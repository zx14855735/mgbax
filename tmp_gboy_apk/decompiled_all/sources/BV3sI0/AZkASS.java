package BV3sI0;

import C4FrIb.AzWtSf;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends JrXYwF.A4TApA {

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final Class f1497AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final Constructor f1498AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final Method f1499AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final Method f1500AlLFFp;

    static {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f1498AaHO0E = constructor;
        f1497AZkASS = cls;
        f1499AcNBzu = method2;
        f1500AlLFFp = method;
    }

    public static boolean EY4UKY(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f1499AcNBzu.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface EdQ5bb(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f1497AZkASS, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1500AlLFFp.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069 A[SYNTHETIC] */
    @Override // JrXYwF.A4TApA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Typeface BI9f7h(android.content.Context r17, BTvldC.ASJ6gh r18, android.content.res.Resources r19, int r20) {
        /*
            r16 = this;
            r1 = 0
            r0 = 0
            java.lang.reflect.Constructor r2 = BV3sI0.AZkASS.f1498AaHO0E     // Catch: java.lang.Throwable -> Lb
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> Lb
            java.lang.Object r2 = r2.newInstance(r3)     // Catch: java.lang.Throwable -> Lb
            goto Ld
        Lb:
            r2 = r1
        Ld:
            if (r2 != 0) goto L10
            goto L69
        L10:
            r3 = r18
            BTvldC.AYUAbz[] r3 = r3.f1450A2egSU
            int r4 = r3.length
            r5 = 0
        L16:
            if (r5 >= r4) goto L72
            r6 = r3[r5]
            int r0 = r6.f1455ARc23Z
            java.io.File r7 = NOd7IU.AlLFFp.CTkVKb(r17)
            if (r7 != 0) goto L26
            r8 = r19
        L24:
            r0 = r1
            goto L5a
        L26:
            r8 = r19
            boolean r0 = NOd7IU.AlLFFp.BNL6CD(r7, r8, r0)     // Catch: java.lang.Throwable -> L6d
            if (r0 != 0) goto L32
            r7.delete()
            goto L24
        L32:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L6d
            r9.<init>(r7)     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L6d
            java.nio.channels.FileChannel r10 = r9.getChannel()     // Catch: java.lang.Throwable -> L4b
            long r14 = r10.size()     // Catch: java.lang.Throwable -> L4b
            java.nio.channels.FileChannel$MapMode r11 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L4b
            r12 = 0
            java.nio.MappedByteBuffer r0 = r10.map(r11, r12, r14)     // Catch: java.lang.Throwable -> L4b
            r9.close()     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L6d
            goto L57
        L4b:
            r0 = move-exception
            r10 = r0
            r9.close()     // Catch: java.lang.Throwable -> L51
            goto L55
        L51:
            r0 = move-exception
            r10.addSuppressed(r0)     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L6d
        L55:
            throw r10     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L6d
        L56:
            r0 = r1
        L57:
            r7.delete()
        L5a:
            if (r0 != 0) goto L5d
            goto L69
        L5d:
            int r7 = r6.f1452A4TApA
            boolean r9 = r6.f1453A5SV6n
            int r6 = r6.AMqCpz
            boolean r0 = EY4UKY(r2, r0, r6, r7, r9)
            if (r0 != 0) goto L6a
        L69:
            return r1
        L6a:
            int r5 = r5 + 1
            goto L16
        L6d:
            r0 = move-exception
            r7.delete()
            throw r0
        L72:
            android.graphics.Typeface r0 = EdQ5bb(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: BV3sI0.AZkASS.BI9f7h(android.content.Context, BTvldC.ASJ6gh, android.content.res.Resources, int):android.graphics.Typeface");
    }

    @Override // JrXYwF.A4TApA
    public final Typeface BIYEnU(Context context, AzWtSf[] azWtSfArr, int i) {
        Object obj;
        int i2 = 0;
        try {
            obj = f1498AaHO0E.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            B25kr6.AzWtSf azWtSf = new B25kr6.AzWtSf();
            int length = azWtSfArr.length;
            while (true) {
                if (i2 >= length) {
                    Typeface EdQ5bb = EdQ5bb(obj);
                    if (EdQ5bb != null) {
                        return Typeface.create(EdQ5bb, i);
                    }
                } else {
                    AzWtSf azWtSf2 = azWtSfArr[i2];
                    Uri uri = azWtSf2.f1576A2egSU;
                    ByteBuffer byteBuffer = (ByteBuffer) azWtSf.get(uri);
                    if (byteBuffer == null) {
                        byteBuffer = NOd7IU.AlLFFp.CmUvjW(context, uri);
                        azWtSf.put(uri, byteBuffer);
                    }
                    if (byteBuffer == null) {
                        break;
                    }
                    if (!EY4UKY(obj, byteBuffer, azWtSf2.f1577A4TApA, azWtSf2.f1578A5SV6n, azWtSf2.f1579ADYaiT)) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return null;
    }
}
