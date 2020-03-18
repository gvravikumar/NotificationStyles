package com.gallihunt.notificationstyles;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    NotificationManager mNotificationManagerCompat;
    Person self;
    NotificationCompat.MessagingStyle messagingStyle;
    NotificationCompat.InboxStyle inboxStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        self = new Person.Builder()
                .setName("Me")
                .setKey("gp")
                .build();

        mNotificationManagerCompat = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("notification_1", "not_chann", NotificationManager.IMPORTANCE_HIGH);
            mNotificationManagerCompat.createNotificationChannel(notificationChannel);
        }

        findViewById(R.id.tv_create_notify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messagingStyle();
            }
        });
        findViewById(R.id.tv_inbox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder1 = new NotificationCompat.Builder(MainActivity.this, "notification_1")
                        .setContentText("messages in group1")
                        .setPriority(NotificationCompat.PRIORITY_LOW)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setGroup("PING")
                        .setStyle(messagingStyle);
                messagingStyle.addMessage("bye... ", new Date().getTime(), new Person.Builder()
                        .setName("ravi ping")
                        .setKey("gp")
                        .build());
                mNotificationManagerCompat.notify(12, builder1.build());
            }
        });
    }

    private void messagingStyle() {
        inboxStyle = new NotificationCompat.InboxStyle()
                .setSummaryText("few messages from chats");
        messagingStyle = new NotificationCompat.MessagingStyle(self);

        //Build and issue the group summary. Use inbox style so that all messages are displayed
        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(MainActivity.this, "notification_1")
                .setContentText("messages in group1")
                .setSubText("Join team")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup("PING")
                .setStyle(messagingStyle);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(MainActivity.this, "notification_1")
                .setSubText("Ping team")
                .setContentText("messages in group2")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup("PING")
                .setStyle(messagingStyle);
        NotificationCompat.Builder builder3 = new NotificationCompat.Builder(MainActivity.this, "notification_1")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup("PING")
                .setStyle(messagingStyle);
        NotificationCompat.Builder summary = new NotificationCompat.Builder(MainActivity.this, "notification_1")
                .setStyle(inboxStyle)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setGroupSummary(true)
                .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup("PING");

        for (int i = 0; i < 1; i++) {
            Person group1 = new Person.Builder()
                    .setName("Group" + i)
                    .setKey("gp" + i)
                    .build();
            messagingStyle.addMessage("hi " + i, new Date().getTime(), group1);
        }
        mNotificationManagerCompat.notify(4, summary.build());
        mNotificationManagerCompat.notify(1, builder1.build());
        SystemClock.sleep(1000);
        mNotificationManagerCompat.notify(2, builder2.build());
        SystemClock.sleep(1000);
        mNotificationManagerCompat.notify(3, builder3.build());
    }
}
