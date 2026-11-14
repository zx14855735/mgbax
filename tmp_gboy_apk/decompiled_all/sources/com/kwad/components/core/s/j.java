package com.kwad.components.core.s;

import android.os.SystemClock;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class j {
    private static long acF;
    private long acE;
    private boolean acG;
    private long acH;

    public j() {
        this(false);
    }

    public final void a(View view, View.OnClickListener onClickListener) {
        com.kwad.sdk.core.d.c.d("click", "cur:" + SystemClock.elapsedRealtime() + " pre:" + this.acE + " global:" + this.acG + " gt:" + acF);
        if (SystemClock.elapsedRealtime() - (this.acG ? acF : this.acE) > this.acH) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.acE = elapsedRealtime;
            acF = elapsedRealtime;
            onClickListener.onClick(view);
        }
    }

    public j(boolean z) {
        this(z, 1000L);
    }

    private j(boolean z, long j) {
        this.acG = z;
        this.acH = 1000L;
    }
}
