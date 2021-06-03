package com.snakelord.pets.marsroverphotos.presentation.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.network.model.State
import com.snakelord.pets.marsroverphotos.domain.interactor.photos.PhotosInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotosViewModel @Inject constructor(private val interactor: PhotosInteractor) : ViewModel() {

    private val photosMutableLiveData = MutableLiveData<State<Array<Photo>>>()
    val photos: LiveData<State<Array<Photo>>>
        get() = photosMutableLiveData

    private val onResultReceived: (State.Success<Array<Photo>>) -> Unit = {
        result -> photosMutableLiveData.postValue(result)
    }

    private val onReceiveFailed: (State.Error) -> Unit = {
        error -> photosMutableLiveData.postValue(error)
    }

    fun getPhotosByDate(formattedDate: String) = viewModelScope.launch(Dispatchers.IO) {
        interactor.getPhotosByDate(formattedDate, onResultReceived, onReceiveFailed)
    }

}