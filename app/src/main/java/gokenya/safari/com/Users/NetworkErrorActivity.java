package gokenya.safari.com.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gokenya.safari.com.R;

public class NetworkErrorActivity extends AppCompatActivity {

    private Button tryagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_error);

        tryagain=findViewById(R.id.try_btn);


        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(NetworkErrorActivity.this,NetworkErrorActivity.class);
                startActivity(intent);

            }
        });
    }
}
