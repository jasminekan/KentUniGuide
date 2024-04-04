package com.example.kentuniguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;


public class QuestionnaireActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private List<String> userResponses = new ArrayList<>();

    private String[] questions = {"question_0", "question_1", "question_2", "question_3", "question_4", "question_5", "question_6", "question_7", "question_8", "question_9"};
    private String[][] options = {
            {"option_1_1", "option_1_2", "option_1_3", "option_1_4", "option_1_5"},
            {"option_2_1", "option_2_2", "option_2_3", "option_2_4", "option_2_5"},
            {"option_3_1", "option_3_2", "option_3_3", "option_3_4", "option_3_5"},
            {"option_4_1", "option_4_2", "option_4_3", "option_4_4", "option_4_5"},
            {"option_5_1", "option_5_2", "option_5_3", "option_5_4", "option_5_5"},
            {"option_6_1", "option_6_2", "option_6_3", "option_6_4", "option_6_5"},
            {"option_7_1", "option_7_2", "option_7_3", "option_7_4", "option_7_5"},
            {"option_8_1", "option_8_2", "option_8_3", "option_8_4", "option_8_5"},
            {"option_9_1", "option_9_2", "option_9_3", "option_9_4", "option_9_5"},
            {"option_10_1", "option_10_2", "option_10_3", "option_10_4", "option_10_5"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        Button homeButton = findViewById(R.id.homeButton);

        displayQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the user's response and move to the next question
                handleNextButtonClick();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the home page
                Intent intent = new Intent(QuestionnaireActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void displayQuestion() {
        if (questionTextView != null && optionsRadioGroup != null) {
            // Check if there are more questions to display
            if (currentQuestionIndex < questions.length) {
                // Set the question text using the string resource
                int questionResId = getResources().getIdentifier(questions[currentQuestionIndex], "string", getPackageName());
                if (questionResId != 0) {
                    questionTextView.setText(getString(questionResId));
                }

                // Set the option texts using string resources
                for (int i = 0; i < 5; i++) {
                    int optionResId = getResources().getIdentifier("option_" + (currentQuestionIndex + 1) + "_" + (i + 1), "string", getPackageName());
                    if (optionResId != 0) {
                        RadioButton option = findViewById(getResources().getIdentifier("option" + (i + 1) + "RadioButton", "id", getPackageName()));
                        option.setText(getString(optionResId));
                    }
                }

                // Check if the user has previously selected an option for the current question
                if (userResponses.size() > currentQuestionIndex) {
                    int selectedOptionIndex = Integer.parseInt(userResponses.get(currentQuestionIndex));
                    // Check the corresponding radio button
                    optionsRadioGroup.check(optionsRadioGroup.getChildAt(selectedOptionIndex).getId());
                }
            } else {
                // Display a message indicating that all questions have been answered
                Toast.makeText(this, "All questions have been answered.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void handleNextButtonClick() {
        int selectedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

            // Store the index of the selected option
            userResponses.add(String.valueOf(optionsRadioGroup.indexOfChild(selectedRadioButton)));

            // Move to the next question
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                // Display the next question
                displayQuestion();
            } else {
                // User has answered all questions
                showResult();
            }
        } else {
            // Show a message indicating that the user must select an option
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
        }
    }

    private void showResult() {
        // Analyze user responses and determine the most frequent answer
        int[] answerCount = new int[options[0].length];

        for (String answer : userResponses) {
            answerCount[Integer.parseInt(answer)]++;
        }

        // Find the index of the most frequent answer
        int mostFrequentAnswerIndex = 0;
        for (int i = 1; i < answerCount.length; i++) {
            if (answerCount[i] > answerCount[mostFrequentAnswerIndex]) {
                mostFrequentAnswerIndex = i;
            }
        }

        // Determine the course outcome based on the most frequent answer
        String courseOutcome = getCourseOutcome(mostFrequentAnswerIndex);

        // Start the ResultActivity and pass the course outcome as an extra
        Intent intent = new Intent(QuestionnaireActivity.this, ResultActivity.class);
        intent.putExtra("COURSE_OUTCOME", courseOutcome);
        intent.putExtra("MOST_FREQUENT_ANSWER", mostFrequentAnswerIndex);
        startActivity(intent);
        finish();
    }


    private String getCourseOutcome(int answerIndex) {
        switch (answerIndex) {
            case 0:
                return getString(R.string.course_outcome_ai);
            case 1:
                return getString(R.string.course_outcome_bit);
            case 2:
                return getString(R.string.course_outcome_cs);
            case 3:
                return getString(R.string.course_outcome_cyber);
            case 4:
                return getString(R.string.course_outcome_se);
            default:
                return getString(R.string.course_outcome_unknown);
        }
    }

}
