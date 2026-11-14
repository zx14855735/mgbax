package androidx.activity.result;

import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT extends A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f7992A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ String f7993A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ A4TApA.A4TApA f7994A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh f7995ADYaiT;

    public /* synthetic */ ADYaiT(ASJ6gh aSJ6gh, String str, A4TApA.A4TApA a4TApA, int i) {
        this.f7992A2egSU = i;
        this.f7995ADYaiT = aSJ6gh;
        this.f7993A4TApA = str;
        this.f7994A5SV6n = a4TApA;
    }

    @Override // androidx.activity.result.A5SV6n
    public final void A2egSU(Object obj) {
        switch (this.f7992A2egSU) {
            case 0:
                ASJ6gh aSJ6gh = this.f7995ADYaiT;
                HashMap hashMap = aSJ6gh.f8001A4TApA;
                String str = this.f7993A4TApA;
                Integer num = (Integer) hashMap.get(str);
                A4TApA.A4TApA a4TApA = this.f7994A5SV6n;
                if (num != null) {
                    aSJ6gh.f8003ADYaiT.add(str);
                    try {
                        aSJ6gh.A4TApA(num.intValue(), a4TApA, obj);
                        return;
                    } catch (Exception e) {
                        aSJ6gh.f8003ADYaiT.remove(str);
                        throw e;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + a4TApA + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                ASJ6gh aSJ6gh2 = this.f7995ADYaiT;
                HashMap hashMap2 = aSJ6gh2.f8001A4TApA;
                String str2 = this.f7993A4TApA;
                Integer num2 = (Integer) hashMap2.get(str2);
                A4TApA.A4TApA a4TApA2 = this.f7994A5SV6n;
                if (num2 != null) {
                    aSJ6gh2.f8003ADYaiT.add(str2);
                    try {
                        aSJ6gh2.A4TApA(num2.intValue(), a4TApA2, obj);
                        return;
                    } catch (Exception e2) {
                        aSJ6gh2.f8003ADYaiT.remove(str2);
                        throw e2;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + a4TApA2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }

    public void A4TApA() {
        this.f7995ADYaiT.ARc23Z(this.f7993A4TApA);
    }
}
