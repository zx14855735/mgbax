package ARc23Z;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AMqCpz extends AcNBzu implements BmvVmW.AZOQYO {

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public A4TApA f283BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public com.bumptech.glide.A5SV6n f284BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f285BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f286BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f287BniPrB;

    public AMqCpz() {
        this(null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0264, code lost:
    
        r5.onStateChange(r5.getState());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x026b, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ARc23Z.AMqCpz ASJ6gh(android.content.Context r23, android.content.res.Resources r24, android.content.res.XmlResourceParser r25, android.util.AttributeSet r26, android.content.res.Resources.Theme r27) {
        /*
            Method dump skipped, instructions count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ARc23Z.AMqCpz.ASJ6gh(android.content.Context, android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):ARc23Z.AMqCpz");
    }

    @Override // ARc23Z.AcNBzu, ARc23Z.AYUAbz
    public final AaHO0E A4TApA() {
        return new A4TApA(this.f283BPw6Q8, this, null);
    }

    @Override // ARc23Z.AcNBzu, ARc23Z.AYUAbz
    public final void AMqCpz(AaHO0E aaHO0E) {
        super.AMqCpz(aaHO0E);
        if (aaHO0E instanceof A4TApA) {
            this.f283BPw6Q8 = (A4TApA) aaHO0E;
        }
    }

    @Override // ARc23Z.AcNBzu
    /* renamed from: ARc23Z */
    public final AaHO0E A4TApA() {
        return new A4TApA(this.f283BPw6Q8, this, null);
    }

    @Override // ARc23Z.AYUAbz, android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        super.jumpToCurrentState();
        com.bumptech.glide.A5SV6n a5SV6n = this.f284BTvldC;
        if (a5SV6n != null) {
            a5SV6n.DXnQ0V();
            this.f284BTvldC = null;
            ADYaiT(this.f285BV3sI0);
            this.f285BV3sI0 = -1;
            this.f286BmvVmW = -1;
        }
    }

    @Override // ARc23Z.AcNBzu, ARc23Z.AYUAbz, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.f287BniPrB) {
            super.mutate();
            this.f283BPw6Q8.ARc23Z();
            this.f287BniPrB = true;
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
    
        if (ADYaiT(r1) != false) goto L45;
     */
    @Override // ARc23Z.AcNBzu, ARc23Z.AYUAbz, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStateChange(int[] r14) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ARc23Z.AMqCpz.onStateChange(int[]):boolean");
    }

    @Override // ARc23Z.AYUAbz, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        com.bumptech.glide.A5SV6n a5SV6n = this.f284BTvldC;
        if (a5SV6n != null && (visible || z2)) {
            if (z) {
                a5SV6n.DV2E8K();
                return visible;
            }
            jumpToCurrentState();
        }
        return visible;
    }

    public AMqCpz(A4TApA a4TApA, Resources resources) {
        this.f285BV3sI0 = -1;
        this.f286BmvVmW = -1;
        AMqCpz(new A4TApA(a4TApA, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
