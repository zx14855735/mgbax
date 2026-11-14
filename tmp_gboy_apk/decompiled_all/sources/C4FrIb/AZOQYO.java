package C4FrIb;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements Callable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ String f1558A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Context f1559A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f1560A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ int f1561ADYaiT;

    public AZOQYO(String str, Context context, AYUAbz aYUAbz, int i) {
        this.f1558A2egSU = str;
        this.f1559A4TApA = context;
        this.f1560A5SV6n = aYUAbz;
        this.f1561ADYaiT = i;
    }

    @Override // java.util.concurrent.Callable
    public AcNBzu call() {
        return AlLFFp.A2egSU(this.f1558A2egSU, this.f1559A4TApA, this.f1560A5SV6n, this.f1561ADYaiT);
    }
}
