package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.JavaBackTraceElement;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class gs implements com.kwad.sdk.core.d<JavaBackTraceElement> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        a2(javaBackTraceElement, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        return b2(javaBackTraceElement, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        javaBackTraceElement.mDeclaringClass = jSONObject.optString("mDeclaringClass");
        if (JSONObject.NULL.toString().equals(javaBackTraceElement.mDeclaringClass)) {
            javaBackTraceElement.mDeclaringClass = "";
        }
        javaBackTraceElement.mIsTitle = jSONObject.optBoolean("mIsTitle");
        javaBackTraceElement.mIsCausedBy = jSONObject.optBoolean("mIsCausedBy");
        javaBackTraceElement.mIsNative = jSONObject.optBoolean("mIsNative");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = javaBackTraceElement.mDeclaringClass;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDeclaringClass", javaBackTraceElement.mDeclaringClass);
        }
        boolean z = javaBackTraceElement.mIsTitle;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsTitle", z);
        }
        boolean z2 = javaBackTraceElement.mIsCausedBy;
        if (z2) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsCausedBy", z2);
        }
        boolean z3 = javaBackTraceElement.mIsNative;
        if (z3) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsNative", z3);
        }
        return jSONObject;
    }
}
