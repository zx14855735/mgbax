package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.BackTraceElement;
import com.kwad.sdk.crash.message.Backtrace;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bw implements com.kwad.sdk.core.d<Backtrace> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(Backtrace backtrace, JSONObject jSONObject) {
        a2(backtrace, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(Backtrace backtrace, JSONObject jSONObject) {
        return b2(backtrace, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Backtrace backtrace, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        backtrace.mBacktraces = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("mBacktraces");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                BackTraceElement backTraceElement = new BackTraceElement();
                backTraceElement.parseJson(optJSONArray.optJSONObject(i));
                backtrace.mBacktraces.add(backTraceElement);
            }
        }
        backtrace.mFrame = jSONObject.optInt("mFrame");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(Backtrace backtrace, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mBacktraces", backtrace.mBacktraces);
        int i = backtrace.mFrame;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mFrame", i);
        }
        return jSONObject;
    }
}
