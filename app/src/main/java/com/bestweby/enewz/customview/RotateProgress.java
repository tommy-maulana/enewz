package com.bestweby.enewz.customview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.bestweby.enewz.R;

/**
 * RotateLoading
 * Created by Victor on 2015/4/28.
 */
public class RotateProgress extends View {

    private static final int DEFAULT_WIDTH = 3;
    private static final int DEFAULT_SHADOW_POSITION = 2;
    private static final int DEFAULT_SPEED_OF_DEGREE = 10;

    private Paint mPaint;

    private RectF loadingRectF;
    private RectF shadowRectF;

    private int topDegree = 10;
    private int bottomDegree = 180;

    private float arc;
    private int width;
    private boolean changeBigger = true;
    private int shadowPosition;

    private boolean showing = false;

    private int color;
    private int speedOfDegree;
    private float speedOfArc;

    public RotateProgress(Context context) {
        super(context);
        initView(context, null);
    }

    public RotateProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public RotateProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        color = context.getResources().getColor(R.color.colorProgress);
        width = dpToPx(context, DEFAULT_WIDTH);
        shadowPosition = dpToPx(getContext(), DEFAULT_SHADOW_POSITION);
        speedOfDegree = DEFAULT_SPEED_OF_DEGREE;

        if (null != attrs) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RotateProgress);
            color = typedArray.getColor(R.styleable.RotateProgress_progress_color, color);
            width = typedArray.getDimensionPixelSize(R.styleable.RotateProgress_progress_width, dpToPx(context, DEFAULT_WIDTH));
            shadowPosition = typedArray.getInt(R.styleable.RotateProgress_shadow_position, DEFAULT_SHADOW_POSITION);
            speedOfDegree = typedArray.getInt(R.styleable.RotateProgress_progress_speed, DEFAULT_SPEED_OF_DEGREE);
            typedArray.recycle();
        }
        speedOfArc = speedOfDegree / 4;
        mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(width);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        arc = 10;

        loadingRectF = new RectF(2 * width, 2 * width, w - 2 * width, h - 2 * width);
        shadowRectF = new RectF(2 * width + shadowPosition, 2 * width + shadowPosition, w - 2 * width + shadowPosition, h - 2 * width + shadowPosition);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!showing) {
            return;
        }

        mPaint.setColor(Color.parseColor("#1a000000"));
        canvas.drawArc(shadowRectF, topDegree, arc, false, mPaint);
        canvas.drawArc(shadowRectF, bottomDegree, arc, false, mPaint);

        mPaint.setColor(color);
        canvas.drawArc(loadingRectF, topDegree, arc, false, mPaint);
        canvas.drawArc(loadingRectF, bottomDegree, arc, false, mPaint);

        topDegree += speedOfDegree;
        bottomDegree += speedOfDegree;
        if (topDegree > 360) {
            topDegree = topDegree - 360;
        }
        if (bottomDegree > 360) {
            bottomDegree = bottomDegree - 360;
        }

        if (changeBigger) {
            if (arc < 160) {
                arc += speedOfArc;
                invalidate();
            }
        } else {
            if (arc > speedOfDegree) {
                arc -= 2 * speedOfArc;
                invalidate();
            }
        }
        if (arc >= 160 || arc <= 10) {
            changeBigger = !changeBigger;
            invalidate();
        }
    }

    public void setProgressColor(int color) {
        this.color = color;
    }

    public int getProgressColor() {
        return color;
    }

    public int getTopDegree() {
        return topDegree;
    }

    public void setTopDegree(int topDegree) {
        this.topDegree = topDegree;
    }

    public int getBottomDegree() {
        return bottomDegree;
    }

    public void setBottomDegree(int bottomDegree) {
        this.bottomDegree = bottomDegree;
    }

    public int getShadowPosition() {
        return shadowPosition;
    }

    public void setShadowPosition(int shadowPosition) {
        this.shadowPosition = shadowPosition;
    }

    public int getSpeedOfDegree() {
        return speedOfDegree;
    }

    public void setSpeedOfDegree(int speedOfDegree) {
        this.speedOfDegree = speedOfDegree;
    }

    public void show() {
        startAnimator();
        showing = true;
        invalidate();
    }

    public void hide() {
        stopAnimator();
        invalidate();
    }

    public boolean isShowing() {
        return showing;
    }

    public void startAnimator() {
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(this, "scaleX", 0.0f, 1);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(this, "scaleY", 0.0f, 1);
        scaleXAnimator.setDuration(300);
        scaleXAnimator.setInterpolator(new LinearInterpolator());
        scaleYAnimator.setDuration(300);
        scaleYAnimator.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
        animatorSet.start();
    }

    public void stopAnimator() {
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(this, "scaleX", 1, 0);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(this, "scaleY", 1, 0);
        scaleXAnimator.setDuration(300);
        scaleXAnimator.setInterpolator(new LinearInterpolator());
        scaleYAnimator.setDuration(300);
        scaleYAnimator.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                showing = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }

    public int dpToPx(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
    }

}
