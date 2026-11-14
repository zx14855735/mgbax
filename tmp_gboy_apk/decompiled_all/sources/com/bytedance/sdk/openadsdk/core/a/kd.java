package com.bytedance.sdk.openadsdk.core.a;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {

    public static class xj implements Comparable<xj> {
        private String hf;
        private long xj;

        public xj(String str, long j) {
            this.hf = str;
            this.xj = j;
        }

        @Override // java.lang.Comparable
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compareTo(xj xjVar) {
            if (xjVar == null) {
                return 1;
            }
            long j = this.xj;
            long j2 = xjVar.xj;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }
    }

    private static void delete(int i, int i2, com.bytedance.sdk.component.u.hf.w wVar, int i3) {
        if (wVar == null) {
            return;
        }
        try {
            Map all = wVar.getAll();
            if (all != null && all.size() != 0) {
                int size = all.size();
                if (xj(i)) {
                    if (size > 1) {
                        wVar.clear();
                        return;
                    }
                    return;
                }
                if (i3 >= i2) {
                    wVar.clear();
                    return;
                }
                int i4 = size + i3;
                if (i4 > i2) {
                    PriorityQueue priorityQueue = new PriorityQueue();
                    for (Map.Entry entry : all.entrySet()) {
                        String str = (String) entry.getValue();
                        JSONObject jSONObject = (str == null || !str.contains("pre_fetch_time")) ? str != null ? new JSONObject(com.bytedance.sdk.component.utils.xj.w(str)) : null : new JSONObject(str);
                        if (jSONObject != null) {
                            priorityQueue.add(new xj((String) entry.getKey(), jSONObject.optLong("pre_fetch_time")));
                        }
                    }
                    int size2 = priorityQueue.size();
                    int i5 = i4 - i2;
                    if (size2 == 0 || size2 < i5) {
                        wVar.clear();
                        return;
                    }
                    for (int i6 = 0; i6 < i5; i6++) {
                        xj xjVar = (xj) priorityQueue.poll();
                        if (xjVar != null) {
                            wVar.remove(xjVar.hf);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean xj(int i) {
        return i == 3 || i == 7 || i == 8;
    }

    public static void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, int i, int i2) {
        if (xjVar == null || xjVar.hf() == null || i2 <= 0) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.ra.ws> hf = xjVar.hf();
        int size = hf.size();
        try {
            com.bytedance.sdk.component.u.hf.w xj2 = j.xj(i + "_prefetch");
            delete(i, i2, xj2, size);
            for (com.bytedance.sdk.openadsdk.core.ra.ws wsVar : hf) {
                String en = wsVar.en();
                String hf2 = com.bytedance.sdk.component.utils.xj.hf(wsVar.ac().toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pre_fetch_time", System.currentTimeMillis());
                jSONObject.put("message", hf2);
                xj2.put(en, jSONObject.toString());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public static com.bytedance.sdk.openadsdk.core.ra.ws xj(String str, int i) {
        if (com.bytedance.sdk.openadsdk.core.pz.hf().z() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.u.hf.w xj2 = j.xj(i + "_prefetch");
        String str2 = xj2.get(str, (String) null);
        if (!TextUtils.isEmpty(str2)) {
            try {
                if (str2.contains("pre_fetch_time")) {
                    str2 = new JSONObject(str2).optString("message");
                }
                com.bytedance.sdk.openadsdk.core.ra.ws xj3 = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(com.bytedance.sdk.component.utils.xj.w(str2)));
                xj2.remove(str);
                return xj3;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
