package com.kwad.sdk.utils;

import BPw6Q8.ASJ6gh;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.cd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bd {
    public static String bfm = "";

    public static com.kwad.sdk.l.a.b QD() {
        return com.kwad.sdk.l.a.b.QD();
    }

    public static com.kwad.sdk.l.a.f QE() {
        return com.kwad.sdk.l.a.f.QE();
    }

    private static String Th() {
        com.kwad.sdk.l.a.f QE = com.kwad.sdk.l.a.f.QE();
        int i = QE != null ? QE.bbP : -1;
        return i >= 0 ? com.kwad.sdk.e.b.a(false, String.valueOf(i), 0) : !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).De() ? com.kwad.sdk.e.b.a(false, String.valueOf(i), 1) : com.kwad.sdk.e.b.a(false, String.valueOf(i), 2);
    }

    private static String Ti() {
        com.kwad.sdk.l.a.b QD = com.kwad.sdk.l.a.b.QD();
        return QD != null ? com.kwad.sdk.e.b.a(false, QD.toJson(), 0) : !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dg() ? com.kwad.sdk.e.b.a(false, "", 1) : com.kwad.sdk.e.b.a(false, "", 2);
    }

    private static String Tj() {
        return com.kwad.sdk.e.b.a(false, "1", 0);
    }

    private static String Tk() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    private static String Tl() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getAppId()), 0);
    }

    public static com.kwad.sdk.utils.c.a cU(Context context) {
        return x.cU(context);
    }

    private static String cg(boolean z) {
        String cr = br.cr(z);
        if (!z) {
            return TextUtils.isEmpty(cr) ? "" : cr;
        }
        if (TextUtils.isEmpty(cr)) {
            return (bc.useOaidDisable() || !s.RJ()) ? com.kwad.sdk.e.b.a(false, cr, 1) : com.kwad.sdk.e.b.a(false, cr, 5);
        }
        return com.kwad.sdk.e.b.a(bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid()), cr, 0);
    }

    private static String ch(boolean z) {
        if (com.kwad.framework.a.a.oy.booleanValue() && !TextUtils.isEmpty(bs.getDeviceId())) {
            return bs.getDeviceId();
        }
        String deviceId = br.getDeviceId();
        if (!z) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        if (TextUtils.isEmpty(deviceId)) {
            return (bc.usePhoneStateDisable() || !s.RH()) ? com.kwad.sdk.e.b.a(false, deviceId, 1) : com.kwad.sdk.e.b.a(false, deviceId, 5);
        }
        return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevAndroidId()), deviceId, 0);
    }

    private static String ci(boolean z) {
        String TY = br.TY();
        return !z ? TextUtils.isEmpty(TY) ? "" : TY : !TextUtils.isEmpty(TY) ? com.kwad.sdk.e.b.a(bc.useNetworkStateDisable(), TY, 0) : (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(8L)) ? com.kwad.sdk.e.b.a(false, TY, 1) : com.kwad.sdk.e.b.a(false, TY, 2);
    }

    public static /* synthetic */ String cj(boolean z) {
        return cg(true);
    }

    public static /* synthetic */ String ck(boolean z) {
        return Th();
    }

    public static /* synthetic */ String cl(boolean z) {
        return Ti();
    }

    public static /* synthetic */ String cm(boolean z) {
        return ch(true);
    }

    public static /* synthetic */ String cn(boolean z) {
        return ci(true);
    }

    public static /* synthetic */ String co(boolean z) {
        return Tj();
    }

    public static /* synthetic */ String cp(boolean z) {
        return Tk();
    }

    public static /* synthetic */ String cq(boolean z) {
        return Tl();
    }

    public static String dA(Context context) {
        return h(context, false);
    }

    public static String dB(Context context) {
        return i(context, false);
    }

    public static String dC(Context context) {
        return j(context, false);
    }

    public static String dD(Context context) {
        return k(context, false);
    }

    public static String dE(Context context) {
        return l(context, false);
    }

    public static String dF(Context context) {
        return m(context, false);
    }

    public static String dG(Context context) {
        return n(context, false);
    }

    public static int dH(Context context) {
        return br.ei(context);
    }

    private static String dI(Context context) {
        int ei = br.ei(context);
        return ei > 0 ? com.kwad.sdk.e.b.a(false, String.valueOf(ei), 0) : Build.VERSION.SDK_INT < 23 ? com.kwad.sdk.e.b.a(false, String.valueOf(ei), 1) : com.kwad.sdk.e.b.a(false, String.valueOf(ei), 3);
    }

    public static int dJ(Context context) {
        return br.ej(context);
    }

    private static String dK(Context context) {
        List<cd.a> o = o(context, 15);
        if (o != null && o.size() > 0) {
            return com.kwad.sdk.e.b.a(bc.useNetworkStateDisable(), aa.S(o), 0);
        }
        if (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(32L)) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", cd.er(context) ? 1 : 3);
    }

    private static Map<String, AppPackageInfo> dL(Context context) {
        com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
        return (pVar == null || !s.RL()) ? new HashMap() : pVar.P(context);
    }

    private static String dM(Context context) {
        com.kwad.sdk.core.c.b.Ji();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.e.b.a(false, "", 5);
        }
        Map<String, AppPackageInfo> dL = dL(context);
        if (dL.size() > 0) {
            boolean z = bc.readInstalledPackagesDisable() && bc.getDevInstalledPackages() != null;
            com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
            if (pVar != null && s.RL()) {
                return com.kwad.sdk.e.b.a(z, pVar.c(dL), 0);
            }
        }
        if (bc.readInstalledPackagesDisable() || !s.RL()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", br.ep(context) ? 3 : 1);
    }

    private static String dN(Context context) {
        com.kwad.sdk.utils.c.a cU = x.cU(context);
        if (cU == null || cU.bhT == null) {
            if (bc.readLocationDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
                return com.kwad.sdk.e.b.a(false, "", 1);
            }
            return com.kwad.sdk.e.b.a(false, "", ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.g) == 0 ? 3 : 1);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", String.valueOf(cU.bhT.getLatitude()));
        hashMap.put("longitude", String.valueOf(cU.bhT.getLongitude()));
        return com.kwad.sdk.e.b.a(bc.readLocationDisable() && bc.Tf() != null, aa.parseMap2JSON(hashMap), 0);
    }

    private static com.kwad.sdk.e.c dO(final Context context) {
        return new com.kwad.sdk.e.c() { // from class: com.kwad.sdk.utils.bd.1
            @Override // com.kwad.sdk.e.a
            public final String NU() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + bd.p(context, true));
                return bd.p(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String NV() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + bd.r(context, true));
                return bd.r(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String NW() {
                String s = bd.s(context, true);
                A2egSU.B7CMnp("getIMEI2:", s, "SDKPrivateSafetyDataUtil");
                return s;
            }

            @Override // com.kwad.sdk.e.a
            public final String NX() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + bd.t(context, true));
                return bd.t(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String NY() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + bd.v(context, true));
                return bd.v(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String NZ() {
                String ck = bd.ck(true);
                A2egSU.B7CMnp("getSimCardActivePhoneCount:", ck, "SDKPrivateSafetyDataUtil");
                return ck;
            }

            @Override // com.kwad.sdk.e.a
            public final String Oa() {
                String cl = bd.cl(true);
                A2egSU.B7CMnp("getBaseStationInfo:", cl, "SDKPrivateSafetyDataUtil");
                return cl;
            }

            @Override // com.kwad.sdk.e.a
            public final String Ob() {
                String w = bd.w(context, true);
                A2egSU.B7CMnp("getWifiList:", w, "SDKPrivateSafetyDataUtil");
                return w;
            }

            @Override // com.kwad.sdk.e.a
            public final String Oc() {
                String y = bd.y(context, true);
                A2egSU.B7CMnp("getAppList:", y, "SDKPrivateSafetyDataUtil");
                return y;
            }

            @Override // com.kwad.sdk.e.a
            public final String Od() {
                String co = bd.co(true);
                A2egSU.B7CMnp("getSdkType:", co, "SDKPrivateSafetyDataUtil");
                return co;
            }

            @Override // com.kwad.sdk.e.a
            public final String getAppId() {
                String cq = bd.cq(true);
                A2egSU.B7CMnp("getAppId:", cq, "SDKPrivateSafetyDataUtil");
                return cq;
            }

            @Override // com.kwad.sdk.e.a
            public final String getDeviceId() {
                String cm = bd.cm(true);
                A2egSU.B7CMnp("getDeviceId:", cm, "SDKPrivateSafetyDataUtil");
                return cm;
            }

            @Override // com.kwad.sdk.e.a
            public final String getIMEI() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + bd.o(context, true));
                return bd.o(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIccId() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + bd.u(context, true));
                return bd.u(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIp() {
                String cn = bd.cn(true);
                A2egSU.B7CMnp("getIp:", cn, "SDKPrivateSafetyDataUtil");
                return cn;
            }

            @Override // com.kwad.sdk.e.a
            public final String getLocation() {
                String x = bd.x(context, true);
                A2egSU.B7CMnp("getLocation:", x, "SDKPrivateSafetyDataUtil");
                return x;
            }

            @Override // com.kwad.sdk.e.a
            public final String getMac() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getMac:" + bd.q(context, true));
                return bd.q(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getOaid() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + bd.cj(true));
                return bd.cj(true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getSdkVersion() {
                String cp = bd.cp(true);
                A2egSU.B7CMnp("getSdkVersion:", cp, "SDKPrivateSafetyDataUtil");
                return cp;
            }
        };
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    public static String getDeviceId() {
        return ch(false);
    }

    public static String getOaid() {
        return cg(false);
    }

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    private static String h(Context context, boolean z) {
        String z2 = br.z(context, z);
        if (!z) {
            return TextUtils.isEmpty(z2) ? "" : z2;
        }
        if (!TextUtils.isEmpty(z2)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei()), z2, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, z2, 4);
        }
        if (bc.usePhoneStateDisable() || !s.RN()) {
            return com.kwad.sdk.e.b.a(false, z2, 1);
        }
        return com.kwad.sdk.e.b.a(false, z2, SystemUtil.dZ(context) ? 3 : 1);
    }

    private static String i(Context context, boolean z) {
        String dB = br.dB(context);
        if (!z) {
            return TextUtils.isEmpty(dB) ? "" : dB;
        }
        if (TextUtils.isEmpty(dB)) {
            return (bc.usePhoneStateDisable() || !s.RH()) ? com.kwad.sdk.e.b.a(false, dB, 1) : com.kwad.sdk.e.b.a(false, dB, 5);
        }
        return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevAndroidId()), dB, 0);
    }

    public static void init(Context context) {
        com.kwad.sdk.e.b.a(dO(context));
    }

    private static String j(Context context, boolean z) {
        String en = br.en(context);
        if (!z) {
            return TextUtils.isEmpty(en) ? "" : en;
        }
        if (!TextUtils.isEmpty(en)) {
            return com.kwad.sdk.e.b.a(bc.useMacAddressDisable() && !TextUtils.isEmpty(bc.getDevMacAddress()), en.toLowerCase(), 0);
        }
        if (bc.useMacAddressDisable() || !s.RI()) {
            return com.kwad.sdk.e.b.a(false, en, 0);
        }
        return com.kwad.sdk.e.b.a(false, en, au.aw(context, com.kuaishou.weapon.p0.g.d) == 0 ? 3 : 1);
    }

    private static String k(Context context, boolean z) {
        String[] eh = br.eh(context);
        String str = (eh == null || eh.length <= 0) ? null : eh[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (bc.usePhoneStateDisable() || !s.RN()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.dZ(context) ? 3 : 1);
    }

    private static String l(Context context, boolean z) {
        String[] eh = br.eh(context);
        String str = (eh == null || eh.length <= 1) ? null : eh[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (bc.usePhoneStateDisable() || !s.RN()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.dZ(context) ? 3 : 1);
    }

    private static String m(Context context, boolean z) {
        String dF = br.dF(context);
        if (!z) {
            return TextUtils.isEmpty(dF) ? "" : dF;
        }
        if (!TextUtils.isEmpty(dF)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable(), dF, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, dF, 4);
        }
        if (bc.usePhoneStateDisable() || !s.RO()) {
            return com.kwad.sdk.e.b.a(false, dF, 1);
        }
        return com.kwad.sdk.e.b.a(false, dF, SystemUtil.dZ(context) ? 3 : 1);
    }

    private static String n(Context context, boolean z) {
        String ek = br.ek(context);
        if (!z) {
            return TextUtils.isEmpty(ek) ? "" : ek;
        }
        if (!TextUtils.isEmpty(ek)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable(), ek, 0);
        }
        if (bc.usePhoneStateDisable() || !s.RP()) {
            return com.kwad.sdk.e.b.a(false, ek, 1);
        }
        return com.kwad.sdk.e.b.a(false, ek, SystemUtil.dZ(context) ? 3 : 1);
    }

    public static /* synthetic */ String o(Context context, boolean z) {
        return h(context, true);
    }

    public static /* synthetic */ String p(Context context, boolean z) {
        return i(context, true);
    }

    public static /* synthetic */ String q(Context context, boolean z) {
        return j(context, true);
    }

    public static /* synthetic */ String r(Context context, boolean z) {
        return k(context, true);
    }

    public static /* synthetic */ String s(Context context, boolean z) {
        return l(context, true);
    }

    public static /* synthetic */ String t(Context context, boolean z) {
        return m(context, true);
    }

    public static /* synthetic */ String u(Context context, boolean z) {
        return n(context, true);
    }

    public static /* synthetic */ String v(Context context, boolean z) {
        return dI(context);
    }

    public static /* synthetic */ String w(Context context, boolean z) {
        return dK(context);
    }

    public static /* synthetic */ String x(Context context, boolean z) {
        return dN(context);
    }

    public static /* synthetic */ String y(Context context, boolean z) {
        return dM(context);
    }

    public static List<cd.a> o(Context context, int i) {
        return cd.o(context, 15);
    }
}
