package com.kuaishou.weapon.p0;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class de {
    private static volatile de b;

    /* renamed from: a, reason: collision with root package name */
    private Context f12273a;

    private de(Context context) {
        this.f12273a = context;
    }

    public static de a(Context context) {
        if (b == null) {
            synchronized (de.class) {
                try {
                    if (b == null) {
                        b = new de(context);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.de.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(de.this.f12273a, "re_po_rt").b(df.B, 0) == 1) {
                        long a2 = df.a(de.this.f12273a).a(df.bn);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a2 >= r1.b(df.E, 2) * bi.s || i == 106) {
                            try {
                                String a3 = new co(de.this.f12273a).a(ck.h);
                                int intValue = Integer.valueOf(ck.h).intValue();
                                if (a3 != null && a3.length() > 10) {
                                    new bc(de.this.f12273a, a3, intValue).a(com.sigmob.sdk.base.n.i);
                                }
                            } catch (Throwable unused) {
                            }
                            df.a(de.this.f12273a).a(df.bn, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
