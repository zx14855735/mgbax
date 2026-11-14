package HH6JFw;

import ADYaiT.CtFAbx;
import FSFw2u.AZkASS;
import H0qugq.AZOQYO;
import NOd7IU.AlLFFp;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3347AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f3348AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f3349AmA8tU;

    public /* synthetic */ A4TApA(AZOQYO azoqyo, Object obj, int i) {
        this.f3347AcNBzu = i;
        this.f3348AlLFFp = azoqyo;
        this.f3349AmA8tU = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Object obj = this.f3349AmA8tU;
        AZOQYO azoqyo = this.f3348AlLFFp;
        switch (this.f3347AcNBzu) {
            case 0:
                int[] iArr = new int[2];
                AZkASS aZkASS = (AZkASS) azoqyo;
                aZkASS.f2704FOAO9d.getLocationInWindow(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                aZkASS.f3234DAk1zC = AlLFFp.ASJ6gh(i, "");
                aZkASS.f3235DG07BK = AlLFFp.ASJ6gh(i2, "");
                StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
                Activity activity = (Activity) obj;
                AMqCpz.append(AlLFFp.AMqCpz(activity, aZkASS.f2733HMGPfW));
                aZkASS.f3236DRlcZ9 = AMqCpz.toString();
                StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz2.append(AlLFFp.AMqCpz(activity, aZkASS.f2751IYh8XG));
                aZkASS.f3237DUi7mC = AMqCpz2.toString();
                break;
            case 1:
                int[] iArr2 = new int[2];
                ((View) obj).getLocationInWindow(iArr2);
                int i3 = iArr2[0];
                int i4 = iArr2[1];
                AZkASS aZkASS2 = (AZkASS) azoqyo;
                aZkASS2.f3225CrfGsy = AlLFFp.ASJ6gh(i3, "");
                aZkASS2.f3226CtFAbx = AlLFFp.ASJ6gh(i4, "");
                long currentTimeMillis = System.currentTimeMillis();
                aZkASS2.f3209BmvVmW = CtFAbx.AaHO0E("", currentTimeMillis);
                aZkASS2.f3210BniPrB = String.valueOf((int) (currentTimeMillis / 1000));
                String str = aZkASS2.f3225CrfGsy;
                int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                break;
            default:
                int[] iArr3 = new int[2];
                FdMWEC.AZkASS aZkASS3 = (FdMWEC.AZkASS) azoqyo;
                aZkASS3.f2808EicXu4.getLocationInWindow(iArr3);
                int i6 = iArr3[0];
                int i7 = iArr3[1];
                aZkASS3.f3234DAk1zC = AlLFFp.ASJ6gh(i6, "");
                aZkASS3.f3235DG07BK = AlLFFp.ASJ6gh(i7, "");
                StringBuilder AMqCpz3 = JrXYwF.A4TApA.AMqCpz("");
                Context context = (Context) obj;
                AMqCpz3.append(AlLFFp.AMqCpz(context, 320.0f));
                aZkASS3.f3236DRlcZ9 = AMqCpz3.toString();
                StringBuilder AMqCpz4 = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz4.append(AlLFFp.AMqCpz(context, 78.0f));
                aZkASS3.f3237DUi7mC = AMqCpz4.toString();
                break;
        }
    }
}
