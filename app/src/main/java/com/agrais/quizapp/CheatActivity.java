package com.agrais.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity implements View.OnClickListener  {


    public static final String EXTRA_QUESTION_TEXT = "question_text";
    public static final String EXTRA_ANSWER_TEXT = "answer_text";
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

        Intent launchIntent= getIntent();
        String questionText = launchIntent.getStringExtra(EXTRA_QUESTION_TEXT);
        String answerText = launchIntent.getStringExtra(EXTRA_ANSWER_TEXT);

        mQuestionTextView.setText(questionText);
        mAnswerTextView.setText(answerText);
    }

    @Override
    public void onClick (View view){
        if (view.getId()==R.id.show_answer_button){
          mAnswerTextView.setVisibility(View.VISIBLE);

          Intent resIntent = new Intent();
          resIntent.putExtra("did_cheat", true);
          setResult(RESULT_OK, resIntent);
        }
    }
    public static Intent newIntent(Context ctx,Question question){
        Intent ret = new Intent (ctx, CheatActivity.class);
        ret.putExtra(EXTRA_QUESTION_TEXT, question.getText(ctx));
        ret.putExtra(EXTRA_ANSWER_TEXT,question.getAnswerText(ctx));
        return ret;
    }

    public static boolean didCheat(Intent resultData){
        return resultData.getBooleanExtra("did_cheat",false);
    }
}
