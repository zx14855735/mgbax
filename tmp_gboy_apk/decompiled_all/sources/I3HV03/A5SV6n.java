package I3HV03;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A5SV6n implements HSHyT0.B2KMhB {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final HSHyT0.AlLFFp f3810AlLFFp = HSHyT0.AlLFFp.A2egSU(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final HSHyT0.AlLFFp f3811AmA8tU = new HSHyT0.AlLFFp("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, HSHyT0.AlLFFp.AMqCpz);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final HZUvgL.AaHO0E f3812AcNBzu;

    static {
        LCcoq();
    }

    public A5SV6n(HZUvgL.AaHO0E aaHO0E) {
        this.f3812AcNBzu = aaHO0E;
    }

    private static /* synthetic */ void LCcoq() {
        char[] charArray = "¼°²ñ¸¾²ºñ½°¦ñ¬·º³³ñ\u0095±¶\u009d\u00ad¶»¸º".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 223);
        }
        String str = new String(charArray);
        char[] charArray2 = "¼³¶±¶«".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 223);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSHyT0.B2KMhB
    public final int A4TApA(HSHyT0.AmA8tU amA8tU) {
        return 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    @Override // HSHyT0.A4TApA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean ASJ6gh(java.lang.Object r7, java.io.File r8, HSHyT0.AmA8tU r9) {
        /*
            r6 = this;
            HXc4pW.BTvldC r7 = (HXc4pW.BTvldC) r7
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r7 = r7.get()
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
            HSHyT0.AlLFFp r1 = I3HV03.A5SV6n.f3811AmA8tU
            java.lang.Object r2 = r9.A5SV6n(r1)
            android.graphics.Bitmap$CompressFormat r2 = (android.graphics.Bitmap.CompressFormat) r2
            if (r2 == 0) goto L15
            goto L20
        L15:
            boolean r2 = r7.hasAlpha()
            if (r2 == 0) goto L1e
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG
            goto L20
        L1e:
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG
        L20:
            r7.getWidth()
            r7.getHeight()
            int r3 = ItGa5w.ASJ6gh.f4081A2egSU
            android.os.SystemClock.elapsedRealtimeNanos()
            HSHyT0.AlLFFp r3 = I3HV03.A5SV6n.f3810AlLFFp
            java.lang.Object r3 = r9.A5SV6n(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = 0
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            HZUvgL.AaHO0E r8 = r6.f3812AcNBzu
            if (r8 == 0) goto L4d
            com.bumptech.glide.load.data.A5SV6n r4 = new com.bumptech.glide.load.data.A5SV6n     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L4b
            r4.<init>(r5, r8)     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L4b
            goto L4e
        L47:
            r4 = r5
            goto L83
        L49:
            r4 = r5
            goto L5e
        L4b:
            r7 = move-exception
            goto L47
        L4d:
            r4 = r5
        L4e:
            r7.compress(r2, r3, r4)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r4.close()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r4.close()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5a
            goto L5a
        L58:
            r7 = move-exception
            goto L89
        L5a:
            r8 = 1
            goto L68
        L5c:
            r7 = move-exception
            goto L83
        L5e:
            r8 = 3
            android.util.Log.isLoggable(r0, r8)     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L67
            r4.close()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L67
        L67:
            r8 = 0
        L68:
            r3 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r3)
            if (r0 == 0) goto L82
            java.util.Objects.toString(r2)
            ItGa5w.AlLFFp.A5SV6n(r7)
            android.os.SystemClock.elapsedRealtimeNanos()
            java.lang.Object r9 = r9.A5SV6n(r1)
            java.util.Objects.toString(r9)
            r7.hasAlpha()
        L82:
            return r8
        L83:
            if (r4 == 0) goto L8a
            r4.close()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L8a
            goto L8a
        L89:
            throw r7
        L8a:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: I3HV03.A5SV6n.ASJ6gh(java.lang.Object, java.io.File, HSHyT0.AmA8tU):boolean");
    }

    @Deprecated
    public A5SV6n() {
        this.f3812AcNBzu = null;
    }
}
