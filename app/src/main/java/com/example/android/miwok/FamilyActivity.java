package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        /*
        * 创建一个word类的数组，用于填充listview
        * @param 实参01：第一语言的单词、实参02：第二语言的单词、实参03：辅助识别图片
        * */
        ArrayList<Word> familyList = new ArrayList<Word>();
        familyList.add(new Word("father", getString(R.string.family_father), R.drawable.family_father));
        familyList.add(new Word("mother", getString(R.string.family_mother), R.drawable.family_mother));
        familyList.add(new Word("son", getString(R.string.family_son), R.drawable.family_son));
        familyList.add(new Word("daugher", getString(R.string.family_daugher), R.drawable.family_daughter));
        familyList.add(new Word("older brother", getString(R.string.family_older_brother), R.drawable.family_older_brother));
        familyList.add(new Word("younger brother", getString(R.string.family_younger_brother), R.drawable.family_younger_brother));
        familyList.add(new Word("older sister", getString(R.string.family_older_sister), R.drawable.family_older_sister));
        familyList.add(new Word("younger sister", getString(R.string.family_younger_sister), R.drawable.family_younger_sister));
        familyList.add(new Word("grandmother", getString(R.string.family_granmother), R.drawable.family_grandmother));
        familyList.add(new Word("grandfather", getString(R.string.family_grandfather), R.drawable.family_father));

        WordAdapter itemsAdapter = new WordAdapter(this, familyList,R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);
    }
}
