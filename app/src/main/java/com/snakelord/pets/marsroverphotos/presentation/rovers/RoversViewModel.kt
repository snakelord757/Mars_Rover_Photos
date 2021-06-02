package com.snakelord.pets.marsroverphotos.presentation.rovers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.domain.interactor.rovers.RoversInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RoversViewModel @Inject constructor(
    private val roversInteractor: RoversInteractor): ViewModel() {

    private val mutableRoverLiveData = MutableLiveData<Rover>()
    val rover: LiveData<Rover>
        get() = mutableRoverLiveData

    fun getInfoAbout(roverName: String) = viewModelScope.launch(Dispatchers.IO) {
        mutableRoverLiveData.postValue(roversInteractor.getInfoAbout(roverName))
    }
}