package CikNvS;

import ADYaiT.D8MqeW;
import AaHO0E.EdQ5bb;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements View.OnTouchListener {

    /* renamed from: BV3sI0, reason: collision with root package name */
    public static final int f1791BV3sI0 = ViewConfiguration.getTapTimeout();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A2egSU f1792AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AccelerateInterpolator f1793AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ListView f1794AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public D8MqeW f1795AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final float[] f1796B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final float[] f1797B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f1798B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f1799B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final float[] f1800B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final float[] f1801B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final float[] f1802BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f1803BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f1804BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f1805BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f1806BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f1807BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final EdQ5bb f1808BTvldC;

    static {
        GUoYtj();
    }

    public ASJ6gh(EdQ5bb edQ5bb) {
        A2egSU a2egSU = new A2egSU();
        a2egSU.AMqCpz = Long.MIN_VALUE;
        a2egSU.f1788ASJ6gh = -1L;
        a2egSU.f1787ARc23Z = 0L;
        this.f1792AcNBzu = a2egSU;
        this.f1793AlLFFp = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f1796B25kr6 = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1797B2KMhB = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f1800B7CMnp = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f1801B9tovu = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1802BChYOn = fArr5;
        this.f1794AmA8tU = edQ5bb;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.f1798B3GDIM = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f1799B4ZgIw = f1791BV3sI0;
        a2egSU.f1783A2egSU = 500;
        a2egSU.f1784A4TApA = 500;
        this.f1808BTvldC = edQ5bb;
    }

    public static float A4TApA(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private static /* synthetic */ void GUoYtj() {
        char[] charArray = "¢®¬ï¦ ¬¤ï£®¸ï²©¤\u00ad\u00adï\u008b¯¨\u0083³¨¥¦¤".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 193);
        }
        String str = new String(charArray);
        char[] charArray2 = "¢\u00ad¨¯¨µ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 193);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float A2egSU(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f1796B25kr6
            r0 = r0[r7]
            float[] r1 = r3.f1797B2KMhB
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = A4TApA(r0, r2, r1)
            float r1 = r3.A5SV6n(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.A5SV6n(r5, r0)
            float r4 = r4 - r1
            android.view.animation.AccelerateInterpolator r5 = r3.f1793AlLFFp
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L26
            float r4 = -r4
            float r4 = r5.getInterpolation(r4)
            float r4 = -r4
            goto L2e
        L26:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L37
            float r4 = r5.getInterpolation(r4)
        L2e:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = A4TApA(r4, r5, r0)
            goto L38
        L37:
            r4 = 0
        L38:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3d
            return r2
        L3d:
            float[] r0 = r3.f1800B7CMnp
            r0 = r0[r7]
            float[] r1 = r3.f1801B9tovu
            r1 = r1[r7]
            float[] r2 = r3.f1802BChYOn
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L54
            float r4 = r4 * r0
            float r4 = A4TApA(r4, r1, r7)
            return r4
        L54:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = A4TApA(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: CikNvS.ASJ6gh.A2egSU(float, float, float, int):float");
    }

    public final float A5SV6n(float f, float f2) {
        if (f2 != 0.0f) {
            int i = this.f1798B3GDIM;
            if (i == 0 || i == 1) {
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.f1806BNL6CD && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < 0.0f) {
                return f / (-f2);
            }
        }
        return 0.0f;
    }

    public final void ADYaiT() {
        int i = 0;
        if (this.f1804BIYEnU) {
            this.f1806BNL6CD = false;
            return;
        }
        A2egSU a2egSU = this.f1792AcNBzu;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (currentAnimationTimeMillis - a2egSU.AMqCpz);
        int i3 = a2egSU.f1784A4TApA;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        a2egSU.f1790AZOQYO = i;
        a2egSU.f1789AYUAbz = a2egSU.A2egSU(currentAnimationTimeMillis);
        a2egSU.f1788ASJ6gh = currentAnimationTimeMillis;
    }

    public final boolean AMqCpz() {
        EdQ5bb edQ5bb;
        int count;
        A2egSU a2egSU = this.f1792AcNBzu;
        float f = a2egSU.f1786ADYaiT;
        int abs = (int) (f / Math.abs(f));
        Math.abs(a2egSU.f1785A5SV6n);
        if (abs != 0 && (count = (edQ5bb = this.f1808BTvldC).getCount()) != 0) {
            int childCount = edQ5bb.getChildCount();
            int firstVisiblePosition = edQ5bb.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && edQ5bb.getChildAt(0).getTop() >= 0)) : !(i >= count && edQ5bb.getChildAt(childCount - 1).getBottom() <= edQ5bb.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f1807BPw6Q8
            r1 = 0
            if (r0 != 0) goto L7
            goto L7d
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7d
        L17:
            r7.ADYaiT()
            return r1
        L1b:
            r7.f1805BJ7GGh = r2
            r7.f1803BI9f7h = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.widget.ListView r4 = r7.f1794AmA8tU
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.A2egSU(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.A2egSU(r9, r8, r3, r2)
            CikNvS.A2egSU r9 = r7.f1792AcNBzu
            r9.f1785A5SV6n = r0
            r9.f1786ADYaiT = r8
            boolean r8 = r7.f1806BNL6CD
            if (r8 != 0) goto L7d
            boolean r8 = r7.AMqCpz()
            if (r8 == 0) goto L7d
            ADYaiT.D8MqeW r8 = r7.f1795AzWtSf
            if (r8 != 0) goto L61
            ADYaiT.D8MqeW r8 = new ADYaiT.D8MqeW
            r9 = 5
            r8.<init>(r9, r7)
            r7.f1795AzWtSf = r8
        L61:
            r7.f1806BNL6CD = r2
            r7.f1804BIYEnU = r2
            boolean r8 = r7.f1803BI9f7h
            if (r8 != 0) goto L76
            int r8 = r7.f1799B4ZgIw
            if (r8 <= 0) goto L76
            ADYaiT.D8MqeW r9 = r7.f1795AzWtSf
            long r5 = (long) r8
            java.util.WeakHashMap r8 = COJEAR.DG07BK.f1680A2egSU
            r4.postOnAnimationDelayed(r9, r5)
            goto L7b
        L76:
            ADYaiT.D8MqeW r8 = r7.f1795AzWtSf
            r8.run()
        L7b:
            r7.f1803BI9f7h = r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: CikNvS.ASJ6gh.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
