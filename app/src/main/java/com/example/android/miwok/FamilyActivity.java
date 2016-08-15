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
        * 创建一个word类的数组，word类由两个String组成，用于填充item中的两个TextView。
        * 构造函数中第一个实参是第一语言的单词，相应的第二个实参是第二语言的单词
        * */
        ArrayList<Word> familyList = new ArrayList<Word>();
        familyList.add(new Word("father","әpә"));
        familyList.add(new Word("mother","әṭa"));
        familyList.add(new Word("son","angsi"));
        familyList.add(new Word("daugher","tune"));
        familyList.add(new Word("older brother","taachi"));
        familyList.add(new Word("younger brother","chalitti"));
        familyList.add(new Word("older sister","teṭe"));
        familyList.add(new Word("younger sister","kolliti"));
        familyList.add(new Word("grandmother","ama"));
        familyList.add(new Word("grandfather","paapa"));

        /*
        * 添加一个ArrayAdapter（context，ArrayList<>）
        * 添加一个ListView
        * 绑定ArrayAdapter到ListView
        * */
        WordsAdapter itemsAdapter = new WordsAdapter(this, familyList);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);
    }
}
