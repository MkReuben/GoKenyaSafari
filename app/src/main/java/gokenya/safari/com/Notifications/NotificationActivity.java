package gokenya.safari.com.Notifications;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import gokenya.safari.com.R;

import static gokenya.safari.com.Notifications.App.CHANNEL_1_ID;
import static gokenya.safari.com.Notifications.App.CHANNEL_2_ID;

//Not active as per now
public class NotificationActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle,editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        notificationManager=NotificationManagerCompat.from(this);

        editTextTitle=findViewById(R.id.edit_text_title);
        editTextMessage=findViewById(R.id.edit_text_message);

    }

    public  void sendOnChannel1(View v)
    {

        String title=editTextTitle.getText().toString();
        String message=editTextMessage.getText().toString();

        Intent activityIntent=new Intent(this, NotificationActivity.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,
                0,activityIntent,0);

        Intent broadcastIntent=new Intent(this,NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage",message);

        PendingIntent actionIntent=PendingIntent.getBroadcast(this,
                0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);


        Bitmap largeIcon= BitmapFactory.decodeResource(getResources(),R.drawable.rhinoicontwo);
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(Color.BLUE)
                .setLargeIcon(largeIcon)
                .setStyle( new NotificationCompat.BigTextStyle()
                        .bigText(message)
                        .setBigContentTitle(title)
                        .setSummaryText("www.gokenyasafari.com"))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
//                .addAction(R.mipmap.ic_launcher,"Toast",actionIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        notificationManager.notify(1,notification);


    }

    public  void sendOnChannel2(View v)
    {
        String title=editTextTitle.getText().toString();
        String message=editTextMessage.getText().toString();


        Bitmap largeIcon=BitmapFactory.decodeResource(getResources(),R.drawable.rhinoicon);
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle(title)
                .setLargeIcon(largeIcon)
                .setContentText(message)
                .setColor(Color.BLUE)
                .setStyle( new NotificationCompat.BigTextStyle()
                        .bigText(message)
                        .setBigContentTitle(title)
                        .setSummaryText("www.gokenyasafari.com"))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_EVENT)
                .setAutoCancel(true)
                .build();

        notificationManager.notify(2,notification);
    }
}
