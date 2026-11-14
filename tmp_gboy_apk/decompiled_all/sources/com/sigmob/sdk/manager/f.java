package com.sigmob.sdk.manager;

import ADYaiT.CtFAbx;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.common.p;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.base.network.g;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.sdk.mraid.i;
import com.sigmob.sdk.videoAd.k;
import com.sigmob.sdk.videoAd.m;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class f extends b implements h.b, p, e.a {
    protected final Handler f = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.manager.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 8193) {
                f fVar = f.this;
                if (fVar.b == AdStatus.AdStatusLoading) {
                    fVar.f.removeMessages(8193);
                    f.this.a(WindAdError.ERROR_SIGMOB_AD_TIME_OUT);
                }
            }
        }
    };
    protected String g;
    protected String h;
    protected String i;
    protected long j;
    protected LoadAdRequest k;
    protected BaseAdUnit l;
    protected List<BaseAdUnit> m;
    protected i n;
    protected k o;
    protected m p;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.l = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        a(this.k, j.AutoNextPreload);
    }

    public String a() {
        return h(this.b == AdStatus.AdStatusPlaying ? this.l : e());
    }

    public Map<String, BiddingResponse> b() {
        return i(this.b == AdStatus.AdStatusPlaying ? this.l : e());
    }

    @Override // com.sigmob.sdk.base.common.p
    public void c(BaseAdUnit baseAdUnit) {
        a("click", baseAdUnit);
        if (q.b(this.p)) {
            this.p.onAdClicked(this.g);
        }
    }

    @Override // com.sigmob.sdk.base.common.p
    public void d(BaseAdUnit baseAdUnit) {
        a("dismissed", (Map<String, String>) null);
        AdStatus adStatus = this.b;
        AdStatus adStatus2 = AdStatus.AdStatusClose;
        if (adStatus == adStatus2) {
            return;
        }
        this.b = adStatus2;
        if (q.b(this.n)) {
            this.n.b(baseAdUnit);
        }
        o();
        if (q.b(this.p)) {
            this.p.onAdClosed(this.g);
        }
        this.f.post(new A4TApA(this, 1));
        p(baseAdUnit);
    }

    @Override // com.sigmob.sdk.manager.b
    public BaseAdUnit e() {
        if (com.sigmob.sdk.base.utils.e.a(this.m)) {
            return null;
        }
        return this.m.get(0);
    }

    @Override // com.sigmob.sdk.manager.b
    public LoadAdRequest f() {
        return this.k;
    }

    @Override // com.sigmob.sdk.manager.b
    public BaseAdUnit i() {
        return this.l;
    }

    public void k() {
        k kVar;
        if (this.b != AdStatus.AdStatusLoading || (kVar = this.o) == null) {
            return;
        }
        kVar.onAdPreLoadSuccess(this.g);
    }

    public abstract i l();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.sigmob.sdk.mraid.i m() {
        /*
            r6 = this;
            com.sigmob.windad.WindAdError r0 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_CHECK_FAIL
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r6.e()
            com.czhj.sdk.common.models.AdStatus r2 = r6.b
            com.czhj.sdk.common.models.AdStatus r3 = com.czhj.sdk.common.models.AdStatus.AdStatusPlaying
            r4 = 0
            r5 = 0
            if (r2 != r3) goto L18
            com.sigmob.windad.WindAdError r1 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_HAS_PLAYING
            java.lang.String r1 = r1.getMessage()
        L14:
            r0.setMessage(r1)
            goto L52
        L18:
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r3 = r6.m
            if (r3 == 0) goto L4f
            if (r1 != 0) goto L1f
            goto L4f
        L1f:
            com.czhj.sdk.common.models.AdStatus r3 = com.czhj.sdk.common.models.AdStatus.AdStatusReady
            if (r2 == r3) goto L26
            java.lang.String r1 = "ad status is not ready"
            goto L14
        L26:
            com.sigmob.sdk.mraid.i r2 = r6.n
            if (r2 != 0) goto L2d
            java.lang.String r1 = "interstitial object is null"
            goto L14
        L2d:
            boolean r2 = r6.d()
            if (r2 == 0) goto L36
            com.sigmob.windad.WindAdError r0 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_EXPIRED
            goto L53
        L36:
            boolean r2 = r6.g(r1)
            if (r2 != 0) goto L42
            java.lang.String r2 = "check ad unit endcard is invalid"
        L3e:
            r0.setMessage(r2)
            goto L53
        L42:
            com.sigmob.sdk.mraid.i r2 = r6.n
            boolean r2 = r2.a(r1)
            if (r2 != 0) goto L4d
            java.lang.String r2 = "check ad unit info is invalid"
            goto L3e
        L4d:
            r4 = 1
            goto L53
        L4f:
            java.lang.String r1 = "not ready adUnit"
            goto L14
        L52:
            r1 = r5
        L53:
            if (r4 != 0) goto L65
            com.sigmob.sdk.videoAd.m r2 = r6.p
            r6.a(r0, r2)
            r6.b(r6)
            java.lang.String r2 = "play"
            com.sigmob.sdk.base.models.LoadAdRequest r3 = r6.k
            com.sigmob.sdk.base.common.ae.a(r2, r0, r1, r3)
            return r5
        L65:
            com.sigmob.sdk.mraid.i r0 = r6.n
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.manager.f.m():com.sigmob.sdk.mraid.i");
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
        a("destroy", (Map<String, String>) null);
        if (o.b(this.h)) {
            h.b(this.h);
        }
        if (o.b(this.i)) {
            h.b(this.i);
        }
        g();
        this.o = null;
        this.p = null;
        this.l = null;
        this.f.removeCallbacksAndMessages(null);
        b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(BaseAdUnit baseAdUnit) {
        ae.a(PointCategory.LOADSTART, (String) null, baseAdUnit, (WindAdRequest) null, this.k, (ae.a) null);
        g.a(baseAdUnit, "load");
    }

    private void p(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || this.k == null) {
            return;
        }
        int playMode = baseAdUnit.getPlayMode();
        if (baseAdUnit.getDisableAutoLoad() || playMode == 0 || !o.a((CharSequence) baseAdUnit.getBid_token()) || baseAdUnit.bidding_response != null) {
            return;
        }
        this.k.setLastCampid(baseAdUnit.getCamp_id());
        this.k.setLastCrid(baseAdUnit.getCrid());
        a(this.k, j.AutoNextPreload);
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(int i, String str, String str2, LoadAdRequest loadAdRequest) {
        b(loadAdRequest);
        ae.a(PointCategory.RESPOND, Constants.FAIL, i, str, loadAdRequest);
        WindAdError windAdError = WindAdError.getWindAdError(i);
        if (windAdError == null) {
            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setErrorMessage(i, str);
        }
        b(windAdError);
        a(windAdError);
    }

    @Override // com.sigmob.sdk.base.common.p
    public void b(BaseAdUnit baseAdUnit) {
        a("start", baseAdUnit);
        n();
        g();
        b(this);
        if (q.b(this.p)) {
            this.p.onAdShow(this.g);
        }
        if (baseAdUnit == null || this.k == null) {
            return;
        }
        int playMode = baseAdUnit.getPlayMode();
        if (!baseAdUnit.getDisableAutoLoad() && playMode == 0 && o.a((CharSequence) baseAdUnit.getBid_token()) && baseAdUnit.bidding_response == null) {
            this.k.setLastCampid(baseAdUnit.getCamp_id());
            this.k.setLastCrid(baseAdUnit.getCrid());
            this.f.post(new A4TApA(this, 0));
        }
    }

    @Override // com.sigmob.sdk.manager.b
    public boolean c() {
        i iVar;
        BaseAdUnit e = e();
        if (e != null && !d() && g(e) && (iVar = this.n) != null && iVar.a(e) && h.e(e.getUuid()) != null) {
            return true;
        }
        if (!q.b(e)) {
            return false;
        }
        h.g().e(e);
        return false;
    }

    @Override // com.sigmob.sdk.manager.b
    public boolean d() {
        if (this.j == 0) {
            return false;
        }
        return f(e());
    }

    @Override // com.sigmob.sdk.base.common.p
    public void e(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return;
        }
        h.g().j(baseAdUnit.getCamp_id());
        h.g().i(baseAdUnit.getCrid());
        g();
    }

    public void n(BaseAdUnit baseAdUnit) {
        if (q.b(this.p)) {
            this.p.onVideoAdPlayEnd(this.g);
        }
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit) {
        o(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.p
    public void b(BaseAdUnit baseAdUnit, String str) {
        this.f.removeMessages(8193);
        com.sigmob.sdk.base.utils.i.f(this.f13439a, CtFAbx.BChYOn("onInterstitialFailed: error = ", str), new Object[0]);
        ae.a(PointCategory.LOADEND, Constants.FAIL, baseAdUnit, (WindAdRequest) null, this.k, (ae.a) null);
        g.a(baseAdUnit, com.sigmob.sdk.base.common.a.y);
        g();
        if (baseAdUnit != null && baseAdUnit.getPlayMode() == 0) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
            windAdError.setMessage(str);
            a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
            a(windAdError);
        }
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit, String str) {
        a(baseAdUnit, str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseAdUnit baseAdUnit, String str, boolean z) {
        g.a(baseAdUnit, o.a((CharSequence) str) ? com.sigmob.sdk.base.common.a.x : com.sigmob.sdk.base.common.a.y);
        ae.a(PointCategory.LOADEND, o.a((CharSequence) str) ? "1" : Constants.FAIL, baseAdUnit, (WindAdRequest) null, this.k, (ae.a) null);
        this.f.removeMessages(8193);
        if (baseAdUnit == null) {
            return;
        }
        if (z) {
            a(baseAdUnit, this.k);
        }
        if (baseAdUnit.getPlayMode() == 0) {
            if (o.a((CharSequence) str)) {
                this.j = baseAdUnit.getCreate_time();
                if (q.b(Boolean.valueOf(z))) {
                    a((WindAdError) null);
                    return;
                }
                return;
            }
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
            windAdError.setMessage(str);
            a(baseAdUnit, "load", baseAdUnit.getAd_type(), baseAdUnit.getAdslot_id(), baseAdUnit.getLoad_id(), windAdError);
            if (q.b(Boolean.valueOf(z))) {
                a(windAdError);
            }
            g();
        }
    }

    public void a(LoadAdRequest loadAdRequest, j jVar) {
        a(loadAdRequest, jVar, (String) null, new e.a() { // from class: com.sigmob.sdk.manager.f.2
            @Override // com.sigmob.sdk.base.network.e.a
            public void a(int i, String str, String str2, LoadAdRequest loadAdRequest2) {
                f.this.b(loadAdRequest2);
                ae.a(PointCategory.RESPOND, Constants.FAIL, i, str, loadAdRequest2);
            }

            @Override // com.sigmob.sdk.base.network.e.a
            public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest2) {
                if (com.sigmob.sdk.base.utils.e.a(list)) {
                    return;
                }
                BaseAdUnit baseAdUnit = list.get(0);
                f.this.i = baseAdUnit.getRequestId();
                f fVar = f.this;
                fVar.m = list;
                fVar.a(list, loadAdRequest2, baseAdUnit);
                int request_scene_type = loadAdRequest2.getRequest_scene_type();
                f.this.a(request_scene_type);
                SigmobLog.d("preloadAdsRequest: sceneType = " + request_scene_type);
                if (q.b(f.this.n) && !f.this.n.a(baseAdUnit)) {
                    f.this.a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                    return;
                }
                for (BaseAdUnit baseAdUnit2 : f.this.m) {
                    if (b.m(baseAdUnit2)) {
                        h.g().f(baseAdUnit2);
                    }
                }
                int playMode = baseAdUnit.getPlayMode();
                if (playMode != 0) {
                    f.this.j = baseAdUnit.getCreate_time();
                }
                h.a(list);
                h.b bVar = new h.b() { // from class: com.sigmob.sdk.manager.f.2.1
                    @Override // com.sigmob.sdk.base.common.h.b
                    public void a(BaseAdUnit baseAdUnit3) {
                        f.this.o(baseAdUnit3);
                    }

                    @Override // com.sigmob.sdk.base.common.h.b
                    public void a(BaseAdUnit baseAdUnit3, String str) {
                        f.this.a(baseAdUnit3, str, true);
                    }
                };
                int creativeType = baseAdUnit.getCreativeType();
                SigmobLog.d("preloadAdsRequest: playMode = " + playMode + ", creativeType = " + creativeType);
                if (creativeType != n.CreativeTypeMRAIDTWO.a()) {
                    if (playMode == 2) {
                        f.this.a(baseAdUnit, loadAdRequest2);
                        return;
                    } else {
                        f.this.n.a(new HashMap(), baseAdUnit);
                        h.g().a(baseAdUnit, bVar);
                        return;
                    }
                }
                boolean a2 = new com.sigmob.sdk.base.common.e(list, bVar, f.this.k).a(false);
                SigmobLog.d("preloadAdsRequest: cache = " + a2);
                if (a2) {
                    f.this.n.a(new HashMap(), baseAdUnit);
                } else {
                    f.this.a(baseAdUnit, loadAdRequest2);
                }
            }
        });
    }

    public void a(LoadAdRequest loadAdRequest, j jVar, String str, e.a aVar) {
        g();
        boolean a2 = b.a(jVar);
        loadAdRequest.setOriginVid(a2 ? this.d : "");
        loadAdRequest.setOriginPrice(a2 ? this.e : "");
        loadAdRequest.setRequest_scene_type(jVar.a());
        loadAdRequest.setExpired(d());
        if (!o.b(str)) {
            str = b.j();
        }
        this.k.setTraceId(str);
        a(loadAdRequest);
        com.sigmob.sdk.base.network.e.a(loadAdRequest, aVar);
    }

    public void a(LoadAdRequest loadAdRequest, m mVar) {
        this.p = mVar;
        this.k = loadAdRequest;
        i m = m();
        if (m == null) {
            return;
        }
        BaseAdUnit e = e();
        this.l = e;
        this.h = e.getRequestId();
        String loadId = this.k.getLoadId();
        String adSceneId = this.k.getAdSceneId();
        String adSceneDesc = this.k.getAdSceneDesc();
        this.l.setLoad_id(loadId);
        this.l.setAd_scene_id(adSceneId);
        this.l.setAd_scene_desc(adSceneDesc);
        SigMacroCommon macroCommon = this.l.getMacroCommon();
        if (o.b(adSceneDesc)) {
            macroCommon.addMarcoKey(SigMacroCommon._ADSCENE_, adSceneDesc);
        }
        if (o.b(adSceneId)) {
            macroCommon.addMarcoKey(SigMacroCommon._ADSCENEID_, adSceneId);
        }
        String video_url = this.l.getVideo_url();
        if (o.b(video_url)) {
            macroCommon.addMarcoKey(SigMacroCommon._VMD5_, h.g().k(this.l.getVideoPath()));
            try {
                macroCommon.addMarcoKey(SigMacroCommon._VURL_, URLEncoder.encode(video_url, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                SigmobLog.e("show: error = " + e2.getMessage());
            }
        }
        boolean z = true;
        if (this.l.getCreativeType() == n.CreativeTypeMRAIDTWO.a()) {
            if (!new com.sigmob.sdk.base.common.e(this.m, this, this.k).a(true)) {
                m.a(new HashMap(), this.l);
            }
        } else if (this.l.getPlayMode() == 2) {
            m.a(new HashMap(), this.l);
            h.g().a(this.l, this);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.sigmob.sdk.base.n.v, this.k.isEnable_keep_on() || com.sigmob.sdk.base.o.a().i());
        if (!this.k.isEnable_screen_lock_displayad() && !com.sigmob.sdk.base.o.a().h()) {
            z = false;
        }
        bundle.putBoolean(com.sigmob.sdk.base.n.u, z);
        m.a(this.l, bundle);
        this.b = AdStatus.AdStatusPlaying;
        this.j = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LoadAdRequest loadAdRequest) {
        ae.a(PointCategory.RESPOND, Constants.FAIL, loadAdRequest);
    }

    public void a(LoadAdRequest loadAdRequest, String str) {
        this.b = AdStatus.AdStatusLoading;
        if (loadAdRequest == null || o.a((CharSequence) loadAdRequest.getPlacementId())) {
            SigmobLog.e("loadAd: request or placementId is null.");
            a(WindAdError.ERROR_SIGMOB_PLACEMENTID_EMPTY);
            return;
        }
        try {
            WindAdError sigMobError = Sigmob.getInstance().getSigMobError();
            if (q.b(sigMobError)) {
                SigmobLog.e("loadAd: error = " + sigMobError);
                PointEntitySigmobError.SigmobError("load", sigMobError.getErrorCode(), sigMobError.getMessage()).commit();
                a(sigMobError);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (o.b(loadAdRequest.getBidToken())) {
            g();
        }
        this.g = loadAdRequest.getPlacementId();
        this.k = loadAdRequest;
        if (this.n == null) {
            this.n = l();
        }
        if (b(loadAdRequest, str)) {
            return;
        }
        if (o.b(this.h)) {
            h.b(this.h);
        }
        if (o.b(this.i)) {
            h.b(this.i);
        }
        loadAdRequest.setLastCampid(h.g().o());
        loadAdRequest.setLastCrid(h.g().n());
        a(loadAdRequest, j.NormalRequest, str, this);
        this.f.sendEmptyMessageDelayed(8193, com.sigmob.sdk.base.o.a().x());
    }

    public void b(WindAdError windAdError) {
        k kVar;
        if (this.b != AdStatus.AdStatusLoading || (kVar = this.o) == null) {
            return;
        }
        kVar.onAdPreLoadFail(windAdError, this.g);
    }

    private boolean b(LoadAdRequest loadAdRequest, String str) {
        if (!c()) {
            return false;
        }
        BaseAdUnit e = e();
        if (q.b(e)) {
            e.setTraceId(str);
            e.setRequestSceneType(loadAdRequest.getRequest_scene_type());
        }
        this.n.a((Map<String, Object>) null, e);
        SigmobLog.d("isExistCache: placementId = " + this.g);
        k();
        a((WindAdError) null);
        k(e);
        return true;
    }

    public void a(k kVar) {
        this.o = kVar;
    }

    public void a(WindAdError windAdError) {
        if (this.b != AdStatus.AdStatusLoading) {
            return;
        }
        if (windAdError == null) {
            this.b = AdStatus.AdStatusReady;
            a(this);
            a(e(), this.k);
        } else {
            this.b = AdStatus.AdStatusNone;
        }
        String h = h();
        k kVar = this.o;
        if (kVar == null) {
            return;
        }
        if (windAdError == null) {
            kVar.onAdLoadSuccess(h);
        } else {
            kVar.onAdLoadError(windAdError, h);
        }
    }

    public void a(String str, String str2) {
        a(this.b == AdStatus.AdStatusPlaying ? this.l : e(), str, str2);
    }

    @Override // com.sigmob.sdk.manager.b
    public void a(String str, String str2, j jVar) {
        super.a(str, str2, jVar);
        LoadAdRequest f = f();
        if (f != null && o.a((CharSequence) f.getBidToken())) {
            f.setLastCampid("");
            f.setLastCrid("");
            a(f, jVar);
        }
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        WindAdError windAdError;
        try {
            if (com.sigmob.sdk.base.utils.e.a(list)) {
                windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
                b(windAdError);
                ae.a(PointCategory.RESPOND, Constants.FAIL, windAdError.getErrorCode(), windAdError.getMessage(), loadAdRequest);
            } else {
                BaseAdUnit baseAdUnit = list.get(0);
                this.h = baseAdUnit.getRequestId();
                this.m = list;
                a(list, loadAdRequest, baseAdUnit);
                if (this.n == null) {
                    this.n = l();
                }
                if (this.n.a(baseAdUnit)) {
                    k();
                    h.a(list);
                    for (BaseAdUnit baseAdUnit2 : this.m) {
                        if (b.m(baseAdUnit2)) {
                            h.g().f(baseAdUnit2);
                        }
                    }
                    int playMode = baseAdUnit.getPlayMode();
                    if (playMode != 0) {
                        this.j = baseAdUnit.getCreate_time();
                        a((WindAdError) null);
                    }
                    if (baseAdUnit.getCreativeType() == n.CreativeTypeMRAIDTWO.a()) {
                        if (new com.sigmob.sdk.base.common.e(list, this, this.k).a(false)) {
                            this.n.a(new HashMap(), baseAdUnit);
                            return;
                        }
                        return;
                    }
                    if (playMode == 2) {
                        return;
                    }
                    this.n.a(new HashMap(), baseAdUnit);
                    h.g().a(baseAdUnit, this);
                    return;
                }
                windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
            }
            a(windAdError);
        } catch (Throwable th) {
            String message = th.getMessage();
            SigmobLog.e("onSuccess: error = " + message);
            g();
            WindAdError windAdError2 = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
            int errorCode = windAdError2.getErrorCode();
            windAdError2.setMessage(message);
            ae.a(PointCategory.RESPOND, Constants.FAIL, errorCode, message, loadAdRequest);
            a(windAdError2);
        }
    }
}
