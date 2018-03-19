package com.okidoki.android.retrofit.dog_app.java.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.okidoki.android.retrofit.R;

public class MainDogActivity extends AppCompatActivity {

    public static String BREED_KEY = "breed_key";
    Button goButton;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dog);

        goButton = findViewById(R.id.go_bv);
        input = findViewById(R.id.breed_ev);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.getText().toString().equals("")) {
                    Intent i = new Intent(v.getContext(), DetailDogActivity.class);
                    i.putExtra(BREED_KEY, input.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}
