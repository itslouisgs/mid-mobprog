package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button doItAgainBtn;
    TextView textView;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        doItAgainBtn = findViewById(R.id.btnDoItAgain);
        textView = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        counter = bundle != null ? bundle.getInt("counter") : 1;

        if (counter == 1){
            textView.setText("You've launched the rocket.");
        } else {
            textView.setText("You've launched the rocket " + counter + " times.");
        }

        doItAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent doItAgainIntent = new Intent(SecondActivity.this, MainActivity.class);
                doItAgainIntent.putExtra("counter", counter);
                startActivity(doItAgainIntent);
            }
        });

    }
}