package LqstKO;

import COJEAR.BNL6CD;
import COJEAR.FG7pZc;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements BNL6CD {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f4933AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f4934AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f4935AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f4936AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Object f4937B25kr6;

    @Override // COJEAR.BNL6CD
    public FG7pZc B3GDIM(View view, FG7pZc fG7pZc) {
        BV3sI0.A5SV6n ARc23Z2 = fG7pZc.f1747A2egSU.ARc23Z(7);
        View view2 = (View) this.f4937B25kr6;
        int i = this.f4933AcNBzu;
        if (i >= 0) {
            view2.getLayoutParams().height = i + ARc23Z2.f1483A4TApA;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(this.f4934AlLFFp + ARc23Z2.f1482A2egSU, this.f4935AmA8tU + ARc23Z2.f1483A4TApA, this.f4936AzWtSf + ARc23Z2.f1484A5SV6n, view2.getPaddingBottom());
        return fG7pZc;
    }
}
