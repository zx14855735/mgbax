package com.bytedance.sdk.openadsdk.core.x;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.en;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.yo;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class am {
    private JSONObject u;
    private JSONObject w;
    private static final ConcurrentHashMap<String, JSONObject> xj = new ConcurrentHashMap<>();
    private static AtomicInteger hf = new AtomicInteger();

    static {
        YhXiYQ();
    }

    private static /* synthetic */ void YhXiYQ() {
        char[] charArray = "\u0014\u0018\u001aY\u0010\u0016\u001a\u0012Y\u0015\u0018\u000eY\u0004\u001f\u0012\u001b\u001bY=\u0019\u001e5\u0005\u001e\u0013\u0010\u0012".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'w');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0014\u001b\u001e\u0019\u001e\u0003".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'w');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private JSONObject hf(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            ws xj2 = com.bytedance.sdk.openadsdk.core.video.u.hf.xj(uVar);
            if (xj2 != null) {
                String xj3 = wo.xj(xj2, "");
                int parseInt = !TextUtils.isEmpty(xj3) ? Integer.parseInt(xj3) : 0;
                int f = wo.f(xj2);
                jSONObject.put("video_count", com.bytedance.sdk.openadsdk.y.hf.hf.xj());
                JSONObject xj4 = xj();
                jSONObject.put("device", xj4);
                JSONObject xj5 = xj(uVar, parseInt, f);
                jSONObject.put("current_video", xj5);
                jSONObject.put("predict_use", xj(String.valueOf(parseInt)));
                jSONObject.put("csj_plugin", hf());
                jSONObject.put("package", hf("video_cache"));
                jSONObject.put("hour", xj4.optInt("hour"));
                jSONObject.put("video_size", uVar.pl());
                jSONObject.put("rit", parseInt);
                jSONObject.put("preload_size", uVar.y());
                jSONObject.put("access", xj4.optString("access"));
                jSONObject.put("sdk_fg_time", xj4.optLong("sdk_fg_time"));
                jSONObject.put("ad_slot_type", xj5.optInt("ad_slot_type"));
                return jSONObject;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        return jSONObject;
    }

    private static String xj(int i, String str) {
        int incrementAndGet = hf.incrementAndGet();
        return i + "-" + yo.w() + "-" + incrementAndGet + "-" + str + "-" + System.currentTimeMillis();
    }

    private static JSONObject xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return xj.get(str);
    }

    public static void xj(int i, long j, ws wsVar, com.bykv.vk.openvk.component.video.api.w.u uVar) {
        com.bytedance.sdk.openadsdk.zg.w.w.hf gh;
        if (wsVar == null || uVar == null || (gh = wsVar.gh()) == null) {
            return;
        }
        try {
            JSONObject xj2 = xj(gh.u());
            if (xj2 != null) {
                String e = uVar.e();
                String optString = xj2.optString(PointParamKey.TRACE_ID);
                if (!TextUtils.isEmpty(optString) && optString.contains(e)) {
                    xj2.put("play_type", i);
                    xj2.put("cache_size", j);
                }
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
    }

    public static void xj(long j, ws wsVar, com.bykv.vk.openvk.component.video.api.w.u uVar) {
        com.bytedance.sdk.openadsdk.zg.w.w.hf gh;
        if (wsVar == null || uVar == null || (gh = wsVar.gh()) == null) {
            return;
        }
        try {
            JSONObject xj2 = xj(gh.u());
            if (xj2 != null) {
                String optString = xj2.optString(PointParamKey.TRACE_ID);
                if (!TextUtils.isEmpty(optString) && optString.contains(uVar.e())) {
                    xj2.put("play_duration", j);
                    xj2.put("pitaya_meet_cache", 1);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    private JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("access", com.bytedance.sdk.component.utils.am.c(pz.getContext()));
            jSONObject.put("hour", Calendar.getInstance().get(11));
            long currentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.a.xj.hf;
            if (currentTimeMillis > 0) {
                jSONObject.put("sdk_fg_time", currentTimeMillis);
                return jSONObject;
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONObject;
    }

    private JSONObject hf(final String str) {
        w wVar = (w) com.bytedance.sdk.openadsdk.ats.w.xj("pitaya");
        if (wVar != null) {
            wVar.queryPackage(str, new f() { // from class: com.bytedance.sdk.openadsdk.core.x.am.1
                @Override // com.bytedance.sdk.openadsdk.core.x.f
                public PluginValueSet hf(int i, SparseArray<Object> sparseArray) {
                    if (sparseArray == null) {
                        return null;
                    }
                    com.bytedance.sdk.openadsdk.zg.xj xjVar = new com.bytedance.sdk.openadsdk.zg.xj(sparseArray);
                    PluginValueSet u = xjVar.u();
                    boolean xj2 = xjVar.xj();
                    if (u != null) {
                        if (TextUtils.equals(str, u.stringValue(5))) {
                            if (xj2) {
                                am.this.w = (JSONObject) u.objectValue(3, JSONObject.class);
                                JSONObject unused = am.this.w;
                            } else {
                                am.this.u = (JSONObject) u.objectValue(4, JSONObject.class);
                            }
                        }
                    }
                    return super.hf(i, sparseArray);
                }
            });
        } else {
            this.w = new JSONObject();
        }
        return this.w;
    }

    private JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_api_code", ai.w);
            jSONObject.put("core_plugin_code", 7132);
            jSONObject.put("ext_api_code", ai.kd);
            jSONObject.put("ext_plugin_code", en.hf());
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return jSONObject;
        }
    }

    private JSONObject xj(com.bykv.vk.openvk.component.video.api.w.u uVar, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_size", uVar.pl());
            jSONObject.put("preload_size", uVar.y());
            jSONObject.put("video_duration", uVar.et().y());
            jSONObject.put("ad_slot_type", i2);
            jSONObject.put("rit", i);
            jSONObject.put("video_url", uVar.zg());
            jSONObject.put("preload_all", uVar.g());
            jSONObject.put(PointParamKey.TRACE_ID, xj(i, uVar.e()));
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return jSONObject;
        }
    }

    public static void xj(com.bykv.vk.openvk.component.video.api.w.u uVar, JSONObject jSONObject, int i, int i2) {
        int optInt;
        if (uVar == null || jSONObject == null || (optInt = jSONObject.optInt("rit", 0)) <= 0) {
            return;
        }
        xj.put(String.valueOf(optInt), jSONObject);
    }

    public JSONObject xj(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        return hf(uVar);
    }
}
