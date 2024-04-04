package com.example.kentuniguide;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Locale;

public class MapActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    HashMap<String, Integer> images = new HashMap<String, Integer>();
    private EditText write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //This is from some testing with using google's text to speech
        System.out.println("HERE");
        super.onCreate(savedInstanceState);
        images.put("food_false_accommodation_false_parking_false", R.drawable.my_image);
        images.put("food_true_accommodation_false_parking_false", R.drawable.food_true_accommodation_false_parking_false);
        images.put("food_true_accommodation_true_parking_false", R.drawable.food_true_accommodation_true_parking_false);
        images.put("food_false_accommodation_true_parking_false", R.drawable.food_false_accommodation_true_parking_false);
        images.put("food_false_accommodation_false_parking_true", R.drawable.food_false_accommodation_false_parking_true);
        images.put("food_false_accommodation_true_parking_true", R.drawable.food_false_accommodation_true_parking_true);
        images.put("food_true_accommodation_true_parking_true", R.drawable.food_true_accommodation_true_parking_true);
        images.put("food_true_accommodation_false_parking_true", R.drawable.food_true_accommodation_false_parking_true);

        images.put("fg_seminar_false_pc_false_lab_false_social_false", R.drawable.kennedy_fg);
        images.put("fg_seminar_false_pc_false_lab_false_social_true",R.drawable.fg_seminar_false_pc_false_lab_false_social_true);
        images.put("fg_seminar_false_pc_false_lab_true_social_false",R.drawable.fg_seminar_false_pc_false_lab_true_social_false);
        images.put("fg_seminar_false_pc_false_lab_true_social_true",R.drawable.fg_seminar_false_pc_false_lab_true_social_true);
        images.put("fg_seminar_false_pc_true_lab_false_social_false",R.drawable.fg_seminar_false_pc_true_lab_false_social_false);
        images.put("fg_seminar_false_pc_true_lab_false_social_true",R.drawable.fg_seminar_false_pc_true_lab_false_social_true);
        images.put("fg_seminar_false_pc_true_lab_true_social_false",R.drawable.fg_seminar_false_pc_true_lab_true_social_false);
        images.put("fg_seminar_false_pc_true_lab_true_social_true",R.drawable.fg_seminar_false_pc_true_lab_true_social_true);
        images.put("fg_seminar_true_pc_false_lab_false_social_false",R.drawable.fg_seminar_true_pc_false_lab_false_social_false);
        images.put("fg_seminar_true_pc_false_lab_false_social_true",R.drawable.fg_seminar_true_pc_false_lab_false_social_true);
        images.put("fg_seminar_true_pc_false_lab_true_social_false",R.drawable.fg_seminar_true_pc_false_lab_true_social_false);
        images.put("fg_seminar_true_pc_false_lab_true_social_true",R.drawable.fg_seminar_true_pc_false_lab_true_social_true);
        images.put("fg_seminar_true_pc_true_lab_false_social_false", R.drawable.fg_seminar_true_pc_true_lab_false_social_false);
        images.put("fg_seminar_true_pc_true_lab_false_social_true", R.drawable.fg_seminar_true_pc_true_lab_false_social_true);
        images.put("fg_seminar_true_pc_true_lab_true_social_false", R.drawable.fg_seminar_true_pc_true_lab_true_social_false);
        images.put("fg_seminar_true_pc_true_lab_true_social_true",R.drawable.fg_seminar_true_pc_true_lab_true_social_true);

        images.put("f1_seminar_false_pc_false_lab_false_social_false", R.drawable.kennedy_f1);
        images.put("f1_seminar_false_pc_false_lab_false_social_true",R.drawable.f1_seminar_false_pc_false_lab_false_social_true);
        images.put("f1_seminar_false_pc_false_lab_true_social_false",R.drawable.f1_seminar_false_pc_false_lab_true_social_false);
        images.put("f1_seminar_false_pc_false_lab_true_social_true",R.drawable.f1_seminar_false_pc_false_lab_true_social_true);
        images.put("f1_seminar_false_pc_true_lab_false_social_false",R.drawable.f1_seminar_false_pc_true_lab_false_social_false);
        images.put("f1_seminar_false_pc_true_lab_false_social_true",R.drawable.f1_seminar_false_pc_true_lab_false_social_true);
        images.put("f1_seminar_false_pc_true_lab_true_social_false",R.drawable.f1_seminar_false_pc_true_lab_true_social_false);
        images.put("f1_seminar_false_pc_true_lab_true_social_true",R.drawable.f1_seminar_false_pc_true_lab_true_social_true);
        images.put("f1_seminar_true_pc_false_lab_false_social_false",R.drawable.f1_seminar_true_pc_false_lab_false_social_false);
        images.put("f1_seminar_true_pc_false_lab_false_social_true",R.drawable.f1_seminar_true_pc_false_lab_false_social_true);
        images.put("f1_seminar_true_pc_false_lab_true_social_false",R.drawable.f1_seminar_true_pc_false_lab_true_social_false);
        images.put("f1_seminar_true_pc_false_lab_true_social_true",R.drawable.f1_seminar_true_pc_false_lab_true_social_true);
        images.put("f1_seminar_true_pc_true_lab_false_social_false", R.drawable.f1_seminar_true_pc_true_lab_false_social_false);
        images.put("f1_seminar_true_pc_true_lab_false_social_true", R.drawable.f1_seminar_true_pc_true_lab_false_social_true);
        images.put("f1_seminar_true_pc_true_lab_true_social_false", R.drawable.f1_seminar_true_pc_true_lab_true_social_false);
        images.put("f1_seminar_true_pc_true_lab_true_social_true",R.drawable.f1_seminar_true_pc_true_lab_true_social_true);

        images.put("f2_lab_false_social_false",R.drawable.kennedy_f2);
        images.put("f2_lab_true_social_false",R.drawable.f2_lab_true_social_false);
        images.put("f2_lab_true_social_true",R.drawable.f2_lab_true_social_true);
        images.put("f2_lab_false_social_true",R.drawable.f2_lab_false_social_true);

        onMapButton(null);
    }

    protected void onMapButton(Bundle savedInstanceState){
        setContentView(R.layout.default_map);
        final Button button = (Button) findViewById(R.id.supabutton);
        final Button expand_map = (Button) findViewById(R.id.expand_map);
        final ImageView image = (ImageView) findViewById(R.id.image_viewer);
        final Switch food_switch = (Switch) findViewById(R.id.food_switch);
        final Switch accomodation_switch = (Switch) findViewById(R.id.accomodation_switch);
        final Switch parking_switch = (Switch) findViewById(R.id.parking_switch);

//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                onMenuButton(null);
//            }
//        });

        expand_map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onExpandMap(null);
            }
        });

        food_switch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String image_src = "";
                if(food_switch.isChecked()) image_src = image_src + "food_true";
                else image_src = image_src + "food_false";

                if(accomodation_switch.isChecked()) image_src = image_src + "_accommodation_true";
                else image_src = image_src + "_accommodation_false";

                if(parking_switch.isChecked()) image_src = image_src + "_parking_true";
                else image_src = image_src + "_parking_false";
                image.setImageResource(images.get(image_src));
            }
        });

        accomodation_switch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String image_src = "";
                if(food_switch.isChecked()) image_src = image_src + "food_true";
                else image_src = image_src + "food_false";

                if(accomodation_switch.isChecked()) image_src = image_src + "_accommodation_true";
                else image_src = image_src + "_accommodation_false";

                if(parking_switch.isChecked()) image_src = image_src + "_parking_true";
                else image_src = image_src + "_parking_false";
                image.setImageResource(images.get(image_src));
            }
        });

        parking_switch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String image_src = "";
                if(food_switch.isChecked()) image_src = image_src + "food_true";
                else image_src = image_src + "food_false";

                if(accomodation_switch.isChecked()) image_src = image_src + "_accommodation_true";
                else image_src = image_src + "_accommodation_false";

                if(parking_switch.isChecked()) image_src = image_src + "_parking_true";
                else image_src = image_src + "_parking_false";
                image.setImageResource(images.get(image_src));
            }
        });
    }

