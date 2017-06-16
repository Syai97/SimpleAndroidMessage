package test.message;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Syaiful Fikri on 13/6/2017.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    SharedPreferences message;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        showNotification(remoteMessage.getData().get("message"));
        message = getSharedPreferences("Message", Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = message.edit();

        edit.putString("MessageText",remoteMessage.getData().get("message"));

        edit.apply();

    }

    private void showNotification(String message) {
        Intent i = new Intent(this, displayMessage.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        int id = (int) System.currentTimeMillis();

        PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), i,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Test Message")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentIntent(pendingIntent)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        manager.notify(id,builder.build());
    }
}
