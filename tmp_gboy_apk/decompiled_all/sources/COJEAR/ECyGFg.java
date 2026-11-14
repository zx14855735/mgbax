package COJEAR;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ECyGFg implements View.OnApplyWindowInsetsListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ARc23Z f1704A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public FG7pZc f1705A4TApA;

    public ECyGFg(View view, ARc23Z aRc23Z) {
        this.f1704A2egSU = aRc23Z;
        FG7pZc AZOQYO2 = DG07BK.AZOQYO(view);
        this.f1705A4TApA = AZOQYO2 != null ? new EdQ5bb(AZOQYO2).f1721A2egSU.A4TApA() : null;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        F32kj0 f32kj0;
        if (!view.isLaidOut()) {
            this.f1705A4TApA = FG7pZc.ASJ6gh(view, windowInsets);
            return EGM26s.AZOQYO(view, windowInsets);
        }
        FG7pZc ASJ6gh2 = FG7pZc.ASJ6gh(view, windowInsets);
        if (this.f1705A4TApA == null) {
            this.f1705A4TApA = DG07BK.AZOQYO(view);
        }
        if (this.f1705A4TApA == null) {
            this.f1705A4TApA = ASJ6gh2;
            return EGM26s.AZOQYO(view, windowInsets);
        }
        ARc23Z AZkASS2 = EGM26s.AZkASS(view);
        if (AZkASS2 != null && Objects.equals((WindowInsets) AZkASS2.f1619AlLFFp, windowInsets)) {
            return EGM26s.AZOQYO(view, windowInsets);
        }
        FG7pZc fG7pZc = this.f1705A4TApA;
        int i = 1;
        int i2 = 0;
        while (true) {
            f32kj0 = ASJ6gh2.f1747A2egSU;
            if (i > 256) {
                break;
            }
            if (!f32kj0.ARc23Z(i).equals(fG7pZc.f1747A2egSU.ARc23Z(i))) {
                i2 |= i;
            }
            i <<= 1;
        }
        if (i2 == 0) {
            return EGM26s.AZOQYO(view, windowInsets);
        }
        FG7pZc fG7pZc2 = this.f1705A4TApA;
        EUIRHA euirha = new EUIRHA(i2, (i2 & 8) != 0 ? f32kj0.ARc23Z(8).f1485ADYaiT > fG7pZc2.f1747A2egSU.ARc23Z(8).f1485ADYaiT ? EGM26s.AMqCpz : EGM26s.f1706ARc23Z : EGM26s.f1707ASJ6gh, 160L);
        euirha.f1716A2egSU.ADYaiT(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(euirha.f1716A2egSU.A2egSU());
        BV3sI0.A5SV6n ARc23Z2 = f32kj0.ARc23Z(i2);
        BV3sI0.A5SV6n ARc23Z3 = fG7pZc2.f1747A2egSU.ARc23Z(i2);
        int min = Math.min(ARc23Z2.f1482A2egSU, ARc23Z3.f1482A2egSU);
        int i3 = ARc23Z2.f1483A4TApA;
        int i4 = ARc23Z3.f1483A4TApA;
        int min2 = Math.min(i3, i4);
        int i5 = ARc23Z2.f1484A5SV6n;
        int i6 = ARc23Z3.f1484A5SV6n;
        int min3 = Math.min(i5, i6);
        int i7 = ARc23Z2.f1485ADYaiT;
        int i8 = ARc23Z3.f1485ADYaiT;
        K1Z3yj.A2egSU a2egSU = new K1Z3yj.A2egSU(BV3sI0.A5SV6n.A4TApA(min, min2, min3, Math.min(i7, i8)), 8, BV3sI0.A5SV6n.A4TApA(Math.max(ARc23Z2.f1482A2egSU, ARc23Z3.f1482A2egSU), Math.max(i3, i4), Math.max(i5, i6), Math.max(i7, i8)));
        EGM26s.ARc23Z(view, windowInsets, false);
        duration.addUpdateListener(new DvK7DB(euirha, ASJ6gh2, fG7pZc2, i2, view));
        duration.addListener(new DyaChj(view, 0, (Object) euirha));
        BV3sI0.A4TApA(view, new C4FrIb.B4ZgIw(view, euirha, a2egSU, duration));
        this.f1705A4TApA = ASJ6gh2;
        return EGM26s.AZOQYO(view, windowInsets);
    }
}
