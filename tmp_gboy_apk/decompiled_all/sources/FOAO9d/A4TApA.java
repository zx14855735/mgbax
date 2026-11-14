package FOAO9d;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2574AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f2575AlLFFp;

    public /* synthetic */ A4TApA(AcNBzu acNBzu, int i) {
        this.f2574AcNBzu = i;
        this.f2575AlLFFp = acNBzu;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2574AcNBzu) {
            case 0:
                AcNBzu acNBzu = this.f2575AlLFFp;
                acNBzu.getClass();
                try {
                    if (acNBzu.f2669J3EcKw != 5 && acNBzu.f2633H0R8Px.getParent() == null) {
                        acNBzu.f2630GcSJYy.addView(acNBzu.f2633H0R8Px);
                        acNBzu.f2669J3EcKw = 5;
                        break;
                    }
                } catch (Exception e) {
                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 011: "), new EY4UKY.ADYaiT(), "004", e);
                    return;
                }
                break;
            case 1:
                HFjH17.ADYaiT aDYaiT = this.f2575AlLFFp.f2636H3v3Sq;
                if (aDYaiT != null) {
                    aDYaiT.AZkASS();
                    break;
                }
                break;
            case 2:
                HFjH17.ADYaiT aDYaiT2 = this.f2575AlLFFp.f2636H3v3Sq;
                if (aDYaiT2 != null) {
                    aDYaiT2.AZkASS();
                    break;
                }
                break;
            case 3:
                AcNBzu acNBzu2 = this.f2575AlLFFp;
                if (acNBzu2.f2605EwN40Z == 1) {
                    acNBzu2.B2KMhB(acNBzu2.GZqyMh.f3000AZOQYO, "1");
                } else {
                    acNBzu2.B2KMhB(acNBzu2.f2608F32kj0, null);
                }
                if (acNBzu2.EQurEW("unuser", 0, false)) {
                    acNBzu2.f3203BIYEnU = true;
                    acNBzu2.BV3sI0();
                    acNBzu2.EY4UKY(1);
                    break;
                }
                break;
            case 4:
                AcNBzu acNBzu3 = this.f2575AlLFFp;
                acNBzu3.f2634H0qugq.setVisibility(8);
                FrameLayout frameLayout = acNBzu3.GZqyMh.f3014BI9f7h;
                acNBzu3.f2655IDXjOL = frameLayout;
                if (frameLayout != null) {
                    Context A4TApA2 = GJee0v.A2egSU.A4TApA(acNBzu3.f3185ARc23Z);
                    Bitmap decodeResource = BitmapFactory.decodeResource(A4TApA2.getResources(), 2131231445);
                    ImageView imageView = new ImageView(A4TApA2);
                    imageView.setImageBitmap(decodeResource);
                    acNBzu3.f2655IDXjOL.addView(imageView);
                    break;
                }
                break;
            default:
                AcNBzu acNBzu4 = this.f2575AlLFFp;
                acNBzu4.getClass();
                try {
                    if (acNBzu4.f2669J3EcKw != 5 && acNBzu4.f2633H0R8Px.getParent() == null) {
                        acNBzu4.f2630GcSJYy.addView(acNBzu4.f2633H0R8Px);
                        acNBzu4.f2669J3EcKw = 5;
                    }
                    HFjH17.ADYaiT aDYaiT3 = acNBzu4.f2636H3v3Sq;
                    if (aDYaiT3 != null) {
                        FrameLayout A5SV6n2 = aDYaiT3.A5SV6n(new A2egSU(acNBzu4));
                        FrameLayout frameLayout2 = acNBzu4.GZqyMh.f3012B9tovu;
                        if (frameLayout2 != null && A5SV6n2 != null) {
                            frameLayout2.removeAllViews();
                            frameLayout2.addView(A5SV6n2);
                        }
                    }
                    Fyurov.ADYaiT aDYaiT4 = acNBzu4.f3208BV3sI0;
                    if (aDYaiT4 != null) {
                        FrameLayout frameLayout3 = aDYaiT4.f2903B2KMhB;
                        FrameLayout frameLayout4 = acNBzu4.GZqyMh.f3013BChYOn;
                        if (frameLayout4 != null && frameLayout3 != null) {
                            frameLayout4.removeAllViews();
                            frameLayout4.addView(frameLayout3);
                            frameLayout3.setOnClickListener(new A5SV6n(acNBzu4, 0));
                            break;
                        }
                    }
                } catch (Exception e2) {
                    CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 019: "), new EY4UKY.ADYaiT(), "004", e2);
                }
                break;
        }
    }
}
