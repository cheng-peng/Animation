package com.cxp.animation.custom_anim.fabulous_anim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cxp.animation.R;

/**
 * 文 件 名: FabulousAnimActivity
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 17:06
 * 描    述: 点赞动画
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class FabulousAnimActivity extends AppCompatActivity {

    private PeriscopeLayout mPeriscopeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabulous_anim);
        mPeriscopeLayout = (PeriscopeLayout) findViewById(R.id.fabulous_periscope);

    }

    //单击事件
    public void clickLis(View view) {
        mPeriscopeLayout.addHeart();
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, FabulousAnimActivity.class);
        context.startActivity(intent);
    }

}
