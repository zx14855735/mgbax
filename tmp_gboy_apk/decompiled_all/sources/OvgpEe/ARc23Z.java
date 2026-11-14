package OvgpEe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6848A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh f6849A4TApA;

    public /* synthetic */ ARc23Z(ASJ6gh aSJ6gh, int i) {
        this.f6848A2egSU = i;
        this.f6849A4TApA = aSJ6gh;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f6848A2egSU) {
            case 1:
                super.onAnimationEnd(animator);
                ASJ6gh aSJ6gh = this.f6849A4TApA;
                super/*android.graphics.drawable.Drawable*/.setVisible(false, false);
                ArrayList arrayList = aSJ6gh.f6857B3GDIM;
                if (arrayList != null && !aSJ6gh.f6858B4ZgIw) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((DcUJf1.A5SV6n) it.next()).A2egSU(aSJ6gh);
                    }
                    break;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f6848A2egSU) {
            case 0:
                super.onAnimationStart(animator);
                ASJ6gh aSJ6gh = this.f6849A4TApA;
                ArrayList arrayList = aSJ6gh.f6857B3GDIM;
                if (arrayList != null && !aSJ6gh.f6858B4ZgIw) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((DcUJf1.A5SV6n) it.next()).A4TApA(aSJ6gh);
                    }
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
