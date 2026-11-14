package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class ir {
    public static m xj(Context context) {
        if (d.v()) {
            return new qf(new p());
        }
        if (d.jk() && p.xj()) {
            return new p();
        }
        if (ew.xj()) {
            return new ew(context);
        }
        if (d.g() && d.am()) {
            return new nt();
        }
        if (d.g() && !d.am()) {
            return new vw();
        }
        if (d.xj(context) || d.g()) {
            return new nt();
        }
        if (d.ra()) {
            return new qf();
        }
        if (d.ht()) {
            return new ol();
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (d.qt() || !nt.w(context)) {
                return null;
            }
            return new nt();
        }
        if (d.dk()) {
            return new sv();
        }
        if (d.io()) {
            return new jw();
        }
        if (d.et()) {
            return new uf();
        }
        if (d.x()) {
            return new wo();
        }
        he heVar = new he(context);
        return heVar.xj(context) ? heVar : new ut();
    }
}
