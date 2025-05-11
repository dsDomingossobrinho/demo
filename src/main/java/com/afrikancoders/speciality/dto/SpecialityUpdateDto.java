package com.afrikancoders.speciality.dto;

import com.afrikancoders.state.dto.StateSenderDto;

public record SpecialityUpdateDto(
        String speciality,
        StateSenderDto state
) {
}
