package DXnQ0V;

import NOd7IU.AlLFFp;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static volatile A2egSU f2199ADYaiT;
    public static final Object AMqCpz = new Object();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Context f2202A5SV6n;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashSet f2201A4TApA = new HashSet();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f2200A2egSU = new HashMap();

    static {
        iduoEjl();
    }

    public A2egSU(Context context) {
        this.f2202A5SV6n = context.getApplicationContext();
    }

    public static A2egSU A5SV6n(Context context) {
        if (f2199ADYaiT == null) {
            synchronized (AMqCpz) {
                try {
                    if (f2199ADYaiT == null) {
                        f2199ADYaiT = new A2egSU(context);
                    }
                } finally {
                }
            }
        }
        return f2199ADYaiT;
    }

    private static /* synthetic */ void iduoEjl() {
        char[] charArray = "\u0007\u000b\tJ\u0003\u0005\t\u0001J\u0006\u000b\u001dJ\u0017\f\u0001\b\bJ.\n\r&\u0016\r\u0000\u0003\u0001".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'd');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0007\b\r\n\r\u0010".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'd');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(Bundle bundle) {
        HashSet hashSet;
        String string = this.f2202A5SV6n.getString(2131886123);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f2201A4TApA;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (A4TApA.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    A4TApA((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e) {
                throw new A5SV6n(e);
            }
        }
    }

    public final Object A4TApA(Class cls, HashSet hashSet) {
        Object obj;
        if (AlLFFp.CikNvS()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap hashMap = this.f2200A2egSU;
        if (hashMap.containsKey(cls)) {
            obj = hashMap.get(cls);
        } else {
            hashSet.add(cls);
            try {
                A4TApA a4TApA = (A4TApA) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class> A2egSU2 = a4TApA.A2egSU();
                if (!A2egSU2.isEmpty()) {
                    for (Class cls2 : A2egSU2) {
                        if (!hashMap.containsKey(cls2)) {
                            A4TApA(cls2, hashSet);
                        }
                    }
                }
                obj = a4TApA.A4TApA(this.f2202A5SV6n);
                hashSet.remove(cls);
                hashMap.put(cls, obj);
            } catch (Throwable th2) {
                throw new A5SV6n(th2);
            }
        }
        Trace.endSection();
        return obj;
    }
}
