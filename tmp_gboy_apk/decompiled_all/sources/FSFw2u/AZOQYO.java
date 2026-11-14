package FSFw2u;

import Fyurov.B4ZgIw;
import H0qugq.AcNBzu;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.utils.DeviceUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements View.OnAttachStateChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ View f2689AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2690AlLFFp;

    public AZOQYO(AZkASS aZkASS, View view) {
        this.f2690AlLFFp = aZkASS;
        this.f2689AcNBzu = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        Activity A5SV6n2 = GJee0v.A2egSU.A5SV6n();
        AZkASS aZkASS = this.f2690AlLFFp;
        if (A5SV6n2 != null) {
            aZkASS.f2721GYpKKt = A5SV6n2.getRequestedOrientation();
            if (DeviceUtil.AzWtSf(A5SV6n2)) {
                A5SV6n2.setRequestedOrientation(0);
            } else {
                A5SV6n2.setRequestedOrientation(1);
            }
        }
        aZkASS.DuwtYk(0, null);
        HFjH17.ADYaiT aDYaiT = aZkASS.f2745I3bnmY;
        if (aDYaiT != null) {
            aDYaiT.AZkASS();
        }
        aZkASS.AYUAbz();
        aZkASS.DAk1zC(aZkASS.f3187AYUAbz);
        HFjH17.ADYaiT aDYaiT2 = aZkASS.f2745I3bnmY;
        if (aDYaiT2 != null) {
            aDYaiT2.AmA8tU();
        }
        View findViewById = this.f2689AcNBzu.findViewById(2131296653);
        SAAllianceAdData sAAllianceAdData = aZkASS.f3187AYUAbz;
        if (sAAllianceAdData != null && sAAllianceAdData.getInteraction() != null && aZkASS.f3187AYUAbz.getInteraction().getAutoCloseCountdownTime() != null && aZkASS.f3187AYUAbz.getInteraction().getAutoCloseCountdownTime().intValue() > 0) {
            float intValue = aZkASS.f3187AYUAbz.getInteraction().getAutoCloseCountdownTime().intValue();
            aZkASS.f2720GTPRn3 = intValue;
            if (aZkASS.f3202BI9f7h >= intValue) {
                aZkASS.f3202BI9f7h = intValue - 1.0f;
            }
        } else if (aZkASS.f3202BI9f7h >= 50.0f) {
            aZkASS.f3202BI9f7h = 49.0f;
        }
        float f = aZkASS.f2720GTPRn3;
        if (f > 0.0f || aZkASS.f3202BI9f7h > 0.0f || aZkASS.f2730HH6JFw) {
            aZkASS.f2719GL2Jh7 = B4ZgIw.A2egSU(Math.max((long) (Math.max(f, aZkASS.f3202BI9f7h) * 1000.0f), 3000L), new DaOi9o.AYUAbz(aZkASS, 1, findViewById));
        }
        B4ZgIw b4ZgIw = aZkASS.f2719GL2Jh7;
        if (b4ZgIw != null) {
            b4ZgIw.A5SV6n();
        }
        Context A4TApA2 = GJee0v.A2egSU.A4TApA(aZkASS.f3185ARc23Z);
        if (aZkASS.f3207BTvldC != null) {
            AcNBzu.ASJ6gh(A4TApA2, aZkASS.HHoABE, aZkASS.f2742HtmBAy);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
