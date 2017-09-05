package com.cxp.animation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cxp.animation.custom_anim.CustomAnimActivity;
import com.cxp.animation.frame_animation.FrameAniationActivity;
import com.cxp.animation.layout_animation.LayoutAnimationActivity;
import com.cxp.animation.property_animation.PropertyAnimationActivity;
import com.cxp.animation.tween_animation.TweenAnimationActivity;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

    }

    //单击事件
    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.main_tween:
                //补间动画
                TweenAnimationActivity.startActivity(mContext);
                break;
            case R.id.main_frame:
                //逐帧动画
                FrameAniationActivity.startActivity(mContext);
                break;
            case R.id.main_property:
                //属性动画
                PropertyAnimationActivity.startActivity(mContext);
                break;
            case R.id.main_layout:
                //布局动画
                LayoutAnimationActivity.startActivity(mContext);
                break;
            case R.id.main_custom:
                //自定义动画
                CustomAnimActivity.startActivity(mContext);
                break;

        }
    }
}
