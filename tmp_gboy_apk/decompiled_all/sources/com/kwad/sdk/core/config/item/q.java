package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class q extends b<String> {
    private static volatile String[] aHc;

    public q(String str, String str2) {
        super(str, str2);
        aHc = null;
    }

    public static boolean ah(long j) {
        if (aHc == null) {
            return false;
        }
        for (String str : aHc) {
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    private static void dO(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        aHc = str.split(",");
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), Io());
        setValue(string);
        dO(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        if (jSONObject == null) {
            setValue(Io());
            return;
        }
        String optString = jSONObject.optString(getKey(), Io());
        setValue(optString);
        dO(optString);
    }
}
