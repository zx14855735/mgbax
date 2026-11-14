package com.bytedance.sdk.openadsdk.core.pl;

import com.bytedance.sdk.openadsdk.core.pz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements u {
    private w hf;
    private List<u> xj = new ArrayList();

    public y() {
        w wVar = new w(pz.hf().xv());
        this.hf = wVar;
        this.xj.add(new kd(wVar));
        this.xj.add(new c(this.hf));
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u
    public boolean xj(String str, String str2, String str3, int i, String str4, String str5, int i2, String str6, String str7) {
        Iterator<u> it = this.xj.iterator();
        while (it.hasNext()) {
            if (it.next().xj(str, str2, str3, i, str4, str5, i2, str6, str7)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u
    public boolean xj(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        Iterator<u> it = this.xj.iterator();
        while (it.hasNext()) {
            if (it.next().xj(str, str2, str3, str4, i, str5, str6)) {
                return true;
            }
        }
        return false;
    }
}
