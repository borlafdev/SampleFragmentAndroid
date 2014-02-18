package com.astraliss.samplefragmentandroid;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	Boolean fragment;
	FragmentManager fm;
	FragmentTransaction ft;	
	Fragment1 f1;
	Fragment2 f2;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textView1);
		f1 = new Fragment1();
		f2 = new Fragment2();
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.setCustomAnimations(
				R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
		ft.replace(R.id.MainFragment, f1, "");
		ft.commit();
		fragment = false;
	}

	public void changeFragment(){
		ft = fm.beginTransaction();
		if(fragment){
			ft.setCustomAnimations(
					R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
			ft.replace(R.id.MainFragment, f1, "");
			ft.commit();
		}else{
			ft.setCustomAnimations(
					R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
			ft.replace(R.id.MainFragment, f2, "");
			ft.commit();
		}
	}

	public void setTex(String text){
		tv.setText(text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onMenuItemClick(MenuItem item) {
		changeFragment();
		fragment = (fragment) ? false : true;
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.changef:
			changeFragment();
			fragment = (fragment) ? false : true;
			break;
		}
		 return super.onOptionsItemSelected(item);
	}



}
