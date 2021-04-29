package com.snakelord.pets.marsroverphotos.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.domain.interactor.PhotosInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val interactor: PhotosInteractor) : ViewModel() {

    private val photosArray = MutableLiveData<Array<Photo>>()
    val photos = photosArray

    fun getPhotosByDate(formattedDate: String) = viewModelScope.launch(Dispatchers.IO) {
        photosArray.postValue(interactor.getPhotosByDate(formattedDate))
    }

}