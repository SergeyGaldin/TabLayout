package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.example.myapplication.Fragments.BlueFragment;
import com.example.myapplication.Fragments.GreenFragment;
import com.example.myapplication.Fragments.RedFragment;
import com.google.android.material.tabs.TabLayout;

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

        pageAdapter = new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new RedFragment(), "Red");
        pageAdapter.addFragment(new GreenFragment(), "Green");
        pageAdapter.addFragment(new BlueFragment(), "Blue");

        viewPager.setAdapter(pageAdapter);
    }
}