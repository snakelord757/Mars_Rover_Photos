package com.snakelord.pets.marsroverphotos.data.mapper

import com.snakelord.pets.marsroverphotos.data.model.Camera
import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.domain.extensions.isEmpty
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject

class RoversResponseMapper: Mapper<Response, Rover> {
    override fun map(input: Response): Rover {
        if (input.isEmpty())
            return Rover()
        val responseJson = input.body!!.string()
        val jsonObject = JSONObject(responseJson).getJSONObject(PARENT_JSON_OBJECT)
        return getRoverInfo(jsonObject)
    }

    private fun getRoverInfo(roverObject: JSONObject): Rover =
        Rover(
            roverName = roverObject.getString(NAME),
            landingDate = roverObject.getString(LANDING_DATE),
            launchDate = roverObject.getString(LAUNCHING_DATE),
            status = roverObject.getString(STATUS),
            sol = roverObject.getInt(MAX_SOL),
            lastPhotoDate = roverObject.getString(MAX_DATE),
            totalPhotos = roverObject.getInt(TOTAL_PHOTOS),
            cameras = getCameras(roverObject.getJSONArray(CAMERAS))
        )

    private fun getCameras(camerasArray: JSONArray): Array<Camera> {
        val cameras = Array(camerasArray.length()) { Camera() }
        for (i in 0 until camerasArray.length())
            cameras[i] = getCamera(camerasArray.getJSONObject(i))
        return cameras
    }

    private fun getCamera(cameraObject: JSONObject) =
        Camera(
            cameraName = cameraObject.getString(NAME),
            fullCameraName = cameraObject.getString(FULL_CAMERA_NAME)
        )

    companion object {
        private const val PARENT_JSON_OBJECT = "rover"
        private const val NAME = "name"
        private const val FULL_CAMERA_NAME = "full_name"
        private const val LANDING_DATE = "landing_date"
        private const val LAUNCHING_DATE = "launch_date"
        private const val STATUS = "status"
        private const val MAX_SOL = "max_sol"
        private const val MAX_DATE = "max_date"
        private const val TOTAL_PHOTOS = "total_photos"
        private const val CAMERAS = "cameras"
    }
}