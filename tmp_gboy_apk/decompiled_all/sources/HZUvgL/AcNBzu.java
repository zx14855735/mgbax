package HZUvgL;

import ADYaiT.BmvVmW;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu implements ADYaiT {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final Bitmap.Config f3668ARc23Z = Bitmap.Config.ARGB_8888;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final B25kr6 f3669A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Set f3670A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final BmvVmW f3671A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final long f3672ADYaiT;
    public long AMqCpz;

    static {
        CpKS();
    }

    public AcNBzu(long j) {
        Bitmap.Config config;
        B25kr6 b25kr6 = new B25kr6();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f3672ADYaiT = j;
        this.f3669A2egSU = b25kr6;
        this.f3670A4TApA = unmodifiableSet;
        this.f3671A5SV6n = new BmvVmW(29);
    }

    private static /* synthetic */ void CpKS() {
        char[] charArray = "±½¿üµ³¿·ü°½«ü¡º·¾¾ü\u0098¼»\u0090 »¶µ·".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 210);
        }
        String str = new String(charArray);
        char[] charArray2 = "±¾»¼»¦".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 210);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HZUvgL.ADYaiT
    public final Bitmap A2egSU(int i, int i2, Bitmap.Config config) {
        Bitmap ARc23Z2 = ARc23Z(i, i2, config);
        if (ARc23Z2 != null) {
            return ARc23Z2;
        }
        if (config == null) {
            config = f3668ARc23Z;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // HZUvgL.ADYaiT
    public final synchronized void A4TApA(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f3669A2egSU.getClass();
                if (ItGa5w.AlLFFp.A5SV6n(bitmap) <= this.f3672ADYaiT && this.f3670A4TApA.contains(bitmap.getConfig())) {
                    this.f3669A2egSU.getClass();
                    int A5SV6n2 = ItGa5w.AlLFFp.A5SV6n(bitmap);
                    this.f3669A2egSU.AMqCpz(bitmap);
                    this.f3671A5SV6n.getClass();
                    this.AMqCpz += A5SV6n2;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        this.f3669A2egSU.getClass();
                        B25kr6.A5SV6n(ItGa5w.AlLFFp.A5SV6n(bitmap), bitmap.getConfig());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Objects.toString(this.f3669A2egSU);
                    }
                    ASJ6gh(this.f3672ADYaiT);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.f3669A2egSU.getClass();
                B25kr6.A5SV6n(ItGa5w.AlLFFp.A5SV6n(bitmap), bitmap.getConfig());
                bitmap.isMutable();
                this.f3670A4TApA.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // HZUvgL.ADYaiT
    public final Bitmap A5SV6n(int i, int i2, Bitmap.Config config) {
        Bitmap ARc23Z2 = ARc23Z(i, i2, config);
        if (ARc23Z2 != null) {
            ARc23Z2.eraseColor(0);
            return ARc23Z2;
        }
        if (config == null) {
            config = f3668ARc23Z;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // HZUvgL.ADYaiT
    public final void ADYaiT(int i) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i >= 40 || (Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            AMqCpz();
        } else if (i >= 20 || i == 15) {
            ASJ6gh(this.f3672ADYaiT / 2);
        }
    }

    @Override // HZUvgL.ADYaiT
    public final void AMqCpz() {
        Log.isLoggable("LruBitmapPool", 3);
        ASJ6gh(0L);
    }

    public final synchronized Bitmap ARc23Z(int i, int i2, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap A4TApA2;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                config2 = Bitmap.Config.HARDWARE;
                if (config == config2) {
                    throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
                }
            }
            A4TApA2 = this.f3669A2egSU.A4TApA(i, i2, config != null ? config : f3668ARc23Z);
            if (A4TApA2 != null) {
                long j = this.AMqCpz;
                this.f3669A2egSU.getClass();
                this.AMqCpz = j - ItGa5w.AlLFFp.A5SV6n(A4TApA2);
                this.f3671A5SV6n.getClass();
                A4TApA2.setHasAlpha(true);
                A4TApA2.setPremultiplied(true);
            } else if (Log.isLoggable("LruBitmapPool", 3)) {
                this.f3669A2egSU.getClass();
                B25kr6.A5SV6n(ItGa5w.AlLFFp.A4TApA(i, i2, config), config);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.f3669A2egSU.getClass();
                B25kr6.A5SV6n(ItGa5w.AlLFFp.A4TApA(i, i2, config), config);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Objects.toString(this.f3669A2egSU);
            }
        } catch (Throwable th) {
            throw th;
        }
        return A4TApA2;
    }

    public final synchronized void ASJ6gh(long j) {
        while (this.AMqCpz > j) {
            B25kr6 b25kr6 = this.f3669A2egSU;
            Bitmap bitmap = (Bitmap) b25kr6.f3682A4TApA.B4ZgIw();
            if (bitmap != null) {
                b25kr6.A2egSU(Integer.valueOf(ItGa5w.AlLFFp.A5SV6n(bitmap)), bitmap);
            }
            if (bitmap == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Objects.toString(this.f3669A2egSU);
                }
                this.AMqCpz = 0L;
                return;
            }
            this.f3671A5SV6n.getClass();
            long j2 = this.AMqCpz;
            this.f3669A2egSU.getClass();
            this.AMqCpz = j2 - ItGa5w.AlLFFp.A5SV6n(bitmap);
            if (Log.isLoggable("LruBitmapPool", 3)) {
                this.f3669A2egSU.getClass();
                B25kr6.A5SV6n(ItGa5w.AlLFFp.A5SV6n(bitmap), bitmap.getConfig());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Objects.toString(this.f3669A2egSU);
            }
            bitmap.recycle();
        }
    }
}
