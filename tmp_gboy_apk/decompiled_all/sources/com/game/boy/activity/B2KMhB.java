package com.game.boy.activity;

import com.baidu.mobads.sdk.internal.cb;
import com.game.boy.MyApp;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B2KMhB extends LLYwnm.AmA8tU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10909A2egSU;

    public B2KMhB(EmulatorActivity emulatorActivity) {
        this.f10909A2egSU = emulatorActivity;
    }

    @Override // LLYwnm.AmA8tU
    public final void A2egSU(Map map) {
        Object obj = map.get("room_details");
        if (obj instanceof Map) {
            Map map2 = (Map) obj;
            Mi9UWv.ASJ6gh.f5401BmvVmW = String.valueOf(map2.get("room_id"));
            LLYwnm.AYUAbz aYUAbz = this.f10909A2egSU.f10998B9tovu;
            if (aYUAbz == null || !aYUAbz.f4626A2egSU.ADYaiT()) {
                return;
            }
            this.f10909A2egSU.f10998B9tovu.AMqCpz(String.valueOf(map2.get("room_id")));
        }
    }

    @Override // LLYwnm.AmA8tU
    public final void A4TApA(Map map) {
        Object obj = map.get("message");
        if (obj != null) {
            MyApp.A2egSU(String.valueOf(obj));
        }
    }

    @Override // LLYwnm.AmA8tU
    public final void A5SV6n(Map map) {
        Object obj;
        Object obj2 = map.get(cb.o);
        if ((obj2 == null || !Boolean.parseBoolean(String.valueOf(obj2))) && (obj = map.get("error")) != null) {
            MyApp.A2egSU(String.valueOf(obj));
        }
    }

    @Override // LLYwnm.AmA8tU
    public final void ADYaiT(Map map) {
        String str;
        WeakReference weakReference = EmulatorActivity.f10988DG07BK;
        EmulatorActivity emulatorActivity = this.f10909A2egSU;
        M0ztbm.A4TApA a4TApA = (M0ztbm.A4TApA) new Gson().fromJson(new Gson().toJson(map), M0ztbm.A4TApA.class);
        if (a4TApA == null || !a4TApA.f4959A4TApA) {
            return;
        }
        B3GDIM b3gdim = new B3GDIM(emulatorActivity);
        I3HV03.A4TApA a4TApA2 = I3HV03.A4TApA.f3806AzWtSf;
        if (a4TApA2 == null || (str = ((M0ztbm.A4TApA) a4TApA2.f3809AmA8tU).f4960A5SV6n) == null || !str.equals(a4TApA.f4960A5SV6n)) {
            I3HV03.A4TApA a4TApA3 = I3HV03.A4TApA.f3806AzWtSf;
            if (a4TApA3 != null) {
                ADYaiT.AmA8tU amA8tU = (ADYaiT.AmA8tU) a4TApA3.f3808AlLFFp;
                if (amA8tU != null && amA8tU.isShowing()) {
                    amA8tU.dismiss();
                }
                if (I3HV03.A4TApA.f3806AzWtSf == a4TApA3) {
                    I3HV03.A4TApA.f3806AzWtSf = null;
                }
            }
            I3HV03.A4TApA a4TApA4 = new I3HV03.A4TApA(emulatorActivity, a4TApA, b3gdim);
            ADYaiT.AmA8tU amA8tU2 = (ADYaiT.AmA8tU) a4TApA4.f3808AlLFFp;
            if (amA8tU2 == null || amA8tU2.isShowing()) {
                return;
            }
            I3HV03.A4TApA a4TApA5 = I3HV03.A4TApA.f3806AzWtSf;
            if (a4TApA5 != null && a4TApA5 != a4TApA4) {
                ADYaiT.AmA8tU amA8tU3 = (ADYaiT.AmA8tU) a4TApA5.f3808AlLFFp;
                if (amA8tU3 != null && amA8tU3.isShowing()) {
                    amA8tU3.dismiss();
                }
                if (I3HV03.A4TApA.f3806AzWtSf == a4TApA5) {
                    I3HV03.A4TApA.f3806AzWtSf = null;
                }
            }
            I3HV03.A4TApA.f3806AzWtSf = a4TApA4;
            amA8tU2.show();
            amA8tU2.ARc23Z(-1).setTextColor(-9675545);
            amA8tU2.ARc23Z(-2).setTextColor(-6382680);
            if (a4TApA.f4967AaHO0E == 1) {
                amA8tU2.ARc23Z(-1).setEnabled(false);
            }
        }
    }

    @Override // LLYwnm.AmA8tU
    public final void AMqCpz(Map map) {
        Object obj = map.get("message");
        if (obj != null) {
            MyApp.A2egSU(String.valueOf(obj));
        }
    }
}
