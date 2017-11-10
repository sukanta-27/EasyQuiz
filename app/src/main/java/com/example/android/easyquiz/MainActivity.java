package com.example.android.easyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    //Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void onClear(View v) {
        /* Clears all selected radio buttons to default */
        radioGroup.clearCheck();
        EditText name = (EditText) findViewById(R.id.enter_name);
        name.setText("");

        EditText email = (EditText) findViewById(R.id.enter_email);
        email.setText("");

        EditText age = (EditText) findViewById(R.id.enter_age);
        age.setText("");
    }

    public void onSubmit(View v) {
        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
       // if (null != rb) {
            //Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
       /* }
        else{
            rb.setError("Sex is required.");
        }*/

    }

}

