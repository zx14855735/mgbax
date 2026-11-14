package com.bytedance.sdk.component.p.kd.xj.xj;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements com.bytedance.sdk.component.p.kd.xj.xj {
    @Override // com.bytedance.sdk.component.p.kd.xj.xj
    public Object xj(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
