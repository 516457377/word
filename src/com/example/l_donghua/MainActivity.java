package com.example.l_donghua;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.l_donghua.XEditText.DrawableLeftListener;

public class MainActivity extends Activity {
	private TextView textView;
	int i = 0;
	private XEditText editText;

	// private SwitchLayout switchLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.but_1);
		textView = (TextView) findViewById(R.id.tex);
		editText=(XEditText) findViewById(R.id.editText1);
		editText.setDrawableLeftListener(new DrawableLeftListener() {

			@Override
			public void onDrawableLeftClick(View view) {
				Toast.makeText(MainActivity.this, "显示左边", 1000).show();
			}
		});
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// SwitchLayout.getSlideFromRight(this, false, null);
				if (i % 2 == 0) {
					textView.setVisibility(View.VISIBLE);
					Animation animation = AnimationUtils.loadAnimation(
							MainActivity.this, R.anim.open);
					textView.setAnimation(animation);
				} else {
					textView.setVisibility(View.GONE);
					Animation animation = AnimationUtils.loadAnimation(
							MainActivity.this, R.anim.close);
					textView.setAnimation(animation);
				}

				i++;
			}
		});
	}
}
