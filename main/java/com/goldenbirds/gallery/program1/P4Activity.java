package com.goldenbirds.gallery.program4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.goldenbirds.gallery.MyButton;
import com.goldenbirds.gallery.MyEditText;
import com.goldenbirds.gallery.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4Activity extends AppCompatActivity {

    MyEditText editText;
    MyButton savebtn,showbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4);
    editText=findViewById(R.id.input_et);
    savebtn=findViewById(R.id.save_btn);
    showbtn=findViewById(R.id.show_btn);

    savebtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text=editText.getText().toString();
            if(text.trim().equals("")){
                editText.setError("Please enter text");
            }
            else{
                try {
                    FileOutputStream fout=P4Activity.this.openFileOutput("app.txt",MODE_PRIVATE);
                    fout.write(text.getBytes());
                    Log.i("content",""+text+""+fout);
                    fout.close();
                    Toast.makeText(P4Activity.this, "Data Saved Succesfuuly", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    });


    showbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            StringBuilder stringBuilder = new StringBuilder();

            try {
                FileInputStream fin =P4Activity.this.openFileInput("app.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fin);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                    String line = reader.readLine();
                    while (line != null) {
                        stringBuilder.append(line).append('\n');
                        line = reader.readLine();
                    }

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                String contents = stringBuilder.toString();
                Toast.makeText(P4Activity.this, ""+contents, Toast.LENGTH_SHORT).show();
            }

        }
    });

    }
}
