package com.kwad.sdk.core.network.b;

import ADYaiT.CtFAbx;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d implements b {
    private static boolean aKs = true;
    public static double aKt = 1.0d;
    private static volatile boolean aKx = false;
    private static String aKy = "";
    private long aKu = -1;
    private long aKv = -1;
    private long aKw = -1;
    private j aKz = new j();

    public d() {
        aKt = new Random().nextDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: JP, reason: merged with bridge method [inline-methods] */
    public d JH() {
        this.aKz.aJD = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: JQ, reason: merged with bridge method [inline-methods] */
    public d JI() {
        this.aKv = SystemClock.elapsedRealtime();
        eA("this.responseReceiveTime:" + this.aKv);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: JR, reason: merged with bridge method [inline-methods] */
    public d JJ() {
        if (aA(this.aKu) && aA(this.aKv)) {
            this.aKz.aJK = this.aKv - this.aKu;
            eA("info.waiting_response_cost:" + this.aKz.aJK);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: JS, reason: merged with bridge method [inline-methods] */
    public d JK() {
        if (aA(this.aKz.aJD)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.aKu = elapsedRealtime;
            j jVar = this.aKz;
            jVar.aJx = elapsedRealtime - jVar.aJD;
            if (aA(jVar.aJv)) {
                j jVar2 = this.aKz;
                jVar2.aJw = jVar2.aJx - jVar2.aJv;
            }
            eA("info.request_create_cost:" + this.aKz.aJx);
            eA("info.requestAddParamsCost:" + this.aKz.aJw);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: JT, reason: merged with bridge method [inline-methods] */
    public d JM() {
        if (aA(this.aKv)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.aKw = elapsedRealtime;
            this.aKz.aJI = elapsedRealtime - this.aKv;
            eA("info.response_parse_cost:" + this.aKz.aJI);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: JU, reason: merged with bridge method [inline-methods] */
    public d JN() {
        if (aA(this.aKw)) {
            this.aKz.aJP = SystemClock.elapsedRealtime() - this.aKw;
            JV();
            eA("info.response_done_cost:" + this.aKz.aJP);
        }
        return this;
    }

    private void JV() {
        j jVar = this.aKz;
        if (jVar == null || jVar.aJO != 1 || aD(jVar.aJP)) {
            return;
        }
        this.aKz.aJP = -1L;
    }

    private d JW() {
        this.aKz.aJS = (int) com.kwad.sdk.ip.direct.a.On();
        this.aKz.aJT = (int) com.kwad.sdk.ip.direct.a.Oo();
        this.aKz.aJU = (int) com.kwad.sdk.ip.direct.a.Op();
        return this;
    }

    private void JX() {
        i c = c(this.aKz);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(c);
        }
        com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", "reportError" + c.toJson().toString());
    }

    private static boolean aA(long j) {
        return j != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: aB, reason: merged with bridge method [inline-methods] */
    public d az(long j) {
        this.aKz.aJJ = j;
        eA(CtFAbx.AaHO0E("responseSize:", j));
        return this;
    }

    private d aC(long j) {
        this.aKz.aJL = j;
        eA(CtFAbx.AaHO0E("totalCost:", j));
        return this;
    }

    private static boolean aD(long j) {
        return j >= 50;
    }

    private static boolean c(i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dT, reason: merged with bridge method [inline-methods] */
    public d dP(int i) {
        this.aKz.httpCode = i;
        eA(CtFAbx.ARc23Z(i, "http_code:"));
        return this;
    }

    private d dU(int i) {
        this.aKz.aJO = i;
        eA(CtFAbx.ARc23Z(i, "hasData:"));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dV, reason: merged with bridge method [inline-methods] */
    public d dR(int i) {
        this.aKz.result = i;
        eA(CtFAbx.ARc23Z(i, "result:"));
        return this;
    }

    private static void eA(String str) {
        if (aKs) {
            com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eB, reason: merged with bridge method [inline-methods] */
    public d ev(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aKz.url = str;
            if (str.contains("?")) {
                String[] split = str.split("\\?");
                if (split.length > 0) {
                    str = split[0];
                }
            }
            if (!TextUtils.isEmpty(str)) {
                eA(CtFAbx.BChYOn("url:", str));
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eC, reason: merged with bridge method [inline-methods] */
    public d ew(String str) {
        try {
            this.aKz.host = Uri.parse(str).getHost();
            eA("host:" + this.aKz.host);
            return this;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eD, reason: merged with bridge method [inline-methods] */
    public d ex(String str) {
        this.aKz.errorMsg = str;
        eA(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eE, reason: merged with bridge method [inline-methods] */
    public d ey(String str) {
        this.aKz.aJt = str;
        eA(CtFAbx.BChYOn("reqType:", str));
        eG(com.kwad.sdk.ip.direct.a.Om());
        JW();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eF, reason: merged with bridge method [inline-methods] */
    public d ez(String str) {
        this.aKz.aJN = str;
        eA(CtFAbx.BChYOn("requestId:", str));
        return this;
    }

    private d eG(String str) {
        this.aKz.aJQ = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b JL() {
        if (aA(this.aKz.aJD)) {
            this.aKz.aJv = SystemClock.elapsedRealtime() - this.aKz.aJD;
            eA("info.request_prepare_cost:" + this.aKz.aJv);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b dQ(int i) {
        return dU(1);
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b dS(int i) {
        j jVar = this.aKz;
        jVar.aJR = i;
        if (i != 0) {
            jVar.aJu = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        if (c((i) this.aKz)) {
            return;
        }
        if (this.aKz.httpCode != 200) {
            JX();
            return;
        }
        long elapsedRealtime = aA(this.aKz.aJD) ? SystemClock.elapsedRealtime() - this.aKz.aJD : -1L;
        aC(elapsedRealtime);
        if (elapsedRealtime > 30000 || elapsedRealtime <= -1) {
            return;
        }
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(this.aKz);
        }
        eA("report normal" + this.aKz.toString());
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.aJt = jVar.aJt;
        iVar.url = jVar.url;
        iVar.aJu = jVar.aJu;
        return iVar;
    }
}
