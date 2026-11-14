package com.kwad.components.ad.interstitial.g;

import android.view.View;
import com.kwad.sdk.utils.bz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b extends com.kwad.components.core.widget.a.a {
    private View mRootView;

    public b(View view, int i) {
        super(view, i);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean ae() {
        return bz.q(this.mRootView, 100);
    }
}
