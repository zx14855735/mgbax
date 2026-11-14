package com.google.android.material.bottomsheet;

import ADYaiT.CqNSpT;
import ADYaiT.DUi7mC;
import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends CqNSpT {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public BottomSheetBehavior f11377B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public FrameLayout f11378B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public CoordinatorLayout f11379B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public FrameLayout f11380B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f11381B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f11382BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f11383BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public A5SV6n f11384BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f11385BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public DUi7mC f11386BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public A4TApA f11387BPw6Q8;

    public final void ARc23Z() {
        if (this.f11378B3GDIM == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), 2131492934, null);
            this.f11378B3GDIM = frameLayout;
            this.f11379B4ZgIw = (CoordinatorLayout) frameLayout.findViewById(2131296535);
            FrameLayout frameLayout2 = (FrameLayout) this.f11378B3GDIM.findViewById(2131296576);
            this.f11380B7CMnp = frameLayout2;
            BottomSheetBehavior AaHO0E2 = BottomSheetBehavior.AaHO0E(frameLayout2);
            this.f11377B2KMhB = AaHO0E2;
            A4TApA a4TApA = this.f11387BPw6Q8;
            ArrayList arrayList = AaHO0E2.f11439DcUJf1;
            if (!arrayList.contains(a4TApA)) {
                arrayList.add(a4TApA);
            }
            this.f11377B2KMhB.setHideable(this.f11381B9tovu);
            this.f11386BNL6CD = new DUi7mC(this.f11377B2KMhB, this.f11380B7CMnp);
        }
    }

    public final BottomSheetBehavior ASJ6gh() {
        if (this.f11377B2KMhB == null) {
            ARc23Z();
        }
        return this.f11377B2KMhB;
    }

    public final FrameLayout AYUAbz(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ARc23Z();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f11378B3GDIM.findViewById(2131296535);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f11385BJ7GGh) {
            FrameLayout frameLayout = this.f11378B3GDIM;
            A2egSU a2egSU = new A2egSU(this);
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            CmUvjW.B9tovu(frameLayout, a2egSU);
        }
        this.f11380B7CMnp.removeAllViews();
        if (layoutParams == null) {
            this.f11380B7CMnp.addView(view);
        } else {
            this.f11380B7CMnp.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(2131298117).setOnClickListener(new ADYaiT.A5SV6n(14, this));
        DG07BK.B4ZgIw(this.f11380B7CMnp, new O1Vn2F.ADYaiT(0, this));
        this.f11380B7CMnp.setOnTouchListener(new O1Vn2F.AMqCpz(0));
        return this.f11378B3GDIM;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        ASJ6gh();
        super.cancel();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.f11385BJ7GGh && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f11378B3GDIM;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.f11379B4ZgIw;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            com.bumptech.glide.A5SV6n.D8MqeW(window, !z);
            A5SV6n a5SV6n = this.f11384BIYEnU;
            if (a5SV6n != null) {
                a5SV6n.AMqCpz(window);
            }
        }
        DUi7mC dUi7mC = this.f11386BNL6CD;
        if (dUi7mC == null) {
            return;
        }
        if (this.f11381B9tovu) {
            dUi7mC.BChYOn(false);
        } else {
            dUi7mC.BIYEnU();
        }
    }

    @Override // ADYaiT.CqNSpT, androidx.activity.AcNBzu, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (Build.VERSION.SDK_INT < 23) {
                window.addFlags(TTAdConstant.KEY_CLICK_AREA);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        A5SV6n a5SV6n = this.f11384BIYEnU;
        if (a5SV6n != null) {
            a5SV6n.AMqCpz(null);
        }
        DUi7mC dUi7mC = this.f11386BNL6CD;
        if (dUi7mC != null) {
            dUi7mC.BIYEnU();
        }
    }

    @Override // androidx.activity.AcNBzu, android.app.Dialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.f11377B2KMhB;
        if (bottomSheetBehavior == null || bottomSheetBehavior.f11427D6DOie != 5) {
            return;
        }
        bottomSheetBehavior.setState(4);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean z) {
        DUi7mC dUi7mC;
        super.setCancelable(z);
        if (this.f11381B9tovu != z) {
            this.f11381B9tovu = z;
            BottomSheetBehavior bottomSheetBehavior = this.f11377B2KMhB;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
            if (getWindow() == null || (dUi7mC = this.f11386BNL6CD) == null) {
                return;
            }
            if (this.f11381B9tovu) {
                dUi7mC.BChYOn(false);
            } else {
                dUi7mC.BIYEnU();
            }
        }
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f11381B9tovu) {
            this.f11381B9tovu = true;
        }
        this.f11382BChYOn = z;
        this.f11383BI9f7h = true;
    }

    @Override // ADYaiT.CqNSpT, androidx.activity.AcNBzu, android.app.Dialog
    public final void setContentView(int i) {
        super.setContentView(AYUAbz(null, i, null));
    }

    @Override // ADYaiT.CqNSpT, androidx.activity.AcNBzu, android.app.Dialog
    public final void setContentView(View view) {
        super.setContentView(AYUAbz(view, 0, null));
    }

    @Override // ADYaiT.CqNSpT, androidx.activity.AcNBzu, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(AYUAbz(view, 0, layoutParams));
    }
}
