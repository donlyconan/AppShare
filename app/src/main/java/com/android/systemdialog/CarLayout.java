package com.android.systemdialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CarLayout extends LinearLayout {
    private View view;
    private Paint mPaint = new Paint();

    public CarLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        for (int i = 1; i < 6; i++) {
//            View v = new View(getContext());
//            if(i % 2 == 0) {
//                v.setBackgroundColor(Color.RED);
//            } else  {
//                v.setBackgroundColor(Color.YELLOW);
//            }
//            LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//            lp.weight = 1;
//            v.setLayoutParams(lp);
//            addView(v);
//        }
//    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        setBackground(snapshot());

        for(int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if(!view.isSelected()) {
                view.setVisibility(INVISIBLE);
            }
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private Drawable snapshot() {
        setDrawingCacheEnabled(true);
        Bitmap bitmap = getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
        setDrawingCacheEnabled(false);
        BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
        return drawable;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.parseColor("#0d0b09"));
        mPaint.setAlpha(230);
        RectF rectF = new RectF(0,0, getRight(), getBottom());
        canvas.drawRect(rectF, mPaint);
//
//        if(getOrientation() == HORIZONTAL) {
//            RectF rectLeft = new RectF(0, 0, view.getLeft(), getWidth());
//            canvas.drawRect(rectLeft, mPaint);
//
//            RectF rectRight = new RectF(view.getRight(), 0, getWidth(), getHeight());
//            canvas.drawRect(rectRight, mPaint);
//        } else  {
//            RectF rectTop = new RectF(0, 0, getHeight(), getWidth());
//            canvas.drawRect(rectTop, mPaint);
//
//            RectF rectBottom = new RectF(0, view.getBottom(), getWidth(), getHeight());
//            canvas.drawRect(rectBottom, mPaint);
//        }


    }


}
