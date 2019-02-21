package model;

import android.view.View;
import android.widget.Button;

public class Animation {

    public void widgetAnimation(View widget){
        widget.animate().rotation(360).setDuration(4000);

    }

    public void buttonRotateXanimation(Button button){
        button.animate().rotationX(360).setDuration(400);
    }

    public void buttonRotateYanimation(View widget){
        widget.animate().rotationY(360).setDuration(400);
    }
}
