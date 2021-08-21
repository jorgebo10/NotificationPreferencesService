package com.manning.application.notification.preferences.repositories;

import com.manning.application.notification.preferences.entities.NotificationPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationPreferenceRepository extends JpaRepository<NotificationPreferences, Long> {

    NotificationPreferences findByCustomerId(String customerId);
}
