package com.agrais.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class QuizOverActivity extends AppCompatActivity {

    public static final String EXTRA_QUIZ_SCORE = "quiz_score";

    private TextView mFinalTextView;
    private TextView mFinalScoreView;
    private TextView mFinalScoreVal;
    private String mFinalScore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_over);

        mFinalTextView= (TextView) findViewById(R.id.final_text_view);
        mFinalScoreView = (TextView) findViewById(R.id.final_score_view);
        mFinalScoreVal = (TextView) findViewById(R.id.final_score_val);

        Intent launchIntent= getIntent();
        int finalScore = launchIntent.getIntExtra(EXTRA_QUIZ_SCORE,0);

        mFinalTextView.setText(R.string.final_text_view);
        mFinalScoreView.setText(R.string.final_score_view);
        mFinalScoreVal.setText(String.valueOf(finalScore));

    }
    public static Intent newIntent(Context ctx, MainActivity mainActivity){
        Intent ret = new Intent(ctx,QuizOverActivity.class);
        ret.putExtra(EXTRA_QUIZ_SCORE,mainActivity.getScore());
        return ret;
    }
}
