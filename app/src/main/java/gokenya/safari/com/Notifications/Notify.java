package gokenya.safari.com.Notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gokenya.safari.com.R;
import gokenya.safari.com.Users.MainActivity;

public class Notify extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);


        createNotificationChannel();
//        createNotificationChannel2();
        createNotificationChannel3();
        createNotificationChannel4();

        Button showupdates = findViewById(R.id.button);
        Button showdiscountedsafari = findViewById(R.id.button2);
        Button shownewoffers = findViewById(R.id.button3);
        Button shownewupdates = findViewById(R.id.button4);


        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.rhino);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Mk")
                .setSmallIcon(R.drawable.notifications)
                .setContentTitle("GoKenya Tours & Safaris Latest Updates")
                .setContentText("New Safari has been updated")
                .setLargeIcon(largeIcon)
                .setColor(Color.BLUE)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setSummaryText("www.gokenyasafari.com"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Bitmap large = BitmapFactory.decodeResource(getResources(), R.drawable.rhinoicon);
        final NotificationCompat.Builder build = new NotificationCompat.Builder(this, "Mktwo")
                .setSmallIcon(R.drawable.notifications)
                .setContentTitle("Discounted Rates @GoKenya Tours & Safaris")
                .setContentText("Hurry!!! Book your holiday safari and receive your quote now...")
                .setLargeIcon(large)
                .setColor(Color.BLUE)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setSummaryText("www.gokenyasafari.com"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Bitmap offers = BitmapFactory.decodeResource(getResources(), R.drawable.rhinoicontwo);
        final NotificationCompat.Builder offer = new NotificationCompat.Builder(this, "Mkthree")
                .setSmallIcon(R.drawable.notifications)
                .setContentTitle("New Safari offers")
                .setContentText("Check the new offers that has been updated..")
                .setLargeIcon(offers)
                .setColor(Color.BLUE)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setSummaryText("www.gokenyasafari.com"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.rhinoicon);
        final NotificationCompat.Builder updates = new NotificationCompat.Builder(this, "Mkfour")
                .setSmallIcon(R.drawable.notifications)
                .setContentTitle("New Update")
                .setContentText("Update the latest version of GoKenyaApp to access new features...")
                .setLargeIcon(icon)
                .setColor(Color.BLUE)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setSummaryText("www.gokenyasafari.com"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        final NotificationManagerCompat notification = NotificationManagerCompat.from(this);
        final NotificationManagerCompat safarioffers = NotificationManagerCompat.from(this);
        final NotificationManagerCompat appupdate = NotificationManagerCompat.from(this);

        shownewoffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safarioffers.notify(103, offer.build());
            }
        });

        showdiscountedsafari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification.notify(101, build.build());

            }
        });

        showupdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notificationManager.notify(100, builder.build());

            }
        });
        shownewupdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                appupdate.notify(100, updates.build());

            }
        });


    }

    private void createNotificationChannel4() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "GoKenya Channel";
            String description = "Channel for new updates";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channelfour = new NotificationChannel("Mkfour", name, importance);
            channelfour.setDescription(description);


            Intent resultIntent = new Intent(this, MainActivity.class);


            NotificationManager notification = getSystemService(NotificationManager.class);
            notification.createNotificationChannel(channelfour);
        }
    }

    private void createNotificationChannel3() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "GoKenya Channel";
            String description = "Channel for offers";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channelthree = new NotificationChannel("Mkthree", name, importance);
            channelthree.setDescription(description);


            Intent resultIntent = new Intent(this, MainActivity.class);


            NotificationManager notification = getSystemService(NotificationManager.class);
            notification.createNotificationChannel(channelthree);

        }
    }

//    private void createNotificationChannel2() {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE_1_1) {
//            CharSequence name = "GoKenya Channel";
//            String description = "Channel for discounted";
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channeltwo = new NotificationChannel("Mktwo", name, importance);
//            channeltwo.setDescription(description);
//
//
//            Intent resultIntent = new Intent(this, MainActivity.class);
//
//
//            NotificationManager notification = getSystemService(NotificationManager.class);
//            notification.createNotificationChannel(channeltwo);
//
//        }

    private void createNotificationChannel() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "GoKenya Channel";
            String descriptiom = "Channel for updates";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Mk", name, importance);
            channel.setDescription(descriptiom);


            Intent resultIntent = new Intent(this, MainActivity.class);


            NotificationManager notification = getSystemService(NotificationManager.class);
            notification.createNotificationChannel(channel);

        }


    }
}