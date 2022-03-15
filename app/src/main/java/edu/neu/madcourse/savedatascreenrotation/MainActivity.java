package edu.neu.madcourse.savedatascreenrotation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textViewCount;
    private Button buttonIncrement;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.counterTextView);

        buttonIncrement = findViewById(R.id.incrementButton);

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });

        // Retrieving "count", if it exists
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
            textViewCount.setText(String.valueOf(count));
        }
    }

    private void increment() {
        count++;
        textViewCount.setText(String.valueOf(count));
    }

    // This method stores key-value pairs in the Bundle outState.
    // The key-values can be retrieved in the onCreate.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count", count);
    }
}