package com.bytedance.sdk.openadsdk.core.a;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pz {
    public static void xj(final Uri uri, final com.bytedance.sdk.openadsdk.core.j jVar) {
        if (jVar == null || !jVar.xj(uri)) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.pz.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.j.this.hf(uri);
                }
            });
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.hf("WebView", "TTAndroidObj handleUri exception: ".concat(String.valueOf(e)));
        }
    }

    public static void xj(final com.bytedance.sdk.component.g.w wVar, final int i, final boolean z) {
        if (wVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.pz.2
            @Override // java.lang.Runnable
            public void run() {
                String userAgentString = com.bytedance.sdk.component.g.w.this.getUserAgentString();
                if (TextUtils.isEmpty(userAgentString)) {
                    return;
                }
                StringBuilder sb = new StringBuilder(userAgentString);
                sb.append(" open_news open_news_u_s/");
                sb.append(i);
                if (z) {
                    sb.append("/");
                    sb.append(wo.d());
                }
                com.bytedance.sdk.component.g.w.this.setUserAgentString(sb.toString());
            }
        });
    }
}
