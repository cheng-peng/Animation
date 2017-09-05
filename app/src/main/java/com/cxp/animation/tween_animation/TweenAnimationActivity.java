package com.cxp.animation.tween_animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.cxp.animation.R;

/**
 * 文 件 名: TweenAnimationActivity
 * 创 建 人: CXP
 * 创建日期: 2017-09-04 10:39
 * 描    述: 补间动画
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 * AccelerateInterpolator 加速，开始时慢中间加速
 * DecelerateInterpolator 减速，开始时快然后减速
 * AccelerateDecelerateInterolator 先加速后减速，开始结束时慢，中间加速
 * AnticipateInterpolator 反向，先向相反方向改变一段再加速播放
 * AnticipateOvershootInterpolator 反向加超越，先向相反方向改变，再加速播放，会超出目的值然后缓慢移动至目的值
 * BounceInterpolator 跳跃，快到目的值时值会跳跃，如目的值100，后面的值可能依次为85，77，70，80，90，100
 * CycleIinterpolator 循环，动画循环一定次数，值的改变为一正弦函数：Math.sin(2* mCycles* Math.PI* input)
 * LinearInterpolator 线性，线性均匀改变
 * OvershootInterpolator超越，最后超出目的值然后缓慢改变到目的值
 */
public class TweenAnimationActivity extends AppCompatActivity {

    private ImageView alphaImg;
    private ImageView scaleImg;
    private ImageView rotateImg;
    private ImageView translateImg;
    private ImageView setImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化视图
        initView();
    }

    //初始化视图
    private void initView() {

        setContentView(R.layout.activity_tween_animation);
        alphaImg = (ImageView) findViewById(R.id.tween_alpha_img);
        scaleImg = (ImageView) findViewById(R.id.tween_scale_img);
        rotateImg = (ImageView) findViewById(R.id.tween_rotate_img);
        translateImg = (ImageView) findViewById(R.id.tween_translate_img);
        setImg = (ImageView) findViewById(R.id.tween_set_img);

        //alpha渐变透明度动画效果
        alphaAnim();

        //scale渐变尺寸缩放动画效果
        scaleAnim();

        //rotate画面旋转动画效果
        rotateAnim();

        //translate画面位置移动动画效果
        translateAnim();

        //set组合动画效果
        setAnim();
    }

    /**
     * alpha渐变透明度动画效果
     */
    private void alphaAnim() {
        //引入方式
//        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_tween_alpha);
//        alphaImg.startAnimation(alphaAnimation);

        //Java 方式
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);  //参数：开始透明度，结束透明度
        alphaAnimation.setDuration(1000);//设置动画持续时间为500毫秒
        alphaAnimation.setFillAfter(false);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
        alphaImg.startAnimation(alphaAnimation);
    }

    /**
     * scale渐变尺寸缩放动画效果
     */
    private void scaleAnim() {
        //引入方式
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_tween_scale);
        scaleImg.startAnimation(scaleAnimation);

        //Java 方式
//        Animation scaleAnimation = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        scaleAnimation.setDuration(1000);//设置动画持续时间为500毫秒
//        scaleAnimation.setFillAfter(true);//如果fillAfter的值为true,则动画执行后，控件将停留在执行结束的状态
//        scaleAnimation.setFillBefore(false);//如果fillBefore的值为true，则动画执行后，控件将回到动画执行之前的状态
//        scaleAnimation.setRepeatCount(3);//设置动画循环次数
//        scaleAnimation.setRepeatMode(Animation.REVERSE);
//        scaleAnimation.setStartOffset(0);
//        scaleAnimation.setInterpolator(this, android.R.anim.decelerate_interpolator);//设置动画插入器
//        scaleImg.startAnimation(scaleAnimation);
    }

    /**
     * rotate画面旋转动画效果
     */
    private void rotateAnim() {
        //引入方式
//        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_tween_rotate);
//        rotateImg.startAnimation(rotateAnimation);

        //Java 方式
        Animation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);//设置动画持续时间为500毫秒
        rotateAnimation.setFillAfter(true);//如果fillAfter的值为true,则动画执行后，控件将停留在执行结束的状态
        rotateAnimation.setInterpolator(this, android.R.anim.accelerate_decelerate_interpolator);//设置动画插入器
        rotateImg.startAnimation(rotateAnimation);
    }

    /**
     * translate画面位置移动动画效果
     */
    private void translateAnim() {
        //引入方式
//        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_tween_translate);
//        translateImg.startAnimation(translateAnimation);

        //Java 方式
        Animation translateAnimation = new TranslateAnimation(0, 100, 0, 0);
        translateAnimation.setDuration(1000);
        translateAnimation.setInterpolator(this, android.R.anim.decelerate_interpolator);//设置动画插入器
        translateAnimation.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
        translateImg.startAnimation(translateAnimation);

        //动画监听
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始时调用
                Log.e("CXP", "动画开始时调用");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束时调用
                Log.e("CXP", "动画结束时调用");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复时调用
                Log.e("CXP", "动画重复时调用");
            }
        });

    }


    /**
     * set组合动画效果
     */
    private void setAnim() {
        //引入方式
//        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.anim_tween_set);
//        setImg.startAnimation(animationSet);

        //Java 方式
        AnimationSet animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaAnimation.setDuration(1000);//设置动画持续时间为500毫秒
        Animation scaleAnimation = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);//设置动画持续时间为500毫秒
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setStartOffset(0);
        scaleAnimation.setInterpolator(this, android.R.anim.decelerate_interpolator);//设置动画插入器
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        setImg.startAnimation(animationSet);
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, TweenAnimationActivity.class);
        context.startActivity(intent);
    }

}
