package AaHO0E;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.sigmob.sdk.downloader.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class H3v3Sq implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AZkASS.A2egSU f896AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ H6qKiO f897AlLFFp;

    public H3v3Sq(H6qKiO h6qKiO) {
        this.f897AlLFFp = h6qKiO;
        Context context = h6qKiO.f898A2egSU.getContext();
        CharSequence charSequence = h6qKiO.f904AYUAbz;
        AZkASS.A2egSU a2egSU = new AZkASS.A2egSU();
        a2egSU.f420B25kr6 = f.a.c;
        a2egSU.f422B3GDIM = f.a.c;
        a2egSU.f427BI9f7h = null;
        a2egSU.f428BIYEnU = null;
        a2egSU.f429BJ7GGh = false;
        a2egSU.f430BNL6CD = false;
        a2egSU.f431BPw6Q8 = 16;
        a2egSU.f424B7CMnp = context;
        a2egSU.f416AcNBzu = charSequence;
        this.f896AcNBzu = a2egSU;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        H6qKiO h6qKiO = this.f897AlLFFp;
        Window.Callback callback = h6qKiO.f907AaHO0E;
        if (callback == null || !h6qKiO.f908AcNBzu) {
            return;
        }
        callback.onMenuItemSelected(0, this.f896AcNBzu);
    }
}
