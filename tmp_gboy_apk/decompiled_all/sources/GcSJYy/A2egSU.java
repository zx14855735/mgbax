package GcSJYy;

import ADYaiT.CtFAbx;
import GJee0v.AZOQYO;
import GYpKKt.ARc23Z;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements Callable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ F32kj0.A2egSU f3064A2egSU;

    public A2egSU(F32kj0.A2egSU a2egSU) {
        this.f3064A2egSU = a2egSU;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        F1loUV.A2egSU a2egSU;
        F32kj0.A2egSU a2egSU2 = this.f3064A2egSU;
        a2egSU2.getClass();
        HashMap hashMap = a2egSU2.f2565A4TApA;
        String str = "requestParams = \n";
        for (Map.Entry entry : hashMap.entrySet()) {
            StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("  | ");
            AMqCpz.append((String) entry.getKey());
            AMqCpz.append(" : ");
            AMqCpz.append(entry.getValue());
            AMqCpz.append("\n");
            str = CtFAbx.AcNBzu(str, AMqCpz.toString());
        }
        int i = AZOQYO.f3039AcNBzu;
        BTvldC.ADYaiT aDYaiT = new BTvldC.ADYaiT(a2egSU2.ARc23Z(), a2egSU2.f2567ADYaiT, hashMap, a2egSU2.f2566A5SV6n);
        a2egSU2.ASJ6gh();
        String str2 = null;
        int i2 = -1;
        try {
            Response execute = ARc23Z.f3063A4TApA.newCall(ARc23Z.A4TApA(aDYaiT)).execute();
            i2 = execute.code();
            execute.message();
            if (execute.isSuccessful()) {
                a2egSU = null;
                str2 = execute.body() != null ? execute.body().string() : "";
            } else {
                a2egSU = new F1loUV.A2egSU(8899);
            }
            execute.close();
        } catch (Exception e) {
            e.getMessage();
            int i3 = AZOQYO.f3039AcNBzu;
            a2egSU = new F1loUV.A2egSU(8899);
        }
        if (200 == i2) {
            return a2egSU2.A2egSU(str2);
        }
        if (a2egSU != null) {
            throw a2egSU;
        }
        if (i2 == 404) {
            throw new F1loUV.A2egSU(404, 0);
        }
        if (i2 == 502) {
            throw new F1loUV.A2egSU(502, 0);
        }
        throw new F1loUV.A2egSU(100, 0);
    }
}
