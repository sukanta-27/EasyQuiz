package com.example.android.easyquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.android.easyquiz.R.string.email;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button button_12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        String name = ((TextView) findViewById(R.id.enter_name)).getText().toString();
        String Email = ((TextView) findViewById(R.id.enter_email)).getText().toString();
        String Age = ((TextView) findViewById(R.id.enter_age)).getText().toString();

        RadioGroup group = (((RadioGroup) findViewById(R.id.radioGroup)));
        RadioButton sexButton = (RadioButton) findViewById((group.getCheckedRadioButtonId()));
        String sex = sexButton.getText().toString();
        intent.putExtra("name",name);
        intent.putExtra("email",Email);
        intent.putExtra("age",Age);
        intent.putExtra("sex",sex);

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

}

