package gokenya.safari.com.MasaiMaraTopTour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import gokenya.safari.com.R;

public class Highlights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlights);


        String [] hihlights=getResources().getStringArray(R.array.highlights_masai_mara);
        ListView listView=(ListView)findViewById(R.id.list_highlights);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,hihlights);
        listView.setAdapter(adapter);
    }
}
