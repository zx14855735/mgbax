package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU implements IlwJBd.AYUAbz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final IlwJBd.AMqCpz f9945AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ImageView f9946AlLFFp;

    public AmA8tU(ImageView imageView) {
        ItGa5w.ARc23Z.A5SV6n(imageView, "Argument must not be null");
        this.f9946AlLFFp = imageView;
        this.f9945AcNBzu = new IlwJBd.AMqCpz(imageView);
    }

    @Override // IlwJBd.AYUAbz
    public final void A4TApA(IhMMDv.ASJ6gh aSJ6gh) {
        this.f9945AcNBzu.f4057A4TApA.remove(aSJ6gh);
    }

    @Override // IlwJBd.AYUAbz
    public final void ADYaiT(Object obj, IsbtnO.A4TApA a4TApA) {
    }

    @Override // IlwJBd.AYUAbz
    public final void AMqCpz(Drawable drawable) {
    }

    @Override // IlwJBd.AYUAbz
    public final void ARc23Z(IhMMDv.A5SV6n a5SV6n) {
        this.f9946AlLFFp.setTag(2131296706, a5SV6n);
    }

    @Override // IlwJBd.AYUAbz
    public final void ASJ6gh(Drawable drawable) {
    }

    @Override // IlwJBd.AYUAbz
    public final IhMMDv.A5SV6n AYUAbz() {
        Object tag = this.f9946AlLFFp.getTag(2131296706);
        if (tag == null) {
            return null;
        }
        if (tag instanceof IhMMDv.A5SV6n) {
            return (IhMMDv.A5SV6n) tag;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // IlwJBd.AYUAbz
    public final void AZOQYO(Drawable drawable) {
        IlwJBd.AMqCpz aMqCpz = this.f9945AcNBzu;
        ViewTreeObserver viewTreeObserver = aMqCpz.f4056A2egSU.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(aMqCpz.f4058A5SV6n);
        }
        aMqCpz.f4058A5SV6n = null;
        aMqCpz.f4057A4TApA.clear();
    }

    @Override // IlwJBd.AYUAbz
    public final void AZkASS(IhMMDv.ASJ6gh aSJ6gh) {
        IlwJBd.AMqCpz aMqCpz = this.f9945AcNBzu;
        ImageView imageView = aMqCpz.f4056A2egSU;
        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int A2egSU2 = aMqCpz.A2egSU(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        ImageView imageView2 = aMqCpz.f4056A2egSU;
        int paddingBottom = imageView2.getPaddingBottom() + imageView2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int A2egSU3 = aMqCpz.A2egSU(imageView2.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((A2egSU2 > 0 || A2egSU2 == Integer.MIN_VALUE) && (A2egSU3 > 0 || A2egSU3 == Integer.MIN_VALUE)) {
            aSJ6gh.AcNBzu(A2egSU2, A2egSU3);
            return;
        }
        ArrayList arrayList = aMqCpz.f4057A4TApA;
        if (!arrayList.contains(aSJ6gh)) {
            arrayList.add(aSJ6gh);
        }
        if (aMqCpz.f4058A5SV6n == null) {
            ViewTreeObserver viewTreeObserver = imageView2.getViewTreeObserver();
            IlwJBd.ADYaiT aDYaiT = new IlwJBd.ADYaiT(aMqCpz);
            aMqCpz.f4058A5SV6n = aDYaiT;
            viewTreeObserver.addOnPreDrawListener(aDYaiT);
        }
    }

    @Override // IQ76hF.AYUAbz
    public final void onDestroy() {
    }

    @Override // IQ76hF.AYUAbz
    public final void onStart() {
    }

    @Override // IQ76hF.AYUAbz
    public final void onStop() {
    }

    public final String toString() {
        return "Target for: " + this.f9946AlLFFp;
    }
}
