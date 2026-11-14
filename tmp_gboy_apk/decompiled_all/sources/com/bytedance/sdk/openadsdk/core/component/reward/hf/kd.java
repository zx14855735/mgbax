package com.bytedance.sdk.openadsdk.core.component.reward.hf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.widget.TopProxyLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private com.bytedance.sdk.openadsdk.core.component.reward.top.y c;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.kd d;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.u f;
    private ws hf;
    private UgenBanner kd;
    private TextView u;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.xj w;
    private final TTBaseVideoActivity xj;
    private com.bytedance.sdk.openadsdk.core.hf.hf y;

    public kd(TTBaseVideoActivity tTBaseVideoActivity) {
        this.xj = tTBaseVideoActivity;
    }

    private void f() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.xj.findViewById(2114387721);
        if (topProxyLayout != null) {
            xj(topProxyLayout);
        }
        this.u = (TextView) this.xj.findViewById(2114387801);
        this.kd = (UgenBanner) this.xj.findViewById(2114387901);
    }

    public void c(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.setShowAgain(z);
        }
    }

    public void hf(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.setShowDislike(z);
        }
    }

    public void kd(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.setShowSound(z);
        }
    }

    public void u(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.setSoundMute(z);
        }
    }

    public void w(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.setDislikeLeft(z);
        }
    }

    public void y(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.setShowBack(z);
        }
    }

    public void xj(ws wsVar, hf hfVar, boolean z, com.bytedance.sdk.openadsdk.core.hf.hf hfVar2) {
        this.hf = wsVar;
        this.y = hfVar2;
        f();
        this.c = new com.bytedance.sdk.openadsdk.core.component.reward.top.y(this.xj, this.hf, hfVar, this, z);
        this.d = new com.bytedance.sdk.openadsdk.core.component.reward.top.kd(this.xj, this.hf, hfVar, this, z);
        this.f = new com.bytedance.sdk.openadsdk.core.component.reward.top.u(this.xj, this.hf, hfVar, this, z);
        xj(1);
    }

    public void c() {
        UgenBanner ugenBanner = this.kd;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.xj();
    }

    public void hf() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.hf();
        }
    }

    public boolean kd() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public View u() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            return xjVar.getCloseButton();
        }
        return null;
    }

    public void w() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.w();
        }
    }

    public void y() {
        UgenBanner ugenBanner = this.kd;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.xj(this.hf, this.y);
    }

    public void hf(String str) {
        TextView textView = this.u;
        if (textView != null) {
            textView.setText(str);
            this.u.setVisibility(0);
            this.u.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.kd.1
                @Override // java.lang.Runnable
                public void run() {
                    kd.this.u.setVisibility(8);
                }
            }, 3000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.sdk.openadsdk.core.component.reward.hf.kd] */
    public void xj(TopProxyLayout topProxyLayout) {
        TopLayoutImpl topLayoutImpl;
        if (v.p(this.hf)) {
            topLayoutImpl = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).xj(this.hf);
        } else {
            topLayoutImpl = new TopLayoutImpl(topProxyLayout.getContext()).xj(this.hf);
        }
        if (topLayoutImpl != null) {
            this.w = topLayoutImpl;
        } else {
            pl.u("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            xj(topProxyLayout, topLayoutImpl, (ViewGroup) parent);
        }
    }

    private void xj(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    public void xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.setVisible(z);
        }
    }

    public void xj(boolean z, String str, String str2, boolean z2, boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj(z, str, str2, z2, z3);
        }
    }

    public void xj(String str, String str2, boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj(str, str2, z);
        }
    }

    public void xj() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj();
        }
    }

    public void xj(int i) {
        if (i == 2) {
            xj(this.f);
        } else if (i != 4) {
            xj(this.c);
        } else {
            xj(this.d);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.component.reward.top.hf hfVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.setListener(hfVar);
        }
    }

    public void xj(String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.setPlayAgainEntranceText(str);
        }
    }

    public void xj(ws wsVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.y yVar = this.c;
        if (yVar != null) {
            yVar.xj(wsVar);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.f;
        if (uVar != null) {
            uVar.xj(wsVar);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.top.kd kdVar = this.d;
        if (kdVar != null) {
            kdVar.xj(wsVar);
        }
    }
}
