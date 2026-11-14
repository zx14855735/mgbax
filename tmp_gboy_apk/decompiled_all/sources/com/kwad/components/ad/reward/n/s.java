package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class s extends d {
    protected ViewGroup vZ;

    public final void a(ViewGroup viewGroup, int i, int i2) {
        if (this.vZ != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        if (viewStub != null) {
            this.vZ = (ViewGroup) viewStub.inflate();
        } else {
            this.vZ = (ViewGroup) viewGroup.findViewById(i2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup hQ() {
        return this.vZ;
    }
}
