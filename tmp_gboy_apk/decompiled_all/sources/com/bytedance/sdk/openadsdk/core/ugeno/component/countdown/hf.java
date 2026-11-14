package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.adsdk.ugeno.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends com.bytedance.adsdk.ugeno.hf.w<CycleCountDownView> {
    private String lm;
    private String my;
    private String vi;
    private String xj;

    public hf(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public CycleCountDownView xj() {
        return new CycleCountDownView(this.hf);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "boxImage":
                ((CycleCountDownView) this.kd).setBoxImage(null);
                com.bytedance.adsdk.ugeno.u.xj().hf().xj(this.d, str2, new xj.InterfaceC0033xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.hf.1
                    @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
                    public void xj(Bitmap bitmap) {
                        ((CycleCountDownView) ((com.bytedance.adsdk.ugeno.hf.w) hf.this).kd).setBoxImage(bitmap);
                    }
                });
                break;
            case "before":
                this.xj = str2;
                break;
            case "finish":
                this.vi = str2;
                break;
            case "text":
                this.lm = str2;
                break;
            case "after":
                this.my = str2;
                break;
            case "boxFinishImage":
                com.bytedance.adsdk.ugeno.u.xj().hf().xj(this.d, str2, new xj.InterfaceC0033xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.hf.2
                    @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
                    public void xj(Bitmap bitmap) {
                        ((CycleCountDownView) ((com.bytedance.adsdk.ugeno.hf.w) hf.this).kd).setBoxFinish(bitmap);
                    }
                });
                break;
        }
        ((CycleCountDownView) this.kd).xj(this.xj, this.my, this.lm, this.vi);
    }

    public void xj(int i, int i2, int i3, boolean z) {
        T t = this.kd;
        if (t != 0) {
            ((CycleCountDownView) t).xj(i, i2, i3);
            ((CycleCountDownView) this.kd).setCanSkip(z);
            ((CycleCountDownView) this.kd).setClickable(z);
            ((CycleCountDownView) this.kd).setEnabled(z);
        }
    }
}
