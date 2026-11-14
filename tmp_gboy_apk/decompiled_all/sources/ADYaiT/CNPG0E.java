package ADYaiT;

import android.window.OnBackInvokedCallback;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class CNPG0E implements OnBackInvokedCallback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f122A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f123A4TApA;

    public /* synthetic */ CNPG0E(int i, Object obj) {
        this.f122A2egSU = i;
        this.f123A4TApA = obj;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        switch (this.f122A2egSU) {
            case 0:
                ((CkXcdM) this.f123A4TApA).BpkvW3();
                break;
            case 1:
                ((Runnable) this.f123A4TApA).run();
                break;
            case 2:
                ((Ogw3zR.A4TApA) this.f123A4TApA).A5SV6n();
                break;
            default:
                Function0 function0 = (Function0) this.f123A4TApA;
                RXb0Sz.ARc23Z.AMqCpz(function0, "$onBackInvoked");
                function0.invoke();
                break;
        }
    }
}
