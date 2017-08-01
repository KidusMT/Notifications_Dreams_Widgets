package com.kidusmt.android.lifeoutsideourapp;

import android.os.Handler;
import android.service.dreams.DreamService;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by KidusMT on 7/31/2017.
 */

public class FirstDreamService extends DreamService {

    ImageView im;
    TextView tv_dream;
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Exit dream upon user touch
        setInteractive(false);
        // Hide system UI
        setFullscreen(true);
        // Set the dream layout
        setContentView(R.layout.layout_dream);

    }

    int mThumbIds[] = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4
    };

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
        im = (ImageView) findViewById(R.id.dream_image);
        tv_dream = (TextView) findViewById(R.id.tv_dream);

        final Handler handler = new Handler();//with out this it's impossible to handle the
        // change in because it should be in the UI thread to change the UI first
        Runnable runnable = new Runnable() {
            int i=0;
            public void run() {
                //this is for starting animation for the fade in and fade out effect
                Animation fadeIn = AnimationUtils.loadAnimation(FirstDreamService.this, R.anim.fade_in);
                im.startAnimation(fadeIn);
                //for repeatedly changing the image
                im.setImageResource(mThumbIds[i]);
                switch (i){
                    case 1:
                        tv_dream.setText("NBA start!");
                        break;
                    case 2:
                        tv_dream.setText("Breath Taking beautiful! - Emma Watson!");
                        break;
                    case 3:
                        tv_dream.setText("Greatest hacker of all time! ;) - Anonymous!");
                        break;
                    default:
                        tv_dream.setText("Just Saying HI!");
                        break;
                }
//                fadeIn.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                        //this is for the fadeout animation
////                        Animation fadeOut = AnimationUtils.loadAnimation(FirstDreamService.this, R.anim.fade_out);
////                        im.startAnimation(fadeOut);
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//                });
                i++;
                if(i>mThumbIds.length-1)
                {
                    i=0;
                }
                handler.postDelayed(this, 3000);  //for interval...
            }
        };
        handler.postDelayed(runnable, 2000); //for initial delay..
    }

}
