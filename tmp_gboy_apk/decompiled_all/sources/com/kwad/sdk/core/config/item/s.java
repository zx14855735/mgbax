package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class s extends a<String> {
    public s(String str) {
        this(str, "");
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(b.getDecodeString(sharedPreferences.getString(getKey(), Io())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString(getKey(), b.dM(getValue()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        String optString = jSONObject != null ? jSONObject.optString(getKey(), Io()) : null;
        if (TextUtils.isEmpty(optString)) {
            setValue(Io());
        } else {
            setValue(optString);
        }
    }

    public s(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final String getValue() {
        return (String) super.getValue();
    }
}
