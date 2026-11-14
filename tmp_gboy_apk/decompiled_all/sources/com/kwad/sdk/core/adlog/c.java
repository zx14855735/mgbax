package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import com.sigmob.sdk.base.mta.PointType;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    private static ExecutorService aBP = GlobalThreadPools.Lk();
    public static JSONObject aBQ;
    public static boolean aBR;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public a(int i, String str) {
            this.code = i;
            this.msg = str;
        }
    }

    static {
        DIpu();
    }

    private static /* synthetic */ void DIpu() {
        char[] charArray = "·»¹ú³µ¹±ú¶»\u00adú§¼±¸¸ú\u009eº½\u0096¦½°³±".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 212);
        }
        String str = new String(charArray);
        char[] charArray2 = "·¸½º½ ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 212);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static int Gn() {
        return aq.isOrientationPortrait() ? 2 : 1;
    }

    private static boolean H(AdInfo adInfo) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return false;
        }
        String az = com.kwad.sdk.core.response.b.a.az(adInfo);
        if (TextUtils.isEmpty(az)) {
            return false;
        }
        return as.as(fVar.getContext(), az);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (aVar != null) {
            try {
                if (adTemplate.fromCache) {
                    aVar.a(h.cn(adTemplate));
                }
                aVar.e(adTemplate, null, null);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void bU(AdTemplate adTemplate) {
        r(adTemplate, 4);
    }

    public static void bV(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        adTemplate.downLoadType = 3;
        aVar.a(new a.C0353a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void bW(AdTemplate adTemplate) {
        r(adTemplate, 36);
    }

    public static void bX(AdTemplate adTemplate) {
        r(adTemplate, 38);
    }

    public static void bY(AdTemplate adTemplate) {
        r(adTemplate, 41);
    }

    public static void bZ(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCI = com.kwad.sdk.core.response.b.a.az(e.er(adTemplate));
        a(adTemplate, 768, aVar, new JSONObject());
    }

    public static void c(final AdTemplate adTemplate, final JSONObject jSONObject) {
        aBP.submit(new bg() { // from class: com.kwad.sdk.core.adlog.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.C0353a c0353a = new a.C0353a();
                c0353a.aBx = AdTemplate.this.downLoadType;
                com.kwad.sdk.core.adlog.c.b dy = new com.kwad.sdk.core.adlog.c.b().b(c0353a).dy(AdTemplate.this.downloadSource);
                c.a(AdTemplate.this, dy);
                c.a(AdTemplate.this, 31, dy.GB(), jSONObject);
                AdInfo er = e.er(AdTemplate.this);
                as.ay(er.downloadFilePath, er.downloadId);
            }
        });
    }

    public static void ca(AdTemplate adTemplate) {
        f(adTemplate, null);
    }

    public static void cb(AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void cc(AdTemplate adTemplate) {
        r(adTemplate, 58);
    }

    public static void cd(AdTemplate adTemplate) {
        r(adTemplate, 914);
    }

    public static void ce(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadStatus = com.kwad.sdk.core.response.b.a.bB(e.er(adTemplate));
        A2egSU.BChYOn(new StringBuilder("reportDownloadCardClose downloadStatus="), aVar.downloadStatus, "AdReportManager");
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, aVar, (JSONObject) null);
    }

    public static void cf(AdTemplate adTemplate) {
        r(adTemplate, 722);
    }

    public static void cg(AdTemplate adTemplate) {
        r(adTemplate, 721);
    }

    public static void ch(AdTemplate adTemplate) {
        a.C0353a c0353a = new a.C0353a();
        c0353a.aBI = com.kwad.sdk.core.response.b.a.dA(e.er(adTemplate)) ? 1 : 0;
        c0353a.aBM = 1;
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.b(c0353a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, bVar.GB(), (JSONObject) null);
    }

    private static boolean ci(AdTemplate adTemplate) {
        if (e.ej(adTemplate)) {
            return true;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        return fVar != null && fVar.aU(adTemplate);
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0353a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        aBP.submit(new bg() { // from class: com.kwad.sdk.core.adlog.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = e.er(AdTemplate.this);
                int az = as.az(er.downloadId, com.kwad.sdk.core.response.b.a.az(er));
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.downloadSource = adTemplate2.downloadSource;
                aVar.aCD = az;
                aVar.aCE = adTemplate2.installFrom;
                aVar.a(new a.C0353a());
                a.C0353a c0353a = aVar.PJ;
                AdTemplate adTemplate3 = AdTemplate.this;
                c0353a.aBx = adTemplate3.downLoadType;
                c.a(adTemplate3, 32, aVar, jSONObject);
            }
        });
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void g(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, jSONObject);
    }

    public static void h(AdTemplate adTemplate, int i) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i == 1;
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCU = i;
        aVar.a(new a.C0353a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 37, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.PK = i;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCC = i;
        b(adTemplate, "wxsmallapp", 1, aVar);
    }

    public static void k(AdTemplate adTemplate, int i) {
        h(adTemplate, i, 0);
    }

    public static void l(AdTemplate adTemplate, long j) {
        a(adTemplate, 52, com.kwad.sdk.core.adlog.c.a.Gz().av(j), (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCm = i;
        a(adTemplate, 28, aVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCI = com.kwad.sdk.core.response.b.a.az(e.er(adTemplate));
        a(adTemplate, i, aVar, new JSONObject());
    }

    public static void o(AdTemplate adTemplate, int i) {
        a(adTemplate, i, new com.kwad.sdk.core.adlog.c.a(), new JSONObject());
    }

    @Deprecated
    public static void p(AdTemplate adTemplate, int i) {
        e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().dx(i));
    }

    public static void q(AdTemplate adTemplate, int i) {
        a.C0353a c0353a = new a.C0353a();
        c0353a.aBI = com.kwad.sdk.core.response.b.a.dA(e.er(adTemplate)) ? 1 : 0;
        c0353a.aBM = i;
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.b(c0353a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, bVar.GB(), (JSONObject) null);
    }

    private static void r(AdTemplate adTemplate, int i) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, new JSONObject());
    }

    public static boolean b(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo er = e.er(adTemplate);
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.dJ(Gn());
        com.kwad.sdk.core.adlog.c.a GB = bVar.GB();
        if (adTemplate.fromCache) {
            GB.a(h.cn(adTemplate));
        }
        GB.aCP = H(er) ? 1 : 0;
        return a(adTemplate, 1, GB, jSONObject);
    }

    public static void c(AdTemplate adTemplate, String str, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCA = i;
        if (!str.equals("")) {
            aVar.aCB = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, aVar, (JSONObject) null);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a GB = bVar.GB();
        GB.e(adTemplate, null, null);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, GB, jSONObject);
    }

    public static void g(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0353a c0353a = new a.C0353a();
        if (z) {
            c0353a.aBB = 1;
        } else {
            c0353a.aBB = 2;
        }
        aVar.a(c0353a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void k(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, jSONObject);
    }

    public static void l(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCn = i;
        a(adTemplate, 759, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE, jSONObject);
    }

    public static void j(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, jSONObject);
    }

    public static void m(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCr = j;
        a(adTemplate, 600, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCp = 69;
        aVar.aCK = i;
        aVar.aCL = i2;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0353a c0353a = new a.C0353a();
        c0353a.aBy = 2;
        bVar.b(c0353a);
        if (z) {
            bVar.dE(33);
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, bVar.GB(), (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCN = j;
        a(adTemplate, 401, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, aj.a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.mH = i;
        int i2 = adTemplate.swipeAngle;
        if (i2 != 0) {
            aVar2.aCY = i2;
        }
        if (aVar != null) {
            aVar2.mJ = aVar;
        }
        a(adTemplate, aVar2, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a GB = bVar.GB();
        GB.e(adTemplate, null, null);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, GB, jSONObject);
    }

    public static void c(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, bVar != null ? bVar.GB() : null, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCo = 1;
        a.C0353a c0353a = new a.C0353a();
        aVar.PJ = c0353a;
        c0353a.templateId = PointType.ANTI_SPAM;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCI = com.kwad.sdk.core.response.b.a.az(e.er(adTemplate));
        aVar.aCp = 93;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, aVar, (JSONObject) null);
    }

    private static void d(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, jSONObject);
    }

    public static void i(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0353a c0353a = new a.C0353a();
        c0353a.aBy = 1;
        bVar.b(c0353a);
        if (z) {
            bVar.dE(33);
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, bVar.GB(), (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, bVar != null ? bVar.GB() : null, jSONObject);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, 3, bVar != null ? bVar.GB() : null, jSONObject);
    }

    public static void h(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCO = i;
        aVar.PL = i2;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, long j, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0353a c0353a = new a.C0353a();
        if (j != -1) {
            c0353a.duration = j;
            aVar.PJ = c0353a;
        }
        a(adTemplate, 934, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0353a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 34, aVar, jSONObject);
    }

    public static void h(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0353a c0353a = new a.C0353a();
        if (z) {
            c0353a.aBB = 1;
        } else {
            c0353a.aBB = 2;
        }
        aVar.a(c0353a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, long j, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCo = i;
        a.C0353a c0353a = new a.C0353a();
        c0353a.duration = j;
        aVar.PJ = c0353a;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aCA = i;
        if (!str.equals("")) {
            aVar.aCB = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, long j2, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.yY = j;
        aVar.aCR = i2;
        aVar.aCo = i;
        a.C0353a c0353a = new a.C0353a();
        c0353a.duration = j2;
        aVar.PJ = c0353a;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        d(adTemplate, jSONObject, new com.kwad.sdk.core.adlog.c.b().dx(i));
    }

    public static void a(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0353a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 33, aVar, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar) {
        AdInfo er = e.er(adTemplate);
        String str = er.downloadFilePath;
        if (str == null) {
            return;
        }
        String az = com.kwad.sdk.core.response.b.a.az(er);
        String hw = as.hw(str);
        if (hw == null || TextUtils.isEmpty(hw) || hw.equals(az)) {
            return;
        }
        bVar.dH(hw);
        bVar.dG(az);
        er.adBaseInfo.appPackageName = hw;
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.aCF = aVar.toJson().toString();
        aVar2.a(new a.C0353a());
        aVar2.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aCA = i;
        if (!str.equals("")) {
            aVar.aCB = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j) {
        aVar.aCM = j;
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCm = i;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == -9999 || i == 6) {
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            aVar.aCs = i;
            if (adExposureFailedReason != null) {
                aVar.aCt = adExposureFailedReason.winEcpm;
                try {
                    int i2 = adExposureFailedReason.adnType;
                    aVar.adnType = i2;
                    if (i2 == 2) {
                        aVar.adnName = adExposureFailedReason.adnName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adUserName)) {
                        aVar.aCu = adExposureFailedReason.adUserName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adTitle)) {
                        aVar.aCv = adExposureFailedReason.adTitle;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adRequestId)) {
                        aVar.aCw = adExposureFailedReason.adRequestId;
                    }
                    aVar.aCx = adExposureFailedReason.isShow;
                    aVar.aCy = adExposureFailedReason.isClick;
                    aVar.adnMaterialType = adExposureFailedReason.adnMaterialType;
                    aVar.adnMaterialUrl = adExposureFailedReason.adnMaterialUrl;
                } catch (Throwable unused) {
                }
            }
            a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.PI = str;
        a(adTemplate, i, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0353a c0353a = new a.C0353a();
        c0353a.aBI = com.kwad.sdk.core.response.b.a.dA(e.er(adTemplate)) ? 1 : 0;
        c0353a.aBJ = str;
        c0353a.aBK = str2;
        c0353a.aBL = i;
        bVar.b(c0353a);
        a(adTemplate, 1024, bVar.GB(), (JSONObject) null);
    }

    public static boolean a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (adTemplate == null || !ci(adTemplate)) {
            return false;
        }
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aCQ = com.kwad.sdk.core.response.b.a.aU(e.er(adTemplate));
        aVar.adxResult = adTemplate.adxResult;
        if (i == 2 && aBR) {
            if (aVar.PJ == null) {
                aVar.PJ = new a.C0353a();
            }
            aVar.PJ.aBE = aBQ;
        }
        if (i == 1 && e.el(adTemplate) == 4 && com.kwad.sdk.core.response.b.a.dw(e.er(adTemplate))) {
            if (aVar.PJ == null) {
                aVar.PJ = new a.C0353a();
            }
            aVar.PJ.aBD = com.kwad.sdk.core.response.b.a.dx(e.er(adTemplate));
        }
        if (i == 1 || i == 2) {
            if (aVar.PJ == null) {
                aVar.PJ = new a.C0353a();
            }
            aVar.PJ.aBI = com.kwad.sdk.core.response.b.a.dA(e.er(adTemplate)) ? 1 : 0;
        }
        aVar.adTemplate = adTemplate;
        aVar.aAV = i;
        aVar.aCl = jSONObject;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        com.kwad.sdk.core.d.c.d("AdReportManager", sb.toString());
        b.a(aVar);
        return true;
    }
}
