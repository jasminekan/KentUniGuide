package com.example.kentuniguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class requestActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    Button yButton;
    Button nButton;
    Button homeButton;
    private TextToSpeech tts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        // Initialize TextToSpeech
        tts = new TextToSpeech(this, this);

        yButton = findViewById(R.id.Yfeedback);
        nButton = findViewById(R.id.Nfeedback);
        homeButton = findViewById(R.id.homeButton); // Initialize homeButton here

        yButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requestActivity.this, faceActivity.class));
            }
        });

        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requestActivity.this, ThanksActivity.class));
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requestActivity.this, MenuActivity.class);
                startActivity(intent);
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

        String defaultWelcomeMessage = getString(R.string.request);
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
