package com.snakelord.pets.marsroverphotos.presentation.rovers

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.snakelord.pets.marsroverphotos.R
import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.model.State
import com.snakelord.pets.marsroverphotos.databinding.FragmentRoversBinding
import com.snakelord.pets.marsroverphotos.di.components.DaggerRoversComponent
import com.snakelord.pets.marsroverphotos.domain.extensions.parseDate
import com.snakelord.pets.marsroverphotos.presentation.extensions.gone
import com.snakelord.pets.marsroverphotos.presentation.extensions.visible
import com.snakelord.pets.marsroverphotos.presentation.rovers.adapter.CamerasAdapter
import javax.inject.Inject

class RoversFragment: Fragment() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private var roversFragmentBinding: FragmentRoversBinding? = null
    private val binding
        get() = roversFragmentBinding!!
    private val roversViewModel: RoversViewModel by navGraphViewModels(R.id.navigation_graph) { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerRoversComponent.builder()
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        roversFragmentBinding = FragmentRoversBinding.inflate(inflater, container, false)
        roversViewModel.rover.observe(viewLifecycleOwner, ::getResponse)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.launchDate.propertyName.text = getString(R.string.launching_date)
        binding.landingDate.propertyName.text = getString(R.string.landing_date)
        binding.status.propertyName.text = getString(R.string.status)
        binding.sol.propertyName.text = getString(R.string.martian_days)
        binding.lastPhotoDate.propertyName.text = getString(R.string.last_photo_date)
        binding.totalPhotos.propertyName.text = getString(R.string.total_photos)
        binding.curiosity.setOnClickListener { makeRequest(CURIOSITY) }
        binding.opportunity.setOnClickListener { makeRequest(OPPORTUNITY) }
        binding.spirit.setOnClickListener { makeRequest(SPIRIT) }
        roversViewModel.getInfoAbout(CURIOSITY)
    }

    private fun makeRequest(roverName: String) {
        roversViewModel.getInfoAbout(roverName)
        binding.progressCircular.visible()
        binding.errorMessage.gone()
        binding.roverInfo.gone()
    }

    private fun getResponse(response: State<Rover>) {
        if (response is State.Success)
            onRoverInfoLoaded(response.data)
        else
            showErrorMessage((response as State.Error).errorMessage)
    }

    private fun onRoverInfoLoaded(rover: Rover) {
        binding.progressCircular.gone()
        binding.roverInfo.visible()
        binding.roverName.text = rover.roverName
        binding.launchDate.propertyValue.text = String.parseDate(rover.launchDate)
        binding.landingDate.propertyValue.text = String.parseDate(rover.landingDate)
        binding.status.propertyValue.text = rover.status
        binding.sol.propertyValue.text = rover.sol.toString()
        binding.lastPhotoDate.propertyValue.text = String.parseDate(rover.lastPhotoDate)
        binding.totalPhotos.propertyValue.text = rover.totalPhotos.toString()
        val camerasAdapter = CamerasAdapter(rover.cameras)
        binding.cameras.apply {
            adapter = camerasAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun showErrorMessage(reason: String) {
        binding.progressCircular.gone()
        binding.roverInfo.gone()
        binding.errorMessage.text = reason
        binding.errorMessage.visible()
    }

    companion object {
        private const val CURIOSITY = "curiosity"
        private const val OPPORTUNITY = "opportunity"
        private const val SPIRIT = "spirit"
    }
}