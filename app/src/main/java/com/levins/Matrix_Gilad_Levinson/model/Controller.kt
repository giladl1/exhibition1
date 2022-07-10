package model

import com.google.gson.Gson
import com.levins.Matrix_Gilad_Levinson.model.jsonObject


class Controller {

    fun getLocations3(json: String):jsonObject{
        val gson = Gson()
        val objectList = gson.fromJson(json, jsonObject::class.java) //Array<jsonObject>::class.java
        return objectList
    }

    companion object {
    }
}