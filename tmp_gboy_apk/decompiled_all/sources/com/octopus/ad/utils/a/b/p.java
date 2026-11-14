package com.octopus.ad.utils.a.b;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12697a;
    private Class<?> b;
    private Object c;

    @SuppressLint({"PrivateApi"})
    public p(Context context) {
        this.f12697a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
        }
    }

    private String b() {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f12697a);
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        return this.c != null;
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12697a == null || cVar == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            cVar.a(new com.octopus.ad.utils.a.e("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String b = b();
            if (b == null || b.length() == 0) {
                throw new com.octopus.ad.utils.a.e("OAID query failed");
            }
            com.octopus.ad.utils.a.f.a("OAID query success: ".concat(b));
            cVar.a(b);
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            cVar.a(e);
        }
    }
}
