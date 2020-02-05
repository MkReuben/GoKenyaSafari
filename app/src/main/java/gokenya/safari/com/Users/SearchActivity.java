package gokenya.safari.com.Users;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import gokenya.safari.com.Model.Safaris;
import gokenya.safari.com.R;
import gokenya.safari.com.ViewHolder.Safariviewholder;

public class SearchActivity extends AppCompatActivity {

    private Button searchBtn;
    private EditText inputText;
    private RecyclerView searchlist;
    private String SearchInput;
    private String type ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        inputText=findViewById(R.id.search__name);
        searchBtn=findViewById(R.id.search_btn);
        searchlist=findViewById(R.id.search_list);
        searchlist.setLayoutManager(new LinearLayoutManager(SearchActivity.this));

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)


            {
                SearchInput=inputText.getText().toString().toUpperCase();
                onStart();

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                if (!type.equals("Admin"))
                {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254718209341"));
                    if (ContextCompat.checkSelfPermission(SearchActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(SearchActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    }
                    else
                    {
                        startActivity(intent);
                    }

                }
            }


        });




    }

    @Override
    protected void onStart() {
        super.onStart();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Packages");

        FirebaseRecyclerOptions<Safaris> options =
                new FirebaseRecyclerOptions.Builder<Safaris>()
                        .setQuery(reference.orderByChild("name").startAt(SearchInput), Safaris.class)

                        .build();

        FirebaseRecyclerAdapter<Safaris, Safariviewholder> adapter =
                new FirebaseRecyclerAdapter<Safaris, Safariviewholder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull Safariviewholder safariviewholder, int i, @NonNull final Safaris services)
                    {
                        safariviewholder.SafariName.setText(services.getName());
                        safariviewholder.SafariDescription.setText(services.getDescription());
                        Safariviewholder.SafariPrice.setText("Price " +" USD "+services.getPrice());


                        Picasso.get().load(services.getImage()).into(safariviewholder.imageView);

                        safariviewholder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {
                                Intent intent =new Intent(SearchActivity.this, SafariDetailsActivity.class);
                                intent.putExtra("sid",services.getSid());
                                startActivity(intent);
                            }
                        });

                    }

                    @NonNull
                    @Override
                    public Safariviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
                    {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.safari_item_layout, parent, false);
                       Safariviewholder holder= new Safariviewholder(view);
                        return holder;
                    }
                };

        searchlist.setAdapter(adapter);
        adapter.startListening();



    }
}

