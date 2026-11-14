package IJPJ4E;

import HSHyT0.AmA8tU;
import HSHyT0.B25kr6;
import HZUvgL.AaHO0E;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements B25kr6 {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final Hdahpu.AZOQYO f3882ARc23Z = new Hdahpu.AZOQYO(12);

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final AZkASS.ARc23Z f3883ASJ6gh = new AZkASS.ARc23Z();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f3884A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f3885A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AZkASS.ARc23Z f3886A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Hdahpu.AZOQYO f3887ADYaiT;
    public final I3HV03.A4TApA AMqCpz;

    static {
        SfNITK();
    }

    public A2egSU(Context context, ArrayList arrayList, HZUvgL.ADYaiT aDYaiT, AaHO0E aaHO0E) {
        Hdahpu.AZOQYO azoqyo = f3882ARc23Z;
        this.f3884A2egSU = context.getApplicationContext();
        this.f3885A4TApA = arrayList;
        this.f3887ADYaiT = azoqyo;
        this.AMqCpz = new I3HV03.A4TApA(aDYaiT, 2, aaHO0E);
        this.f3886A5SV6n = f3883ASJ6gh;
    }

    private static /* synthetic */ void SfNITK() {
        char[] charArray = "=13p9?3;p<1'p-6;22p\u001407\u001c,7:9;".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '^');
        }
        String str = new String(charArray);
        char[] charArray2 = "=2707*".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '^');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x005b
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // HSHyT0.B25kr6
    public final HXc4pW.BTvldC A2egSU(java.lang.Object r8, int r9, int r10, HSHyT0.AmA8tU r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            AZkASS.ARc23Z r8 = r7.f3886A5SV6n
            monitor-enter(r8)
            java.lang.Object r0 = r8.f451AlLFFp     // Catch: java.lang.Throwable -> L56
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0     // Catch: java.lang.Throwable -> L56
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L56
            HPJABZ.A5SV6n r0 = (HPJABZ.A5SV6n) r0     // Catch: java.lang.Throwable -> L56
            if (r0 != 0) goto L17
            HPJABZ.A5SV6n r0 = new HPJABZ.A5SV6n     // Catch: java.lang.Throwable -> L19
            r0.<init>()     // Catch: java.lang.Throwable -> L19
        L17:
            r5 = r0
            goto L1d
        L19:
            r0 = move-exception
            r9 = r0
            r1 = r7
            goto L59
        L1d:
            r0 = 0
            r5.f3435A4TApA = r0     // Catch: java.lang.Throwable -> L56
            byte[] r0 = r5.f3434A2egSU     // Catch: java.lang.Throwable -> L56
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L56
            HPJABZ.A4TApA r0 = new HPJABZ.A4TApA     // Catch: java.lang.Throwable -> L56
            r0.<init>()     // Catch: java.lang.Throwable -> L56
            r5.f3436A5SV6n = r0     // Catch: java.lang.Throwable -> L56
            r5.f3437ADYaiT = r1     // Catch: java.lang.Throwable -> L56
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L56
            r5.f3435A4TApA = r0     // Catch: java.lang.Throwable -> L56
            r0.position(r1)     // Catch: java.lang.Throwable -> L56
            java.nio.ByteBuffer r0 = r5.f3435A4TApA     // Catch: java.lang.Throwable -> L56
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L56
            r0.order(r1)     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            I9dkCd.A4TApA r8 = r1.A5SV6n(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4e
            AZkASS.ARc23Z r9 = r1.f3886A5SV6n
            r9.BTvldC(r5)
            return r8
        L4e:
            r0 = move-exception
            r8 = r0
            AZkASS.ARc23Z r9 = r1.f3886A5SV6n
            r9.BTvldC(r5)
            throw r8
        L56:
            r0 = move-exception
            r1 = r7
        L58:
            r9 = r0
        L59:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L5b
            throw r9
        L5b:
            r0 = move-exception
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: IJPJ4E.A2egSU.A2egSU(java.lang.Object, int, int, HSHyT0.AmA8tU):HXc4pW.BTvldC");
    }

    @Override // HSHyT0.B25kr6
    public final boolean A4TApA(Object obj, AmA8tU amA8tU) {
        return !((Boolean) amA8tU.A5SV6n(AZOQYO.f3921A4TApA)).booleanValue() && HSHyT0.AZOQYO.getType(this.f3885A4TApA, (ByteBuffer) obj) == ImageHeaderParser$ImageType.GIF;
    }

    public final I9dkCd.A4TApA A5SV6n(ByteBuffer byteBuffer, int i, int i2, HPJABZ.A5SV6n a5SV6n, AmA8tU amA8tU) {
        int i3 = ItGa5w.ASJ6gh.f4081A2egSU;
        SystemClock.elapsedRealtimeNanos();
        try {
            HPJABZ.A4TApA A4TApA2 = a5SV6n.A4TApA();
            if (A4TApA2.f3426A5SV6n > 0 && A4TApA2.f3425A4TApA == 0) {
                Bitmap.Config config = amA8tU.A5SV6n(AZOQYO.f3920A2egSU) == HSHyT0.A2egSU.f3458AlLFFp ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int min = Math.min(A4TApA2.f3429ASJ6gh / i2, A4TApA2.f3428ARc23Z / i);
                int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
                Log.isLoggable("BufferGifDecoder", 2);
                Hdahpu.AZOQYO azoqyo = this.f3887ADYaiT;
                I3HV03.A4TApA a4TApA = this.AMqCpz;
                azoqyo.getClass();
                HPJABZ.ADYaiT aDYaiT = new HPJABZ.ADYaiT(a4TApA, A4TApA2, byteBuffer, max);
                aDYaiT.A5SV6n(config);
                aDYaiT.f3447AaHO0E = (aDYaiT.f3447AaHO0E + 1) % aDYaiT.f3448AcNBzu.f3426A5SV6n;
                Bitmap A4TApA3 = aDYaiT.A4TApA();
                if (A4TApA3 == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        SystemClock.elapsedRealtimeNanos();
                        return null;
                    }
                    return null;
                }
                I9dkCd.A4TApA a4TApA2 = new I9dkCd.A4TApA(new A4TApA(new DcUJf1.AMqCpz(1, new AYUAbz(com.bumptech.glide.A4TApA.A4TApA(this.f3884A2egSU), aDYaiT, i, i2, A4TApA3))), 1);
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    SystemClock.elapsedRealtimeNanos();
                }
                return a4TApA2;
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                SystemClock.elapsedRealtimeNanos();
            }
        }
    }
}
