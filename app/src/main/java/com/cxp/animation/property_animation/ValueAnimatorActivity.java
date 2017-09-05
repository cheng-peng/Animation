package com.cxp.animation.property_animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.cxp.animation.R;

/**
 * 文 件 名: ValueAnimatorActivity
 * 创 建 人: CXP
 * 创建日期: 2017-09-04 16:37
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 * AccelerateInterpolator 	 加速，开始时慢中间加速  	@android:anim/accelerate_interpolator
 * DecelerateInterpolator 	减速，开始时快然后减速 	@android:anim/decelerate_interpolator
 * AccelerateDecelerateInterolator　  	先加速后减速，开始结束时慢，中间加速  	@android:anim/accelerate_decelerate_interpolator
 * AnticipateInterpolator 	反向 ，先向相反方向改变一段再加速播放  	@android:anim/anticipate_interpolator
 * AnticipateOvershootInterpolator 	反向加超越，先向相反方向改变，再加速播放，会超出目的值然后缓慢移动至目的值 	@android:anim/anticipate_overshoot_interpolator
 * BounceInterpolator  	跳跃，快到目的值时值会跳跃，如目的值100，后面的值可能依次为85，77，70，80，90，100 	@android:anim/bounce_interpolator
 * CycleIinterpolator  	循环，动画循环一定次数，值的改变为一正弦函数：Math.sin(2* mCycles* Math.PI* input) 	@android:anim/cycle_interpolator
 * LinearInterpolator  	线性，线性均匀改变 	@android:anim/linear_interpolator
 * OvershootInterpolator 	超越，最后超出目的值然后缓慢改变到目的值 	@android:anim/overshoot_interpolator
 */
public class ValueAnimatorActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        tv = (TextView) findViewById(R.id.value_tv);
    }

    public void clickLis(View view) {
        //ofInt()、ofObject()、ofPropertyValuesHolder()函数，api 21之后又提供了ofArgb()
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 222222.222f);
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        //动画更新监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float money = (float) animation.getAnimatedValue();
                tv.setText(String.format("%.2f", money));
            }
        });
        valueAnimator.start();
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ValueAnimatorActivity.class);
        context.startActivity(intent);
    }
}
