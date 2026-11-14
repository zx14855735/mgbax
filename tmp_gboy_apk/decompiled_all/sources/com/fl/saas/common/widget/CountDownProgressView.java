package com.fl.saas.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CountDownProgressView extends FrameLayout {
    private Runnable finishFun;
    private CountDownTimer mTimer;
    private Consumer<Integer> mVisibilityChanged;
    private int remainingCount;
    private RoundProgressView roundProgressView;
    private TextView textview;
    private AmA8tU.A2egSU tickFun;
    private int totalCount;
    private int visibilityState;

    public CountDownProgressView(Context context) {
        super(context);
        this.totalCount = 5;
        createView();
    }

    public static /* synthetic */ int access$006(CountDownProgressView countDownProgressView) {
        int i = countDownProgressView.remainingCount - 1;
        countDownProgressView.remainingCount = i;
        return i;
    }

    private void createView() {
        TextView textView = new TextView(getContext());
        this.textview = textView;
        textView.setTextSize(2, 13.0f);
        this.textview.setGravity(17);
        this.textview.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview.setTextColor(-1);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.textview, layoutParams);
        RoundProgressView roundProgressView = new RoundProgressView(getContext());
        this.roundProgressView = roundProgressView;
        addView(roundProgressView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        AmA8tU.A2egSU a2egSU = this.tickFun;
        if (a2egSU != null && this.textview != null) {
            this.textview.setText((String) a2egSU.apply(1));
        }
        RoundProgressView roundProgressView = this.roundProgressView;
        if (roundProgressView != null) {
            roundProgressView.setProgress(this.totalCount * 1000);
        }
        Runnable runnable = this.finishFun;
        if (runnable != null) {
            runnable.run();
            this.mTimer.cancel();
        }
    }

    private void lodTimer() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (this.totalCount <= 0) {
            return;
        }
        RoundProgressView roundProgressView = this.roundProgressView;
        if (roundProgressView != null) {
            roundProgressView.setMaxProgress(r0 * 1000);
        }
        this.remainingCount = this.totalCount * 20;
        this.mTimer = new CountDownTimer(this.remainingCount * 50, 50L) { // from class: com.fl.saas.common.widget.CountDownProgressView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                CountDownProgressView.this.finish();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                int access$006 = CountDownProgressView.access$006(CountDownProgressView.this);
                if (access$006 < 0) {
                    CountDownProgressView.this.finish();
                } else if (access$006 % 5 == 0 && CountDownProgressView.this.tickFun != null && CountDownProgressView.this.textview != null) {
                    int i = (((int) j) / 1000) + 1;
                    CountDownProgressView.this.textview.setText((String) CountDownProgressView.this.tickFun.apply(Integer.valueOf(i >= 1 ? i : 1)));
                }
                if (CountDownProgressView.this.roundProgressView != null) {
                    CountDownProgressView.this.roundProgressView.setProgress((CountDownProgressView.this.totalCount * 1000) - j);
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

    public int getVisibilityState() {
        return this.visibilityState;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancel();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visibilityState = i;
        Consumer<Integer> consumer = this.mVisibilityChanged;
        if (consumer != null) {
            consumer.accept(Integer.valueOf(i));
        }
    }

    public void setCount(int i) {
        this.totalCount = i;
    }

    public CountDownProgressView setFinish(Runnable runnable) {
        this.finishFun = runnable;
        return this;
    }

    public CountDownProgressView setOnTick(AmA8tU.A2egSU a2egSU) {
        this.tickFun = a2egSU;
        return this;
    }

    public void setOnVisibilityChanged(Consumer<Integer> consumer) {
        this.mVisibilityChanged = consumer;
    }

    public void setText(String str) {
        TextView textView = this.textview;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void start() {
        lodTimer();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
        AmA8tU.A2egSU a2egSU = this.tickFun;
        if (a2egSU == null || this.textview == null) {
            return;
        }
        this.textview.setText((String) a2egSU.apply(Integer.valueOf(this.totalCount)));
    }

    public void unOnVisibilityChanged() {
        this.mVisibilityChanged = null;
    }

    public CountDownProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountDownProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.totalCount = 5;
    }
}
