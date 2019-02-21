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
import android.widget.Toast;

import model.Animation;
import model.Sound;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radioGroupOrientationOption;
    int radioButtonId;
    Button buttonGo;
    Button buttonExit;
    Intent intent;
    String orientation;
    Animation animate;
    Sound play;

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
        animate = new Animation();
        play = new Sound(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonGo:
                if (radioGroupOrientationOption.getCheckedRadioButtonId() != -1){
                    animate.buttonRotateXanimation(buttonGo);
                    play.soundGoForward();
                    radioButtonId = radioGroupOrientationOption.getCheckedRadioButtonId();
                    intent = new Intent(this, MathActivity.class);
//                Configuration orientation = new Configuration();

                    switch (radioButtonId) {
                        case R.id.radioButtonLanscape:
//                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                        orientation.orientation = Configuration.ORIENTATION_LANDSCAPE;
//                        intent.putExtra("orientation",orientation);
                            orientation = "LANDSCAPE";
                            intent.putExtra("orientation", orientation);
//                        intent = new Intent(this,MathActivity.class);
//                        startActivity(intent);
                            break;

                        case R.id.radioButtonPortrait:
//                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                            orientation = "PORTRAIT";
                            intent.putExtra("orientation", orientation);
//                        intent = new Intent(this,MathActivity.class);
//                        startActivity(intent);
                            break;
                    }

                    startActivity(intent);
                    break;
                }else{
                    Toast.makeText(this,"Please select an operation",Toast.LENGTH_LONG).show();
                    play.soundError();
                    break;
            }
            case R.id.buttonExit:
                animate.buttonRotateXanimation(buttonExit);
                play.soundExit();
                finish();
                break;
        }


    }


//    getResources().getConfiguration().orientation


}
