package PWIgQJ;

import Fyurov.AcNBzu;
import OLy1FW.AzWtSf;
import Oay4Bh.C4FrIb;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends LinearLayout {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final /* synthetic */ int f7283AzWtSf = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ValueAnimator f7284AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f7285AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ TabLayout f7286AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A5SV6n(TabLayout tabLayout, Context context) {
        super(context);
        this.f7286AmA8tU = tabLayout;
        this.f7285AlLFFp = -1;
        setWillNotDraw(false);
    }

    public final void A2egSU(int i) {
        TabLayout tabLayout = this.f7286AmA8tU;
        if (tabLayout.f11888DUi7mC == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
            View childAt = getChildAt(i);
            AzWtSf azWtSf = tabLayout.f11876CrfGsy;
            Drawable drawable = tabLayout.f11856BNL6CD;
            azWtSf.getClass();
            RectF A5SV6n2 = AzWtSf.A5SV6n(tabLayout, childAt);
            drawable.setBounds((int) A5SV6n2.left, drawable.getBounds().top, (int) A5SV6n2.right, drawable.getBounds().bottom);
            tabLayout.f11842AcNBzu = i;
        }
    }

    public final void A4TApA(int i) {
        TabLayout tabLayout = this.f7286AmA8tU;
        Rect bounds = tabLayout.f11856BNL6CD.getBounds();
        tabLayout.f11856BNL6CD.setBounds(bounds.left, 0, bounds.right, i);
        requestLayout();
    }

    public final void A5SV6n(View view, View view2, float f) {
        TabLayout tabLayout = this.f7286AmA8tU;
        if (view == null || view.getWidth() <= 0) {
            Drawable drawable = tabLayout.f11856BNL6CD;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.f11856BNL6CD.getBounds().bottom);
        } else {
            tabLayout.f11876CrfGsy.ARc23Z(tabLayout, view, view2, f, tabLayout.f11856BNL6CD);
        }
        postInvalidateOnAnimation();
    }

    public final void ADYaiT(int i, int i2, boolean z) {
        int i3 = 2;
        TabLayout tabLayout = this.f7286AmA8tU;
        if (tabLayout.f11842AcNBzu == i) {
            return;
        }
        View childAt = getChildAt(tabLayout.getSelectedTabPosition());
        View childAt2 = getChildAt(i);
        if (childAt2 == null) {
            A2egSU(tabLayout.getSelectedTabPosition());
            return;
        }
        tabLayout.f11842AcNBzu = i;
        AcNBzu acNBzu = new AcNBzu(this, childAt, childAt2, i3);
        if (!z) {
            this.f7284AcNBzu.removeAllUpdateListeners();
            this.f7284AcNBzu.addUpdateListener(acNBzu);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f7284AcNBzu = valueAnimator;
        valueAnimator.setInterpolator(tabLayout.f11877CtFAbx);
        valueAnimator.setDuration(i2);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(acNBzu);
        valueAnimator.start();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int height;
        TabLayout tabLayout = this.f7286AmA8tU;
        int height2 = tabLayout.f11856BNL6CD.getBounds().height();
        if (height2 < 0) {
            height2 = tabLayout.f11856BNL6CD.getIntrinsicHeight();
        }
        int i = tabLayout.f11869CTkVKb;
        if (i == 0) {
            height = getHeight() - height2;
            height2 = getHeight();
        } else if (i != 1) {
            height = 0;
            if (i != 2) {
                height2 = i != 3 ? 0 : getHeight();
            }
        } else {
            height = (getHeight() - height2) / 2;
            height2 = (getHeight() + height2) / 2;
        }
        if (tabLayout.f11856BNL6CD.getBounds().width() > 0) {
            Rect bounds = tabLayout.f11856BNL6CD.getBounds();
            tabLayout.f11856BNL6CD.setBounds(bounds.left, height, bounds.right, height2);
            tabLayout.f11856BNL6CD.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ValueAnimator valueAnimator = this.f7284AcNBzu;
        TabLayout tabLayout = this.f7286AmA8tU;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            ADYaiT(tabLayout.getSelectedTabPosition(), -1, false);
            return;
        }
        if (tabLayout.f11842AcNBzu == -1) {
            tabLayout.f11842AcNBzu = tabLayout.getSelectedTabPosition();
        }
        A2egSU(tabLayout.f11842AcNBzu);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.f7286AmA8tU;
        boolean z = true;
        if (tabLayout.f11867CQhlFr == 1 || tabLayout.f11870CcAIMM == 2) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0) {
                    i3 = Math.max(i3, childAt.getMeasuredWidth());
                }
            }
            if (i3 <= 0) {
                return;
            }
            if (i3 * childCount <= getMeasuredWidth() - (((int) C4FrIb.AYUAbz(getContext(), 16)) * 2)) {
                boolean z2 = false;
                for (int i5 = 0; i5 < childCount; i5++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                    if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                        layoutParams.width = i3;
                        layoutParams.weight = 0.0f;
                        z2 = true;
                    }
                }
                z = z2;
            } else {
                tabLayout.f11867CQhlFr = 0;
                tabLayout.B4ZgIw(false);
            }
            if (z) {
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (Build.VERSION.SDK_INT >= 23 || this.f7285AlLFFp == i) {
            return;
        }
        requestLayout();
        this.f7285AlLFFp = i;
    }
}
