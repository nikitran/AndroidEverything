package com.okidoki.android.activity.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.okidoki.android.activity.R
import kotlinx.android.synthetic.main.activity_nav_b.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_b)

        Log.d("Activity B: ", "OnCreate")

        if (getIntent() != null) {
            var data = getIntent().getStringExtra("KEY_FOR_EXTRA")
            Toast.makeText(this, data, Toast.LENGTH_LONG).show()
        }

        stopActivityBtn.setOnClickListener() { v ->
            var i = Intent();
            i.putExtra("result", "sent result from activity 2")
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity B: ", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity B: ", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity B: ", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity B: ", "OnStop")
    }
}
