package com.appsmontreal.kids;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Random;

import model.Animation;
import model.Mathematic;
import model.Sound;

public class MathActivity extends AppCompatActivity implements View.OnClickListener {

    int[] numbers = {R.drawable.zero,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine};

    String orientation;
    int indexNumber1;
    int indexNumber2;
    ImageView imageViewNumber1;
    ImageView imageViewNumber2;
    ImageView imageViewOperator;
    ImageView imageViewResult;
    Button buttonStart;
    Button buttonCheck;
    EditText editTextResult;
    Random random = new Random();
    Animation animate;
    Sound play;
    Mathematic calculation;
    boolean operator;
    boolean result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        orientation = (String)getIntent().getExtras().getSerializable("orientation");

        if (orientation.equals("LANDSCAPE")) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            operator = false;

        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            operator = true;

        }
        initialize();

    }

    //    getResources().getConfiguration().orientation

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        switch (newConfig.orientation){
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_math);
                initialize();
                break;

            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_math);
                initialize();
                break;
        }

    }


    private void initialize(){
        indexNumber1 = 0;
        indexNumber2 = 0;
        imageViewNumber1 = (ImageView) findViewById(R.id.imageViewNumber1);
        imageViewNumber2 = (ImageView) findViewById(R.id.imageViewNumber2);
        imageViewOperator = (ImageView) findViewById(R.id.imageViewOperator);
        imageViewResult = (ImageView) findViewById(R.id.imageViewResult);
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonCheck = (Button) findViewById(R.id.buttonCheck);
        buttonStart.setOnClickListener(this);
        buttonCheck.setOnClickListener(this);
        editTextResult = (EditText) findViewById(R.id.editTextResult);
        animate = new Animation();
        calculation = new Mathematic(operator);
        editTextResult.setText("0");
        imageViewResult.setImageResource(R.drawable.sleep);
        play = new Sound(this);


     }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonStart:
                animate.buttonRotateXanimation(buttonStart);
                startGame();
                initialize();
                break;

            case R.id.buttonCheck:
                animate.buttonRotateXanimation(buttonCheck);
                checkGame();
                break;
        }
        play.soundGoForward();
    }

    private void startGame(){
        CountDownTimer countDownTimer = new CountDownTimer(5000,150) {
            @Override
            public void onTick(long millisUntilFinished) {
                indexNumber1 = random.nextInt(numbers.length);
                animate.widgetAnimation(imageViewNumber1);
                imageViewNumber1.setImageResource(numbers[indexNumber1]);
                indexNumber2 = random.nextInt(numbers.length);
                animate.widgetAnimation(imageViewNumber2);
                imageViewNumber2.setImageResource(numbers[indexNumber2]);

            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();

    }

    private void checkGame(){
        String userAnswer = editTextResult.getText().toString();
        result = calculation.makeOperation(indexNumber1,indexNumber2,Integer.parseInt(userAnswer));
        Toast.makeText(this,Boolean.toString(result) ,Toast.LENGTH_SHORT).show();

        if(result) {
            imageViewResult.setImageResource(R.drawable.smile);
            play.soundOkAnswer();
        }else{
            imageViewResult.setImageResource(R.drawable.nosmile);
            play.soundWrongAnswer();
        }

    }



}
