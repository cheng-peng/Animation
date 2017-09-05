package com.cxp.animation.custom_anim.wave_anim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cxp.animation.R;

/**
 * 文 件 名: WaveAnimActivity
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 18:33
 * 描    述: 波浪动画
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class WaveAnimActivity extends AppCompatActivity {

    private MyView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_anim);
        view= (MyView) findViewById(R.id.wave_view);
        view.startAnim();
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, WaveAnimActivity.class);
        context.startActivity(intent);
    }
}
