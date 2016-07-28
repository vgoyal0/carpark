package com.gojek.notification.service.email;

import com.gojek.notification.NotificationService;

public class EmailNotificationService implements NotificationService {

	private String authToken;

	public EmailNotificationService(String authToken) {
		this.authToken = authToken;
	}

	@Override
	public void sendNotification(String recepient, String msg) {
		System.out.println("Email sent.");
	}

}
