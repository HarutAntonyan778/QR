package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ZoomOutTransformation implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.65f;
    private static final float MIN_ALPHA = 0.3f;


    @Override
    public void transformPage(@NonNull View view, float v) {
        if (v <-1){  // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        }
        else if (v <=1){ // [-1,1]

            view.setScaleX(Math.max(MIN_SCALE,1-Math.abs(v)));
            view.setScaleY(Math.max(MIN_SCALE,1-Math.abs(v)));
            view.setAlpha(Math.max(MIN_ALPHA,1-Math.abs(v)));

        }
        else {  // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);

        }
    }
}