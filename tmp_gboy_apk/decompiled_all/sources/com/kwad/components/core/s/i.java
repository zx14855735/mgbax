package com.kwad.components.core.s;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class i implements View.OnClickListener {
    private j acD;

    public i() {
        this(false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.acD.a(view, this);
    }

    private i(boolean z) {
        this.acD = new j(false);
    }
}
