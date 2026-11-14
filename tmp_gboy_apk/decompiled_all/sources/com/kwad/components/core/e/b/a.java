package com.kwad.components.core.e.b;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {

    /* renamed from: com.kwad.components.core.e.b.a$a, reason: collision with other inner class name */
    public static class C0288a {
        private static final c Pd = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long al(String str) {
        return ph().am(str);
    }

    private static c ph() {
        return C0288a.Pd;
    }

    public static String y(long j) {
        String z = ph().z(j);
        return z.endsWith("=") ? z.replace("=", "") : z;
    }
}
