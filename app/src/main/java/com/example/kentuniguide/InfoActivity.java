package com.example.kentuniguide;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.util.Patterns;
import android.widget.EditText;


import com.google.android.material.button.MaterialButton;

public class InfoActivity extends AppCompatActivity {

    //Database instance
    private Database dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        dbhelper = new Database(this);

        //this allows for the ID in the xml to interact with this activity
        EditText fName = (EditText) findViewById(R.id.fName);
        EditText lName = (EditText) findViewById(R.id.lName);
        EditText email = (EditText) findViewById(R.id.email);
        EditText problem = (EditText) findViewById(R.id.problem);
        MaterialButton problemSubBtn = (MaterialButton) findViewById(R.id.problemSubBtn);

        problemSubBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Validate the inputs done by the user and show pop-up dialog
                showPopUpDialog();
            }
        });
    }

    // This is what will appear in the pop-up dialog box
    private void showPopUpDialog() {
        // Validate inputs
        if(validateInputs()){
            //This will allow the method to insert data to work
            insertDataIntoDatabase();

            // This displays the  pop-up dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Thank you for entering your details, it has been saved and we plan on getting back to you in 5-7 working days.")
                    .setTitle("Details Saved!");
            AlertDialog dialog = builder.create();
            dialog.show();

            // Delay before starting ThanksActivity
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                    startActivity(new Intent(InfoActivity.this, ThanksActivity.class));
                    //this allows the infoActivity to finish and for the thanksActivity to continue
                    finish();
                }
            }, 10000); // 10 seconds delay
        }
    }


    //This method is for the information that the user put inputted to be able to be written into the database
    private void insertDataIntoDatabase() {
        EditText fNameEditText = findViewById(R.id.fName);
        EditText lNameEditText = findViewById(R.id.lName);
        EditText emailEditText = findViewById(R.id.email);
        EditText problemEditText = findViewById(R.id.problem);

        String fName = fNameEditText.getText().toString().trim();
        String lName = lNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String problem = problemEditText.getText().toString().trim();

        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Database.COLUMN_FIRST_NAME, fName);
        values.put(Database.COLUMN_LAST_NAME, lName);
        values.put(Database.COLUMN_EMAIL,email);
        values.put(Database.COLUMN_QUERY, problem);


        //this will insert the data into a row on the information table
        long newRowId = db.insert(Database.TABLE_INFORMATION, null, values);

        //This will close the databases usage
        db.close();
    }

    //This is a validation for the name input, making sure a valid name in inputted
    private boolean isValidName(String name) {
        String regex = "^[a-zA-Z]+$";
        return name.matches(regex);
    }

    //This ensures that a valid email address is inputted
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    //This is what will appear if what the user has inputted is not valid
    private boolean validateInputs() {
        EditText fNameEditText = findViewById(R.id.fName);
        EditText lNameEditText = findViewById(R.id.lName);
        EditText emailEditText = findViewById(R.id.email);

        String fName = fNameEditText.getText().toString().trim();
        String lName = lNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        if (fName.isEmpty() || !isValidName(fName)) {
            fNameEditText.setError("Enter a valid First Name please.");
            fNameEditText.requestFocus();
            return false;
        }

        if (lName.isEmpty() || !isValidName(lName)) {
            lNameEditText.setError("Enter a valid Last Name please.");
            lNameEditText.requestFocus();
            return false;
        }

        if (email.isEmpty() || !isValidEmail(email)) {
            emailEditText.setError("Enter a valid email please.");
            emailEditText.requestFocus();
            return false;
        }

        return true;
    }
}