package com.cxp.animation.custom_anim.demo1;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 文 件 名: MyAnimView
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 15:56
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class MyAnimView extends View {

    //半径
    public static final int radius = 50;

    private Point currentPoint;

    private Paint mPaint;

    public MyAnimView(Context context) {
        this(context,null);
    }

    public MyAnimView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyAnimView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new Point(radius, radius);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        float x = currentPoint.x;
        float y = currentPoint.y;
        canvas.drawCircle(x, y, radius, mPaint);
    }

    private void startAnimation() {
        Point startPoint = new Point(radius, radius);
        Point endPoint = new Point(getWidth() - radius, getHeight() - radius);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setDuration(5000);
        anim.start();
    }
}
