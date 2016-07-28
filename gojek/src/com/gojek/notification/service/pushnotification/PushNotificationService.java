package com.gojek.notification.service.pushnotification;

import com.gojek.notification.NotificationService;

public class PushNotificationService implements NotificationService {

	private String authToken;

	public PushNotificationService(String authToken) {
		this.authToken = authToken;
	}

	@Override
	public void sendNotification(String recepient, String msg) {
		System.out.println("Push notification sent");
		PushNotification service = PushNotificationFactory.getPushNotificationService();
		service.pushNotification(recepient, msg);
	}

}
