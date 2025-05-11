package com.afrikancoders.activityArea.service;

import java.util.List;

import com.afrikancoders.activityArea.dto.ActivityAreaDto;
import com.afrikancoders.activityArea.entity.ActivityAreas;
import com.afrikancoders.activityArea.response.ActivityAreaResponse;

public interface ActivityAreaService {

    ActivityAreaResponse saveActivityArea(ActivityAreaDto activityAreaDto);

    ActivityAreaResponse updateActivityArea(Long id, ActivityAreaDto activityAreaDto);

    void deleteActivityArea(Long id);    

    List<ActivityAreaResponse> getAllActivityAreas();

    ActivityAreas getActivityAreaById(Long id);

    ActivityAreaResponse getActivityAreaByIdResponse(Long id);

    ActivityAreas getActivityAreaByactivityArea(String activityArea);
    
}
