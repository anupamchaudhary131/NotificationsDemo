package com.example.notificationsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "My Channel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.learnvern, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        // Custom Notification (Line 20, 37-68,79,80,81,92,93 )
        Intent iNotify = new Intent(getApplicationContext(), MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this, REQ_CODE, iNotify, PendingIntent.FLAG_UPDATE_CURRENT);

        // Big Picture Style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(), R.drawable.learnvern, null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image Sent By Raman")
                .setSummaryText("Image Message");


        // Inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("D")
                .addLine("E")
                .addLine("F")
                .addLine("G")
                .addLine("H")
                .addLine("I")
                .addLine("J")
                .addLine("K")
                .addLine("L")
                .addLine("M")
                .addLine("N")
                .addLine("O")
                .setBigContentTitle("Full Message")
                .setSummaryText("Message From Raman");




        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.learnvern)
                    .setContentText("New Message")
                    .setSubText("New Message From Raman")
                    .setAutoCancel(false)
                    .setContentIntent(pi)
                    .setStyle(inboxStyle)
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH));

        }else{
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.learnvern)
                    .setContentText("New Message")
                    .setSubText("New Message From Raman")
                    .setAutoCancel(false)
                    .setStyle(inboxStyle)
                    .build();
        }

        nm.notify(NOTIFICATION_ID, notification);

    }
}