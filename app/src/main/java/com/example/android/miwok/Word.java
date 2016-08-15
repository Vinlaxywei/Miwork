package com.example.android.miwok;

/**
 * Created by hhoo7 on 2016/8/15.
 */
public class Word {
    private String firstLanguage;
    private String secondtLanguage;

    public Word(String firstLanguage, String secondtLanguage){
        this.firstLanguage = firstLanguage;
        this.secondtLanguage = secondtLanguage;
    }

    public String getFirstLanguage() {
        return firstLanguage;
    }

    public String getSecondtLanguage() {
        return secondtLanguage;
    }
}
