package com.kwad.sdk.api.loader;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fl.saas.common.util.CommConstant;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    public static class C0346a {
        int axO;
        String axP;
        transient File axQ;
        long interval;
        String md5;
        String sdkVersion;

        public final boolean EU() {
            return this.axO == 1;
        }

        public final boolean EV() {
            return this.axO == -1;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.axO = jSONObject.optInt("dynamicType");
            this.axP = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
            this.interval = jSONObject.optLong("interval");
            this.sdkVersion = jSONObject.optString(CommConstant.SdkVersion.SDK_VERSION_KEY);
        }

        public final String toString() {
            return "Data{dynamicType=" + this.axO + ", dynamicUrl='" + this.axP + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.axQ + '}';
        }
    }

    public static class b {
        C0346a axR;
        String errorMsg;
        long result;

        public final boolean isLegal() {
            return this.result == 1 && this.axR != null;
        }

        public final void parseJson(JSONObject jSONObject) {
            this.result = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            C0346a c0346a = new C0346a();
            this.axR = c0346a;
            c0346a.parseJson(jSONObject.optJSONObject(PointParamKey.DATA));
        }

        public final String toString() {
            return "UpdateData{result=" + this.result + ", errorMsg='" + this.errorMsg + "', data=" + this.axR + '}';
        }
    }
}
