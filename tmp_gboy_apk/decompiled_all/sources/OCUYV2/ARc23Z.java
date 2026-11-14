package OCUYV2;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DG07BK;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f6231A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ int f6232A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f6233A5SV6n;

    public ARc23Z(int i) {
        this.f6231A2egSU = i;
    }

    public final int A2egSU() {
        switch (this.f6232A4TApA) {
            case 0:
                return this.f6233A5SV6n.getHeight();
            default:
                CarouselLayoutManager carouselLayoutManager = this.f6233A5SV6n;
                return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
        }
    }

    public final int A4TApA() {
        switch (this.f6232A4TApA) {
            case 0:
                return this.f6233A5SV6n.getPaddingLeft();
            default:
                return 0;
        }
    }

    public final int A5SV6n() {
        switch (this.f6232A4TApA) {
            case 0:
                CarouselLayoutManager carouselLayoutManager = this.f6233A5SV6n;
                return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
            default:
                return this.f6233A5SV6n.getWidth();
        }
    }

    public final int ADYaiT() {
        switch (this.f6232A4TApA) {
            case 0:
                return 0;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f6233A5SV6n;
                if (carouselLayoutManager.B3GDIM()) {
                    return carouselLayoutManager.getWidth();
                }
                return 0;
        }
    }

    public final int AMqCpz() {
        switch (this.f6232A4TApA) {
            case 0:
                return 0;
            default:
                return this.f6233A5SV6n.getPaddingTop();
        }
    }

    public final void ARc23Z(View view, int i, int i2) {
        switch (this.f6232A4TApA) {
            case 0:
                CarouselLayoutManager carouselLayoutManager = this.f6233A5SV6n;
                int paddingLeft = carouselLayoutManager.getPaddingLeft();
                DG07BK dg07bk = (DG07BK) view.getLayoutParams();
                this.f6233A5SV6n.layoutDecoratedWithMargins(view, paddingLeft, i, carouselLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) dg07bk).leftMargin + ((ViewGroup.MarginLayoutParams) dg07bk).rightMargin + paddingLeft, i2);
                break;
            default:
                CarouselLayoutManager carouselLayoutManager2 = this.f6233A5SV6n;
                int paddingTop = carouselLayoutManager2.getPaddingTop();
                DG07BK dg07bk2 = (DG07BK) view.getLayoutParams();
                this.f6233A5SV6n.layoutDecoratedWithMargins(view, i, paddingTop, i2, carouselLayoutManager2.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) dg07bk2).topMargin + ((ViewGroup.MarginLayoutParams) dg07bk2).bottomMargin + paddingTop);
                break;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ARc23Z(CarouselLayoutManager carouselLayoutManager, int i) {
        this(1);
        this.f6232A4TApA = i;
        switch (i) {
            case 1:
                this.f6233A5SV6n = carouselLayoutManager;
                this(0);
                break;
            default:
                this.f6233A5SV6n = carouselLayoutManager;
                break;
        }
    }
}
