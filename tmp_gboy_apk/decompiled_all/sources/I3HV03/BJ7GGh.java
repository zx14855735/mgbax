package I3HV03;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BJ7GGh {

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final boolean f3847ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final boolean f3848AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final File f3849AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public static volatile BJ7GGh f3850AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static volatile int f3851AaHO0E;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final boolean f3852A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f3853A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f3854A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f3855ADYaiT;
    public boolean AMqCpz = true;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final AtomicBoolean f3856ARc23Z = new AtomicBoolean(false);

    static {
        int i = Build.VERSION.SDK_INT;
        f3847ASJ6gh = i < 29;
        f3848AYUAbz = i >= 26;
        f3849AZOQYO = new File("/proc/self/fd");
        f3851AaHO0E = -1;
        jdNBy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x009e, code lost:
    
        r26.f3852A2egSU = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00a4, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 28) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00a6, code lost:
    
        r26.f3853A4TApA = 20000;
        r26.f3854A5SV6n = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00ac, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ad, code lost:
    
        r26.f3853A4TApA = 700;
        r26.f3854A5SV6n = com.sigmob.sdk.base.views.r.b.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT != 27 ? false : java.util.Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(android.os.Build.MODEL)) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x009d, code lost:
    
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BJ7GGh() {
        /*
            r26 = this;
            r0 = r26
            r0.<init>()
            r1 = 1
            r0.AMqCpz = r1
            java.util.concurrent.atomic.AtomicBoolean r2 = new java.util.concurrent.atomic.AtomicBoolean
            r3 = 0
            r2.<init>(r3)
            r0.f3856ARc23Z = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            if (r2 == r4) goto L17
            goto L5a
        L17:
            java.lang.String r20 = "moto g(6) forge"
            java.lang.String r21 = "moto g(6) play"
            java.lang.String r5 = "SC-04J"
            java.lang.String r6 = "SM-N935"
            java.lang.String r7 = "SM-J720"
            java.lang.String r8 = "SM-G570F"
            java.lang.String r9 = "SM-G570M"
            java.lang.String r10 = "SM-G960"
            java.lang.String r11 = "SM-G965"
            java.lang.String r12 = "SM-G935"
            java.lang.String r13 = "SM-G930"
            java.lang.String r14 = "SM-A520"
            java.lang.String r15 = "SM-A720F"
            java.lang.String r16 = "moto e5"
            java.lang.String r17 = "moto e5 play"
            java.lang.String r18 = "moto e5 plus"
            java.lang.String r19 = "moto e5 cruise"
            java.lang.String[] r2 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}
            java.util.List r2 = java.util.Arrays.asList(r2)
            java.util.Iterator r2 = r2.iterator()
        L45:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L5a
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = android.os.Build.MODEL
            boolean r4 = r5.startsWith(r4)
            if (r4 == 0) goto L45
            goto L9d
        L5a:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 27
            if (r2 == r4) goto L62
            r2 = 0
            goto L9a
        L62:
            java.lang.String r24 = "LM-X220QMA"
            java.lang.String r25 = "LM-X410PM"
            java.lang.String r5 = "LG-M250"
            java.lang.String r6 = "LG-M320"
            java.lang.String r7 = "LG-Q710AL"
            java.lang.String r8 = "LG-Q710PL"
            java.lang.String r9 = "LGM-K121K"
            java.lang.String r10 = "LGM-K121L"
            java.lang.String r11 = "LGM-K121S"
            java.lang.String r12 = "LGM-X320K"
            java.lang.String r13 = "LGM-X320L"
            java.lang.String r14 = "LGM-X320S"
            java.lang.String r15 = "LGM-X401L"
            java.lang.String r16 = "LGM-X401S"
            java.lang.String r17 = "LM-Q610.FG"
            java.lang.String r18 = "LM-Q610.FGN"
            java.lang.String r19 = "LM-Q617.FG"
            java.lang.String r20 = "LM-Q617.FGN"
            java.lang.String r21 = "LM-Q710.FG"
            java.lang.String r22 = "LM-Q710.FGN"
            java.lang.String r23 = "LM-X220PM"
            java.lang.String[] r2 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25}
            java.util.List r2 = java.util.Arrays.asList(r2)
            java.lang.String r4 = android.os.Build.MODEL
            boolean r2 = r2.contains(r4)
        L9a:
            if (r2 != 0) goto L9d
            goto L9e
        L9d:
            r1 = 0
        L9e:
            r0.f3852A2egSU = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto Lad
            r1 = 20000(0x4e20, float:2.8026E-41)
            r0.f3853A4TApA = r1
            r0.f3854A5SV6n = r3
            return
        Lad:
            r1 = 700(0x2bc, float:9.81E-43)
            r0.f3853A4TApA = r1
            r1 = 128(0x80, float:1.794E-43)
            r0.f3854A5SV6n = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: I3HV03.BJ7GGh.<init>():void");
    }

    public static BJ7GGh A2egSU() {
        if (f3850AZkASS == null) {
            synchronized (BJ7GGh.class) {
                try {
                    if (f3850AZkASS == null) {
                        f3850AZkASS = new BJ7GGh();
                    }
                } finally {
                }
            }
        }
        return f3850AZkASS;
    }

    private static /* synthetic */ void jdNBy() {
        char[] charArray = "\u007fsq2{}qy2~se2otypp2Vru^nux{y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 28);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u007fpuruh".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 28);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean A4TApA(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        if (!z) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (!this.f3852A2egSU) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (!f3848AYUAbz) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (f3847ASJ6gh && !this.f3856ARc23Z.get()) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (z2) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        int i3 = this.f3854A5SV6n;
        if (i < i3) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (i2 < i3) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        synchronized (this) {
            try {
                int i4 = this.f3855ADYaiT + 1;
                this.f3855ADYaiT = i4;
                if (i4 >= 50) {
                    this.f3855ADYaiT = 0;
                    boolean z4 = ((long) f3849AZOQYO.list().length) < ((long) (f3851AaHO0E != -1 ? f3851AaHO0E : this.f3853A4TApA));
                    this.AMqCpz = z4;
                    if (!z4) {
                        Log.isLoggable("Downsampler", 5);
                    }
                }
                z3 = this.AMqCpz;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z3) {
            return true;
        }
        Log.isLoggable("HardwareConfig", 2);
        return false;
    }
}
