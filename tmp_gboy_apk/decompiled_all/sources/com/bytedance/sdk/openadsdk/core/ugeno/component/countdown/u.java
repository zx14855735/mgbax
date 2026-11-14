package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends xj {
    private String cu;
    private int no;
    private String vi;

    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xj
    public void xj(int i, int i2, int i3) {
        if (i3 <= 0 && !TextUtils.isEmpty(((xj) this).lm)) {
            String str = ((xj) this).lm;
            ((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj = str;
            pl(str);
            return;
        }
        int i4 = this.no;
        int i5 = i4 - i2;
        if (i4 <= 0) {
            ((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj = this.cu;
        } else if (i5 > 0) {
            ((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj = this.vi;
        } else {
            ((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj = this.cu;
        }
        String replace = ((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj.replace("${_countdownTime_}", String.valueOf(i5)).replace("${_remainTime_}", String.valueOf(i3));
        ((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj = replace;
        pl(replace);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xj, com.bytedance.adsdk.ugeno.widget.text.hf, com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        char c;
        super.xj(str, str2);
        str.getClass();
        switch (str.hashCode()) {
            case 110256292:
                if (str.equals("text1")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 110256293:
                if (str.equals("text2")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 996930575:
                if (str.equals("startCountDown")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.vi = str2;
                break;
            case 1:
                this.cu = str2;
                break;
            case 2:
                this.no = com.bytedance.adsdk.ugeno.y.w.xj(str2, -1);
                break;
        }
    }
}
