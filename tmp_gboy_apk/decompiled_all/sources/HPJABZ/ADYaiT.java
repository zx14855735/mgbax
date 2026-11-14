package HPJABZ;

import HZUvgL.AaHO0E;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int[] f3438A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final I3HV03.A4TApA f3440A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ByteBuffer f3441ADYaiT;
    public byte[] AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public short[] f3442ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public byte[] f3443ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public byte[] f3444AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public byte[] f3445AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final int[] f3446AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f3447AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A4TApA f3448AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Bitmap f3449AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final boolean f3450AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f3451AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f3452B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final int f3453B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f3454B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public Boolean f3455B4ZgIw;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int[] f3439A4TApA = new int[256];

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Bitmap.Config f3456B7CMnp = Bitmap.Config.ARGB_8888;

    public ADYaiT(I3HV03.A4TApA a4TApA, A4TApA a4TApA2, ByteBuffer byteBuffer, int i) {
        this.f3440A5SV6n = a4TApA;
        this.f3448AcNBzu = new A4TApA();
        synchronized (this) {
            try {
                if (i <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
                int highestOneBit = Integer.highestOneBit(i);
                this.f3451AzWtSf = 0;
                this.f3448AcNBzu = a4TApA2;
                this.f3447AaHO0E = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f3441ADYaiT = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f3441ADYaiT.order(ByteOrder.LITTLE_ENDIAN);
                this.f3450AmA8tU = false;
                Iterator it = a4TApA2.AMqCpz.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((A2egSU) it.next()).f3419ASJ6gh == 3) {
                        this.f3450AmA8tU = true;
                        break;
                    }
                }
                this.f3452B25kr6 = highestOneBit;
                int i2 = a4TApA2.f3428ARc23Z;
                this.f3454B3GDIM = i2 / highestOneBit;
                int i3 = a4TApA2.f3429ASJ6gh;
                this.f3453B2KMhB = i3 / highestOneBit;
                int i4 = i2 * i3;
                AaHO0E aaHO0E = (AaHO0E) this.f3440A5SV6n.f3809AmA8tU;
                this.f3445AZOQYO = aaHO0E == null ? new byte[i4] : (byte[]) aaHO0E.ADYaiT(i4, byte[].class);
                I3HV03.A4TApA a4TApA3 = this.f3440A5SV6n;
                int i5 = this.f3454B3GDIM * this.f3453B2KMhB;
                AaHO0E aaHO0E2 = (AaHO0E) a4TApA3.f3809AmA8tU;
                this.f3446AZkASS = aaHO0E2 == null ? new int[i5] : (int[]) aaHO0E2.ADYaiT(i5, int[].class);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap A2egSU() {
        Boolean bool = this.f3455B4ZgIw;
        Bitmap A2egSU2 = ((HZUvgL.ADYaiT) this.f3440A5SV6n.f3808AlLFFp).A2egSU(this.f3454B3GDIM, this.f3453B2KMhB, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f3456B7CMnp);
        A2egSU2.setHasAlpha(true);
        return A2egSU2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0029, B:15:0x0030, B:17:0x003a, B:18:0x0045, B:19:0x003d, B:20:0x0047, B:22:0x0058, B:23:0x0064, B:26:0x006d, B:28:0x0071, B:32:0x007a, B:34:0x007e, B:36:0x0090, B:38:0x0094, B:39:0x0098, B:42:0x0069, B:44:0x009e, B:47:0x0011, B:49:0x0019, B:50:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0029, B:15:0x0030, B:17:0x003a, B:18:0x0045, B:19:0x003d, B:20:0x0047, B:22:0x0058, B:23:0x0064, B:26:0x006d, B:28:0x0071, B:32:0x007a, B:34:0x007e, B:36:0x0090, B:38:0x0094, B:39:0x0098, B:42:0x0069, B:44:0x009e, B:47:0x0011, B:49:0x0019, B:50:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0029, B:15:0x0030, B:17:0x003a, B:18:0x0045, B:19:0x003d, B:20:0x0047, B:22:0x0058, B:23:0x0064, B:26:0x006d, B:28:0x0071, B:32:0x007a, B:34:0x007e, B:36:0x0090, B:38:0x0094, B:39:0x0098, B:42:0x0069, B:44:0x009e, B:47:0x0011, B:49:0x0019, B:50:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a A[Catch: all -> 0x000e, TRY_ENTER, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0029, B:15:0x0030, B:17:0x003a, B:18:0x0045, B:19:0x003d, B:20:0x0047, B:22:0x0058, B:23:0x0064, B:26:0x006d, B:28:0x0071, B:32:0x007a, B:34:0x007e, B:36:0x0090, B:38:0x0094, B:39:0x0098, B:42:0x0069, B:44:0x009e, B:47:0x0011, B:49:0x0019, B:50:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0069 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0029, B:15:0x0030, B:17:0x003a, B:18:0x0045, B:19:0x003d, B:20:0x0047, B:22:0x0058, B:23:0x0064, B:26:0x006d, B:28:0x0071, B:32:0x007a, B:34:0x007e, B:36:0x0090, B:38:0x0094, B:39:0x0098, B:42:0x0069, B:44:0x009e, B:47:0x0011, B:49:0x0019, B:50:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized android.graphics.Bitmap A4TApA() {
        /*
            r8 = this;
            monitor-enter(r8)
            HPJABZ.A4TApA r0 = r8.f3448AcNBzu     // Catch: java.lang.Throwable -> Le
            int r0 = r0.f3426A5SV6n     // Catch: java.lang.Throwable -> Le
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L11
            int r0 = r8.f3447AaHO0E     // Catch: java.lang.Throwable -> Le
            if (r0 >= 0) goto L1f
            goto L11
        Le:
            r0 = move-exception
            goto La5
        L11:
            java.lang.String r0 = "ADYaiT"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L1d
            HPJABZ.A4TApA r0 = r8.f3448AcNBzu     // Catch: java.lang.Throwable -> Le
            int r0 = r0.f3426A5SV6n     // Catch: java.lang.Throwable -> Le
        L1d:
            r8.f3451AzWtSf = r2     // Catch: java.lang.Throwable -> Le
        L1f:
            int r0 = r8.f3451AzWtSf     // Catch: java.lang.Throwable -> Le
            r3 = 0
            if (r0 == r2) goto L9e
            r4 = 2
            if (r0 != r4) goto L29
            goto L9e
        L29:
            r0 = 0
            r8.f3451AzWtSf = r0     // Catch: java.lang.Throwable -> Le
            byte[] r5 = r8.AMqCpz     // Catch: java.lang.Throwable -> Le
            if (r5 != 0) goto L47
            I3HV03.A4TApA r5 = r8.f3440A5SV6n     // Catch: java.lang.Throwable -> Le
            java.lang.Object r5 = r5.f3809AmA8tU     // Catch: java.lang.Throwable -> Le
            HZUvgL.AaHO0E r5 = (HZUvgL.AaHO0E) r5     // Catch: java.lang.Throwable -> Le
            r6 = 255(0xff, float:3.57E-43)
            if (r5 != 0) goto L3d
            byte[] r5 = new byte[r6]     // Catch: java.lang.Throwable -> Le
            goto L45
        L3d:
            java.lang.Class<byte[]> r7 = byte[].class
            java.lang.Object r5 = r5.ADYaiT(r6, r7)     // Catch: java.lang.Throwable -> Le
            byte[] r5 = (byte[]) r5     // Catch: java.lang.Throwable -> Le
        L45:
            r8.AMqCpz = r5     // Catch: java.lang.Throwable -> Le
        L47:
            HPJABZ.A4TApA r5 = r8.f3448AcNBzu     // Catch: java.lang.Throwable -> Le
            java.util.ArrayList r5 = r5.AMqCpz     // Catch: java.lang.Throwable -> Le
            int r6 = r8.f3447AaHO0E     // Catch: java.lang.Throwable -> Le
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> Le
            HPJABZ.A2egSU r5 = (HPJABZ.A2egSU) r5     // Catch: java.lang.Throwable -> Le
            int r6 = r8.f3447AaHO0E     // Catch: java.lang.Throwable -> Le
            int r6 = r6 - r2
            if (r6 < 0) goto L63
            HPJABZ.A4TApA r7 = r8.f3448AcNBzu     // Catch: java.lang.Throwable -> Le
            java.util.ArrayList r7 = r7.AMqCpz     // Catch: java.lang.Throwable -> Le
            java.lang.Object r6 = r7.get(r6)     // Catch: java.lang.Throwable -> Le
            HPJABZ.A2egSU r6 = (HPJABZ.A2egSU) r6     // Catch: java.lang.Throwable -> Le
            goto L64
        L63:
            r6 = r3
        L64:
            int[] r7 = r5.f3423AaHO0E     // Catch: java.lang.Throwable -> Le
            if (r7 == 0) goto L69
            goto L6d
        L69:
            HPJABZ.A4TApA r7 = r8.f3448AcNBzu     // Catch: java.lang.Throwable -> Le
            int[] r7 = r7.f3424A2egSU     // Catch: java.lang.Throwable -> Le
        L6d:
            r8.f3438A2egSU = r7     // Catch: java.lang.Throwable -> Le
            if (r7 != 0) goto L7a
            java.lang.String r0 = "ADYaiT"
            android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            r8.f3451AzWtSf = r2     // Catch: java.lang.Throwable -> Le
            monitor-exit(r8)
            return r3
        L7a:
            boolean r1 = r5.f3418ARc23Z     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L98
            int[] r1 = r8.f3439A4TApA     // Catch: java.lang.Throwable -> Le
            int r2 = r7.length     // Catch: java.lang.Throwable -> Le
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch: java.lang.Throwable -> Le
            int[] r1 = r8.f3439A4TApA     // Catch: java.lang.Throwable -> Le
            r8.f3438A2egSU = r1     // Catch: java.lang.Throwable -> Le
            int r2 = r5.f3420AYUAbz     // Catch: java.lang.Throwable -> Le
            r1[r2] = r0     // Catch: java.lang.Throwable -> Le
            int r0 = r5.f3419ASJ6gh     // Catch: java.lang.Throwable -> Le
            if (r0 != r4) goto L98
            int r0 = r8.f3447AaHO0E     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L98
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Le
            r8.f3455B4ZgIw = r0     // Catch: java.lang.Throwable -> Le
        L98:
            android.graphics.Bitmap r0 = r8.ADYaiT(r5, r6)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r8)
            return r0
        L9e:
            java.lang.String r0 = "ADYaiT"
            android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r8)
            return r3
        La5:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Le
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: HPJABZ.ADYaiT.A4TApA():android.graphics.Bitmap");
    }

    public final void A5SV6n(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f3456B7CMnp = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        if (r4.f3432AZkASS == r36.f3420AYUAbz) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap ADYaiT(HPJABZ.A2egSU r36, HPJABZ.A2egSU r37) {
        /*
            Method dump skipped, instructions count: 1055
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: HPJABZ.ADYaiT.ADYaiT(HPJABZ.A2egSU, HPJABZ.A2egSU):android.graphics.Bitmap");
    }
}
