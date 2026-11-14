package com.kwad.sdk.components;

import android.content.Context;
import com.kwad.sdk.app.AppPackageInfo;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface p extends b {
    JSONObject C(String str);

    Map<String, AppPackageInfo> P(Context context);

    void a(Context context, com.kwad.sdk.g.a<JSONArray> aVar);

    JSONArray[] b(Context context, List<String> list);

    JSONArray c(Map<String, AppPackageInfo> map);

    JSONObject e(Context context, String str);
}
