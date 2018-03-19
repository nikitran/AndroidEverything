package com.okidoki.android.activity.lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.okidoki.android.activity.R

class LifecycleActivity : AppCompatActivity() {
    // some transient state for the activity instance
    var mGameState: String? = null
    var GAME_STATE_KEY = "key";

    //----------------------------------ON-CREATE-----------------------------//
    /**
     *  - perform basic application startup logic that should happen only once
     *    for the entire life of the activity
     *  - savedInstanceState(Bundle) - contains the activity's previous saved state
     *  - setContentView() declares the user interface (XML file)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // user interface layout for this activity
        setContentView(R.layout.activity_lifecycle)

        // recovering the instance state
        // if Bundle savedInstanceState == null, the activity never existed
        if (savedInstanceState != null) {
            mGameState = savedInstanceState.getString(GAME_STATE_KEY);
        }
    }

    // The system calls onRestoreInstanceState() only if there is a saved state to restore, so you do
    // not need to check whether the Bundle is null. Bundle same as onCreate bundle
    // called right after the onStart() method.
    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        mGameState = savedInstanceState.getString(GAME_STATE_KEY);
    }

    // called when the activity may be temporarily destroyed, save the instance state here
    public override fun onSaveInstanceState(outState: Bundle?) {
        // save data to the bundle here:
        outState?.putString(GAME_STATE_KEY, mGameState);

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)
    }

    //-----------------------------------ON-START----------------------------------------
    /**
     * The onStart() call makes the activity visible to the user.
     *
     * This method is where the app initializes the code that maintains the UI.
     * OnStart() can be use to register a Broadcast Receiver that monitors changes that
     * are reflected in the UI.
     */
    override fun onStart() {
        super.onStart()
    }

    //----------------------------------ON-RESUME-------------------------------------//
    /**
     * The on OnResumed() callback is called when the activity comes the foreground. This is the state in which
     * the app interacts with the user.
     *
     * Use this method to initialize components that was released during onPaused()
     */
    override fun onResume() {
        super.onResume()
    }

    //--------------------------------ON-PAUSE------------------------------------------//
    /**
     * The system calls this method at the first indication that the user is leaving your activity
     *
     * Use the onPause() method to release system resources (broadcast receivers, GPS) and pause operations
     * such animations and music playback that should not continue while the Activity is in the Paused state
     *
     * Do not use onPause() to save application or user data, make network calls, or execute database transactions;
     * such work may not complete before the method completes. Instead, you should perform heavy-load shutdown
     * operations during onStop().
     */
    override fun onPause() {
        super.onPause()
    }

    //--------------------------------ON-STOP--------------------------------------------//
    /**
     * When your activity is no longer visible to the user, it has entered the Stopped state, and the
     * system invokes the onStop() callback.
     *
     * Use OnStop() to release all resources (BR), release resources that might leak memory, perform relative
     * CPU-intensive shutdown operations, save information to data base
     *
     * Once activity is stopped, the system might destroy the process that contains the activity if the
     * the system needs to recover memory. From the stopped state the activity if the activity comes back
     * the system invokes onRestart().
     */
    override fun onStop() {
        super.onStop()
    }

    //----------------------------------ON-DESTROY-------------------------------------------//
    /**
     *  The system calls on-destroy either when finish() is called, or when the system is
     *  temporarily destroying the process containing the activity to save space. You can distinguish
     *  between these two scenarios with the isFinishing() method.
     *
     *  The system may also call this method when an orientation change occurs, and then immediately
     *  call onCreate() to recreate the process (and the components that it contains) in the new orientation.
     */
    override fun onDestroy() {
        super.onDestroy()
    }

    /** isFinishing()
     * Check to see whether this activity is in the process of finishing, either because you called
     * finish() on it or someone else has requested that it finished.
     *
     * This is often used in onPause() to determine whether the activity is simply pausing or completely finishing.
     */


    //--------------------------------ON-RESTART-------------------------------------//
    override fun onRestart() {
        super.onRestart()
    }

}
