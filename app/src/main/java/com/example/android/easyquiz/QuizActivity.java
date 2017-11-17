package com.example.android.easyquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import static com.example.android.easyquiz.R.id.radioGroup;

/**
 * Created by sukanta on 11/11/2017.
 */

    public class QuizActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz);
            Intent intent = getIntent();

        }

    /**
     * This method will reset all the checked RadioButtons in all four of the questions.
     * @param view
     */

    public void resetQuiz (View view){
            RadioGroup radioGroup_one = (RadioGroup) findViewById(R.id.group_one);
            radioGroup_one.clearCheck();

            RadioGroup radioGroup_two = (RadioGroup) findViewById(R.id.group_two);
            radioGroup_two.clearCheck();

            RadioGroup radioGroup_three = (RadioGroup) findViewById(R.id.group_three);
            radioGroup_three.clearCheck();

            RadioGroup radioGroup_four = (RadioGroup) findViewById(R.id.group_four);
            radioGroup_four.clearCheck();
        }
    }

