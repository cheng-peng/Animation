package com.cxp.animation.custom_anim.custom_path;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 文 件 名: AnimatorPath
 * 创 建 人: CXP
 * 创建日期: 2017-09-05 10:57
 * 描    述: 客户端使用类,记录一系列的不同移动轨迹
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class AnimatorPath {

    //一系列的轨迹记录动作
    private List<PathPoint> mPoints = new ArrayList<>();


    /**
     * 移动位置到:
     *
     * @param x
     * @param y
     */
    public void moveTo(float x, float y) {
        mPoints.add(PathPoint.moveTo(x, y));
    }

    /**
     * 直线移动
     *
     * @param x
     * @param y
     */
    public void lineTo(float x, float y) {
        mPoints.add(PathPoint.lineTo(x, y));
    }

    /**
     * 二阶贝塞尔曲线移动
     *
     * @param c0X
     * @param c0Y
     * @param x
     * @param y
     */
    public void secondBesselCurveTo(float c0X, float c0Y, float x, float y) {
        mPoints.add(PathPoint.secondBesselCurveTo(c0X, c0Y, x, y));
    }

    /**
     * 三阶贝塞尔曲线移动
     *
     * @param c0X
     * @param c0Y
     * @param c1X
     * @param c1Y
     * @param x
     * @param y
     */
    public void thirdBesselCurveTo(float c0X, float c0Y, float c1X, float c1Y, float x, float y) {
        mPoints.add(PathPoint.thirdBesselCurveTo(c0X, c0Y, c1X, c1Y, x, y));
    }

    /**
     * @return 返回移动动作集合
     */
    public Collection<PathPoint> getPoints() {
        return mPoints;
    }


}
