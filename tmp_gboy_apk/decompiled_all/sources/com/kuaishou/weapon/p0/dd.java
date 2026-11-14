package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class dd {
    private static volatile dd b;

    /* renamed from: a, reason: collision with root package name */
    private Context f12271a;

    private dd(Context context) {
        this.f12271a = context;
    }

    public static dd a(Context context) {
        if (b == null) {
            synchronized (dd.class) {
                try {
                    if (b == null) {
                        b = new dd(context);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dd.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(dd.this.f12271a, "re_po_rt").b(df.aC, 1) == 1) {
                        long a2 = df.a(dd.this.f12271a).a();
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = r0.b(df.aE, 8) * bi.s;
                        if (a2 > 0 && currentTimeMillis - a2 < WeaponHI.ii * bi.s && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a2 >= b2 || i == 106) {
                            cp.a(dd.this.f12271a, new cn(dd.this.f12271a, i).a(ck.b), ck.b, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
