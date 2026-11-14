package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.j.d;
import com.bytedance.sdk.openadsdk.core.live.xj.c;
import com.bytedance.sdk.openadsdk.core.live.xj.kd;
import com.bytedance.sdk.openadsdk.core.live.xj.u;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.r;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private final u xj;

    public static final class xj {
        private static final hf xj = new hf();

        static {
            DpjUkRL();
        }

        private static /* synthetic */ void DpjUkRL() {
            char[] charArray = "§«©ê£¥©¡ê¦«½ê·¬¡¨¨ê\u008eª\u00ad\u0086¶\u00ad £¡".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 196);
            }
            String str = new String(charArray);
            char[] charArray2 = "§¨\u00adª\u00ad°".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 196);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static final hf xj() {
        return xj.xj;
    }

    public String c() {
        return this.xj.c();
    }

    public long d() {
        return this.xj.w();
    }

    public JSONObject f() {
        return this.xj.f();
    }

    public int hf(Context context, ws wsVar, Map<String, Object> map) {
        return this.xj.hf(context, wsVar, map);
    }

    public int kd() {
        return this.xj.kd();
    }

    public void u() {
        this.xj.u();
    }

    public int w() {
        return this.xj.hf();
    }

    public int y() {
        return com.bytedance.sdk.openadsdk.core.w.u.xj().w();
    }

    private hf() {
        if (!d.xj()) {
            this.xj = new com.bytedance.sdk.openadsdk.core.live.xj.hf();
            return;
        }
        if (ai.y) {
            this.xj = new c();
        } else if (ai.c()) {
            this.xj = new kd();
        } else {
            this.xj = new com.bytedance.sdk.openadsdk.core.live.xj.hf();
        }
    }

    public boolean hf(ws wsVar) {
        if (wsVar == null || TextUtils.isEmpty(wsVar.wr())) {
            return false;
        }
        return xj(wsVar.wr(), wsVar.vu());
    }

    public void kd(ws wsVar) {
        this.xj.u(wsVar);
    }

    public void u(final ws wsVar) {
        long startElapsedRealtime;
        if (wsVar == null) {
            return;
        }
        kd(wsVar);
        if (TextUtils.isEmpty(wsVar.wr())) {
            return;
        }
        int w = com.bytedance.sdk.openadsdk.core.w.u.xj().w() + 1;
        if (w > 100) {
            w = 100;
        }
        com.bytedance.sdk.openadsdk.core.w.u.xj().xj(w);
        final int w2 = w();
        final int kd = kd();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        startElapsedRealtime = Process.getStartElapsedRealtime();
        final long j = elapsedRealtime - startElapsedRealtime;
        if (wsVar.vu() == 1 && wsVar.kn() == 1) {
            com.bytedance.sdk.openadsdk.core.ht.hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.live.hf.1
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(n.m, wsVar.jf());
                        jSONObject.put("live_sdk_status", w2);
                        jSONObject.put("live_auth_status", kd);
                        jSONObject.put("app_start_time", j);
                        jSONObject.put("is_web", wsVar.xj());
                    } catch (Throwable unused) {
                    }
                    return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("saas_miss").hf(jSONObject.toString());
                }
            }, "saas_miss", true);
        }
    }

    public int w(ws wsVar) {
        if (pz.hf().ps()) {
            return this.xj.b_(wsVar);
        }
        return 0;
    }

    public void xj(Function<SparseArray<Object>, Object> function) {
        this.xj.xj(function);
    }

    public boolean y(ws wsVar) {
        return wsVar != null && wsVar.wo() == 2;
    }

    public int xj(Context context, ws wsVar, Map<String, Object> map) {
        if (context == null || wsVar == null) {
            return 5;
        }
        return this.xj.xj(context, wsVar, map);
    }

    public void hf() {
        this.xj.xj();
    }

    public void xj(String str, boolean z) {
        this.xj.xj(str, z);
    }

    public int xj(ws wsVar, com.bytedance.sdk.openadsdk.core.live.xj.w wVar, String str) {
        return this.xj.xj(wsVar, wVar, str);
    }

    public boolean xj(ws wsVar) {
        return this.xj.xj(wsVar);
    }

    public void xj(String str, ws wsVar, long j) {
        this.xj.xj(str, wsVar, j);
    }

    public boolean xj(String str, int i) {
        return this.xj.xj(str, i);
    }

    public void xj(View view, r rVar, Map<String, Object> map, Map<String, Object> map2) {
        Object tag;
        if (view == null || rVar == null || (tag = view.getTag(TTAdConstant.KEY_CLICK_AREA)) == null || !(tag instanceof Integer)) {
            return;
        }
        int intValue = ((Integer) tag).intValue();
        int i = intValue & 255;
        int i2 = (intValue & 65280) >>> 8;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (i == 101 && !rVar.w()) {
            i = 102;
        }
        map.put("live_saas_param_interaction_type", Integer.valueOf(i));
        map2.put("click_saas_area", Integer.valueOf(i2));
    }

    public int xj(String str) {
        return this.xj.xj(str);
    }

    public int xj(com.bytedance.sdk.openadsdk.core.live.hf.hf hfVar, boolean z) {
        return this.xj.xj(hfVar, z);
    }

    public void xj(com.bytedance.sdk.openadsdk.qt.u uVar) {
        this.xj.xj(uVar);
    }
}
