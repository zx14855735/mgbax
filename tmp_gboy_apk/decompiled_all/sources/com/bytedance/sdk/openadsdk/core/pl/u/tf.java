package com.bytedance.sdk.openadsdk.core.pl.u;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.sdk.component.d.hf.w] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.d.hf.u] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.sdk.component.d.hf.kd] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void xj(int i, String str, Map<String, Object> map, kd kdVar) {
        ?? w;
        if (i == 0) {
            w = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    w.xj(entry.getKey(), entry.getValue().toString());
                }
            }
        } else if (i != 1) {
            w = 0;
        } else {
            w = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue().toString());
            }
            w.xj(hashMap);
        }
        if (w != 0) {
            w.xj(str);
            xj(w.xj(), kdVar);
        }
    }

    public static void xj(String str, byte[] bArr, String str2, int i, kd kdVar) {
        if (bArr == null) {
            if (kdVar != null) {
                kdVar.xj(new Exception("request data is null"));
            }
        } else {
            com.bytedance.sdk.component.d.hf.kd hf = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
            hf.xj(str);
            hf.xj(str2, bArr);
            xj(hf.xj(), kdVar);
        }
    }

    private static void xj(com.bytedance.sdk.component.d.hf hfVar, kd kdVar) {
        String valueOf;
        if (hfVar != null && hfVar.f()) {
            if (kdVar != null) {
                kdVar.xj(hfVar.u());
                return;
            }
            return;
        }
        boolean isEmpty = TextUtils.isEmpty((hfVar == null || hfVar.hf() == null) ? null : hfVar.hf());
        if (kdVar != null) {
            if (isEmpty) {
                valueOf = hfVar != null ? String.valueOf(hfVar.xj()) : "";
            } else {
                valueOf = hfVar.hf();
            }
            kdVar.xj(new Exception(valueOf));
        }
    }
}
