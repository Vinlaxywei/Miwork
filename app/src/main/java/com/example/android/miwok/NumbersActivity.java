package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private String LOG_TAG = NumbersActivity.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    /*
    * 定义一个全局的Mediaplayer.OncompletionListener，便于Item调用
    * 执行：调用releaseMediaPlayer方法释放内存
    * */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    /*
    * 定义一个全局的AudioManager.OnAudioFocusChangListener，便于Item调用
    * 执行：判断当前音频焦点，根据各种情况对应出不同的操作
    * */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //实例化mAudioManager
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        /*
        * 定义一个word类的数组，用于填充listview
        * @param 实参01：第一语言的单词、实参02：第二语言的单词、实参03：辅助识别图片、实参04：辅助识别语音
        * */
        final ArrayList<Word> numberList = new ArrayList<Word>();
        numberList.add(new Word("one", getString(R.string.number_one), R.drawable.number_one, R.raw.number_one));
        numberList.add(new Word("two", getString(R.string.number_two), R.drawable.number_two, R.raw.number_two));
        numberList.add(new Word("three", getString(R.string.number_three), R.drawable.number_three, R.raw.number_three));
        numberList.add(new Word("four", getString(R.string.number_four), R.drawable.number_four, R.raw.number_four));
        numberList.add(new Word("five", getString(R.string.number_five), R.drawable.number_five, R.raw.number_five));
        numberList.add(new Word("six", getString(R.string.number_six), R.drawable.number_six, R.raw.number_six));
        numberList.add(new Word("seven", getString(R.string.number_seven), R.drawable.number_seven, R.raw.number_seven));
        numberList.add(new Word("eight", getString(R.string.nember_eight), R.drawable.number_eight, R.raw.number_eight));
        numberList.add(new Word("nine", getString(R.string.number_nine), R.drawable.number_nine, R.raw.number_nine));
        numberList.add(new Word("ten", getString(R.string.number_ten), R.drawable.number_ten, R.raw.number_ten));

        /*
        * 添加一个WordAdapter（上下文，数据数组,背景图片Id,）
        * 添加一个ListView
        * 绑定WordAdapter到ListView
        * */
        WordAdapter itemsAdapter = new WordAdapter(this, numberList, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);

        /*
        * listview设定item点击事件监听器
        * */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /*
            * @param parent：当前的ListView
            * @param view：当前的item中的对应的布局，在此findViewById对布局中的视图进行操作
            * @param position：当前item所对应的数据的位置
            * @param id：Adapter会为每一个item设置id
            * */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //播放语音前先释放内存，这样做当用户点击多个item时会释放上一个语音
                releaseMediaPlayer();
                //定义一个word类，便于获取辅助识别语音id
                Word word = numberList.get(position);

                /*
                * 定义int类型对象result，用于申请音频焦点
                * 判断：当前如果拥有音频焦点，则播放辅助识别语音和后续释放资源等操作
                * */
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    /*
                    * 获取数据数组的当前位置，根据当前位置的word类提取语音资源ID，加载到mMediaPlayer中
                    * */
                    mMediaPlayer = MediaPlayer.create(getBaseContext(), word.getVoiceResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
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

            //放弃音频焦点
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    /*
    * 当用户焦点不在此Activity时，释放内存
    * */
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
