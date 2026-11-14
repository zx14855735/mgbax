package F32kj0;

import ADYaiT.CtFAbx;
import DuwtYk.AMqCpz;
import EY4UKY.ADYaiT;
import NOd7IU.AlLFFp;
import android.text.TextUtils;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.czhj.sdk.common.Constants;
import com.google.gson.Gson;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends A2egSU {
    public String AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public String f2568ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f2569ASJ6gh;

    public A5SV6n(AMqCpz aMqCpz, String str, GYpKKt.A2egSU a2egSU) {
        super(a2egSU, 3000);
        this.AMqCpz = "https://de.ad.gameley.com/delivery/request/getad/adn";
        this.f2569ASJ6gh = -1;
        this.f2568ARc23Z = str;
        aMqCpz.getClass();
        this.f2569ASJ6gh = 0;
        AlLFFp.f5904BniPrB = true;
        AlLFFp.Cd8JRx();
        this.f2565A4TApA.putAll(A4TApA(aMqCpz));
        AYUAbz(aMqCpz);
    }

    @Override // F32kj0.A2egSU
    public final Object A2egSU(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = com.bumptech.glide.A5SV6n.AMqCpz(jSONObject.getString("cipher"), jSONObject.getString("encryptParams"));
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SAAllianceEngineAction 002: "), new ADYaiT(), "004", e);
            str2 = "";
        }
        try {
            return (SAAllianceEngineData) new Gson().fromJson(str2, new EiK8oA.A2egSU().getType());
        } catch (Exception e2) {
            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceEngineAction 001: "), new ADYaiT(), "004", e2);
            return null;
        }
    }

    @Override // F32kj0.A2egSU
    public final void ADYaiT(F1loUV.A2egSU a2egSU) {
        GYpKKt.A2egSU a2egSU2 = this.f2564A2egSU;
        if (a2egSU2 != null) {
            a2egSU2.a(a2egSU.f2563AcNBzu, a2egSU.getMessage());
        }
    }

    @Override // F32kj0.A2egSU
    public final void AMqCpz(Object obj) {
        SAAllianceEngineData sAAllianceEngineData = (SAAllianceEngineData) obj;
        GYpKKt.A2egSU a2egSU = this.f2564A2egSU;
        if (a2egSU != null) {
            a2egSU.AMqCpz(sAAllianceEngineData);
        }
    }

    @Override // F32kj0.A2egSU
    public final String ARc23Z() {
        return this.AMqCpz;
    }

    @Override // F32kj0.A2egSU
    public final void ASJ6gh() {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = FmyuN2.A2egSU.f2874A2egSU;
        String str = this.f2568ARc23Z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (currentTimeMillis <= 0) {
            currentTimeMillis = System.currentTimeMillis();
        }
        FmyuN2.A2egSU.f2874A2egSU.put(str, Long.valueOf(currentTimeMillis));
    }

    public final void AYUAbz(AMqCpz aMqCpz) {
        Integer valueOf = Integer.valueOf(this.f2569ASJ6gh);
        HashMap hashMap = this.f2565A4TApA;
        hashMap.put("loadtype", valueOf);
        hashMap.put("crequestid", this.f2568ARc23Z);
        hashMap.put("sposid", aMqCpz.f2478A2egSU);
        hashMap.put("appList", GGG1xW.A2egSU.f2987AZOQYO.A2egSU());
        hashMap.put("count", 1);
        hashMap.put("sid", "");
        String str = aMqCpz.f2482ARc23Z;
        hashMap.put("userId", (str == null || str.isEmpty()) ? ADYaiT.f2532CASmeH : aMqCpz.f2482ARc23Z);
        hashMap.put("sectionid", "");
        hashMap.put("adHeight", "" + aMqCpz.f2480A5SV6n);
        hashMap.put("adWidth", "" + aMqCpz.f2479A4TApA);
        hashMap.put("enableShake", aMqCpz.f2484AYUAbz ? "1" : Constants.FAIL);
        hashMap.put("spostype", Integer.valueOf(aMqCpz.f2481ADYaiT));
        String str2 = aMqCpz.f2482ARc23Z;
        hashMap.put("userId", str2 != null ? str2 : "");
    }
}
