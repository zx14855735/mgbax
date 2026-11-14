package N9P37h;

import android.accounts.Account;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public HashSet f5610A2egSU = new HashSet();

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f5611A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f5612A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f5613ADYaiT;
    public String AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public Account f5614ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public String f5615ASJ6gh;

    public final A5SV6n A2egSU() {
        if (this.f5613ADYaiT && (this.f5614ARc23Z == null || !this.f5610A2egSU.isEmpty())) {
            this.f5610A2egSU.add(A5SV6n.f5616B7CMnp);
        }
        return new A5SV6n(this.f5610A2egSU, this.f5614ARc23Z, this.f5613ADYaiT, this.f5611A4TApA, this.f5612A5SV6n, this.AMqCpz, this.f5615ASJ6gh);
    }
}
