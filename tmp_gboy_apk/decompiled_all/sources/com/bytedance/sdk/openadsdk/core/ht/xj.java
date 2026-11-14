package com.bytedance.sdk.openadsdk.core.ht;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.a.io;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.core.yo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.constant.BaseConstants;
import io.dcloud.openapi.core.util.Const;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements com.bytedance.sdk.component.f.xj.f {
    public static final xj xj = new xj();
    private long hf;
    private String u;
    private int w;

    static {
        TlFak();
    }

    private xj() {
    }

    private static /* synthetic */ void TlFak() {
        char[] charArray = "²¾¼ÿ¶°¼´ÿ³¾¨ÿ¢¹´½½ÿ\u009b¿¸\u0093£¸µ¶´".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 209);
        }
        String str = new String(charArray);
        char[] charArray2 = "²½¸¿¸¥".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 209);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String p() {
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

    public static int pl() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public String c() {
        return wo.d("/api/ad/union/sdk/stats/batch/");
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", yo.w());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public boolean f() {
        return ai.xj();
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public byte[] hf(JSONObject jSONObject, int i) {
        byte[] hf = hf(jSONObject);
        com.bytedance.sdk.component.u.xj hf2 = dk.hf();
        if (hf == null || hf2 == null || !hf2.getArmorLoadStatus() || i <= 3) {
            return null;
        }
        byte[] encrypt = hf2.encrypt(hf);
        if (encrypt == null) {
            am.xj().xj(3, -1L, "stats");
        }
        return encrypt;
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public com.bytedance.sdk.component.f.xj.xj.y kd() {
        return new pl(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf());
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public int tf() {
        return pz.hf().le() ? 4 : 3;
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public int u() {
        int dk = pz.hf().dk();
        if (dk < 0 || dk == Integer.MAX_VALUE) {
            return 10;
        }
        return dk;
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public long w() {
        long ht = pz.hf().ht();
        return (ht < 0 || ht == 2147483647L) ? PushUIConfig.dismissTime : ht;
    }

    public String xj(Context context) {
        try {
            return com.bytedance.sdk.openadsdk.core.a.p.w(context) ? "tv" : com.bytedance.sdk.openadsdk.core.a.p.hf(context) ? "android_pad" : "android";
        } catch (Throwable unused) {
            return "android";
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public String y() {
        return wo.dk();
    }

    private byte[] hf(JSONObject jSONObject) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (jSONObject == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        try {
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
        try {
            gZIPOutputStream.write(jSONObject.toString().getBytes());
            gZIPOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            gZIPOutputStream2 = gZIPOutputStream;
            com.bytedance.sdk.component.utils.pl.xj(e);
            if (gZIPOutputStream2 != null) {
                gZIPOutputStream2.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (IOException e4) {
                    com.bytedance.sdk.component.utils.pl.xj(e4);
                }
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @SuppressLint({"HardwareIds"})
    private JSONObject xj(List<com.bytedance.sdk.component.f.xj.hf> list, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        Context context = pz.getContext();
        if (z) {
            try {
                jSONObject.put(PluginConstants.KEY_SDK_VERSION, ai.u);
                jSONObject.put("display_name", com.bytedance.sdk.openadsdk.core.f.xj.kd());
                jSONObject.put(n.r, com.bytedance.sdk.openadsdk.core.f.xj.u());
                jSONObject.put("package", wo.d());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
                jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                ArrayList<String> xj2 = com.bytedance.sdk.component.utils.w.xj(context, "MD5");
                if (xj2 != null && !xj2.isEmpty()) {
                    jSONObject.put("sig_hash", xj2.get(0));
                }
                jSONObject.put("version_code", wo.tf());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.u("log_net", th.getMessage());
                return jSONObject;
            }
        }
        jSONObject.put("ua", com.bytedance.sdk.openadsdk.core.a.tf.g());
        com.bytedance.sdk.openadsdk.qt.hf.w(context, jSONObject);
        jSONObject.put("openudid", com.bytedance.sdk.openadsdk.core.a.tf.xj());
        jSONObject.put("oaid", com.bytedance.sdk.openadsdk.core.a.tf.w(false));
        jSONObject.put("ad_sdk_version", ai.u);
        jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
        jSONObject.put("is_plugin", ai.xj());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.a.p.xj((String) null));
        jSONObject2.put("client_ipv6", com.bytedance.sdk.openadsdk.core.a.tf.qt());
        jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
        jSONObject.put("sim_op", yo.p());
        jSONObject.put("root", z2 ? 1 : 0);
        jSONObject.put("timezone", com.bytedance.sdk.openadsdk.core.a.tf.v());
        jSONObject.put("access", com.bytedance.sdk.component.utils.am.c(context));
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        if (TextUtils.isEmpty(this.u)) {
            this.u = xj(context);
        }
        jSONObject.put("device_type", this.u);
        jSONObject.put("device_model", com.bytedance.sdk.openadsdk.core.a.tf.hf());
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put(MediaFormat.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        jSONObject.put("resolution", r.kd(context) + "x" + r.u(context));
        jSONObject.put("display_density", xj(r.f(context)));
        jSONObject.put("density_dpi", r.f(context));
        jSONObject.put("device_id", yo.w());
        int w = com.bytedance.sdk.component.f.hf.w.xj.w(list, com.bytedance.sdk.component.f.hf.xj.kd(Const.TYPE_CSJ));
        if (w != 0) {
            jSONObject.put("aid", String.valueOf(w));
        } else {
            jSONObject.put("aid", "1371");
        }
        jSONObject.put("rom", com.bytedance.sdk.openadsdk.core.a.tf.jk());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", com.bytedance.sdk.openadsdk.core.a.tf.p());
        jSONObject.put("ut", this.w);
        jSONObject.put("uid", this.hf);
        jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.a.tf.w());
        jSONObject.put("screen_bright", Math.ceil(com.bytedance.sdk.openadsdk.core.a.p.pl() * 10.0f) / 10.0d);
        jSONObject.put("is_screen_off", !com.bytedance.sdk.openadsdk.core.a.p.xj() ? 1 : 0);
        if (context != null) {
            jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.core.f.xj.xj(context));
        }
        if (x.w() > 0) {
            jSONObject.put("screenshot_time", String.valueOf(x.w()));
        }
        jSONObject.put("mnc", com.bytedance.sdk.openadsdk.core.a.tf.kd());
        jSONObject.put("mcc", com.bytedance.sdk.openadsdk.core.a.tf.u());
        jSONObject.put("pan_code_serial", n.i);
        return jSONObject;
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public String hf() {
        return wo.et();
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public JSONObject xj(List<com.bytedance.sdk.component.f.xj.hf> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            boolean z2 = false;
            try {
                xj(list.get(0));
                JSONArray jSONArray = new JSONArray();
                Iterator<com.bytedance.sdk.component.f.xj.hf> it = list.iterator();
                while (it.hasNext()) {
                    JSONObject c = it.next().c();
                    if (TextUtils.equals("pangle_live_sdk_monitor", c.optString("event"))) {
                        if (!z2) {
                            z2 = true;
                        }
                        c.putOpt("nt", Integer.valueOf(com.bytedance.sdk.component.utils.am.w(pz.getContext())));
                    }
                    jSONArray.put(c);
                }
                jSONObject.put("header", xj(list, z2, z));
                jSONObject.put("event_v3", jSONArray);
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put("_gen_time", System.currentTimeMillis());
                return jSONObject;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.w(e.getMessage());
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public byte[] xj(JSONObject jSONObject, int i) {
        byte[] hf = hf(jSONObject);
        if (hf == null) {
            return null;
        }
        com.bytedance.sdk.component.u.xj hf2 = dk.hf();
        if (i > 3 && hf2 != null) {
            byte[] encrypt = hf2.encrypt(hf);
            if (encrypt == null) {
                am.xj().xj(3, -1L, "applog");
            }
            return encrypt;
        }
        return TTEncryptUtils.a(hf, hf.length);
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public boolean xj() {
        return com.bytedance.sdk.openadsdk.core.f.zg().hl();
    }

    @Override // com.bytedance.sdk.component.f.xj.f
    public JSONObject xj(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.xj.xj(jSONObject);
    }

    private void xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        String optString;
        if (hfVar == null) {
            return;
        }
        JSONObject c = hfVar.c();
        JSONObject optJSONObject = c.optJSONObject("params");
        if (optJSONObject != null) {
            optString = optJSONObject.optString("log_extra", "");
        } else {
            optString = c.optString("log_extra", "");
        }
        long u = wo.u(optString);
        int kd = wo.kd(optString);
        if (u == 0) {
            u = this.hf;
        }
        this.hf = u;
        if (kd == 0) {
            kd = this.w;
        }
        this.w = kd;
    }

    public static String xj(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i == 480) {
            return "xxhdpi";
        }
        if (i != 640) {
            return "mdpi";
        }
        return "xxxhdpi";
    }
}
