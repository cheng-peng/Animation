package com.cxp.animation.custom_anim.demo1;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/**
 * 文 件 名: PointEvaluator
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 16:00
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        int x = (int) (startPoint.x + fraction * (endPoint.x - startPoint.x));
        int y = (int) (startPoint.y + fraction * (endPoint.y - startPoint.y));
        Point point = new Point(x, y);
        return point;
    }
}
