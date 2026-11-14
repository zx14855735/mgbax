package IlwJBd;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends A2egSU {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ImageView f4046AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AZOQYO f4047AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Animatable f4048AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ int f4049B25kr6;

    public A4TApA(ImageView imageView, int i) {
        this.f4049B25kr6 = i;
        ItGa5w.ARc23Z.A5SV6n(imageView, "Argument must not be null");
        this.f4046AlLFFp = imageView;
        this.f4047AmA8tU = new AZOQYO(imageView);
    }

    public final void A2egSU(Object obj) {
        switch (this.f4049B25kr6) {
            case 0:
                this.f4046AlLFFp.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.f4046AlLFFp.setImageDrawable((Drawable) obj);
                break;
        }
    }

    @Override // IlwJBd.AYUAbz
    public final void A4TApA(IhMMDv.ASJ6gh aSJ6gh) {
        this.f4047AmA8tU.f4061A4TApA.remove(aSJ6gh);
    }

    @Override // IlwJBd.AYUAbz
    public final void ADYaiT(Object obj, IsbtnO.A4TApA a4TApA) {
        if (a4TApA != null && a4TApA.AMqCpz(obj, this)) {
            if (!(obj instanceof Animatable)) {
                this.f4048AzWtSf = null;
                return;
            }
            Animatable animatable = (Animatable) obj;
            this.f4048AzWtSf = animatable;
            animatable.start();
            return;
        }
        A2egSU(obj);
        if (!(obj instanceof Animatable)) {
            this.f4048AzWtSf = null;
            return;
        }
        Animatable animatable2 = (Animatable) obj;
        this.f4048AzWtSf = animatable2;
        animatable2.start();
    }

    @Override // IlwJBd.A2egSU, IlwJBd.AYUAbz
    public final void AMqCpz(Drawable drawable) {
        A2egSU(null);
        this.f4048AzWtSf = null;
        this.f4046AlLFFp.setImageDrawable(drawable);
    }

    @Override // IlwJBd.A2egSU, IlwJBd.AYUAbz
    public final void ARc23Z(IhMMDv.A5SV6n a5SV6n) {
        this.f4046AlLFFp.setTag(2131296706, a5SV6n);
    }

    @Override // IlwJBd.A2egSU, IlwJBd.AYUAbz
    public final void ASJ6gh(Drawable drawable) {
        A2egSU(null);
        this.f4048AzWtSf = null;
        this.f4046AlLFFp.setImageDrawable(drawable);
    }

    @Override // IlwJBd.A2egSU, IlwJBd.AYUAbz
    public final IhMMDv.A5SV6n AYUAbz() {
        Object tag = this.f4046AlLFFp.getTag(2131296706);
        if (tag == null) {
            return null;
        }
        if (tag instanceof IhMMDv.A5SV6n) {
            return (IhMMDv.A5SV6n) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // IlwJBd.A2egSU, IlwJBd.AYUAbz
    public final void AZOQYO(Drawable drawable) {
        AZOQYO azoqyo = this.f4047AmA8tU;
        ViewTreeObserver viewTreeObserver = azoqyo.f4060A2egSU.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(azoqyo.f4062A5SV6n);
        }
        azoqyo.f4062A5SV6n = null;
        azoqyo.f4061A4TApA.clear();
        Animatable animatable = this.f4048AzWtSf;
        if (animatable != null) {
            animatable.stop();
        }
        A2egSU(null);
        this.f4048AzWtSf = null;
        this.f4046AlLFFp.setImageDrawable(drawable);
    }

    @Override // IlwJBd.AYUAbz
    public final void AZkASS(IhMMDv.ASJ6gh aSJ6gh) {
        AZOQYO azoqyo = this.f4047AmA8tU;
        ImageView imageView = azoqyo.f4060A2egSU;
        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int A2egSU2 = azoqyo.A2egSU(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        ImageView imageView2 = azoqyo.f4060A2egSU;
        int paddingBottom = imageView2.getPaddingBottom() + imageView2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int A2egSU3 = azoqyo.A2egSU(imageView2.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((A2egSU2 > 0 || A2egSU2 == Integer.MIN_VALUE) && (A2egSU3 > 0 || A2egSU3 == Integer.MIN_VALUE)) {
            aSJ6gh.AcNBzu(A2egSU2, A2egSU3);
            return;
        }
        ArrayList arrayList = azoqyo.f4061A4TApA;
        if (!arrayList.contains(aSJ6gh)) {
            arrayList.add(aSJ6gh);
        }
        if (azoqyo.f4062A5SV6n == null) {
            ViewTreeObserver viewTreeObserver = imageView2.getViewTreeObserver();
            ADYaiT aDYaiT = new ADYaiT(azoqyo);
            azoqyo.f4062A5SV6n = aDYaiT;
            viewTreeObserver.addOnPreDrawListener(aDYaiT);
        }
    }

    @Override // IlwJBd.A2egSU, IQ76hF.AYUAbz
    public final void onStart() {
        Animatable animatable = this.f4048AzWtSf;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // IlwJBd.A2egSU, IQ76hF.AYUAbz
    public final void onStop() {
        Animatable animatable = this.f4048AzWtSf;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final String toString() {
        return "Target for: " + this.f4046AlLFFp;
    }
}
