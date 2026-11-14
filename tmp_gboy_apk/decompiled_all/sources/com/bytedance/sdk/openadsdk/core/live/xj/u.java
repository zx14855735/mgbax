package com.bytedance.sdk.openadsdk.core.live.xj;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface u {
    int b_(ws wsVar);

    String c();

    JSONObject f();

    int hf();

    int hf(Context context, ws wsVar, Map<String, Object> map);

    int kd();

    void u();

    void u(ws wsVar);

    long w();

    int xj(Context context, ws wsVar, Map<String, Object> map);

    int xj(com.bytedance.sdk.openadsdk.core.live.hf.hf hfVar, boolean z);

    int xj(ws wsVar, w wVar, String str);

    int xj(String str);

    void xj();

    void xj(com.bytedance.sdk.openadsdk.qt.u uVar);

    void xj(String str, ws wsVar, long j);

    void xj(String str, boolean z);

    void xj(Function<SparseArray<Object>, Object> function);

    boolean xj(ws wsVar);

    boolean xj(String str, int i);

    boolean y();
}
