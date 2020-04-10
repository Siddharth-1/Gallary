package com.goldenbirds.gallery;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.goldenbirds.gallery.program1.ViewPagerAdapter;
import com.goldenbirds.gallery.program4.P4Activity;
import com.goldenbirds.gallery.program5.P5Activity;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    ViewPager viewPager;
    com.google.android.material.tabs.TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.selectimage:
                //checking for storage permissiion
                int MyVersion = Build.VERSION.SDK_INT;
                if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
                    if (!checkIfAlreadyhavePermission()) {
                        requestForSpecificPermission();
                    } else {

                        //open to select image
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        Intent i = new Intent(Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(i, REQUEST_CODE);
                    }
                }
                break;
            case R.id.program4:
                startActivity(new Intent(MainActivity.this, P4Activity.class));
                break;
            case R.id.program5:
                startActivity( new Intent(MainActivity.this, P5Activity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //storage checking func
    private boolean checkIfAlreadyhavePermission() {//to check if already have permission
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    //to request for permission
    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
    }

    //get the permisission result
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //granted
                    //open to choose image
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    Intent i = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, REQUEST_CODE);

                } else {
                    //not granted
                    Toast.makeText(getApplicationContext(), "Storage permission is required to fetch image", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    //handle result set it to the view pager adapter
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Log.i("req" + requestCode, "" + resultCode);
        if (requestCode == REQUEST_CODE) {
            //image recieved add to pager

            if (resultCode == Activity.RESULT_OK) {

                Uri selectedImageUri = data.getData();
                viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), selectedImageUri);
                viewPager.setAdapter(viewPagerAdapter);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }
}
