package I3HV03;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BTvldC extends ASJ6gh {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final byte[] f3864A5SV6n = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(HSHyT0.AZkASS.f3465A2egSU);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f3865A4TApA = 10;

    static {
        kJvn();
    }

    private static /* synthetic */ void kJvn() {
        char[] charArray = "º¶´÷¾¸´¼÷»¶ ÷ª±¼µµ÷\u0093·°\u009b«°½¾¼".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 217);
        }
        String str = new String(charArray);
        char[] charArray2 = "ºµ°·°\u00ad".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 217);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        messageDigest.update(f3864A5SV6n);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f3865A4TApA).array());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    @Override // I3HV03.ASJ6gh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap A5SV6n(HZUvgL.ADYaiT r9, android.graphics.Bitmap r10, int r11, int r12) {
        /*
            r8 = this;
            android.graphics.Paint r11 = I3HV03.BmvVmW.f3866A2egSU
            int r11 = r8.f3865A4TApA
            r12 = 0
            r0 = 1
            if (r11 <= 0) goto La
            r1 = 1
            goto Lb
        La:
            r1 = 0
        Lb:
            java.lang.String r2 = "roundingRadius must be greater than 0."
            ItGa5w.ARc23Z.A2egSU(r1, r2)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L29
            android.graphics.Bitmap$Config r3 = ADYaiT.C4FrIb.BJ7GGh()
            android.graphics.Bitmap$Config r4 = r10.getConfig()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L29
            android.graphics.Bitmap$Config r3 = ADYaiT.C4FrIb.BJ7GGh()
            goto L2b
        L29:
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
        L2b:
            if (r1 < r2) goto L40
            android.graphics.Bitmap$Config r1 = ADYaiT.C4FrIb.BJ7GGh()
            android.graphics.Bitmap$Config r2 = r10.getConfig()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L40
            android.graphics.Bitmap$Config r1 = ADYaiT.C4FrIb.BJ7GGh()
            goto L42
        L40:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
        L42:
            android.graphics.Bitmap$Config r2 = r10.getConfig()
            boolean r2 = r1.equals(r2)
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L50
            r1 = r10
            goto L64
        L50:
            int r2 = r10.getWidth()
            int r6 = r10.getHeight()
            android.graphics.Bitmap r1 = r9.A5SV6n(r2, r6, r1)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r1)
            r2.drawBitmap(r10, r5, r5, r4)
        L64:
            int r2 = r1.getWidth()
            int r6 = r1.getHeight()
            android.graphics.Bitmap r2 = r9.A5SV6n(r2, r6, r3)
            r2.setHasAlpha(r0)
            android.graphics.BitmapShader r3 = new android.graphics.BitmapShader
            android.graphics.Shader$TileMode r6 = android.graphics.Shader.TileMode.CLAMP
            r3.<init>(r1, r6, r6)
            android.graphics.Paint r6 = new android.graphics.Paint
            r6.<init>()
            r6.setAntiAlias(r0)
            r6.setShader(r3)
            android.graphics.RectF r0 = new android.graphics.RectF
            int r3 = r2.getWidth()
            float r3 = (float) r3
            int r7 = r2.getHeight()
            float r7 = (float) r7
            r0.<init>(r5, r5, r3, r7)
            java.util.concurrent.locks.Lock r3 = I3HV03.BmvVmW.f3867A4TApA
            r3.lock()
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch: java.lang.Throwable -> Lb7
            r5.<init>(r2)     // Catch: java.lang.Throwable -> Lb7
            android.graphics.PorterDuff$Mode r7 = android.graphics.PorterDuff.Mode.CLEAR     // Catch: java.lang.Throwable -> Lb7
            r5.drawColor(r12, r7)     // Catch: java.lang.Throwable -> Lb7
            float r11 = (float) r11     // Catch: java.lang.Throwable -> Lb7
            r5.drawRoundRect(r0, r11, r11, r6)     // Catch: java.lang.Throwable -> Lb7
            r5.setBitmap(r4)     // Catch: java.lang.Throwable -> Lb7
            r3.unlock()
            boolean r10 = r1.equals(r10)
            if (r10 != 0) goto Lb6
            r9.A4TApA(r1)
        Lb6:
            return r2
        Lb7:
            r9 = move-exception
            r3.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: I3HV03.BTvldC.A5SV6n(HZUvgL.ADYaiT, android.graphics.Bitmap, int, int):android.graphics.Bitmap");
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        return (obj instanceof BTvldC) && this.f3865A4TApA == ((BTvldC) obj).f3865A4TApA;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        return ItGa5w.AlLFFp.ARc23Z(-569625254, ItGa5w.AlLFFp.ARc23Z(this.f3865A4TApA, 17));
    }
}
