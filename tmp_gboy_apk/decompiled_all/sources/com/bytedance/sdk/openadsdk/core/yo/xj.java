package com.bytedance.sdk.openadsdk.core.yo;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pl.hf.u;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.kd;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.y;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements w {
    private final hf hf;
    private boolean w;
    private final ws xj;
    private com.bytedance.sdk.openadsdk.core.pl.hf.xj y;
    private final Map<String, com.bytedance.sdk.openadsdk.core.pl.hf.u> u = new HashMap();
    private boolean kd = true;
    private boolean c = false;

    private xj(hf hfVar, ws wsVar, boolean z) {
        this.hf = hfVar;
        this.xj = wsVar;
        this.w = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void w() {
        hf();
        for (com.bytedance.sdk.openadsdk.core.pl.hf.u uVar : this.u.values()) {
            if (uVar != null) {
                uVar.hf();
            }
        }
        this.u.clear();
    }

    public static xj xj(hf hfVar, ws wsVar, boolean z) {
        return new xj(hfVar, wsVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void hf() {
        Iterator<com.bytedance.sdk.openadsdk.core.pl.hf.u> it = this.u.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void hf(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || this.hf == null || (optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.u uVar = this.u.get(xj(this.xj, optJSONObject, (String) null).vh().hf());
        if (uVar != null) {
            uVar.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void xj() {
        for (com.bytedance.sdk.openadsdk.core.pl.hf.u uVar : this.u.values()) {
            if (uVar != null) {
                uVar.xj();
            }
        }
    }

    public static ws xj(ws wsVar, JSONObject jSONObject, String str) {
        String str2;
        boolean z;
        ws xj;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (jSONObject != null) {
            str2 = jSONObject.optString("download_url");
            z = true;
        } else {
            str2 = "";
            z = false;
        }
        if (TextUtils.isEmpty(str2)) {
            z = false;
        }
        boolean z2 = (wsVar.vh() == null || wsVar.vh().hf() == null || !wsVar.vh().hf().equals(str2)) ? z : false;
        if (jSONObject != null && (optJSONObject2 = jSONObject.optJSONObject("download_config_json")) != null && !optJSONObject2.optBoolean("has_valid_download_url", true)) {
            z2 = true;
        }
        if (z2) {
            xj = new ws();
            xj.u(wsVar.kd());
            xj.q(wsVar.ey());
            xj.ai(wsVar.zm());
            xj.q(jSONObject.optInt("lp_down_rule"));
            xj.j(4);
            xj.pz(jSONObject.optString(f.f13353a));
            xj.am(jSONObject.optString(n.l));
            kd kdVar = new kd();
            kdVar.u(jSONObject.optString("pkg_name"));
            kdVar.w(jSONObject.optString("name"));
            kdVar.hf(str2);
            xj.xj(kdVar);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("download_config_json");
            if (optJSONObject3 != null) {
                xj.xj(new jk(optJSONObject3));
                if (!optJSONObject3.optBoolean("has_valid_download_url", true)) {
                    xj.tf(true);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("app_manage_json");
            if (optJSONObject4 != null) {
                y ut = xj.ut();
                if (ut == null) {
                    ut = new y();
                }
                ut.xj(optJSONObject4.optInt("score"));
                ut.xj(optJSONObject4.optJSONArray("creative_tags"));
                xj.xj(ut);
                xj.g(optJSONObject4.toString());
                z uf = xj.uf();
                if (uf == null) {
                    uf = new z();
                }
                uf.xj(optJSONObject4.optString("icon_url"));
                xj.xj(uf);
                xj.v(optJSONObject4.optString("desc"));
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_manage_type_json");
            if (optJSONObject5 != null) {
                xj.ai(optJSONObject5.optInt("app_manage_type"));
            }
            int optInt = jSONObject.optInt("live_interaction_type");
            String optString = jSONObject.optString("live_room_id");
            if (optInt > 0 && !TextUtils.isEmpty(optString)) {
                xj.tu(optInt);
                xj.ff(optString);
            }
            xj.aq(jSONObject.optInt("ad_type"));
            ne xj2 = ne.xj(jSONObject.optJSONObject("wc_miniapp_info"));
            if (xj2 != null) {
                xj.xj(xj2);
            }
            String optString2 = jSONObject.optString("quick_app_url");
            if (!TextUtils.isEmpty(optString2)) {
                kd vh = xj.vh() != null ? xj.vh() : new kd();
                vh.xj(optString2);
                xj.xj(vh);
            }
        } else {
            xj = com.bytedance.sdk.openadsdk.core.xj.xj(wsVar.ac());
        }
        if (!TextUtils.isEmpty(str)) {
            xj.ht(str);
        }
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("deep_link")) != null) {
            zg zgVar = new zg();
            if (wsVar.yt() != null) {
                zgVar.xj(wsVar.yt());
            }
            zgVar.xj(new zg(optJSONObject));
            xj.xj(zgVar);
        }
        return xj;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.yo.xj$xj, reason: collision with other inner class name */
    public static class C0198xj {
        private static ConcurrentHashMap<String, JSONObject> xj = new ConcurrentHashMap<>();

        static {
            EGmQpTP();
        }

        private static /* synthetic */ void EGmQpTP() {
            char[] charArray = "\u001f\u0013\u0011R\u001b\u001d\u0011\u0019R\u001e\u0013\u0005R\u000f\u0014\u0019\u0010\u0010R6\u0012\u0015>\u000e\u0015\u0018\u001b\u0019".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '|');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u001f\u0010\u0015\u0012\u0015\b".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '|');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static synchronized JSONObject xj(String str) {
            synchronized (C0198xj.class) {
                if (TextUtils.isEmpty(str)) {
                    return new JSONObject();
                }
                ConcurrentHashMap<String, JSONObject> concurrentHashMap = xj;
                if (concurrentHashMap == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject = concurrentHashMap.get(str);
                if (jSONObject != null) {
                    return jSONObject;
                }
                return new JSONObject();
            }
        }

        public static synchronized void xj(String str, int i, int i2) {
            synchronized (C0198xj.class) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (xj == null) {
                        xj = new ConcurrentHashMap<>();
                    }
                    JSONObject jSONObject = xj.get(str);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                        xj.put(str, jSONObject);
                    }
                    try {
                        jSONObject.put("downloadStatus", i);
                        jSONObject.put("downloadProcessRate", i2);
                        jSONObject.put(PluginConstants.KEY_ERROR_CODE, 0);
                        jSONObject.put("codeMsg", "get ad_down_load_id success");
                    } catch (Exception e) {
                        pl.xj(e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void hf(boolean z) {
        this.c = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void xj(Context context, JSONObject jSONObject, String str, int i, boolean z, boolean z2) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA)) == null) {
            return;
        }
        ws xj = xj(this.xj, optJSONObject, xj(optJSONObject, str));
        xj(context, xj, optJSONObject, i, z ? tf.xj(xj) : 0, z2);
    }

    private void xj(Context context, ws wsVar, JSONObject jSONObject, int i, int i2, boolean z) {
        if (context == null || wsVar == null || wsVar.vh() == null || jSONObject == null || this.hf == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.u uVar = this.u.get(wsVar.vh().hf());
        if (uVar != null) {
            uVar.xj(i2);
            return;
        }
        String xj = wo.xj(i);
        if (TextUtils.isEmpty(xj)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.u xj2 = xj(context, wsVar, jSONObject, xj);
        xj2.xj(i2);
        if (xj2 instanceof com.bytedance.sdk.openadsdk.core.pl.w.u) {
            ((com.bytedance.sdk.openadsdk.core.pl.w.u) xj2).y(z);
        }
        this.u.put(wsVar.vh().hf(), xj2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void xj(Context context, JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA)) == null) {
            return;
        }
        xj(context, xj(this.xj, optJSONObject, xj(optJSONObject, str2)), str);
    }

    private String xj(JSONObject jSONObject, String str) {
        String optString = jSONObject != null ? jSONObject.optString(n.m) : null;
        return TextUtils.isEmpty(optString) ? str : optString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void xj(Context context, ws wsVar, String str) {
        if (context == 0 || wsVar == null) {
            return;
        }
        if (wsVar.vh() == null) {
            com.bytedance.sdk.openadsdk.core.pl.hf.w hf = com.bytedance.sdk.openadsdk.core.pl.f.hf(context, wsVar, str, false);
            if (hf instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
                ((com.bytedance.sdk.openadsdk.core.pl.w.kd) hf).y(this.w);
            }
            hf.xj(wsVar, false);
        } else {
            final String ho = wsVar.ho();
            com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = (com.bytedance.sdk.openadsdk.core.pl.hf.u) this.u.get(wsVar.vh().hf());
            if (wVar != null) {
                wVar.w(this.c);
                if (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
                    ((com.bytedance.sdk.openadsdk.core.pl.w.kd) wVar).f().xj(this.kd);
                } else if (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.f) {
                    ((com.bytedance.sdk.openadsdk.core.pl.w.f) wVar).y().xj(this.kd);
                }
                wVar.xj(wsVar, false);
                wVar.xj(new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.yo.xj.1
                    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                    public void hf(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0198xj.xj(ho, 2, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                    public void w(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0198xj.xj(ho, 4, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                    public void xj() {
                        C0198xj.xj(ho, 1, 0);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                    public void xj(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0198xj.xj(ho, 3, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                    public void xj(long j, String str2, String str3) {
                        C0198xj.xj(ho, 5, 100);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                    public void xj(String str2, String str3) {
                        C0198xj.xj(ho, 6, 100);
                    }
                });
            }
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.f.hf) {
            ((com.bytedance.sdk.openadsdk.core.f.hf) context).xj(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void xj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA)) == null) {
            return;
        }
        xj(xj(this.xj, optJSONObject, (String) null), optJSONObject);
    }

    private void xj(ws wsVar, JSONObject jSONObject) {
        if (this.hf == null || wsVar == null || wsVar.vh() == null) {
            return;
        }
        String hf = wsVar.vh().hf();
        if (this.u.containsKey(hf)) {
            com.bytedance.sdk.openadsdk.core.pl.hf.u remove = this.u.remove(hf);
            if (remove != null) {
                try {
                    remove.hf();
                } catch (JSONException e) {
                    pl.xj(e);
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("message", cb.o);
            jSONObject2.put("status", "unsubscribed");
            jSONObject2.put("appad", jSONObject);
            this.hf.xj("app_ad_event", jSONObject2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void xj(boolean z) {
        this.kd = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.w
    public void xj(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.pl.hf.u uVar;
        if (TextUtils.isEmpty(str) || (uVar = this.u.get(str)) == null) {
            return;
        }
        uVar.hf(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bytedance.sdk.openadsdk.core.pl.hf.u xj(Context context, ws wsVar, final JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.pl.hf.u hf = com.bytedance.sdk.openadsdk.core.pl.f.hf(context, wsVar, str, false);
        if (hf instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
            ((com.bytedance.sdk.openadsdk.core.pl.w.kd) hf).y(this.w);
        }
        hf.xj(new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.yo.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void hf(long j, long j2, String str2, String str3) {
                xj("status", "download_paused", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (xj.this.y == null) {
                    return;
                }
                xj.this.y.hf(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void w(long j, long j2, String str2, String str3) {
                xj("status", PointCategory.DOWNLOAD_FAILED, "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (xj.this.y == null) {
                    return;
                }
                xj.this.y.w(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj() {
                xj("status", "idle");
                if (xj.this.y == null) {
                    return;
                }
                xj.this.y.xj();
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, long j2, String str2, String str3) {
                xj("status", "download_active", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (xj.this.y == null) {
                    return;
                }
                xj.this.y.xj(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, String str2, String str3) {
                xj("status", "download_finished", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j));
                if (xj.this.y == null) {
                    return;
                }
                xj.this.y.xj(j, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(String str2, String str3) {
                xj("status", "installed");
                if (xj.this.y == null) {
                    return;
                }
                xj.this.y.xj(str2, str3);
            }

            private void xj(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", cb.o);
                    jSONObject2.put("appad", jSONObject);
                    for (int i = 0; i < strArr.length; i += 2) {
                        jSONObject2.put(strArr[i], strArr[i + 1]);
                    }
                    xj.this.hf.xj("app_ad_event", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        });
        hf.xj(new u.xj() { // from class: com.bytedance.sdk.openadsdk.core.yo.xj.3
        });
        return hf;
    }
}
