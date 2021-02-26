package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.widget.ZoomButtonsController;


import com.example.myapplication.Fragments.BlueFragment;
import com.example.myapplication.Fragments.GreenFragment;
import com.example.myapplication.Fragments.RedFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager2 viewPager;
    TabLayout tabLayout;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        // PAGER
        pageAdapter = new PageAdapter(this);
        pageAdapter.addFragment(new RedFragment());
        pageAdapter.addFragment(new GreenFragment());
        pageAdapter.addFragment(new BlueFragment());
        viewPager.setAdapter(pageAdapter);
        viewPager.setPageTransformer(new DepthPageTransformer());

        // TOOLBAR
        setSupportActionBar(toolbar);

        // TAB LAYOUT
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("Red");
                    } else {
                        if (position == 1) {
                            tab.setText("Green");
                        } else {
                            if (position == 2) {
                                tab.setText("Blue");
                            }
                        }
                    }
                }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getWindow().setStatusBarColor(Color.RED);
                        toolbar.setBackgroundColor(Color.RED);
                        tabLayout.setBackgroundColor(Color.RED);
                        break;
                    case 1:
                        getWindow().setStatusBarColor(Color.GREEN);
                        toolbar.setBackgroundColor(Color.GREEN);
                        tabLayout.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        getWindow().setStatusBarColor(Color.BLUE);
                        toolbar.setBackgroundColor(Color.BLUE);
                        tabLayout.setBackgroundColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}