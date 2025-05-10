package com.afrikancoders.ability.dto;

import com.afrikancoders.state.dto.StateSenderDto;

public record AbilityUpdateDto(
        String ability,
        StateSenderDto state
) {
}
