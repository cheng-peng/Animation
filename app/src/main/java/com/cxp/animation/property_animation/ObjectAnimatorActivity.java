package com.cxp.animation.property_animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.cxp.animation.R;

/**
 * 文 件 名: ObjectAnimatorActivity
 * 创 建 人: CXP
 * 创建日期: 2017-09-04 15:51
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class ObjectAnimatorActivity extends AppCompatActivity {

    private ImageView alphaImg;
    private ImageView scaleImg;
    private ImageView rotationImg;
    private ImageView translationImg;
    private ImageView setImg;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化视图
        initView();
    }

    //初始化视图
    private void initView() {
        setContentView(R.layout.activity_object_animator);
        alphaImg = (ImageView) findViewById(R.id.object_alpha_img);
        scaleImg = (ImageView) findViewById(R.id.object_scale_img);
        rotationImg = (ImageView) findViewById(R.id.object_rotation_img);
        translationImg = (ImageView) findViewById(R.id.object_translation_img);
        setImg = (ImageView) findViewById(R.id.object_set_img);

        //alpha渐变透明度动画效果
        alphaAnim();

        //scale渐变尺寸缩放动画效果
        scaleAnim();

        //rotation画面旋转动画效果
        rotationAnim();

        //translation画面位置移动动画效果
        translationAnim();

        //set组合动画效果
        setAnim();


    }

    /**
     * alpha渐变透明度动画效果
     */
    private void alphaAnim() {
        //引入方式
//        Animator alphaAnimation = AnimatorInflater.loadAnimator(this, R.animator.animator_object_alpha);
//        alphaAnimation.setTarget(alphaImg);
//        alphaAnimation.start();

        //Java方式
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(alphaImg, "alpha", 0f, 1f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(0);
        alphaAnimation.setRepeatMode(ValueAnimator.REVERSE);
        alphaAnimation.setStartDelay(200);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.start();
    }

    /**
     * scale渐变尺寸缩放动画效果
     */
    private void scaleAnim() {
        //引入方式
//        Animator scaleXAnimator = AnimatorInflater.loadAnimator(this, R.animator.animator_object_scale);
//        scaleXAnimator.setTarget(scaleImg);
//        scaleXAnimator.start();

        //Java 方式
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(scaleImg, "scaleY", 1f, 1.5f);
        scaleXAnimator.setDuration(1000);
        scaleXAnimator.setRepeatCount(0);
        scaleXAnimator.setRepeatMode(ValueAnimator.REVERSE);
        scaleXAnimator.start();
    }

    /**
     * rotation画面旋转动画效果
     */
    private void rotationAnim() {
        //引入方式
//        Animator objectAnimator = AnimatorInflater.loadAnimator(this, R.animator.animator_object_rotation);
//        objectAnimator.setTarget(rotationImg);
//        objectAnimator.start();

        //Java 方式
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(rotationImg, "rotation", 0f, 360f);
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatCount(1);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();
    }

    /**
     * translation画面位置移动动画效果
     */
    private void translationAnim() {
        //引入方式
        Animator objectAnimator = AnimatorInflater.loadAnimator(this, R.animator.animator_object_translation);
        objectAnimator.setTarget(translationImg);
        objectAnimator.start();

//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(translationImg, "translationX", 0f, 100f);
//        objectAnimator.setDuration(1000);
//        objectAnimator.setRepeatCount(1);
//        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        objectAnimator.start();
    }

    /**
     * set组合动画效果
     */
    private void setAnim() {
        //引入方式
//        Animator anim = AnimatorInflater.loadAnimator(this, R.animator.animator_object_set);
//        anim.setTarget(setImg);
//
//        //动画监听
//        anim.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                //TODO 动画开始前的操作
//                Log.e("CXP","动画开始前的操作");
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                //TODO 动画结束的操作
//                Log.e("CXP","动画结束的操作");
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//                //TODO 动画取消的操作
//                Log.e("CXP","动画取消的操作");
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//                //TODO 动画重复的操作
//                Log.e("CXP","动画重复的操作");
//            }
//        });
//
//        anim.start();


        //Java 方式
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(setImg, "scaleY", 1f, 1.5f);
        scaleYAnimator.setDuration(1000);
        scaleYAnimator.setRepeatCount(1);
        scaleYAnimator.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(setImg, "scaleX", 1f, 0.5f);
        scaleXAnimator.setDuration(1000);
        scaleXAnimator.setRepeatCount(1);
        scaleXAnimator.setRepeatMode(ValueAnimator.REVERSE);
        scaleXAnimator.start();
        //同时执行动画
//      animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
        //after(Animator anim) 将现有动画插入到传入的动画之后执行
        //after(long delay) 将现有动画延迟指定毫秒后执行
        //before(Animator anim) 将现有动画插入到传入的动画之前执行
        //with(Animator anim) 将现有动画和传入的动画同时执行
        animatorSet.play(scaleYAnimator).after(scaleXAnimator);
//        animatorSet.start();


        //第二种方法
//        PropertyValuesHolder scaleXValuesHolder = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.5f);
//        PropertyValuesHolder scaleYValuesHolder = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.5f);
//        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(setImg, scaleXValuesHolder, scaleYValuesHolder);
//        objectAnimator.setDuration(1000);
//        objectAnimator.setRepeatCount(1);
//        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        objectAnimator.start();
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ObjectAnimatorActivity.class);
        context.startActivity(intent);
    }
}
