package Cd8JRx;

import COJEAR.DG07BK;
import CQhlFr.B7CMnp;
import Fyurov.B4ZgIw;
import GJee0v.AZOQYO;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.fl.saas.base.base.BaseAPI;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialEnvelopeView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialFullScreenView;
import com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener;
import com.fl.saas.base.inner.reward.YdInnerRewardVideoActivity;
import com.fl.saas.base.interfaces.AdReRequestListener;
import com.fl.saas.base.widget.FingerSlidingAndTwistingView;
import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.base.widget.YdCommonDialog;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.common.util.feature.joor.AnnontationManager;
import com.fl.saas.s2s.S2SFullVideoAdapter;
import com.fl.saas.s2s.S2SRewardVideoAdapter;
import com.fl.saas.s2s.sdk.helper.CacheListener;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.sigmob.sdk.base.a;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.newInterstitial.f;
import com.sigmob.sdk.newInterstitial.i;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class ADYaiT implements G58fqA.A5SV6n, Predicate, CacheListener, B7CMnp, AdReRequestListener, ShakeView.ShakeListener, VideoSoundControlListener.SoundControlViewStateChangeListener, YdCommonDialog.OnSubmitListener, AmA8tU.A2egSU, ae.a, ac {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1778AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f1779AlLFFp;

    public /* synthetic */ ADYaiT(int i, Object obj) {
        this.f1778AcNBzu = i;
        this.f1779AlLFFp = obj;
    }

    public void A2egSU(int i) {
        Integer valueOf = Integer.valueOf(i);
        Fyurov.ADYaiT aDYaiT = (Fyurov.ADYaiT) this.f1779AlLFFp;
        DG07BK.A2egSU a2egSU = aDYaiT.f2892ARc23Z;
        if (a2egSU != null) {
            Message obtainMessage = a2egSU.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = valueOf;
            aDYaiT.f2892ARc23Z.sendMessage(obtainMessage);
        }
    }

    @Override // G58fqA.A5SV6n
    public void A4TApA(Intent intent) {
        FZu94u.A4TApA a4TApA = (FZu94u.A4TApA) this.f1779AlLFFp;
        a4TApA.getClass();
        int i = AZOQYO.f3039AcNBzu;
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        B4ZgIw b4ZgIw = a4TApA.G16Pvp;
        if (b4ZgIw != null) {
            b4ZgIw.A5SV6n();
        }
        a4TApA.f2787GIi2tl.A4TApA();
    }

    public boolean A5SV6n(KCxDWD.A5SV6n a5SV6n, int i, Bundle bundle) {
        COJEAR.AMqCpz aMqCpz;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((AYUAbz) a5SV6n.f4241AlLFFp).A5SV6n();
                Parcelable parcelable = (Parcelable) ((AYUAbz) a5SV6n.f4241AlLFFp).ASJ6gh();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception unused) {
                return false;
            }
        }
        ClipDescription description = ((AYUAbz) a5SV6n.f4241AlLFFp).getDescription();
        AYUAbz aYUAbz = (AYUAbz) a5SV6n.f4241AlLFFp;
        ClipData clipData = new ClipData(description, new ClipData.Item(aYUAbz.A2egSU()));
        if (i2 >= 31) {
            aMqCpz = new KCxDWD.A5SV6n(clipData, 2);
        } else {
            COJEAR.ARc23Z aRc23Z = new COJEAR.ARc23Z();
            aRc23Z.f1619AlLFFp = clipData;
            aRc23Z.f1620AmA8tU = 2;
            aMqCpz = aRc23Z;
        }
        aMqCpz.AMqCpz(aYUAbz.ADYaiT());
        aMqCpz.setExtras(bundle);
        return DG07BK.AzWtSf((AppCompatEditText) this.f1779AlLFFp, aMqCpz.build()) == null;
    }

    @Override // CQhlFr.B7CMnp
    public boolean ADYaiT(View view) {
        int i = BottomSheetDragHandleView.f11447B9tovu;
        return ((BottomSheetDragHandleView) this.f1779AlLFFp).A2egSU();
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f1778AcNBzu;
        return KfamK9.A4TApA.A2egSU(this, predicate);
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        Object[] lambda$handleAnnMethod$2;
        lambda$handleAnnMethod$2 = AnnontationManager.lambda$handleAnnMethod$2((Object[]) this.f1779AlLFFp, (Class[]) obj);
        return lambda$handleAnnMethod$2;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener.SoundControlViewStateChangeListener
    public void changeViewVisible(boolean z) {
        ((InterstitialFullScreenView) this.f1779AlLFFp).lambda$setMediaView$4(z);
    }

    @Override // com.fl.saas.s2s.sdk.helper.CacheListener
    public boolean isCache() {
        switch (this.f1778AcNBzu) {
            case 5:
                return ((S2SFullVideoAdapter) this.f1779AlLFFp).isCache();
            default:
                return ((S2SRewardVideoAdapter) this.f1779AlLFFp).isCache();
        }
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate negate() {
        switch (this.f1778AcNBzu) {
        }
        return KfamK9.A4TApA.A4TApA(this);
    }

    @Override // com.sigmob.sdk.base.common.ac
    public void onAdClick(boolean z, a aVar) {
        ((i) this.f1779AlLFFp).a(z, aVar);
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public void onAddExtra(Object obj) {
        f.a((String) this.f1779AlLFFp, obj);
    }

    @Override // com.fl.saas.base.widget.YdCommonDialog.OnSubmitListener
    public void onClick() {
        ((YdInnerRewardVideoActivity) this.f1779AlLFFp).lambda$onClick$0();
    }

    @Override // com.fl.saas.base.interfaces.AdReRequestListener
    public void onReRequest() {
        ((BaseAPI) this.f1779AlLFFp).reRequest();
    }

    @Override // com.fl.saas.base.widget.ShakeView.ShakeListener
    public void onShake(int i, int i2, int i3) {
        switch (this.f1778AcNBzu) {
            case 11:
                ((InterstitialEnvelopeView) this.f1779AlLFFp).lambda$bindActionView$1(i, i2, i3);
                break;
            default:
                ((FingerSlidingAndTwistingView) this.f1779AlLFFp).lambda$createView$0(i, i2, i3);
                break;
        }
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f1778AcNBzu;
        return KfamK9.A4TApA.A5SV6n(this, predicate);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public boolean test(Object obj) {
        boolean equals;
        switch (this.f1778AcNBzu) {
            case 3:
                equals = this.f1779AlLFFp.equals(obj);
                return equals;
            default:
                return KfamK9.A4TApA.AMqCpz((Predicate) this.f1779AlLFFp, obj);
        }
    }
}
