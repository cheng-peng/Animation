package com.cxp.animation.property_animation;


import android.animation.TypeEvaluator;

/**
 * 文 件 名: TextArgbEvaluator
 * 创 建 人: CXP
 * 创建日期: 2017-09-04 17:00
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class TextArgbEvaluator implements TypeEvaluator {

    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int startInt = (Integer) startValue;
        int startA = (startInt >> 24) & 0xff;
        int startR = (startInt >> 16) & 0xff;
        int startG = (startInt >> 8) & 0xff;
        int startB = startInt & 0xff;

        int endInt = (Integer) endValue;
        int endA = (endInt >> 24) & 0xff;
        int endR = (endInt >> 16) & 0xff;
        int endG = (endInt >> 8) & 0xff;
        int endB = endInt & 0xff;

        return (int) ((startA + (int) (fraction * (endA - startA))) << 24) |
                (int) ((startR + (int) (fraction * (endR - startR))) << 16) |
                (int) ((startG + (int) (fraction * (endG - startG))) << 8) |
                (int) ((startB + (int) (fraction * (endB - startB))));
    }
}