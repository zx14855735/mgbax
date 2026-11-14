package com.bytedance.sdk.component.w.hf.xj.hf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class kd extends RuntimeException {
    private static final Method xj;
    private IOException hf;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        xj = method;
    }

    public kd(IOException iOException) {
        super(iOException);
        this.hf = iOException;
    }

    public IOException xj() {
        return this.hf;
    }

    public void xj(IOException iOException) {
        xj(iOException, this.hf);
        this.hf = iOException;
    }

    private void xj(IOException iOException, IOException iOException2) {
        Method method = xj;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
