package com.reverseosmosisdemo.demowidget;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
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
        wrapperView.setContentView(demoWidget);

        return wrapperView;
    }

    @ReactProp(name = "buttonTitle")
    public void setButtonTitle(WrapperView view, String buttonTitle) {
        DemoWidget demoWidget = (DemoWidget) view.getContentView();
        demoWidget.setButtonTitle(buttonTitle);
    }

    @ReactProp(name = "labelTitle")
    public void setLabelTitle(WrapperView view, String labelTitle) {
        DemoWidget demoWidget = (DemoWidget) view.getContentView();
        demoWidget.setLabelTitle(labelTitle);
    }
}
