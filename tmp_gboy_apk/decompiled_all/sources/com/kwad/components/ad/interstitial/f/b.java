package com.kwad.components.ad.interstitial.f;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class b extends Presenter {
    public c mi;

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        this.mi = (c) PC();
    }

    public void dS() {
        List<Presenter> PB = PB();
        if (PB == null) {
            return;
        }
        for (Presenter presenter : PB) {
            if (presenter instanceof b) {
                ((b) presenter).dS();
            }
        }
    }

    public void dT() {
        List<Presenter> PB = PB();
        if (PB == null) {
            return;
        }
        for (Presenter presenter : PB) {
            if (presenter instanceof b) {
                ((b) presenter).dT();
            }
        }
    }
}
