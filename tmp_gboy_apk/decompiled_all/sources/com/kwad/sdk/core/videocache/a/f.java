package com.kwad.sdk.core.videocache.a;

import ADYaiT.CtFAbx;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.utils.al;
import java.util.HashMap;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f implements c {
    private static String fh(String str) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (parse.getHost() == null || !parse.getHost().endsWith(".yximgs.com")) {
            return str;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        HashMap hashMap = new HashMap();
        if (parse.isHierarchical()) {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            for (String str2 : queryParameterNames) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
            buildUpon.clearQuery();
            for (String str3 : queryParameterNames) {
                if (!"tag".equals(str3) && !"di".equals(str3) && str3 != null) {
                    buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
                }
            }
        }
        return buildUpon.toString();
    }

    private static String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 6 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.kwad.sdk.core.videocache.a.c
    public final String generate(String str) {
        String fh = fh(str);
        String extension = getExtension(fh);
        String md5 = al.md5(fh);
        return TextUtils.isEmpty(extension) ? md5 : CtFAbx.AlLFFp(md5, ".", extension);
    }
}
