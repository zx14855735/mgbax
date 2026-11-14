package COJEAR;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.sigmob.sdk.base.utils.n;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DyaChj extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f1701A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f1702A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ Object f1703A5SV6n;

    public /* synthetic */ DyaChj(View view, int i, Object obj) {
        this.f1701A2egSU = i;
        this.f1702A4TApA = obj;
        this.f1703A5SV6n = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f1701A2egSU) {
            case 0:
                ((EUIRHA) this.f1702A4TApA).f1716A2egSU.ADYaiT(1.0f);
                EGM26s.AMqCpz((View) this.f1703A5SV6n);
                break;
            case 1:
                ((B25kr6.ADYaiT) this.f1702A4TApA).remove(animator);
                ((DaOi9o.B4ZgIw) this.f1703A5SV6n).f2253BPw6Q8.remove(animator);
                break;
            case 2:
            default:
                super.onAnimationEnd(animator);
                break;
            case 3:
                OpB85q.B9tovu b9tovu = (OpB85q.B9tovu) this.f1703A5SV6n;
                DrawerLayout drawerLayout = (DrawerLayout) this.f1702A4TApA;
                drawerLayout.A5SV6n(b9tovu, false);
                drawerLayout.setScrimColor(n.f13223a);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f1701A2egSU) {
            case 1:
                ((DaOi9o.B4ZgIw) this.f1703A5SV6n).f2253BPw6Q8.add(animator);
                break;
            case 2:
                super.onAnimationStart(animator);
                ((Fyurov.B2KMhB) this.f1703A5SV6n).getClass();
                ((ImageView) this.f1702A4TApA).animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public /* synthetic */ DyaChj(Object obj, int i, Object obj2) {
        this.f1701A2egSU = i;
        this.f1703A5SV6n = obj;
        this.f1702A4TApA = obj2;
    }
}
