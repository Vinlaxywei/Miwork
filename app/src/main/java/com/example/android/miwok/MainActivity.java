package com.example.android.miwok;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 指定layout，其中包含一个ViewPager
        setContentView(R.layout.activity_main);

        // 调用ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.ViewPager);

        // 定义一个CategoryAdapter类型的对象，call adapter
        CategoryAdapter adapter = new CategoryAdapter(getBaseContext(),getSupportFragmentManager());

        // 设定适配器到ViewPager上
        viewPager.setAdapter(adapter);

        //调用TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.scrolTab);
        //绑定TabLayout和ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }

}
