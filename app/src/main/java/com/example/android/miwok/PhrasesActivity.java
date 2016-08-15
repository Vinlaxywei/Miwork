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
        phraseList.add(new Word("Where are you going?", "minto wuksus"));
        phraseList.add(new Word("What is you name?", "tinnә oyaase'nә"));
        phraseList.add(new Word("My name is...", "oyaaset..."));
        phraseList.add(new Word("How are you feeling", "michәksәs?"));
        phraseList.add(new Word("I’m feeling good", "kuchi achit"));
        phraseList.add(new Word("Are you coming?", "әәnәs'aa?"));
        phraseList.add(new Word("yes,I’m coming", "hәә’ әәnәm"));
        phraseList.add(new Word("I’m coming", "әәnәm"));
        phraseList.add(new Word("Let’s go", "yoowutis"));
        phraseList.add(new Word("Come here", "әnni'nem"));

        /*
        * 添加一个WordAdapter（context，ArrayList<>）
        * 添加一个ListView
        * 绑定WordAdapter到ListView
        * */
        WordAdapter itemsAdapter = new WordAdapter(this, phraseList);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);
    }
}
