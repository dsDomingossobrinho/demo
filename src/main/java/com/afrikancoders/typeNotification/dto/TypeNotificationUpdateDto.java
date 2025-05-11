package com.afrikancoders.typeNotification.dto;

import com.afrikancoders.state.dto.StateSenderDto;

public record TypeNotificationUpdateDto(
        String type,
        StateSenderDto state
) {
}
