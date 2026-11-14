package androidx.fragment.app;

import COJEAR.FG7pZc;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f8963AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f8964AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f8965AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f8966AzWtSf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        String str;
        RXb0Sz.ARc23Z.AMqCpz(context, "context");
        this.f8963AcNBzu = new ArrayList();
        this.f8964AlLFFp = new ArrayList();
        this.f8966AzWtSf = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8701A4TApA, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    public final void A2egSU(View view) {
        if (this.f8964AlLFFp.contains(view)) {
            this.f8963AcNBzu.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        RXb0Sz.ARc23Z.AMqCpz(view, "child");
        Object tag = view.getTag(2131296696);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        FG7pZc AmA8tU2;
        RXb0Sz.ARc23Z.AMqCpz(windowInsets, "insets");
        FG7pZc ASJ6gh2 = FG7pZc.ASJ6gh(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f8965AmA8tU;
        if (onApplyWindowInsetsListener != null) {
            RXb0Sz.ARc23Z.A4TApA(onApplyWindowInsetsListener);
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            RXb0Sz.ARc23Z.ADYaiT(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            AmA8tU2 = FG7pZc.ASJ6gh(null, onApplyWindowInsets);
        } else {
            AmA8tU2 = COJEAR.DG07BK.AmA8tU(this, ASJ6gh2);
        }
        RXb0Sz.ARc23Z.ADYaiT(AmA8tU2, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!AmA8tU2.f1747A2egSU.AlLFFp()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                COJEAR.DG07BK.A4TApA(getChildAt(i), AmA8tU2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        RXb0Sz.ARc23Z.AMqCpz(canvas, "canvas");
        if (this.f8966AzWtSf) {
            Iterator it = this.f8963AcNBzu.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        RXb0Sz.ARc23Z.AMqCpz(canvas, "canvas");
        RXb0Sz.ARc23Z.AMqCpz(view, "child");
        if (this.f8966AzWtSf) {
            ArrayList arrayList = this.f8963AcNBzu;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        RXb0Sz.ARc23Z.AMqCpz(view, "view");
        this.f8964AlLFFp.remove(view);
        if (this.f8963AcNBzu.remove(view)) {
            this.f8966AzWtSf = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        FragmentActivity fragmentActivity;
        Fragment fragment;
        CtxOCS supportFragmentManager;
        View view = this;
        while (true) {
            fragmentActivity = null;
            if (view == null) {
                fragment = null;
                break;
            }
            Object tag = view.getTag(2131296696);
            fragment = tag instanceof Fragment ? (Fragment) tag : null;
            if (fragment != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (fragment == null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (fragmentActivity == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        } else {
            if (!fragment.isAdded()) {
                throw new IllegalStateException("The Fragment " + fragment + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            supportFragmentManager = fragment.getChildFragmentManager();
        }
        return (F) supportFragmentManager.BPw6Q8(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        RXb0Sz.ARc23Z.AMqCpz(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                RXb0Sz.ARc23Z.ADYaiT(childAt, "view");
                A2egSU(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        RXb0Sz.ARc23Z.AMqCpz(view, "view");
        A2egSU(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        RXb0Sz.ARc23Z.ADYaiT(childAt, "view");
        A2egSU(childAt);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        RXb0Sz.ARc23Z.AMqCpz(view, "view");
        A2egSU(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            RXb0Sz.ARc23Z.ADYaiT(childAt, "view");
            A2egSU(childAt);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            RXb0Sz.ARc23Z.ADYaiT(childAt, "view");
            A2egSU(childAt);
        }
        super.removeViewsInLayout(i, i2);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.f8966AzWtSf = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        RXb0Sz.ARc23Z.AMqCpz(onApplyWindowInsetsListener, "listener");
        this.f8965AmA8tU = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        RXb0Sz.ARc23Z.AMqCpz(view, "view");
        if (view.getParent() == this) {
            this.f8964AlLFFp.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, CtxOCS ctxOCS) {
        super(context, attributeSet);
        View view;
        RXb0Sz.ARc23Z.AMqCpz(context, "context");
        RXb0Sz.ARc23Z.AMqCpz(attributeSet, "attrs");
        this.f8963AcNBzu = new ArrayList();
        this.f8964AlLFFp = new ArrayList();
        this.f8966AzWtSf = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8701A4TApA, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment BPw6Q82 = ctxOCS.BPw6Q8(id);
        if (classAttribute != null && BPw6Q82 == null) {
            if (id == -1) {
                throw new IllegalStateException(ADYaiT.CtFAbx.BI9f7h("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            Fragment A2egSU2 = ctxOCS.BpkvW3().A2egSU(context.getClassLoader(), classAttribute);
            RXb0Sz.ARc23Z.ADYaiT(A2egSU2, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            A2egSU2.onInflate(context, attributeSet, (Bundle) null);
            A2egSU a2egSU = new A2egSU(ctxOCS);
            a2egSU.f8931B25kr6 = true;
            A2egSU2.mContainer = this;
            a2egSU.AZOQYO(getId(), A2egSU2, string, 1);
            a2egSU.ARc23Z();
        }
        Iterator it = ctxOCS.f8831A5SV6n.ADYaiT().iterator();
        while (it.hasNext()) {
            DUi7mC dUi7mC = (DUi7mC) it.next();
            Fragment fragment = dUi7mC.f8903A5SV6n;
            if (fragment.mContainerId == getId() && (view = fragment.mView) != null && view.getParent() == null) {
                fragment.mContainer = this;
                dUi7mC.A2egSU();
            }
        }
    }
}
