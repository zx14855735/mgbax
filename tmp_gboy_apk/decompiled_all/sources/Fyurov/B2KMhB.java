package Fyurov;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Context f2960A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f2961A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f2962A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public double f2963ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public FdMWEC.AYUAbz f2964ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public FrameLayout f2965ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public TextView f2966AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public TextView f2967AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public AnimatorSet f2968AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public float f2969AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public float f2970AcNBzu;

    public static void ADYaiT(B2KMhB b2KMhB, float f, ArrayList arrayList, int i) {
        ImageView imageView = (ImageView) arrayList.get(0);
        ImageView imageView2 = (ImageView) arrayList.get(1);
        ImageView imageView3 = (ImageView) arrayList.get(2);
        ImageView imageView4 = (ImageView) arrayList.get(3);
        if (i == 1) {
            if (0.0f < f && f < 10.0f) {
                imageView.setAlpha(0.3f);
                return;
            }
            if (10.0f < f && f < 20.0f) {
                imageView2.setAlpha(0.6f);
                return;
            } else {
                if (20.0f >= f || f >= 30.0f) {
                    return;
                }
                imageView3.setAlpha(0.9f);
                return;
            }
        }
        if (i == 2) {
            if (0.0f < f && f < 10.0f) {
                imageView.setAlpha(0.0f);
                return;
            }
            if (10.0f < f && f < 20.0f) {
                imageView2.setAlpha(0.0f);
                return;
            } else {
                if (20.0f >= f || f >= 30.0f) {
                    return;
                }
                imageView3.setAlpha(0.0f);
                return;
            }
        }
        if (i == 3) {
            if (0.0f < f && f < 10.0f) {
                imageView4.setAlpha(0.9f);
                return;
            }
            if (10.0f < f && f < 20.0f) {
                imageView3.setAlpha(0.6f);
                return;
            } else {
                if (20.0f >= f || f >= 30.0f) {
                    return;
                }
                imageView2.setAlpha(0.3f);
                return;
            }
        }
        if (i != 4) {
            return;
        }
        if (0.0f < f && f < 10.0f) {
            imageView2.setAlpha(0.0f);
            return;
        }
        if (10.0f < f && f < 20.0f) {
            imageView3.setAlpha(0.0f);
        } else {
            if (20.0f >= f || f >= 30.0f) {
                return;
            }
            imageView4.setAlpha(0.0f);
        }
    }

    public final int A2egSU(float f) {
        Context context = this.f2960A2egSU;
        if (context == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
        } else {
            f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f;
    }

    public final ImageView A4TApA(int i, FrameLayout frameLayout) {
        Context context = this.f2960A2egSU;
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), 2131231447));
        double d = this.f2962A5SV6n;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(A2egSU((float) (0.08d * d)), A2egSU((float) (d * 0.05d)));
        layoutParams.gravity = 81;
        layoutParams.setMargins(0, 0, 0, A2egSU(i));
        imageView.setLayoutParams(layoutParams);
        imageView.setAlpha(0.0f);
        frameLayout.addView(imageView);
        return imageView;
    }

    public final LinearLayout A5SV6n(float f) {
        LinearLayout linearLayout = new LinearLayout(this.f2960A2egSU);
        LinearLayout.LayoutParams layoutParams = f > 0.0f ? new LinearLayout.LayoutParams(-1, 0, f) : new LinearLayout.LayoutParams(-1, 0);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public final void AMqCpz(ViewGroup viewGroup, boolean z) {
        viewGroup.setClickable(true);
        viewGroup.setOnTouchListener(new AzWtSf(this, z));
    }
}
