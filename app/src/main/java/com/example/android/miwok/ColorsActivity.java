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
        * 创建一个word类的数组，用于填充listview
        * @param 实参01：第一语言的单词、实参02：第二语言的单词、实参03：辅助识别图片
        * */
        ArrayList<Word> colorList = new ArrayList<Word>();
        colorList.add(new Word("red", "weṭeṭṭi", R.drawable.color_red));
        colorList.add(new Word("green", "chokokki", R.drawable.color_green));
        colorList.add(new Word("brown", "ṭakaakki", R.drawable.color_brown));
        colorList.add(new Word("gray", "ṭopoppi", R.drawable.color_gray));
        colorList.add(new Word("black", "kululli", R.drawable.color_black));
        colorList.add(new Word("white", "kelelli", R.drawable.color_white));
        colorList.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        colorList.add(new Word("mustart yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));

        /*
        * 添加一个WordAdapter（context，ArrayList<>）
        * 添加一个ListView
        * 绑定WordAdapter到ListView
        * */
        WordAdapter itemsAdapter = new WordAdapter(this, colorList);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);
    }
}
