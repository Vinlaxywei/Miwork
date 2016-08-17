package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private String LOG_TAG = FamilyActivity.class.getSimpleName();
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

        final ArrayList<Word> familyList = new ArrayList<Word>();
        familyList.add(new Word("father", getString(R.string.family_father), R.drawable.family_father,R.raw.family_father));
        familyList.add(new Word("mother", getString(R.string.family_mother), R.drawable.family_mother,R.raw.family_mother));
        familyList.add(new Word("son", getString(R.string.family_son), R.drawable.family_son,R.raw.family_son));
        familyList.add(new Word("daugher", getString(R.string.family_daugher), R.drawable.family_daughter,R.raw.family_daughter));
        familyList.add(new Word("older brother", getString(R.string.family_older_brother), R.drawable.family_older_brother,R.raw.family_older_brother));
        familyList.add(new Word("younger brother", getString(R.string.family_younger_brother), R.drawable.family_younger_brother,R.raw.family_younger_brother));
        familyList.add(new Word("older sister", getString(R.string.family_older_sister), R.drawable.family_older_sister,R.raw.family_older_sister));
        familyList.add(new Word("younger sister", getString(R.string.family_younger_sister), R.drawable.family_younger_sister,R.raw.family_younger_sister));
        familyList.add(new Word("grandmother", getString(R.string.family_granmother), R.drawable.family_grandmother,R.raw.family_grandfather));
        familyList.add(new Word("grandfather", getString(R.string.family_grandfather), R.drawable.family_father,R.raw.family_grandmother));

        WordAdapter itemsAdapter = new WordAdapter(this, familyList,R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //播放语音前先释放内存，这样做当用户点击多个item时会释放上一个语音
                releaseMediaPlayer();

                Word word = familyList.get(position);
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
