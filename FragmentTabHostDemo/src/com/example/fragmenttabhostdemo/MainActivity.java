package com.example.fragmenttabhostdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.fragmenttabhostdemo.bean.Tab;
import com.example.fragmenttabhostdemo.fragment.HomeFragment;
import com.example.fragmenttabhostdemo.fragment.SettingsFragment;
import com.example.fragmenttabhostdemo.fragment.TodayFragment;
import com.example.fragmenttabhostdemo.fragment.TomorrowFragment;


public class MainActivity extends ActionBarActivity {
	
	private FragmentTabHost tabHost ;
	private LayoutInflater inflat;
	private List<Tab> list = new ArrayList<Tab>(4);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        inflat = LayoutInflater.from(this);
        
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        
        
        
        Tab home = new Tab(R.drawable.nav_aqi,R.string.home, HomeFragment.class);
        Tab today = new Tab(R.drawable.nav_today, R.string.today,TodayFragment.class);
        Tab tomorrow = new Tab(R.drawable.nav_tomorrow_default, R.string.tomorrow,TomorrowFragment.class);
        Tab setting = new Tab(R.drawable.nav_setting_default, R.string.setting,SettingsFragment.class);
        
        list.add(home);
        list.add(today);
        list.add(tomorrow);
        list.add(setting);
        
        for (Tab tab : list) {
        	
        	View view= inflat.inflate(R.layout.indicator, null);
            ImageView iamge = (ImageView) view.findViewById(R.id.image);
            iamge.setBackgroundResource(tab.getImage());
            tabHost.addTab(tabHost.newTabSpec(getString(tab.getTag())).setIndicator(view), tab.getFragment(), null);
		}
    }
    
}
