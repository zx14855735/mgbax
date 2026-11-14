package com.google.android.material.bottomsheet;

import COJEAR.FG7pZc;
import COJEAR.FM663C;
import COJEAR.FOAO9d;
import COJEAR.FSFw2u;
import COJEAR.FdMWEC;
import OLy1FW.AYUAbz;
import PCV8se.AaHO0E;
import android.content.res.ColorStateList;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends BottomSheetBehavior.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Boolean f11373A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final FG7pZc f11374A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Window f11375A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f11376ADYaiT;

    public A5SV6n(View view, FG7pZc fG7pZc) {
        this.f11374A4TApA = fG7pZc;
        AaHO0E aaHO0E = BottomSheetBehavior.AaHO0E(view).f11397B7CMnp;
        ColorStateList backgroundTintList = aaHO0E != null ? aaHO0E.f7042AlLFFp.f7024ADYaiT : view.getBackgroundTintList();
        if (backgroundTintList != null) {
            this.f11373A2egSU = Boolean.valueOf(AYUAbz.AZkASS(backgroundTintList.getDefaultColor()));
            return;
        }
        ColorStateList C2rE4F2 = JrXYwF.A4TApA.C2rE4F(view.getBackground());
        Integer valueOf = C2rE4F2 != null ? Integer.valueOf(C2rE4F2.getDefaultColor()) : null;
        if (valueOf != null) {
            this.f11373A2egSU = Boolean.valueOf(AYUAbz.AZkASS(valueOf.intValue()));
        } else {
            this.f11373A2egSU = null;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.A2egSU
    public final void A2egSU(View view) {
        ADYaiT(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.A2egSU
    public final void A4TApA(View view) {
        ADYaiT(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.A2egSU
    public final void A5SV6n(int i, View view) {
        ADYaiT(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ADYaiT(View view) {
        FM663C fm663c;
        WindowInsetsController insetsController;
        FM663C fm663c2;
        WindowInsetsController insetsController2;
        int top = view.getTop();
        FG7pZc fG7pZc = this.f11374A4TApA;
        if (top < fG7pZc.ADYaiT()) {
            Window window = this.f11375A5SV6n;
            if (window != null) {
                Boolean bool = this.f11373A2egSU;
                boolean booleanValue = bool == null ? this.f11376ADYaiT : bool.booleanValue();
                KCxDWD.A5SV6n a5SV6n = new KCxDWD.A5SV6n(window.getDecorView());
                int i = Build.VERSION.SDK_INT;
                if (i >= 30) {
                    insetsController2 = window.getInsetsController();
                    FdMWEC fdMWEC = new FdMWEC(insetsController2, a5SV6n);
                    fdMWEC.f1752AcNBzu = window;
                    fm663c2 = fdMWEC;
                } else {
                    fm663c2 = i >= 26 ? new FSFw2u(window, a5SV6n) : i >= 23 ? new FOAO9d(window, a5SV6n) : new FM663C(window, a5SV6n);
                }
                fm663c2.D6yqiO(booleanValue);
            }
            view.setPadding(view.getPaddingLeft(), fG7pZc.ADYaiT() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            return;
        }
        if (view.getTop() != 0) {
            Window window2 = this.f11375A5SV6n;
            if (window2 != null) {
                boolean z = this.f11376ADYaiT;
                KCxDWD.A5SV6n a5SV6n2 = new KCxDWD.A5SV6n(window2.getDecorView());
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 30) {
                    insetsController = window2.getInsetsController();
                    FdMWEC fdMWEC2 = new FdMWEC(insetsController, a5SV6n2);
                    fdMWEC2.f1752AcNBzu = window2;
                    fm663c = fdMWEC2;
                } else {
                    fm663c = i2 >= 26 ? new FSFw2u(window2, a5SV6n2) : i2 >= 23 ? new FOAO9d(window2, a5SV6n2) : new FM663C(window2, a5SV6n2);
                }
                fm663c.D6yqiO(z);
            }
            view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void AMqCpz(Window window) {
        FM663C fm663c;
        WindowInsetsController insetsController;
        if (this.f11375A5SV6n == window) {
            return;
        }
        this.f11375A5SV6n = window;
        if (window != null) {
            KCxDWD.A5SV6n a5SV6n = new KCxDWD.A5SV6n(window.getDecorView());
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                insetsController = window.getInsetsController();
                FdMWEC fdMWEC = new FdMWEC(insetsController, a5SV6n);
                fdMWEC.f1752AcNBzu = window;
                fm663c = fdMWEC;
            } else {
                fm663c = i >= 26 ? new FSFw2u(window, a5SV6n) : i >= 23 ? new FOAO9d(window, a5SV6n) : new FM663C(window, a5SV6n);
            }
            this.f11376ADYaiT = fm663c.CcAIMM();
        }
    }
}
