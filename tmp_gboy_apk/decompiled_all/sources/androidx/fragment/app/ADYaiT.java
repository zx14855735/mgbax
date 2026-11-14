package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f8721AcNBzu = 1;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AmA8tU f8722AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f8723AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f8724AzWtSf;

    public /* synthetic */ ADYaiT(AmA8tU amA8tU, View view, AZOQYO azoqyo) {
        this.f8722AlLFFp = amA8tU;
        this.f8723AmA8tU = view;
        this.f8724AzWtSf = azoqyo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8721AcNBzu) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f8723AmA8tU;
                DyaChj dyaChj = (DyaChj) this.f8724AzWtSf;
                RXb0Sz.ARc23Z.AMqCpz(this.f8722AlLFFp, "this$0");
                if (arrayList.contains(dyaChj)) {
                    arrayList.remove(dyaChj);
                    View view = dyaChj.f8955A5SV6n.mView;
                    int i = dyaChj.f8953A2egSU;
                    RXb0Sz.ARc23Z.ADYaiT(view, "view");
                    J3FDQU.A2egSU.A2egSU(i, view);
                    break;
                }
                break;
            default:
                AmA8tU amA8tU = this.f8722AlLFFp;
                RXb0Sz.ARc23Z.AMqCpz(amA8tU, "this$0");
                AZOQYO azoqyo = (AZOQYO) this.f8724AzWtSf;
                RXb0Sz.ARc23Z.AMqCpz(azoqyo, "$animationInfo");
                amA8tU.f8753A2egSU.endViewTransition((View) this.f8723AmA8tU);
                azoqyo.A2egSU();
                break;
        }
    }

    public /* synthetic */ ADYaiT(ArrayList arrayList, DyaChj dyaChj, AmA8tU amA8tU) {
        this.f8723AmA8tU = arrayList;
        this.f8724AzWtSf = dyaChj;
        this.f8722AlLFFp = amA8tU;
    }
}
