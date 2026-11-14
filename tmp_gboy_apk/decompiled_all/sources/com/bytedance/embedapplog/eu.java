package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class eu extends n {
    private final Context kd;
    private final wn y;

    public eu(Context context, wn wnVar) {
        super(true, false);
        this.kd = context;
        this.y = wnVar;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.y.a())) {
            jSONObject.put("ab_client", this.y.a());
        }
        if (!TextUtils.isEmpty(this.y.jk())) {
            if (cu.hf) {
                cu.xj("init config has abversion:" + this.y.jk(), null);
            }
            jSONObject.put("ab_version", this.y.jk());
        }
        if (!TextUtils.isEmpty(this.y.wo())) {
            jSONObject.put("ab_group", this.y.wo());
        }
        if (TextUtils.isEmpty(this.y.r())) {
            return true;
        }
        jSONObject.put("ab_feature", this.y.r());
        return true;
    }
}
