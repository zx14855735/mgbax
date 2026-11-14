package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO extends AZkASS {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final boolean f8739A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f8740ADYaiT;
    public C4FrIb AMqCpz;

    public AZOQYO(DyaChj dyaChj, C2rE4F.AMqCpz aMqCpz, boolean z) {
        super(dyaChj, aMqCpz);
        this.f8739A5SV6n = z;
    }

    public final C4FrIb A5SV6n(Context context) {
        Animation loadAnimation;
        C4FrIb c4FrIb;
        int DaOi9o2;
        if (this.f8740ADYaiT) {
            return this.AMqCpz;
        }
        DyaChj dyaChj = this.f8741A2egSU;
        boolean z = dyaChj.f8953A2egSU == 2;
        Fragment fragment = dyaChj.f8955A5SV6n;
        int nextTransition = fragment.getNextTransition();
        int popEnterAnim = this.f8739A5SV6n ? z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z ? fragment.getEnterAnim() : fragment.getExitAnim();
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        C4FrIb c4FrIb2 = null;
        if (viewGroup != null && viewGroup.getTag(2131298317) != null) {
            fragment.mContainer.setTag(2131298317, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, popEnterAnim);
            if (onCreateAnimation != null) {
                c4FrIb2 = new C4FrIb(onCreateAnimation);
            } else {
                Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, popEnterAnim);
                if (onCreateAnimator != null) {
                    c4FrIb2 = new C4FrIb(onCreateAnimator);
                } else {
                    if (popEnterAnim == 0 && nextTransition != 0) {
                        if (nextTransition == 4097) {
                            popEnterAnim = z ? 2130837513 : 2130837514;
                        } else if (nextTransition != 8194) {
                            if (nextTransition == 8197) {
                                DaOi9o2 = z ? JrXYwF.A4TApA.DaOi9o(context, R.attr.activityCloseEnterAnimation) : JrXYwF.A4TApA.DaOi9o(context, R.attr.activityCloseExitAnimation);
                            } else if (nextTransition == 4099) {
                                popEnterAnim = z ? 2130837511 : 2130837512;
                            } else if (nextTransition != 4100) {
                                popEnterAnim = -1;
                            } else {
                                DaOi9o2 = z ? JrXYwF.A4TApA.DaOi9o(context, R.attr.activityOpenEnterAnimation) : JrXYwF.A4TApA.DaOi9o(context, R.attr.activityOpenExitAnimation);
                            }
                            popEnterAnim = DaOi9o2;
                        } else {
                            popEnterAnim = z ? 2130837509 : 2130837510;
                        }
                    }
                    if (popEnterAnim != 0) {
                        boolean equals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                        try {
                            if (equals) {
                                try {
                                    loadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                                } catch (Resources.NotFoundException e) {
                                    throw e;
                                } catch (RuntimeException unused) {
                                }
                                if (loadAnimation != null) {
                                    c4FrIb = new C4FrIb(loadAnimation);
                                    c4FrIb2 = c4FrIb;
                                }
                            }
                            Animator loadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                            if (loadAnimator != null) {
                                c4FrIb = new C4FrIb(loadAnimator);
                                c4FrIb2 = c4FrIb;
                            }
                        } catch (RuntimeException e2) {
                            if (equals) {
                                throw e2;
                            }
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                            if (loadAnimation2 != null) {
                                c4FrIb2 = new C4FrIb(loadAnimation2);
                            }
                        }
                    }
                }
            }
        }
        this.AMqCpz = c4FrIb2;
        this.f8740ADYaiT = true;
        return c4FrIb2;
    }
}
