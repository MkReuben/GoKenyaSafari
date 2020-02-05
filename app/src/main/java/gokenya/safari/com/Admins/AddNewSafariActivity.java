package gokenya.safari.com.Admins;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import gokenya.safari.com.R;

public class AddNewSafariActivity extends AppCompatActivity {
    private String Description, Location, Price, name, saveCurrrentDate, saveCurrentTime;
    private ImageView InputSafariImage;
    private Button AddNewSafari;
    private EditText InputSafariName, InputSafariDescription, InputSafariPrice;
    private static final int Gallerypick = 1;

    private Uri ImageUri;
    private String checker = "";
    private String serviceRandomKey, downloadImageuRL;
    private StorageReference SafariImageRef;
    private DatabaseReference SafariRef;
    private ProgressDialog LoadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_safari);



        SafariImageRef = FirebaseStorage.getInstance().getReference().child("Safari images");
        SafariRef = FirebaseDatabase.getInstance().getReference().child("Packages");
        AddNewSafari = findViewById(R.id.add_new_safari);
        InputSafariName = findViewById(R.id.safari_name);
        InputSafariDescription = findViewById(R.id.safari_description);
        InputSafariPrice = findViewById(R.id.safari_price);

        InputSafariImage = findViewById(R.id.select_safari_image);
        LoadingBar = new ProgressDialog(this);



        InputSafariImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            checker = "clicked";
//            CropImage.activity(imageUri)
                //  .setAspectRatio(7,7)
                //.start(AdminAddNewSafariActivity.this);
                OpenGallery();
            }
        });


        AddNewSafari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateData();
            }
        });

    }


    private void ValidateData() {

        Description = InputSafariDescription.getText().toString();
        Price = InputSafariPrice.getText().toString();
        name = InputSafariName.getText().toString();

        if (ImageUri == null) {
            Toast.makeText(this, "Package Image is required", Toast.LENGTH_SHORT).show();
        } else if (Description.isEmpty()) {
            Toast.makeText(this, "Package Description is required", Toast.LENGTH_SHORT).show();
        } else if (Price.isEmpty()) {
            Toast.makeText(this, "Your package price is mandatory", Toast.LENGTH_SHORT).show();
        } else if (name.isEmpty()) {
            Toast.makeText(this, "Package name is required", Toast.LENGTH_SHORT).show();
        } else {
            StoreInformation();
        }
    }

    private void StoreInformation() {

        LoadingBar.setTitle("Adding New Safari Package");
        LoadingBar.setMessage("Please wait while we are adding the new safari package");
        LoadingBar.setCanceledOnTouchOutside(false);
        LoadingBar.show();
        Calendar calendar = Calendar.getInstance();


        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd,yyyy");
        saveCurrrentDate = currentDate.format(calendar.getTime());


        SimpleDateFormat currentTime = new SimpleDateFormat("H:mm:ssa");
        saveCurrentTime = currentTime.format(calendar.getTime());

        serviceRandomKey = saveCurrentTime + saveCurrrentDate;

        final StorageReference filepath = SafariImageRef.child(ImageUri.getLastPathSegment() + serviceRandomKey + "jpg");

        final UploadTask uploadTask = filepath.putFile(ImageUri);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String message = e.toString();
                Toast.makeText(AddNewSafariActivity.this, "Error:" + message, Toast.LENGTH_SHORT).show();
                LoadingBar.dismiss();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(AddNewSafariActivity.this, "Package Image uploaded successfully", Toast.LENGTH_SHORT).show();
                Task<Uri> uriTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }
                        downloadImageuRL = filepath.getDownloadUrl().toString();
                        return filepath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {

                            downloadImageuRL = task.getResult().toString();
                            Toast.makeText(AddNewSafariActivity.this, "Getting package image URL successful", Toast.LENGTH_SHORT).show();


                            SavedServiceInfoToDatabase();
                        }
                    }
                });
            }
        });


    }

    private void SavedServiceInfoToDatabase() {
        HashMap<String, Object> serviceMap = new HashMap<>();
        serviceMap.put("sid", serviceRandomKey);
        serviceMap.put("date", saveCurrrentDate);
        serviceMap.put("time", saveCurrentTime);
        serviceMap.put("description", Description);
        serviceMap.put("image", downloadImageuRL);
        serviceMap.put("price", Price);
        serviceMap.put("name", name);


        SafariRef.child(serviceRandomKey).updateChildren(serviceMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(AddNewSafariActivity.this, AdminHomeActivity.class);
                            startActivity(intent);
                            LoadingBar.dismiss();
                            Toast.makeText(AddNewSafariActivity.this, "Package is added successfully..", Toast.LENGTH_SHORT).show();
                        } else {
                            LoadingBar.dismiss();

                            String message = task.getException().toString();
                            Toast.makeText(AddNewSafariActivity.this, "Error" + message, Toast.LENGTH_SHORT).show();


                        }

                    }
                });
    }


    private void OpenGallery() {

        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, Gallerypick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Gallerypick && resultCode == RESULT_OK && data != null) {
            ImageUri = data.getData();
            InputSafariImage.setImageURI(ImageUri);
        }


    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = " GoKenya";
            String descriptiom = "Channel for updates";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("MK", name, importance);
            channel.setDescription(descriptiom);


            Intent resultIntent = new Intent(this, AddNewSafariActivity.class);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }


    }

}