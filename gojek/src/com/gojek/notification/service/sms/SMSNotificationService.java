package com.gojek.notification.service.sms;

import com.gojek.notification.NotificationService;

public class SMSNotificationService implements NotificationService {

	private String authToken;

	public SMSNotificationService(String authToken) {
		this.authToken = authToken;
	}

	@Override
	public void sendNotification(String recepient, String msg) {
		System.out.println("SMS Sent");

	}

}
