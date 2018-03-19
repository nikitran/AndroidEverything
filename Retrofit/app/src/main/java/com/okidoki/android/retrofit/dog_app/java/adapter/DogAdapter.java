package com.okidoki.android.retrofit.dog_app.java.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.okidoki.android.retrofit.R;

import java.util.List;

/**
 * Created by nikitran on 3/13/18.
 */

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {
    private List<String> mDogList;
    private Context mContext;

    public DogAdapter(List<String> dogList, Context context) {
        mDogList = dogList;
        mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dog, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DogAdapter.ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mDogList.get(position))
                .into(holder.mDogImage);
    }

    @Override
    public int getItemCount() {
        return mDogList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mDogImage;

        public ViewHolder(View v){
            super(v);
            mDogImage = v.findViewById(R.id.dog_iv);
        }
    }
}
