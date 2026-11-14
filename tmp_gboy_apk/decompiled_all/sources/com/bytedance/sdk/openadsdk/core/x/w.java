package com.bytedance.sdk.openadsdk.core.x;

import android.content.Context;
import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface w {
    void init(Context context, Function<SparseArray<Object>, Object> function);

    boolean isPitayaEnvAvailable();

    boolean isPitayaInitSuccess();

    void queryPackage(String str, Function<SparseArray<Object>, Object> function);

    void runTask(String str, JSONObject jSONObject, Function<SparseArray<Object>, Object> function);
}
