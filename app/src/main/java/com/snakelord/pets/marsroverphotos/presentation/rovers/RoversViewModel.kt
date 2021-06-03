package com.snakelord.pets.marsroverphotos.presentation.rovers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.model.State
import com.snakelord.pets.marsroverphotos.domain.interactor.rovers.RoversInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RoversViewModel @Inject constructor(
    private val roversInteractor: RoversInteractor): ViewModel() {

    private val mutableRoverLiveData = MutableLiveData<State<Rover>>()
    val rover: LiveData<State<Rover>>
        get() = mutableRoverLiveData

    private val onResultReceived: (State.Success<Rover>) -> Unit = {
            result -> mutableRoverLiveData.postValue(result)
    }

    private val onReceiveFailed: (State.Error) -> Unit = {
            error -> mutableRoverLiveData.postValue(error)
    }

    fun getInfoAbout(roverName: String) = viewModelScope.launch(Dispatchers.IO) {
        roversInteractor.getInfoAbout(roverName, onResultReceived, onReceiveFailed)
    }
}