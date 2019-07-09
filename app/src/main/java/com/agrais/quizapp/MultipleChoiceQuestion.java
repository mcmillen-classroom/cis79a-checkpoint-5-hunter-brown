package com.agrais.quizapp;

import android.content.Context;

import com.agrais.quizapp.Question;

public class MultipleChoiceQuestion extends Question {
    private int mAnswer;// index into array of correct answers 0=A 1=B 2=C 3=D
    private int mOptionsResId;
    public MultipleChoiceQuestion(int TextResId, int HintResId, int OptionsResId, int Answer) {
        super(TextResId, HintResId);
        mAnswer=Answer;
        mOptionsResId=OptionsResId;
    }

    public int getOptionsResId() {
        return mOptionsResId;
    }

    @Override
    public boolean isMultipleChoiceQuestion(){
        return true;
    }
    @Override
    public boolean checkAnswer(int userChoice){
        return mAnswer == userChoice;
    }

    @Override
    public String getAnswerText(Context ctx){
        String[] options= ctx.getResources().getStringArray(mOptionsResId);
        return options[mAnswer];
    }
}
