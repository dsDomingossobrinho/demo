package com.afrikancoders.activityArea.dto;

import com.afrikancoders.state.dto.StateSenderDto;

public record ActivityAreaUpdateDto(
        String activityArea,
        StateSenderDto state
) {
}
