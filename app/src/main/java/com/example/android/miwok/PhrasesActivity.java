package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private String LOG_TAG = PhrasesActivity.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        /*
        * 创建一个word类的数组，用于填充listview
        * @param 实参01：第一语言的单词、实参02：第二语言的单词、实参03：辅助识别图片
        * */
        final ArrayList<Word> phraseList = new ArrayList<Word>();
        phraseList.add(new Word("Where are you going?", getString(R.string.where_are_you_going), R.raw.phrase_where_are_you_going));
        phraseList.add(new Word("What is you name?", getString(R.string.what_is_you_name), R.raw.phrase_what_is_your_name));
        phraseList.add(new Word("My name is...", getString(R.string.my_name_is), R.raw.phrase_my_name_is));
        phraseList.add(new Word("How are you feeling", getString(R.string.how_are_you_feeling), R.raw.phrase_how_are_you_feeling));
        phraseList.add(new Word("I’m feeling good", getString(R.string.im_feeeling_good), R.raw.phrase_im_feeling_good));
        phraseList.add(new Word("Are you coming?", getString(R.string.are_you_coming), R.raw.phrase_are_you_coming));
        phraseList.add(new Word("yes,I’m coming", getString(R.string.yes_im_coming), R.raw.phrase_yes_im_coming));
        phraseList.add(new Word("I’m coming", getString(R.string.im_coming), R.raw.phrase_im_coming));
        phraseList.add(new Word("Let’s go", getString(R.string.lets_go), R.raw.phrase_lets_go));
        phraseList.add(new Word("Come here", getString(R.string.come_here), R.raw.phrase_come_here));

        WordAdapter itemsAdapter = new WordAdapter(this, phraseList, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //播放语音前先释放内存，这样做当用户点击多个item时会释放上一个语音
                releaseMediaPlayer();

                Word word = phraseList.get(position);
                mMediaPlayer = MediaPlayer.create(getBaseContext(), word.getVoiceResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /*
    * 当用户点击item时播放辅助识别语音，播放完毕后调用此方法释放内存
    * if判断语音是否为空，如果不为空，则执行释放内存操作，并将语音设为空
    * */
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
