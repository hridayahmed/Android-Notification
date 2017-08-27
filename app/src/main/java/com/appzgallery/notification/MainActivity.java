package com.appzgallery.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification ;
    private static final int uniqueId = 23456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void btnclick(View view){
        notification.setSmallIcon(R.drawable.notification);
        notification.setTicker("THis is some text");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("This is Content Title");
        notification.setContentText("Yeah i am the right text that you want to know");

        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueId,notification.build());
    }
}
