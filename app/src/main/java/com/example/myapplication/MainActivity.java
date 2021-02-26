package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;


import com.example.myapplication.Fragments.BlueFragment;
import com.example.myapplication.Fragments.GreenFragment;
import com.example.myapplication.Fragments.RedFragment;
import com.google.android.material.tabs.TabLayout;

//https://www.youtube.com/watch?v=ltQMyvgIkMs
public class MainActivity extends AppCompatActivity {
    Toolbar toolbar, toolbarTab;
    ViewPager viewPager;
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
        toolbarTab = findViewById(R.id.toolbarTab);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        // PAGER
        pageAdapter = new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new RedFragment(), "Red");
        pageAdapter.addFragment(new GreenFragment(), "Green");
        pageAdapter.addFragment(new BlueFragment(), "Blue");
        viewPager.setAdapter(pageAdapter);

        // TOOLBAR
        setSupportActionBar(toolbar);

        // TAB LAYOUT
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getWindow().setStatusBarColor(Color.RED);
                        toolbar.setBackgroundColor(Color.RED);
                        toolbarTab.setBackgroundColor(Color.RED);
                        tabLayout.setBackgroundColor(Color.RED);
                        break;
                    case 1:
                        getWindow().setStatusBarColor(Color.GREEN);
                        toolbar.setBackgroundColor(Color.GREEN);
                        toolbarTab.setBackgroundColor(Color.GREEN);
                        tabLayout.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        getWindow().setStatusBarColor(Color.BLUE);
                        toolbar.setBackgroundColor(Color.BLUE);
                        toolbarTab.setBackgroundColor(Color.BLUE);
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