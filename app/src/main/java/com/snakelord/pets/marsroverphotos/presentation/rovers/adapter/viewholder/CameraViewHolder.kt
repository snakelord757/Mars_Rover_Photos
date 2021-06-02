package com.snakelord.pets.marsroverphotos.presentation.rovers.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.snakelord.pets.marsroverphotos.R
import com.snakelord.pets.marsroverphotos.data.model.Camera

class CameraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(camera: Camera) {
        itemView.findViewById<TextView>(R.id.camera_name).text = camera.cameraName
        itemView.findViewById<TextView>(R.id.full_camera_name).text = camera.fullCameraName
    }
}