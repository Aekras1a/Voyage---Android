package com.cet.thabjeel.traveller.network.model;

/**
 * Created by droidcafe on 5/6/2017.
 */

public class NotificationModel {

    public String to_id, from_id;
    public boolean isNotify, isData;
    public Notification notification;

    public NotificationModel() {

    }

    public NotificationModel(String title, String to_id, String from_id) {
        this.to_id = to_id;
        this.from_id = from_id;
        notification = new Notification();
        notification.title = title;
        notification.body = title;
        isNotify = true;
        isData = false;
    }

    static class Notification {
        public Notification() {

        }

        public String title;
        public String body;
    }
}
