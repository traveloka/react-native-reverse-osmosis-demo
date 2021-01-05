package com.reverseosmosisdemo.demowidget;

public interface DemoWidgetListener {
    default void onSetUpView() {}
    default void onToggleClick() {}
}
