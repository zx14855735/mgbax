package LLiCI0;

import MTKlkd.AZOQYO;
import android.content.Context;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AZOQYO.A2egSU f4692AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f4693AlLFFp;

    public AZkASS(AzWtSf azWtSf, AZOQYO.A2egSU a2egSU) {
        this.f4693AlLFFp = azWtSf;
        this.f4692AcNBzu = a2egSU;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = view.getContext();
        this.f4693AlLFFp.getClass();
        AZOQYO.A2egSU a2egSU = this.f4692AcNBzu;
        String A4TApA2 = a2egSU.A4TApA() == null ? "" : a2egSU.A4TApA();
        String ARc23Z2 = a2egSU.ARc23Z() != null ? a2egSU.ARc23Z() : "";
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(context);
        String AMqCpz = a2egSU.AMqCpz();
        ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
        azoqyo.AMqCpz = AMqCpz;
        azoqyo.f28ASJ6gh = A4TApA2;
        a4TApA.AlLFFp("复制内容", new AcNBzu(context, A4TApA2));
        a4TApA.AzWtSf("打开", new AaHO0E(ARc23Z2, context));
        a4TApA.AcNBzu("取消", null);
        a4TApA.AMqCpz();
    }
}
