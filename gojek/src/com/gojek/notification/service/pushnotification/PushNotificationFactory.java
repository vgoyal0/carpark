package com.gojek.notification.service.pushnotification;

public class PushNotificationFactory {

	private static Class<?>[] services = { ApplePushNotification.class, AndriodPushNotification.class };
	private static int lastUsedServiceIndex = 0;

	public static PushNotification getPushNotificationService() {

		try {
			return (PushNotification) services[++lastUsedServiceIndex % services.length].newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
