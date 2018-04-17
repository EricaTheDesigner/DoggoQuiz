package com.example.android.doggoquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app tests DoggoLingo knowledge and pushes for adoption of dogs
 */

public class MainActivity extends AppCompatActivity {

     //Tracks the score at the end of the app
   int final_score;
   int question_one= 0;
   int question_two= 0;
   int question_three= 0;
   int question_four= 0;
   int question_five=0;

    //Intializing Views in on Create method, doesn't recognize int values
    TextView show_final_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //QUESTION ONE
    private void questionOneAns(View view){
    RadioButton q_one_answer  = (RadioButton) findViewById(R.id.q_one_one);
    if (q_one_answer.isChecked()) {
        question_one = question_one + 20;
    }

    /**
     * Calculates the Quiz Score
     */
    public int tallyQuizScore(Integer view) {

        //QUESTION ONE
        RadioButton q_one_answer  = (RadioButton) findViewById(R.id.q_one_one);
        if (q_one_answer.isChecked()) {
          question_one = question_one + 20;
        }

        //QUESTION TWO
        CheckBox q_two_one = (CheckBox) findViewById(R.id.q_two_one);
        CheckBox q_two_two = (CheckBox) findViewById(R.id.q_two_two);
        CheckBox q_two_three = (CheckBox) findViewById(R.id.q_two_three);
        if (q_two_one.isChecked() && q_two_two.isChecked() && q_two_three.isChecked()){
            final_score = final_score + 20;
        }

        //QUESTION THREE
        EditText q_three_answer_ed = findViewById(R.id.q_three_answer);
        String q_three_answer = q_three_answer_ed.getText().toString();
        if (q_three_answer == "floof")
            final_score = final_score + 20;

        //QUESTION FOUR
        RadioButton q_four_answer  = (RadioButton) findViewById(R.id.q_four_answer);
        if (q_four_answer.isChecked()) {
            final_score = final_score + 20;
        }

        //QUESTION FIVE
        CheckBox q_five_one = (CheckBox) findViewById(R.id.q_five_one);
        CheckBox q_five_two = (CheckBox) findViewById(R.id.q_five_two);
        CheckBox q_five_three = (CheckBox) findViewById(R.id.q_five_three);
        if (q_five_one.isChecked() && q_five_two.isChecked() && q_five_three.isChecked()){
            final_score = final_score + 20;
        }

        return final_score;
    }


    //Calculates final_score
    public int calculateFinalScore(){
        final_score = 0;
        final_score = final_score + question_one + question_two + question_three + question_four + question_five;
        return final_score;
    }

    public void displayQuizScore(View view) {
        Context context = getApplicationContext();
        CharSequence text = "You Scored " + final_score + "%";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}