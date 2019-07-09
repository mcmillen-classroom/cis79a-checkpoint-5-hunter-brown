package com.agrais.quizapp;

import android.content.Context;

import java.io.StreamCorruptedException;

public class   Question {

    private int mTextResId;
    private int mHintResId;

    public Question(int TextResId, int HintResId )
    {
        mTextResId=TextResId;
        mHintResId=HintResId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public String getText(Context ctx){
        return ctx.getString(mTextResId);
    }
    //stub
    public String getAnswerText (Context ctx){
        return "";
    }

    public int getHintResId() {
        return mHintResId;
    }

    public void setHintResId(int hintResId) {
        mHintResId = hintResId;
    }

    //stub method only applies to T/F questions
    public boolean checkAnswer (boolean boolResponse){
        return false;
    }
    //stub Only applies to Fill in the Blank
    public boolean checkAnswer (String userAnswer){
        return false;
    }
    //stub Only applies to Multiple choice
    public boolean checkAnswer (int userChoice){
        return false;
    }
    //stub
    public boolean isTrueFalseQuestion(){
        return false;
    }
    //stub

    public boolean isFillTheBlankQuestion(){
        return false;
    }
    //stub
    public boolean isMultipleChoiceQuestion(){
        return false;
    }
}
