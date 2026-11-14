package PWr3nF;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f7353A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ TextView f7354A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ int f7355A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ TextView f7356ADYaiT;
    public final /* synthetic */ B3GDIM AMqCpz;

    public B25kr6(B3GDIM b3gdim, int i, TextView textView, int i2, TextView textView2) {
        this.AMqCpz = b3gdim;
        this.f7353A2egSU = i;
        this.f7354A4TApA = textView;
        this.f7355A5SV6n = i2;
        this.f7356ADYaiT = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        AppCompatTextView appCompatTextView;
        int i = this.f7353A2egSU;
        B3GDIM b3gdim = this.AMqCpz;
        b3gdim.f7370AmA8tU = i;
        b3gdim.f7368AcNBzu = null;
        TextView textView = this.f7354A4TApA;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f7355A5SV6n == 1 && (appCompatTextView = b3gdim.f7374B3GDIM) != null) {
                appCompatTextView.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f7356ADYaiT;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f7356ADYaiT;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}
