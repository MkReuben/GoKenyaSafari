package gokenya.safari.com.TopTourSafaris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import gokenya.safari.com.LakeNakuruTopTour.DetailedItineraryNakuru;
import gokenya.safari.com.LakeNakuruTopTour.HighlightsNakuru;
import gokenya.safari.com.LakeNakuruTopTour.PackageDetailsNakuru;
import gokenya.safari.com.LakeNakuruTopTour.PriceNakuru;
import gokenya.safari.com.MasaiMaraTopTour.DetailedItinerary;
import gokenya.safari.com.MasaiMaraTopTour.Highlights;
import gokenya.safari.com.MasaiMaraTopTour.PackageDetails;
import gokenya.safari.com.MasaiMaraTopTour.Price;
import gokenya.safari.com.R;

public class LakeNakuru extends AppCompatActivity {

    String items[]=new String[]{"Detailed Itinerary","Highlights","Package Details","Price","Inquiry"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lake_nakuru);


        final ListView listView = (ListView) findViewById(R.id.lake_nakuru);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LakeNakuru.this, items[position], Toast.LENGTH_SHORT).show();

                if (position == 0) {
                    //code specific to first list item
                    Intent myIntent = new Intent(view.getContext(), DetailedItineraryNakuru.class);
                    startActivityForResult(myIntent, 0);


                }else
                if (position == 1) {

                    Intent myIntent = new Intent(view.getContext(), HighlightsNakuru.class);
                    startActivityForResult(myIntent, 0);


                }else  if (position == 2) {

                    Intent myIntent = new Intent(view.getContext(), PackageDetailsNakuru.class);
                    startActivityForResult(myIntent, 0);


                }else  if (position == 3) {

                    Intent myIntent = new Intent(view.getContext(), PriceNakuru.class);
                    startActivityForResult(myIntent, 0);


                }else  if (position == 4) {



                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","info@gokenyasafari.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Lake Nakuru-Masai Mara Inquiry");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Please include your contact details");
                    startActivity(Intent.createChooser(emailIntent, ""));



                }
            }


        });


    }
}

