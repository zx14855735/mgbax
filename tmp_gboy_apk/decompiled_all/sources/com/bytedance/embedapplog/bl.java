package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class bl extends n {
    private final Context kd;
    private final wn y;

    public bl(Context context, wn wnVar) {
        super(true, false);
        this.kd = context;
        this.y = wnVar;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        Map<String, String> xj = zm.xj(this.kd, this.y.kd());
        if (xj == null) {
            return !xj.hf;
        }
        jSONObject.put("oaid", new JSONObject(xj));
        return true;
    }
}
