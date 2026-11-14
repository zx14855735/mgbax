package Nm94Z2;

import COJEAR.FG7pZc;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.search.SearchBar;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ADYaiT extends AMqCpz {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Rect f6061AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Rect f6062AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f6063B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f6064B2KMhB;

    public ADYaiT() {
        this.f6061AmA8tU = new Rect();
        this.f6062AzWtSf = new Rect();
        this.f6063B25kr6 = 0;
    }

    @Override // Nm94Z2.AMqCpz
    public final void ASJ6gh(CoordinatorLayout coordinatorLayout, View view, int i) {
        AppBarLayout AYUAbz2 = AYUAbz(coordinatorLayout.ADYaiT(view));
        int i2 = 0;
        if (AYUAbz2 == null) {
            coordinatorLayout.AZkASS(i, view);
            this.f6063B25kr6 = 0;
            return;
        }
        androidx.coordinatorlayout.widget.A5SV6n a5SV6n = (androidx.coordinatorlayout.widget.A5SV6n) view.getLayoutParams();
        int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) a5SV6n).leftMargin;
        int bottom = AYUAbz2.getBottom() + ((ViewGroup.MarginLayoutParams) a5SV6n).topMargin;
        int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) a5SV6n).rightMargin;
        int bottom2 = ((AYUAbz2.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) a5SV6n).bottomMargin;
        Rect rect = this.f6061AmA8tU;
        rect.set(paddingLeft, bottom, width, bottom2);
        FG7pZc lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            rect.left = lastWindowInsets.A4TApA() + rect.left;
            rect.right -= lastWindowInsets.A5SV6n();
        }
        int i3 = a5SV6n.f8429A5SV6n;
        int i4 = i3 == 0 ? 8388659 : i3;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect2 = this.f6062AzWtSf;
        Gravity.apply(i4, measuredWidth, measuredHeight, rect, rect2, i);
        if (this.f6064B2KMhB != 0) {
            float AZOQYO2 = AZOQYO(AYUAbz2);
            int i5 = this.f6064B2KMhB;
            i2 = com.bumptech.glide.AMqCpz.B3GDIM((int) (AZOQYO2 * i5), 0, i5);
        }
        view.layout(rect2.left, rect2.top - i2, rect2.right, rect2.bottom - i2);
        this.f6063B25kr6 = rect2.top - AYUAbz2.getBottom();
    }

    public abstract AppBarLayout AYUAbz(ArrayList arrayList);

    public float AZOQYO(View view) {
        return 1.0f;
    }

    public int AZkASS(View view) {
        return view.getMeasuredHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        AppBarLayout AYUAbz2;
        FG7pZc lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (AYUAbz2 = AYUAbz(coordinatorLayout.ADYaiT(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (AYUAbz2.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.A2egSU() + lastWindowInsets.ADYaiT();
        }
        int AZkASS2 = AZkASS(AYUAbz2) + size;
        int measuredHeight = AYUAbz2.getMeasuredHeight();
        if (this instanceof SearchBar.ScrollingViewBehavior) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            AZkASS2 -= measuredHeight;
        }
        coordinatorLayout.AaHO0E(view, i, i2, View.MeasureSpec.makeMeasureSpec(AZkASS2, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    public ADYaiT(int i) {
        super(0);
        this.f6061AmA8tU = new Rect();
        this.f6062AzWtSf = new Rect();
        this.f6063B25kr6 = 0;
    }
}
