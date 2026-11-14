package COJEAR;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.base.builder.InnerBannerBuilder;
import com.fl.saas.base.base.builder.InnerDrawVideoBuilder;
import com.fl.saas.base.base.builder.InnerFullVideoBuilder;
import com.fl.saas.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.base.base.builder.InnerNativeBuilder;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper;
import com.google.android.material.carousel.MaskableFrameLayout;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AZOQYO implements DaOi9o.B9tovu, AmA8tU.A2egSU, Predicate, PCV8se.B3GDIM, PWr3nF.BIYEnU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1625AcNBzu;

    public /* synthetic */ AZOQYO(int i) {
        this.f1625AcNBzu = i;
    }

    @Override // DaOi9o.B9tovu
    public void A2egSU(DaOi9o.B7CMnp b7CMnp, DaOi9o.B4ZgIw b4ZgIw) {
        switch (this.f1625AcNBzu) {
            case 2:
                b7CMnp.ASJ6gh(b4ZgIw);
                break;
            case 3:
                b7CMnp.A2egSU(b4ZgIw);
                break;
            case 4:
                b7CMnp.A5SV6n(b4ZgIw);
                break;
            case 5:
                b7CMnp.A4TApA();
                break;
            default:
                b7CMnp.AMqCpz();
                break;
        }
    }

    @Override // PCV8se.B3GDIM
    public PCV8se.ADYaiT ARc23Z(PCV8se.ADYaiT aDYaiT) {
        int i = MaskableFrameLayout.f11514B7CMnp;
        return aDYaiT instanceof PCV8se.A2egSU ? new PCV8se.A5SV6n(((PCV8se.A2egSU) aDYaiT).f7015A2egSU) : aDYaiT;
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f1625AcNBzu;
        return KfamK9.A4TApA.A2egSU(this, predicate);
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        WeakReference contextRef;
        FrameLayout lambda$new$0;
        String lambda$showAutoCloseView$5;
        String lambda$showAutoCloseView$7;
        switch (this.f1625AcNBzu) {
            case 7:
                return (Activity) ((WeakReference) obj).get();
            case 8:
                contextRef = ((BaseBuilder) obj).getContextRef();
                return contextRef;
            case 9:
                return (Context) ((WeakReference) obj).get();
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 25:
            default:
                return Integer.valueOf(((InnerNativeBuilder) obj).getHeight());
            case 11:
                lambda$new$0 = S2STemplateViewHelper.lambda$new$0((View) obj);
                return lambda$new$0;
            case 18:
                return Integer.valueOf(((InnerBannerBuilder) obj).getWidth());
            case 19:
                return Integer.valueOf(((InnerBannerBuilder) obj).getHeight());
            case 20:
                return Integer.valueOf(((InnerBannerBuilder) obj).getAutoSlideInterval());
            case 21:
                return Integer.valueOf(((InnerDrawVideoBuilder) obj).getAdCount());
            case 22:
                return Boolean.valueOf(((InnerDrawVideoBuilder) obj).isMute());
            case 23:
                return Boolean.valueOf(((InnerFullVideoBuilder) obj).isMute());
            case 24:
                return Integer.valueOf(((InnerInterstitialBuilder) obj).getAutoCloseCountDown());
            case 26:
                lambda$showAutoCloseView$5 = AdViewInterstitialAdapter.lambda$showAutoCloseView$5((Integer) obj);
                return lambda$showAutoCloseView$5;
            case 27:
                lambda$showAutoCloseView$7 = AdViewInterstitialAdapter.lambda$showAutoCloseView$7((Integer) obj);
                return lambda$showAutoCloseView$7;
            case 28:
                return Integer.valueOf(((InnerNativeBuilder) obj).getWidth());
        }
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate negate() {
        switch (this.f1625AcNBzu) {
        }
        return KfamK9.A4TApA.A4TApA(this);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f1625AcNBzu;
        return KfamK9.A4TApA.A5SV6n(this, predicate);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public boolean test(Object obj) {
        boolean lambda$showInterstitialAd$0;
        switch (this.f1625AcNBzu) {
            case 10:
                return KfamK9.A4TApA.AYUAbz(obj);
            default:
                lambda$showInterstitialAd$0 = AdViewInterstitialAdapter.lambda$showInterstitialAd$0((Activity) obj);
                return lambda$showInterstitialAd$0;
        }
    }
}
