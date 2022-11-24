package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button launchBtn;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        counter = bundle != null ? bundle.getInt("counter") : 0;

        launchBtn = findViewById(R.id.btnLaunch);

        launchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launch = new Intent(MainActivity.this, SecondActivity.class);
                launch.putExtra("counter", ++counter);
                startActivity(launch);
            }
        });
    }
}