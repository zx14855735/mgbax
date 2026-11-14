package com.game.boy.activity;

import MTKlkd.A4TApA;
import android.util.Base64;
import com.google.gson.Gson;
import java.net.InetAddress;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B4ZgIw implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ B7CMnp f10911AcNBzu;

    public B4ZgIw(B7CMnp b7CMnp) {
        this.f10911AcNBzu = b7CMnp;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B7CMnp b7CMnp = this.f10911AcNBzu;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            try {
                MTKlkd.A4TApA a4TApA = (MTKlkd.A4TApA) new Gson().fromJson(b7CMnp.f10913AlLFFp, MTKlkd.A4TApA.class);
                if (a4TApA == null || a4TApA.A5SV6n() == null || a4TApA.A5SV6n().isEmpty()) {
                    throw new Exception();
                }
                for (int i = 0; i < a4TApA.A5SV6n().size(); i++) {
                    A4TApA.A2egSU a2egSU = (A4TApA.A2egSU) a4TApA.A5SV6n().get(i);
                    if (a2egSU.A2egSU() == null || a2egSU.A2egSU().isEmpty()) {
                        throw new Exception();
                    }
                    String A2egSU2 = a2egSU.A2egSU();
                    Gson gson = L2suez.AYUAbz.f4368A2egSU;
                    byte[] decode = A2egSU2 == null ? null : Base64.decode(A2egSU2, 2);
                    if (decode == null || decode.length == 0) {
                        throw new Exception();
                    }
                    arrayList.add(decode);
                    arrayList2.add(a2egSU.A4TApA());
                }
                EmulatorActivity emulatorActivity = b7CMnp.f10914AmA8tU;
                emulatorActivity.f11015CSDoyG = EmulatorActivity.B25kr6(emulatorActivity);
                EmulatorActivity.B2KMhB(emulatorActivity, "room");
                String A2egSU3 = a4TApA.A2egSU();
                emulatorActivity.f11015CSDoyG.AMqCpz(InetAddress.getByName(A2egSU3), a4TApA.A4TApA(), a4TApA.ADYaiT().A2egSU() == 0, arrayList, arrayList2);
            } catch (Exception e) {
                b7CMnp.f10914AmA8tU.runOnUiThread(new MOpbMP.A2egSU(this, 21, e.getMessage()));
                arrayList.clear();
                System.gc();
            }
        } catch (Throwable th) {
            arrayList.clear();
            System.gc();
            throw th;
        }
    }
}
