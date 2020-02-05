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

public class MombasaRoadSafaris extends AppCompatActivity {

    private ImageView call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mombasa_road_safaris);

        call=findViewById(R.id.callus);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254723321938"));
                if (ContextCompat.checkSelfPermission(MombasaRoadSafaris.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MombasaRoadSafaris.this, new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else
                {
                    startActivity(intent);
                }

            }
        });

        String [] mombasaroadsafaris=getResources().getStringArray(R.array.mombasa_road_safaris);
        ListView listView=(ListView)findViewById(R.id.mombasa_road_safaris);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mombasaroadsafaris);
        listView.setAdapter(adapter);

    }
}
