package gokenya.safari.com.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.text.CollationElementIterator;

import gokenya.safari.com.R;


public class Safariviewholder extends RecyclerView.ViewHolder implements View.OnClickListener
{

    public static TextView SafariName;
    public static TextView SafariDescription;
    public static TextView SafariPrice;


    public ImageView imageView;
    public ItemClickListener listener;

    public Safariviewholder(@NonNull View itemView)
    {
        super(itemView);

        imageView=(ImageView) itemView.findViewById(R.id.safari_image);
        SafariDescription=(TextView) itemView.findViewById(R.id.safari_description);
        SafariName=(TextView) itemView.findViewById(R.id.safari_name);
        SafariPrice=(TextView) itemView.findViewById(R.id.safari_price);


        Picasso.get().load(String.valueOf(imageView)).networkPolicy(NetworkPolicy.OFFLINE).into(imageView, new Callback() {
            public void onSuccess()
            {

            }

            @Override
            public void onError(Exception e)
            {

            }
        });

    }

    @Override
    public void onClick(View view)
    {
        ItemClickListener.onClick(view,getAdapterPosition(),false);

    }
    public  void setItemClickListener(ItemClickListener listener)
    {
        this.listener=listener;
    }


}

