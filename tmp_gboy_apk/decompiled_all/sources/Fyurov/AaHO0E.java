package Fyurov;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ B25kr6 f2940A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ImageView f2941A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2942A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ B2KMhB f2943ADYaiT;

    public AaHO0E(B2KMhB b2KMhB, B25kr6 b25kr6, ImageView imageView, ArrayList arrayList) {
        this.f2943ADYaiT = b2KMhB;
        this.f2940A2egSU = b25kr6;
        this.f2941A4TApA = imageView;
        this.f2942A5SV6n = arrayList;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        B25kr6 b25kr6 = this.f2940A2egSU;
        b25kr6.f2957AmA8tU = floatValue;
        b25kr6.invalidate();
        B2KMhB b2KMhB = this.f2943ADYaiT;
        ImageView imageView = this.f2941A4TApA;
        imageView.setAlpha(1.0f);
        double d = b2KMhB.f2962A5SV6n;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2KMhB.A2egSU((float) (0.15d * d)), b2KMhB.A2egSU((float) (0.14d * d)));
        layoutParams.gravity = 8388691;
        layoutParams.setMargins(b2KMhB.A2egSU((float) (0.5d * d)), 0, 0, b2KMhB.A2egSU(floatValue - ((float) (d * 0.017d))));
        imageView.setLayoutParams(layoutParams);
        B2KMhB.ADYaiT(b2KMhB, floatValue, this.f2942A5SV6n, 1);
    }
}
