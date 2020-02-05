package gokenya.safari.com.Users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rey.material.widget.TextView;

import java.lang.reflect.Type;

import gokenya.safari.com.Notifications.NotificationActivity;
import gokenya.safari.com.R;
import gokenya.safari.com.Safaris.BusinessTravelPackages;
import gokenya.safari.com.Safaris.DepartingMombasaEndNairobi;
import gokenya.safari.com.Safaris.DiscoverKenyaSafari;
import gokenya.safari.com.Safaris.KenyaLuxurySafari;
import gokenya.safari.com.Safaris.KenyaSafariBeach;
import gokenya.safari.com.Safaris.MombasaDaySafaris;
import gokenya.safari.com.Safaris.MombasaRoadSafaris;
import gokenya.safari.com.Safaris.NairobiDaySafaris;
import gokenya.safari.com.Safaris.NairobiEndMombasa;
import gokenya.safari.com.Safaris.NairobiSafariActivity;
import gokenya.safari.com.Safaris.TanzaniaLuxurySafari;
import gokenya.safari.com.Safaris.TanzaniaSafaris;
import gokenya.safari.com.TopTourSafaris.LakeNakuru;
import gokenya.safari.com.TopTourSafaris.MasaiMara;
import gokenya.safari.com.networksync.CheckInternetConnection;

public class AccountActivity extends AppCompatActivity {

    private String type ="";
    private ImageView nairobiSafari,tanzaniaSafari,kenyasafaribeach,mombasadaysafaris,mombasaroadsafari,nairobiendmombasa,nairobidaysafari,mombasaendnairobi,dicoverkenyasafari,kenyaluxurysafari,tanzanialuxurysafari,businesstravelpackages;
    private ImageView call,sms,whatsapp,gmail,location,payments;
    private TextView toptourmasaimara,toptournakuru,showTextView,tvnakuru,tvgallery;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        showTextView=findViewById(R.id.tv_maasai_mara_top_tour);
        tvnakuru=findViewById(R.id.tv_nakuru_top_tour);


        tvnakuru.setPaintFlags(tvnakuru.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        showTextView.setPaintFlags(showTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        tvgallery=findViewById(R.id.gallery);

        nairobiSafari=findViewById(R.id.img_nairobi_safari);
        tanzaniaSafari=findViewById(R.id.imgn_tanzania_safaris);
        kenyasafaribeach=findViewById(R.id.img_kenya_safari_and_beach);
        mombasadaysafaris=findViewById(R.id.img_mombasa_day_tours);
        mombasaroadsafari=findViewById(R.id.img_mombasa_road_safaris);
        nairobiendmombasa=findViewById(R.id.img_nairobi_end_mombasa);
        nairobidaysafari=findViewById(R.id.img_nairobi_day_safari);
        mombasaendnairobi=findViewById(R.id.img_mombasa_end_nairobi);
        dicoverkenyasafari=findViewById(R.id.img_discover_kenya_safari);
        kenyaluxurysafari=findViewById(R.id.img_kenya_luxury_safari);
        tanzanialuxurysafari=findViewById(R.id.imgn_tanzania_luxury_safaris);
        businesstravelpackages=findViewById(R.id.img_business_travel_packages);



        call=findViewById(R.id.call);
        sms=findViewById(R.id.sms);
        whatsapp=findViewById(R.id.whatsapp);
        gmail=findViewById(R.id.gmail);
        location=findViewById(R.id.location);
        payments=findViewById(R.id.payment);


        toptourmasaimara=(TextView) findViewById(R.id.tv_maasai_mara_top_tour);
        toptournakuru=(TextView) findViewById(R.id.tv_nakuru_top_tour);

        FloatingActionButton fab = findViewById(R.id.fab);

        tvgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this,Gallery.class);
                startActivity(intent);

            }
        });

        toptournakuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this, LakeNakuru.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Lake Nakuru Top Safari", Toast.LENGTH_SHORT).show();

            }
        });

        toptourmasaimara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AccountActivity.this, MasaiMara.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Masai Mara Top Safari", Toast.LENGTH_SHORT).show();


            }
        });

        businesstravelpackages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this, BusinessTravelPackages.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Business travel packages", Toast.LENGTH_SHORT).show();
            }
        });

        tanzanialuxurysafari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this, TanzaniaLuxurySafari.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Tanzania Luxury Safaris", Toast.LENGTH_SHORT).show();
            }
        });

        kenyaluxurysafari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                Intent intent=new Intent(AccountActivity.this, KenyaLuxurySafari.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Kenya Luxury Safaris", Toast.LENGTH_SHORT).show();
            }
        });

        dicoverkenyasafari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent=new Intent(AccountActivity.this, DiscoverKenyaSafari.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Discover Kenya Safaris", Toast.LENGTH_SHORT).show();

            }
        });
        mombasaendnairobi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this, DepartingMombasaEndNairobi.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Mombasa End Nairobi Safaris", Toast.LENGTH_SHORT).show();

            }
        });


        nairobidaysafari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this, NairobiDaySafaris.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Nairobi Day Safaris", Toast.LENGTH_SHORT).show();


            }
        });

        nairobiendmombasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             Intent nairobisafari=new Intent(AccountActivity.this, NairobiEndMombasa.class);
                startActivity(nairobisafari);
                Toast.makeText(AccountActivity.this, "Nairobi End Mombasa Safaris", Toast.LENGTH_SHORT).show();
            }
        });

        nairobiSafari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent nairobisafari=new Intent(AccountActivity.this, NairobiSafariActivity.class);
                startActivity(nairobisafari);

                Toast.makeText(AccountActivity.this, "Nairobi Safaris", Toast.LENGTH_SHORT).show();


            }
        });



        tanzaniaSafari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this, TanzaniaSafaris.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Tanzania Safaris", Toast.LENGTH_SHORT).show();


            }
        });
        kenyasafaribeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this, KenyaSafariBeach.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Kenya Safari Beach", Toast.LENGTH_SHORT).show();

            }
        });
        mombasadaysafaris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this, MombasaDaySafaris.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Mombasa Day Safaris", Toast.LENGTH_SHORT).show();

            }
        });
        mombasaroadsafari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(AccountActivity.this, MombasaRoadSafaris.class);
                startActivity(intent);
                Toast.makeText(AccountActivity.this, "Mombasa Road Safaris", Toast.LENGTH_SHORT).show();

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                if (!type.equals("Admin"))
                {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254723321938"));
                    if (ContextCompat.checkSelfPermission(AccountActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(AccountActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    }
                    else
                    {
                        startActivity(intent);
                    }

                }
            }


        });

        location.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
//                Intent intent = new Intent(AccountActivity.this,LocationActivity.class);
//                startActivity(intent);
                                            new AlertDialog.Builder(AccountActivity.this)
                                                    .setTitle("Go Kenya Tours & Safaris")
                                                    .setMessage("Vision Plaza Nairobi,Mombasa Road")
                                                    .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Log.d("AlertDialog", "Positive");
                                                        }
                                                    })
                                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Log.d("AlertDialog", "Negative");
                                                        }
                                                    })
                                                    .show();
                                        }


                                    });




        payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent =new Intent(AccountActivity.this, PaymentActivity.class);
                startActivity(intent);


                Toast.makeText(AccountActivity.this, "Please wait while its loading..", Toast.LENGTH_SHORT).show();

            }
        });


        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","info@gokenyasafari.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Please include your contacts");
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
                if (ContextCompat.checkSelfPermission(AccountActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AccountActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else
                {
                    startActivity(intent);
                }

            }
        });



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
}


