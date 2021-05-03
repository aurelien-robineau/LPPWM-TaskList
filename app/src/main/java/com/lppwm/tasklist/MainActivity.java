package com.lppwm.tasklist;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.lppwm.tasklist.ui.SectionsPagerAdapter;
import com.lppwm.tasklist.ui.tabs.PlanningTab;
import com.lppwm.tasklist.ui.tabs.TaskListTab;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tabs
        TaskListTab taskListTab = new TaskListTab(this);
        TaskListTab.setInstance(taskListTab);

//        PlanningTab planningTab = new PlanningTab(this);
//        PlanningTab.setInstance(planningTab);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}