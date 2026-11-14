package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.openadsdk.core.a.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTCountdownViewForBtn extends LinearLayout implements ai.xj, u {
    private int c;
    private boolean d;
    private int f;
    private Context hf;
    private xj kd;
    private TextView u;
    private TextView w;
    protected final ai xj;
    private AtomicBoolean y;

    public TTCountdownViewForBtn(Context context) {
        super(context);
        this.y = new AtomicBoolean(true);
        this.xj = new ai(Looper.getMainLooper(), this);
        this.c = 5;
        this.f = 1;
        this.d = false;
        this.hf = context;
        u();
    }

    private void c() {
        if (this.w != null) {
            StringBuilder sb = new StringBuilder();
            int i = this.f;
            int i2 = this.c;
            sb.append(i <= i2 ? i2 - i : 0);
            sb.append("s");
            this.w.setText(sb.toString());
        }
    }

    private void kd() {
        ai aiVar = this.xj;
        if (aiVar != null) {
            aiVar.removeMessages(1);
        }
        this.f = 1;
    }

    private void u() {
        setOrientation(0);
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99333333"));
        int w = r.w(this.hf, 14.0f);
        gradientDrawable.setCornerRadius(w);
        int i = w * 2;
        gradientDrawable.setSize(i, i);
        setBackground(gradientDrawable);
        this.w = new TextView(this.hf);
        int w2 = r.w(this.hf, 6.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.w.setTextColor(-1);
        this.w.setTextSize(2, 14.0f);
        addView(this.w, layoutParams);
        View view = new View(this.hf);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = r.w(this.hf, 1.0f);
        layoutParams2.height = r.w(this.hf, 12.0f);
        layoutParams2.leftMargin = w2;
        layoutParams2.rightMargin = w2;
        view.setBackgroundColor(-1);
        addView(view, layoutParams2);
        this.u = new TextView(this.hf);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.u.setTextColor(-1);
        this.u.setTextSize(2, 14.0f);
        this.u.setText("跳过");
        addView(this.u, layoutParams3);
    }

    private void y() {
        try {
            if (!this.d && this.w != null) {
                c();
                int i = this.f;
                if (i < this.c + 1) {
                    this.f = i + 1;
                    this.xj.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    xj xjVar = this.kd;
                    if (xjVar != null) {
                        xjVar.xj();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public View getView() {
        return this;
    }

    public void hf() {
        try {
            ai aiVar = this.xj;
            if (aiVar != null) {
                aiVar.removeMessages(1);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        kd();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.y.set(z);
        if (this.d) {
            return;
        }
        if (this.y.get()) {
            w();
        } else {
            hf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public void setCountDownTime(int i) {
        this.c = i;
        c();
        kd();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public void setCountdownListener(xj xjVar) {
        this.kd = xjVar;
        this.y.get();
    }

    public void w() {
        try {
            y();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public void xj() {
        if (this.d) {
            return;
        }
        kd();
        y();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public void xj(boolean z) {
        this.d = z;
        if (z) {
            kd();
        }
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what == 1) {
            y();
        }
    }
}
