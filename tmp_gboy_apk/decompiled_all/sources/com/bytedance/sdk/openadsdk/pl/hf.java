package com.bytedance.sdk.openadsdk.pl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import com.baidu.mobads.sdk.internal.an;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private String hf;
    private Map<String, String> w;
    private Uri xj;

    public hf(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest != null) {
            this.xj = webResourceRequest.getUrl();
            this.hf = webResourceRequest.getMethod();
            this.w = webResourceRequest.getRequestHeaders();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.xj = Uri.parse(str);
        this.hf = an.c;
    }

    public String hf() {
        return this.hf;
    }

    public Map<String, String> w() {
        return this.w;
    }

    public Uri xj() {
        return this.xj;
    }
}
