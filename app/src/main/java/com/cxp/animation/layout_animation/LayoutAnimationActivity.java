package com.cxp.animation.layout_animation;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.cxp.animation.R;

import static android.animation.LayoutTransition.APPEARING;
import static android.animation.LayoutTransition.CHANGE_APPEARING;
import static android.animation.LayoutTransition.CHANGE_DISAPPEARING;
import static android.animation.LayoutTransition.DISAPPEARING;

/**
 * 文 件 名: LayoutAnimationActivity
 * 创 建 人: CXP
 * 创建日期: 2017-09-04 10:39
 * 描    述: 布局动画
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class LayoutAnimationActivity extends AppCompatActivity {

    private GridImageViewGroup mImageViewGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);

        //初始化视图
        initView();
    }

    //初始化视图
    private void initView() {
        setContentView(R.layout.activity_layout_animation);
        mImageViewGroup = (GridImageViewGroup) findViewById(R.id.image_layout);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImageView();
            }
        });
        mImageViewGroup.addView(imageView);

        //第一种动画实现： android:animateLayoutChanges="true"



//        APPEARING —— 元素在容器中显现时需要动画显示。
//        CHANGE_APPEARING —— 由于容器中要显现一个新的元素，其它元素的变化需要动画显示。
//        DISAPPEARING —— 元素在容器中消失时需要动画显示。
//        CHANGE_DISAPPEARING —— 由于容器中某个元素要消失，其它元素的变化需要动画显示。

        //第二种动画实现
        LayoutTransition mLayoutTransition = new LayoutTransition();

        //设置每个动画持续的时间
        mLayoutTransition.setStagger(CHANGE_APPEARING, 50);
        mLayoutTransition.setStagger(CHANGE_DISAPPEARING, 50);
        mLayoutTransition.setStagger(APPEARING, 50);
        mLayoutTransition.setStagger(DISAPPEARING, 50);

        PropertyValuesHolder appearingScaleX = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f);
        PropertyValuesHolder appearingScaleY = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f);
        PropertyValuesHolder appearingAlpha = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
        ObjectAnimator mAnimatorAppearing = ObjectAnimator.ofPropertyValuesHolder(this, appearingAlpha, appearingScaleX, appearingScaleY);
        //为LayoutTransition设置动画及动画类型
        mLayoutTransition.setAnimator(APPEARING, mAnimatorAppearing);


        PropertyValuesHolder disappearingAlpha = PropertyValuesHolder.ofFloat("alpha", 1f, 0f);
        PropertyValuesHolder disappearingRotationY = PropertyValuesHolder.ofFloat("rotationY", 0.0f, 90.0f);
        ObjectAnimator mAnimatorDisappearing = ObjectAnimator.ofPropertyValuesHolder(this, disappearingAlpha, disappearingRotationY);
        //为LayoutTransition设置动画及动画类型
        mLayoutTransition.setAnimator(DISAPPEARING, mAnimatorDisappearing);


        ObjectAnimator mAnimatorChangeDisappearing = ObjectAnimator.ofFloat(null, "alpha", 1f, 0f);
        //为LayoutTransition设置动画及动画类型
        mLayoutTransition.setAnimator(CHANGE_DISAPPEARING, mAnimatorChangeDisappearing);

        ObjectAnimator mAnimatorChangeAppearing = ObjectAnimator.ofFloat(null, "alpha", 1f, 0f);
        //为LayoutTransition设置动画及动画类型
        mLayoutTransition.setAnimator(CHANGE_APPEARING, mAnimatorChangeAppearing);

        //为mImageViewGroup设置mLayoutTransition对象
        mImageViewGroup.setLayoutTransition(mLayoutTransition);


    }

    public void addImageView() {
        final ImageView imageView = new ImageView(LayoutAnimationActivity.this);
        imageView.setImageResource(R.mipmap.ic_launcher_round);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageViewGroup.removeView(imageView);
            }
        });
        mImageViewGroup.addView(imageView, 0);
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LayoutAnimationActivity.class);
        context.startActivity(intent);
    }

}
