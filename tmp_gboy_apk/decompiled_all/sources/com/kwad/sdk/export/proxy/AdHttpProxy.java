package com.kwad.sdk.export.proxy;

import com.kwad.sdk.core.network.c;
import java.io.OutputStream;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface AdHttpProxy {
    c doGet(String str, Map<String, String> map);

    c doGetWithoutResponse(String str, Map<String, String> map, boolean z);

    c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder);

    c doPost(String str, Map<String, String> map, Map<String, String> map2);

    c doPost(String str, Map<String, String> map, JSONObject jSONObject);

    boolean downloadUrlToStream(String str, OutputStream outputStream, long j, boolean z, AdHttpResponseListener adHttpResponseListener);
}
