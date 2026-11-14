package com.bytedance.embedapplog;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class gh extends n {
    public gh() {
        super(true, false);
    }

    private boolean hf() {
        String str = Build.DISPLAY;
        return (!TextUtils.isEmpty(str) && str.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(16);
        if (xj()) {
            sb.append("MIUI-");
        } else if (hf()) {
            sb.append("FLYME-");
        } else {
            String xj = d.xj();
            if (d.xj(xj)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(xj)) {
                sb.append(xj);
                sb.append("-");
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put("rom", sb.toString());
        return true;
    }

    private boolean xj() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
