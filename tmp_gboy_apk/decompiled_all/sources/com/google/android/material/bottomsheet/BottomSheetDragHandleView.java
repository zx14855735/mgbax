package com.google.android.material.bottomsheet;

import COJEAR.DG07BK;
import GJee0v.AzWtSf;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final /* synthetic */ int f11447B9tovu = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AccessibilityManager f11448AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BottomSheetBehavior f11449AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final GestureDetector f11450AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f11451AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f11452B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f11453B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final String f11454B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final String f11455B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final ARc23Z f11456B7CMnp;

    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130968717, 2131952625), attributeSet, 2130968717);
        this.f11452B25kr6 = false;
        this.f11453B2KMhB = false;
        this.f11454B3GDIM = getResources().getString(2131886149);
        this.f11455B4ZgIw = getResources().getString(2131886148);
        this.f11456B7CMnp = new ARc23Z(this);
        AzWtSf azWtSf = new AzWtSf(3, this);
        Context context2 = getContext();
        this.f11450AmA8tU = new GestureDetector(context2, azWtSf, new Handler(Looper.getMainLooper()));
        this.f11448AcNBzu = (AccessibilityManager) context2.getSystemService("accessibility");
        DG07BK.B4ZgIw(this, new O1Vn2F.ADYaiT(1, this));
    }

    private void setBottomSheetBehavior(BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior bottomSheetBehavior2 = this.f11449AlLFFp;
        ARc23Z aRc23Z = this.f11456B7CMnp;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.f11439DcUJf1.remove(aRc23Z);
            this.f11449AlLFFp.B25kr6(null);
            this.f11449AlLFFp.DXuj49 = null;
        }
        this.f11449AlLFFp = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.B25kr6(this);
            BottomSheetBehavior bottomSheetBehavior3 = this.f11449AlLFFp;
            bottomSheetBehavior3.getClass();
            bottomSheetBehavior3.DXuj49 = new WeakReference(this);
            ADYaiT(this.f11449AlLFFp.f11427D6DOie);
            ArrayList arrayList = this.f11449AlLFFp.f11439DcUJf1;
            if (!arrayList.contains(aRc23Z)) {
                arrayList.add(aRc23Z);
            }
        }
        setClickable(this.f11449AlLFFp != null);
    }

    public final boolean A2egSU() {
        BottomSheetBehavior bottomSheetBehavior = this.f11449AlLFFp;
        if (!(bottomSheetBehavior != null)) {
            return false;
        }
        boolean z = bottomSheetBehavior.f11390AlLFFp;
        int i = bottomSheetBehavior.f11427D6DOie;
        int i2 = 6;
        if (i == 4) {
            if (z) {
                i2 = 3;
            }
        } else if (i != 3) {
            i2 = this.f11451AzWtSf ? 3 : 4;
        } else if (z) {
            i2 = 4;
        }
        bottomSheetBehavior.setState(i2);
        return true;
    }

    public final void ADYaiT(int i) {
        if (i == 4) {
            this.f11451AzWtSf = true;
        } else if (i == 3) {
            this.f11451AzWtSf = false;
        }
        DG07BK.B2KMhB(this, CQhlFr.A5SV6n.f1758ASJ6gh, this.f11451AzWtSf ? this.f11454B3GDIM : this.f11455B4ZgIw, new Cd8JRx.ADYaiT(7, this));
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        BottomSheetBehavior<?> bottomSheetBehavior;
        super.onAttachedToWindow();
        View view = this;
        while (true) {
            Object parent = view.getParent();
            bottomSheetBehavior = null;
            view = parent instanceof View ? (View) parent : null;
            if (view == null) {
                break;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof androidx.coordinatorlayout.widget.A5SV6n) {
                CoordinatorLayout.A2egSU a2egSU = ((androidx.coordinatorlayout.widget.A5SV6n) layoutParams).f8427A2egSU;
                if (a2egSU instanceof BottomSheetBehavior) {
                    bottomSheetBehavior = (BottomSheetBehavior) a2egSU;
                    break;
                }
            }
        }
        setBottomSheetBehavior(bottomSheetBehavior);
        AccessibilityManager accessibilityManager = this.f11448AcNBzu;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            accessibilityManager.isEnabled();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.f11448AcNBzu;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f11453B2KMhB || this.f11452B25kr6) ? super.onTouchEvent(motionEvent) : this.f11450AmA8tU.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11453B2KMhB = onClickListener != null;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f11452B25kr6 = onTouchListener != null;
        super.setOnTouchListener(onTouchListener);
    }
}
