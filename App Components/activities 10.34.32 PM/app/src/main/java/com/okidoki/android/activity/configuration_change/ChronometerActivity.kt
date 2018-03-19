package com.okidoki.android.activity.configuration_change

import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import com.okidoki.android.activity.R
import kotlinx.android.synthetic.main.activity_chronometer.*

/**
 *  Part 1 - saveinstancestate
 *  Part 2 - view model
 *
 */

class ChronometerActivity : AppCompatActivity() {

    val BASE_EXTRA_KEY = "base_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chronometer)

        chronometer1.start()
        chronometer2.start()

        // PART 2: using ViewModel

        // The ViewModelStore provides a new ViewModel or one previously created.
        //val chronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)

        val chronometerViewModel = ChronometerViewModel();

        // If the start date is not defined, it's a new ViewModel so set it.
        if (chronometerViewModel.startTime == null) {
            val startTime = SystemClock.elapsedRealtime()
            chronometerViewModel.startTime = startTime
            chronometer3.base = startTime
        } else {
            // Set the chronometer's base to the original starting time.
            chronometer3.base = chronometerViewModel.startTime!!
        }
        chronometer3.start()
    }

    // Part 3: using onSaveInstanceState
    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putLong(BASE_EXTRA_KEY, chronometer2.base)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        var prevTime = savedInstanceState!!.getLong(BASE_EXTRA_KEY)
        chronometer2.base = prevTime
    }
}
