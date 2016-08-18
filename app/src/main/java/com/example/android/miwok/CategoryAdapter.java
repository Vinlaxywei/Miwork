package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 自定义Adapter，继承自FragmentPagerAdapter。
 * 作为连接Activity和Fragment之间的适配器存在
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    //构造函数
    public CategoryAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /*
    * 设定滑动指定位置标签所显示的画面
    * @param position：当前位置。根据这个参数来返回相应视图
    * */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
        }
        return new NumbersFragment();
    }

    /*
    * @return 需要返回多少个视图
    * */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return mContext.getString(R.string.category_numbers);
            case 1:
                return mContext.getString(R.string.category_family);
            case 2:
                return mContext.getString(R.string.category_colors);
            case 3:
                return mContext.getString(R.string.category_phrases);
        }
        return "NULL";
    }
}

