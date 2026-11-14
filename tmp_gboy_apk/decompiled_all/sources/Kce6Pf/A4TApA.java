package Kce6Pf;

import android.graphics.drawable.Drawable;
import com.fl.saas.base.inner.spread.coustomView.SpreadVerticalView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4258AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ SpreadVerticalView f4259AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Drawable f4260AmA8tU;

    public /* synthetic */ A4TApA(SpreadVerticalView spreadVerticalView, Drawable drawable, int i) {
        this.f4258AcNBzu = i;
        this.f4259AlLFFp = spreadVerticalView;
        this.f4260AmA8tU = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4258AcNBzu) {
            case 0:
                this.f4259AlLFFp.lambda$setMediaView$1(this.f4260AmA8tU);
                break;
            default:
                this.f4259AlLFFp.lambda$setMediaView$2(this.f4260AmA8tU);
                break;
        }
    }
}
