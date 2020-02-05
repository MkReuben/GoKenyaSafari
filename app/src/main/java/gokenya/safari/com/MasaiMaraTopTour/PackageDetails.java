package gokenya.safari.com.MasaiMaraTopTour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import gokenya.safari.com.R;

public class PackageDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);

//        String [] packagedetails=getResources().getStringArray(R.array.package_includes);
//        ListView listView=(ListView)findViewById(R.id.list_packages);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,packagedetails);
//        listView.setAdapter(adapter);
//
//        String [] thingsnotincluded=getResources().getStringArray(R.array.things_not_includes);
//        ListView list=(ListView)findViewById(R.id.things_not_included);
//        ArrayAdapter<String> adapters=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,thingsnotincluded);
//        list.setAdapter(adapters);
    }
}
