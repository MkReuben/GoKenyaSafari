package gokenya.safari.com.Admins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import gokenya.safari.com.Notifications.NotificationActivity;
import gokenya.safari.com.Notifications.Notify;
import gokenya.safari.com.Users.HomeActivity;
import gokenya.safari.com.R;

public class AdminHomeActivity extends AppCompatActivity {
    private TextView addnew,maintain,logout,notifications;
    private ImageView imgaddnew,imgmaintain,imglogout,imgnotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        maintain=findViewById(R.id.tv_maintain);
        addnew=findViewById(R.id.tv_add_new);
        logout=findViewById(R.id.tv_logout_admin);
        notifications=findViewById(R.id.tv_send_notification);


        imgaddnew=findViewById(R.id.add_new_image);
        imgmaintain=findViewById(R.id.maintain_image);
        imglogout=findViewById(R.id.logout_admin);
        imgnotifications=findViewById(R.id.send_notification);


        imgnotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminHomeActivity.this, Notify.class);
                startActivity(intent);
            }
        });
        imgaddnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent =new Intent(AdminHomeActivity.this, AddNewSafariActivity.class);
                startActivity(intent);
            }
        });
        imgmaintain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent=new Intent(AdminHomeActivity.this, HomeActivity.class);
                intent.putExtra("Admins","Admins");
                startActivity(intent);
            }
        });
        imglogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AdminHomeActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

            }
        });

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminHomeActivity.this, Notify.class);
                startActivity(intent);

            }
        });



        maintain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AdminHomeActivity.this, HomeActivity.class);
                intent.putExtra("Admins","Admins");
                startActivity(intent);
            }
        });
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminHomeActivity.this, AddNewSafariActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AdminHomeActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

    }
}
