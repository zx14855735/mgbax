package com.octopus.ad.internal.a.a;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.octopus.ad.internal.a.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f implements c {
    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 6 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.octopus.ad.internal.a.a.c
    public String a(String str) {
        String b = b(str);
        String d = q.d(str);
        return TextUtils.isEmpty(b) ? d : CtFAbx.AlLFFp(d, ".", b);
    }
}
