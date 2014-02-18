package com.astraliss.samplefragmentandroid;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment2 extends Fragment implements OnClickListener {
	Activity activity;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment2,container, false);
		Button btn = (Button) view.findViewById(R.id.btnf2);
		btn.setOnClickListener(this);
		activity = getActivity();
		return view;
	}

	@Override
	public void onClick(View v) {
		((MainActivity)activity).setTex("Fragment 2 button pressed");

	}


} 