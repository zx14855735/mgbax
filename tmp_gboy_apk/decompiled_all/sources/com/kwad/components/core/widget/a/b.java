package com.kwad.components.core.widget.a;

import android.view.View;
import com.kwad.sdk.utils.bz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class b extends a {
    private View mRootView;

    public b(View view, int i) {
        super(view, i);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public boolean ae() {
        return bz.a(this.mRootView, 70, true);
    }
}
