package com.okidoki.android.retrofit.dog_app.java.service;

import com.okidoki.android.retrofit.dog_app.Constants;
import com.okidoki.android.retrofit.dog_app.java.data.DogImages;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by nikitran on 3/18/18.
 */

public class RetrofitService {

    public static class Factory {

        public static Observable<DogImages> create(String searchString) {
            Retrofit retrofit = create();
            DogService service = retrofit.create(DogService.class);
            return service.getDogImages(searchString);
        }

        private static Retrofit create() {
            return new Retrofit.Builder()
                    .baseUrl(Constants.url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    public interface DogService {
        @GET("breed/{breedName}/images")
        Observable<DogImages> getDogImages(@Path("breedName")String breed);
    }
}
