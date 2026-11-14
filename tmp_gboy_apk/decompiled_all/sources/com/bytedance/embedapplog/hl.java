package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class hl extends n {
    private final wn kd;

    public hl(Context context, wn wnVar) {
        super(true, false);
        this.kd = wnVar;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        String xj = zm.xj(this.kd.kd());
        if (TextUtils.isEmpty(xj)) {
            return false;
        }
        jSONObject.put("cdid", xj);
        return true;
    }
}
