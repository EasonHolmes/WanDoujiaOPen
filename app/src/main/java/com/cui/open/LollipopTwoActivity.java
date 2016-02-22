package com.cui.open;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * Created by cuiyang on 16/2/19.
 */
public class LollipopTwoActivity extends BaseActivity {


    private ImageView imgMove, background_layout;
    private final int normal_duration = 700;
    private int normal_delay = 50;
    private int set_delay = 200;

    //传入的位置
    private float Px;
    private float Py;
    //目标位置
    private float Tx;
    private float Ty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lolloipop_two);
        super.initToolbar();
        imgMove = (ImageView) findViewById(R.id.img_move);
        background_layout = (ImageView) findViewById(R.id.background_layout);
        Px = getIntent().getFloatExtra("px", 0);
        Py = getIntent().getFloatExtra("py", 0);
        mToolbar.setVisibility(View.INVISIBLE);

        setLayout(imgMove, (int) Px, (int) Py);
        setLayout(background_layout, 0, (int) Py - 100);
        Tx = getDeviceWidth(this) / 3 + 40 - Px;
        Ty = Py - 100;

        Picasso.with(this).load(R.mipmap.accout_img).placeholder(R.mipmap.accout_img).into(imgMove);
        ObjectAnimator objectAnimatorX = new ObjectAnimator().ofFloat(imgMove, "translationX", 0, Tx);
        ObjectAnimator objectAnimatorY = new ObjectAnimator().ofFloat(imgMove, "translationY", 0, -Ty);
        ObjectAnimator objectAnimatorL = new ObjectAnimator().ofFloat(background_layout, "scaleY", 1f, 15f);
        objectAnimatorL.setStartDelay(normal_delay);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(objectAnimatorX, objectAnimatorY, objectAnimatorL);
        set.setDuration(normal_duration);
        set.setStartDelay(set_delay);
        set.setInterpolator(new AccelerateInterpolator());
        set.start();
    }

    @SuppressWarnings("deprecation")
    private int getDeviceWidth(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        return manager.getDefaultDisplay().getWidth();
    }

    private void setLayout(View view, int x, int y) {
        FrameLayout.MarginLayoutParams margin = new FrameLayout.MarginLayoutParams(view.getLayoutParams());
        margin.setMargins(x, y, x + margin.width, y + margin.height);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(margin);
        view.setLayoutParams(layoutParams);
    }
}
