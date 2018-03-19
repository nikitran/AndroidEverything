package com.okidoki.android.retrofit.dog_app.kotlin.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DogImages {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("message")
    @Expose
    var message: List<String>? = null

    override fun toString(): String {
        return "DogImages{" +
                "status='" + status + '\''.toString() +
                ", message=" + message +
                '}'.toString()
    }
}
