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
        familyList.add(new Word("father", "әpә", R.drawable.family_father));
        familyList.add(new Word("mother", "әṭa", R.drawable.family_mother));
        familyList.add(new Word("son", "angsi", R.drawable.family_son));
        familyList.add(new Word("daugher", "tune", R.drawable.family_daughter));
        familyList.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        familyList.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        familyList.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        familyList.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        familyList.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        familyList.add(new Word("grandfather", "paapa", R.drawable.family_father));

        /*
        * 添加一个WordAdapter（context，ArrayList<>）
        * 添加一个ListView
        * 绑定WordAdapter到ListView
        * */
        WordAdapter itemsAdapter = new WordAdapter(this, familyList);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);
    }
}
