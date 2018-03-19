package com.okidoki.android.retrofit.dog_app.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.okidoki.android.retrofit.R
import kotlinx.android.synthetic.main.item_dog.view.*

/**
 * Created by nikitran on 3/13/18.
 */
class DogAdapter(private val myDataset: List<String>, private val mContext: Context): RecyclerView.Adapter<DogAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_dog, parent, false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(mContext)
                .load(myDataset.get(position))
                .into(holder.dogIv)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogIv = itemView.dog_iv
    }

}