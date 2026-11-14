package com.ss.android.socialbase.appdownloader.y.xj;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    public static final void xj(u uVar, int i) {
        int hf = uVar.hf();
        if (hf == i) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(hf) + ".");
    }
}
