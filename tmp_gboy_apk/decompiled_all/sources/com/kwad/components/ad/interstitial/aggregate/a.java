package com.kwad.components.ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.A2egSU;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.ad.interstitial.h.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a extends A2egSU {
    private final KsAdVideoPlayConfig bU;
    private final KsInterstitialAd.AdInteractionListener kP;
    private final d kV;
    private final boolean kW;
    private b kX;
    private InterfaceC0236a kY;
    private AdResultData mAdResultData;
    private final List<AdTemplate> mAdTemplateList = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0236a {
        void dA();
    }

    public interface b {
        void a(c cVar, int i);
    }

    public a(AdResultData adResultData, d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdResultData = adResultData;
        this.kV = dVar;
        this.bU = ksAdVideoPlayConfig;
        this.kP = adInteractionListener;
        this.kW = com.kwad.sdk.core.response.b.a.cB(e.er(com.kwad.sdk.core.response.b.c.r(adResultData))) == 1;
    }

    public final void d(List<AdTemplate> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(list);
    }

    @Override // androidx.viewpager.widget.A2egSU
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.A2egSU
    public final int getCount() {
        return this.mAdTemplateList.size();
    }

    @Override // androidx.viewpager.widget.A2egSU
    public final Object instantiateItem(ViewGroup viewGroup, final int i) {
        c cVar = new c(viewGroup.getContext());
        viewGroup.addView(cVar);
        cVar.setAggregateAdView(i > 0);
        cVar.setAdAggregateClickActionListener(new c.a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
            @Override // com.kwad.components.ad.interstitial.f.c.a
            public final void a(long j, long j2, boolean z) {
                AdTemplate adTemplate = (AdTemplate) a.this.mAdTemplateList.get(i);
                if (adTemplate == null) {
                    return;
                }
                if (i == 0 && z) {
                    com.kwad.components.ad.interstitial.report.a.eP().b(adTemplate, j, j2);
                }
                if (a.this.kY != null) {
                    a.this.kY.dA();
                }
            }
        });
        if (i > 0) {
            cVar.setAggregateShowTriggerType(8);
        }
        cVar.a(this.mAdResultData, this.kV, this.bU, this.kP, i);
        b bVar = this.kX;
        if (bVar != null) {
            bVar.a(cVar, i);
        }
        return cVar;
    }

    @Override // androidx.viewpager.widget.A2egSU
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final void a(b bVar) {
        this.kX = bVar;
    }

    public final void a(InterfaceC0236a interfaceC0236a) {
        this.kY = interfaceC0236a;
    }
}
