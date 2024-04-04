
package com.example.kentuniguide;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.kentuniguide.Module;


public class CourseActivity extends AppCompatActivity {

    private TextView moduleNameTextView;
    private TextView convenorTextView;
    private TextView descriptionTextView;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity);

        moduleNameTextView = findViewById(R.id.moduleName);
        convenorTextView = findViewById(R.id.convenor);
        descriptionTextView = findViewById(R.id.details);

        dbHelper = new MyDatabaseHelper(this);

        // Retrieve the module code passed from the previous activity
        String moduleCode = getIntent().getStringExtra("MODULE_CODE");

        // Retrieve module details from the database using the module code
        Module module = dbHelper.getModule(moduleCode);

        // Set the text of the TextViews with module details
        moduleNameTextView.setText(module.getModuleName());
        String convenorDetails = module.getConvenorName() + " (" + module.getConvenorEmail() + ")";
        convenorTextView.setText(convenorDetails);
        descriptionTextView.setText(module.getDescription());

    }
}