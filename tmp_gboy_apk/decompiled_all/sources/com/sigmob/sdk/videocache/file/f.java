package com.sigmob.sdk.videocache.file;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.sigmob.sdk.videocache.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13724a = 4;

    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 6 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.sigmob.sdk.videocache.file.c
    public String a(String str) {
        String b = b(str);
        String d = r.d(str);
        return TextUtils.isEmpty(b) ? d : CtFAbx.AlLFFp(d, ".", b);
    }
}
