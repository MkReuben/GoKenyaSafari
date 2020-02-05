package gokenya.safari.com.Users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

import gokenya.safari.com.Adapter.CustomAdapter;
import gokenya.safari.com.R;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // ArrayList for person names
        ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Tanzania Safaris", "Kenya Safari & Beach", "Discover Kenya Safaris", "Departing Mombasa End Nairobi", "Business Travel Packages", "Person 6", "Person 7", "Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"));
//        ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.lion, R.drawable.maasaimara, R.drawable.nax, R.drawable.masaimaratourist, R.drawable.mombasaday, R.drawable.one, R.drawable.ostrich, R.drawable.rhino, R.drawable.safari, R.drawable.sarova, R.drawable.sarovahotel, R.drawable.serene, R.drawable.serenehotel, R.drawable.swimming,R.drawable.tanzania,R.drawable.tanzanialuxury,R.drawable.van,R.drawable.vantwo,R.drawable.warthog,R.drawable.bird,R.drawable.birdstwo));



        ArrayList<Integer>personImages=new ArrayList<>(Arrays.asList(R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten,R.drawable.eleven,R.drawable.twelve,R.drawable.nax,R.drawable.lion,R.drawable.vantwo,R.drawable.maasaimara,R.drawable.van,R.drawable.discoverkenya,R.drawable.msatwo,R.drawable.bg));

            // get the reference of RecyclerView
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            // set a GridLayoutManager with 2 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 4, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
            //  call the constructor of CustomAdapter to send the reference and data to Adapter
            CustomAdapter customAdapter = new CustomAdapter(Gallery.this, personNames, personImages);
            recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


            ;


        }
    }


