package gokenya.safari.com.Users;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import gokenya.safari.com.R;
import gokenya.safari.com.networksync.CheckInternetConnection;

public class PaymentActivity extends AppCompatActivity {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




//        if (!isConnected(PaymentActivity.this)) buildDialog(PaymentActivity.this).show();
//
//        else {
//
//            Toast.makeText(PaymentActivity.this,"Please wait while its loading...", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_payment);


            webView = findViewById(R.id.webview);
            WebSettings webSetting = webView.getSettings();
            webSetting.setJavaScriptEnabled(true);
            webView.loadUrl("https://payments.pesapal.com/gokenyasafari");
            webView.setWebViewClient(new WebViewClient());

            new CheckInternetConnection(this).checkConnection();

        }
//
//    }

//    public boolean isConnected(Context context) {
//
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo netinfo = cm.getActiveNetworkInfo();
//
//        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
//            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
//        else return false;
//        } else
//        return false;
//    }
//
//    public AlertDialog.Builder buildDialog(Context c) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(c);
//        builder.setTitle("No Internet Connection");
//        builder.setMessage("You need to have Mobile Data or wifi to access this page. Press ok to Exit");
//
//        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                finish();
//            }
//        });
//
//        return builder;
//    }


    @Override
    public void onBackPressed()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
            new CheckInternetConnection(this).checkConnection();
        }
        else
            {

            super.onBackPressed();
                new CheckInternetConnection(this).checkConnection();
        }
    }


}
