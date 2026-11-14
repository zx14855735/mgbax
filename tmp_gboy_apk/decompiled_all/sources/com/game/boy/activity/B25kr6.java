package com.game.boy.activity;

import com.baidu.mobads.sdk.internal.cb;
import com.google.gson.Gson;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 extends LLYwnm.AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10908A2egSU;

    public B25kr6(EmulatorActivity emulatorActivity) {
        this.f10908A2egSU = emulatorActivity;
    }

    @Override // LLYwnm.AlLFFp
    public final void A2egSU(Map map) {
        LHpdLt.AZOQYO azoqyo = this.f10908A2egSU.f10997B7CMnp;
        if (azoqyo != null) {
            String json = new Gson().toJson(map);
            MTKlkd.AYUAbz aYUAbz = (MTKlkd.AYUAbz) azoqyo.f4499BmvVmW.fromJson(json, MTKlkd.AYUAbz.class);
            if (aYUAbz != null) {
                boolean equals = "lobby".equals(aYUAbz.AMqCpz());
                if (aYUAbz.ADYaiT() != null && aYUAbz.ADYaiT().equals(azoqyo.f4505COJEAR.B25kr6("user_name"))) {
                    azoqyo.AYUAbz(json);
                    return;
                }
                LHpdLt.BV3sI0 bV3sI0 = new LHpdLt.BV3sI0(aYUAbz.ADYaiT(), aYUAbz.A4TApA(), aYUAbz.A2egSU(), false);
                String A5SV6n2 = aYUAbz.A5SV6n();
                if (equals) {
                    azoqyo.ARc23Z(azoqyo.f4495BNL6CD, bV3sI0, A5SV6n2, true);
                } else if (azoqyo.f4497BTvldC) {
                    azoqyo.ARc23Z(azoqyo.f4494BJ7GGh, bV3sI0, A5SV6n2, false);
                }
            }
        }
    }

    @Override // LLYwnm.AlLFFp
    public final void A4TApA(int i, String str) {
        EmulatorActivity emulatorActivity = this.f10908A2egSU;
        if (emulatorActivity.f10997B7CMnp != null) {
            HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h(PointParamKey.TYPE, "user_join");
            BI9f7h2.put(cb.o, Boolean.TRUE);
            BI9f7h2.put("uuid", str);
            BI9f7h2.put("players", String.valueOf(i));
            emulatorActivity.f10997B7CMnp.AYUAbz(new Gson().toJson(BI9f7h2));
        }
    }

    @Override // LLYwnm.AlLFFp
    public final void A5SV6n(int i, String str) {
        EmulatorActivity emulatorActivity = this.f10908A2egSU;
        if (emulatorActivity.f10997B7CMnp != null) {
            HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h(PointParamKey.TYPE, "user_leave");
            BI9f7h2.put(cb.o, Boolean.TRUE);
            BI9f7h2.put("uuid", str);
            BI9f7h2.put("players", String.valueOf(i));
            emulatorActivity.f10997B7CMnp.AYUAbz(new Gson().toJson(BI9f7h2));
        }
    }
}
