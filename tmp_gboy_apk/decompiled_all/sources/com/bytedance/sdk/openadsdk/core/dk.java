package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.et;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface dk<T> {

    public interface hf {
        void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar);

        void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar);
    }

    public interface kd {
        void xj(int i, String str);

        void xj(et.u uVar);
    }

    public interface u {
        void xj(int i, String str);

        void xj(et.w wVar);
    }

    public interface w<T> {
        void xj(int i, String str);

        void xj(T t);
    }

    public interface xj {
        void xj(boolean z, long j, long j2);
    }

    void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, int i, hf hfVar2);

    void w(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, int i, hf hfVar2);

    com.bytedance.sdk.component.adexpress.xj.w.xj xj(int i);

    com.bytedance.sdk.openadsdk.core.ra.u xj(ws wsVar, String str);

    String xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar);

    String xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z, int i);

    void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar, List<com.bytedance.sdk.openadsdk.zg.w.hf.y> list);

    void xj(ne neVar, String str, String str2, w wVar, int i, long j);

    void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, int i, hf hfVar2);

    void xj(String str);

    void xj(String str, String str2, xj xjVar);

    void xj(Map<String, Object> map, Function<SparseArray<Object>, Object> function);

    void xj(Function<SparseArray<Object>, Object> function);

    void xj(JSONObject jSONObject, kd kdVar);

    void xj(JSONObject jSONObject, u uVar);

    void xj(JSONObject jSONObject, w<com.bytedance.sdk.component.d.hf> wVar);

    void xj(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.kd.hf.hf hfVar);
}
