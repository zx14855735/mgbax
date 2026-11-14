package De4eam;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f2403A2egSU;

    public A5SV6n(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Margin must be non-negative");
        }
        this.f2403A2egSU = i;
    }

    @Override // De4eam.AaHO0E
    public final void transformPage(View view, float f) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if (!(parent instanceof RecyclerView) || !(parent2 instanceof ViewPager2)) {
            throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
        }
        ViewPager2 viewPager2 = (ViewPager2) parent2;
        float f2 = this.f2403A2egSU * f;
        if (viewPager2.getOrientation() != 0) {
            view.setTranslationY(f2);
            return;
        }
        if (viewPager2.f9591B3GDIM.getLayoutDirection() == 1) {
            f2 = -f2;
        }
        view.setTranslationX(f2);
    }
}
