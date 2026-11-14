package AaHO0E;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f598A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f599A4TApA;

    public /* synthetic */ A5SV6n(int i, Object obj) {
        this.f598A2egSU = i;
        this.f599A4TApA = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f598A2egSU) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f599A4TApA;
                actionBarOverlayLayout.f8130C4FrIb = null;
                actionBarOverlayLayout.f8118B9tovu = false;
                break;
            case 1:
                ((COJEAR.DjONCG) this.f599A4TApA).A2egSU();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f598A2egSU) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f599A4TApA;
                actionBarOverlayLayout.f8130C4FrIb = null;
                actionBarOverlayLayout.f8118B9tovu = false;
                break;
            case 1:
                ((COJEAR.DjONCG) this.f599A4TApA).A5SV6n();
                break;
            case 2:
                ((DaOi9o.B4ZgIw) this.f599A4TApA).AlLFFp();
                animator.removeListener(this);
                break;
            case 3:
                DcUJf1.ARc23Z aRc23Z = (DcUJf1.ARc23Z) this.f599A4TApA;
                ArrayList arrayList = new ArrayList(aRc23Z.f2326B25kr6);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((DcUJf1.A5SV6n) arrayList.get(i)).A2egSU(aRc23Z);
                }
                break;
            case 4:
                ((Fyurov.B2KMhB) this.f599A4TApA).f2968AZkASS.start();
                break;
            case 5:
                ((HideBottomViewOnScrollBehavior) this.f599A4TApA).f11329BI9f7h = null;
                break;
            case 6:
                ((HideViewOnScrollBehavior) this.f599A4TApA).f11341BI9f7h = null;
                break;
            case 7:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f599A4TApA;
                bottomSheetBehavior.B2KMhB(5);
                WeakReference weakReference = bottomSheetBehavior.f11436DV2E8K;
                if (weakReference != null && weakReference.get() != null) {
                    ((View) bottomSheetBehavior.f11436DV2E8K.get()).requestLayout();
                    break;
                }
                break;
            case 8:
            case 11:
            default:
                super.onAnimationEnd(animator);
                break;
            case 9:
                Ogw3zR.ARc23Z aRc23Z2 = (Ogw3zR.ARc23Z) this.f599A4TApA;
                aRc23Z2.f6638A4TApA.setTranslationY(0.0f);
                aRc23Z2.A4TApA(0.0f);
                break;
            case 10:
                View view = (View) this.f599A4TApA;
                if (view != null) {
                    view.setVisibility(0);
                    break;
                }
                break;
            case 12:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f599A4TApA;
                sideSheetBehavior.AMqCpz(5);
                WeakReference weakReference2 = sideSheetBehavior.f11803BPw6Q8;
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((View) sideSheetBehavior.f11803BPw6Q8.get()).requestLayout();
                    break;
                }
                break;
            case 13:
                super.onAnimationEnd(animator);
                PSeUZ5.ADYaiT aDYaiT = (PSeUZ5.ADYaiT) this.f599A4TApA;
                aDYaiT.getClass();
                ViewGroup AZkASS2 = Oay4Bh.C4FrIb.AZkASS(aDYaiT);
                ViewOverlay overlay = AZkASS2 == null ? null : AZkASS2.getOverlay();
                if (overlay != null) {
                    Iterator it = aDYaiT.f7192BI9f7h.iterator();
                    while (it.hasNext()) {
                        overlay.remove((PcHFaG.A4TApA) it.next());
                    }
                    break;
                }
                break;
            case 14:
                PWr3nF.AZkASS aZkASS = (PWr3nF.AZkASS) this.f599A4TApA;
                aZkASS.B2KMhB();
                aZkASS.f7321B3GDIM.start();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        switch (this.f598A2egSU) {
            case 8:
                super.onAnimationRepeat(animator);
                OdANhw.A2egSU a2egSU = (OdANhw.A2egSU) this.f599A4TApA;
                CtFAbx.ASJ6gh aSJ6gh = a2egSU.AMqCpz;
                int i = a2egSU.f6618A2egSU + 1;
                a2egSU.f6618A2egSU = i;
                aSJ6gh.A2egSU(i);
                break;
            case 11:
                super.onAnimationRepeat(animator);
                OvgpEe.AlLFFp alLFFp = (OvgpEe.AlLFFp) this.f599A4TApA;
                alLFFp.f6892B2KMhB = (alLFFp.f6892B2KMhB + 1) % alLFFp.f6891B25kr6.AMqCpz.length;
                alLFFp.f6893B3GDIM = true;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f598A2egSU) {
            case 1:
                ((COJEAR.DjONCG) this.f599A4TApA).A4TApA();
                break;
            case 2:
            default:
                super.onAnimationStart(animator);
                break;
            case 3:
                DcUJf1.ARc23Z aRc23Z = (DcUJf1.ARc23Z) this.f599A4TApA;
                ArrayList arrayList = new ArrayList(aRc23Z.f2326B25kr6);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((DcUJf1.A5SV6n) arrayList.get(i)).A4TApA(aRc23Z);
                }
                break;
        }
    }

    public A5SV6n(COJEAR.DjONCG djONCG, View view) {
        this.f598A2egSU = 1;
        this.f599A4TApA = djONCG;
    }
}
