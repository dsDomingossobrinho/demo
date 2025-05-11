package com.afrikancoders.role.dto;

import com.afrikancoders.state.dto.StateSenderDto;

public record RoleUpdateDto(
        String role,
        StateSenderDto state
) {
}
