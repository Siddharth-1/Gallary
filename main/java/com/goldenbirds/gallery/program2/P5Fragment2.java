package com.goldenbirds.gallery.program5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goldenbirds.gallery.R;


public class P5Fragment2 extends Fragment {
    String s="";
    public P5Fragment2() {
        // Required empty public constructor
    }
    //get the string from interface
    public P5Fragment2(String st){
        s=st;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_p52, container, false);
        TextView textView=v.findViewById(R.id.textView);
        textView.setText(s);
        return v;
    }
}
