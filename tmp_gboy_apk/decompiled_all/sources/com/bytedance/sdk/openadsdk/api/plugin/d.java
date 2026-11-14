package com.bytedance.sdk.openadsdk.api.plugin;

import IzHBwY.A4TApA;
import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginDecodeCallback;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fl.saas.base.custom.MedProConst;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.n;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {

    /* renamed from: pl, reason: collision with root package name */
    private static volatile TTPluginListener f10272pl;
    private static volatile BaseDexClassLoader u;
    private final Context d;
    private static final String xj = "next" + File.separator;
    private static final HashMap<String, TTPluginListener> hf = new HashMap<>();
    private static final HashMap<String, Handler> w = new HashMap<>();
    private static volatile d kd = null;
    private final CountDownLatch y = new CountDownLatch(1);
    private volatile boolean c = false;
    private volatile String f = "none";
    private JSONObject tf = new JSONObject();
    private EventListener p = null;

    public static final class hf implements IZeusLogger {
        private hf() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.y.kd(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.y.w(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.y.xj(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.y.u(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.y.u(str, str2, th);
        }
    }

    public static final class xj {
        public String c;
        public String kd;
        public int u;
        public String w;
        public int y;
        public String xj = "";
        public File hf = null;
        public int d = 0;
        public int tf = Integer.MAX_VALUE;
        public List<String> f = null;

        public boolean xj() {
            return this.y == 3;
        }
    }

    static {
        fuybNq();
    }

    private d(Context context) {
        this.d = context.getApplicationContext();
        try {
            GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th);
        }
        hf(context.getApplicationContext());
    }

    private static /* synthetic */ void fuybNq() {
        char[] charArray = "JFD\u0007NHDL\u0007KFP\u0007ZALEE\u0007cG@k[@MNL".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ')');
        }
        String str = new String(charArray);
        char[] charArray2 = "JE@G@]".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ')');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static xj kd(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return xj(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.y.kd("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                ARc23Z A5SV6n2 = ARc23Z.A5SV6n(3);
                SparseArray sparseArray = A5SV6n2.f4113A2egSU;
                A5SV6n2.ADYaiT(0, 1);
                sparseArray.put(1, str);
                sparseArray.put(2, plugin.mClassLoader);
                TTAdSdk.getAdManager().register(A5SV6n2.A2egSU().sparseArray());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "initPluginService failed in " + str, th);
        }
    }

    private void hf(Context context) {
        try {
            com.bytedance.pangle.kd.kd.xj(new com.bytedance.pangle.y() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.1
                @Override // com.bytedance.pangle.y
                public void hf(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.yo.xj.xj().w().execute(runnable);
                }

                @Override // com.bytedance.pangle.y
                public void w(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }

                @Override // com.bytedance.pangle.y
                public void xj(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.yo.xj.xj().w().execute(runnable);
                }
            });
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.2
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MediationConstant.EXTRA_DURATION, jSONObject.opt(MediationConstant.EXTRA_DURATION));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            d.this.tf.put("zeus", jSONObject2);
                        } catch (Exception e) {
                            com.bytedance.sdk.openadsdk.api.y.xj(e);
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        y.xj(str, jSONObject);
                    } else {
                        y.hf(str, jSONObject);
                    }
                }

                @Override // com.bytedance.pangle.log.IZeusReporter
                public void saveRecord(String str, String str2) {
                    kd.xj(str, str2);
                }
            };
            com.bytedance.pangle.kd.kd.xj(new com.bytedance.pangle.y() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.3
                @Override // com.bytedance.pangle.y
                public void hf(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.yo.xj.xj().w().execute(runnable);
                }

                @Override // com.bytedance.pangle.y
                public void w(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }

                @Override // com.bytedance.pangle.y
                public void xj(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.yo.xj.xj().w().execute(runnable);
                }
            });
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(w(context));
            globalParam.setLogger(new hf());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.4
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", str + " state changed, " + i);
                    if (i != 9 || TextUtils.equals(str, "com.byted.pangle")) {
                        return;
                    }
                    d.this.u(str);
                }
            });
            Zeus.setDecodeCallback(new ZeusPluginDecodeCallback() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.5
                @Override // com.bytedance.pangle.ZeusPluginDecodeCallback
                public String decode(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String optString = jSONObject.optString("cypher");
                        String optString2 = jSONObject.optString("message");
                        if (!TextUtils.equals(optString, "3") || TextUtils.isEmpty(optString2)) {
                            return null;
                        }
                        return com.bytedance.sdk.openadsdk.api.plugin.w.hf.hf(optString2);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "dex plugin decode throw error ".concat(String.valueOf(th)));
                        return null;
                    }
                }
            });
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isDexPlugin", 1);
                jSONObject.put("apiVersionCode", 1000);
                jSONObject.put("packageName", "com.byted.mixed");
                jSONObject.put("hostPackageName", "com.byted.pangle");
                jSONObject.put("minPluginVersion", 1000);
                jSONObject.put("maxPluginVersion", 999999999);
                jSONObject.put("internalPath", "");
                jSONObject.put("internalVersionCode", -1);
                jSONObject.put(MedProConst.AD_APPKEY, "");
                jSONObject.put("appSecretKey", "");
                Zeus.addPackageDexManager("com.byted.mixed", jSONObject);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "init dex plugin config throw error " + th);
            }
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.6
                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i, String str2) {
                    if (i == 7) {
                        d.this.hf(str, i);
                        return;
                    }
                    if (i == 6) {
                        d.this.hf(str, i);
                        if (d.this.p == null || !"com.byted.pangle".equals(str)) {
                            com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "no main pl");
                            return;
                        }
                        EventListener eventListener = d.this.p;
                        A4TApA ADYaiT2 = A4TApA.ADYaiT();
                        ADYaiT2.f4105A5SV6n = true;
                        eventListener.onEvent(0, ADYaiT2.A5SV6n());
                    }
                }
            });
            this.c = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "Unexpected error for init zeus.", th2);
            this.f = th2.getMessage();
        }
        PluginManager pluginManager = PluginManager.getInstance();
        pluginManager.registerPlugin("{apiVersionCode:7132,packageName:com.byted.pangle,minPluginVersion:7132,internalPath:'',internalVersionCode:7132}");
        pluginManager.registerPlugin("{apiVersionCode:999,packageName:com.byted.csj.ext,minPluginVersion:1000,maxPluginVersion:999999999,internalPath:'',internalVersionCode:-1,appKey:'',appSecretKey:''}");
        pluginManager.registerPlugin("{apiVersionCode:2114,packageName:com.byted.live.lite,minPluginVersion:211400,maxPluginVersion:999999,isSupportLibIsolate:true}");
    }

    private static File w(Context context) {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(context, "tt_pangle_bykv_file", 0), xj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str, int i) {
        com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt(PluginConstants.KEY_ERROR_CODE, i);
        TTPluginListener tTPluginListener = hf.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public static d xj(Context context) {
        if (kd == null) {
            synchronized (d.class) {
                try {
                    if (kd == null) {
                        kd = new d(context);
                    }
                } finally {
                }
            }
        }
        return kd;
    }

    private static boolean u(Context context) {
        File w2 = w(context);
        return w2.exists() && w2.listFiles().length != 0;
    }

    public JSONObject xj() {
        return this.tf;
    }

    public BaseDexClassLoader xj(c cVar, int i) {
        boolean z;
        String str;
        if (this.c) {
            boolean hf2 = com.bytedance.sdk.openadsdk.api.plugin.w.w.hf();
            int i2 = 8;
            if (!Zeus.isPluginInstalled("com.byted.pangle")) {
                if (hf2) {
                    new f(this.d).xj();
                }
                if (u(this.d)) {
                    Zeus.installFromDownloadDir();
                }
                try {
                    if (!hf2) {
                        com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "dont wait pl");
                    } else {
                        com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "wait start");
                        this.y.await(i, TimeUnit.MILLISECONDS);
                    }
                    com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "wait done");
                    cVar.hf("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "Install wait time out");
                    throw new u(8, "install wait timeout");
                }
            }
            if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
                u = Zeus.getPlugin("com.byted.pangle").mClassLoader;
                z = true;
            } else {
                z = false;
            }
            cVar.hf("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (u == null) {
                if (this.y.getCount() != 0) {
                    if (hf2) {
                        i2 = 10;
                        str = "this device does not support arm64-v8a, and install wait time out";
                    } else {
                        str = "install wait time out";
                    }
                    com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "Install wait time out");
                    throw new u(i2, str);
                }
                if (z) {
                    com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "Get null after load");
                    throw new u(9, "Get null after load");
                }
            }
            cVar.hf("get_classloader_done");
            return u;
        }
        com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "Zeus init failed.");
        throw new u(4, this.f);
    }

    public static final class w implements Serializable, Function<SparseArray<Object>, Object> {
        @Override // java.util.function.Function
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray != null) {
                ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
                int intValue = AMqCpz.intValue(-99999987, 0);
                SparseArray sparseArray2 = (SparseArray) AMqCpz.objectValue(-99999979, SparseArray.class);
                if (sparseArray2 != null) {
                    ADYaiT AMqCpz2 = A2egSU.AMqCpz(sparseArray2);
                    A4TApA ADYaiT2 = A4TApA.ADYaiT();
                    ADYaiT2.f4104A4TApA = AMqCpz2.intValue(-999900, 0);
                    ADYaiT2.f4106ADYaiT = AMqCpz2.stringValue(-999901, null);
                    ADYaiT2.f4105A5SV6n = AMqCpz2.booleanValue(-999903, false);
                    ADYaiT2.AMqCpz = A2egSU.AMqCpz((SparseArray) AMqCpz2.objectValue(-999902, SparseArray.class));
                    return xj(intValue, ADYaiT2.A5SV6n());
                }
            }
            return null;
        }

        public SparseArray<Object> xj(int i, Result result) {
            ARc23Z A4TApA2 = ARc23Z.A4TApA();
            if (i == 1) {
                kd.xj("plugin_download", "plugin update start");
                ValueSet values = result.values();
                if (values == null) {
                    kd.xj("plugin_download", "valueSet empty");
                    return null;
                }
                String stringValue = values.stringValue(3);
                int code = result.code();
                if (result.isSuccess()) {
                    xj kd = d.kd(values.stringValue(2));
                    if (kd == null || TextUtils.isEmpty(kd.w)) {
                        kd.xj("plugin_download", "plugin update received with invalid config");
                        com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                    kd.xj("plugin_download", "plugin update received: " + kd.w);
                    com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "plugin update received: " + kd.w);
                    if (kd.xj()) {
                        kd.xj("plugin_download", "plugin revert " + kd.w);
                        Zeus.unInstallPlugin(kd.w);
                    } else {
                        xj(kd);
                        kd.xj("plugin_download", "plugin install");
                        if (d.hf(kd)) {
                            A4TApA2.ASJ6gh(4, true);
                        }
                    }
                } else {
                    kd.xj("plugin_download", "plugin update received failed");
                    com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "plugin update received failed");
                    d.w(stringValue, code);
                    return null;
                }
            }
            return A4TApA2.A2egSU().sparseArray();
        }

        private void xj(xj xjVar) {
            try {
                if (TextUtils.isEmpty(xjVar.w) || !xjVar.w.equals("com.byted.pangle")) {
                    return;
                }
                d.xj(TTAppContextHolder.getContext()).hf();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(String str, int i) {
        if ("com.byted.pangle".equals(str) && i == 6) {
            com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "notify to end wait");
            this.y.countDown();
        }
        xj(i == 6, str);
    }

    public static String hf(String str) {
        int installedMaxVer;
        try {
            Plugin plugin = Zeus.getPlugin(str, false);
            if (plugin == null || (installedMaxVer = plugin.getInstalledMaxVer()) <= 0) {
                return null;
            }
            return xj(installedMaxVer);
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public Bundle xj(String str, Bundle bundle) {
        String xj2 = xj(str);
        if (!TextUtils.isEmpty(xj2)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, xj2);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public void hf(TTPluginListener tTPluginListener) {
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", sb.toString());
        if (plugin != null) {
            xj(plugin);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            f10272pl = tTPluginListener;
        }
    }

    public static String xj(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str, false) || (plugin = Zeus.getPlugin(str, false)) == null) {
                return null;
            }
            return xj(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hf(xj xjVar) {
        File file;
        if (xjVar != null && (file = xjVar.hf) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(xjVar.w, file.getAbsolutePath());
            xj(syncInstallPlugin, xjVar.w);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "plugin config is null");
        return false;
    }

    public void xj(final TTPluginListener tTPluginListener) {
        if (!this.c) {
            com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler hf2 = com.bytedance.sdk.openadsdk.yo.xj.xj().hf();
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.d.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        };
        hf2.postDelayed(runnable, 180000L);
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", sb.toString());
        if (plugin != null) {
            xj(plugin);
            hf2.removeCallbacks(runnable);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            hf.put(packageName, tTPluginListener);
            w.put(packageName, hf2);
        }
    }

    public void hf() {
        EventListener eventListener = this.p;
        if (eventListener != null) {
            A4TApA ADYaiT2 = A4TApA.ADYaiT();
            ADYaiT2.f4105A5SV6n = true;
            eventListener.onEvent(1, ADYaiT2.A5SV6n());
        }
    }

    private static xj xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xj xjVar = new xj();
        xjVar.w = jSONObject.optString(n.p);
        xjVar.u = jSONObject.optInt("version_code");
        xjVar.kd = jSONObject.optString("download_url");
        xjVar.c = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        xjVar.d = jSONObject.optInt("min_version");
        xjVar.tf = jSONObject.optInt("max_version");
        xjVar.xj = jSONObject.optString("sign");
        xjVar.y = jSONObject.optBoolean("is_revert") ? 3 : 2;
        xjVar.hf = new File(jSONObject.optString("plugin_file"));
        return xjVar;
    }

    private static void xj(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, xj(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static String xj(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static boolean xj(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void xj(boolean z, String str) {
        HashMap<String, TTPluginListener> hashMap = hf;
        TTPluginListener tTPluginListener = hashMap.get(str);
        StringBuilder sb = new StringBuilder("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", sb.toString());
        HashMap<String, Handler> hashMap2 = w;
        Handler handler = hashMap2.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = f10272pl;
            if (!xj(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                xj(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (xj(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    f10272pl = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "handle installed, load failed");
                w(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.y.hf("TTPluginManager", "handle installed failed");
            w(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    public static void xj(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.y.u("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
