package com.bytedance.adsdk.lottie;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class jk {
    private final LottieAnimationView hf;
    private boolean u;
    private final f w;
    private final Map<String, String> xj;

    public jk() {
        this.xj = new HashMap();
        this.u = true;
        this.hf = null;
        this.w = null;
    }

    public void hf(String str, String str2) {
        this.xj.put(str, str2);
        xj();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String w(String str, String str2) {
        if (this.u && this.xj.containsKey(str2)) {
            return this.xj.get(str2);
        }
        String xj = xj(str, str2);
        if (this.u) {
            this.xj.put(str2, xj);
        }
        return xj;
    }

    public String xj(String str) {
        return str;
    }

    public String xj(String str, String str2) {
        return xj(str2);
    }

    private void xj() {
        LottieAnimationView lottieAnimationView = this.hf;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        f fVar = this.w;
        if (fVar != null) {
            fVar.invalidateSelf();
        }
    }

    public jk(LottieAnimationView lottieAnimationView) {
        this.xj = new HashMap();
        this.u = true;
        this.hf = lottieAnimationView;
        this.w = null;
    }
}
