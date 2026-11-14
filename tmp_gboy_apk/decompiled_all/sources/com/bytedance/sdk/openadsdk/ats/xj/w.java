package com.bytedance.sdk.openadsdk.ats.xj;

import android.text.TextUtils;
import com.bytedance.sdk.component.u.p;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements p {
    private hf hf = new hf();
    private xj w = new xj();
    private boolean xj = !this.hf.xj();

    @Override // com.bytedance.sdk.component.u.p
    public String get(String str) {
        String str2 = this.hf.xj() ? this.hf.get(str) : "";
        return (this.xj && TextUtils.isEmpty(str2)) ? this.w.get(str) : str2;
    }

    @Override // com.bytedance.sdk.component.u.p
    public boolean getBoolean(String str) {
        boolean z = this.hf.xj() ? this.hf.getBoolean(str) : false;
        return (!this.xj || z) ? z : this.w.getBoolean(str);
    }

    @Override // com.bytedance.sdk.component.u.p
    public int getInt(String str) {
        int i = this.hf.xj() ? this.hf.getInt(str) : Integer.MAX_VALUE;
        return (this.xj && i == Integer.MAX_VALUE) ? this.w.getInt(str) : i;
    }

    @Override // com.bytedance.sdk.component.u.p
    public long getLong(String str) {
        long j = this.hf.xj() ? this.hf.getLong(str) : Long.MAX_VALUE;
        return (this.xj && j == 2147483647L) ? this.w.getLong(str) : j;
    }

    @Override // com.bytedance.sdk.component.u.p
    public void set(String str, String str2) {
        if (this.hf.xj()) {
            this.hf.set(str, str2);
        }
    }
}
