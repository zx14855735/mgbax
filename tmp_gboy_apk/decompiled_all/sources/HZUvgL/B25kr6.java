package HZUvgL;

import android.graphics.Bitmap;
import android.os.Build;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class B25kr6 {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final Bitmap.Config[] f3677ADYaiT;
    public static final Bitmap.Config[] AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final Bitmap.Config[] f3678ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final Bitmap.Config[] f3679ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final Bitmap.Config[] f3680AYUAbz;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AZkASS f3681A2egSU = new AZkASS(1);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final K1Z3yj.A2egSU f3682A4TApA = new K1Z3yj.A2egSU(28);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashMap f3683A5SV6n = new HashMap();

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            int length = configArr.length - 1;
            config = Bitmap.Config.RGBA_F16;
            configArr[length] = config;
        }
        f3677ADYaiT = configArr;
        AMqCpz = configArr;
        f3678ARc23Z = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f3679ASJ6gh = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f3680AYUAbz = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
        DjvtXW();
    }

    public static String A5SV6n(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static /* synthetic */ void DjvtXW() {
        char[] charArray = "\\PR\u0011X^RZ\u0011]PF\u0011LWZSS\u0011uQV}MV[XZ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '?');
        }
        String str = new String(charArray);
        char[] charArray2 = "\\SVQVK".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '?');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(Integer num, Bitmap bitmap) {
        NavigableMap ADYaiT2 = ADYaiT(bitmap.getConfig());
        Integer num2 = (Integer) ADYaiT2.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                ADYaiT2.remove(num);
                return;
            } else {
                ADYaiT2.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + A5SV6n(ItGa5w.AlLFFp.A5SV6n(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[EDGE_INSN: B:34:0x00a3->B:20:0x00a3 BREAK  A[LOOP:0: B:10:0x0055->B:32:0x00a1], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap A4TApA(int r12, int r13, android.graphics.Bitmap.Config r14) {
        /*
            r11 = this;
            r0 = 0
            r1 = 1
            int r2 = ItGa5w.AlLFFp.A4TApA(r12, r13, r14)
            HZUvgL.AZkASS r3 = r11.f3681A2egSU
            java.lang.Object r4 = r3.f3654AcNBzu
            java.util.ArrayDeque r4 = (java.util.ArrayDeque) r4
            java.lang.Object r4 = r4.poll()
            HZUvgL.AlLFFp r4 = (HZUvgL.AlLFFp) r4
            if (r4 != 0) goto L18
            HZUvgL.AlLFFp r4 = r3.A5SV6n()
        L18:
            HZUvgL.AzWtSf r4 = (HZUvgL.AzWtSf) r4
            r4.f3675A4TApA = r2
            r4.f3676A5SV6n = r14
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 26
            if (r5 < r6) goto L31
            android.graphics.Bitmap$Config r5 = ADYaiT.C4FrIb.BJ7GGh()
            boolean r5 = r5.equals(r14)
            if (r5 == 0) goto L31
            android.graphics.Bitmap$Config[] r5 = HZUvgL.B25kr6.AMqCpz
            goto L54
        L31:
            int[] r5 = HZUvgL.AmA8tU.f3673A2egSU
            int r6 = r14.ordinal()
            r5 = r5[r6]
            if (r5 == r1) goto L52
            r6 = 2
            if (r5 == r6) goto L4f
            r6 = 3
            if (r5 == r6) goto L4c
            r6 = 4
            if (r5 == r6) goto L49
            android.graphics.Bitmap$Config[] r5 = new android.graphics.Bitmap.Config[r1]
            r5[r0] = r14
            goto L54
        L49:
            android.graphics.Bitmap$Config[] r5 = HZUvgL.B25kr6.f3680AYUAbz
            goto L54
        L4c:
            android.graphics.Bitmap$Config[] r5 = HZUvgL.B25kr6.f3679ASJ6gh
            goto L54
        L4f:
            android.graphics.Bitmap$Config[] r5 = HZUvgL.B25kr6.f3678ARc23Z
            goto L54
        L52:
            android.graphics.Bitmap$Config[] r5 = HZUvgL.B25kr6.f3677ADYaiT
        L54:
            int r6 = r5.length
        L55:
            if (r0 >= r6) goto La3
            r7 = r5[r0]
            java.util.NavigableMap r8 = r11.ADYaiT(r7)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            java.lang.Object r8 = r8.ceilingKey(r9)
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto La1
            int r9 = r8.intValue()
            int r10 = r2 * 8
            if (r9 > r10) goto La1
            int r0 = r8.intValue()
            if (r0 != r2) goto L82
            if (r7 != 0) goto L7c
            if (r14 == 0) goto La3
            goto L82
        L7c:
            boolean r0 = r7.equals(r14)
            if (r0 != 0) goto La3
        L82:
            r3.A4TApA(r4)
            int r0 = r8.intValue()
            java.lang.Object r1 = r3.f3654AcNBzu
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1
            java.lang.Object r1 = r1.poll()
            HZUvgL.AlLFFp r1 = (HZUvgL.AlLFFp) r1
            if (r1 != 0) goto L99
            HZUvgL.AlLFFp r1 = r3.A5SV6n()
        L99:
            r4 = r1
            HZUvgL.AzWtSf r4 = (HZUvgL.AzWtSf) r4
            r4.f3675A4TApA = r0
            r4.f3676A5SV6n = r7
            goto La3
        La1:
            int r0 = r0 + r1
            goto L55
        La3:
            K1Z3yj.A2egSU r0 = r11.f3682A4TApA
            java.lang.Object r0 = r0.AmA8tU(r4)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto Lb9
            int r1 = r4.f3675A4TApA
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.A2egSU(r1, r0)
            r0.reconfigure(r12, r13, r14)
        Lb9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: HZUvgL.B25kr6.A4TApA(int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    public final NavigableMap ADYaiT(Bitmap.Config config) {
        HashMap hashMap = this.f3683A5SV6n;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(config, treeMap);
        return treeMap;
    }

    public final void AMqCpz(Bitmap bitmap) {
        int A5SV6n2 = ItGa5w.AlLFFp.A5SV6n(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        AZkASS aZkASS = this.f3681A2egSU;
        AlLFFp alLFFp = (AlLFFp) ((ArrayDeque) aZkASS.f3654AcNBzu).poll();
        if (alLFFp == null) {
            alLFFp = aZkASS.A5SV6n();
        }
        AzWtSf azWtSf = (AzWtSf) alLFFp;
        azWtSf.f3675A4TApA = A5SV6n2;
        azWtSf.f3676A5SV6n = config;
        this.f3682A4TApA.B2KMhB(azWtSf, bitmap);
        NavigableMap ADYaiT2 = ADYaiT(bitmap.getConfig());
        Integer num = (Integer) ADYaiT2.get(Integer.valueOf(azWtSf.f3675A4TApA));
        ADYaiT2.put(Integer.valueOf(azWtSf.f3675A4TApA), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder A4TApA2 = B4ZgIw.AYUAbz.A4TApA("SizeConfigStrategy{groupedMap=");
        A4TApA2.append(this.f3682A4TApA);
        A4TApA2.append(", sortedSizes=(");
        HashMap hashMap = this.f3683A5SV6n;
        for (Map.Entry entry : hashMap.entrySet()) {
            A4TApA2.append(entry.getKey());
            A4TApA2.append('[');
            A4TApA2.append(entry.getValue());
            A4TApA2.append("], ");
        }
        if (!hashMap.isEmpty()) {
            A4TApA2.replace(A4TApA2.length() - 2, A4TApA2.length(), "");
        }
        A4TApA2.append(")}");
        return A4TApA2.toString();
    }
}
