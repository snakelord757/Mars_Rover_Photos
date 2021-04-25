package com.snakelord.pets.marsroverphotos.domain.mapper

import com.snakelord.pets.marsroverphotos.data.model.Camera
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.model.Rover
import okhttp3.Response
import org.json.JSONObject
import javax.inject.Inject

class PhotosResponseMapper @Inject constructor(): Mapper<Response, Array<Photo>>{

    override fun map(input: Response): Array<Photo> {
        val responseJson = input.body!!.string()
        val jsonArray = JSONObject(responseJson).getJSONArray(JSON_ARRAY_NAME)
        val photosArray = Array(jsonArray.length()) { Photo() }
        for (i in 0 until jsonArray.length())
            photosArray[i] = photoFromJson(jsonArray.getJSONObject(i))
        return photosArray
    }

    private fun photoFromJson(photoObject: JSONObject): Photo =
        Photo(
            photoLink = photoObject.getString(IMG_SRC),
            earthDate = EARTH_DATE,
            fromCamera = getCameraInfo(photoObject.getJSONObject(CAMERA)),
            fromRover = getRoverInfo(photoObject.getJSONObject(ROVER)),
        )

    private fun getCameraInfo(cameraObject: JSONObject): Camera =
        Camera(
            cameraName = cameraObject.getString(NAME),
            fullCameraName = cameraObject.getString(FULL_CAMERA__NAME)
        )

    private fun getRoverInfo(roverObject: JSONObject): Rover =
        Rover(
            roverName = roverObject.getString(NAME),
            roverLaunchDate = roverObject.getString(ROVER_LAUNCH_DATE),
            roverLandingDate = roverObject.getString(ROVER_LANDING_DATE),
            roverStatus = roverObject.getString(ROVER_STATUS)
        )

    companion object {
        private const val JSON_ARRAY_NAME = "photos"
        private const val IMG_SRC = "img_src"
        private const val EARTH_DATE = "earth_date"
        private const val NAME = "name"
        private const val FULL_CAMERA__NAME = "full_name"
        private const val CAMERA = "camera"
        private const val ROVER = "rover"
        private const val ROVER_LAUNCH_DATE = "launch_date"
        private const val ROVER_LANDING_DATE = "landing_date"
        private const val ROVER_STATUS = "status"
    }
}