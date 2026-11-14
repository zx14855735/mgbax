package com.fl.saas.common.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SkipView extends FrameLayout {
    private Runnable cancelFun;
    private CircularCountDownView circle_skip;
    private Runnable finishFun;
    private CountDownTimer mTimer;
    private int remainingCount;
    private boolean showCountDown;
    private AmA8tU.A2egSU tickFun;
    private int totalCount;
    private CountDownTextView tv_skip;
    private int type;
    private View v_skip;
    private int value;

    public SkipView(Context context) {
        super(context);
        this.totalCount = 5;
    }

    public static /* synthetic */ int access$006(SkipView skipView) {
        int i = skipView.remainingCount - 1;
        skipView.remainingCount = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$3(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$4(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setShowCountDown$0(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setShowCountDown$1(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setShowCountDown$2(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
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
        this.remainingCount = i * 20;
        this.mTimer = new CountDownTimer(this.totalCount * 1000, 50L) { // from class: com.fl.saas.common.widget.SkipView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (SkipView.this.finishFun != null) {
                    SkipView.this.finishFun.run();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (SkipView.access$006(SkipView.this) < 0) {
                    if (SkipView.this.finishFun != null) {
                        SkipView.this.finishFun.run();
                        SkipView.this.mTimer.cancel();
                        return;
                    }
                    return;
                }
                if (SkipView.this.circle_skip != null) {
                    SkipView.this.circle_skip.setProgress((int) (((SkipView.this.totalCount * 1000) - j) / (SkipView.this.totalCount * 10.0d)));
                }
            }
        };
    }

    public void cancel() {
        if (this.showCountDown) {
            CountDownTextView countDownTextView = this.tv_skip;
            if (countDownTextView != null) {
                countDownTextView.cancel();
                return;
            }
            return;
        }
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void createView() {
        View inflate = ViewHelper.inflate(getContext(), R.layout.yd_saas_view_spread_skipview);
        this.tv_skip = (CountDownTextView) inflate.findViewById(R.id.tv_skip);
        this.circle_skip = (CircularCountDownView) inflate.findViewById(R.id.circle_skip);
        this.v_skip = inflate.findViewById(R.id.v_skip);
        addView(inflate, ViewHelper.getWrapParent());
    }

    public void onClick() {
        View view;
        A2egSU a2egSU;
        if (this.showCountDown) {
            if (this.type == 0) {
                return;
            }
            this.type = 0;
            this.v_skip.setVisibility(8);
            view = this.tv_skip;
            a2egSU = new A2egSU(this, 0);
        } else {
            if (this.type == 0) {
                return;
            }
            this.type = 0;
            this.v_skip.setVisibility(8);
            view = this.circle_skip;
            a2egSU = new A2egSU(this, 1);
        }
        view.setOnClickListener(a2egSU);
    }

    public SkipView setCancel(Runnable runnable) {
        this.cancelFun = runnable;
        return this;
    }

    public void setCount(int i) {
        this.totalCount = i;
    }

    public SkipView setFinish(Runnable runnable) {
        this.finishFun = runnable;
        return this;
    }

    public SkipView setOnTick(AmA8tU.A2egSU a2egSU) {
        this.tickFun = a2egSU;
        return this;
    }

    public void setShowCountDown(boolean z) {
        View view;
        A2egSU a2egSU;
        this.showCountDown = z;
        if (z) {
            this.tv_skip.setVisibility(0);
            this.circle_skip.setVisibility(8);
            this.tv_skip.setOnTick(this.tickFun).setFinish(this.finishFun);
            if (this.type == 0) {
                view = this.tv_skip;
                a2egSU = new A2egSU(this, 2);
                view.setOnClickListener(a2egSU);
            }
        } else {
            this.tv_skip.setVisibility(8);
            this.circle_skip.setVisibility(0);
            if (this.type == 0) {
                view = this.circle_skip;
                a2egSU = new A2egSU(this, 3);
                view.setOnClickListener(a2egSU);
            }
        }
        this.v_skip.setOnClickListener(new A2egSU(this, 4));
    }

    public void setValue(int i, int i2) {
        this.type = i;
        this.value = i2;
        if (i == 0 || i2 <= 0) {
            return;
        }
        this.v_skip.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.v_skip.getLayoutParams();
        int dip2px = DeviceUtil.dip2px((i2 * 40) / 100.0f);
        layoutParams.width = dip2px;
        layoutParams.height = dip2px;
        this.v_skip.setLayoutParams(layoutParams);
    }

    public void start() {
        if (this.showCountDown) {
            CountDownTextView countDownTextView = this.tv_skip;
            if (countDownTextView != null) {
                countDownTextView.start();
                return;
            }
            return;
        }
        lodTimer();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public SkipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.totalCount = 5;
        createView();
    }
}
