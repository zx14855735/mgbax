package H0qugq;

import com.alliance.ssp.ad.utils.jni_interface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements jni_interface.Callback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f3170A2egSU;

    public AMqCpz(AZOQYO azoqyo) {
        this.f3170A2egSU = azoqyo;
    }

    @Override // com.alliance.ssp.ad.utils.jni_interface.Callback
    public final void onEvent(String str) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        boolean equals = str.equals("1");
        AZOQYO azoqyo = this.f3170A2egSU;
        if (equals) {
            azoqyo.f3204BJ7GGh = true;
        } else {
            azoqyo.f3204BJ7GGh = false;
        }
    }
}
