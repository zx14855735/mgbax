package com.czhj.devicehelper.cnoaid.impl;

import android.app.Application;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static com.czhj.devicehelper.cnoaid.d f10514a;

    private m() {
    }

    public static com.czhj.devicehelper.cnoaid.d a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.czhj.devicehelper.cnoaid.d dVar = f10514a;
        if (dVar != null) {
            return dVar;
        }
        com.czhj.devicehelper.cnoaid.d b = b(context);
        f10514a = b;
        if (b != null && b.a()) {
            com.czhj.devicehelper.cnoaid.g.a("Manufacturer interface has been found: ".concat(f10514a.getClass().getName()));
            return f10514a;
        }
        com.czhj.devicehelper.cnoaid.d c = c(context);
        f10514a = c;
        return c;
    }

    private static com.czhj.devicehelper.cnoaid.d b(Context context) {
        if (com.czhj.devicehelper.cnoaid.h.l() || com.czhj.devicehelper.cnoaid.h.p()) {
            return new i(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.k()) {
            return new j(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.m()) {
            return new l(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.f() || com.czhj.devicehelper.cnoaid.h.g() || com.czhj.devicehelper.cnoaid.h.h()) {
            return new t(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.j()) {
            return new r(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.e()) {
            return new s(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.n()) {
            return new a(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.c() && !com.czhj.devicehelper.cnoaid.h.b()) {
            g gVar = new g(context);
            if (gVar.a()) {
                return gVar;
            }
        }
        if (com.czhj.devicehelper.cnoaid.h.a() || com.czhj.devicehelper.cnoaid.h.b()) {
            return new h(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.d() || com.czhj.devicehelper.cnoaid.h.i()) {
            p pVar = new p(context);
            return pVar.a() ? pVar : new o(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.a(context)) {
            return new b(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.r()) {
            return new c(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.q()) {
            return new e(context);
        }
        if (com.czhj.devicehelper.cnoaid.h.t()) {
            return new q(context);
        }
        return null;
    }

    private static com.czhj.devicehelper.cnoaid.d c(Context context) {
        String name;
        String str;
        com.czhj.devicehelper.cnoaid.d kVar = new k(context);
        if (kVar.a()) {
            name = k.class.getName();
            str = "Mobile Security Alliance has been found: ";
        } else {
            kVar = new f(context);
            if (!kVar.a()) {
                d dVar = new d();
                com.czhj.devicehelper.cnoaid.g.a("OAID/AAID was not supported: ".concat(d.class.getName()));
                return dVar;
            }
            name = f.class.getName();
            str = "Google Play Service has been found: ";
        }
        com.czhj.devicehelper.cnoaid.g.a(str.concat(name));
        return kVar;
    }
}
