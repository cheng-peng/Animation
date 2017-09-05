package com.cxp.animation.custom_anim.demo3;

import android.animation.TimeInterpolator;

/**
 * 文 件 名: MyInterpolator
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 16:49
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class MyInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        if (input<=0.3){
            return input;
        }
        return 1;
    }
}
