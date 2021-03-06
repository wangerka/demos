package com.example.fragmenttabhostdemo.fragment;

import com.example.fragmenttabhostdemo.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class BaseFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment, null);
		TextView text = (TextView) view.findViewById(R.id.text);
		setText(text);
		return view;
	}
	
	
	abstract void setText(TextView text);
}

