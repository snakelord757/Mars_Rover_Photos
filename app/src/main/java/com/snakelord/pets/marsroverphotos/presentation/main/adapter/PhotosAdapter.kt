package com.snakelord.pets.marsroverphotos.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.snakelord.pets.marsroverphotos.R
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.presentation.main.adapter.viewholder.EmptyListViewHolder
import com.snakelord.pets.marsroverphotos.presentation.main.adapter.viewholder.PhotoViewHolder

class PhotosAdapter(
    private val photos: Array<Photo>,
    private val clickListener: (Photo) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            PHOTO -> PhotoViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_photo, parent, false)
            )
            EMPTY_LIST -> EmptyListViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_empty_list, parent, false)
            )
            else -> throw IllegalStateException(UNKNOWN_VIEW_TYPE_EXCEPTION)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (getItemViewType(position) == PHOTO) {
            (holder as PhotoViewHolder).bind(photos[position])
            holder.itemView.setOnClickListener { clickListener.invoke(photos[position]) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (photos.isEmpty())
            return EMPTY_LIST
        return PHOTO
    }


    override fun getItemCount(): Int {
        if (photos.isEmpty())
            return 1
        return photos.size
    }

    companion object {
        private const val PHOTO = 1
        private const val EMPTY_LIST = 0
        private const val UNKNOWN_VIEW_TYPE_EXCEPTION = "Unknown viewType"
    }
}