package com.snakelord.pets.marsroverphotos.presentation.rovers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.snakelord.pets.marsroverphotos.R
import com.snakelord.pets.marsroverphotos.data.model.Camera
import com.snakelord.pets.marsroverphotos.presentation.rovers.adapter.viewholder.CameraViewHolder

class CamerasAdapter(private val cameras: Array<Camera>) : Adapter<CameraViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        return CameraViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_camera, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.bind(cameras[position])
    }

    override fun getItemCount(): Int = cameras.size
}