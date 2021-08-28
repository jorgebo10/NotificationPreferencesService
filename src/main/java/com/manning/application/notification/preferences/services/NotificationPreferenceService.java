package com.manning.application.notification.preferences.services;

import com.manning.application.notification.preferences.entities.NotificationPreferences;
import com.manning.application.notification.preferences.formatters.NotificationPreferencesFormatter;
import com.manning.application.notification.preferences.model.NotificationPreferenceReq;
import com.manning.application.notification.preferences.model.NotificationPreferenceRsp;
import com.manning.application.notification.preferences.repositories.NotificationPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationPreferenceService {
    private final NotificationPreferenceRepository notificationPreferenceRepository;
    private final NotificationPreferencesFormatter notificationPreferencesFormatter;

    public NotificationPreferenceRsp getNotificationPreferences(NotificationPreferenceReq notificationPreferenceReq) {
        NotificationPreferences notificationPreference = notificationPreferenceRepository.findByCustomerId(
                notificationPreferenceReq.getCustomerId());
        return notificationPreferencesFormatter.formatNotificationResponse(notificationPreference);
    }
}