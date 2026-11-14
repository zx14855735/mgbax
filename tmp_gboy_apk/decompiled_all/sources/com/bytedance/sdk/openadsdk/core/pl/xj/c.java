package com.bytedance.sdk.openadsdk.core.pl.xj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    private static void callback(com.bytedance.sdk.component.d.hf hfVar, ITTHttpCallback iTTHttpCallback) {
        if (hfVar != null && hfVar.f()) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onResponse(hfVar.u());
            }
        } else {
            boolean isEmpty = TextUtils.isEmpty((hfVar == null || hfVar.hf() == null) ? null : hfVar.hf());
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onError(new Exception(!isEmpty ? hfVar.hf() : hfVar != null ? String.valueOf(hfVar.xj()) : ""));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.sdk.component.d.hf.w] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.d.hf.u] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.sdk.component.d.hf.kd] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void execute(int i, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
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
            callback(w.xj(), iTTHttpCallback);
        }
    }

    public static void postBody(String str, byte[] bArr, String str2, int i, ITTHttpCallback iTTHttpCallback) {
        if (bArr == null) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onError(new Exception("request data is null"));
            }
        } else {
            com.bytedance.sdk.component.d.hf.kd hf = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
            hf.xj(str);
            hf.xj(str2, bArr);
            callback(hf.xj(), iTTHttpCallback);
        }
    }
}
