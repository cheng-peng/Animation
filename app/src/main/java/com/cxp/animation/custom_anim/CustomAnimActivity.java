package com.cxp.animation.custom_anim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cxp.animation.R;
import com.cxp.animation.custom_anim.custom_path.CustomPathActivity;
import com.cxp.animation.custom_anim.demo1.CustomAnimDemo1Activity;
import com.cxp.animation.custom_anim.demo2.CustomAnimDemo2Activity;
import com.cxp.animation.custom_anim.demo3.CustomAnimDemo3Activity;
import com.cxp.animation.custom_anim.fabulous_anim.FabulousAnimActivity;
import com.cxp.animation.custom_anim.wave_anim.WaveAnimActivity;

/**
 * 文 件 名: CustomAnimDemo2Activity
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 15:50
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class CustomAnimActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_anim);
        mContext = this;
    }

    //单击事件
    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.custom_anim1:
                //自定义动画demo1
                CustomAnimDemo1Activity.startActivity(mContext);
                break;
            case R.id.custom_anim2:
                //自定义动画demo2
                CustomAnimDemo2Activity.startActivity(mContext);
            case R.id.custom_anim3:
                //自定义动画demo3
                CustomAnimDemo3Activity.startActivity(mContext);
                break;
            case R.id.custom_path_anim:
                //自定义路径动画
                CustomPathActivity.startActivity(mContext);
                break;
            case R.id.fabulous_anim:
                //点赞动画
                FabulousAnimActivity.startActivity(mContext);
                break;
            case R.id.wave_anim:
                //波浪动画
                WaveAnimActivity.startActivity(mContext);
                break;
        }
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CustomAnimActivity.class);
        context.startActivity(intent);
    }
}
