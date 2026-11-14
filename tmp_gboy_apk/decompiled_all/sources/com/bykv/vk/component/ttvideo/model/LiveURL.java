package com.bykv.vk.component.ttvideo.model;

import com.bykv.vk.component.ttvideo.player.Keep;
import org.json.JSONObject;

@Keep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class LiveURL {
    public final String backupURL;
    public final String mainURL;
    public String sdkParams;

    public LiveURL(String str, String str2, String str3) {
        this.mainURL = str;
        this.backupURL = str2;
        this.sdkParams = str3;
    }

    public static LiveURL build(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new LiveURL(jSONObject.optString("main_play_url"), jSONObject.optString("backup_play_url"), jSONObject.optString("SdkParams"));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getVCodec() {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r4.sdkParams     // Catch: org.json.JSONException -> Ld
            if (r1 == 0) goto L11
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> Ld
            java.lang.String r2 = r4.sdkParams     // Catch: org.json.JSONException -> Ld
            r1.<init>(r2)     // Catch: org.json.JSONException -> Ld
            goto L12
        Ld:
            r1 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r1)
        L11:
            r1 = r0
        L12:
            if (r1 == 0) goto L27
            java.lang.String r2 = "VCodec"
            boolean r3 = r1.has(r2)
            if (r3 == 0) goto L27
            java.lang.String r1 = r1.optString(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L27
            return r1
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveURL.getVCodec():java.lang.String");
    }
}
