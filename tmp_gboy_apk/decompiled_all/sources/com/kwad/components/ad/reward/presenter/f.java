package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.reward.A2egSU;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class f {
    private static long vG;

    private static boolean N(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.er(adTemplate)));
    }

    private static boolean O(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.O(adTemplate);
    }

    private static boolean V(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.al(com.kwad.sdk.core.response.b.e.er(adTemplate));
    }

    public static void a(final com.kwad.components.ad.reward.g gVar, boolean z) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        final AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (!gVar.rW) {
            o(gVar);
            return;
        }
        q(gVar);
        boolean z2 = !gVar.gX() && V(gVar.mAdTemplate);
        if (N(adTemplate) || O(adTemplate) || gVar.sv < com.kwad.sdk.core.response.b.a.ah(er)) {
            if (z2) {
                a(gVar, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.2
                    @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
                    public final void H(boolean z3) {
                        super.H(z3);
                        if (com.kwad.components.ad.reward.a.b.k(AdInfo.this)) {
                            gVar.iA();
                        } else if (com.kwad.sdk.core.response.b.a.bX(AdInfo.this)) {
                            f.p(gVar);
                        } else {
                            f.r(gVar);
                            com.kwad.components.ad.reward.l.j(gVar);
                        }
                    }
                });
                return;
            } else if (com.kwad.sdk.core.response.b.a.bX(er)) {
                p(gVar);
                return;
            } else {
                r(gVar);
                com.kwad.components.ad.reward.l.j(gVar);
                return;
            }
        }
        if (gVar.sp) {
            gVar.iA();
            return;
        }
        if (!gVar.sw && gVar.sv < com.kwad.sdk.core.response.b.a.ah(er)) {
            if (z) {
                gVar.iA();
                return;
            }
            return;
        }
        if (gVar.sw) {
            gVar.Z(2);
        } else {
            gVar.Z(1);
        }
        y(gVar);
        if (com.kwad.sdk.core.response.b.a.bX(er)) {
            p(gVar);
        } else {
            r(gVar);
            com.kwad.components.ad.reward.l.j(gVar);
        }
    }

    private static void o(final com.kwad.components.ad.reward.g gVar) {
        if (com.kwad.sdk.core.response.b.a.bW(com.kwad.sdk.core.response.b.e.er(gVar.mAdTemplate))) {
            p(gVar);
            return;
        }
        if (gVar.rY) {
            r(gVar);
            return;
        }
        gVar.sb = true;
        com.kwad.components.ad.reward.g.a(gVar.rO, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jW();
            }
        });
        gVar.rG.onVideoSkipToEnd(0L);
        com.kwad.sdk.core.adlog.c.i(gVar.mAdTemplate, gVar.mReportExtData);
        com.kwad.components.ad.reward.m.e eVar = gVar.rH;
        if (eVar != null) {
            eVar.release();
        }
        gVar.gL();
        u(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(final com.kwad.components.ad.reward.g gVar) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.presenter.f.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.ad.reward.g.this.gY();
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.rG.onVideoSkipToEnd(gVar2.sv);
                com.kwad.components.ad.reward.g.this.release();
                com.kwad.components.ad.reward.g.this.iA();
            }
        });
    }

    private static void q(com.kwad.components.ad.reward.g gVar) {
        long j = gVar.su;
        int i = j != 0 ? (int) (j / 1000) : 0;
        long j2 = gVar.sv;
        com.kwad.sdk.core.adlog.c.e(gVar.mAdTemplate, gVar.mReportExtData, new com.kwad.sdk.core.adlog.c.b().dx(69).dA(i).dB(j2 != 0 ? (int) (j2 / 1000) : 0));
    }

    public static void r(final com.kwad.components.ad.reward.g gVar) {
        gVar.sb = true;
        gVar.gY();
        if (i.z(gVar)) {
            bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.s(com.kwad.components.ad.reward.g.this);
                }
            }, 200L);
        } else {
            s(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(final com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.ad.reward.g.a(gVar.rO, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jW();
            }
        });
        com.kwad.components.ad.reward.m.e eVar = gVar.rH;
        if (eVar != null) {
            eVar.skipToEnd();
        }
    }

    public static void t(com.kwad.components.ad.reward.g gVar) {
        x(gVar);
        gVar.iA();
    }

    public static void u(com.kwad.components.ad.reward.g gVar) {
        com.kwad.sdk.core.d.c.d("openAppMarket", "tryOpenAppMarket");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - vG < 300) {
            com.kwad.sdk.core.d.c.d("openAppMarket", "连续点击");
            return;
        }
        vG = elapsedRealtime;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (a(er, "openAppMarket")) {
            return;
        }
        Context context = gVar.mContext;
        if (a("openAppMarket", adTemplate, er)) {
            return;
        }
        com.kwad.sdk.core.adlog.c.b dH = new com.kwad.sdk.core.adlog.c.b().dv(MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID).dH(8);
        boolean z = com.kwad.sdk.core.download.a.b.H(context, com.kwad.sdk.core.response.b.a.cU(er)) == 1;
        com.kwad.sdk.core.d.c.i("openAppMarket", "handleDeepLink dpSuccess: " + z);
        if (z) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", dH, (JSONObject) null);
            com.kwad.components.ad.reward.h.a.J(context);
            return;
        }
        String cX = com.kwad.sdk.core.response.b.a.cX(er);
        com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore url：" + cX);
        if (com.kwad.sdk.utils.e.a(context, cX, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", dH, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.h(adTemplate, 1, 8);
            com.kwad.components.ad.reward.h.a.J(context);
        } else {
            if (!com.kwad.sdk.utils.e.l(context, adTemplate)) {
                com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore failed");
                return;
            }
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", dH, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.h(adTemplate, 0, 8);
            com.kwad.components.ad.reward.h.a.J(context);
        }
    }

    public static void v(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (!gVar.rW) {
            x(gVar);
            gVar.iA();
            return;
        }
        if (!N(adTemplate) && !O(adTemplate)) {
            long ah = com.kwad.sdk.core.response.b.a.ah(er);
            if (gVar.sw || gVar.sv >= ah) {
                y(gVar);
            }
            x(gVar);
            gVar.iA();
            return;
        }
        q(gVar);
        if (!gVar.gX() && V(gVar.mAdTemplate) && !gVar.sb) {
            w(gVar);
        } else {
            x(gVar);
            gVar.iA();
        }
    }

    private static void w(final com.kwad.components.ad.reward.g gVar) {
        final AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.reward.g.a(gVar, com.kwad.components.ad.reward.h.a(gVar, (String) null), new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.6
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void H(boolean z) {
                com.kwad.components.ad.reward.g.this.F(false);
                if (!z) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS);
                }
                f.x(com.kwad.components.ad.reward.g.this);
                com.kwad.components.ad.reward.g.this.iA();
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hb() {
                com.kwad.components.ad.reward.g.this.F(true);
                com.kwad.sdk.core.adlog.c.b(adTemplate, 149, com.kwad.components.ad.reward.g.this.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hk() {
                com.kwad.components.ad.reward.g.this.F(false);
                com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(com.kwad.components.ad.reward.g gVar) {
        gVar.rG.i(false);
    }

    private static void y(com.kwad.components.ad.reward.g gVar) {
        gVar.rG.onRewardVerify();
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bL(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is playable return");
            return true;
        }
        if (!com.kwad.sdk.core.response.b.a.aG(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is not Download type");
            return true;
        }
        if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(adInfo))) {
            com.kwad.sdk.core.d.c.i(str, "isRewardLaunchAppTask");
            return true;
        }
        if (!com.kwad.components.ad.reward.g.g(adInfo)) {
            return false;
        }
        com.kwad.sdk.core.d.c.i(str, "is Aggregation return");
        return true;
    }

    private static boolean a(AdInfo adInfo, String str) {
        if (!com.kwad.components.ad.reward.a.b.hM()) {
            com.kwad.sdk.core.d.c.e(str, "isEnable false");
            return true;
        }
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.cX(adInfo))) {
            return true;
        }
        int hL = com.kwad.components.ad.reward.a.b.hL();
        A2egSU.A4TApA(hL, "JumpDirectMaxCount ", str);
        return hL <= 0 || com.kwad.components.ad.reward.h.a.dP() >= hL;
    }

    private static void a(final com.kwad.components.ad.reward.g gVar, final h.b bVar) {
        String str;
        final AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        final JSONObject jSONObject = gVar.mReportExtData;
        long ae = com.kwad.sdk.core.response.b.a.ae(er);
        if (ae > 0 && com.kwad.sdk.core.response.b.a.M(er) > ae) {
            str = "观看视频" + ae + "s即可获取奖励";
        } else {
            str = "观看完整视频即可获取奖励";
        }
        final h.c a2 = com.kwad.components.ad.reward.h.a(gVar, str);
        com.kwad.components.ad.reward.g.a(gVar, a2, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.7
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void H(boolean z) {
                com.kwad.components.ad.reward.g.this.F(false);
                if (!z) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS);
                }
                h.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.H(z);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void h(int i, int i2) {
                super.h(i, i2);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, i, i2);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hb() {
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.rH;
                if (eVar != null) {
                    eVar.pause();
                }
                com.kwad.components.ad.reward.g.this.F(true);
                if (a2.getStyle() == 0) {
                    com.kwad.sdk.core.adlog.c.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.adlog.c.b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void hi() {
                super.hi();
                com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, 156, 1);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hj() {
                super.hj();
                com.kwad.components.ad.reward.g.this.F(false);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hk() {
                com.kwad.components.ad.reward.g.this.F(false);
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.rH;
                if (eVar != null) {
                    eVar.resume();
                }
                if (a2.getStyle() == 1 || a2.getStyle() == 2 || a2.getStyle() == 5 || a2.getStyle() == 8) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
                } else {
                    com.kwad.sdk.core.adlog.c.k(adTemplate, jSONObject);
                }
            }
        });
    }
}
