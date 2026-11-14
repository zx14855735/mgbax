package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.u.xj;
import com.bytedance.sdk.openadsdk.TTFileProvider;
import com.bytedance.sdk.openadsdk.core.ra.gj;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class dk {
    public static int hf = 1;
    private static volatile xj.InterfaceC0120xj kd = null;
    private static int u = 300;
    public static int w = 2;
    public static int xj;

    public static class xj implements xj.hf {
        @Override // com.bytedance.sdk.component.u.xj.hf
        public void reportSoftDecData(String str, JSONObject jSONObject) {
            if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            dk.xj(jSONObject.toString(), str);
        }

        @Override // com.bytedance.sdk.component.u.xj.hf
        public void setCryptInitStatus(long j, boolean z) {
            com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(10001, j, Boolean.valueOf(z), (String) null);
        }
    }

    public static void c() {
        String[] rq = com.bytedance.sdk.openadsdk.core.pz.hf().rq();
        if (rq == null || rq.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : rq) {
            try {
                Class.forName(str);
                arrayList.add(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (arrayList.size() > 0) {
            xj(arrayList);
        }
    }

    public static void d() {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.dk.3
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.component.u.xj hf2 = dk.hf();
                jSONObject.put("board", Build.BOARD + "#" + hf2.pglArmorCallApi2getProperty("ro.product.board", MediationConfigUserInfoForSegment.GENDER_UNKNOWN));
                jSONObject.put(bn.i, Build.MODEL + "#" + hf2.pglArmorCallApi2getProperty("ro.product.model", MediationConfigUserInfoForSegment.GENDER_UNKNOWN));
                jSONObject.put("os_version", Build.VERSION.RELEASE + "#" + hf2.pglArmorCallApi2getProperty("ro.build.version.release", MediationConfigUserInfoForSegment.GENDER_UNKNOWN));
                jSONObject.put("vendor", Build.MANUFACTURER + "#" + hf2.pglArmorCallApi2getProperty("ro.product.manufacturer", MediationConfigUserInfoForSegment.GENDER_UNKNOWN));
                jSONObject.put("rom_version", Build.DISPLAY + "#" + hf2.pglArmorCallApi2getProperty("ro.build.display.id", MediationConfigUserInfoForSegment.GENDER_UNKNOWN));
                jSONObject.put("compiling_time", Build.TIME + "#" + (Long.parseLong(hf2.pglArmorCallApi2getProperty("ro.build.date.utc", "-1")) * 1000));
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("pangle_build_pick").hf(jSONObject.toString());
            }
        }, "pangle_build_pick");
    }

    public static boolean f() {
        String tf = com.bytedance.sdk.openadsdk.core.pz.hf().tf();
        try {
            com.bytedance.sdk.component.u.xj hf2 = hf();
            if (hf2 != null) {
                return hf2.detectHostLocalIp(tf);
            }
            return false;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return false;
        }
    }

    public static String g() {
        com.bytedance.sdk.component.u.xj hf2 = hf();
        return hf2 != null ? hf2.getArchEnv() : "";
    }

    public static com.bytedance.sdk.component.u.xj hf() {
        return (com.bytedance.sdk.component.u.xj) com.bytedance.sdk.openadsdk.ats.w.xj("armor_service");
    }

    public static void kd() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray u2 = u();
            if (u2.length() > 0) {
                jSONObject.put("usb", u2);
            }
            JSONObject jSONObject2 = new JSONObject();
            int i = TTFileProvider.f10267AlLFFp;
            ClassLoader classLoader = TTFileProvider.class.getClassLoader();
            if (classLoader != null) {
                jSONObject2.put("loader", classLoader.getClass().getName());
                Class<? super Object> superclass = classLoader.getClass().getSuperclass();
                while (true) {
                    if (superclass == null || superclass.getName().equals("java.lang.Object")) {
                        break;
                    }
                    if (superclass.getName().equals("dalvik.system.BaseDexClassLoader")) {
                        xj(classLoader, superclass, jSONObject2);
                        break;
                    }
                    superclass = superclass.getSuperclass();
                }
            }
            jSONObject.put("control", jSONObject2);
        } catch (Throwable unused) {
        }
        if (jSONObject.length() > 0) {
            xj(jSONObject.toString(), "pangle_check");
        }
    }

    public static gj p() {
        try {
            if (!com.bytedance.sdk.openadsdk.core.pz.hf().og()) {
                return null;
            }
            gj xj2 = com.bytedance.sdk.openadsdk.core.ff.xj.xj(com.bytedance.sdk.openadsdk.core.pz.getContext()).xj();
            if (xj2 != null) {
                return xj2;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void pl() {
        Context context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            com.bytedance.sdk.openadsdk.core.ff.xj.w xj2 = com.bytedance.sdk.openadsdk.core.ff.xj.w.xj(context);
            try {
                jSONObject.put("access_perm", com.bytedance.sdk.openadsdk.core.io.hf.xj(context, com.kuaishou.weapon.p0.g.b));
                jSONObject.put("change_perm", com.bytedance.sdk.openadsdk.core.io.hf.xj(context, "android.permission.CHANGE_NETWORK_STATE"));
                jSONObject.put("sim", com.bytedance.sdk.openadsdk.core.ff.xj.kd.xj());
                jSONObject.put("network", xj2.xj());
                xj(jSONObject.toString(), "uaid_info");
            } catch (Throwable unused) {
            }
        }
    }

    public static String tf() {
        gj p = p();
        com.bytedance.sdk.openadsdk.core.r.xj.xj().xj(p);
        if (p != null) {
            String gjVar = p.toString();
            if (!TextUtils.isEmpty(gjVar)) {
                return gjVar;
            }
        }
        return null;
    }

    public static JSONArray u() {
        UsbAccessory[] accessoryList = ((UsbManager) com.bytedance.sdk.openadsdk.core.pz.getContext().getSystemService("usb")).getAccessoryList();
        JSONArray jSONArray = new JSONArray();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                if (usbAccessory != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("manufacturer", usbAccessory.getManufacturer());
                        jSONObject.put(bn.i, usbAccessory.getModel());
                        jSONObject.put("desc", usbAccessory.getDescription());
                        jSONObject.put(ContentProviderManager.PROVIDER_URI, usbAccessory.getUri());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void w() {
        com.bytedance.sdk.component.u.xj hf2 = hf();
        if (hf2 != null) {
            hf2.initPglArmorCallApi(new xj());
        }
    }

    public static void xj() {
        tf();
        y();
        if (com.bytedance.sdk.openadsdk.core.pz.hf().gh()) {
            c();
            kd();
            d();
            pl();
        }
    }

    public static String y() {
        try {
            com.bytedance.sdk.component.u.xj hf2 = hf();
            if (!com.bytedance.sdk.openadsdk.core.f.zg().pl()) {
                hf2.setBlt(false);
            }
            return hf2.getSoftChara();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return xj(th);
        }
    }

    public static void hf(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.x.w wVar;
        if (jSONObject == null || com.bytedance.sdk.openadsdk.core.pz.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB) == null || (wVar = (com.bytedance.sdk.openadsdk.core.x.w) com.bytedance.sdk.openadsdk.ats.w.xj("pitaya")) == null || !wVar.isPitayaInitSuccess()) {
            return;
        }
        wVar.isPitayaEnvAvailable();
        wVar.runTask("antispam_handhold", jSONObject, new com.bytedance.sdk.openadsdk.core.x.f() { // from class: com.bytedance.sdk.openadsdk.core.a.dk.5
            @Override // com.bytedance.sdk.openadsdk.core.x.f
            public PluginValueSet xj(int i, com.bytedance.sdk.openadsdk.core.x.d dVar) {
                com.bytedance.sdk.openadsdk.zg.xj w2 = dVar.w();
                if (w2 == null) {
                    return null;
                }
                PluginValueSet u2 = w2.u();
                if (!w2.xj() || u2 == null) {
                    return null;
                }
                JSONObject jSONObject2 = (JSONObject) u2.objectValue(2, JSONObject.class);
                if (jSONObject2 != null) {
                    try {
                        JSONArray jSONArray = jSONObject2.getJSONArray("probability");
                        com.bytedance.sdk.component.u.xj hf2 = dk.hf();
                        if (jSONArray.length() == 1 && hf2 != null) {
                            hf2.softDecTool2ua(jSONArray.optDouble(0), System.currentTimeMillis());
                        }
                    } catch (JSONException unused) {
                    }
                }
                return u2;
            }
        });
    }

    private static void xj(ClassLoader classLoader, Class<?> cls, JSONObject jSONObject) {
        Field declaredField = cls.getDeclaredField("pathList");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(classLoader);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("dexElements");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField2.get(obj);
            if (objArr != null) {
                jSONObject.put("size", objArr.length);
                StringBuilder sb = new StringBuilder();
                for (Object obj2 : objArr) {
                    Field declaredField3 = obj2.getClass().getDeclaredField("dexFile");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    if (obj3 != null && !obj3.toString().startsWith("/data/app")) {
                        sb.append(obj3);
                        sb.append(";");
                    }
                }
                jSONObject.put("dexPathList", sb);
            }
        }
    }

    public static void xj(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.dk.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(str2).hf(str);
            }
        }, str2);
    }

    public static void xj(MotionEvent motionEvent) {
        try {
            hf().pglArmorCallApi2c(motionEvent);
        } catch (Throwable unused) {
        }
    }

    public static String xj(String str, long j, int i, boolean z) {
        try {
            return hf().pglArmorCallApi2ccc(str, j, i, z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void xj(long j, int i) {
        try {
            hf().pglArmorCallApi2src(j, i);
        } catch (Throwable unused) {
        }
    }

    public static int xj(String str) {
        int i = xj;
        if (str != null && !str.isEmpty()) {
            int indexOf = str.indexOf("_");
            if (indexOf <= 0) {
                return w;
            }
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            int indexOf2 = substring2.indexOf("_");
            if (indexOf2 <= 0) {
                return w;
            }
            String substring3 = substring2.substring(0, indexOf2);
            String substring4 = substring2.substring(indexOf2 + 1);
            long longValue = Long.valueOf(substring).longValue() - Long.valueOf(substring3).longValue();
            try {
                com.bytedance.sdk.component.u.xj hf2 = hf();
                if (hf2 != null) {
                    if (!hf2.signVerifyMD5withRSA(substring3 + "_" + com.bytedance.sdk.openadsdk.core.yo.w(), substring4)) {
                        return w;
                    }
                }
                return Math.abs(longValue) > ((long) u) ? hf : i;
            } catch (Throwable unused) {
                return xj;
            }
        }
        return w;
    }

    public static String xj(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.pl.xj(th2);
            return "eyJzdHRzIjozfQ==";
        }
    }

    private static void xj(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.dk.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clz", list.toString());
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("pangle_clz_found").hf(jSONObject.toString());
            }
        }, "pangle_clz_found");
    }

    public static void xj(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.dk.4
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("har_automatic").hf(jSONObject.toString());
            }
        }, "har_automatic");
    }

    public static void xj(int i, final int i2) {
        final com.bytedance.sdk.component.u.xj hf2 = hf();
        if (hf2 == null || hf2.getArmorContext() == null || !com.bytedance.sdk.openadsdk.core.f.zg().kd() || !hf2.enableSetHARSensorCallBack(i)) {
            return;
        }
        if (kd == null) {
            kd = new xj.InterfaceC0120xj() { // from class: com.bytedance.sdk.openadsdk.core.a.dk.6
                @Override // com.bytedance.sdk.component.u.xj.InterfaceC0120xj
                public void reportSensorData(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("scene", i2);
                        } catch (JSONException unused) {
                        }
                        dk.hf(jSONObject);
                        dk.xj(jSONObject);
                    }
                }
            };
            hf2.setHARSensorCallBack(kd);
        }
        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("har") { // from class: com.bytedance.sdk.openadsdk.core.a.dk.7
            @Override // java.lang.Runnable
            public void run() {
                hf2.registerHarSensors();
            }
        });
    }
}
