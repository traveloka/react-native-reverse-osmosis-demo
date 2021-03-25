package com.reverseosmosisdemo.demowidget;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.reverseosmosisdemo.wrapperview.WrapperView;

public class DemoWidgetViewGroupManager extends ViewGroupManager<WrapperView> {
    @NonNull
    @Override
    public String getName() {
        return "DemoWidget";
    }

    @NonNull
    @Override
    protected WrapperView createViewInstance(@NonNull ThemedReactContext reactContext) {
        WrapperView wrapperView = new WrapperView(reactContext);
        DemoWidget demoWidget = new DemoWidget(reactContext);
        wrapperView.addView(demoWidget);

        return wrapperView;
    }

    @Override
    public boolean needsCustomLayoutForChildren() {
        return true;
    }
}
