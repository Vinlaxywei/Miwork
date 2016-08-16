package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);



        /*
        * 创建一个word类的数组，用于填充listview
        * @param 实参01：第一语言的单词、实参02：第二语言的单词、实参03：辅助识别图片
        * */
        ArrayList<Word> numberList = new ArrayList<Word>();
        numberList.add(new Word("one", getString(R.string.number_one), R.drawable.number_one,R.raw.number_one));
        numberList.add(new Word("two", getString(R.string.number_two), R.drawable.number_two));
        numberList.add(new Word("three", getString(R.string.number_three), R.drawable.number_three));
        numberList.add(new Word("four", getString(R.string.number_four), R.drawable.number_four));
        numberList.add(new Word("five", getString(R.string.number_five), R.drawable.number_five));
        numberList.add(new Word("six", getString(R.string.number_six), R.drawable.number_six));
        numberList.add(new Word("seven", getString(R.string.number_seven), R.drawable.number_seven));
        numberList.add(new Word("eight", getString(R.string.nember_eight), R.drawable.number_eight));
        numberList.add(new Word("nine", getString(R.string.number_nine), R.drawable.number_nine));
        numberList.add(new Word("ten", getString(R.string.number_ten), R.drawable.number_ten));

        /*
        * 添加一个WordAdapter（context，ArrayList<>,itemBackgoundResourceId）
        * 添加一个ListView
        * 绑定WordAdapter到ListView
        * */
        WordAdapter itemsAdapter = new WordAdapter(this, numberList, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer.create(getBaseContext(),R.raw.number_one).start();
            }
        });
    }

}
