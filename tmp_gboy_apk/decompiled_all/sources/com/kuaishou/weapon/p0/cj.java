package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.kuaishou.weapon.p0.jni.Engine;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class cj {

    /* renamed from: a, reason: collision with root package name */
    private Context f12240a;

    public cj(Context context) {
        this.f12240a = context;
    }

    public JSONObject a() {
        int i;
        try {
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f12240a, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            if (a2.b(df.G, 1) != 1) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (a2.b(df.K, 0) == 1 && Engine.loadSuccess) {
                ap apVar = new ap(this.f12240a);
                jSONObject.put(Constants.FAIL, apVar.b(Constants.FAIL));
                jSONObject.put("1", apVar.b("1"));
                jSONObject.put("2", apVar.b("2"));
                jSONObject.put("4", apVar.b("4"));
                jSONObject.put("5", apVar.b("5"));
                jSONObject.put("6", apVar.b("6"));
                jSONObject.put("7", apVar.b("7"));
                jSONObject.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, apVar.b(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD));
                jSONObject.put("9", apVar.b("9"));
                jSONObject.put(PointType.SIGMOB_APP, apVar.b(PointType.SIGMOB_APP));
                jSONObject.put("11", apVar.b("11"));
                jSONObject.put("12", apVar.b("12"));
                jSONObject.put(PointType.SIGMOB_REPORT_TRACKING, apVar.b(PointType.SIGMOB_REPORT_TRACKING));
                jSONObject.put("14", apVar.b("14"));
                jSONObject.put("15", apVar.b("15"));
                jSONObject.put("16", apVar.b("16"));
                jSONObject.put(PointType.LOAD_READY, apVar.b(PointType.LOAD_READY));
                jSONObject.put("18", apVar.b("18"));
                jSONObject.put("19", apVar.b("19"));
                jSONObject.put("20", apVar.b("20"));
                jSONObject.put("21", apVar.b("21"));
                jSONObject.put("22", apVar.b("22"));
                jSONObject.put("23", apVar.b("23"));
                jSONObject.put("24", apVar.b("24"));
                jSONObject.put("25", apVar.b("25"));
                jSONObject.put("26", apVar.b("26"));
                jSONObject.put("27", apVar.b("27"));
                jSONObject.put("28", apVar.b("28"));
                jSONObject.put("29", apVar.b("29"));
                jSONObject.put(PointType.DOWNLOAD_TRACKING, apVar.b(PointType.DOWNLOAD_TRACKING));
                jSONObject.put("31", apVar.b("31"));
                jSONObject.put("32", apVar.b("32"));
                jSONObject.put("33", apVar.b("33"));
                jSONObject.put("34", apVar.b("34"));
                jSONObject.put("35", apVar.b("35"));
                jSONObject.put("36", apVar.b("36"));
                jSONObject.put("37", apVar.b("37"));
                jSONObject.put("38", apVar.b("38"));
                jSONObject.put("39", apVar.b("39"));
                jSONObject.put("40", apVar.b("40"));
                jSONObject.put("41", apVar.b("41"));
                jSONObject.put("42", apVar.b("42"));
                jSONObject.put("43", apVar.a("43"));
                jSONObject.put("44", apVar.a("44"));
                jSONObject.put(PointType.ANTI_SPAM, apVar.b(PointType.ANTI_SPAM));
                jSONObject.put(PointType.ANTI_SPAM_TOUCH, apVar.b(PointType.ANTI_SPAM_TOUCH));
                jSONObject.put("105", apVar.b("105"));
                jSONObject.put("106", apVar.b("106"));
                jSONObject.put("49", dl.b(this.f12240a));
            }
            if (a2.b(df.J, 1) == 1 && Engine.loadSuccess) {
                at atVar = new at(this.f12240a);
                jSONObject.put("45", atVar.d("45"));
                if (atVar.a()) {
                    i = 1;
                    jSONObject.put("93", 1);
                } else {
                    i = 1;
                }
                if (atVar.b()) {
                    jSONObject.put("94", i);
                }
                jSONObject.put("46", atVar.d("46"));
                jSONObject.put("48", atVar.a("48"));
                jSONObject.put("51", atVar.b("51"));
                jSONObject.put("52", atVar.a(this.f12240a, "52", 0));
                jSONObject.put("55", atVar.c("55"));
                jSONObject.put("66", atVar.a("66"));
                jSONObject.put("67", di.d());
                jSONObject.put("78", atVar.a("78"));
                jSONObject.put("79", atVar.a("79"));
                az azVar = new az(this.f12240a, 200);
                jSONObject.put("70", azVar.a("70"));
                jSONObject.put("71", azVar.a("71"));
                jSONObject.put("72", azVar.a("72"));
                jSONObject.put("73", azVar.a("73"));
                jSONObject.put("74", azVar.a("74"));
            }
            if (a2.b(df.M, 1) == 1) {
                ax axVar = new ax(this.f12240a);
                jSONObject.put("53", axVar.a(this.f12240a, "53", 1));
                jSONObject.put("56", axVar.a("56"));
                jSONObject.put("57", axVar.a("57"));
                jSONObject.put("64", di.a());
            }
            if (a2.b(df.N, 1) == 1) {
                cs csVar = new cs();
                jSONObject.put("98", csVar.a());
                jSONObject.put(PointType.WIND_ACTIVE, csVar.b());
                String d = am.d();
                if (!TextUtils.isEmpty(d)) {
                    jSONObject.put("77", d);
                }
                jSONObject.put("104", am.c());
                jSONObject.put("109", dl.e(this.f12240a));
                aj ajVar = new aj(this.f12240a);
                jSONObject.put("82", ajVar.h());
                String i2 = ajVar.i();
                if (!TextUtils.isEmpty(i2)) {
                    jSONObject.put("83", i2);
                }
                String j = ajVar.j();
                if (!TextUtils.isEmpty(j)) {
                    jSONObject.put("84", j);
                }
                String k = ajVar.k();
                if (!TextUtils.isEmpty(k)) {
                    jSONObject.put("86", k);
                }
            }
            if (a2.b(df.L, 1) == 1) {
                au auVar = new au(this.f12240a);
                jSONObject.put("95", auVar.b("95"));
                jSONObject.put("96", auVar.a() ? 1 : 0);
                jSONObject.put("97", di.e());
                try {
                    jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Oe().Od()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Oe().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Oe().getAppId()));
                } catch (Throwable unused) {
                }
            }
            jSONObject.put("11006", e ? 1 : 0);
            jSONObject.put("11029", e2 ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cm(str, ck.l).a(this.f12240a);
            if (a3 == null || (a2 = a()) == null) {
                return null;
            }
            a3.put("module_section", a2);
            return a3.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
