package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        /*
        * 创建一个word类的数组，word类由两个String组成，用于填充item中的两个TextView。
        * 构造函数中第一个实参是第一语言的单词，相应的第二个实参是第二语言的单词
        * */
        ArrayList<Word> numberList = new ArrayList<Word>();
        numberList.add(new Word("one","lutti"));
        numberList.add(new Word("two","otiiko"));
        numberList.add(new Word("two","tolookosu"));
        numberList.add(new Word("four","oyyisa"));
        numberList.add(new Word("five","massokka"));
        numberList.add(new Word("six","temmokka"));
        numberList.add(new Word("seven","kenekaku"));
        numberList.add(new Word("eight","kawinta"));
        numberList.add(new Word("nine","wo’e"));
        numberList.add(new Word("ten","na’aacha"));

        /*
        * 添加一个ArrayAdapter（context，ArrayList<>）
        * 添加一个ListView
        * 绑定ArrayAdapter到ListView
        * */
        WordsAdapter itemsAdapter = new WordsAdapter(this, numberList);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);
    }

}
