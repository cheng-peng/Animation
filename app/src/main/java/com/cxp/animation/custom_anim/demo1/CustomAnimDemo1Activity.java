package com.cxp.animation.custom_anim.demo1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cxp.animation.R;

/**
 * 文 件 名: CustomAnimDemo2Activity
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 15:55
 * 描    述: 自定义动画
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class CustomAnimDemo1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_anim_demo1);
    }


    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CustomAnimDemo1Activity.class);
        context.startActivity(intent);
    }
}
