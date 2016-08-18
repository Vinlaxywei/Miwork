package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesFragment extends Fragment {
    private String LOG_TAG = "PhrasesFragment";
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

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

    public PhrasesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), phraseList, R.color.category_phrases);
        ListView listView = (ListView) rootView.findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //播放语音前先释放内存，这样做当用户点击多个item时会释放上一个语音
                releaseMediaPlayer();
                //定义一个word类，便于获取辅助识别语音id
                Word word = phraseList.get(position);

                /*
                * 定义int类型对象result，用于申请音频焦点
                * 判断：当前如果拥有音频焦点，则播放辅助识别语音和后续释放资源等操作
                * */
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    /*
                    * 获取数据数组的当前位置，根据当前位置的word类提取语音资源ID，加载到mMediaPlayer中
                    * */
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getVoiceResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }

    /*
    * 当用户点击item时播放辅助识别语音，播放完毕后调用此方法释放内存
    * if判断语音是否为空，如果不为空，则执行释放内存操作，并将语音设为空
    * */
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(getActivity());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
        Log.d(LOG_TAG, "onStop");
    }

}
