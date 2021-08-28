package com.manning.application.notification.preferences.controllers;

import com.manning.application.notification.preferences.model.NotificationPreferenceReq;
import com.manning.application.notification.preferences.model.NotificationPreferenceRsp;
import com.manning.application.notification.preferences.services.NotificationPreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/notifications/preferences")
@RequiredArgsConstructor
public class NotificationPreferencesController {
    private final NotificationPreferenceService notificationPreferenceService;

    @PostMapping
    public NotificationPreferenceRsp get(@RequestBody @Valid NotificationPreferenceReq createNotificationReq) {
        return notificationPreferenceService.getNotificationPreferences(createNotificationReq);
    }

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "UP";
    }
}
