package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private String LOG_TAG = ColorsActivity.class.getSimpleName();
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
                //播放语音前先释放内存，这样做当用户点击多个item时会释放上一个语音
                releaseMediaPlayer();

                Word word = colorList.get(position);
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
