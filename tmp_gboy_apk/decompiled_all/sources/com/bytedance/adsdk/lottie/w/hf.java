package com.bytedance.adsdk.lottie.w;

import com.baidu.mobads.sdk.internal.an;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.net.HttpURLConnection;
import java.net.URL;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements y {
    @Override // com.bytedance.adsdk.lottie.w.y
    public u xj(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(an.c);
        httpURLConnection.connect();
        return new xj(httpURLConnection);
    }
}
