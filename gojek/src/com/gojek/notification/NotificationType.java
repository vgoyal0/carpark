package com.gojek.notification;

public enum NotificationType {
	SMS(1), EMAIL(2), PUSH_NOTIFICATION(3);

	private int id;

	NotificationType(int id) {
		this.id = id;
	}

	public static NotificationType getMessageType(int id) {
		for (NotificationType type : NotificationType.values()) {
			if (type.id == id)
				return type;
		}
		return null;
	}
}
