package com.goldenbirds.gallery.program5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.goldenbirds.gallery.R;

public class P5Activity extends AppCompatActivity implements  P5Fragment1.MyInterface{
    FragmentManager fm;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5);
         fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
      fragment =new P5Fragment1();
        ft.add(R.id.framelayout,fragment,"First");
        ft.commit();
    }

    @Override
    public void message(String s) {

        FragmentManager fm=getSupportFragmentManager();
        fm.beginTransaction().remove(fragment).commit();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.framelayout,new P5Fragment2(s),"Second");

        ft.commit();
    }
}
