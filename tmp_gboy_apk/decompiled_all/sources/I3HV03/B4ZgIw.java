package I3HV03;

import ADYaiT.DUi7mC;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B4ZgIw {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final HSHyT0.AlLFFp f3832ARc23Z = HSHyT0.AlLFFp.A2egSU(HSHyT0.A2egSU.f3459AmA8tU, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final HSHyT0.AlLFFp f3833ASJ6gh = HSHyT0.AlLFFp.A2egSU(HSHyT0.AzWtSf.f3471AcNBzu, "com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final HSHyT0.AlLFFp f3834AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final HSHyT0.AlLFFp f3835AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final Set f3836AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final Hdahpu.AZOQYO f3837AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final ArrayDeque f3838AcNBzu;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HZUvgL.ADYaiT f3839A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final DisplayMetrics f3840A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HZUvgL.AaHO0E f3841A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ArrayList f3842ADYaiT;
    public final BJ7GGh AMqCpz = BJ7GGh.A2egSU();

    static {
        B25kr6 b25kr6 = B2KMhB.f3826A2egSU;
        Boolean bool = Boolean.FALSE;
        f3834AYUAbz = HSHyT0.AlLFFp.A2egSU(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        f3835AZOQYO = HSHyT0.AlLFFp.A2egSU(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        f3836AZkASS = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f3837AaHO0E = new Hdahpu.AZOQYO(7);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        f3838AcNBzu = new ArrayDeque(0);
        hnNHH();
    }

    public B4ZgIw(ArrayList arrayList, DisplayMetrics displayMetrics, HZUvgL.ADYaiT aDYaiT, HZUvgL.AaHO0E aaHO0E) {
        this.f3842ADYaiT = arrayList;
        ItGa5w.ARc23Z.A5SV6n(displayMetrics, "Argument must not be null");
        this.f3840A4TApA = displayMetrics;
        ItGa5w.ARc23Z.A5SV6n(aDYaiT, "Argument must not be null");
        this.f3839A2egSU = aDYaiT;
        ItGa5w.ARc23Z.A5SV6n(aaHO0E, "Argument must not be null");
        this.f3841A5SV6n = aaHO0E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap A5SV6n(ADYaiT.DUi7mC r8, android.graphics.BitmapFactory.Options r9, I3HV03.B3GDIM r10, HZUvgL.ADYaiT r11) {
        /*
            boolean r0 = r9.inJustDecodeBounds
            if (r0 != 0) goto L20
            r10.ADYaiT()
            int r0 = r8.f238AcNBzu
            switch(r0) {
                case 12: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L20
        Ld:
            java.lang.Object r0 = r8.f239AlLFFp
            NGepWW.A2egSU r0 = (NGepWW.A2egSU) r0
            java.lang.Object r0 = r0.f5658AlLFFp
            I3HV03.BPw6Q8 r0 = (I3HV03.BPw6Q8) r0
            monitor-enter(r0)
            byte[] r1 = r0.f3858AcNBzu     // Catch: java.lang.Throwable -> L1d
            int r1 = r1.length     // Catch: java.lang.Throwable -> L1d
            r0.f3860AmA8tU = r1     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)
            goto L20
        L1d:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            throw r8
        L20:
            int r0 = r9.outWidth
            int r1 = r9.outHeight
            java.lang.String r2 = r9.outMimeType
            java.util.concurrent.locks.Lock r3 = I3HV03.BmvVmW.f3867A4TApA
            r3.lock()
            android.graphics.Bitmap r8 = r8.AcNBzu(r9)     // Catch: java.lang.IllegalArgumentException -> L33 java.lang.Throwable -> L74
            r3.unlock()
            return r8
        L33:
            r3 = move-exception
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L74
            java.lang.String r5 = "Exception decoding bitmap, outWidth: "
            java.lang.String r6 = ", outHeight: "
            java.lang.String r7 = ", outMimeType: "
            java.lang.StringBuilder r0 = J3FDQU.A2egSU.B7CMnp(r0, r1, r5, r6, r7)     // Catch: java.lang.Throwable -> L74
            r0.append(r2)     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = ", inBitmap: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L74
            android.graphics.Bitmap r1 = r9.inBitmap     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = ADYaiT(r1)     // Catch: java.lang.Throwable -> L74
            r0.append(r1)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L74
            r4.<init>(r0, r3)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "Downsampler"
            r1 = 3
            android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L74
            android.graphics.Bitmap r0 = r9.inBitmap     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L73
            r11.A4TApA(r0)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L74
            r0 = 0
            r9.inBitmap = r0     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L74
            android.graphics.Bitmap r8 = A5SV6n(r8, r9, r10, r11)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L74
            java.util.concurrent.locks.Lock r9 = I3HV03.BmvVmW.f3867A4TApA
            r9.unlock()
            return r8
        L72:
            throw r4     // Catch: java.lang.Throwable -> L74
        L73:
            throw r4     // Catch: java.lang.Throwable -> L74
        L74:
            r8 = move-exception
            java.util.concurrent.locks.Lock r9 = I3HV03.BmvVmW.f3867A4TApA
            r9.unlock()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: I3HV03.B4ZgIw.A5SV6n(ADYaiT.DUi7mC, android.graphics.BitmapFactory$Options, I3HV03.B3GDIM, HZUvgL.ADYaiT):android.graphics.Bitmap");
    }

    public static String ADYaiT(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void AMqCpz(BitmapFactory.Options options) {
        ARc23Z(options);
        ArrayDeque arrayDeque = f3838AcNBzu;
        synchronized (arrayDeque) {
            arrayDeque.offer(options);
        }
    }

    public static void ARc23Z(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static /* synthetic */ void hnNHH() {
        char[] charArray = "\u008c\u0080\u0082Á\u0088\u008e\u0082\u008aÁ\u008d\u0080\u0096Á\u009c\u0087\u008a\u0083\u0083Á¥\u0081\u0086\u00ad\u009d\u0086\u008b\u0088\u008a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 239);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008c\u0083\u0086\u0081\u0086\u009b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 239);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final ARc23Z A2egSU(DUi7mC dUi7mC, int i, int i2, HSHyT0.AmA8tU amA8tU, B3GDIM b3gdim) {
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.f3841A5SV6n.ADYaiT(65536, byte[].class);
        synchronized (B4ZgIw.class) {
            ArrayDeque arrayDeque = f3838AcNBzu;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                ARc23Z(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        HSHyT0.A2egSU a2egSU = (HSHyT0.A2egSU) amA8tU.A5SV6n(f3832ARc23Z);
        HSHyT0.AzWtSf azWtSf = (HSHyT0.AzWtSf) amA8tU.A5SV6n(f3833ASJ6gh);
        B2KMhB b2KMhB = (B2KMhB) amA8tU.A5SV6n(B2KMhB.f3830ARc23Z);
        boolean booleanValue = ((Boolean) amA8tU.A5SV6n(f3834AYUAbz)).booleanValue();
        HSHyT0.AlLFFp alLFFp = f3835AZOQYO;
        try {
            return ARc23Z.A5SV6n(this.f3839A2egSU, A4TApA(dUi7mC, options2, b2KMhB, a2egSU, azWtSf, amA8tU.A5SV6n(alLFFp) != null && ((Boolean) amA8tU.A5SV6n(alLFFp)).booleanValue(), i, i2, booleanValue, b3gdim));
        } finally {
            AMqCpz(options2);
            this.f3841A5SV6n.AYUAbz(bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0464 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x036e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap A4TApA(ADYaiT.DUi7mC r33, android.graphics.BitmapFactory.Options r34, I3HV03.B2KMhB r35, HSHyT0.A2egSU r36, HSHyT0.AzWtSf r37, boolean r38, int r39, int r40, boolean r41, I3HV03.B3GDIM r42) {
        /*
            Method dump skipped, instructions count: 1202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I3HV03.B4ZgIw.A4TApA(ADYaiT.DUi7mC, android.graphics.BitmapFactory$Options, I3HV03.B2KMhB, HSHyT0.A2egSU, HSHyT0.AzWtSf, boolean, int, int, boolean, I3HV03.B3GDIM):android.graphics.Bitmap");
    }
}
