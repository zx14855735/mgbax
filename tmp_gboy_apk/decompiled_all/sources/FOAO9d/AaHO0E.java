package FOAO9d;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f2596AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Context f2597AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f2598AmA8tU;

    public AaHO0E(AcNBzu acNBzu, LinearLayout linearLayout, Context context) {
        this.f2598AmA8tU = acNBzu;
        this.f2596AcNBzu = linearLayout;
        this.f2597AlLFFp = context;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        this.f2596AcNBzu.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        String ASJ6gh2 = NOd7IU.AlLFFp.ASJ6gh(i, "");
        AcNBzu acNBzu = this.f2598AmA8tU;
        acNBzu.f3234DAk1zC = ASJ6gh2;
        acNBzu.f3235DG07BK = NOd7IU.AlLFFp.ASJ6gh(i2, "");
        StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz.append(NOd7IU.AlLFFp.AMqCpz(this.f2597AlLFFp, acNBzu.f2602EmJGcg));
        acNBzu.f3236DRlcZ9 = AMqCpz.toString();
        StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz2.append(acNBzu.f2649Hjvs0g);
        acNBzu.f3237DUi7mC = AMqCpz2.toString();
    }
}
