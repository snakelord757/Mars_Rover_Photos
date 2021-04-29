package com.snakelord.pets.marsroverphotos.presentation.main.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.snakelord.pets.marsroverphotos.R
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.squareup.picasso.Picasso

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val photoImageView = itemView.findViewById<ImageView>(R.id.photo)
    private val roverNameTextView = itemView.findViewById<TextView>(R.id.roverName)

    fun bind(photo: Photo) {
        roverNameTextView.text = photo.fromCamera.cameraName
        Picasso.get()
            .load(photo.photoLink)
            .into(photoImageView)
    }
}