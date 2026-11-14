package com.bytedance.sdk.openadsdk.core.ugeno.component.xj;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.adsdk.ugeno.widget.hf.xj {
    public xj(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.hf.xj
    public String p(String str) {
        str.getClass();
        switch (str) {
            case "unmuted":
                return "tt_ugen_unmuted";
            case "back":
                return "tt_ugen_back";
            case "logo":
                return "tt_ugen_logo";
            case "close":
                return "tt_ugen_close";
            case "muted":
                return "tt_ugen_muted";
            default:
                return "";
        }
    }
}
