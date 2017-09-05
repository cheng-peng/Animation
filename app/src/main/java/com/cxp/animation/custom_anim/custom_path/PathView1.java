package com.cxp.animation.custom_anim.custom_path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 文 件 名: PathView
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 11:14
 * 描   述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class PathView1 extends View {

    private Paint paint;

    public PathView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //防抖动
        paint.setDither(true);
        //设置画笔未实心
        paint.setStyle(Paint.Style.STROKE);
        //设置颜色
        paint.setColor(Color.GREEN);
        //设置画笔宽度
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        path.cubicTo(100, 100, 1000, 200,1000, 1200);
        canvas.drawPath(path, paint);
    }

}
