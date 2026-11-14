package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class b<T> {
    private T aGU;
    private T aGV;
    private String mKey;

    public b(String str, T t) {
        this(str, t, t);
    }

    public static String dM(String str) {
        return !TextUtils.isEmpty(str) ? com.kwad.sdk.core.a.c.encodeKsSdk(str) : str;
    }

    public static String getDecodeString(String str) {
        return (TextUtils.isEmpty(str) || !com.kwad.sdk.core.a.c.isEncodeKsSdk(str)) ? str : com.kwad.sdk.core.a.c.decodeKsSdk(str);
    }

    public final T Io() {
        return this.aGU;
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public final String getKey() {
        return this.mKey;
    }

    public T getValue() {
        return this.aGV;
    }

    public abstract void l(JSONObject jSONObject);

    public void setValue(T t) {
        this.aGV = t;
    }

    private b(String str, T t, T t2) {
        this.mKey = str;
        this.aGV = t;
        this.aGU = t2;
        com.kwad.sdk.core.config.b.a(this);
    }
}
