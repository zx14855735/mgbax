package com.octopus.ad.utils.a;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.octopus.ad.Octopus;
import com.octopus.ad.internal.utilities.SPUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f12674a = false;
    private static volatile String b = null;
    private static volatile String c = null;
    private static volatile String d = null;
    private static volatile String e = null;
    private static volatile String f = "";
    private static volatile String g = null;
    private static volatile String h = null;
    private static volatile String i = null;
    private static volatile String j = null;
    private static boolean k = true;
    private static boolean l = true;
    private static boolean m = true;

    private b() {
    }

    public static String c(Context context) {
        e = SPUtils.getString(context, "hoaid");
        if (TextUtils.isEmpty(e) && m) {
            m = false;
            synchronized (b.class) {
                try {
                    if (TextUtils.isEmpty(e)) {
                        e = a.a();
                        if (TextUtils.isEmpty(e)) {
                            a.a(context, new c() { // from class: com.octopus.ad.utils.a.b.2
                                @Override // com.octopus.ad.utils.a.c
                                public void a(Exception exc) {
                                }

                                @Override // com.octopus.ad.utils.a.c
                                public void a(String str) {
                                    String unused = b.e = str;
                                }
                            });
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(e)) {
                SPUtils.put(context, "hoaid", e);
            }
        }
        if (e == null) {
            e = "";
        }
        f.b("Hoaid is: " + e);
        return e;
    }

    public static String d(Context context) {
        j = SPUtils.getString(context, "gaid");
        if (TextUtils.isEmpty(j)) {
            if (j == null) {
                j = "";
            } else {
                SPUtils.put(context, "gaid", j);
            }
        }
        f.b("Gaid is: " + j);
        return j;
    }

    public static String e(Context context) {
        if (k) {
            k = false;
            if (Octopus.getCustomController() == null || Octopus.getCustomController().isCanUsePhoneState()) {
                synchronized (b.class) {
                    f = a.b(context);
                }
            }
        }
        return f;
    }

    public static void a(Application application) {
        if (f12674a) {
            return;
        }
        synchronized (b.class) {
            try {
                if (!f12674a) {
                    a.a(application);
                    f12674a = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String b(Context context) {
        d = SPUtils.getString(context, "newOaid");
        if (TextUtils.isEmpty(d) && l) {
            l = false;
            synchronized (b.class) {
                try {
                    if (TextUtils.isEmpty(d)) {
                        com.octopus.ad.b.e.a(context, new com.octopus.ad.b.d() { // from class: com.octopus.ad.utils.a.b.1
                            @Override // com.octopus.ad.b.d
                            public void a(String str) {
                                String unused = b.d = str;
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(d)) {
                SPUtils.put(context, "newOaid", d);
            }
        }
        if (d == null) {
            d = "";
        }
        f.b("Oaid is: " + d);
        return d;
    }

    public static String a(Context context) {
        if (Octopus.getCustomController() != null && !Octopus.getCustomController().isCanUsePhoneState()) {
            c = Octopus.getCustomController().getImei();
        } else if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = a.a(context);
                    }
                } finally {
                }
            }
        }
        if (c == null) {
            c = "";
        }
        return c;
    }
}
