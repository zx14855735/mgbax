package OCUYV2;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.CASmeH;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends CASmeH {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f6228A2egSU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ADYaiT(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
        this.f6228A2egSU = carouselLayoutManager;
    }

    @Override // androidx.recyclerview.widget.CASmeH
    public final int calculateDxToMakeVisible(View view, int i) {
        CarouselLayoutManager carouselLayoutManager = this.f6228A2egSU;
        if (carouselLayoutManager.f11505ARc23Z == null || !carouselLayoutManager.B2KMhB()) {
            return 0;
        }
        int position = carouselLayoutManager.getPosition(view);
        return (int) (carouselLayoutManager.f11501A2egSU - carouselLayoutManager.AmA8tU(position, carouselLayoutManager.AcNBzu(position)));
    }

    @Override // androidx.recyclerview.widget.CASmeH
    public final int calculateDyToMakeVisible(View view, int i) {
        CarouselLayoutManager carouselLayoutManager = this.f6228A2egSU;
        if (carouselLayoutManager.f11505ARc23Z == null || carouselLayoutManager.B2KMhB()) {
            return 0;
        }
        int position = carouselLayoutManager.getPosition(view);
        return (int) (carouselLayoutManager.f11501A2egSU - carouselLayoutManager.AmA8tU(position, carouselLayoutManager.AcNBzu(position)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AZkASS
    public final PointF computeScrollVectorForPosition(int i) {
        return this.f6228A2egSU.computeScrollVectorForPosition(i);
    }
}
