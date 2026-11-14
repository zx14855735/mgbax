package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardLandingPageAppInfoView extends LinearLayout {
    private DownloadItemView xj;

    public RewardLandingPageAppInfoView(Context context) {
        super(context);
    }

    private View hf(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("隐私");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i == -1) {
            layoutParams.addRule(11, -1);
        } else {
            layoutParams.addRule(0, i);
            layoutParams.rightMargin = r.w(context, 6.0f);
        }
        relativeLayout.addView(textView, layoutParams);
        int w = r.w(context, 6.0f);
        r.xj(textView, w, w, 0, 0);
        return textView;
    }

    private View u(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("权限");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        textView.setId(View.generateViewId());
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams AYUAbz2 = A2egSU.AYUAbz(-2, -2, 0, i);
        AYUAbz2.rightMargin = r.w(context, 6.0f);
        relativeLayout.addView(textView, AYUAbz2);
        int w = r.w(context, 6.0f);
        r.xj(textView, w, w, 0, 0);
        return textView;
    }

    private View w(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("功能");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i);
        layoutParams.rightMargin = r.w(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int w = r.w(context, 6.0f);
        r.xj(textView, w, w, 0, 0);
        return textView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        DownloadItemView downloadItemView = this.xj;
        if (downloadItemView == null || onClickListener == null) {
            return;
        }
        downloadItemView.setOnClickListener(onClickListener);
    }

    public void xj(ws wsVar, String str) {
        if (wsVar == null) {
            return;
        }
        setBackgroundColor(-1);
        setOrientation(1);
        Context context = getContext();
        xj(wsVar);
        y ut = wsVar.ut();
        if (ut == null) {
            return;
        }
        int w = r.w(context, 12.0f);
        View xj = xj(context, ut);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = w;
        addView(xj, layoutParams);
        View xj2 = xj(context, wsVar, ut, str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = w;
        addView(xj2, layoutParams2);
        int w2 = r.w(context, 16.0f);
        setPadding(w2, w, w2, w);
    }

    private void xj(ws wsVar) {
        DownloadItemView downloadItemView = new DownloadItemView(getContext());
        this.xj = downloadItemView;
        downloadItemView.xj(wsVar);
        addView(this.xj);
    }

    private View xj(Context context, y yVar) {
        TextView textView = new TextView(context);
        textView.setText(yVar.c());
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        return textView;
    }

    private View xj(final Context context, final ws wsVar, y yVar, final String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        textView.setText("版本号：" + yVar.kd());
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        int i = -1;
        ViewGroup.LayoutParams AYUAbz2 = A2egSU.AYUAbz(-2, -2, 9, -1);
        textView.setId(View.generateViewId());
        relativeLayout.addView(textView, AYUAbz2);
        if (!TextUtils.isEmpty(yVar.p())) {
            View xj = xj(context, relativeLayout);
            i = xj(context, relativeLayout, xj.getId()).getId();
            xj.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.core.a.y.xj(wsVar, context, str);
                }
            });
        }
        View hf = hf(context, relativeLayout, i);
        hf.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.a.y.hf(wsVar, context, str);
            }
        });
        View u = u(context, relativeLayout, xj(context, relativeLayout, hf.getId()).getId());
        u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.a.y.w(wsVar, context, str);
            }
        });
        w(context, relativeLayout, xj(context, relativeLayout, u.getId()).getId()).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.a.y.xj(context, wsVar, str);
            }
        });
        return relativeLayout;
    }

    private View xj(Context context, RelativeLayout relativeLayout, int i) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#22000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r.w(context, 1.5f), r.w(context, 8.0f));
        layoutParams.rightMargin = r.w(context, 6.0f);
        view.setId(View.generateViewId());
        layoutParams.addRule(0, i);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(view, layoutParams);
        return view;
    }

    private View xj(Context context, RelativeLayout relativeLayout) {
        TextView textView = new TextView(context);
        textView.setText("备案");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        relativeLayout.addView(textView, layoutParams);
        int w = r.w(context, 6.0f);
        r.xj(textView, w, w, 0, 0);
        return textView;
    }
}
