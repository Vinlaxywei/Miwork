package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hhoo7 on 2016/8/15.
 */
public class WordsAdapter extends ArrayAdapter<Word> {

    public WordsAdapter(Activity context, ArrayList<Word> word) {
        super(context, 0, word);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        //检查item如果是空的，则进行填充
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.word_list_item, parent,false);
        }

        /*
        * 填充item
        *
        * @param textView01第一语言
        * @param textView02第二语言
        * */
        Word currenWord = getItem(position);
        TextView textView01 = (TextView) listItemView.findViewById(R.id.list_item_textview01);
        textView01.setText(currenWord.getFirstLanguage());
        TextView textView02 = (TextView) listItemView.findViewById(R.id.list_item_textview02);
        textView02.setText(currenWord.getSecondtLanguage());

        return listItemView;
    }
}

