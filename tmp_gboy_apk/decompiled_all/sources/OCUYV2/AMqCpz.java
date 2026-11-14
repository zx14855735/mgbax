package OCUYV2;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz extends RecyclerView.AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Paint f6229A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public List f6230A4TApA;

    public AMqCpz() {
        Paint paint = new Paint();
        this.f6229A2egSU = paint;
        this.f6230A4TApA = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AMqCpz
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E) {
        Canvas canvas2;
        super.onDrawOver(canvas, recyclerView, aaHO0E);
        Paint paint = this.f6229A2egSU;
        paint.setStrokeWidth(recyclerView.getResources().getDimension(2131165693));
        for (AcNBzu acNBzu : this.f6230A4TApA) {
            paint.setColor(BV3sI0.A2egSU.A4TApA(acNBzu.f6252A5SV6n, -65281, -16776961));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).B2KMhB()) {
                float AMqCpz = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f11509AZkASS.AMqCpz();
                float A2egSU2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f11509AZkASS.A2egSU();
                float f = acNBzu.f6251A4TApA;
                float f2 = acNBzu.f6251A4TApA;
                canvas2 = canvas;
                canvas2.drawLine(f, AMqCpz, f2, A2egSU2, paint);
            } else {
                float A4TApA2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f11509AZkASS.A4TApA();
                float A5SV6n2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f11509AZkASS.A5SV6n();
                float f3 = acNBzu.f6251A4TApA;
                float f4 = acNBzu.f6251A4TApA;
                canvas2 = canvas;
                canvas2.drawLine(A4TApA2, f4, A5SV6n2, f3, paint);
            }
            canvas = canvas2;
        }
    }
}
