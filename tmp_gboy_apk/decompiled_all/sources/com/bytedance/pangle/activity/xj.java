package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements View.OnClickListener {
    private final String hf;
    private Method u;
    private final int w;
    private final Activity xj;

    public xj(Activity activity, int i, String str) {
        this.xj = activity;
        this.hf = str;
        this.w = i;
    }

    private void xj(Activity activity, String str) {
        try {
            Method method = activity.getClass().getMethod(this.hf, View.class);
            if (method != null) {
                this.u = method;
                return;
            }
        } catch (NoSuchMethodException unused) {
        }
        throw new IllegalStateException("Could not find method " + this.hf + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.w);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.u == null) {
            xj(this.xj, this.hf);
        }
        try {
            this.u.invoke(this.xj, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
