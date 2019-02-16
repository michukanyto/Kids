package com.appsmontreal.kids;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radioGroupOrientationOption;
    int radioButtonId;
    Button buttonGo;
    Button buttonExit;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize(){
        radioGroupOrientationOption = (RadioGroup)findViewById(R.id.radioGroupOrientationOption);
        buttonExit = (Button)findViewById(R.id.buttonExit);
        buttonGo = (Button)findViewById(R.id.buttonGo);
        buttonGo.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
        radioButtonId = 0;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonGo:
                radioButtonId = radioGroupOrientationOption.getCheckedRadioButtonId();
                intent = new Intent(this,MathActivity.class);
                switch(radioButtonId){
                    case R.id.radioButtonLanscape:
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                        break;

                    case R.id.radioButtonPortrait:
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        break;
                }

                startActivity(intent);
                break;

            case R.id.buttonExit:
                finish();
                break;
        }


    }


}
