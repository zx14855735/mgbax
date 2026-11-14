package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class b extends RelativeLayout {
    protected final c aPx;
    private Runnable adJ;

    public b(Context context, c cVar) {
        super(context);
        this.aPx = cVar;
    }

    public abstract void onPlayStateChanged(int i);

    public void p(int i, int i2) {
    }

    public abstract void reset();

    public abstract void uY();

    public final void ve() {
        vf();
        if (this.adJ == null) {
            this.adJ = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.uY();
                    if (b.this.adJ != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.adJ, 1000L);
                    }
                }
            };
        }
        post(this.adJ);
    }

    public final void vf() {
        Runnable runnable = this.adJ;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.adJ = null;
        }
    }
}
