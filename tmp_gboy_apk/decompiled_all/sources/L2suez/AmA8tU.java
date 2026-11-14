package L2suez;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Context f4373AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ MTKlkd.AZOQYO f4374AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ boolean f4375AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ ADYaiT.AmA8tU f4376AzWtSf;

    public AmA8tU(B25kr6 b25kr6, Context context, MTKlkd.AZOQYO azoqyo, boolean z, ADYaiT.AmA8tU amA8tU) {
        this.f4373AcNBzu = context;
        this.f4374AlLFFp = azoqyo;
        this.f4375AmA8tU = z;
        this.f4376AzWtSf = amA8tU;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f4373AcNBzu.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f4374AlLFFp.AMqCpz())));
        if (this.f4375AmA8tU) {
            return;
        }
        this.f4376AzWtSf.dismiss();
    }
}
