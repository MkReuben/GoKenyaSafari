package gokenya.safari.com.Safaris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import gokenya.safari.com.R;

public class TanzaniaLuxurySafari extends AppCompatActivity {

    private ImageView call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanzania_luxury_safari);

        call=findViewById(R.id.callus);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254723321938"));
                if (ContextCompat.checkSelfPermission(TanzaniaLuxurySafari.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(TanzaniaLuxurySafari.this, new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else
                {
                    startActivity(intent);
                }

            }
        });
        String [] tanzanialuxurysafaris=getResources().getStringArray(R.array.tanzania_luxury_safari);
        ListView listView=(ListView)findViewById(R.id.tanzania_luxury_safaris);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tanzanialuxurysafaris);
        listView.setAdapter(adapter);
    }
}
