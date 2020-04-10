package com.goldenbirds.gallery.program5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.goldenbirds.gallery.MyButton;
import com.goldenbirds.gallery.MyEditText;
import com.goldenbirds.gallery.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class P5Fragment1 extends Fragment {

    MyInterface i;
    public P5Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_p51, container, false);
            final MyEditText editText=v.findViewById(R.id.editext1);
            MyButton btn=v.findViewById(R.id.btn1);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String t=editText.getText().toString();
                    if(t.trim().equals("")){
                        editText.setError("Please enter text");
                    }
                    else{
                        i=(MyInterface)getActivity();
                        i.message(t);
                    }

                }
            });
            return  v;
    }
    public interface  MyInterface{
        public void message(String s);
    }
}
