package com.goldenbirds.gallery.program1;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.goldenbirds.gallery.program1.Fragments.FragmentCenter;
import com.goldenbirds.gallery.program1.Fragments.FragmentCenterCrop;
import com.goldenbirds.gallery.program1.Fragments.FragmentCenterInside;
import com.goldenbirds.gallery.program1.Fragments.FragmentfitCenter;
import com.goldenbirds.gallery.program1.Fragments.FragmentfitEnd;
import com.goldenbirds.gallery.program1.Fragments.FragmentfitStart;
import com.goldenbirds.gallery.program1.Fragments.FragmentfitXY;
import com.goldenbirds.gallery.program1.Fragments.Fragmentmatrix;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    Uri Imagepath ;
    public static final int FRAGMENT_COUNt = 8;

    public ViewPagerAdapter(@NonNull FragmentManager fm, Uri path) {

        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        Imagepath=path;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position) {
            case 0:
                f = new FragmentCenter(Imagepath);
                break;
            case 1:
                f = new FragmentCenterCrop(Imagepath);
                break;
            case 2:
                f = new FragmentCenterInside(Imagepath);
                break;
            case 3:
                f = new FragmentfitCenter(Imagepath);
                break;
            case 4:
                f = new FragmentfitEnd(Imagepath);
                break;
            case 5:
                f = new FragmentfitStart(Imagepath);
                break;
            case 6:
                f = new FragmentfitXY(Imagepath);
                break;
            case 7:
                f = new Fragmentmatrix(Imagepath);
                break;
        }
        //
        return f;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNt;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return new String("" + (position + 1));
    }
}
