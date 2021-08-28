package com.manning.application.notification.preferences.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public final class NotificationPreferenceReq {
    @NotEmpty
    private String customerId;
}
