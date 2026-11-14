package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.kuaishou.weapon.p0.jni.Engine;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.mta.PointType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class co {

    /* renamed from: a, reason: collision with root package name */
    private Context f12245a;

    public co(Context context) {
        this.f12245a = context;
    }

    public String a(String str) {
        JSONObject a2;
        JSONObject a3;
        try {
            cm cmVar = new cm(str, ck.l);
            String a4 = dl.a(cu.f12252a);
            String b = b(a4);
            if (TextUtils.isEmpty(b) || (a2 = cmVar.a(this.f12245a)) == null) {
                return null;
            }
            String str2 = cu.h + "?" + cv.a(this.f12245a);
            if (cu.a() && cu.f12252a.contains("api")) {
                str2 = "/api" + str2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", b);
            jSONObject.put("host", a4);
            jSONObject.put("path", str2);
            String str3 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                jSONObject.put("cookie", str3);
            }
            jSONObject.put("head", a2);
            StringBuilder sb = new StringBuilder();
            sb.append("sdk=" + Build.VERSION.SDK_INT);
            jSONObject.put("parame", sb.toString());
            if (str.equals(ck.h) && (a3 = a()) != null) {
                jSONObject.put("sjd", a3);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String hostAddress = InetAddress.getByName(dl.a(str)).getHostAddress();
            try {
                if (!TextUtils.isEmpty(hostAddress)) {
                    if (hostAddress.contains(".")) {
                        return hostAddress;
                    }
                }
                return "";
            } catch (UnknownHostException unused) {
                return hostAddress;
            }
        } catch (UnknownHostException unused2) {
            return "";
        }
    }

    private JSONObject a() {
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f12245a, "re_po_rt");
            a2.e("a1_p_s_p_s");
            a2.e("a1_p_s_p_s_c_b");
            aj ajVar = new aj(this.f12245a);
            jSONObject.put(Constants.FAIL, ajVar.d());
            jSONObject.put("1", ajVar.a());
            jSONObject.put("2", ajVar.c());
            jSONObject.put("3", ajVar.f());
            jSONObject.put("24", ajVar.e());
            jSONObject.put("35", ab.b() ? 1 : 0);
            jSONObject.put("36", ab.a(this.f12245a) ? 1 : 0);
            Object a3 = ai.a(this.f12245a);
            if (a3 != null) {
                jSONObject.put("4", a3);
            }
            a2.b(df.ac, 0);
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean a4 = acVar.a(this.f12245a);
            jSONObject.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, a4 ? 1 : 0);
            if (a4) {
                jSONObject.put("61", acVar.b(this.f12245a));
            }
            jSONObject.put(PointType.SIGMOB_APP, acVar.e(this.f12245a));
            jSONObject.put("11", acVar.c(this.f12245a));
            ae aeVar = new ae();
            jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean b = aoVar.b();
            jSONObject.put("66", b ? 1 : 0);
            if (b) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put("69", aoVar.e());
            jSONObject.put(PointType.ANTI_SPAM, aoVar.c() ? 1 : 0);
            jSONObject.put(PointType.ANTI_SPAM_TOUCH, aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bv.a(this.f12245a));
            jSONObject2.put("03014", bh.g(this.f12245a));
            jSONObject2.put("03020", bv.b(this.f12245a));
            jSONObject2.put("03030", bg.d(this.f12245a));
            jSONObject.put("51", jSONObject2);
            jSONObject.put(PointType.WIND_ACTIVE, new an().d());
            jSONObject.put("60", ab.b(this.f12245a) ? 1 : 0);
            try {
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Oe().Od()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Oe().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Oe().getAppId()));
                jSONObject.put("11002", Engine.soVersion);
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
