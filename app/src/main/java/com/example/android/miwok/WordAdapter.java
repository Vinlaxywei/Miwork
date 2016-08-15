package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hhoo7 on 2016/8/15.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> word) {
        super(context, 0, word);
    }

    /*
    * @param position 当前item位置
    * @param convertView 当前传入的view
    * @param parent 目标listview
    * */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        /*
        * 检查item如果是空的，则创建一个新的word_list_item进行填充，填充到目标parent
        * */
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.word_list_item, parent, false);
        }

        /*
        * 填充item
        *
        * @param textView01第一语言
        * @param textView02第二语言
        * @param imageView 辅助图片
        * */
        Word currenWord = getItem(position);
        TextView textView01 = (TextView) listItemView.findViewById(R.id.list_item_textview01);
        textView01.setText(currenWord.getFirstLanguage());
        TextView textView02 = (TextView) listItemView.findViewById(R.id.list_item_textview02);
        textView02.setText(currenWord.getSecondtLanguage());
        if (currenWord.getImageResourceId() != 0) {
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_imageview);
            imageView.setImageResource(currenWord.getImageResourceId());
        }
        return listItemView;
    }
}

