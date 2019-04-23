package com.lentimosystems.licio.androidnotifications2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "lentimo_systems";
    private static final String CHANNEL_NAME = "Lentimo Systems";
    private static final String CHANNEL_DESC = "Lentimo Systems Notifications";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        findViewById(R.id.btnNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
    }

    private void displayNotification(){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                                    .setSmallIcon(R.drawable.ic_chat_bubble_outline_black_24dp)
                                    .setContentTitle("Notification Title")
                                    .setContentText("THis is a notification")
                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(1,mBuilder.build());
    }
}
