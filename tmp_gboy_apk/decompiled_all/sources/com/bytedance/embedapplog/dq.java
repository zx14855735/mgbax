package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class dq extends n {
    private final Context kd;
    private final wn y;

    public dq(Context context, wn wnVar) {
        super(true, false);
        this.kd = context;
        this.y = wnVar;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        String xj = xj.g() != null ? xj.g().en().xj() : "";
        if (TextUtils.isEmpty(xj)) {
            return true;
        }
        jSONObject.put("mc", xj);
        return true;
    }
}
