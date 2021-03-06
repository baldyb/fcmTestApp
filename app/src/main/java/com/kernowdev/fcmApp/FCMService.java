package com.kernowdev.fcmApp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Date;

public class FCMService extends FirebaseMessagingService {


    public FCMService() {

    }



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        super.onMessageReceived(remoteMessage);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setSmallIcon(R.drawable.notification)
                .setChannelId("123")
                .build();
        NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
        manager.notify(123, notification);

        // pass back notification details to activity
        sendMessageToActivity(new Date().toString(),remoteMessage.getNotification().getBody());
        Log.d("FCM", "*****onMessageReceived: received a push message!");
    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    private void sendMessageToActivity(String notificationDate, String notificationText) {
        Intent intent = new Intent("NotificationUpdates");;
        Bundle b = new Bundle();
        b.putString("notificationDate", notificationDate);
        b.putString("notificationText", notificationText);

        intent.putExtra("Notification", b);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
