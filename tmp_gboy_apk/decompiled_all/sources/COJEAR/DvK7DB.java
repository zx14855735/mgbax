package COJEAR;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DvK7DB implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ EUIRHA f1697A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ FG7pZc f1698A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ FG7pZc f1699A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ int f1700ADYaiT;
    public final /* synthetic */ View AMqCpz;

    public DvK7DB(EUIRHA euirha, FG7pZc fG7pZc, FG7pZc fG7pZc2, int i, View view) {
        this.f1697A2egSU = euirha;
        this.f1698A4TApA = fG7pZc;
        this.f1699A5SV6n = fG7pZc2;
        this.f1700ADYaiT = i;
        this.AMqCpz = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        EUIRHA euirha = this.f1697A2egSU;
        euirha.f1716A2egSU.ADYaiT(animatedFraction);
        float A4TApA2 = euirha.f1716A2egSU.A4TApA();
        PathInterpolator pathInterpolator = EGM26s.AMqCpz;
        FG7pZc fG7pZc = this.f1698A4TApA;
        EdQ5bb edQ5bb = new EdQ5bb(fG7pZc);
        int i = 1;
        while (true) {
            EmJGcg emJGcg = edQ5bb.f1721A2egSU;
            if (i > 256) {
                EGM26s.ASJ6gh(this.AMqCpz, emJGcg.A4TApA(), Collections.singletonList(euirha));
                return;
            }
            int i2 = this.f1700ADYaiT & i;
            F32kj0 f32kj0 = fG7pZc.f1747A2egSU;
            if (i2 == 0) {
                emJGcg.A5SV6n(i, f32kj0.ARc23Z(i));
            } else {
                BV3sI0.A5SV6n ARc23Z2 = f32kj0.ARc23Z(i);
                BV3sI0.A5SV6n ARc23Z3 = this.f1699A5SV6n.f1747A2egSU.ARc23Z(i);
                float f = 1.0f - A4TApA2;
                emJGcg.A5SV6n(i, FG7pZc.AMqCpz(ARc23Z2, (int) (((ARc23Z2.f1482A2egSU - ARc23Z3.f1482A2egSU) * f) + 0.5d), (int) (((ARc23Z2.f1483A4TApA - ARc23Z3.f1483A4TApA) * f) + 0.5d), (int) (((ARc23Z2.f1484A5SV6n - ARc23Z3.f1484A5SV6n) * f) + 0.5d), (int) (((ARc23Z2.f1485ADYaiT - ARc23Z3.f1485ADYaiT) * f) + 0.5d)));
            }
            i <<= 1;
        }
    }
}
