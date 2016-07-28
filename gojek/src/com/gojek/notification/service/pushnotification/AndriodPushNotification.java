package com.gojek.notification.service.pushnotification;

public class AndriodPushNotification implements PushNotification {

	@Override
	public void pushNotification(String recepient, String message) {
		System.out.println("Sent using andriod cloud");
	}

}
