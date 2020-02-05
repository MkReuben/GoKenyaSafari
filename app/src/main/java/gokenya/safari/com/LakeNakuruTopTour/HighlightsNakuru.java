package gokenya.safari.com.LakeNakuruTopTour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import gokenya.safari.com.R;

public class HighlightsNakuru extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlights_nakuru);


        String [] nakurusafari=getResources().getStringArray(R.array.highlights_lake_nakuru_masai_mara);
        ListView listView=(ListView)findViewById(R.id.list_nakuru_highlights);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nakurusafari);
        listView.setAdapter(adapter);
    }
}
