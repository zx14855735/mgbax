package com.bytedance.msdk.kd;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.msdk.f.ai;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d implements com.bytedance.sdk.component.f.xj.p {
    private static final Handler hf = new Handler(com.bytedance.msdk.xj.kd.y.hf());
    private static final Runnable w = new Runnable() { // from class: com.bytedance.msdk.kd.d.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.xj.kd.w.xj("TMe", "--==--- upload event routine");
            com.bytedance.sdk.component.f.hf.xj.u("csj_mediation");
            d.hf();
        }
    };
    public com.bytedance.msdk.kd.hf.xj<xj> xj;

    static {
        sjDwNv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf() {
        Handler handler = hf;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(w, com.bytedance.msdk.core.hf.hf().x());
    }

    private static /* synthetic */ void sjDwNv() {
        char[] charArray = "!-/l%#/'l -;l1*'..l\b,+\u00000+&%'".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'B');
        }
        String str = new String(charArray);
        char[] charArray2 = "!.+,+6".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'B');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void hf(JSONObject jSONObject, int i, long j, int i2, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                if (optJSONObject != null) {
                    xj(optJSONObject, i, j, i2, jSONObject2 != null ? jSONObject2.optJSONObject("params") : null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.p
    public void xj(final List<com.bytedance.sdk.component.f.xj.hf> list, final com.bytedance.sdk.component.f.xj.tf tfVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        Iterator<com.bytedance.sdk.component.f.xj.hf> it = list.iterator();
        JSONObject jSONObject = null;
        int i = 0;
        while (true) {
            JSONObject jSONObject2 = jSONObject;
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.sdk.component.f.xj.hf next = it.next();
            jSONObject = next.c();
            byte kd = next.kd();
            byte u = next.u();
            if (kd == 2 && u == 3) {
                hf(jSONObject, list.size(), currentTimeMillis, i, jSONObject2);
                arrayList.add(new c(next.w(), jSONObject));
            } else {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.putOpt("not_v3", jSONObject);
                    jSONObject3.putOpt("batchId", Long.valueOf(currentTimeMillis));
                    jSONObject3.putOpt("batchIndex", Integer.valueOf(i));
                    ai.xj(jSONObject3);
                } catch (Throwable unused) {
                }
            }
            i++;
        }
        if (arrayList.size() > 0) {
            com.bytedance.msdk.xj.kd.y.c().execute(new Runnable() { // from class: com.bytedance.msdk.kd.d.1
                @Override // java.lang.Runnable
                public void run() {
                    kd xj = d.this.xj(arrayList);
                    if (tfVar == null || xj == null) {
                        return;
                    }
                    com.bytedance.sdk.component.f.hf.hf.w.hf hfVar = new com.bytedance.sdk.component.f.hf.hf.w.hf(xj.xj, xj.hf, xj.w, xj.u, "");
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new com.bytedance.sdk.component.f.hf.hf.w.xj(hfVar, list));
                    tfVar.xj(arrayList2);
                    if (xj.xj) {
                        d.hf();
                    }
                }
            });
        }
    }

    private void xj(JSONObject jSONObject, int i, long j, int i2, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("event_extra");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(optString);
                jSONObject3.putOpt("size", Integer.valueOf(i));
                jSONObject3.putOpt("batchId", Long.valueOf(j));
                jSONObject3.putOpt("batchIndex", Integer.valueOf(i2));
                jSONObject3.putOpt("preEventId", jSONObject2 != null ? jSONObject2.optString("event_id") : "-1");
                jSONObject.put("event_extra", jSONObject3.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public kd xj(List<xj> list) {
        try {
            if (this.xj == null) {
                this.xj = com.bytedance.msdk.core.hf.xj();
            }
        } catch (Exception unused) {
        }
        com.bytedance.msdk.kd.hf.xj<xj> xjVar = this.xj;
        if (xjVar == null) {
            return null;
        }
        return xjVar.xj(list);
    }
}
