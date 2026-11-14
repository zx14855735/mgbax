package androidx.activity;

import android.os.Bundle;
import androidx.lifecycle.COJEAR;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AMqCpz implements DV2E8K.A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f7940A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f7941A4TApA;

    public /* synthetic */ AMqCpz(int i, Object obj) {
        this.f7940A2egSU = i;
        this.f7941A4TApA = obj;
    }

    @Override // DV2E8K.A5SV6n
    public final Bundle saveState() {
        switch (this.f7940A2egSU) {
            case 0:
                return ComponentActivity.A5SV6n((ComponentActivity) this.f7941A4TApA);
            default:
                return COJEAR.A2egSU((COJEAR) this.f7941A4TApA);
        }
    }
}
