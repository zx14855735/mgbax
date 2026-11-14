package com.czhj.devicehelper.cnoaid.impl;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class t implements com.czhj.devicehelper.cnoaid.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10525a;
    private Class<?> b;
    private Object c;

    @SuppressLint({"PrivateApi"})
    public t(Context context) {
        this.f10525a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
        }
    }

    private String b() {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f10525a);
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.f10525a == null || cVar == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            cVar.a(new com.czhj.devicehelper.cnoaid.f("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String b = b();
            if (b == null || b.length() == 0) {
                throw new com.czhj.devicehelper.cnoaid.f("OAID query failed");
            }
            com.czhj.devicehelper.cnoaid.g.a("OAID query success: ".concat(b));
            cVar.a(b);
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
            cVar.a(e);
        }
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        return this.c != null;
    }
}
