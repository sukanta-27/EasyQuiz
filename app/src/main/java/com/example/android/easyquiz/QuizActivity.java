package com.example.android.easyquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by sukanta on 11/11/2017.
 */

    public class QuizActivity extends AppCompatActivity {

    public int score;
    char[] answers = new char[4];
    String name, email, age,sex;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz);
            Intent intent = getIntent();
            name = intent.getStringExtra("name");
            email = intent.getStringExtra("email");
            age = intent.getStringExtra("age");
            sex = intent.getStringExtra("sex");

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

    /*private String[] toEmailAddresses = new String[1];

    public void setToEmailAddresses(String[] toEmailAddresses) {
        this.toEmailAddresses = toEmailAddresses;
    }

    public String[] getToEmailAddresses() {
        return toEmailAddresses;
    }
*/

    /*
    * Method to Compose mail.
    * @param toEmailAddresses : send to all these email Adresses
    * @param summery : The summery of the mail
    * @param subject : The subject of the mail*/

    public void composeEmail(String Email,String summery, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL,new String[] {Email});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT ,summery);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /*
    * Method to create the summery of the mail
    * @param name:  Name of the Quiz taker
    * @param Age : age
    * @param sex
    * @param score : The score secured by the Quiz taker
    * */

    public String createSummery(String name, String email,String age, String sex, int score){

        String summery = "Name : "+name+"\n";
        summery += "Age : "+age+"\n";
        summery += "Sex : "+sex+"\n";
        summery += "Email : "+email+"\n";
        summery += "Score : "+score+"\n";

        return summery;
    }

    /*
    * This method takes all the selected radioButtons and check if they are the right answer or wrong, calculates the score and
    * shows it as a Toast. AS of Now.
    *
    * @param View*/

    public void submitQuiz(View view){
        score = 0;

        RadioGroup radioGroup_one = (RadioGroup) findViewById(R.id.group_one);
        RadioGroup radioGroup_two = (RadioGroup) findViewById(R.id.group_two);
        RadioGroup radioGroup_three = (RadioGroup) findViewById(R.id.group_three);
        RadioGroup radioGroup_four = (RadioGroup) findViewById(R.id.group_four);

        int selectedID_one = radioGroup_one.getCheckedRadioButtonId();
        RadioButton radioButton_one = (RadioButton) findViewById(selectedID_one);

        int selectedID_two = radioGroup_two.getCheckedRadioButtonId();
        RadioButton radioButton_two = (RadioButton) findViewById(selectedID_two);

        int selectedID_three = radioGroup_three.getCheckedRadioButtonId();
        RadioButton radioButton_three = (RadioButton) findViewById(selectedID_three);

        int selectedID_four = radioGroup_four.getCheckedRadioButtonId();
        RadioButton radioButton_four = (RadioButton) findViewById(selectedID_four);

        answers[0] = (radioButton_one.getText().toString()).charAt(0);
        answers[1] = (radioButton_two.getText().toString()).charAt(0);
        answers[2] = (radioButton_three.getText().toString()).charAt(0);
        answers[3] = (radioButton_four.getText().toString()).charAt(0);

        if(answers[0] == 'B'){
            score += 1;
        }

        if(answers[1] == 'D'){
            score += 1;
        }

        if(answers[2] == 'C'){
            score += 1;
        }

        if(answers[3] == 'A'){
            score += 1;
        }

        //Toast.makeText(QuizActivity.this, String.valueOf(score), Toast.LENGTH_SHORT).show();
        String subject = "Test results of Easy Quiz for "+name;
        String summery = createSummery(name, email,age,sex,score);
        composeEmail(email, summery, subject);

    }
}

