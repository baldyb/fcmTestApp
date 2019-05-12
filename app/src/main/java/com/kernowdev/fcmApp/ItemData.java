package com.kernowdev.fcmApp;

public class ItemData {
    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    private String notificationDate;
    private String notificationText;


    public ItemData(String notificationDate, String notificationText) {
        this.notificationDate = notificationDate;
        this.notificationText = notificationText;
    }
}