package com.goldenbirds.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
        init();
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public  void init()
    {
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                boolean isClicked = false;

                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        setWidth((int) (getWidth()+1000));
                        break;
                    case MotionEvent.ACTION_UP:
                        setWidth(getWidth()-1000);
                        break;
                }
                return false;
            }
        });
    }
}
