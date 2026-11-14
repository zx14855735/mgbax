package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class cz {
    private static volatile cz b;

    /* renamed from: a, reason: collision with root package name */
    private Context f12260a;

    private cz(Context context) {
        this.f12260a = context;
    }

    public static cz a(Context context) {
        if (b == null) {
            synchronized (cz.class) {
                try {
                    if (b == null) {
                        b = new cz(context);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(cz.this.f12260a, "re_po_rt").b(df.G, 1) == 1) {
                        long a2 = df.a(cz.this.f12260a).a(df.bm);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = r0.b(df.I, 12) * bi.s;
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
                            cp.a(cz.this.f12260a, new cj(cz.this.f12260a).a(ck.g), ck.g, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
