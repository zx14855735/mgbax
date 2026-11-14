package com.bytedance.sdk.openadsdk.core.ugeno.component.hf;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static int hf = 1;
    public static int xj;
    private kd.xj w;
    private int u = 60;
    private int kd = hf;

    private int hf(View view) {
        int xj2 = (int) (f.xj(view.getContext()) / 2.3d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs(((view.getHeight() / 2) + iArr[1]) - xj2);
    }

    public int xj(RecyclerView recyclerView) {
        kd.xj xjVar;
        View w;
        kd.xj xjVar2 = null;
        com.bytedance.sdk.component.widget.recycler.kd kdVar = recyclerView.getLayoutManager() instanceof com.bytedance.sdk.component.widget.recycler.kd ? (com.bytedance.sdk.component.widget.recycler.kd) recyclerView.getLayoutManager() : null;
        if (kdVar != null) {
            int p = kdVar.p();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int tf = kdVar.tf(); tf <= p; tf++) {
                Object w2 = recyclerView.w(tf);
                if ((w2 instanceof kd.xj) && (w = (xjVar = (kd.xj) w2).w()) != null && xj(w, this.u)) {
                    if (this.kd == xj) {
                        xjVar.K_();
                        this.w = xjVar;
                        return tf;
                    }
                    linkedHashMap.put(Integer.valueOf(tf), xjVar);
                }
            }
            int i = Integer.MAX_VALUE;
            int i2 = -1;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int hf2 = hf(((kd.xj) entry.getValue()).w());
                if (hf2 < i) {
                    kd.xj xjVar3 = (kd.xj) entry.getValue();
                    i2 = ((Integer) entry.getKey()).intValue();
                    xjVar2 = xjVar3;
                    i = hf2;
                }
            }
            kd.xj xjVar4 = this.w;
            if (xjVar4 != xjVar2) {
                if (xjVar4 != null) {
                    xjVar4.J_();
                }
                this.w = xjVar2;
            }
            kd.xj xjVar5 = this.w;
            if (xjVar5 != null) {
                xjVar5.K_();
                return i2;
            }
        }
        return -1;
    }

    public void xj() {
        kd.xj xjVar = this.w;
        if (xjVar == null || xjVar.w() == null || xj(this.w.w(), this.u)) {
            return;
        }
        this.w.J_();
    }

    private int xj(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean xj(View view, int i) {
        return view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && xj(view) >= i;
    }
}
