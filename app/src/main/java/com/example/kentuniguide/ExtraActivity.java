package com.example.kentuniguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class ExtraActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    Button buttonY; //Allows for the yes button to work
    Button buttonN; //Allows for the no button to function.
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        // Initialize TextToSpeech
        tts = new TextToSpeech(this, this);

        Button homeButton = findViewById(R.id.homeButton);

        buttonY = findViewById(R.id.buttonYes);
        buttonN = findViewById(R.id.buttonNo);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the home page
                Intent intent = new Intent(ExtraActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        //This will allow the page to go to the information page when the yes button is clicked
        buttonY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExtraActivity.this,InfoActivity.class));
            }
        });

        //This will allow the the page to go to the thanks page when the no button is clicked
        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExtraActivity.this, ThanksActivity.class));
            }
        });
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            // Speak the welcome message
            speakMessage();
        } else {
            Log.e("TTS", "Initialization failed");
        }
    }

    private void speakMessage() {
        // Get the current locale
        Locale currentLocale = getResources().getConfiguration().locale;

        // Set the language of the TTS engine to match the current locale
        tts.setLanguage(currentLocale);

        String defaultWelcomeMessage = getString(R.string.query);
        tts.speak(defaultWelcomeMessage, TextToSpeech.QUEUE_FLUSH, null, null);

    }

    @Override
    protected void onDestroy() {
        // Release the TTS engine when the activity is destroyed
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
