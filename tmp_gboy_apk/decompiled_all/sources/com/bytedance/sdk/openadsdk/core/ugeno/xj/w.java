package com.bytedance.sdk.openadsdk.core.ugeno.xj;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.express.u;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends u {
    public w(Context context, ws wsVar, com.bytedance.sdk.openadsdk.core.ugeno.express.hf hfVar, ViewGroup viewGroup) {
        super(context, wsVar, hfVar, viewGroup);
    }

    private JSONObject am() {
        try {
            return new JSONObject(xj.xj(this.y, this.c).xj(this.y));
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u, com.bytedance.sdk.component.adexpress.hf.u
    public int w() {
        return 8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u
    public JSONObject xj() {
        return am();
    }
}
