package io.dcloud.sdk.poly.adapter.zy;

import a.b;
import a.c;
import a.d;
import a.f;
import a.g;
import a.h;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.Octopus;
import com.octopus.ad.OctopusAdSdkController;
import io.dcloud.api.custom.UniAdCustomAdapter;
import io.dcloud.api.custom.base.UniAdPrivacyConfig;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ZYADAdapter extends UniAdCustomAdapter {
    private UniAdPrivacyConfig config;

    public class a extends OctopusAdSdkController {
        public a() {
        }

        @Override // com.octopus.ad.OctopusAdSdkController
        public String getImei() {
            return super.getImei();
        }

        @Override // com.octopus.ad.OctopusAdSdkController
        public String getOaid() {
            return super.getOaid();
        }

        @Override // com.octopus.ad.OctopusAdSdkController
        public boolean isCanShake() {
            return ZYADAdapter.this.config == null ? super.isCanShake() : ZYADAdapter.this.config.isCanUseSensor();
        }

        @Override // com.octopus.ad.OctopusAdSdkController
        public boolean isCanUseLocation() {
            return ZYADAdapter.this.config == null ? super.isCanUseLocation() : ZYADAdapter.this.config.isCanUseLocation();
        }

        @Override // com.octopus.ad.OctopusAdSdkController
        public boolean isCanUseOaid() {
            return ZYADAdapter.this.config == null ? super.isCanUseOaid() : ZYADAdapter.this.config.isCanGetOAID();
        }

        @Override // com.octopus.ad.OctopusAdSdkController
        public boolean isCanUsePhoneState() {
            return ZYADAdapter.this.config == null ? super.isCanUsePhoneState() : ZYADAdapter.this.config.isCanUsePhoneState();
        }
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public int getAdapterVersion() {
        return 3;
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public UniAdCustomBaseLoader getAdsByType(int i) {
        if (i == 1) {
            return new h();
        }
        if (i == 4) {
            return new f();
        }
        if (i == 7) {
            return new c();
        }
        if (i == 15) {
            return new d();
        }
        if (i == 9) {
            return new g();
        }
        if (i != 10) {
            return null;
        }
        return new b();
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter, io.dcloud.openapi.core.adapter.IAdAdapter
    public String getSDKVersion() {
        return Octopus.getSdkVersion();
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public void init(Context context, JSONObject jSONObject) {
        String str;
        try {
            str = jSONObject.optString("appid");
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            onInitFail(MediationConstant.ErrorCode.ADN_INIT_FAIL, "AppId is empty!");
        } else {
            try {
                Octopus.init(context, str, new a());
            } catch (Throwable unused) {
            }
            onInitSuccess();
        }
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
        Octopus.setLimitPersonalAds(!z);
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public void setPrivacyConfig(UniAdPrivacyConfig uniAdPrivacyConfig) {
        this.config = uniAdPrivacyConfig;
    }
}
