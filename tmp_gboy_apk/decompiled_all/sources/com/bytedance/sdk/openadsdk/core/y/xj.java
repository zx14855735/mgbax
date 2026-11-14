package com.bytedance.sdk.openadsdk.core.y;

import android.text.TextUtils;
import com.bytedance.sdk.component.d.hf.u;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.ws;
import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.et.kd;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements xj.hf {
    private static HashMap<String, Long> kd = null;
    private static final String u = "com.bytedance.sdk.openadsdk.core.y.xj";
    private static volatile xj xj;
    private static final HashSet y;
    private CopyOnWriteArrayList<JSONObject> hf = new CopyOnWriteArrayList<>();
    private com.bytedance.sdk.openadsdk.core.a.xj w;

    static {
        String name = xj.class.getName();
        kd = new HashMap<>();
        y = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", name));
        bBvRBdn();
    }

    private xj() {
        com.bytedance.sdk.openadsdk.core.a.xj u2 = f.zg().u();
        this.w = u2;
        if (u2 != null) {
            u2.hf(this);
        }
    }

    private static /* synthetic */ void bBvRBdn() {
        char[] charArray = "\u008b\u0087\u0085Æ\u008f\u0089\u0085\u008dÆ\u008a\u0087\u0091Æ\u009b\u0080\u008d\u0084\u0084Æ¢\u0086\u0081ª\u009a\u0081\u008c\u008f\u008d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 232);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008b\u0084\u0081\u0086\u0081\u009c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 232);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = this.hf;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.hf.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException e) {
            pl.xj(e);
        }
        this.hf.clear();
        String d = wo.d("/api/ad/union/sdk/callstack/batch/");
        ws wsVar = new ws(kd.xj().hf().y());
        wsVar.xj(d);
        wsVar.w(jSONObject, "callstack");
        wsVar.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.y.xj.2
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                if (hfVar != null) {
                    pl.xj("CallChainStatistic", Boolean.valueOf(hfVar.f()), hfVar.u());
                } else {
                    pl.xj("CallChainStatistic", "NetResponse is null");
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(u uVar, IOException iOException) {
                pl.xj("CallChainStatistic", iOException.getMessage());
            }
        });
    }

    public static xj w() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void xj() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void hf() {
        if (f.zg().z()) {
            return;
        }
        u();
    }

    public void xj(int i, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        xj(i, hfVar.u());
    }

    private boolean xj(Long l) {
        return !xj(new Date(), new Date(l.longValue()));
    }

    private boolean xj(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    private boolean xj(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Long l = kd.get(str);
            if (l != null && l.longValue() != 0) {
                if (!xj(l)) {
                    return false;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis > 0) {
                    kd.put(str, Long.valueOf(currentTimeMillis));
                }
            }
            return true;
        } catch (Throwable th) {
            pl.w("callstack error:" + th.getMessage());
            return true;
        }
    }

    public void xj(final int i, final String str) {
        if (hf.xj() && xj(str)) {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            c.xj(new d("callChainStatistic") { // from class: com.bytedance.sdk.openadsdk.core.y.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.hf.add(xj.this.xj(i, str, stackTrace));
                    if (xj.this.hf.size() < 3) {
                        return;
                    }
                    try {
                        xj.this.u();
                    } catch (OutOfMemoryError e) {
                        pl.xj(e);
                    }
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject xj(int i, String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", str);
            jSONObject.put("appid", f.zg().pz());
            jSONObject.put(n.r, wo.p());
            jSONObject.put("ad_sdk_version", ai.u);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
            jSONObject.put("adtype", i);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("callstack", xj(obj));
            jSONObject.put(PointParamKey.TYPE, "callstack");
            jSONObject.put("device_info", com.bytedance.sdk.openadsdk.core.w.xj.xj(pz.getContext(), i));
            return jSONObject;
        } catch (JSONException e) {
            pl.xj(e);
            return jSONObject;
        }
    }

    private JSONArray xj(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj != null) {
            for (StackTraceElement stackTraceElement : (StackTraceElement[]) obj) {
                if (stackTraceElement != null) {
                    if (!y.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                        String className = stackTraceElement.getClassName();
                        if (className != null && className.startsWith("android.app")) {
                            break;
                        }
                        jSONArray.put(stackTraceElement.toString());
                    } else {
                        continue;
                    }
                }
            }
        }
        return jSONArray;
    }
}
