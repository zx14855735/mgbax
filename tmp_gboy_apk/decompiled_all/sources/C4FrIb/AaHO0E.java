package C4FrIb;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E implements Callable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ String f1564A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Context f1565A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f1566A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ int f1567ADYaiT;

    public AaHO0E(String str, Context context, AYUAbz aYUAbz, int i) {
        this.f1564A2egSU = str;
        this.f1565A4TApA = context;
        this.f1566A5SV6n = aYUAbz;
        this.f1567ADYaiT = i;
    }

    @Override // java.util.concurrent.Callable
    public AcNBzu call() {
        try {
            return AlLFFp.A2egSU(this.f1564A2egSU, this.f1565A4TApA, this.f1566A5SV6n, this.f1567ADYaiT);
        } catch (Throwable unused) {
            return new AcNBzu(-3);
        }
    }
}
