package H0qugq;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Activity f3175AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Material f3176AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ SAAllianceAdData f3177AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Handler f3178AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f3179B25kr6;

    public AYUAbz(AZOQYO azoqyo, Activity activity, Material material, SAAllianceAdData sAAllianceAdData, Handler handler) {
        this.f3179B25kr6 = azoqyo;
        this.f3175AcNBzu = activity;
        this.f3176AlLFFp = material;
        this.f3177AmA8tU = sAAllianceAdData;
        this.f3178AzWtSf = handler;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Material material = this.f3176AlLFFp;
        SAAllianceAdData sAAllianceAdData = this.f3177AmA8tU;
        AZOQYO azoqyo = this.f3179B25kr6;
        azoqyo.B25kr6(this.f3175AcNBzu, material, sAAllianceAdData, this.f3178AzWtSf);
        azoqyo.f3254EUIRHA = false;
    }
}
