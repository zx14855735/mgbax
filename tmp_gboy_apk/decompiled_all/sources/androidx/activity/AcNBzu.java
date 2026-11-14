package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.BI9f7h;
import androidx.lifecycle.CQhlFr;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AcNBzu extends Dialog implements androidx.lifecycle.B9tovu, B9tovu, DV2E8K.ARc23Z {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public BI9f7h f7950AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final DV2E8K.AMqCpz f7951AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final OnBackPressedDispatcher f7952AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcNBzu(Context context, int i) {
        super(context, i);
        RXb0Sz.ARc23Z.AMqCpz(context, "context");
        this.f7951AlLFFp = new DV2E8K.AMqCpz(this);
        this.f7952AmA8tU = new OnBackPressedDispatcher(new CtFAbx.A2egSU(18, this));
    }

    public static void A2egSU(AcNBzu acNBzu) {
        RXb0Sz.ARc23Z.AMqCpz(acNBzu, "this$0");
        super.onBackPressed();
    }

    public final void A4TApA() {
        Window window = getWindow();
        RXb0Sz.ARc23Z.A4TApA(window);
        View decorView = window.getDecorView();
        RXb0Sz.ARc23Z.ADYaiT(decorView, "window!!.decorView");
        CQhlFr.ARc23Z(decorView, this);
        Window window2 = getWindow();
        RXb0Sz.ARc23Z.A4TApA(window2);
        View decorView2 = window2.getDecorView();
        RXb0Sz.ARc23Z.ADYaiT(decorView2, "window!!.decorView");
        JrXYwF.A4TApA.CtxOCS(decorView2, this);
        Window window3 = getWindow();
        RXb0Sz.ARc23Z.A4TApA(window3);
        View decorView3 = window3.getDecorView();
        RXb0Sz.ARc23Z.ADYaiT(decorView3, "window!!.decorView");
        JrXYwF.A4TApA.CtFAbx(decorView3, this);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        RXb0Sz.ARc23Z.AMqCpz(view, "view");
        A4TApA();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.lifecycle.B9tovu
    public final androidx.lifecycle.AzWtSf getLifecycle() {
        BI9f7h bI9f7h = this.f7950AcNBzu;
        if (bI9f7h != null) {
            return bI9f7h;
        }
        BI9f7h bI9f7h2 = new BI9f7h(this);
        this.f7950AcNBzu = bI9f7h2;
        return bI9f7h2;
    }

    @Override // androidx.activity.B9tovu
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f7952AmA8tU;
    }

    @Override // DV2E8K.ARc23Z
    public final DV2E8K.ADYaiT getSavedStateRegistry() {
        return this.f7951AlLFFp.f2197A4TApA;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f7952AmA8tU.A4TApA();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            RXb0Sz.ARc23Z.ADYaiT(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            OnBackPressedDispatcher onBackPressedDispatcher = this.f7952AmA8tU;
            onBackPressedDispatcher.getClass();
            onBackPressedDispatcher.AMqCpz = onBackInvokedDispatcher;
            onBackPressedDispatcher.A5SV6n(onBackPressedDispatcher.f7985ASJ6gh);
        }
        this.f7951AlLFFp.A4TApA(bundle);
        BI9f7h bI9f7h = this.f7950AcNBzu;
        if (bI9f7h == null) {
            bI9f7h = new BI9f7h(this);
            this.f7950AcNBzu = bI9f7h;
        }
        bI9f7h.ARc23Z(androidx.lifecycle.AlLFFp.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        RXb0Sz.ARc23Z.ADYaiT(onSaveInstanceState, "super.onSaveInstanceState()");
        this.f7951AlLFFp.A5SV6n(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BI9f7h bI9f7h = this.f7950AcNBzu;
        if (bI9f7h == null) {
            bI9f7h = new BI9f7h(this);
            this.f7950AcNBzu = bI9f7h;
        }
        bI9f7h.ARc23Z(androidx.lifecycle.AlLFFp.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        BI9f7h bI9f7h = this.f7950AcNBzu;
        if (bI9f7h == null) {
            bI9f7h = new BI9f7h(this);
            this.f7950AcNBzu = bI9f7h;
        }
        bI9f7h.ARc23Z(androidx.lifecycle.AlLFFp.ON_DESTROY);
        this.f7950AcNBzu = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        A4TApA();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        RXb0Sz.ARc23Z.AMqCpz(view, "view");
        A4TApA();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        RXb0Sz.ARc23Z.AMqCpz(view, "view");
        A4TApA();
        super.setContentView(view, layoutParams);
    }
}
