package com.bytedance.adsdk.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements f {
    @Override // com.bytedance.adsdk.hf.f
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public String xj(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length >= 2) {
            String valueOf = String.valueOf(objArr[0]);
            if (TextUtils.isEmpty(valueOf)) {
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(valueOf);
                String valueOf2 = String.valueOf(objArr[1]);
                if (TextUtils.isEmpty(valueOf2)) {
                    return null;
                }
                Object xj = com.bytedance.adsdk.hf.hf.xj.xj(valueOf2).xj(jSONObject2);
                if (!TextUtils.isEmpty(String.valueOf(xj))) {
                    return String.valueOf(xj);
                }
                if (objArr.length >= 3) {
                    return String.valueOf(objArr[2]);
                }
                return null;
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        return null;
    }
}
