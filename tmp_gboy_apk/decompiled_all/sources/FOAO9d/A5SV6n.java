package FOAO9d;

import ADYaiT.CtFAbx;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A5SV6n implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2576AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f2577AlLFFp;

    public /* synthetic */ A5SV6n(AcNBzu acNBzu, int i) {
        this.f2576AcNBzu = i;
        this.f2577AlLFFp = acNBzu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AcNBzu acNBzu = this.f2577AlLFFp;
        switch (this.f2576AcNBzu) {
            case 0:
                if (acNBzu.EQurEW("user", 1, false)) {
                    acNBzu.EY4UKY(1);
                    break;
                }
                break;
            case 1:
                if (acNBzu.f2605EwN40Z != 0) {
                    if (acNBzu.f2623GGG1xW == 1) {
                        acNBzu.EQurEW("user", 0, false);
                        break;
                    }
                } else {
                    acNBzu.f3201BChYOn = "user";
                    if (acNBzu.EQurEW("user", 0, false)) {
                        acNBzu.EY4UKY(1);
                        break;
                    }
                }
                break;
            default:
                acNBzu.getClass();
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                try {
                    if (acNBzu.f3202BI9f7h <= 0.0f && acNBzu.BniPrB()) {
                        if (acNBzu.f2605EwN40Z == 1) {
                            acNBzu.B2KMhB(acNBzu.GZqyMh.f3000AZOQYO, "1");
                        } else {
                            acNBzu.B2KMhB(acNBzu.f2608F32kj0, null);
                        }
                        if (acNBzu.EQurEW("close_button", 0, false)) {
                            acNBzu.f3203BIYEnU = true;
                            acNBzu.BV3sI0();
                            acNBzu.EY4UKY(1);
                            break;
                        }
                    }
                    acNBzu.DuwtYk(2, null, 0, null);
                    acNBzu.CtxOCS();
                    HFjH17.ADYaiT aDYaiT = acNBzu.f2636H3v3Sq;
                    if (aDYaiT != null) {
                        aDYaiT.AlLFFp();
                        acNBzu.f2636H3v3Sq = null;
                    }
                    acNBzu.EY4UKY(4);
                    EQurEW.A4TApA a4TApA = acNBzu.f2641HMGPfW;
                    if (a4TApA != null) {
                        a4TApA.f2491A2egSU.getViewTreeObserver().removeOnScrollChangedListener(a4TApA.f2492A4TApA);
                        acNBzu.f2641HMGPfW = null;
                        break;
                    }
                } catch (Exception e) {
                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 016: "), new EY4UKY.ADYaiT(), "004", e);
                }
                break;
        }
    }
}
