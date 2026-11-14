package com.kwad.components.ad.draw.presenter.b;

import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    private InterfaceC0227a eH;
    private b eI;
    private boolean eJ = false;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.presenter.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0227a {
        void aU();
    }

    public interface b {
        boolean aV();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void a(InterfaceC0227a interfaceC0227a) {
        this.eH = interfaceC0227a;
    }

    public final void aT() {
        InterfaceC0227a interfaceC0227a;
        if (this.eJ) {
            return;
        }
        this.eJ = true;
        if (e.er(this.mAdTemplate).status == 1 || e.er(this.mAdTemplate).status == 2 || e.er(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.eI;
        if ((bVar == null || !bVar.aV()) && (interfaceC0227a = this.eH) != null) {
            interfaceC0227a.aU();
        }
    }

    public final void a(b bVar) {
        this.eI = bVar;
    }
}
