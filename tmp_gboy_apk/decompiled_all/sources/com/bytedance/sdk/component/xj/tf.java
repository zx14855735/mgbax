package com.bytedance.sdk.component.xj;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.xj.p;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf {
    boolean am;
    boolean c;
    g d;
    boolean f;
    xj hf;
    Context kd;
    boolean qt;
    am tf;
    f u;
    com.bytedance.sdk.component.g.w xj;
    boolean y;
    p.hf zg;
    String w = "IESJSBridge";
    String p = "host";

    /* renamed from: pl, reason: collision with root package name */
    final Set<String> f10256pl = new LinkedHashSet();
    final Set<String> g = new LinkedHashSet();

    public tf(com.bytedance.sdk.component.g.w wVar) {
        this.xj = wVar;
    }

    private void w() {
        if ((this.xj == null && !this.am && this.hf == null) || ((TextUtils.isEmpty(this.w) && this.xj != null) || this.u == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public Context getContext() {
        return this.kd;
    }

    public tf hf(boolean z) {
        this.c = z;
        return this;
    }

    public tf xj(xj xjVar) {
        this.hf = xjVar;
        return this;
    }

    public e hf() {
        w();
        return new e(this);
    }

    public tf xj(String str) {
        this.w = str;
        return this;
    }

    public tf xj(pl plVar) {
        this.u = f.xj(plVar);
        return this;
    }

    public tf xj(boolean z) {
        this.y = z;
        return this;
    }

    public tf xj() {
        this.qt = true;
        return this;
    }

    public tf() {
    }
}
