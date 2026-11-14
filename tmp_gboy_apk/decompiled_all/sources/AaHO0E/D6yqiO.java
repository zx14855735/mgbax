package AaHO0E;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D6yqiO extends BTvldC.B2KMhB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f720A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ int f721A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ WeakReference f722A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ DRlcZ9 f723ADYaiT;

    public D6yqiO(DRlcZ9 dRlcZ9, int i, int i2, WeakReference weakReference) {
        this.f723ADYaiT = dRlcZ9;
        this.f720A2egSU = i;
        this.f721A4TApA = i2;
        this.f722A5SV6n = weakReference;
    }

    @Override // BTvldC.B2KMhB
    public final void A4TApA(int i) {
    }

    @Override // BTvldC.B2KMhB
    public final void A5SV6n(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.f720A2egSU) != -1) {
            typeface = DG07BK.A2egSU(typeface, i, (this.f721A4TApA & 2) != 0);
        }
        DRlcZ9 dRlcZ9 = this.f723ADYaiT;
        if (dRlcZ9.f739AlLFFp) {
            dRlcZ9.f738AcNBzu = typeface;
            TextView textView = (TextView) this.f722A5SV6n.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new D8MqeW(dRlcZ9.f736AZkASS, 0, textView, typeface));
                } else {
                    textView.setTypeface(typeface, dRlcZ9.f736AZkASS);
                }
            }
        }
    }
}
