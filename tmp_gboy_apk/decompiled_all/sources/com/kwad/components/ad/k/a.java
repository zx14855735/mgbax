package com.kwad.components.ad.k;

import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class a<L extends i> {
    public AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public abstract void a(L l);

    public abstract void b(L l);

    public long getPlayDuration() {
        return 0L;
    }

    public boolean lc() {
        return false;
    }

    public abstract void pause();

    public void release() {
    }

    public abstract void resume();

    public void setAudioEnabled(boolean z, boolean z2) {
    }

    public void skipToEnd() {
    }
}
