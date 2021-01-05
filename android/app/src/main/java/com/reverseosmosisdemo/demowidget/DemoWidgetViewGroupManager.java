package com.reverseosmosisdemo.demowidget;

import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;

public class DemoWidgetViewGroupManager extends ViewGroupManager<DemoWidget> {
    @NonNull
    @Override
    public String getName() {
        return "DemoWidget";
    }

    @NonNull
    @Override
    protected DemoWidget createViewInstance(@NonNull ThemedReactContext reactContext) {
        DemoWidget demoWidget = new DemoWidget(reactContext);
        updateSize(reactContext, demoWidget);
        demoWidget.setListener(new DemoWidgetListener() {
            @Override
            public void onToggleClick() {
                updateSize(reactContext, demoWidget);
            }
        });
        return demoWidget;
    }

    private void updateSize(ThemedReactContext reactContext, DemoWidget widget) {
        reactContext.runOnUiQueueThread(() -> {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            reactContext.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

            int widthSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, View.MeasureSpec.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            widget.measure(widthSpec, heightSpec);

            int width = widget.getMeasuredWidth();
            int height = widget.getMeasuredHeight();
            reactContext.runOnNativeModulesQueueThread(() -> reactContext.getNativeModule(UIManagerModule.class).updateNodeSize(widget.getId(), width, height));
        });
    }
}
