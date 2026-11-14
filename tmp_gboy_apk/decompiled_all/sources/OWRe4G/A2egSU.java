package OWRe4G;

import PCV8se.AaHO0E;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends ViewOutlineProvider {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Rect f6450A2egSU = new Rect();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ShapeableImageView f6451A4TApA;

    public A2egSU(ShapeableImageView shapeableImageView) {
        this.f6451A4TApA = shapeableImageView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        ShapeableImageView shapeableImageView = this.f6451A4TApA;
        if (shapeableImageView.f11675B7CMnp == null) {
            return;
        }
        if (shapeableImageView.f11674B4ZgIw == null) {
            shapeableImageView.f11674B4ZgIw = new AaHO0E(shapeableImageView.f11675B7CMnp);
        }
        RectF rectF = shapeableImageView.f11668AlLFFp;
        Rect rect = this.f6450A2egSU;
        rectF.round(rect);
        shapeableImageView.f11674B4ZgIw.setBounds(rect);
        shapeableImageView.f11674B4ZgIw.getOutline(outline);
    }
}
