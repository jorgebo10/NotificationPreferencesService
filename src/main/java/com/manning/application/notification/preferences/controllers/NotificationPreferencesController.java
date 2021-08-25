package com.manning.application.notification.preferences.controllers;

import com.manning.application.notification.preferences.model.NotificationReq;
import com.manning.application.notification.preferences.model.NotificationRes;
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
    public NotificationRes create(@RequestBody @Valid NotificationReq createNotificationRes) {
        return notificationPreferenceService.getNotificationPreferences(createNotificationRes);
    }

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "UP";
    }
}
