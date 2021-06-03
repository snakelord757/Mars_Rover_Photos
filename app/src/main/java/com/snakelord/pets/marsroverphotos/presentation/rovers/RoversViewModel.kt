package com.snakelord.pets.marsroverphotos.presentation.rovers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.model.State
import com.snakelord.pets.marsroverphotos.domain.interactor.rovers.RoversInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RoversViewModel @Inject constructor(
    private val roversInteractor: RoversInteractor): ViewModel() {

    private val roverMutableLiveData = MutableLiveData<State<Rover>>()
    val rover: LiveData<State<Rover>>
        get() = roverMutableLiveData

    private val onResultReceived: (State.Success<Rover>) -> Unit = {
            result -> roverMutableLiveData.postValue(result)
    }

    private val onReceiveFailed: (State.Error) -> Unit = {
            error -> roverMutableLiveData.postValue(error)
    }

    fun getInfoAbout(roverName: String) = viewModelScope.launch(Dispatchers.IO) {
        roversInteractor.getInfoAbout(roverName, onResultReceived, onReceiveFailed)
    }
}