package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        /*
        * 创建一个word类的数组，word类由两个String组成，用于填充item中的两个TextView。
        * 构造函数中第一个实参是第一语言的单词，相应的第二个实参是第二语言的单词
        * */
        ArrayList<Word> colorList = new ArrayList<Word>();
        colorList.add(new Word("red","weṭeṭṭi"));
        colorList.add(new Word("green","chokokki"));
        colorList.add(new Word("brown","ṭakaakki"));
        colorList.add(new Word("gray","ṭopoppi"));
        colorList.add(new Word("black","kululli"));
        colorList.add(new Word("white","kelelli"));
        colorList.add(new Word("dusty yellow","ṭopiisә"));
        colorList.add(new Word("mustart yellow","chiwiiṭә"));

        /*
        * 添加一个ArrayAdapter（context，ArrayList<>）
        * 添加一个ListView
        * 绑定ArrayAdapter到ListView
        * */
        WordsAdapter itemsAdapter = new WordsAdapter(this, colorList);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);
    }
}
