package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ct {

    /* renamed from: a, reason: collision with root package name */
    private static int f12251a;
    private static boolean b;

    public ct() {
        b();
    }

    private int a(Method method) {
        try {
            int i = f12251a;
            if (i <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, i, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    private void b() {
        if (!Engine.loadSuccess || b) {
            return;
        }
        boolean b2 = cr.b();
        int i = Build.VERSION.SDK_INT;
        if (b2 && i < 29 && i > 22) {
            f12251a = Engine.off();
        }
        b = true;
    }

    private boolean c() {
        return b && f12251a > 1;
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(dh.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(int i, Class cls, String str, Object... objArr) {
        Method a2;
        try {
            if (!c() || (a2 = dh.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(a2, i);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a() {
        if (!c()) {
            return -1;
        }
        long a2 = cq.b.a();
        long a3 = cq.f12247a.a();
        if (f12251a == a2) {
            return (int) a3;
        }
        return -1;
    }
}
