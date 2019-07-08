package com.agrais.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity implements View.OnClickListener  {
   private TextView mCheatWarning;
   private TextView mAnswerTextView;
   private TextView mQuestionTextView;
   private Button mShowAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mCheatWarning= (TextView) findViewById(R.id.cheat_warning);
        mAnswerTextView= (TextView) findViewById(R.id.answer_text_view);
        mQuestionTextView= (TextView) findViewById(R.id.question_text_view);
        mShowAnswerButton=(Button) findViewById(R.id.show_answer_button);

        mShowAnswerButton.setOnClickListener(this);

        mAnswerTextView.setVisibility(View.INVISIBLE);
        mQuestionTextView.setVisibility(View.VISIBLE);
        mCheatWarning.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick (View view){
        if (view.getId()==R.id.show_answer_button){
          mAnswerTextView.setVisibility(View.VISIBLE);
        }
    }
}
