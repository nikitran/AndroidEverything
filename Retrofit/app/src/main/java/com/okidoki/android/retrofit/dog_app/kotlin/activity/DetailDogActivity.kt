package com.okidoki.android.retrofit.dog_app.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.okidoki.android.retrofit.R
import com.okidoki.android.retrofit.dog_app.java.activity.MainDogActivity.BREED_KEY
import com.okidoki.android.retrofit.dog_app.kotlin.adapter.DogAdapter
import com.okidoki.android.retrofit.dog_app.kotlin.service.DogService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail_dog.*

class DetailDogActivity : AppCompatActivity() {
    private var disposable: Disposable? = null

    private val dogService by lazy {
        DogService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_dog)

        var breedName = intent.getStringExtra(BREED_KEY)
        recycler_view.setLayoutManager(LinearLayoutManager(this))

        startSearch(breedName);
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    private fun startSearch(searchString: String) {
        disposable = dogService.getDogImages(searchString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> if (result.message != null) bindAdapterToView(result.message!!) },
                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
                )
    }

    fun bindAdapterToView(list: List<String>){
        recycler_view.setAdapter(DogAdapter(list,this))
    }
}