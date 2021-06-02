package com.snakelord.pets.marsroverphotos.presentation.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.snakelord.pets.marsroverphotos.R
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.databinding.FragmentPhotoDetailsBinding
import com.snakelord.pets.marsroverphotos.domain.extensions.parseDate
import com.squareup.picasso.Picasso

class PhotoDetailsFragment : Fragment() {

    private var photoDetailsBinding: FragmentPhotoDetailsBinding? = null
    private var photo: Photo? = null
    private val binding
        get() = photoDetailsBinding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        photoDetailsBinding = FragmentPhotoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.earthDate.propertyName.text = getString(R.string.date)
        binding.fromCamera.propertyName.text = getString(R.string.from_camera)
        binding.fromRover.propertyName.text = getString(R.string.from_rover)
        binding.martianSol.propertyName.text = getString(R.string.martian_sol)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        photo = arguments?.getSerializable(PHOTO_ARG) as Photo
        initViews()
    }

    private fun initViews() {
        Picasso
            .get()
            .load(photo!!.photoLink)
            .into(binding.photo)
        binding.earthDate.propertyValue.text = String.parseDate(photo!!.earthDate)
        binding.fromCamera.propertyValue.text = getString(
            R.string.about_placeholder,
            photo!!.fromCamera.cameraName,
            photo!!.fromCamera.fullCameraName
        )
        binding.fromRover.propertyValue.text = getString(
            R.string.about_placeholder,
            photo!!.fromRover.roverName,
            photo!!.fromRover.roverStatus
        )
        binding.martianSol.propertyValue.text = photo!!.photoMartianSol.toString()
    }

    companion object {
        const val PHOTO_ARG = "Photo"
    }

}