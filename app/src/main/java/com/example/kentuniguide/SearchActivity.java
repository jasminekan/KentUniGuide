package com.example.kentuniguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        Button COMP3200 = findViewById(R.id.button1);
        Button COMP3220 = findViewById(R.id.button2);
        Button COMP3250 = findViewById(R.id.button3);
        Button COMP3230 = findViewById(R.id.button4);
        Button COMP3280 = findViewById(R.id.button5);
        Button COMP3270 = findViewById(R.id.button6);
        Button COMP3830 = findViewById(R.id.button7);
        Button COMP5200 = findViewById(R.id.button8);
        COMP3200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModuleInfoActivity("COMP3200");
            }
        });

        COMP3220.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModuleInfoActivity("COMP3220");
            }
        });
        COMP3250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModuleInfoActivity("COMP3250");
            }
        });
        COMP3230.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModuleInfoActivity("COMP3230");
            }
        });
        COMP3280.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModuleInfoActivity("COMP3280");
            }
        });
        COMP3270.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModuleInfoActivity("COMP3270");
            }
        });
        COMP3830.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModuleInfoActivity("COMP3830");
            }
        });
        COMP5200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModuleInfoActivity("COMP5200");
            }
        });

    }

    private void startModuleInfoActivity(String moduleCode) {
        Intent intent = new Intent(SearchActivity.this, CourseActivity.class);
        intent.putExtra("MODULE_CODE", moduleCode);
        startActivity(intent);
    }
}
