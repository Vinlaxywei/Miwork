package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsFragment extends Fragment {
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

    public ColorsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> colorList = new ArrayList<Word>();
        colorList.add(new Word("red", getString(R.string.color_red), R.drawable.color_red, R.raw.color_red));
        colorList.add(new Word("green", getString(R.string.color_green), R.drawable.color_green, R.raw.color_green));
        colorList.add(new Word("brown", getString(R.string.color_brown), R.drawable.color_brown, R.raw.color_brown));
        colorList.add(new Word("gray", getString(R.string.color_gray), R.drawable.color_gray, R.raw.color_gray));
        colorList.add(new Word("black", getString(R.string.color_black), R.drawable.color_black, R.raw.color_black));
        colorList.add(new Word("white", getString(R.string.color_white), R.drawable.color_white, R.raw.color_white));
        colorList.add(new Word("dusty yellow", getString(R.string.color_dusty_yellow), R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorList.add(new Word("mustart yellow", getString(R.string.color_mustart_yellow), R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), colorList, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.word_listview);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //播放语音前先释放内存，这样做当用户点击多个item时会释放上一个语音
                releaseMediaPlayer();
                //定义一个word类，便于获取辅助识别语音id
                Word word = colorList.get(position);

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
    }
}
