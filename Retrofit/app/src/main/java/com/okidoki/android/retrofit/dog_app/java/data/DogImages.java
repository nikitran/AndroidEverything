
package com.okidoki.android.retrofit.dog_app.java.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogImages {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("message")
    @Expose
    public List<String> message;

    @Override
    public String toString() {
        return "DogImages{" +
                "status='" + status + '\'' +
                ", message=" + message +
                '}';
    }
}
