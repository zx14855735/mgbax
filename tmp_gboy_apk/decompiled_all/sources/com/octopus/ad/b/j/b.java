package com.octopus.ad.b.j;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {
    private static int A = 0;
    private static int B = 0;
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    private static int F = 0;

    /* renamed from: a, reason: collision with root package name */
    private static Context f12380a = null;
    private static Object c = new Object();
    private static boolean d = false;
    private static int e = 13;
    private static c f;
    private static c g;
    private static c h;
    private static c i;
    private static HandlerThread j;
    private static Handler k;
    private static String l;
    private static String m;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static volatile b s;
    private static volatile a t;
    private static int u;
    private static int v;
    private static int w;
    private static int x;
    private static int y;
    private static int z;
    private final int b;

    static {
        uwfbi();
    }

    private b() {
        u();
        t = new a(f12380a);
        this.b = c(f12380a);
    }

    private void t() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() { // from class: com.octopus.ad.b.j.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.F + b.E + b.z + b.y + b.D + b.C + b.x + b.w + b.D + b.A + b.v + b.u > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("oaid", b.this.a(b.u, b.v, b.A, b.B));
                    contentValues.put("vaid", b.this.a(b.w, b.x, b.C, b.D));
                    contentValues.put("aaid", b.this.a(b.y, b.z, b.E, b.F));
                    b.t.a(7, "vivo", new ContentValues[]{contentValues});
                    int unused = b.u = b.v = b.w = b.x = b.y = b.z = 0;
                    int unused2 = b.A = b.B = b.C = b.D = b.E = b.F = 0;
                }
            }
        }, 600L, 600L, TimeUnit.SECONDS);
    }

    private static void u() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        j = handlerThread;
        handlerThread.start();
        k = new Handler(j.getLooper()) { // from class: com.octopus.ad.b.j.b.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 11) {
                    int i2 = message.getData().getInt(PointParamKey.TYPE);
                    try {
                        String a2 = b.t.a(i2, message.getData().getString("appid"));
                        if (i2 == 0) {
                            String unused = b.l = a2;
                            b.a(8, b.l);
                        } else if (i2 == 1) {
                            if (a2 != null) {
                                String unused2 = b.m = a2;
                            }
                            b.a(9, b.m);
                        } else if (i2 == 2) {
                            if (a2 != null) {
                                String unused3 = b.n = a2;
                            }
                            b.a(10, b.n);
                        } else if (i2 != 3) {
                            if (i2 == 4) {
                                String unused4 = b.p = a2;
                            } else if (i2 == 5 && a2 != null) {
                                String unused5 = b.q = a2;
                            }
                        } else if (a2 != null) {
                            String unused6 = b.o = a2;
                        }
                    } catch (Exception e2) {
                        e2.toString();
                    }
                    synchronized (b.c) {
                        b.c.notify();
                    }
                }
            }
        };
    }

    private static /* synthetic */ void uwfbi() {
        char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 160);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 160);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void v() {
        d = "1".equals(a("persist.sys.identifierid.supported", Constants.FAIL)) || "1".equals(a("persist.sys.identifierid", Constants.FAIL));
    }

    public static b b(Context context) {
        if (a()) {
            return a(context);
        }
        return null;
    }

    public String a(int i2, int i3, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(i3);
        stringBuffer.append(";");
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i5);
        return stringBuffer.toString();
    }

    public static b a(Context context) {
        if (f12380a == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f12380a = context;
        }
        if (s == null) {
            synchronized (b.class) {
                try {
                    if (s == null) {
                        s = new b();
                        s.t();
                    }
                } finally {
                }
            }
        }
        return s;
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.vivo.vms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public String b() {
        String str = l;
        if (str != null) {
            a(0, str);
            return l;
        }
        c(0, null);
        if (f == null) {
            a(f12380a, 0, null);
        }
        a(0, l);
        return l;
    }

    private void c(int i2, String str) {
        synchronized (c) {
            b(i2, str);
            SystemClock.uptimeMillis();
            try {
                c.wait(2000L);
            } catch (InterruptedException unused) {
            }
            SystemClock.uptimeMillis();
        }
    }

    public void b(int i2, String str) {
        Message obtainMessage = k.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt(PointParamKey.TYPE, i2);
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        k.sendMessage(obtainMessage);
    }

    public static boolean a() {
        if (!d) {
            v();
        }
        return d;
    }

    public static void a(int i2, String str) {
        if (i2 == 0) {
            if (str == null) {
                v++;
                return;
            } else {
                u++;
                return;
            }
        }
        if (i2 == 1) {
            if (str == null) {
                x++;
                return;
            } else {
                w++;
                return;
            }
        }
        if (i2 == 2) {
            if (str == null) {
                z++;
                return;
            } else {
                y++;
                return;
            }
        }
        switch (i2) {
            case 8:
                if (str == null) {
                    B++;
                    break;
                } else {
                    A++;
                    break;
                }
            case 9:
                if (str == null) {
                    D++;
                    break;
                } else {
                    C++;
                    break;
                }
            case 10:
                if (str == null) {
                    F++;
                    break;
                } else {
                    E++;
                    break;
                }
        }
    }

    private static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, Constants.FAIL);
            } catch (Exception e2) {
                e2.getMessage();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static synchronized void a(Context context, int i2, String str) {
        synchronized (b.class) {
            if (i2 == 0) {
                if (f == null) {
                    f = new c(s, 0, null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f);
                    return;
                }
                return;
            }
            if (i2 == 1) {
                if (g == null) {
                    g = new c(s, 1, str);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, g);
                    return;
                }
                return;
            }
            if (i2 != 2) {
                return;
            }
            if (h == null) {
                h = new c(s, 2, str);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, h);
            }
        }
    }
}
