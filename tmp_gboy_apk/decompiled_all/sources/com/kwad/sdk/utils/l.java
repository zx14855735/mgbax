package com.kwad.sdk.utils;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class l<T> {
    protected boolean bdQ = false;
    protected boolean enable;

    public l(boolean z) {
        this.enable = z;
    }

    public final T cL(Context context) {
        if (!this.enable || this.bdQ) {
            return null;
        }
        try {
            return cM(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public abstract T cM(Context context);

    public final void ce(boolean z) {
        this.enable = z;
    }
}
