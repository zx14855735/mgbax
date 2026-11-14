package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class f extends b implements com.kwad.sdk.widget.d {
    private KsAdVideoPlayConfig bU;
    private List<Integer> ck;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0370a cz;
    private KSFrameLayout fC;
    private ImageView hM;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    protected Context mContext;
    private c mi;
    private KSFrameLayout nh;
    private com.kwad.components.core.video.f ni;
    private boolean mIsAudioEnable = false;
    private final a.InterfaceC0313a hQ = new a.InterfaceC0313a() { // from class: com.kwad.components.ad.interstitial.f.f.4
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        @Override // com.kwad.components.core.video.a.InterfaceC0313a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(int r11, com.kwad.sdk.utils.aj.a r12) {
            /*
                r10 = this;
                r0 = 2
                r1 = 1
                r2 = 0
                if (r11 == r1) goto L16
                if (r11 == r0) goto L13
                r3 = 3
                if (r11 == r3) goto Le
                r11 = 108(0x6c, float:1.51E-43)
            Lc:
                r3 = 2
                goto L19
            Le:
                r11 = 83
                r2 = 1
                r3 = 1
                goto L19
            L13:
                r11 = 82
                goto Lc
            L16:
                r11 = 13
                goto Lc
            L19:
                com.kwad.components.ad.interstitial.f.f r4 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.ad.interstitial.f.f.d(r4)
                boolean r4 = com.kwad.sdk.utils.aq.SM()
                if (r4 == 0) goto L25
                goto L26
            L25:
                r0 = 1
            L26:
                com.kwad.components.ad.interstitial.report.a r4 = com.kwad.components.ad.interstitial.report.a.eP()
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.a(r5)
                r6 = 1
                long r8 = (long) r11
                r4.a(r5, r6, r8)
                com.kwad.components.core.e.d.a$a r4 = new com.kwad.components.core.e.d.a$a
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                android.content.Context r5 = com.kwad.components.ad.interstitial.f.f.f(r5)
                r4.<init>(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.sdk.core.response.model.AdTemplate r5 = com.kwad.components.ad.interstitial.f.f.a(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.aE(r5)
                com.kwad.components.ad.interstitial.f.f r5 = com.kwad.components.ad.interstitial.f.f.this
                com.kwad.components.core.e.d.d r5 = com.kwad.components.ad.interstitial.f.f.e(r5)
                com.kwad.components.core.e.d.a$a r4 = r4.b(r5)
                com.kwad.components.core.e.d.a$a r3 = r4.aD(r3)
                com.kwad.components.core.e.d.a$a r2 = r3.as(r2)
                com.kwad.components.core.e.d.a$a r1 = r2.au(r1)
                com.kwad.components.core.e.d.a$a r1 = r1.aC(r11)
                com.kwad.components.core.e.d.a$a r12 = r1.d(r12)
                com.kwad.components.core.e.d.a$a r12 = r12.aE(r0)
                com.kwad.components.ad.interstitial.f.f$4$1 r0 = new com.kwad.components.ad.interstitial.f.f$4$1
                r0.<init>()
                com.kwad.components.core.e.d.a$a r11 = r12.a(r0)
                com.kwad.components.core.e.d.a.a(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.f.f.AnonymousClass4.a(int, com.kwad.sdk.utils.aj$a):void");
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:15:0x009a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void ey() {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.f.f.ey():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j) {
        c cVar = this.mi;
        cVar.mk = true;
        cVar.c(1L, j);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        c cVar = (c) PC();
        this.mi = cVar;
        this.bU = cVar.bU;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        this.mAdInfo = er;
        List<Integer> bq = com.kwad.sdk.core.response.b.a.bq(er);
        this.ck = bq;
        com.kwad.sdk.core.video.videoview.a aVar = this.mi.cq;
        this.cq = aVar;
        aVar.setTag(bq);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.cq);
        this.ni = fVar;
        fVar.setDataFlowAutoStart(this.bU.isDataFlowAutoStart());
        this.ni.setAdClickListener(this.hQ);
        this.ni.uZ();
        this.mApkDownloadHelper = this.mi.mApkDownloadHelper;
        ey();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.fC.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nh = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.fC = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.hM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.fC.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mi.mq = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.mi.a(c(view, true));
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        this.mi.a(c(view, false));
    }

    private c.C0240c c(View view, boolean z) {
        return new c.C0240c(view.getContext()).l(z).a(this.nh.getTouchCoords()).L(3).M(85);
    }
}
