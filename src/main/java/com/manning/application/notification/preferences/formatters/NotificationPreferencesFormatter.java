package com.manning.application.notification.preferences.formatters;

import com.manning.application.notification.preferences.entities.NotificationPreferences;
import com.manning.application.notification.preferences.model.NotificationPreferenceRsp;
import org.springframework.stereotype.Component;

@Component
public final class NotificationPreferencesFormatter {

    public NotificationPreferenceRsp formatNotificationResponse(NotificationPreferences notificationPreference) {
        System.out.println(notificationPreference.getCustomerId());
        NotificationPreferenceRsp notificationPreferenceRsp = new NotificationPreferenceRsp();
        if (existsNotificationPreference(notificationPreference)) {
            populateSuccessNotificationResponse(notificationPreference, notificationPreferenceRsp);
        } else {
            populateErrorNotificationResponse(notificationPreferenceRsp);
        }
        return notificationPreferenceRsp;
    }

    private void populateErrorNotificationResponse(NotificationPreferenceRsp notificationPreferenceRsp) {
        notificationPreferenceRsp.setStatus("ERROR");
        notificationPreferenceRsp.setStatusDescription("Notification Failed");
    }

    private void populateSuccessNotificationResponse(NotificationPreferences notificationPreference, NotificationPreferenceRsp notificationPreferenceRsp) {
        notificationPreferenceRsp.setEmailPreferenceFlag(notificationPreference.isEmailPreferenceFlag());
        notificationPreferenceRsp.setSmsPreferenceFlag(notificationPreference.isSmsPreferenceFlag());
        notificationPreferenceRsp.setEmailAddress(notificationPreference.getEmailAddress());
        notificationPreferenceRsp.setPhoneNumber(notificationPreference.getPhoneNumber());
        notificationPreferenceRsp.setStatus("SUCCESS");
        notificationPreferenceRsp.setStatusDescription("Notification Received Successfully");
    }

    private boolean existsNotificationPreference(NotificationPreferences notificationPreference) {
        return notificationPreference != null && notificationPreference.getId() != null;
    }
}