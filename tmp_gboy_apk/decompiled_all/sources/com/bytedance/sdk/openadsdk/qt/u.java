package com.bytedance.sdk.openadsdk.qt;

import android.text.TextUtils;
import com.bytedance.embedapplog.kd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private kd.xj hf;
    private String xj;

    public u(kd.xj xjVar) {
        this.hf = xjVar;
        if (xjVar == null || TextUtils.isEmpty(xjVar.xj) || TextUtils.equals("00000000-0000-0000-0000-000000000000", xjVar.xj)) {
            this.xj = "error";
        }
    }

    public String getType() {
        return this.xj;
    }

    public kd.xj xj() {
        return this.hf;
    }

    public u(String str) {
        this.xj = str;
    }
}
