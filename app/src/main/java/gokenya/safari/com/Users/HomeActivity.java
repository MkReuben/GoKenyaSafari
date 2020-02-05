package gokenya.safari.com.Users;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import gokenya.safari.com.Admins.AdminMaintainActivity;
import gokenya.safari.com.Admins.LoginActivity;
import gokenya.safari.com.Model.Safaris;
import gokenya.safari.com.R;
import gokenya.safari.com.ViewHolder.Safariviewholder;
import gokenya.safari.com.ui.home.HomeFragment;

public class HomeActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        private DatabaseReference SafariRef;
        private TextView userNameTextView;
        private String type ="";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            Intent intent=getIntent();
            Bundle bundle=intent.getExtras();
            if (bundle!=null)
            {
                type=getIntent().getExtras().get("Admins").toString();
            }

            // userNameTextView=(TextView)findViewById(R.id.user_profile_image);


            HomeFragment homeFragment=new HomeFragment();
//        AccountFragment accountFragment=new AccountFragment();
//        LogoutFragment logoutFragment =new LogoutFragment();
//        SearchFragment searchFragment =new SearchFragment();


            SafariRef= FirebaseDatabase.getInstance().getReference().child("Packages");
            SafariRef.keepSynced(true);



            recyclerView=findViewById(R.id.recycler_safari);
            recyclerView.setHasFixedSize(true);
            layoutManager=new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);


            BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);

            bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_con,
                    new HomeFragment()).commit();





        }





        @Override
        protected void onStart()
        {
            super.onStart();


            FirebaseRecyclerOptions<Safaris> options=
                    new FirebaseRecyclerOptions.Builder<Safaris>()
                            .setQuery(SafariRef,Safaris.class)
                            .build();


            FirebaseRecyclerAdapter<Safaris, Safariviewholder> adapter=
                    new FirebaseRecyclerAdapter<Safaris, Safariviewholder>(options) {
                        @Override
                        protected void onBindViewHolder(@NonNull Safariviewholder safariviewholder, int i, @NonNull final Safaris safaris)
                        {
                            Safariviewholder.SafariName.setText(safaris.getName());
                            Safariviewholder.SafariDescription.setText(safaris.getDescription());
                            Safariviewholder.SafariPrice.setText("Price " +" USD "+safaris.getPrice());

                            Picasso.get().load(safaris.getImage()).into( safariviewholder.imageView);




                            FloatingActionButton fab = findViewById(R.id.fab);
                            fab.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view)
                                {


                                    if (!type.equals("Admin"))
                                    {
                                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254723321938"));
                                        if (ContextCompat.checkSelfPermission(HomeActivity.this,
                                                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                            ActivityCompat.requestPermissions(HomeActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                                        }
                                        else
                                        {
                                            startActivity(intent);
                                        }

                                    }
                                    }


                            });

                            safariviewholder.itemView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v)
                                {
                                    if (type.equals("Admins"))
                                    {

                                        Intent intent= new Intent(HomeActivity.this, AdminMaintainActivity.class);
                                        intent.putExtra("sid",safaris.getSid());
                                        startActivity(intent);

                                    }
                                    else
                                    {
                                        Intent intent=new Intent(HomeActivity.this, SafariDetailsActivity.class);
                                        intent.putExtra("sid",safaris.getSid());
                                        startActivity(intent);
                                    }

                                }
                            });
                        }

                        @NonNull
                        @Override
                        public Safariviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
                        {
                            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.safari_item_layout,parent,false);
                            Safariviewholder holder=new Safariviewholder(view);
                            return holder;
                        }
                    };
            recyclerView.setAdapter(adapter);
            adapter.startListening();
            super.onStart();
        }

        private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment selectedFragment=null;


                        switch (menuItem.getItemId()) {
                            case R.id.navigation_home:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.navigation_admin:
                                if (!type.equals("Admins")) {
                                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    break;

                                }
                            case R.id.navigation_search:

                                if (!type.equals("Admins"))
                                {
                                    Intent inten = new Intent(HomeActivity.this, SearchActivity.class);
                                    startActivity(inten);
                                    break;
                                }
                        case R.id.navigation_account:

                            if (!type.equals("Admins"))
                            {
                                Intent cart = new Intent(HomeActivity.this, AccountActivity.class);
                                startActivity(cart);
                                break;
                            }

                        case R.id.navigation_aboutus:

                        if (!type.equals("Admins"))
                        {
                            Intent cart = new Intent(HomeActivity.this, AboutusActivity.class);
                            startActivity(cart);
                            break;
                        }


                        }



                        return true;
                    }
                };
    }
