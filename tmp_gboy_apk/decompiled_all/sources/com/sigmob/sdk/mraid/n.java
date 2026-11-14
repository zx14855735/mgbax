package com.sigmob.sdk.mraid;

import android.content.Context;
import android.view.View;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    protected String f13481a;
    String b;

    public interface a {
        void a(Context context, JSONObject jSONObject);

        void a(JSONObject jSONObject);

        void b(JSONObject jSONObject);

        void c(JSONObject jSONObject);

        void d(JSONObject jSONObject);

        void e(JSONObject jSONObject);

        void f(JSONObject jSONObject);

        void g(JSONObject jSONObject);

        void h(JSONObject jSONObject);
    }

    public n(String str) {
        this.f13481a = str;
    }

    public abstract View a();

    public void a(String str) {
        this.b = str;
    }

    public abstract void b();

    public String c() {
        return this.b;
    }
}