//    protected void onMenuButton(Bundle savedInstanceState) {
//        setContentView(R.layout.activity_menu);
//        final Button button = (Button) findViewById(R.id.supabutton);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                onMapButton(null);
//            }
//        });
//    }

    protected void onExpandMap(Bundle savedInstanceState) {
        setContentView(R.layout.kennedy_fg);
        final ImageView image = (ImageView) findViewById(R.id.image_viewer);
        final Button button = (Button) findViewById(R.id.supabutton);
        final Button up_floor = (Button) findViewById(R.id.up_floor);
        final Switch seminarRoom_switch = (Switch) findViewById(R.id.seminarRoom_switch);
        final Switch pcRoom_switch = (Switch) findViewById(R.id.pcRoom_switch);
        final Switch labs_switch = (Switch) findViewById(R.id.labs_switch);
        final Switch social_switch = (Switch) findViewById(R.id.social_switch);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onMapButton(null);
            }
        });
        up_floor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                onFloor1(null);
            }
        });
        seminarRoom_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "fg_";
                if(seminarRoom_switch.isChecked())image_src =image_src +"seminar_true";
                else image_src =image_src +"seminar_false";

                if(pcRoom_switch.isChecked())image_src =image_src +"_pc_true";
                else image_src =image_src +"_pc_false";

                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
        pcRoom_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "fg_";
                if(seminarRoom_switch.isChecked())image_src =image_src +"seminar_true";
                else image_src =image_src +"seminar_false";

                if(pcRoom_switch.isChecked())image_src =image_src +"_pc_true";
                else image_src =image_src +"_pc_false";

                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
        labs_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "fg_";
                if(seminarRoom_switch.isChecked())image_src =image_src +"seminar_true";
                else image_src =image_src +"seminar_false";

                if(pcRoom_switch.isChecked())image_src =image_src +"_pc_true";
                else image_src =image_src +"_pc_false";

                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
        social_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "fg_";
                if(seminarRoom_switch.isChecked())image_src =image_src +"seminar_true";
                else image_src =image_src +"seminar_false";

                if(pcRoom_switch.isChecked())image_src =image_src +"_pc_true";
                else image_src =image_src +"_pc_false";

                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
    }

    protected void onFloor1(Bundle savedInstanceState) {
        setContentView(R.layout.kennedy_f1);
        final ImageView image = (ImageView)  findViewById(R.id.image_viewer);
        final Button button = (Button) findViewById(R.id.supabutton);
        final Button up_floor = (Button) findViewById(R.id.up_floor);
        final Button down_floor = (Button) findViewById(R.id.down_floor);
        final Switch seminarRoom_switch = (Switch) findViewById(R.id.seminarRoom_switch);
        final Switch pcRoom_switch = (Switch) findViewById(R.id.pcRoom_switch);
        final Switch labs_switch = (Switch) findViewById(R.id.labs_switch);
        final Switch social_switch = (Switch) findViewById(R.id.social_switch);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onMapButton(null);
            }
        });
        up_floor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                onFloor2(null);
            }
        });
        down_floor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                onExpandMap(null);
            }
        });
        seminarRoom_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "f1_";
                if(seminarRoom_switch.isChecked())image_src =image_src +"seminar_true";
                else image_src =image_src +"seminar_false";

                if(pcRoom_switch.isChecked())image_src =image_src +"_pc_true";
                else image_src =image_src +"_pc_false";

                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
        pcRoom_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "f1_";
                if(seminarRoom_switch.isChecked())image_src =image_src +"seminar_true";
                else image_src =image_src +"seminar_false";

                if(pcRoom_switch.isChecked())image_src =image_src +"_pc_true";
                else image_src =image_src +"_pc_false";

                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
        labs_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "f1_";
                if(seminarRoom_switch.isChecked())image_src =image_src +"seminar_true";
                else image_src =image_src +"seminar_false";

                if(pcRoom_switch.isChecked())image_src =image_src +"_pc_true";
                else image_src =image_src +"_pc_false";

                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
        social_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "f1_";
                if(seminarRoom_switch.isChecked())image_src =image_src +"seminar_true";
                else image_src =image_src +"seminar_false";

                if(pcRoom_switch.isChecked())image_src =image_src +"_pc_true";
                else image_src =image_src +"_pc_false";

                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
    }

    protected void onFloor2(Bundle savedInstanceState) {
        setContentView(R.layout.kennedy_f2);
        final ImageView image = (ImageView)  findViewById(R.id.image_viewer);
        final Button button = (Button) findViewById(R.id.supabutton);
        final Button down_floor = (Button) findViewById(R.id.down_floor);
        final Switch labs_switch = (Switch) findViewById(R.id.labs_switch);
        final Switch social_switch = (Switch) findViewById(R.id.social_switch);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onMapButton(null);
            }
        });
        down_floor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                onFloor1(null);
            }
        });
        labs_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "f2";
                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
        social_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String image_src = "f2";
                if(labs_switch.isChecked())image_src =image_src +"_lab_true";
                else image_src =image_src +"_lab_false";

                if(social_switch.isChecked())image_src =image_src +"_social_true";
                else image_src =image_src +"_social_false";
                image.setImageResource(images.get(image_src));
            }
        });
    }
}
