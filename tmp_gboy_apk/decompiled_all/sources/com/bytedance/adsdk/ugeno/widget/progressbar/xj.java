package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.y.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends w<UGProgressBar> {
    private float cu;
    private String lm;
    private int my;
    private float no;
    private int vi;
    private int xj;

    public xj(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public UGProgressBar xj() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.hf);
        uGProgressBar.xj(this);
        return uGProgressBar;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        ((UGProgressBar) this.kd).setBackgroundColor(this.my);
        ((UGProgressBar) this.kd).setText(this.lm);
        ((UGProgressBar) this.kd).setProgressBgColor(this.my);
        ((UGProgressBar) this.kd).setProgressColor(this.xj);
        ((UGProgressBar) this.kd).setTextColor(this.vi);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "progressBgColor":
                this.my = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case "textColor":
                this.vi = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case "textSize":
                this.cu = f.xj(this.hf, str2);
                break;
            case "progress":
                this.no = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case "text":
                this.lm = str2;
                break;
            case "progressColor":
                this.xj = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
        }
    }
}
