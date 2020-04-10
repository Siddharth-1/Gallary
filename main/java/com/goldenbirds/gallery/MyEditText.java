package com.goldenbirds.gallery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;


public class MyEditText extends AppCompatEditText
{
    Drawable clearButton, clearButton1;

    public MyEditText(Context context) {
        super(context);
        init();
    }

    public MyEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init()
    {
        clearButton = ResourcesCompat.getDrawable(getResources(),
                R.drawable.ic_clear_black_24dp,null);
        clearButton1 = ResourcesCompat.getDrawable(getResources(),
                R.drawable.ic_clear_opacblack_24dp, null);

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                showButton();
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                float clearButtonstart;

                boolean isclicked = false;

                clearButtonstart = getWidth() - getPaddingEnd() - clearButton.getIntrinsicWidth();

                if(motionEvent.getX() > clearButtonstart)
                {
                    isclicked = true;
                }
                if(isclicked) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            getText().clear();
                            break;
                        case MotionEvent.ACTION_UP:
                            hideButton();
                            break;
                    }
                }
                return false;
            }
        });
    }

    void showButton()
    {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,
                clearButton,null);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    void hideButton()
    {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,
                clearButton1,null);
    }
}