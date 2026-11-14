package OCUYV2;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A5SV6n implements View.OnLayoutChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6226AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f6227AlLFFp;

    public /* synthetic */ A5SV6n(int i, Object obj) {
        this.f6226AcNBzu = i;
        this.f6227AlLFFp = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean z;
        NpX2pY.A2egSU a2egSU;
        switch (this.f6226AcNBzu) {
            case 0:
                CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) this.f6227AlLFFp;
                if (i3 - i != i7 - i5 || i4 - i2 != i8 - i6) {
                    view.post(new CtFAbx.A2egSU(6, carouselLayoutManager));
                    break;
                }
                break;
            case 1:
                CarouselLayoutManager carouselLayoutManager2 = (CarouselLayoutManager) this.f6227AlLFFp;
                carouselLayoutManager2.getClass();
                if (i3 - i != i7 - i5 || i4 - i2 != i8 - i6) {
                    view.post(new CtFAbx.A2egSU(6, carouselLayoutManager2));
                    break;
                }
                break;
            default:
                OpB85q.ARc23Z aRc23Z = (OpB85q.ARc23Z) this.f6227AlLFFp;
                ImageView imageView = aRc23Z.f6687BniPrB;
                if (imageView.getVisibility() == 0 && (a2egSU = aRc23Z.f6716DXnQ0V) != null) {
                    Rect rect = new Rect();
                    imageView.getDrawingRect(rect);
                    a2egSU.setBounds(rect);
                    a2egSU.AZkASS(imageView, null);
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aRc23Z.f6684BTvldC.getLayoutParams();
                int i9 = (i3 - i) + layoutParams.rightMargin + layoutParams.leftMargin;
                int i10 = (i4 - i2) + layoutParams.topMargin + layoutParams.bottomMargin;
                boolean z2 = true;
                if (aRc23Z.DXuj49 == 1 && aRc23Z.f6711DAk1zC == -2) {
                    View view2 = aRc23Z.f6685BV3sI0;
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view2.getLayoutParams();
                    if (aRc23Z.f6711DAk1zC != -2 || view2.getMeasuredWidth() == i9) {
                        z = false;
                    } else {
                        layoutParams2.width = Math.max(i9, Math.min(aRc23Z.f6709D8cQ8b, aRc23Z.getMeasuredWidth() - (aRc23Z.f6714DUi7mC * 2)));
                        z = true;
                    }
                    if (view2.getMeasuredHeight() < i10) {
                        layoutParams2.height = i10;
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        view2.setLayoutParams(layoutParams2);
                        break;
                    }
                }
                break;
        }
    }
}
