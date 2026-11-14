package com.kwad.components.ad.reward.presenter.d;

import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.presenter.d.b.c;
import com.kwad.components.ad.reward.presenter.d.b.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class a extends com.kwad.components.ad.reward.presenter.b implements g, j {
    public a() {
        du();
    }

    private void dn() {
        this.tq.b(this);
        com.kwad.components.ad.reward.a.gh().a(this);
    }

    private void fb() {
        List<Presenter> PB = PB();
        if (PB == null) {
            return;
        }
        for (Object obj : PB) {
            if (obj instanceof c) {
                ((c) obj).jP();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        dn();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cW() {
        fb();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dm() {
        fb();
    }

    public void du() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.d.b.a());
        a(new com.kwad.components.ad.reward.presenter.d.b.b());
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tq.c(this);
        com.kwad.components.ad.reward.a.gh().b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
