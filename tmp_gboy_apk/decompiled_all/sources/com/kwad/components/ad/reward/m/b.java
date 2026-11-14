package com.kwad.components.ad.reward.m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b extends com.kwad.components.ad.k.a<i> implements g.a {
    private com.kwad.components.core.h.c BD;

    public b(AdTemplate adTemplate) {
        super(adTemplate);
        long N = com.kwad.sdk.core.response.b.a.N(com.kwad.sdk.core.response.b.e.er(adTemplate));
        com.kwad.components.core.h.c cVar = new com.kwad.components.core.h.c();
        this.BD = cVar;
        cVar.E(N);
    }

    public final FrameLayout T(Context context) {
        FrameLayout imagePlayerView = this.BD.getImagePlayerView(context);
        this.BD.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    @Override // com.kwad.components.ad.k.a
    public final void a(i iVar) {
        this.BD.d(iVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final void b(i iVar) {
        this.BD.c(iVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.BD.getPlayDuration();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void he() {
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hf() {
        resume();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hg() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hh() {
        this.BD.destroy();
    }

    public final void ld() {
        this.BD.setURLs(com.kwad.sdk.core.response.b.a.bb(com.kwad.sdk.core.response.b.e.er(this.mAdTemplate)));
        this.BD.play();
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.BD.pause();
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        this.BD.destroy();
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.BD.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.BD.skipToEnd();
    }
}
