package com.example.kentuniguide;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class ThanksActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private Button homeButton; // Declare the Button variable

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);


        // Initialize TextToSpeech
        tts = new TextToSpeech(this, this);

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

        String defaultWelcomeMessage = getString(R.string.thanks);
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
