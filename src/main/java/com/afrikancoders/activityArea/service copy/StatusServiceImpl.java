package com.afrikancoders.state.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afrikancoders.state.dto.StateDto;
import com.afrikancoders.state.entity.Status;
import com.afrikancoders.state.repository.StatusRepository;
import com.afrikancoders.state.response.StateResponse;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final StatusRepository stateRepository;

    @PostConstruct
    public void migration() {
        if (stateRepository.count() == 0) {
            String[] array = {
                "active",
                "inactive",
                "eliminated",
                "pending",
                "rejected",
                "updated",
                "expired",
                "renewed"
            };

            for (int i = 0; i < array.length; i++) {
                Status state = new Status();
                state.setState(array[i]);
                stateRepository.save(state);
            }
        }
    }

    @Override
    public StateResponse saveState(StateDto stateDto) {
        Status state = new Status();
        state.setState(stateDto.state());
        stateRepository.save(state);
        return new StateResponse(state.getId(), state.getState());
    }

    @Override
    public StateResponse updateState(Long id, StateDto stateDto) {
        Status state = this.getStateById(id);
        state.setState(stateDto.state());
        stateRepository.save(state);
        return new StateResponse(state.getId(), state.getState());
    }

    @Override
    public List<StateResponse> getAllStates() {
        return stateRepository.findAllResponse();
    }

    @Override
    public Status getStateById(Long id) {
        return stateRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Status with ID " + id + " not found."));
    }

    @Override
    public Status getStateByState(String state) {
        return stateRepository.findByState(state)
        .orElseThrow(() -> new EntityNotFoundException("Status " + state + " not found."));
    }

    @Override
    public StateResponse getStateByIdResponse(Long id) {
        Status state = this.getStateById(id);
        return new StateResponse(state.getId(), state.getState());
    }
    
}
