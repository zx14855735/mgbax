package com.sigmob.sdk.nativead;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ad extends Handler {
    static final int b = 87108;
    long c;
    boolean d;

    public ad() {
        this.c = 100L;
        this.d = true;
    }

    public void a() {
        sendEmptyMessageDelayed(b, this.c);
    }

    public boolean b() {
        return this.d;
    }

    public ad(Looper looper) {
        super(looper);
        this.c = 100L;
        this.d = true;
    }

    public void a(boolean z) {
        this.d = z;
    }
}
