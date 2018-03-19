package com.okidoki.android.retrofit.dog_app.kotlin.service

import com.okidoki.android.retrofit.dog_app.Constants
import com.okidoki.android.retrofit.dog_app.kotlin.data.DogImages
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by nikitran on 3/16/18.
 */
interface DogService {

    @GET("breed/{breedName}/images")
    fun getDogImages(@Path("breedName") breed: String): Observable<DogImages>


    companion object {
        fun create(): DogService {
            val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit.create(DogService::class.java)
        }
    }
}