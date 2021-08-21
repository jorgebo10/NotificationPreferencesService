DROP TABLE IF EXISTS notification_preferences;

CREATE TABLE notification_preferences (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_id VARCHAR(250) NOT NULL,
  sms_preference_flag BOOLEAN NOT NULL,
  email_preference_flag BOOLEAN NOT NULL,
  phone_number VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) DEFAULT NULL
);
