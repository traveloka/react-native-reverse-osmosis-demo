package com.reverseosmosisdemo.wrapperview;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;

public class WrapperView extends LinearLayout {
    private int mWidthMeasureSpec = MeasureSpec.UNSPECIFIED;
    private int mHeightMeasureSpec = MeasureSpec.UNSPECIFIED;

    public WrapperView(Context context) {
        super(context);
    }

    @Override
    public void requestLayout() {
        super.requestLayout();

        // workaround to trigger onMeasure when requestLayout invoked
        this.measure(mWidthMeasureSpec, mHeightMeasureSpec);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxWidth = 0;
        int maxHeight = 0;

        mWidthMeasureSpec = widthMeasureSpec;

        int widthSpec = mWidthMeasureSpec;
        int heightSpec = mHeightMeasureSpec;

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                child.measure(widthSpec, heightSpec);

                maxWidth = Math.max(maxWidth, child.getMeasuredWidth());
                maxHeight = Math.max(maxHeight, child.getMeasuredHeight());

                ThemedReactContext reactContext = (ThemedReactContext) getContext();
                reactContext.runOnNativeModulesQueueThread(() -> reactContext.getNativeModule(UIManagerModule.class).updateNodeSize(getId(), child.getMeasuredWidth(), child.getMeasuredHeight()));
            }
        }

        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());

        setMeasuredDimension(maxWidth, maxHeight);
    }
}
