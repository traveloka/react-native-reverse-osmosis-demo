package com.reverseosmosisdemo.demowidget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reverseosmosisdemo.R;

public class DemoWidget extends LinearLayout {
    private Button btnToggle;
    private TextView txtToggled;

    public DemoWidget(Context context) {
        super(context);

        setUpView();
        setUpAction();
    }

    private void setUpView() {
        View view = inflate(getContext(), R.layout.demo_widget_view, null);
        addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        btnToggle = findViewById(R.id.btn_toggle);
        txtToggled = findViewById(R.id.text_view_toggled);
    }

    private void setUpAction() {
        btnToggle.setOnClickListener(view -> {
            txtToggled.setVisibility(txtToggled.getVisibility() == GONE ? VISIBLE : GONE);
        });
    }

    public void setButtonTitle(String title) {
        btnToggle.setText(title);
    }

    public void setLabelTitle(String title) {
        txtToggled.setText(title);
    }
}
