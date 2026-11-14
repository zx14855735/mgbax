package com.bytedance.sdk.openadsdk.core.j;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.a.ra;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.ws;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.v;
import com.sigmob.sdk.base.n;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f extends com.bytedance.sdk.component.tf.d {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile f u;
    private volatile Runnable c;
    private final Context hf;
    private final kd xj;
    private static final AtomicLong w = new AtomicLong(0);
    private static boolean kd = true;
    private static volatile boolean y = false;

    public class xj extends BroadcastReceiver {
        private xj() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            pl.xj("SdkSettingsHelper", "onReceive: ");
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    f.w.set(longExtra);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                try {
                    if (f.this.xj != null) {
                        f.this.xj.xj();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    static {
        VXbZE();
    }

    private f(kd kdVar) {
        super("SdkSettingsHelper");
        this.xj = kdVar == null ? pz.hf() : kdVar;
        Context context = pz.getContext();
        this.hf = context;
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            try {
                context.registerReceiver(new xj(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"), wo.io(), com.bytedance.sdk.component.utils.f.xj());
            } catch (Throwable unused) {
            }
        }
    }

    private static /* synthetic */ void VXbZE() {
        char[] charArray = "üðò±øþòú±ýðæ±ì÷úóó±ÕñöÝíöûøú".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 159);
        }
        String str = new String(charArray);
        char[] charArray2 = "üóöñöë".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 159);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static JSONObject d() {
        JSONObject optJSONObject;
        JSONObject en = com.bytedance.sdk.openadsdk.core.f.zg().en();
        if (en == null) {
            return new JSONObject();
        }
        Iterator<String> keys = en.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (optJSONObject = en.optJSONObject(next)) != null) {
                try {
                    optJSONObject.put("plugin_update_network", com.bytedance.sdk.openadsdk.core.f.zg().et().xj(next));
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        }
        return en;
    }

    private boolean f() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.f.zg().pz());
    }

    public static boolean u() {
        return y;
    }

    public JSONObject kd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.core.a.tf.am());
            jSONObject.put("ipv6", com.bytedance.sdk.openadsdk.core.a.tf.qt());
            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.core.a.tf.w(false));
            jSONObject.put("oaid_source", ra.xj());
            jSONObject.put(bn.i, com.bytedance.sdk.openadsdk.core.a.tf.hf());
            jSONObject.put("conn_type", am.hf(this.hf));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put(PluginConstants.KEY_SDK_VERSION, ai.u);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
            jSONObject.put("is_plugin", ai.xj());
            jSONObject.put("is_boost", true);
            jSONObject.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.u.xj.u());
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.core.pl.d.u());
            jSONObject.put(n.p, wo.d());
            jSONObject.put("position", wo.u() ? 1 : 2);
            jSONObject.put(n.r, wo.p());
            jSONObject.put("app_code", wo.tf());
            String str = Build.MANUFACTURER;
            jSONObject.put("vendor", str);
            jSONObject.put(PluginConstants.KEY_APP_ID, com.bytedance.sdk.openadsdk.core.f.zg().pz());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.kd.hf(com.bytedance.sdk.openadsdk.core.f.zg().pz() != null ? com.bytedance.sdk.openadsdk.core.f.zg().pz().concat(String.valueOf(currentTimeMillis)).concat(ai.u) : ""));
            pl.xj("isApplicationForeground", "app_version:" + wo.p() + "，vendor:" + str);
            jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.a.tf.w());
            jSONObject.put("channel", ai.c);
            jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.a.tf.e());
            jSONObject.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.f.zg().y());
            com.bytedance.sdk.openadsdk.qt.hf.xj(this.hf, jSONObject);
            com.bytedance.sdk.openadsdk.qt.hf.hf(this.hf, jSONObject);
            jSONObject.put("system_app", ai.w());
            if (ai.xj()) {
                jSONObject.put("plugins", d());
            }
            jSONObject.put("imei", com.bytedance.sdk.openadsdk.core.a.tf.f());
            jSONObject.put(n.l, 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            String s = com.bytedance.sdk.openadsdk.core.f.zg().s();
            if (!TextUtils.isEmpty(s)) {
                jSONObject.put("rit_list", s);
            }
            long ws = pz.hf().ws();
            if (ws > 0) {
                jSONObject.put("data_time", ws);
            }
            Object b = pz.hf().b();
            if (b != null) {
                jSONObject.put("digest", b);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("DeviceRate", "bytebench_value")));
            } catch (NumberFormatException unused) {
                jSONObject.put("device_score", -1);
            }
            jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.f.zg().ws() ? 1 : 0);
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!am.xj(this.hf)) {
            try {
                this.xj.xj();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (f()) {
            return;
        }
        if (!d.xj() || v.xj) {
            JSONObject kd2 = kd();
            ws wsVar = new ws(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y());
            wsVar.xj(com.bytedance.sdk.openadsdk.c.w.xj(wsVar, wo.f("/api/ad/union/sdk/settings/")));
            wsVar.hf("User-Agent", com.bytedance.sdk.openadsdk.core.a.tf.g());
            wsVar.hf(kd2, "settings");
            com.bytedance.sdk.openadsdk.c.w.xj(kd2, 1);
            wsVar.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.j.f.2
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                    if (hfVar == null || !hfVar.f()) {
                        try {
                            f.this.xj.xj();
                            pz.hf().yo();
                        } catch (Throwable unused2) {
                        }
                        v.hf();
                        return;
                    }
                    try {
                        try {
                            final JSONObject jSONObject = (JSONObject) com.bytedance.sdk.openadsdk.core.w.y.xj(hfVar, "settings", false).second;
                            if (jSONObject == null) {
                                return;
                            }
                            try {
                                if (!f.this.xj(jSONObject)) {
                                    pl.hf("SdkSettingsHelper", "can not update settings");
                                    return;
                                }
                            } catch (Throwable unused3) {
                            }
                            if (ai.y) {
                                f.this.xj.xj(jSONObject);
                            }
                            new com.bytedance.sdk.openadsdk.core.u.hf("check_and_update_pl").xj(5).hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.f.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONArray optJSONArray;
                                    JSONArray optJSONArray2 = jSONObject.optJSONArray("plugins");
                                    if (optJSONArray2 != null) {
                                        com.bytedance.sdk.openadsdk.core.ai.xj.hf.xj().xj(optJSONArray2);
                                    }
                                    JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
                                    if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("plugins")) == null) {
                                        return;
                                    }
                                    com.bytedance.sdk.openadsdk.core.ai.xj.hf.xj().xj(optJSONArray);
                                }
                            });
                            try {
                                f.this.xj.hf(jSONObject);
                                v.xj();
                                if (!f.y) {
                                    boolean unused4 = f.y = true;
                                }
                                com.bytedance.sdk.openadsdk.core.f.zg().et().kd();
                                com.bytedance.sdk.openadsdk.core.en.xj.hf();
                            } catch (Throwable th) {
                                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("setting_saveData_failed", f.this.xj(th), th);
                            }
                            com.bytedance.sdk.openadsdk.core.ht.am.xj().hf();
                            if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                                f.hf();
                            }
                            com.bytedance.sdk.openadsdk.c.w.hf(jSONObject, 1);
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("setting_decrypt", th2);
                        }
                    } catch (Throwable th3) {
                        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("setting_parse", th3);
                    }
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                    try {
                        Iterator<String> keys = com.bytedance.sdk.openadsdk.core.f.zg().en().keys();
                        while (keys.hasNext()) {
                            com.bytedance.sdk.openadsdk.core.ai.xj.hf.xj().xj(keys.next(), PluginConstants.ERROR_PLUGIN_FETCH);
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        f.this.xj.xj();
                        pz.hf().yo();
                    } catch (Throwable unused3) {
                    }
                    v.hf();
                }
            });
        }
    }

    public void w() {
        xj(false);
    }

    public static void hf() {
        if (pz.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(wo.d());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                pz.getContext().sendBroadcast(intent, wo.d() + ".openadsdk.permission.TT_PANGOLIN");
            } catch (Throwable unused) {
            }
        }
    }

    public static f xj(kd kdVar) {
        if (u == null) {
            synchronized (f.class) {
                try {
                    if (u == null) {
                        u = new f(kdVar);
                    }
                } finally {
                }
            }
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(long j) {
        w.set(j);
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            xj(j);
        }
        com.bytedance.sdk.component.tf.c.xj(this, 10);
    }

    public static void xj() {
        try {
            j.xj("tt_sdk_settings_other").clear();
            j.xj("tt_sdk_settings_other_bst").clear();
            j.xj("tt_sdk_settings_slot").clear();
            j.xj("tt_sdk_settings_slot_bst").clear();
            j.xj("tt_sdk_settings_slot_splash").clear();
            j.xj("tt_sdk_settings_slot_splash_bst").clear();
        } catch (Throwable unused) {
        }
    }

    public static void xj(long j) {
        if (j > 0 && pz.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(wo.d());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                pz.getContext().sendBroadcast(intent, wo.io());
            } catch (Throwable unused) {
            }
        }
    }

    public void xj(boolean z) {
        try {
            if (f()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!z) {
                if (currentTimeMillis - w.get() < 600000) {
                    return;
                }
                hf(currentTimeMillis);
            } else {
                if (this.c != null) {
                    pl.hf("SdkSettingsHelper", "current task is not null !");
                    return;
                }
                long j = (w.get() + 60000) - currentTimeMillis;
                if (j > 0) {
                    this.c = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.c = null;
                            f.this.hf(System.currentTimeMillis());
                        }
                    };
                    com.bytedance.sdk.component.utils.f.xj().postDelayed(this.c, j);
                } else {
                    this.c = null;
                    hf(currentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("active_control", 1);
                d.xj(optInt);
                pl.xj("SdkSettingsHelper", "sdk status: ".concat(String.valueOf(optInt)));
                return optInt == 1;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject xj(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (th != null) {
            int i = 0;
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                i++;
                if (stackTraceElement != null) {
                    try {
                        jSONObject.putOpt(String.valueOf(i), stackTraceElement.toString());
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }
}
