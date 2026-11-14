package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    int c;
    int d;
    boolean e;
    int f;
    int g;
    int kd;
    float p;

    /* renamed from: pl, reason: collision with root package name */
    int f10067pl;
    int qt;
    float tf;
    int y;
    boolean yo;
    int zg;
    int xj = Integer.MAX_VALUE;
    int hf = Integer.MAX_VALUE;
    int w = Integer.MIN_VALUE;
    int u = Integer.MIN_VALUE;
    List<Integer> am = new ArrayList();

    public int hf() {
        return this.f - this.d;
    }

    public int xj() {
        return this.c;
    }

    public void xj(View view, int i, int i2, int i3, int i4) {
        hf hfVar = (hf) view.getLayoutParams();
        this.xj = Math.min(this.xj, (view.getLeft() - hfVar.g()) - i);
        this.hf = Math.min(this.hf, (view.getTop() - hfVar.am()) - i2);
        this.w = Math.max(this.w, hfVar.qt() + view.getRight() + i3);
        this.u = Math.max(this.u, hfVar.zg() + view.getBottom() + i4);
    }
}
