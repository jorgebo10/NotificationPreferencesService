package com.manning.application.notification.preferences.services;

import com.manning.application.notification.preferences.entities.NotificationPreferences;
import com.manning.application.notification.preferences.formatters.NotificationPreferencesFormatter;
import com.manning.application.notification.preferences.model.NotificationReq;
import com.manning.application.notification.preferences.model.NotificationRes;
import com.manning.application.notification.preferences.repositories.NotificationPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationPreferenceService {
    private final NotificationPreferenceRepository notificationPreferenceRepository;
    private final NotificationPreferencesFormatter notificationPreferencesFormatter;

    public NotificationRes getNotificationPreferences(NotificationReq notificationReq) {
        NotificationPreferences notificationPreference = notificationPreferenceRepository.findByCustomerId(
                notificationReq.getCustomerId());
        return notificationPreferencesFormatter.formatNotificationResponse(notificationPreference);
    }
}