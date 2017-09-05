package com.cxp.animation.layout_animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.cxp.animation.R;

/**
 * 文 件 名: GridImageViewGroup
 * 创 建 人: CXP
 * 创建日期: 2017-09-04 17:07
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class GridImageViewGroup extends ViewGroup {
    private int childVerticalSpace = 0;
    private int childHorizontalSpace = 0;
    private int columnNum = 3;
    private int childWidth = 0;
    private int childHeight = 0;


    public GridImageViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.GridImageViewGroup);
        if (attributes != null) {
            childVerticalSpace = attributes.getDimensionPixelSize(R.styleable.GridImageViewGroup_childVerticalSpace, 0);
            childHorizontalSpace = attributes.getDimensionPixelSize(R.styleable.GridImageViewGroup_childHorizontalSpace, 0);
            columnNum = attributes.getInt(R.styleable.GridImageViewGroup_columnNum, 3);
            attributes.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int rw = MeasureSpec.getSize(widthMeasureSpec);
        int rh = MeasureSpec.getSize(heightMeasureSpec);
        int childCount = getChildCount();
        if (childCount > 0) {
            childWidth = (rw - (columnNum - 1) * childHorizontalSpace) / columnNum;

            childHeight = childWidth;

            int vw = rw;
            if (childCount < columnNum) {
                vw = childCount * (childHeight + childVerticalSpace);
            }
            int rowCount = childCount / columnNum + (childCount % columnNum != 0 ? 1 : 0);

            int vh = rowCount * childHeight + (rowCount > 0 ? rowCount - 1 : 0) * childVerticalSpace;

            setMeasuredDimension(vw, vh);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 0;
        int top = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            left = (i % columnNum) * (childWidth + childHorizontalSpace);
            top = (i / columnNum) * (childHeight + childVerticalSpace);
            child.layout(left, top, left + childWidth, top + childHeight);
        }
    }
}