package com.cxp.animation.custom_anim.custom_path;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.cxp.animation.R;

/**
 * 文 件 名: CustomPathActivity
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 10:29
 * 描    述: 自定义运动路径
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class CustomPathActivity extends AppCompatActivity {

    private ImageView img;

    private AnimatorPath path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_path);

        img = (ImageView) findViewById(R.id.custom_path_img);

        setPath();

    }

    /*设置动画路径*/
    public void setPath() {
        path = new AnimatorPath();
        path.moveTo(0,0);
        path.lineTo(400, 400);
        path.secondBesselCurveTo(600, 200, 800, 400);
        path.thirdBesselCurveTo(100, 600, 900, 1000, 200, 1200);
    }

    /*设置动画路径*/
//    public void setPath() {
//
//        path = new AnimatorPath();
//        path.moveTo(0,0);
//        path.thirdBesselCurveTo(100, 100,1000, 200,1000, 1200);
//    }

    /**
     * 设置动画
     *
     * @param view
     * @param propertyName
     * @param path
     */
    private void startAnimatorPath(View view, String propertyName, AnimatorPath path) {
        ObjectAnimator anim = ObjectAnimator.ofObject(this, propertyName, new PathEvaluator(), path.getPoints().toArray());
        anim.setInterpolator(new DecelerateInterpolator());//动画插值器
        anim.setDuration(3000);
        anim.start();
    }

    /**
     * 设置View的属性通过ObjectAnimator.ofObject() 的反射机制来调用
     *
     * @param newLoc
     */

    public void setImg(PathPoint newLoc) {
        img.setTranslationX(newLoc.mX);
        img.setTranslationY(newLoc.mY);
    }

    public void clickLis(View view) {
        startAnimatorPath(img, "img", path);
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CustomPathActivity.class);
        context.startActivity(intent);
    }
}
