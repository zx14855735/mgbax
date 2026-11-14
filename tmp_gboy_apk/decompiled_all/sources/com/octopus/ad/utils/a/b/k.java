package com.octopus.ad.utils.a.b;

import android.app.Application;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static com.octopus.ad.utils.a.d f12690a;

    public static com.octopus.ad.utils.a.d a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.octopus.ad.utils.a.d dVar = f12690a;
        if (dVar != null) {
            return dVar;
        }
        com.octopus.ad.utils.a.d b = b(context);
        f12690a = b;
        if (b != null && b.a()) {
            com.octopus.ad.utils.a.f.a("Manufacturer interface has been found: ".concat(f12690a.getClass().getName()));
            return f12690a;
        }
        com.octopus.ad.utils.a.d c = c(context);
        f12690a = c;
        return c;
    }

    private static com.octopus.ad.utils.a.d b(Context context) {
        if (com.octopus.ad.utils.a.g.k() || com.octopus.ad.utils.a.g.n()) {
            return new g(context);
        }
        if (com.octopus.ad.utils.a.g.j()) {
            return new h(context);
        }
        if (com.octopus.ad.utils.a.g.l()) {
            return new j(context);
        }
        if (com.octopus.ad.utils.a.g.e() || com.octopus.ad.utils.a.g.f() || com.octopus.ad.utils.a.g.g()) {
            return new p(context);
        }
        if (com.octopus.ad.utils.a.g.i()) {
            return new n(context);
        }
        if (com.octopus.ad.utils.a.g.d()) {
            return new o(context);
        }
        if (com.octopus.ad.utils.a.g.m()) {
            return new a(context);
        }
        if (com.octopus.ad.utils.a.g.a() || com.octopus.ad.utils.a.g.b()) {
            return new f(context);
        }
        if (com.octopus.ad.utils.a.g.c() || com.octopus.ad.utils.a.g.h()) {
            return new m(context);
        }
        if (com.octopus.ad.utils.a.g.a(context)) {
            return new b(context);
        }
        if (com.octopus.ad.utils.a.g.p()) {
            return new c(context);
        }
        if (com.octopus.ad.utils.a.g.o()) {
            return new e(context);
        }
        return null;
    }

    private static com.octopus.ad.utils.a.d c(Context context) {
        i iVar = new i(context);
        if (iVar.a()) {
            com.octopus.ad.utils.a.f.a("Mobile Security Alliance has been found: ".concat(i.class.getName()));
            return iVar;
        }
        d dVar = new d();
        com.octopus.ad.utils.a.f.a("OAID/GAID was not supported: ".concat(d.class.getName()));
        return dVar;
    }
}
