package com.okidoki.android.activity.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.okidoki.android.activity.R
import kotlinx.android.synthetic.main.activity_nav_a.*

/**
 * Starting an activity from another activity, and send data between the activities
 * - Part 1: startActivity() with explicit intent
 *     - start ActivityB explicitly
 *     - sending data from A - > B
 *
 * - Part 2: startActivity with implicit intent
 *     - start an activity with the type of action
 *     - sending data to the new activity
 *
 * - Part 3: startActivityForResult()
 *      - sending data from B -> A
 *      - setResult(RESULT_OK, Intent) used to return the result as a bundle
 *      - onActivityResult() calls before onResume() when first activity restarts
 *
 * - Order of lifecycle callbacks
 *     - Activity A - onCreate, onStart, onResume
 *     - Activity A - onPause
 *     - Activity B - onCreate, onStart, onResume
 *     - Activity A - onStop
 */


class ActivityA : AppCompatActivity() {

    val REQUEST_KEY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_a)

        Log.d("Activity A: ", "OnCreate")

// --------------------------------JAVA CODE ----------------------------------------
//        1. starting an activity (implicit)
//        Button startButton = findViewById(R.id.startActivityBtn);
//        startButton.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                Intent i = new Intent(ActivityA.this, ActivityB.class);
//                startActivity(i);
//            }
//        });

//        2. starting an activity to send an email (explicit)
//        Button startButton = findViewById(R.id.startActivityBtn);
//        startButton.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                Intent i = new Intent(ActivityA.this, ActivityB.class);
//                startActivity(i);
//            }
//        });

//       3. starting an activity with a returned result
//        static final int REQUEST_KEY = 0;
//        Button startButton = findViewById(R.id.startActivityBtn);
//        startButton.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                Intent i = new Intent(ActivityA.this, ActivityB.class);
//                startActivityForResult(i, REQUEST_KEY);
//            }
//        });


// ------------------------------KOTLIN---------------------------------------

        // 1. starting a specific activity (explicit intent)
        startActivityBtn.setOnClickListener {
            val i = Intent(this, ActivityB::class.java)
            i.putExtra("KEY_FOR_EXTRA", "sending over data to second activity")
            startActivity(i)
        }

        // 2. starting an activity to send and email (implicit intent)
        startActivityBtnImplicit.setOnClickListener {
            val i = Intent (Intent.ACTION_CHOOSER)
            i.putExtra(Intent.EXTRA_EMAIL, "email.com")
            startActivity(i)
        }

        // 3: starting an activity and wait for a return result
        startActivityForResultBtn.setOnClickListener {
            val i = Intent (this, ActivityB::class.java)
            startActivityForResult(i, REQUEST_KEY)
        }
    }

    // called immediately before onResume() when your activity is re-starting.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_KEY && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("result");
            Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show();
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity A: ", "OnStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity A: ", "OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity A: ", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity A: ", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity A: ", "OnStop")
    }

}
