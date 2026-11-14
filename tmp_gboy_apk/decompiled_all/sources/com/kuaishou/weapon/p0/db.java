package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class db {
    private static volatile db b;

    /* renamed from: a, reason: collision with root package name */
    private Context f12267a;

    private db(Context context) {
        this.f12267a = context;
    }

    public static db a(Context context) {
        if (b == null) {
            synchronized (db.class) {
                try {
                    if (b == null) {
                        b = new db(context);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(final int i, final int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                try {
                    h a2 = h.a(db.this.f12267a, "re_po_rt");
                    if (a2.b(df.P, 1) == 1) {
                        long a3 = df.a(db.this.f12267a).a(df.bj);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = a2.b(df.R, 1) * bi.s;
                        long b3 = a2.b(df.S, 5) * 60000;
                        int b4 = a2.b(df.T, 0);
                        if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * bi.s && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        long j = currentTimeMillis - a3;
                        if (j >= b2 || (((i3 = i) == 100 && b4 == 1) || i3 == 106 || (i3 != 100 && i3 > 0 && j >= b3))) {
                            cp.a(db.this.f12267a, new cl(db.this.f12267a, i, i2).a(ck.c), ck.c, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
