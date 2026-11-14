package com.bytedance.sdk.component.adexpress.kd;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.xj.et;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private WeakReference<et> xj;

    public u(et etVar) {
        this.xj = new WeakReference<>(etVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<et> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().invokeMethod(str);
    }

    public void xj(et etVar) {
        this.xj = new WeakReference<>(etVar);
    }
}
