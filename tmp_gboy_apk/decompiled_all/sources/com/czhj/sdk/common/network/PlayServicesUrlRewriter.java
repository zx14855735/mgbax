package com.czhj.sdk.common.network;

import com.czhj.volley.toolbox.HurlStack;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class PlayServicesUrlRewriter implements HurlStack.UrlRewriter {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10576a = "mp_tmpl_advertising_id";
    private static final String b = "mp_tmpl_do_not_track";

    @Override // com.czhj.volley.toolbox.HurlStack.UrlRewriter
    public String rewriteUrl(String str) {
        if (!str.contains(f10576a)) {
            str.contains(b);
        }
        return str;
    }
}
