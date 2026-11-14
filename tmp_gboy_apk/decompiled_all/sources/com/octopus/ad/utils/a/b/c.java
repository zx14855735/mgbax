package com.octopus.ad.utils.a.b;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12679a;
    private final KeyguardManager b;

    public c(Context context) {
        this.f12679a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f12679a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            return false;
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12679a == null || cVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            cVar.a(new com.octopus.ad.utils.a.e("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (invoke != null) {
                String obj = invoke.toString();
                com.octopus.ad.utils.a.f.a("OAID obtain success: " + obj);
                cVar.a(obj);
                return;
            }
            throw new com.octopus.ad.utils.a.e("OAID obtain failed");
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
        }
    }
}
