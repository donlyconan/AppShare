package com.android.systemdialog;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class MaskLayout extends RelativeLayout {

    private int mStart = 100;
    private int mEnd = 200;
    private int mMaskColor = Color.TRANSPARENT;
    private View mFirstView;
    private View mLastView;

    public MaskLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaskLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MaskLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mFirstView = makeSufaceCoating();
        mLastView = makeSufaceCoating();
        LayoutParams firLp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        LayoutParams lastLp = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        mFirstView.setLayoutParams(firLp);
        mLastView.setLayoutParams(lastLp);
        addView(mFirstView);
        addView(mLastView);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public void overlayChildView() {

    }

    public View makeSufaceCoating() {
        View view = new View(getContext());
        view.setBackgroundColor(mMaskColor);
        view.setFocusable(true);
        return view;
    }

}
