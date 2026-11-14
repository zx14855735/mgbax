package com.kwad.components.ad.reward.presenter;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.components.core.j.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class g extends b implements a.InterfaceC0298a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        boolean Jl = com.kwad.sdk.core.local.a.Jl();
        A2egSU.B9tovu("onBind localCheckResult: ", "RewardInnerAdLoadPresenter", Jl);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl == null || !Jl) {
            return;
        }
        com.kwad.components.core.j.a.a(sceneImpl, this);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0298a
    public final void e(List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean cK = com.kwad.sdk.core.response.b.b.cK(adTemplate);
        List<a.InterfaceC0298a> gS = this.tq.gS();
        if (cK) {
            com.kwad.sdk.core.local.a.e(com.kwad.sdk.core.response.b.b.cH(adTemplate), com.kwad.sdk.core.response.b.b.cI(adTemplate));
            if (gS != null) {
                Iterator<a.InterfaceC0298a> it = gS.iterator();
                while (it.hasNext()) {
                    it.next().e(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0298a
    public final void onError(int i, String str) {
        List<a.InterfaceC0298a> gS = this.tq.gS();
        if (gS != null) {
            Iterator<a.InterfaceC0298a> it = gS.iterator();
            while (it.hasNext()) {
                it.next().onError(i, str);
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0298a
    public final void onRequestResult(int i) {
        List<a.InterfaceC0298a> gS = this.tq.gS();
        if (gS != null) {
            Iterator<a.InterfaceC0298a> it = gS.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
