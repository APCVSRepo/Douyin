package com.ford.douyin.Style3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ZoomCenterLayoutManager extends LinearLayoutManager {

    // Shrink the cards around the center up to 50%
    private final float mShrinkAmount = 0.5f;
    // The cards will be at 50% when they are 75% of the way between the
    // center and the edge.
    private final float mShrinkDistance = 0.75f;

    private boolean isFirstMeasure = true;
    private int itemHeight = 0;
    private int itemWidth = 0;



    public ZoomCenterLayoutManager(Context context) {
        super(context);
    }

    public ZoomCenterLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public ZoomCenterLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrolled = super.scrollHorizontallyBy(dx, recycler, state);

        float midpoint = getWidth() / 2.f;
        float d0 = 0.f;
        float d1 = mShrinkDistance * midpoint;
        float s0 = 1.f;
        float s1 = 1.f - mShrinkAmount;

        for (int i = 0; i < getChildCount(); i++) {

            Log.d("ChildCount", getChildCount()+"");

            View child = getChildAt(i);

            float childMidpoint =
                    (getDecoratedRight(child) + getDecoratedLeft(child)) / 2.f;
            float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
//            float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
//            scale*=1.5;
            float scale = 1.5f;

//            if (getChildCount() != 0 && isFirstMeasure){
//                itemHeight = child.getHeight();
//                itemWidth = child.getWidth();
//                isFirstMeasure = false;
//            }

            if (Math.abs(midpoint - childMidpoint) < 200){
                child.setScaleX(scale);
                child.setScaleY(scale);
            }else {
                child.setScaleX(1);
                child.setScaleY(1);
            }
        }

        return scrolled;
    }




    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        scrollVerticallyBy(0, recycler, state);
    }
}
