package com.example.kentuniguide;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private VideoView videoView;
    private Button skipButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);
        skipButton = findViewById(R.id.skipButton);

        // Hide skip button initially
        skipButton.setVisibility(View.GONE);

        // Initialize VideoView with the video resource
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(videoUri);

        // Listener to show skip button when video is prepared
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                skipButton.setVisibility(View.VISIBLE);
            }
        });

        // Play audio
        mediaPlayer = MediaPlayer.create(this, R.raw.audio); // Replace with your audio resource
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // After audio finishes, hide image, display video, and show skip button
                imageView.setVisibility(View.GONE);
                videoView.setVisibility(View.VISIBLE);
                videoView.start();
                skipButton.setVisibility(View.VISIBLE);
            }
        });

        mediaPlayer.start(); // Start playing the audio

        // Set OnClickListener for the skip button
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle skip action here
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer resources
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
