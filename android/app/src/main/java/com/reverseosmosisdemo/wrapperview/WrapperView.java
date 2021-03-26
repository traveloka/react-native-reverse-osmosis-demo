package com.reverseosmosisdemo.wrapperview;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;

import java.lang.ref.WeakReference;

public class WrapperView extends LinearLayout {
    private WeakReference<UIManagerModule> _uiManagerModule;

    public WrapperView(Context context) {
        super(context);

        _uiManagerModule = new WeakReference<>(((ThemedReactContext)getContext()).getNativeModule(UIManagerModule.class));
    }

    private UIManagerModule getUIManagerModule() {
        return _uiManagerModule.get();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestLayout();
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
        post(measureAndLayout);
    }

    private final Runnable measureAndLayout = () -> {
        measure(
            MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.EXACTLY));
        layout(getLeft(), getTop(), getLeft() + getMeasuredWidth(), getTop() + getMeasuredHeight());
    };

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                child.measure(widthMeasureSpec, MeasureSpec.UNSPECIFIED);

                maxWidth = Math.max(maxWidth, child.getMeasuredWidth());
                maxHeight = Math.max(maxHeight, child.getMeasuredHeight());
            }
        }

        int finalWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        int finalHeight = Math.max(maxHeight, getSuggestedMinimumHeight());

        setMeasuredDimension(finalWidth, finalHeight);
        ((ThemedReactContext)getContext()).runOnNativeModulesQueueThread(() -> getUIManagerModule().updateNodeSize(getId(), finalWidth, finalHeight));
    }
}
