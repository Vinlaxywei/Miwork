package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        /*
        * 创建一个word类的数组，用于填充listview
        * @param 实参01：第一语言的单词、实参02：第二语言的单词、实参03：辅助识别图片
        * */
        ArrayList<Word> phraseList = new ArrayList<Word>();
        phraseList.add(new Word("Where are you going?", getString(R.string.where_are_you_going)));
        phraseList.add(new Word("What is you name?", getString(R.string.what_is_you_name)));
        phraseList.add(new Word("My name is...", getString(R.string.my_name_is)));
        phraseList.add(new Word("How are you feeling", getString(R.string.how_are_you_feeling)));
        phraseList.add(new Word("I’m feeling good", getString(R.string.im_feeeling_good)));
        phraseList.add(new Word("Are you coming?", getString(R.string.are_you_coming)));
        phraseList.add(new Word("yes,I’m coming", getString(R.string.yes_im_coming)));
        phraseList.add(new Word("I’m coming", getString(R.string.im_coming)));
        phraseList.add(new Word("Let’s go", getString(R.string.lets_go)));
        phraseList.add(new Word("Come here", getString(R.string.come_here)));

        /*
        * 添加一个WordAdapter（context，ArrayList<>）
        * 添加一个ListView
        * 绑定WordAdapter到ListView
        * */
        WordAdapter itemsAdapter = new WordAdapter(this, phraseList,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);
    }
}
