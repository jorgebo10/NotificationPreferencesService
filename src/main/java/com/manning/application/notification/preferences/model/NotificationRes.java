package com.manning.application.notification.preferences.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class NotificationRes {
    private String status;
    private String statusDescription;
    private Boolean smsPreferenceFlag;
    private Boolean emailPreferenceFlag;
    private String emailAddress;
    private String phoneNumber;
}
