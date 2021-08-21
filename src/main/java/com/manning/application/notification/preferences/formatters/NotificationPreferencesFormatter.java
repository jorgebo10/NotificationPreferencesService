package com.manning.application.notification.preferences.formatters;

import com.manning.application.notification.preferences.entities.NotificationPreferences;
import com.manning.application.notification.preferences.model.NotificationRes;
import org.springframework.stereotype.Component;

@Component
public final class NotificationPreferencesFormatter {

    public NotificationRes formatNotificationResponse(NotificationPreferences notificationPreference) {
        System.out.println(notificationPreference.getCustomerId());
        NotificationRes notificationRes = new NotificationRes();
        if (existsNotificationPreference(notificationPreference)) {
            populateSuccessNotificationResponse(notificationPreference, notificationRes);
        } else {
            populateErrorNotificationResponse(notificationRes);
        }
        return notificationRes;
    }

    private void populateErrorNotificationResponse(NotificationRes notificationRes) {
        notificationRes.setStatus("ERROR");
        notificationRes.setStatusDescription("Notification Failed");
    }

    private void populateSuccessNotificationResponse(NotificationPreferences notificationPreference, NotificationRes notificationRes) {
        notificationRes.setEmailPreferenceFlag(notificationPreference.isEmailPreferenceFlag());
        notificationRes.setSmsPreferenceFlag(notificationPreference.isSmsPreferenceFlag());
        notificationRes.setEmailAddress(notificationPreference.getEmailAddress());
        notificationRes.setPhoneNumber(notificationPreference.getPhoneNumber());
        notificationRes.setStatus("SUCCESS");
        notificationRes.setStatusDescription("Notification Received Successfully");
    }

    private boolean existsNotificationPreference(NotificationPreferences notificationPreference) {
        return notificationPreference != null && notificationPreference.getId() != null;
    }
}