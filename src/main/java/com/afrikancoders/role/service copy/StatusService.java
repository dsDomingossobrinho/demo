package com.afrikancoders.state.service;

import java.util.List;

import com.afrikancoders.state.dto.StateDto;
import com.afrikancoders.state.entity.Status;
import com.afrikancoders.state.response.StateResponse;

public interface StatusService {

    StateResponse saveState(StateDto stateDto);

    StateResponse updateState(Long id, StateDto stateDto);

    List<StateResponse> getAllStates();

    Status getStateById(Long id);

    StateResponse getStateByIdResponse(Long id);

    Status getStateByState(String state);
    
}
