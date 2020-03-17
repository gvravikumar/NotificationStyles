package com.gallihunt.notificationstyles;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.app.TaskStackBuilder;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    final String someLongText = "fkdljfdldkfj;ldaksjfkladj;flja;lkjdfljadslfjaddfdsfafjdfad" +
            "fdl;akjf;lkdf;lkaj;flkjda;lkfjadljflk;adsjfladjflk;dfjlkdjflakdfjdaffjdlfjdjjj" +
            "adjflkjadlkfjad;lkfjad;sljf;ladkjajlkfjad;lksfjl;akdjf;lkdsajf;lkdjfkadj;flkad" +
            "jf;lkadjfkldas;lkfja;dljf;lkdasjf;lkadjs;lfjas;ldkfj;lkadsjfl;kadljfl;kasdjf;l" +
            "jdlskfjklda;fjadslkfj;sdalkfj;ladjf;lajdl;fkajld;kfjlajfl;adjfl;kajdl;fjadl;kfj;";
    NotificationManager mNotificationManagerCompat;
    Person self;

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
    }

    private void messagingStyle() {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();

//        NotificationCompat.Builder inboxBuilder = new NotificationCompat.Builder(MainActivity.this, "notification_1")
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("inboxTitle")
//                .setContentText("inboxText")
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .setGroup("PING")
//                .setGroupSummary(true)
//                .setStyle(inboxStyle);
//        NotificationCompat.Builder messagingBuilder = new NotificationCompat.Builder(MainActivity.this, "notification_1")
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("messagingTitle")
//                .setContentText("messagingText")
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .setGroup("PING")
//                .setGroupSummary(true)
//                .setStyle(messagingStyle);
//        NotificationCompat.Builder bigTextBuilder = new NotificationCompat.Builder(MainActivity.this, "notification_1")
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("bigTextTitle")
//                .setContentText("bigTextText")
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .setGroup("PING")
//                .setGroupSummary(true)
//                .setStyle(bigTextStyle);
//        NotificationCompat.Builder bigPictureBuilder = new NotificationCompat.Builder(MainActivity.this, "notification_1")
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("bigTextTitle")
//                .setContentText("bigTextText")
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .setGroup("PING")
//                .setGroupSummary(true)
//                .setStyle(bigPictureStyle);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(self);

        //Build and issue the group summary. Use inbox style so that all messages are displayed
        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(MainActivity.this, "notification_1")
                .setContentText("messages in group1")
                .setSubText("Join team")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup("PING")
                .setStyle(messagingStyle);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(MainActivity.this, "notification_1")
                .setSubText("Ping team")
                .setContentText("messages in group2")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup("PING")
                .setStyle(messagingStyle);
        NotificationCompat.Builder builder3 = new NotificationCompat.Builder(MainActivity.this, "notification_1")
                .setSubText("Telebu team")
                .setContentText("messages in group2")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup("PING")
                .setStyle(messagingStyle);
        NotificationCompat.Builder summary = new NotificationCompat.Builder(MainActivity.this, "notification_1")
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("first line")
                        .addLine("second line")
                        .setBigContentTitle("few messages")
                        .setSummaryText("2 messages from 4 chats"))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroupSummary(true)
                .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup("PING");
        mNotificationManagerCompat.notify(4, summary.build());

        for (int i = 0; i < 5; i++) {
            Person group1 = new Person.Builder()
                    .setName("Group" + i)
                    .setKey("gp" + i)
                    .build();
            messagingStyle.addMessage("hi " + i, new Date().getTime(), group1);
            messagingStyle.addMessage("hii " + i, new Date().getTime(), group1);
        }
        mNotificationManagerCompat.notify(1, builder1.build());
        SystemClock.sleep(1000);
        mNotificationManagerCompat.notify(2, builder2.build());
        mNotificationManagerCompat.notify(4, summary.build());
//        SystemClock.sleep(2500);
//        mNotificationManagerCompat.notify(3, builder3.build());
    }
}
