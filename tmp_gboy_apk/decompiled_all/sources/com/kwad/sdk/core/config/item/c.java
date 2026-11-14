package com.kwad.sdk.core.config.item;

import android.content.Context;
import android.content.SharedPreferences;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c extends b<Integer> {
    public c() {
        super("batchReportCacheType", 2);
    }

    public static int bC(Context context) {
        SharedPreferences sharedPreferences;
        try {
            com.kwad.sdk.core.d.c.d("batchReportCacheType", "loadBatchReportCacheType");
            if (context != null && (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) != null) {
                return sharedPreferences.getInt("batchReportCacheType", 2);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return 2;
    }

    private static void i(Context context, int i) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.d.c.d("batchReportCacheType", "saveBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("batchReportCacheType", i);
        edit.apply();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(bC(ServiceProvider.Re())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        i(ServiceProvider.Re(), getValue().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Integer.valueOf(jSONObject.optInt(getKey(), Io().intValue())));
        } else {
            setValue(Io());
        }
    }
}
