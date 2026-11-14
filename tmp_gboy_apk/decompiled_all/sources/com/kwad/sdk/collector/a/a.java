package com.kwad.sdk.collector.a;

import com.fl.saas.common.util.CommConstant;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.aa;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends d {
    private C0348a azu;

    /* renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    public static class C0348a {
        private List<String> azv;

        public C0348a(List<String> list) {
            this.azv = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "packageName", this.azv);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0348a c0348a = new C0348a(list);
        this.azu = c0348a;
        putBody("targetAppInfo", c0348a.toJson());
        putBody(CommConstant.SdkVersion.SDK_VERSION_KEY, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.CA();
    }
}
