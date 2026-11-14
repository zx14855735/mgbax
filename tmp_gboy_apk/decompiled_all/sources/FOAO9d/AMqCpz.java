package FOAO9d;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.alliance.ssp.ad.template.SAAllianceContainerView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialFullScreenView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2581AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f2582AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ int f2583AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f2584AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ Object f2585B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final /* synthetic */ View f2586B2KMhB;

    public /* synthetic */ AMqCpz(Object obj, int i, int i2, Object obj2, View view, int i3) {
        this.f2581AcNBzu = i3;
        this.f2584AzWtSf = obj;
        this.f2582AlLFFp = i;
        this.f2583AmA8tU = i2;
        this.f2585B25kr6 = obj2;
        this.f2586B2KMhB = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DvK7DB.A4TApA a4TApA;
        switch (this.f2581AcNBzu) {
            case 0:
                AcNBzu acNBzu = (AcNBzu) this.f2584AzWtSf;
                int i = this.f2582AlLFFp;
                int i2 = this.f2583AmA8tU;
                String str = (String) this.f2585B25kr6;
                LinearLayout linearLayout = (LinearLayout) this.f2586B2KMhB;
                acNBzu.getClass();
                synchronized (AlLFFp.AMqCpz) {
                    try {
                        try {
                            AlLFFp alLFFp = acNBzu.f2607F1loUV;
                            if (alLFFp != null && (a4TApA = alLFFp.f2670A4TApA) != null) {
                                if (i != 0) {
                                    if (i == 1) {
                                        a4TApA.onAdShow();
                                    } else if (i == 2) {
                                        a4TApA.onAdClose();
                                    } else if (i == 3) {
                                        a4TApA.onRenderFail(i2, str);
                                    } else if (i == 4) {
                                        SAAllianceContainerView sAAllianceContainerView = new SAAllianceContainerView(GJee0v.A2egSU.A4TApA(acNBzu.f3185ARc23Z), acNBzu.EdQ5bb);
                                        sAAllianceContainerView.addView(linearLayout);
                                        acNBzu.f2607F1loUV.f2670A4TApA.onRenderSuccess(sAAllianceContainerView);
                                    }
                                } else if (acNBzu.f2611FM663C != 1) {
                                    a4TApA.onAdClick();
                                    acNBzu.DXnQ0V();
                                }
                            }
                        } catch (Exception unused) {
                        }
                    } finally {
                    }
                }
                return;
            default:
                ((InterstitialFullScreenView) this.f2584AzWtSf).lambda$setMediaView$3(this.f2582AlLFFp, this.f2583AmA8tU, (FrameLayout.LayoutParams) this.f2585B25kr6, this.f2586B2KMhB);
                return;
        }
    }
}
