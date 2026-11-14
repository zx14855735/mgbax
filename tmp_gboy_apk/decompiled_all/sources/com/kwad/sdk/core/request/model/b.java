package com.kwad.sdk.core.request.model;

import B4ZgIw.AYUAbz;
import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.components.p;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.s;
import org.json.JSONArray;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static boolean aMN;
    private static JSONArray aMO;
    public String Mh;
    public String Mi;
    public String Mj;
    public String Mk;
    public String Ml;
    public int QW;
    public int QX;
    public String aGW;
    public String aGX;
    public String aMP;
    public String aMQ;
    public String aMR;
    public String aMS;
    public String aMT;
    public int aMU;
    public int aMV;
    public String aMW;
    public String aMX;
    public int aMY;
    public String aMZ;
    public String aNa;
    public JSONArray aNb;
    public String aNc;
    public String aNd;
    public String aNf;
    public String aNg;
    public String aNh;

    @Deprecated
    public String aNj;
    public String aNk;
    public int aNl;
    public int ahe;
    public int ahg;
    public String ahh;
    public String uaid;
    public int aNe = 0;
    public long aNi = 0;

    private static boolean Dl() {
        return ((h) ServiceProvider.get(h.class)).Dl();
    }

    private static boolean Dm() {
        return ((h) ServiceProvider.get(h.class)).Dm();
    }

    public static b KC() {
        b bVar = new b();
        try {
            bVar.aGX = bd.getOaid();
            bVar.Ml = bd.getDeviceId();
            bVar.Mh = br.TK();
            bVar.ahe = 1;
            bVar.ahg = br.TX();
            bVar.Mj = br.getOsVersion();
            bVar.aNa = ag.getEGid();
            if (ag.Ss()) {
                bVar.aNc = ag.Sr();
            }
            if (ag.St() && !TextUtils.isEmpty(ag.Sq())) {
                bVar.uaid = ag.Sq();
            }
            com.kwad.sdk.components.h hVar = (com.kwad.sdk.components.h) com.kwad.sdk.components.d.f(com.kwad.sdk.components.h.class);
            if (hVar != null) {
                bVar.aMZ = hVar.qt();
            }
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
                bVar.aGW = bd.dA(ServiceProvider.Re());
                return bVar;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    private static String a(com.kwad.sdk.service.a.f fVar, b bVar, Context context) {
        StringBuilder sb = new StringBuilder("i=");
        sb.append(fVar.getAppId());
        sb.append(",n=");
        sb.append(fVar.getAppName());
        sb.append(",external:");
        sb.append(fVar.CT());
        sb.append(",v1:");
        sb.append(fVar.getApiVersion());
        sb.append(",v2:4.9.20.1,d:");
        sb.append(bVar.Ml);
        sb.append(",dh:");
        String str = bVar.Ml;
        sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
        sb.append(",b:304,p:");
        sb.append(ay.isInMainProcess(context));
        sb.append(",dy:");
        sb.append(com.kwad.framework.a.a.apg);
        String sb2 = sb.toString();
        if (Dm()) {
            return sb2;
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(sb2, ",o:");
        A5SV6n2.append(bVar.aGX);
        return A5SV6n2.toString();
    }

    private static synchronized JSONArray bO(Context context) {
        synchronized (b.class) {
            try {
                if (!aMN) {
                    aMN = true;
                    p pVar = (p) com.kwad.sdk.components.d.f(p.class);
                    com.kwad.sdk.core.d.c.d("DeviceInfo", "getAppList: OptDataFetchComponent: " + pVar);
                    if (pVar != null && s.RL()) {
                        pVar.a(context, new com.kwad.sdk.g.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                            private static void g(JSONArray jSONArray) {
                                JSONArray unused = b.aMO = jSONArray;
                            }

                            @Override // com.kwad.sdk.g.a
                            public final /* synthetic */ void accept(JSONArray jSONArray) {
                                g(jSONArray);
                            }
                        });
                    }
                }
                JSONArray jSONArray = aMO;
                if (jSONArray == null) {
                    return null;
                }
                aMO = null;
                return jSONArray;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static b h(boolean z, int i) {
        b bVar = new b();
        try {
            Context Re = ServiceProvider.Re();
            bVar.aGW = bd.dA(Re);
            bVar.aMP = bd.dD(Re);
            bVar.aMQ = bd.dE(Re);
            bVar.aMR = br.eg(Re);
            bVar.aGX = bd.getOaid();
            bVar.Mh = br.TK();
            bVar.Mi = br.TM();
            bVar.ahe = 1;
            bVar.ahg = br.TX();
            bVar.Mj = br.getOsVersion();
            bVar.ahh = m.getLanguage();
            bVar.QW = m.getScreenHeight(Re);
            bVar.QX = m.getScreenWidth(Re);
            bVar.aMU = m.cR(Re);
            bVar.aMV = m.cS(Re);
            bVar.aMW = bd.dB(Re);
            if (z) {
                bVar.aNb = bO(Re);
            }
            bVar.aNl = ((h) ServiceProvider.get(h.class)).DK();
            bVar.aNd = br.TW();
            if (ag.Ss()) {
                bVar.aNc = ag.Sr();
            }
            if (ag.St() && !TextUtils.isEmpty(ag.Sq())) {
                bVar.uaid = ag.Sq();
            }
            bVar.Ml = bd.getDeviceId();
            bVar.aNi = br.TL();
            bVar.aMX = br.TU();
            bVar.aNa = ag.getEGid();
            com.kwad.sdk.components.h hVar = (com.kwad.sdk.components.h) com.kwad.sdk.components.d.f(com.kwad.sdk.components.h.class);
            if (hVar != null) {
                bVar.aMZ = hVar.qt();
            }
            bVar.aMY = br.TV();
            try {
                com.kwad.sdk.core.d.c.U("DeviceInfo", a((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class), bVar, Re));
            } catch (Exception unused) {
            }
            bVar.aNd = br.TW();
            bVar.aNe = i;
            if (Dl() && com.kwad.sdk.app.b.Fi() != null) {
                bVar.aNf = com.kwad.sdk.app.b.Fi().getVersion(Re, "com.smile.gifmaker");
                bVar.aNg = com.kwad.sdk.app.b.Fi().getVersion(Re, "com.kuaishou.nebula");
                bVar.aNh = com.kwad.sdk.app.b.Fi().getVersion(Re, "com.tencent.mm");
            }
            bVar.Mk = br.TS();
            bVar.aMT = am.dl(Re);
            bVar.aNk = br.hQ("/data/data");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }
}
