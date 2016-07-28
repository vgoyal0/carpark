package com.gojek.notification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotificationClient {
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		while ((input = reader.readLine()) != null) {

			if (input.equalsIgnoreCase("exit")) {
				break;
			}

			String[] arrguments = input.split(" ");
			String type = arrguments[0];
			String recipient = arrguments[1];
			String msg = arrguments[2];
			String authToken = arrguments[3];

			NotificationService notification = NotificationServiceFactory
					.getNotificationSender(NotificationType.getMessageType(Integer.parseInt(type)), authToken);

			notification.sendNotification(recipient, msg);
		}
	}
}
