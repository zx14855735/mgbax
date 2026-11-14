package DcUJf1;

import android.graphics.Paint;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends AmA8tU {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public BTvldC.ADYaiT f2332ADYaiT;
    public float AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public BTvldC.ADYaiT f2333ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f2334ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f2335AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public float f2336AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public float f2337AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public float f2338AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Paint.Cap f2339AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Paint.Join f2340AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public float f2341AmA8tU;

    @Override // DcUJf1.AlLFFp
    public final boolean A2egSU() {
        return this.f2333ARc23Z.A4TApA() || this.f2332ADYaiT.A4TApA();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // DcUJf1.AlLFFp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A4TApA(int[] r7) {
        /*
            r6 = this;
            BTvldC.ADYaiT r0 = r6.f2333ARc23Z
            boolean r1 = r0.A4TApA()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.f1449AmA8tU
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r7, r4)
            int r4 = r0.f1447AcNBzu
            if (r1 == r4) goto L1e
            r0.f1447AcNBzu = r1
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            BTvldC.ADYaiT r1 = r6.f2332ADYaiT
            boolean r4 = r1.A4TApA()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r1.f1449AmA8tU
            android.content.res.ColorStateList r4 = (android.content.res.ColorStateList) r4
            int r5 = r4.getDefaultColor()
            int r7 = r4.getColorForState(r7, r5)
            int r4 = r1.f1447AcNBzu
            if (r7 == r4) goto L3a
            r1.f1447AcNBzu = r7
            r2 = 1
        L3a:
            r7 = r0 | r2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: DcUJf1.AaHO0E.A4TApA(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.f2335AYUAbz;
    }

    public int getFillColor() {
        return this.f2333ARc23Z.f1447AcNBzu;
    }

    public float getStrokeAlpha() {
        return this.f2334ASJ6gh;
    }

    public int getStrokeColor() {
        return this.f2332ADYaiT.f1447AcNBzu;
    }

    public float getStrokeWidth() {
        return this.AMqCpz;
    }

    public float getTrimPathEnd() {
        return this.f2337AZkASS;
    }

    public float getTrimPathOffset() {
        return this.f2338AaHO0E;
    }

    public float getTrimPathStart() {
        return this.f2336AZOQYO;
    }

    public void setFillAlpha(float f) {
        this.f2335AYUAbz = f;
    }

    public void setFillColor(int i) {
        this.f2333ARc23Z.f1447AcNBzu = i;
    }

    public void setStrokeAlpha(float f) {
        this.f2334ASJ6gh = f;
    }

    public void setStrokeColor(int i) {
        this.f2332ADYaiT.f1447AcNBzu = i;
    }

    public void setStrokeWidth(float f) {
        this.AMqCpz = f;
    }

    public void setTrimPathEnd(float f) {
        this.f2337AZkASS = f;
    }

    public void setTrimPathOffset(float f) {
        this.f2338AaHO0E = f;
    }

    public void setTrimPathStart(float f) {
        this.f2336AZOQYO = f;
    }
}
