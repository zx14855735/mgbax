package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static volatile w xj;

    private w() {
    }

    public static w xj() {
        if (xj == null) {
            synchronized (w.class) {
                try {
                    if (xj == null) {
                        xj = new w();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public u xj(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        if (xjVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(xjVar.d())) {
            return new p(view, xjVar);
        }
        if ("translate".equals(xjVar.d())) {
            return new qt(view, xjVar);
        }
        if ("ripple".equals(xjVar.d())) {
            return new f(view, xjVar);
        }
        if ("marquee".equals(xjVar.d())) {
            return new c(view, xjVar);
        }
        if ("waggle".equals(xjVar.d())) {
            return new zg(view, xjVar);
        }
        if ("shine".equals(xjVar.d())) {
            return new pl(view, xjVar);
        }
        if ("swing".equals(xjVar.d())) {
            return new am(view, xjVar);
        }
        if ("fade".equals(xjVar.d())) {
            return new xj(view, xjVar);
        }
        if ("rubIn".equals(xjVar.d())) {
            return new tf(view, xjVar);
        }
        if ("rotate".equals(xjVar.d())) {
            return new d(view, xjVar);
        }
        if ("cutIn".equals(xjVar.d())) {
            return new y(view, xjVar);
        }
        if ("stretch".equals(xjVar.d())) {
            return new g(view, xjVar);
        }
        if ("bounce".equals(xjVar.d())) {
            return new kd(view, xjVar);
        }
        return null;
    }
}
