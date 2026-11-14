package com.bytedance.sdk.openadsdk.core.video.w;

import JCv79N.A2egSU;
import JCv79N.A4TApA;
import JCv79N.A5SV6n;
import JCv79N.ADYaiT;
import JCv79N.AMqCpz;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.io;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.a;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.core.yo;
import com.bytedance.sdk.openadsdk.f.hf;
import com.bytedance.sdk.openadsdk.x.c;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static A2egSU hf(int i) {
        return i == 7 ? A2egSU.f4122AlLFFp : i == 8 ? A2egSU.f4123AmA8tU : i == 5 ? A2egSU.f4124AzWtSf : i == 9 ? A2egSU.f4125B25kr6 : A2egSU.f4121AcNBzu;
    }

    private static String w(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    public static void xj(final String str, final ws wsVar, final long j) {
        c.hf(new d("csj_live_log_event") { // from class: com.bytedance.sdk.openadsdk.core.video.w.xj.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a lv = wsVar.lv();
                    String wr = wsVar.wr();
                    if (TextUtils.isEmpty(wr) && lv != null) {
                        wr = lv.hf();
                    }
                    if (TextUtils.isEmpty(wr)) {
                        return;
                    }
                    String y = lv != null ? lv.y() : null;
                    if (TextUtils.isEmpty(y)) {
                        y = wsVar.zf();
                    }
                    ADYaiT aDYaiT = new ADYaiT();
                    aDYaiT.f4131A2egSU = Long.parseLong(wr);
                    aDYaiT.f4132A4TApA = lv != null ? lv.xj() : "";
                    aDYaiT.f4133A5SV6n = y;
                    aDYaiT.f4134ADYaiT = xj.hf(wo.f(wsVar));
                    A4TApA xj = xj.xj(wo.f(wsVar));
                    long j2 = j;
                    long j3 = aDYaiT.f4131A2egSU;
                    String str2 = aDYaiT.f4132A4TApA;
                    String str3 = aDYaiT.f4133A5SV6n;
                    A2egSU a2egSU = aDYaiT.f4134ADYaiT;
                    AMqCpz aMqCpz = new AMqCpz();
                    aMqCpz.f4135A2egSU = j3;
                    aMqCpz.f4136A4TApA = str2;
                    aMqCpz.f4137A5SV6n = str3;
                    aMqCpz.f4138ADYaiT = a2egSU;
                    aMqCpz.AMqCpz = xj;
                    aMqCpz.f4139ARc23Z = j2;
                    JSONObject A2egSU2 = A5SV6n.A2egSU(aMqCpz, xj.xj(pz.getContext()));
                    A2egSU2.put("tob_extra", wsVar.jf());
                    y.hf(str, A2egSU2);
                } catch (Throwable th) {
                    pl.w("TTLiveVideoUtil", "Throwable : ", th);
                }
            }
        });
    }

    public static Map<String, String> xj(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("device_id", yo.w());
        hashMap.put(PluginConstants.KEY_SDK_VERSION, ai.u);
        hashMap.put("os", "Android");
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("device_model", tf.hf());
        hashMap.put("resolution", r.kd(context) + "x" + r.u(context));
        hashMap.put(MediaFormat.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        hashMap.put("timezone", String.valueOf(hf()));
        hashMap.put("access", am.c(context));
        hashMap.put("openudid", tf.xj());
        hashMap.put("aid", "1371");
        hashMap.put("display_name", com.bytedance.sdk.openadsdk.core.f.xj.kd());
        hashMap.put(n.r, com.bytedance.sdk.openadsdk.core.f.xj.u());
        hashMap.put("package", wo.d());
        hashMap.put("region", Locale.getDefault().getCountry());
        hashMap.put("tz_name", Calendar.getInstance().getTimeZone().getID());
        hashMap.put("tz_offset", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000));
        hashMap.put("rom", xj());
        String str = Build.MANUFACTURER;
        hashMap.put("device_manufacturer", str);
        ArrayList<String> xj = w.xj(context, "MD5");
        if (xj != null && !xj.isEmpty()) {
            hashMap.put("sig_hash", str);
        }
        hashMap.put("display_density", w(r.f(context)));
        hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("density_dpi", String.valueOf(r.f(context)));
        hashMap.put("device_brand", Build.BRAND);
        hashMap.put("build_serial", tf.p());
        hashMap.put("version_code", wo.tf());
        hashMap.put("udid", tf.f());
        hashMap.put("cpu_abi", Build.CPU_ABI);
        hashMap.put("oaid", tf.w(false));
        return hashMap;
    }

    public static void hf(ws wsVar) {
        if (wsVar != null && xj(wsVar)) {
            String f = com.bytedance.sdk.openadsdk.core.ra.wo.f(wsVar);
            String d = com.bytedance.sdk.openadsdk.core.ra.wo.d(wsVar);
            if (!TextUtils.isEmpty(f)) {
                hf.xj(f).to(new dk() { // from class: com.bytedance.sdk.openadsdk.core.video.w.xj.2
                    @Override // com.bytedance.sdk.component.y.dk
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.y.dk
                    public void onSuccess(zg zgVar) {
                    }
                });
            }
            if (TextUtils.isEmpty(d)) {
                return;
            }
            hf.xj(d).to(new dk() { // from class: com.bytedance.sdk.openadsdk.core.video.w.xj.3
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg zgVar) {
                }
            });
        }
    }

    private static int hf() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static A4TApA xj(int i) {
        if (i == 5) {
            return A4TApA.f4129AmA8tU;
        }
        if (i != 7 && i != 8 && i != 9) {
            return A4TApA.f4127AcNBzu;
        }
        return A4TApA.f4128AlLFFp;
    }

    public static boolean xj(ws wsVar) {
        return ai.u() && com.bytedance.sdk.openadsdk.core.ra.wo.xj(wsVar);
    }

    private static String xj() {
        StringBuilder sb = new StringBuilder();
        try {
            if (io.zg()) {
                sb.append("MIUI-");
            } else if (io.jk()) {
                sb.append("FLYME-");
            } else {
                String pz = io.pz();
                if (io.xj(pz)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(pz)) {
                    sb.append(pz);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
