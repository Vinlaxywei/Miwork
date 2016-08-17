package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
        final ArrayList<Word> colorList = new ArrayList<Word>();
        colorList.add(new Word("red", getString(R.string.color_red), R.drawable.color_red,R.raw.color_red));
        colorList.add(new Word("green", getString(R.string.color_green), R.drawable.color_green,R.raw.color_green));
        colorList.add(new Word("brown", getString(R.string.color_brown), R.drawable.color_brown,R.raw.color_brown));
        colorList.add(new Word("gray", getString(R.string.color_gray), R.drawable.color_gray,R.raw.color_gray));
        colorList.add(new Word("black", getString(R.string.color_black), R.drawable.color_black,R.raw.color_black));
        colorList.add(new Word("white", getString(R.string.color_white), R.drawable.color_white,R.raw.color_white));
        colorList.add(new Word("dusty yellow", getString(R.string.color_dusty_yellow), R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colorList.add(new Word("mustart yellow", getString(R.string.color_mustart_yellow), R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this, colorList,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = colorList.get(position);
                MediaPlayer.create(getBaseContext(),word.getVoiceResourceId()).start();
            }
        });
    }
}
