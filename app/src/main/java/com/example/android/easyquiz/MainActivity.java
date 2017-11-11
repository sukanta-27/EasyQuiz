package com.example.android.easyquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button button_12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        radioGroup.clearCheck();
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton rb = (RadioButton) group.findViewById(checkedId);
//                if (null != rb && checkedId > -1) {
//                    //Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        button_12 = (Button) findViewById(R.id.button2);
        button_12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });

    }

    private void launchActivity(){
        Intent intent = new Intent(this,QuizActivity.class);
        startActivity(intent);
    }

    public void onClear(View v) {
        /* Clears all selected radio buttons to default */
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.clearCheck();
        EditText name = (EditText) findViewById(R.id.enter_name);
        name.setText("");

        EditText email = (EditText) findViewById(R.id.enter_email);
        email.setText("");

        EditText age = (EditText) findViewById(R.id.enter_age);
        age.setText("");
    }

//    public void onSubmit(View v) {
//
//        Intent quiz_intent = new Intent(MainActivity.this, QuizClass.class);
//        startActivity(quiz_intent);
//
//    }

}

