package com.fl.saas.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.TextView;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.s2s.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CountDownTextView extends TextView {
    private int bgColor;
    private int bgRadius;
    private Runnable finishFun;
    private CountDownTimer mTimer;
    private Consumer<Integer> mVisibilityChanged;
    private int remainingCount;
    private AmA8tU.A2egSU tickFun;
    private int totalCount;

    public CountDownTextView(Context context) {
        super(context);
        this.totalCount = 5;
        this.bgColor = 0;
        this.bgRadius = 0;
    }

    public static /* synthetic */ int access$006(CountDownTextView countDownTextView) {
        int i = countDownTextView.remainingCount - 1;
        countDownTextView.remainingCount = i;
        return i;
    }

    private void lodTimer() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        int i = this.totalCount;
        if (i <= 0) {
            return;
        }
        this.remainingCount = i + 1;
        this.mTimer = new CountDownTimer(this.remainingCount * 1000, 1000L) { // from class: com.fl.saas.common.widget.CountDownTextView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (CountDownTextView.this.finishFun != null) {
                    CountDownTextView.this.finishFun.run();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                int access$006 = CountDownTextView.access$006(CountDownTextView.this);
                if (access$006 < 0) {
                    if (CountDownTextView.this.finishFun != null) {
                        CountDownTextView.this.finishFun.run();
                        CountDownTextView.this.mTimer.cancel();
                        return;
                    }
                    return;
                }
                if (CountDownTextView.this.tickFun != null) {
                    CountDownTextView.this.setText((String) CountDownTextView.this.tickFun.apply(Integer.valueOf(access$006)));
                }
            }
        };
    }

    public void cancel() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancel();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        Consumer<Integer> consumer = this.mVisibilityChanged;
        if (consumer != null) {
            consumer.accept(Integer.valueOf(i));
        }
    }

    public void setCount(int i) {
        this.totalCount = i;
    }

    public CountDownTextView setFinish(Runnable runnable) {
        this.finishFun = runnable;
        return this;
    }

    public CountDownTextView setOnTick(AmA8tU.A2egSU a2egSU) {
        this.tickFun = a2egSU;
        return this;
    }

    public void setOnVisibilityChanged(Consumer<Integer> consumer) {
        this.mVisibilityChanged = consumer;
    }

    public void start() {
        lodTimer();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public void unOnVisibilityChanged() {
        this.mVisibilityChanged = null;
    }

    public CountDownTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountDownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.totalCount = 5;
        this.bgColor = 0;
        this.bgRadius = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CountDownTextView);
        this.totalCount = obtainStyledAttributes.getInt(R.styleable.CountDownTextView_yd_count, 5);
        this.bgColor = obtainStyledAttributes.getColor(R.styleable.CountDownTextView_yd_bg_color, -7829368);
        this.bgRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CountDownTextView_yd_bg_radius, 0);
        obtainStyledAttributes.recycle();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.bgRadius);
        gradientDrawable.setColor(this.bgColor);
        setBackground(gradientDrawable);
    }
}
