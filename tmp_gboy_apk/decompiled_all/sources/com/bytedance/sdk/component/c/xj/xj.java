package com.bytedance.sdk.component.c.xj;

import android.util.Base64;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.component.u.hf.xj {
    @Override // com.bytedance.sdk.component.u.hf.xj
    public String decrypt(String str) {
        return new String(Base64.decode(str.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }

    @Override // com.bytedance.sdk.component.u.hf.xj
    public String encrypt(String str) {
        return Base64.encodeToString(str.toString().getBytes(Charset.forName("UTF-8")), 0);
    }

    @Override // com.bytedance.sdk.component.u.hf.xj
    public int type() {
        return 32;
    }
}
