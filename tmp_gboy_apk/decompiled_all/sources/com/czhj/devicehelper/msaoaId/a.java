package com.czhj.devicehelper.msaoaId;

import android.content.Context;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC0217a f10534a;
    private static String b;
    private static String c;
    private static Class<?> d;
    private static Class<?> e;
    private static Class<?> f;
    private static Class<?> g;
    private static String h;
    private static final List<String> i = new LinkedList<String>() { // from class: com.czhj.devicehelper.msaoaId.a.1
        {
            add("00000000-0000-0000-0000-000000000000");
            add("00000000000000000000000000000000");
        }
    };
    private static final List<String> j = new LinkedList<String>() { // from class: com.czhj.devicehelper.msaoaId.a.2
        {
            add("msaoaidsec");
            add("nllvm1632808251147706677");
            add("nllvm1630571663641560568");
            add("nllvm1623827671");
        }
    };

    /* renamed from: com.czhj.devicehelper.msaoaId.a$a, reason: collision with other inner class name */
    public interface InterfaceC0217a {
        void a(String str);
    }

    public static class b implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                if (!"OnSupport".equalsIgnoreCase(method.getName())) {
                    return null;
                }
                Method declaredMethod = a.e.getDeclaredMethod("getOAID", new Class[0]);
                String unused = a.c = objArr.length == 1 ? (String) declaredMethod.invoke(objArr[0], new Object[0]) : (String) declaredMethod.invoke(objArr[1], new Object[0]);
                if (a.f10534a != null) {
                    a.f10534a.a(a.c);
                }
                SigmobLog.e("MdidSdkHelper oaid:" + a.c);
                return null;
            } catch (Throwable unused2) {
                if (a.f10534a == null) {
                    return null;
                }
                a.f10534a.a(a.c);
                return null;
            }
        }
    }

    static {
        e();
        HZeC();
    }

    private static /* synthetic */ void HZeC() {
        char[] charArray = "\u0093\u009f\u009dÞ\u0097\u0091\u009d\u0095Þ\u0092\u009f\u0089Þ\u0083\u0098\u0095\u009c\u009cÞº\u009e\u0099²\u0082\u0099\u0094\u0097\u0095".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 240);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0093\u009c\u0099\u009e\u0099\u0084".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 240);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0041 A[Catch: IOException -> 0x004f, LOOP:0: B:6:0x003b->B:8:0x0041, LOOP_END, TryCatch #1 {IOException -> 0x004f, blocks: (B:2:0x0000, B:5:0x002c, B:6:0x003b, B:8:0x0041, B:10:0x004a, B:4:0x0028), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String d(android.content.Context r2) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L4f
            r0.<init>()     // Catch: java.io.IOException -> L4f
            java.lang.String r1 = r2.getPackageName()     // Catch: java.io.IOException -> L4f
            r0.append(r1)     // Catch: java.io.IOException -> L4f
            java.lang.String r1 = ".cert.pem"
            r0.append(r1)     // Catch: java.io.IOException -> L4f
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L4f
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.io.IOException -> L4f
            java.lang.String r1 = com.czhj.devicehelper.msaoaId.a.h     // Catch: java.io.IOException -> L4f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.io.IOException -> L4f
            if (r1 != 0) goto L28
            java.lang.String r1 = com.czhj.devicehelper.msaoaId.a.h     // Catch: java.io.IOException -> L28
            java.io.InputStream r2 = r2.open(r1)     // Catch: java.io.IOException -> L28
            goto L2c
        L28:
            java.io.InputStream r2 = r2.open(r0)     // Catch: java.io.IOException -> L4f
        L2c:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.io.IOException -> L4f
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L4f
            r1.<init>(r2)     // Catch: java.io.IOException -> L4f
            r0.<init>(r1)     // Catch: java.io.IOException -> L4f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L4f
            r2.<init>()     // Catch: java.io.IOException -> L4f
        L3b:
            java.lang.String r1 = r0.readLine()     // Catch: java.io.IOException -> L4f
            if (r1 == 0) goto L4a
            r2.append(r1)     // Catch: java.io.IOException -> L4f
            r1 = 10
            r2.append(r1)     // Catch: java.io.IOException -> L4f
            goto L3b
        L4a:
            java.lang.String r2 = r2.toString()     // Catch: java.io.IOException -> L4f
            return r2
        L4f:
            java.lang.String r2 = "loadPemFromAssetFile failed"
            com.czhj.sdk.logger.SigmobLog.d(r2)
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.devicehelper.msaoaId.a.d(android.content.Context):java.lang.String");
    }

    private static void e() {
        Iterator<String> it = j.iterator();
        while (it.hasNext()) {
            try {
                System.loadLibrary(it.next());
                return;
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(Context context) {
        InterfaceC0217a interfaceC0217a;
        try {
            d();
            if (context != null && g != null && d != null && e != null) {
                if (TextUtils.isEmpty(c)) {
                    b(context);
                    return;
                }
                interfaceC0217a = f10534a;
                if (interfaceC0217a != null) {
                    interfaceC0217a.a(c);
                }
                return;
            }
            SigmobLog.e("OAID 读取类创建失败");
            interfaceC0217a = f10534a;
            if (interfaceC0217a == null) {
                return;
            }
            interfaceC0217a.a(c);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            InterfaceC0217a interfaceC0217a2 = f10534a;
            if (interfaceC0217a2 != null) {
                interfaceC0217a2.a(c);
            }
        }
    }

    private static void b(Context context) {
        InterfaceC0217a interfaceC0217a;
        try {
            c(context);
            try {
                Class<?> cls = f;
                if (cls != null && cls.getField("classLoader").get(f) == null) {
                    f.getDeclaredMethod("InitEntry", Context.class).invoke(f, context);
                }
            } catch (Exception unused) {
            }
            int intValue = ((Integer) g.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, d).invoke(null, context, Boolean.TRUE, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{d}, new b()))).intValue();
            SigmobLog.e("MdidSdkHelper ErrorCode : " + intValue);
            if (intValue == 1008614 || intValue == 1008610 || (interfaceC0217a = f10534a) == null) {
                return;
            }
            interfaceC0217a.a(c);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            InterfaceC0217a interfaceC0217a2 = f10534a;
            if (interfaceC0217a2 != null) {
                interfaceC0217a2.a(c);
            }
        }
    }

    private static void d() {
        try {
            g = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            try {
                try {
                    try {
                        d = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                        e = Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
                    } catch (Exception unused) {
                        d = Class.forName("com.bun.supplier.IIdentifierListener");
                        e = Class.forName("com.bun.supplier.IdSupplier");
                        f = Class.forName("com.bun.miitmdid.core.JLibrary");
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                d = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                e = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                f = Class.forName("com.bun.miitmdid.core.JLibrary");
            }
        } catch (ClassNotFoundException e2) {
            SigmobLog.e(e2.getMessage());
        }
    }

    public static void a(Context context, InterfaceC0217a interfaceC0217a) {
        f10534a = interfaceC0217a;
        a(context);
    }

    public static void b(String str) {
        h = str;
    }

    private static void c(Context context) {
        try {
            String d2 = !TextUtils.isEmpty(b) ? b : d(context);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            g.getDeclaredMethod("InitCert", Context.class, String.class).invoke(null, context, d2);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public static void a(String str) {
        b = str;
    }
}
