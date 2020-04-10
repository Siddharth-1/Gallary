package com.goldenbirds.gallery.program1.Fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.goldenbirds.gallery.R;

public class FragmentfitStart extends Fragment {
    ImageView imageView;

    Uri path;
    public FragmentfitStart (){
        // Required empty public constructor
    }
    public  FragmentfitStart(Uri p){path=p;}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_fragmentfit_start, container, false);
        imageView=rootView.findViewById(R.id.imageview);
        imageView.setImageURI(path);
        return rootView;
    }
}
