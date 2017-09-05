package com.cxp.animation.property_animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cxp.animation.R;

/**
 * 文 件 名: PropertyAnimationActivity
 * 创 建 人: CXP
 * 创建日期: 2017-09-04 10:39
 * 描    述: 属性动画
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class PropertyAnimationActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化视图
        initView();
    }

    //初始化视图
    private void initView() {
        setContentView(R.layout.activity_property_animation);
        mContext=this;

    }

    //单击事件
    public void clickLis(View view){
        switch (view.getId()) {
            case R.id.property_object:
                ObjectAnimatorActivity.startActivity(mContext);
                break;
            case R.id.property_value:
                ValueAnimatorActivity.startActivity(mContext);
                break;

        }
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, PropertyAnimationActivity.class);
        context.startActivity(intent);
    }

}
