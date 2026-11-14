package com.czhj.devicehelper.cnoaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c implements com.czhj.devicehelper.cnoaid.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10493a;
    private final KeyguardManager b;

    public c(Context context) {
        this.f10493a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.f10493a == null || cVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            cVar.a(new com.czhj.devicehelper.cnoaid.f("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (invoke == null) {
                throw new com.czhj.devicehelper.cnoaid.f("OAID obtain failed");
            }
            String obj = invoke.toString();
            com.czhj.devicehelper.cnoaid.g.a("OAID obtain success: " + obj);
            cVar.a(obj);
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
        }
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f10493a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
            return false;
        }
    }
}
