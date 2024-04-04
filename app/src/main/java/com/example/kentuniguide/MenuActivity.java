package com.example.kentuniguide;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MenuActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Initialize TextToSpeech
        tts = new TextToSpeech(this, this);

        // Initialize buttons
        Button buttonFeature1 = findViewById(R.id.questionnairePageButton);
        Button buttonFeature2 = findViewById(R.id.mapPageButton);
        Button buttonFeature3 = findViewById(R.id.concernsPageButton);
        Button buttonFeature4 = findViewById(R.id.videoPageButton);

        Button frenchButton = findViewById(R.id.frenchButton);
        Button spanishButton = findViewById(R.id.spanishButton);
        Button italianButton = findViewById(R.id.italianButton);
        Button englishButton = findViewById(R.id.englishButton);


        // Set click listeners
        buttonFeature1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Feature 1
                startActivity(new Intent(MenuActivity.this, QuestionnaireActivity.class));
            }
        });

        buttonFeature2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MapActivity.class));
            }
        });

        buttonFeature3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Feature 3
                startActivity(new Intent(MenuActivity.this, requestActivity.class));
            }
        });

        buttonFeature4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Feature 4
                startActivity(new Intent(MenuActivity.this, SearchActivity.class));
            }
        });

        frenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set language to French
                setLocale("fr");
                tts.setLanguage(Locale.FRANCE);
            }
        });

        spanishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set language to Spanish
                setLocale("es");
            }
        });

        italianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set language to Italian
                setLocale("it");
            }
        });

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set language to english
                setLocale("en");
            }
        });
    }

    private void setLocale(String languageCode) {
        // Create a Locale object with the specified language code
        Locale locale = new Locale(languageCode);
        Configuration configuration = getResources().getConfiguration();
        // Set the locale of the configuration
        configuration.setLocale(locale);
        // Update the application resources based on the new configuration
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        // Set the language of the TTS engine
        tts.setLanguage(locale);
        // Recreate the activity to apply the language change
        recreate();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            // Speak the welcome message
            speakWelcomeMessage();
        } else {
            Log.e("TTS", "Initialization failed");
        }
    }

    private void speakWelcomeMessage() {
        // Get the current locale
        Locale currentLocale = getResources().getConfiguration().locale;

        // Set the language of the TTS engine to match the current locale
        tts.setLanguage(currentLocale);

        String defaultWelcomeMessage = getString(R.string.welcome_message_);
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
