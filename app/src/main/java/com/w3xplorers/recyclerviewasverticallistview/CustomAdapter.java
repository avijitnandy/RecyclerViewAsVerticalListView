package com.w3xplorers.recyclerviewasverticallistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Avijit on 8/3/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private ArrayList<AndroidVersion> android_versions;
    private Context context;


    public CustomAdapter(Context context,ArrayList<AndroidVersion> android_versions) {
        this.context = context;
        this.android_versions = android_versions;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.cards_layout, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {


        holder.vText.setText(android_versions.get(position).getAndroid_version_name());
        Picasso.with(context)
                .load(android_versions.get(position).getAndroid_image_url())
                .placeholder(R.drawable.placeholder)                             // optional
                .error(R.drawable.error)
                .resize(120, 120)
                .into(holder.vImageView);
    }

    @Override
    public int getItemCount() {
        return android_versions.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView vText;
        protected ImageView vImageView;

        private CustomViewHolder(View itemView) {
            super(itemView);
            vText = (TextView) itemView.findViewById(R.id.text);
            vImageView = (ImageView) itemView.findViewById(R.id.img);

            //to add onclick listener
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // The user may not set a click listener for list items, in which case our listener
            // will be null, so we need to check for this

            Toast.makeText(context, vText.getText()+"is clicked.",Toast.LENGTH_SHORT).show();
        }
    }





}