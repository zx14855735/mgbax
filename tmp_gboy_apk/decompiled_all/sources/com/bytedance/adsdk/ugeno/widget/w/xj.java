package com.bytedance.adsdk.ugeno.widget.w;

import android.content.Context;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj extends com.bytedance.adsdk.ugeno.hf.xj<UGFrameLayout> {
    public xj(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                hf(str, str2);
                break;
        }
    }
}
