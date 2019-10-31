package com.ramadan.ramadanalert;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

class iftar extends BroadcastReceiver {
    private static final CharSequence NOTIFICATION_CHANNEL_NAME = "Mychannel";
    MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {


        final String NOTIFICATION_CHANNEL_ID = "4655";

//Notification Channel
        CharSequence channelName = NOTIFICATION_CHANNEL_NAME;
        int importance = NotificationManager.IMPORTANCE_LOW;
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, importance);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

        MediaPlayer mediaPlayer = MediaPlayer.create(context,Settings.System.DEFAULT_ALARM_ALERT_URI);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);


        Intent repeating_intent = new Intent(context,repeating_activity2.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews contentView;
        final NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.arrow_down_float)
                .setContentTitle("Iftar")
                .setContentText("Few minutes left for iftar. Be ready!")
                .setAutoCancel(true);

        notificationManager.notify(100,builder.build());
        mediaPlayer.start();




    }
}
