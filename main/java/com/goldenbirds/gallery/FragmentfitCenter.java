package com.goldenbirds.gallery.program1.Fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.goldenbirds.gallery.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentfitCenter#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentfitCenter extends Fragment {
    ImageView imageView;
    Uri path;
    public FragmentfitCenter() {
        // Required empty public constructor
    }
    public  FragmentfitCenter(Uri p){
        path=p;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_fragmentfit_center, container, false);
        imageView=rootView.findViewById(R.id.imageview);
        imageView.setImageURI(path);
        return rootView;
    }
}
