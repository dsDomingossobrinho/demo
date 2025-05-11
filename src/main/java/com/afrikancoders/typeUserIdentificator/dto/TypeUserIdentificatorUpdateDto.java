package com.afrikancoders.typeUserIdentificator.dto;

import com.afrikancoders.state.dto.StateSenderDto;

public record TypeUserIdentificatorUpdateDto(
        String type,
        StateSenderDto state
) {
}
