package com.gojek.notification;

import com.gojek.notification.service.email.EmailNotificationService;
import com.gojek.notification.service.pushnotification.PushNotificationService;
import com.gojek.notification.service.sms.SMSNotificationService;

public class NotificationServiceFactory {
	public static NotificationService getNotificationSender(NotificationType msgType, String authToken) {
		switch (msgType) {
		case SMS:
			return new SMSNotificationService(authToken);
		case EMAIL:
			return new EmailNotificationService(authToken);
		case PUSH_NOTIFICATION:
			return new PushNotificationService(authToken);
		}

		return null;
	}
}
