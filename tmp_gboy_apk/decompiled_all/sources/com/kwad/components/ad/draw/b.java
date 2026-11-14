package com.kwad.components.ad.draw;

import android.view.View;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.bz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b extends com.kwad.components.core.widget.a.b {
    private View mRootView;

    public b(View view) {
        super(view, aF());
        this.mRootView = view;
    }

    private static int aF() {
        int Hx;
        try {
            Hx = ((int) e.Hx()) * 100;
        } catch (Throwable unused) {
        }
        if (Hx < 0 || Hx > 100) {
            return 70;
        }
        return Hx;
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean ae() {
        return bz.a(this.mRootView, 70, true);
    }
}
