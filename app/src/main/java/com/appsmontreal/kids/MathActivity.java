package com.appsmontreal.kids;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MathActivity extends AppCompatActivity implements View.OnClickListener {

    int[] numbers = {R.drawable.zero,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine};
    int[] numbers1 = {R.drawable.zero1,R.drawable.one1,R.drawable.two1,R.drawable.three1,R.drawable.four1,R.drawable.five1,R.drawable.six1,R.drawable.seven1,R.drawable.eight1,R.drawable.nine1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
//        initialize();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        switch (newConfig.orientation){
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_math);
                break;

            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_math);
                break;
        }
    }
}
