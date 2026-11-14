package com.bytedance.sdk.openadsdk.qt;

import JrXYwF.A4TApA;
import JrXYwF.A5SV6n;
import JrXYwF.AMqCpz;
import JrXYwF.ASJ6gh;
import K7mCWO.A2egSU;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.tf.p;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.io;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.z;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.core.yo;
import com.czhj.sdk.common.Constants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.n;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static void hf(final Context context) {
        A5SV6n.AMqCpz.AMqCpz = new ASJ6gh() { // from class: com.bytedance.sdk.openadsdk.qt.xj.1
            @Override // JrXYwF.ASJ6gh
            public boolean xj(final Throwable th, final Thread thread) {
                try {
                    p.hf.c(com.bytedance.sdk.openadsdk.core.en.xj.xj);
                    if (!xj.hf(th, null)) {
                        return false;
                    }
                    c.hf(new d("tt_crash_handle") { // from class: com.bytedance.sdk.openadsdk.qt.xj.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            z.xj().xj(thread, th);
                        }
                    });
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // JrXYwF.ASJ6gh
            public boolean xj() {
                try {
                    return xj.hf(null, Looper.getMainLooper().getThread());
                } catch (Throwable unused) {
                    return false;
                }
            }
        };
        boolean z = false;
        boolean z2 = new SecureRandom().nextInt(10) == 0;
        Context applicationContext = context.getApplicationContext();
        AMqCpz aMqCpz = new AMqCpz() { // from class: com.bytedance.sdk.openadsdk.qt.xj.2
            @Override // JrXYwF.AMqCpz
            public Map<String, Object> c() {
                HashMap hashMap = new HashMap();
                String pz = f.zg().pz();
                if (TextUtils.isEmpty(pz)) {
                    pz = String.valueOf(y.xj().y());
                }
                hashMap.put("host_appid", pz);
                hashMap.put(PluginConstants.KEY_SDK_VERSION, "7.1.3.2");
                hashMap.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
                hashMap.put("channel", ai.kd());
                hashMap.put("sdk_api_version", ai.u);
                return hashMap;
            }

            @Override // JrXYwF.AMqCpz
            public String hf() {
                String w = yo.w();
                return TextUtils.isEmpty(w) ? Constants.FAIL : w;
            }

            @Override // JrXYwF.AMqCpz
            public Map<String, Integer> kd() {
                return null;
            }

            @Override // JrXYwF.AMqCpz
            public String u() {
                return null;
            }

            @Override // JrXYwF.AMqCpz
            public String w() {
                return y.xj().u();
            }

            @Override // JrXYwF.AMqCpz
            public Map<String, Object> xj() {
                HashMap hashMap = new HashMap();
                String e = tf.e();
                if (TextUtils.isEmpty(e)) {
                    e = yo.w();
                }
                if (!TextUtils.isEmpty(e)) {
                    hashMap.put("device_id", e);
                }
                hashMap.put("ac", com.bytedance.sdk.component.d.u.y.w(context));
                hashMap.put("aid", y.xj().y());
                hashMap.put("app_name", y.xj().c());
                String p = wo.p();
                if (!TextUtils.isEmpty(p)) {
                    hashMap.put(n.r, p);
                }
                String tf = wo.tf();
                if (!TextUtils.isEmpty(tf)) {
                    hashMap.put("version_code", tf);
                    try {
                        hashMap.put("update_version_code", Integer.valueOf(tf));
                    } catch (Exception e2) {
                        hashMap.put("update_version_code", 0);
                        e2.getMessage();
                    }
                }
                hashMap.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "7.1.3.2");
                hashMap.put("sdk_api_version", ai.u);
                hashMap.put("device_platform", "android");
                hashMap.put("os", "Android");
                String hf = tf.hf();
                hashMap.put("device_type", hf);
                hashMap.put("device_mode", hf);
                hashMap.put("rom", io.xj());
                hashMap.put("cpu_abi", Build.CPU_ABI);
                hashMap.put("device_brand", Build.BRAND);
                hashMap.put("channel", ai.kd());
                hashMap.put(MediaFormat.KEY_LANGUAGE, Locale.getDefault().getLanguage());
                hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String str = Build.VERSION.RELEASE;
                    if (str != null && str.length() > 10) {
                        str = str.substring(0, 10);
                    }
                    hashMap.put("os_version", str);
                } catch (Exception unused) {
                }
                hashMap.put("openudid", tf.xj());
                hashMap.put("dpi", String.valueOf(r.f(context)));
                hashMap.put("resolution", r.u(context) + "*" + r.kd(context));
                return hashMap;
            }

            @Override // JrXYwF.AMqCpz
            public List<String> y() {
                return null;
            }
        };
        boolean z3 = (pz.hf().ct() & 2) == 0;
        if (z2 && (pz.hf().ct() & 1) == 0) {
            z = true;
        }
        synchronized (A4TApA.class) {
            A4TApA.DyaChj(applicationContext, aMqCpz, z3, z);
        }
        com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.qt.xj.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.core.u.xj.w()) {
                    return;
                }
                boolean e = pz.hf().e();
                boolean xj = xj.xj();
                if (e && xj) {
                    new Object() { // from class: com.bytedance.sdk.openadsdk.qt.xj.3.1
                    };
                    A2egSU.A2egSU().post(new JrXYwF.A2egSU(0));
                }
            }
        }, PushUIConfig.dismissTime);
    }

    public static void xj(Context context) {
        hf(context);
    }

    public static boolean xj() {
        int i;
        try {
            String op = pz.hf().op();
            if (!TextUtils.isEmpty(op) && op.contains(";")) {
                String[] split = op.split(";");
                if (split.length != 2) {
                    return true;
                }
                String str = split[0];
                String str2 = split[1];
                Long l = -1L;
                try {
                    l = Long.valueOf(Long.valueOf(str).longValue() * 60000);
                    i = Integer.valueOf(str2).intValue();
                } catch (Exception e) {
                    pl.hf("apm", "error", e.getMessage());
                    i = -1;
                }
                if (l.longValue() >= 0 && i >= 0 && i <= 60) {
                    if (l.longValue() == 0 || i == 0 || l.longValue() / i < PushUIConfig.dismissTime) {
                        return false;
                    }
                    String hf = hf();
                    StringBuilder sb = new StringBuilder();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(hf)) {
                        sb.append(currentTimeMillis);
                        xj(sb.toString());
                        return true;
                    }
                    String[] split2 = hf.split(";");
                    int length = split2.length;
                    if (length >= i && length != 0) {
                        boolean z = currentTimeMillis - Long.valueOf(split2[0]).longValue() > l.longValue();
                        int i2 = length - i;
                        for (int i3 = i2; i3 < length; i3++) {
                            String str3 = split2[i3];
                            if (i3 != i2 && !TextUtils.isEmpty(str3)) {
                                sb.append(str3);
                                sb.append(";");
                            }
                        }
                        sb.append(currentTimeMillis);
                        xj(sb.toString());
                        return z;
                    }
                    for (String str4 : split2) {
                        sb.append(str4);
                        sb.append(";");
                    }
                    sb.append(currentTimeMillis);
                    xj(sb.toString());
                    return true;
                }
            }
            return true;
        } catch (Exception e2) {
            pl.xj(e2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hf(Throwable th, Thread thread) {
        StackTraceElement[] stackTrace;
        if (f.zg().z()) {
            return false;
        }
        if (th != null) {
            stackTrace = th.getStackTrace();
        } else {
            stackTrace = thread != null ? thread.getStackTrace() : null;
        }
        String arrays = Arrays.toString(stackTrace);
        if (!arrays.contains(BuildConfig.LIBRARY_PACKAGE_NAME) && !arrays.contains("com.bytedance.sdk.component") && !arrays.contains("com.bykv.vk") && !arrays.contains("com.byted.csj.ext_impl") && !arrays.contains("com.bytedance.adsdk") && !arrays.contains("com.bytedance.msdk") && !arrays.contains("com.bytedance.sdk.gromore") && !arrays.contains("com.bytedance.sdk.openadsdk.mediation") && !arrays.contains("bykvm")) {
            return false;
        }
        Map<String, String> hf = com.bytedance.sdk.openadsdk.core.u.xj().hf();
        if (hf == null) {
            return true;
        }
        if (arrays.contains("com.bytedance.sdk.openadsdk.core.nativeexpress")) {
            hf.put("express", "true");
        }
        if (arrays.contains(com.bytedance.sdk.openadsdk.core.live.xj.class.getPackage().getName()) || arrays.contains("com.bytedance.sdk.openadsdk.live") || arrays.contains("com.bykv.vk.openvk.live")) {
            hf.put("live_sdk", "true");
        }
        if (!arrays.contains("com.bytedance.msdk") && !arrays.contains("com.bytedance.sdk.gromore") && !arrays.contains("com.bytedance.sdk.openadsdk.mediation") && !arrays.contains("bykvm")) {
            hf.put("mediation", "false");
        } else {
            hf.put("mediation", "true");
        }
        Map<String, String> hf2 = com.bytedance.sdk.openadsdk.core.u.xj().hf();
        if (hf2 == null || hf2.isEmpty()) {
            return true;
        }
        A5SV6n.AMqCpz.f4155A4TApA.putAll(hf2);
        return true;
    }

    public static void xj(String str) {
        com.bytedance.sdk.openadsdk.core.w.u.xj().hf("sp_apm_record", str);
    }

    public static String hf() {
        return com.bytedance.sdk.openadsdk.core.w.u.xj().w("sp_apm_record", "");
    }
}
