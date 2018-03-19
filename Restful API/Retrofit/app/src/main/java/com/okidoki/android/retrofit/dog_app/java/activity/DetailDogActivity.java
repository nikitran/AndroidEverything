package com.okidoki.android.retrofit.dog_app.java.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.okidoki.android.retrofit.R;
import com.okidoki.android.retrofit.dog_app.java.adapter.DogAdapter;
import com.okidoki.android.retrofit.dog_app.java.data.DogImages;
import com.okidoki.android.retrofit.dog_app.java.service.RetrofitService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailDogActivity extends AppCompatActivity {

    private String breedName;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dog);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        breedName = getIntent().getStringExtra(MainDogActivity.BREED_KEY);

        if (breedName == null || breedName.isEmpty() ) {
            Log.e("DetailActivity", "selectedBreed is null");
            return;
        }
        callRxRetrofit(breedName);
    }

    private void callRxRetrofit(String searchString){
        Observable<DogImages> result = RetrofitService.Factory.create(searchString);

        result
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DogImages>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(DogImages value) {
                        bindAdapterToView(value.message);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private void bindAdapterToView(List<String> list){
        mRecyclerView.setAdapter(new DogAdapter(list, this));
    }
}
