package gokenya.safari.com.Admins;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import gokenya.safari.com.R;

public class AdminMaintainActivity extends AppCompatActivity {

        private Button applyChangebtn,Deletebtn;
        private EditText name,price,description;
        private ImageView imageView;
        private Uri imageUri;
        private String safariID = "";
        private DatabaseReference safariRef;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin_maintain);

            safariID = getIntent().getStringExtra("sid");
            safariRef= FirebaseDatabase.getInstance().getReference().child("Packages").child(safariID);



            applyChangebtn=findViewById(R.id.edit_btn);
            Deletebtn=findViewById(R.id.delete_btn);
            name=findViewById(R.id.maintain_name);
            price=findViewById(R.id.maintain_price);
            description=findViewById(R.id.maintain_description);
            imageView=findViewById(R.id.maintain_image);

            displaySpecificServiceInfo();

            Deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    deleteThisService();

                }
            });

            applyChangebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    applyChanges();

                }
            });
        }

        private void deleteThisService()
        {
            safariRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task)
                {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(AdminMaintainActivity.this, "The Package is deleted successfully", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(AdminMaintainActivity.this, AdminHomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }

        private void applyChanges()
        {

            String sName=name.getText().toString();
            String sPrice=price.getText().toString();
            String sDescription=description.getText().toString();




            if (sName.equals(""))
            {
                Toast.makeText(this, "Write down Package Name", Toast.LENGTH_SHORT).show();
            }
            else  if (sPrice.equals(""))
            {
                Toast.makeText(this, "Write down Package Price", Toast.LENGTH_SHORT).show();
            }
            else  if (sDescription.equals(""))
            {
                Toast.makeText(this, "Write down Package Description", Toast.LENGTH_SHORT).show();
            }

            else
            {

                HashMap<String, Object> safariMap= new HashMap<>();

                safariMap.put("sid",safariID);
                safariMap.put("description",sDescription);
                safariMap.put("price",sPrice);
                safariMap.put("name",sName);
                safariRef.updateChildren(safariMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(AdminMaintainActivity.this, "Changes applied Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(AdminMaintainActivity.this,AdminHomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

            }


        }

        private void displaySpecificServiceInfo()
        {
            safariRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                {
                    if (dataSnapshot.exists())
                    {
                        String sName =dataSnapshot.child("name").getValue().toString();
                        String sPrice =dataSnapshot.child("price").getValue().toString();
                        String sDescription =dataSnapshot.child("description").getValue().toString();
                        String sImage =dataSnapshot.child("image").getValue().toString();

                        name.setText(sName);
                        price.setText(sPrice);
                        description.setText(sDescription);
                        Picasso.get().load(sImage).into(imageView);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError)
                {


                }
            });
        }
    }
