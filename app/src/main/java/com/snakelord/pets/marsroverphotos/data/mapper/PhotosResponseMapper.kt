package com.snakelord.pets.marsroverphotos.data.mapper

import com.snakelord.pets.marsroverphotos.data.model.Camera
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.model.RoverMinimal
import com.snakelord.pets.marsroverphotos.domain.extensions.isEmpty
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject

class PhotosResponseMapper @Inject constructor(): Mapper<Response, Array<Photo>> {

    override fun map(input: Response): Array<Photo> {
        if (input.isEmpty())
            return emptyArray()
        val responseJson = input.body!!.string()
        val jsonArray = JSONObject(responseJson).getJSONArray(JSON_ARRAY_NAME)
        return getPhotosArray(jsonArray)
    }

    private fun getPhotosArray(jsonArray: JSONArray): Array<Photo> {
        val photosArray = Array(jsonArray.length()) { Photo() }
        for (i in 0 until jsonArray.length())
            photosArray[i] = photoFromJson(jsonArray.getJSONObject(i))
        return photosArray
    }

    private fun photoFromJson(photoObject: JSONObject): Photo =
        Photo().apply {
            photoLink = photoObject.getString(IMG_SRC)
            photoMartianSol = photoObject.getInt(SOL)
            earthDate = photoObject.getString(EARTH_DATE)
            fromCamera = getCameraInfo(photoObject.getJSONObject(CAMERA))
            fromRoverMinimal = getRoverInfo(photoObject.getJSONObject(ROVER))
        }

    private fun getCameraInfo(cameraObject: JSONObject): Camera =
        Camera(
            cameraName = cameraObject.getString(NAME),
            fullCameraName = cameraObject.getString(FULL_CAMERA_NAME)
        )

    private fun getRoverInfo(roverObject: JSONObject): RoverMinimal =
        RoverMinimal(
            roverName = roverObject.getString(NAME),
            roverStatus = roverObject.getString(ROVER_STATUS)
        )

    companion object {
        private const val JSON_ARRAY_NAME = "photos"
        private const val IMG_SRC = "img_src"
        private const val EARTH_DATE = "earth_date"
        private const val NAME = "name"
        private const val FULL_CAMERA_NAME = "full_name"
        private const val CAMERA = "camera"
        private const val ROVER = "rover"
        private const val ROVER_STATUS = "status"
        private const val SOL = "sol"
    }
}