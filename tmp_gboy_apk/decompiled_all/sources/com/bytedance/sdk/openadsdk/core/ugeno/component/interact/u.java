package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.io;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    kd hf;
    w u;
    y w;
    ws xj;

    public u(ws wsVar, boolean z, xj xjVar) {
        this.xj = wsVar;
        w wVar = new w(wsVar);
        this.u = wVar;
        this.hf = new kd(this.xj, z, xjVar, wVar);
        this.w = new y(this.xj, z, xjVar, this.u);
    }

    private void hf(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("easy_pfwv".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                    this.hf.u();
                    this.w.u();
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("easy_pfwv".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                    this.hf.u();
                    this.w.u();
                }
            }
        }
    }

    private boolean xj(boolean z) {
        int f = wo.f(this.xj);
        if (f == 5 || f == 9) {
            return true;
        }
        return (f == 3 || f == 4) ? z : f == 7 || f == 8;
    }

    public void xj(ViewGroup viewGroup, View view) {
        hf(viewGroup, view);
        if ((viewGroup instanceof FrameLayout) || (viewGroup instanceof RelativeLayout)) {
            if (this.hf.w()) {
                int w = io.y(this.xj).w();
                boolean z = w == 0 || w == 2;
                if (xj(true)) {
                    this.u.xj(this.hf.xj(), z);
                    kd kdVar = this.hf;
                    if (z) {
                        view = viewGroup;
                    }
                    kdVar.xj(viewGroup, view, true);
                    return;
                }
                return;
            }
            if (this.w.w()) {
                int hf = io.kd(this.xj).hf();
                boolean z2 = hf == 0 || hf == 2;
                if (xj(false)) {
                    this.u.xj(this.w.xj(), z2);
                    y yVar = this.w;
                    if (z2) {
                        view = viewGroup;
                    }
                    yVar.xj(viewGroup, view, hf != 2);
                }
            }
        }
    }

    public c xj() {
        if (this.hf.w()) {
            return this.hf.hf();
        }
        if (this.w.w()) {
            return this.w.hf();
        }
        return new c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void hf() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void kd() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void u() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void xj() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void xj(boolean z) {
            }
        };
    }

    public void hf() {
        this.hf.u();
        this.w.u();
    }

    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar) {
        y yVar = this.w;
        if (yVar != null) {
            yVar.xj(hfVar);
        }
        kd kdVar = this.hf;
        if (kdVar != null) {
            kdVar.xj(hfVar);
        }
    }
}
