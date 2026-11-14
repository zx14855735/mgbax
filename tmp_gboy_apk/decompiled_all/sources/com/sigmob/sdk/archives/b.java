package com.sigmob.sdk.archives;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends Exception {
    private static final long serialVersionUID = 2772690708123267100L;

    public b(String str) {
        super(str);
    }

    public b(String str, Exception exc) {
        super(str);
        initCause(exc);
    }
}
