package com.cxp.animation.frame_animation;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.cxp.animation.R;

/**
 * 文 件 名: FrameAniationActivity
 * 创 建 人: CXP
 * 创建日期: 2017-09-04 10:42
 * 描    述: 逐帧动画
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class FrameAniationActivity extends AppCompatActivity {

    private ImageView frameImg;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化视图
        initView();
    }

    //初始化视图
    private void initView() {
        setContentView(R.layout.activity_frame_animation);
        frameImg = (ImageView) findViewById(R.id.frame_img);

        //动画开始
        animationDrawable = (AnimationDrawable) frameImg.getDrawable();

        //false为循环播放，true为仅播放一次
//        animationDrawable.setOneShot(false);

        //是否正在播放
//        animationDrawable.isRunning();

        // 添加一帧，并设置该帧显示的持续时间
//        animationDrawable.addFrame();

    }

    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.frame_start:
                //开始动画
                animationDrawable.start();
                break;
            case R.id.frame_stop:
                //停止动画
                animationDrawable.stop();
                break;
        }
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, FrameAniationActivity.class);
        context.startActivity(intent);
    }
}
