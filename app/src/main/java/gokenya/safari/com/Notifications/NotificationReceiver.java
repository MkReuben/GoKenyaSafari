package gokenya.safari.com.Notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
//Not active as per now
public class NotificationReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String message =intent.getStringExtra("toastMessage");
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }
}
