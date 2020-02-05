package gokenya.safari.com.Users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import gokenya.safari.com.Model.Safaris;
import gokenya.safari.com.R;
import gokenya.safari.com.ViewHolder.Safariviewholder;

public class SafariDetailsActivity extends AppCompatActivity {


        private ImageView sImage;
        private TextView safariPrice,  safaridescription, safariName;
        private String safariID = "";
        private ImageView call,sms,whatsapp,email,payments,location;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_safari_details);


            safariID = getIntent().getStringExtra("sid");


            sImage = findViewById(R.id.safari_image_details);
            safariPrice = findViewById(R.id.service_price_details);
            safaridescription = findViewById(R.id.safari_description_details);
            safariName = findViewById(R.id.safari_name_details);
            call=findViewById(R.id.call_details);
            sms=findViewById(R.id.sms_details);
            whatsapp=findViewById(R.id.whatsapp_details);
            email=findViewById(R.id.email_details);
            payments=findViewById(R.id.payments);
            location=findViewById(R.id.location);

            location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
//                    Intent intent = new Intent(SafariDetailsActivity.this,MapsActivity.class);
//                    startActivity(intent);

                {
                            new AlertDialog.Builder(SafariDetailsActivity.this)
                                    .setTitle( "Go Kenya Tours & Safaris" )
                                    .setMessage( "Vision Plaza Nairobi,Mombasa Road" )
                                    .setPositiveButton( "Save", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            Log.d( "AlertDialog", "Positive" );
                                        }
                                    })
                                    .setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            Log.d( "AlertDialog", "Negative" );
                                        }
                                    } )
                                    .show();
                        }


                }
            });

            payments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent intent =new Intent(SafariDetailsActivity.this, PaymentActivity.class);
                    startActivity(intent);

                    Toast.makeText(SafariDetailsActivity.this, "Please wait while its loading..", Toast.LENGTH_SHORT).show();

                }
            });


            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","info@gokenyasafari.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Please include your contact details");
                    startActivity(Intent.createChooser(emailIntent, ""));
                }
            });


            sms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Uri uri = Uri.parse("smsto:+254723321938");
                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                    intent.putExtra("sms_body", "");
                    startActivity(intent);

                }
            });




            whatsapp.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    startSupportChat ();
                }
            } );





            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254723321938"));
                    if (ContextCompat.checkSelfPermission(SafariDetailsActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(SafariDetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    }
                    else
                    {
                        startActivity(intent);
                    }

                }
            });

            getServiceDetails(safariID);



        }

    private void startSupportChat()
    {

        try {
            String headerReceiver = "GoKenya";// Replace with your message.
            String bodyMessageFormal = "Hello this GoKenya Safari";// Replace with your message.
            String whatsappContain = headerReceiver + bodyMessageFormal;
            String trimToNumner = "+254723321938"; //10 digit number
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( "https://wa.me/" + trimToNumner + "/?text=" + "" ) );
            startActivity ( intent );
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

    private void getServiceDetails(String serviceID) {



            DatabaseReference serviceRef = FirebaseDatabase.getInstance().getReference().child("Packages");

            serviceRef.child(serviceID).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Safaris services = dataSnapshot.getValue(Safaris.class);

                        safariName.setText(services.getName());
                        safariPrice.setText("Price" + " USD "+services.getPrice());
                        safaridescription.setText(services.getDescription());
                        Picasso.get().load(services.getImage()).into(sImage);

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }


    }

