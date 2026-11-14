package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class qd extends n {
    private final Context kd;

    public qd(Context context) {
        super(true, true);
        this.kd = context;
    }

    @Override // com.bytedance.embedapplog.n
    @SuppressLint({"MissingPermission"})
    public boolean xj(JSONObject jSONObject) {
        aq.xj(jSONObject, "access", ua.xj(this.kd));
        return true;
    }
}
