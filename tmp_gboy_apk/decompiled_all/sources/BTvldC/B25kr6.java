package BTvldC;

import android.view.View;
import android.widget.TextView;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.sigmob.sdk.videoAd.j;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class B25kr6 implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1465AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f1466AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f1467AmA8tU;

    public /* synthetic */ B25kr6(int i, int i2, Object obj) {
        this.f1465AcNBzu = i2;
        this.f1467AmA8tU = obj;
        this.f1466AlLFFp = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FZu94u.A4TApA a4TApA;
        int i = this.f1466AlLFFp;
        Object obj = this.f1467AmA8tU;
        switch (this.f1465AcNBzu) {
            case 0:
                ((B2KMhB) obj).A4TApA(i);
                break;
            case 1:
                NMRewardVideoActivity nMRewardVideoActivity = (NMRewardVideoActivity) obj;
                TextView textView = nMRewardVideoActivity.f9635C4FrIb;
                if (textView != null && (a4TApA = NMRewardVideoActivity.f9613F1loUV) != null && !a4TApA.f2789GJee0v) {
                    if (!nMRewardVideoActivity.f9664DcUJf1) {
                        textView.setText(String.format(nMRewardVideoActivity.getResources().getString(2131886633), Integer.valueOf(i)));
                        break;
                    } else {
                        textView.setText(nMRewardVideoActivity.getResources().getString(2131886634));
                        break;
                    }
                }
                break;
            case 2:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.f11803BPw6Q8.get();
                if (view != null) {
                    sideSheetBehavior.ASJ6gh(view, i, false);
                    break;
                }
                break;
            case 3:
                ((j) obj).c(i);
                break;
            default:
                ((com.sigmob.sdk.videoplayer.j) obj).a(i);
                break;
        }
    }
}
