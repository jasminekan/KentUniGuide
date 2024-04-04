package com.example.kentuniguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private List<String> courseDescriptions;
    private Button homeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize the homeButton after setContentView() is called
        homeButton = findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the home page
                Intent intent = new Intent(ResultActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        // Retrieve the course outcome and most frequent answer index from the intent
        String courseOutcome = getIntent().getStringExtra("COURSE_OUTCOME");
        int mostFrequentAnswerIndex = getIntent().getIntExtra("MOST_FREQUENT_ANSWER", -1);

        // Initialize the list of course descriptions
        initializeCourseDescriptions();

        // Display the course outcome and description on the screen
        TextView resultTextView = findViewById(R.id.resultTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        resultTextView.setText(getString(R.string.course_outcome_prefix, courseOutcome));

        if (mostFrequentAnswerIndex >= 0 && mostFrequentAnswerIndex < courseDescriptions.size()) {
            String courseDescription = courseDescriptions.get(mostFrequentAnswerIndex);
            descriptionTextView.setText(courseDescription);
        } else {
            descriptionTextView.setText(getString(R.string.description_not_available));
        }
    }

    private void initializeCourseDescriptions() {
        // Retrieve the array of course descriptions from resources
        String[] descriptionsArray = getResources().getStringArray(R.array.course_descriptions);

        // Convert the array to a list
        courseDescriptions = Arrays.asList(descriptionsArray);
    }
}
