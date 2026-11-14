package COJEAR;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BV3sI0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1650AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final View f1651AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ViewTreeObserver f1652AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Runnable f1653AzWtSf;

    public BV3sI0(View view, Runnable runnable, int i) {
        this.f1650AcNBzu = i;
        switch (i) {
            case 1:
                this.f1651AlLFFp = view;
                this.f1652AmA8tU = view.getViewTreeObserver();
                this.f1653AzWtSf = runnable;
                break;
            default:
                this.f1651AlLFFp = view;
                this.f1652AmA8tU = view.getViewTreeObserver();
                this.f1653AzWtSf = runnable;
                break;
        }
    }

    public static void A2egSU(View view, Runnable runnable) {
        BV3sI0 bV3sI0 = new BV3sI0(view, runnable, 1);
        view.getViewTreeObserver().addOnPreDrawListener(bV3sI0);
        view.addOnAttachStateChangeListener(bV3sI0);
    }

    public static void A4TApA(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        BV3sI0 bV3sI0 = new BV3sI0(view, runnable, 0);
        view.getViewTreeObserver().addOnPreDrawListener(bV3sI0);
        view.addOnAttachStateChangeListener(bV3sI0);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f1650AcNBzu) {
            case 0:
                boolean isAlive = this.f1652AmA8tU.isAlive();
                View view = this.f1651AlLFFp;
                if (isAlive) {
                    this.f1652AmA8tU.removeOnPreDrawListener(this);
                } else {
                    view.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                view.removeOnAttachStateChangeListener(this);
                this.f1653AzWtSf.run();
                break;
            default:
                boolean isAlive2 = this.f1652AmA8tU.isAlive();
                View view2 = this.f1651AlLFFp;
                if (isAlive2) {
                    this.f1652AmA8tU.removeOnPreDrawListener(this);
                } else {
                    view2.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                view2.removeOnAttachStateChangeListener(this);
                this.f1653AzWtSf.run();
                break;
        }
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.f1650AcNBzu) {
            case 0:
                this.f1652AmA8tU = view.getViewTreeObserver();
                break;
            default:
                this.f1652AmA8tU = view.getViewTreeObserver();
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f1650AcNBzu) {
            case 0:
                boolean isAlive = this.f1652AmA8tU.isAlive();
                View view2 = this.f1651AlLFFp;
                if (isAlive) {
                    this.f1652AmA8tU.removeOnPreDrawListener(this);
                } else {
                    view2.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                view2.removeOnAttachStateChangeListener(this);
                break;
            default:
                boolean isAlive2 = this.f1652AmA8tU.isAlive();
                View view3 = this.f1651AlLFFp;
                if (isAlive2) {
                    this.f1652AmA8tU.removeOnPreDrawListener(this);
                } else {
                    view3.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                view3.removeOnAttachStateChangeListener(this);
                break;
        }
    }
}
