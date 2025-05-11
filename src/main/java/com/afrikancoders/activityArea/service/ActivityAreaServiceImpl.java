package com.afrikancoders.activityArea.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afrikancoders.activityArea.dto.ActivityAreaDto;
import com.afrikancoders.activityArea.entity.ActivityAreas;
import com.afrikancoders.activityArea.repository.ActivityAreaRepository;
import com.afrikancoders.activityArea.response.ActivityAreaResponse;
import com.afrikancoders.state.service.StatusService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityAreaServiceImpl implements ActivityAreaService {

    private final ActivityAreaRepository activityAreaRepository;

    private final StatusService statusService;

    /*@PostConstruct
    public void migration() {
        if (activityAreaRepository.count() == 0) {
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
                activityAreas activityArea = new activityAreas();
                activityArea.setactivityArea(array[i]);
                activityAreaRepository.save(activityArea);
            }
        }
    }*/

    @Override
    public ActivityAreaResponse saveActivityArea(ActivityAreaDto activityAreaDto) {
        ActivityAreas activityArea = new ActivityAreas();
        activityArea.setActivityArea(activityAreaDto.activityArea());
        activityArea.setState(statusService.getStateById(1L));
        activityAreaRepository.save(activityArea);
        return new ActivityAreaResponse(activityArea.getId(),activityArea.getActivityArea());
    }

    @Override
    public ActivityAreaResponse updateActivityArea(Long id, ActivityAreaDto activityAreaDto) {
        ActivityAreas activityArea = this.getActivityAreaById(id);
        activityArea.setActivityArea(activityAreaDto.activityArea());
        activityAreaRepository.save(activityArea);
        return new ActivityAreaResponse(activityArea.getId(), activityArea.getActivityArea());
    }

    @Override
    public List<ActivityAreaResponse> getAllActivityAreas() {
        return activityAreaRepository.findAllResponse();
    }

    @Override
    public ActivityAreas getActivityAreaById(Long id) {
        return activityAreaRepository.findByIdAndStateId(id, 1L)
            .orElseThrow(() -> new EntityNotFoundException("ActivityAreas with ID " + id + " not found."));
    }

    @Override
    public ActivityAreas getActivityAreaByactivityArea(String activityArea) {
        return activityAreaRepository.findByActivityArea(activityArea)
        .orElseThrow(() -> new EntityNotFoundException("ActivityAreas " + activityArea + " not found."));
    }

    @Override
    public ActivityAreaResponse getActivityAreaByIdResponse(Long id) {
        ActivityAreas activityArea = this.getActivityAreaById(id);
        return new ActivityAreaResponse(activityArea.getId(), activityArea.getActivityArea());
    }

    
    @Override
    public void deleteActivityArea(Long id) {
        ActivityAreas activityArea = this.getActivityAreaById(id);
        activityArea.setState(statusService.getStateById(3L));
        activityAreaRepository.save(activityArea);
    }
    
}
