package com.okidoki.android.retrofit.dog_app.kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.okidoki.android.retrofit.R
import kotlinx.android.synthetic.main.activity_main_dog.*

class MainDogActivity : AppCompatActivity() {
    val BREED_KEY = "breed_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dog)

        go_bv.setOnClickListener { v ->
            if (breed_ev.getText().toString() != "") {
                val i = Intent(v.context, DetailDogActivity::class.java)
                i.putExtra(BREED_KEY, breed_ev.getText().toString())
                startActivity(i)
            }
        }
    }
}
