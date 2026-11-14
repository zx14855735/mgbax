package Qo94AZ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public long f7775A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final List f7776A4TApA = Collections.synchronizedList(new ArrayList());

    public final void A2egSU(A2egSU a2egSU) {
        this.f7775A2egSU++;
        Thread thread = new Thread(a2egSU);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.f7775A2egSU + ")");
        this.f7776A4TApA.add(a2egSU);
        thread.start();
    }
}
