package DaOi9o;

import android.animation.Animator;
import android.view.View;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CkXcdM extends B4ZgIw {

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public static final String[] f2302Cd8JRx = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: CcAIMM, reason: collision with root package name */
    public int f2303CcAIMM = 3;

    static {
        IpbCg();
    }

    public static void COJEAR(BmvVmW bmvVmW) {
        int visibility = bmvVmW.f2282A4TApA.getVisibility();
        HashMap hashMap = bmvVmW.f2281A2egSU;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = bmvVmW.f2282A4TApA;
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static DaOi9o.CikNvS CQhlFr(DaOi9o.BmvVmW r8, DaOi9o.BmvVmW r9) {
        /*
            DaOi9o.CikNvS r0 = new DaOi9o.CikNvS
            r0.<init>()
            r1 = 0
            r0.f2297A2egSU = r1
            r0.f2298A4TApA = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f2281A2egSU
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f2299A5SV6n = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.AMqCpz = r6
            goto L33
        L2f:
            r0.f2299A5SV6n = r3
            r0.AMqCpz = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f2281A2egSU
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f2300ADYaiT = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f2301ARc23Z = r2
            goto L56
        L52:
            r0.f2300ADYaiT = r3
            r0.f2301ARc23Z = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f2299A5SV6n
            int r9 = r0.f2300ADYaiT
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.AMqCpz
            android.view.ViewGroup r4 = r0.f2301ARc23Z
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f2298A4TApA = r1
            r0.f2297A2egSU = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.f2298A4TApA = r2
            r0.f2297A2egSU = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f2301ARc23Z
            if (r8 != 0) goto L81
            r0.f2298A4TApA = r1
            r0.f2297A2egSU = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.AMqCpz
            if (r8 != 0) goto L9f
            r0.f2298A4TApA = r2
            r0.f2297A2egSU = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f2300ADYaiT
            if (r8 != 0) goto L95
            r0.f2298A4TApA = r2
            r0.f2297A2egSU = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f2299A5SV6n
            if (r8 != 0) goto L9f
            r0.f2298A4TApA = r1
            r0.f2297A2egSU = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: DaOi9o.CkXcdM.CQhlFr(DaOi9o.BmvVmW, DaOi9o.BmvVmW):DaOi9o.CikNvS");
    }

    private static /* synthetic */ void IpbCg() {
        char[] charArray = "ÿóñ²ûýñù²þóå²ïôùðð²ÖòõÞîõøûù".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 156);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÿðõòõè".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 156);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // DaOi9o.B4ZgIw
    public final void ADYaiT(BmvVmW bmvVmW) {
        COJEAR(bmvVmW);
    }

    @Override // DaOi9o.B4ZgIw
    public void ASJ6gh(BmvVmW bmvVmW) {
        COJEAR(bmvVmW);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (CQhlFr(B25kr6(r3, false), B7CMnp(r3, false)).f2297A2egSU != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01db  */
    @Override // DaOi9o.B4ZgIw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator AaHO0E(android.view.ViewGroup r24, DaOi9o.BmvVmW r25, DaOi9o.BmvVmW r26) {
        /*
            Method dump skipped, instructions count: 683
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: DaOi9o.CkXcdM.AaHO0E(android.view.ViewGroup, DaOi9o.BmvVmW, DaOi9o.BmvVmW):android.animation.Animator");
    }

    @Override // DaOi9o.B4ZgIw
    public final String[] B4ZgIw() {
        return f2302Cd8JRx;
    }

    @Override // DaOi9o.B4ZgIw
    public final boolean B9tovu(BmvVmW bmvVmW, BmvVmW bmvVmW2) {
        if (bmvVmW == null && bmvVmW2 == null) {
            return false;
        }
        if (bmvVmW != null && bmvVmW2 != null && bmvVmW2.f2281A2egSU.containsKey("android:visibility:visibility") != bmvVmW.f2281A2egSU.containsKey("android:visibility:visibility")) {
            return false;
        }
        CikNvS CQhlFr2 = CQhlFr(bmvVmW, bmvVmW2);
        if (CQhlFr2.f2297A2egSU) {
            return CQhlFr2.f2299A5SV6n == 0 || CQhlFr2.f2300ADYaiT == 0;
        }
        return false;
    }

    public Animator CSDoyG(View view, BmvVmW bmvVmW) {
        return null;
    }

    public Animator CTkVKb(View view, BmvVmW bmvVmW, BmvVmW bmvVmW2) {
        return null;
    }
}
