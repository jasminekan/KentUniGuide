package com.example.kentuniguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class faceActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    ImageButton happyButton; // Allows for the image Button of the happy smiley face to function.
    ImageButton neutralButton; // Allows for the image button of the neutral face to function.
    ImageButton sadButton; // Allows for the image button of the neutral face to function.
    Button subButton; // Allows for the button for submit to work.
    MediaPlayer happySound; // Allows for the mp3 for happy face to be played
    MediaPlayer neutralSound; //Allows for the mp3 for neutral face to work
    MediaPlayer sadSound; //Allows for the mp3 for the sad face to work
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);

        // Initialize TextToSpeech
        tts = new TextToSpeech(this, this);

        //Defines the button with their ID
        neutralButton = (ImageButton) findViewById(R.id.Neutralbuttonn);
        happyButton = (ImageButton) findViewById(R.id.Happybuttonn);
        sadButton = (ImageButton) findViewById(R.id.Sadbuttonn);
        subButton = (Button) findViewById(R.id.SubButton);

        Button homeButton = findViewById(R.id.homeButton);


        //this will start the media sound for each sound effect used for the faces.
        happySound = MediaPlayer.create(this,R.raw.happy);
        neutralSound = MediaPlayer.create(this,R.raw.neutral);
        sadSound = MediaPlayer.create(this, R.raw.trumbone);

        //this instructs what happens when the button is clicked.
        neutralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(faceActivity.this, "You have selected the Neutral Face!", Toast.LENGTH_SHORT).show();
                playNeutralSound();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the home page
                Intent intent = new Intent(faceActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        //instructs what will happen when the happyButton is clicked
        happyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(faceActivity.this, "You have selected the Happy Face!", Toast.LENGTH_SHORT).show();
                playHappySound();
            }
        });

        //Instructs what will happen when the sadButton is clicked
        sadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(faceActivity.this, "You have selected the Sad Face!", Toast.LENGTH_SHORT).show();
                playSadSound();
            }
        });

        //when the subButton is clicked this will instruct what page to go on to.
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(faceActivity.this, ExtraActivity.class)); //This allows the extra activity to open when the submit button has opened.
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

        String defaultWelcomeMessage = getString(R.string.select);
        tts.speak(defaultWelcomeMessage, TextToSpeech.QUEUE_FLUSH, null, null);

    }

    //these methods will allow the the sound to start playing
    private void playNeutralSound() {
        neutralSound.start();
    }

    private void playHappySound() {
        happySound.start();
    }

    private void playSadSound() {
        sadSound.start();
    }
    // This will release the MediaPlayer resources when activity is destroyed/stops
    @Override
    protected void onDestroy() {
        // Release the TTS engine when the activity is destroyed
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
        if (happySound != null) {
            happySound.release();
        }
        if (neutralSound != null) {
            neutralSound.release();
        }
        if (sadSound != null) {
            sadSound.release();
        }
    }
}



