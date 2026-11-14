package com.bytedance.sdk.openadsdk.core.et.xj;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.jk;
import com.bytedance.sdk.component.y.zg;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {

    public interface hf {
        void xj(int i, String str, Throwable th);

        void xj(zg zgVar, com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.et.xj.xj$xj, reason: collision with other inner class name */
    public static class C0165xj implements hf {
        @Override // com.bytedance.sdk.openadsdk.core.et.xj.xj.hf
        public void xj(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.et.xj.xj.hf
        public void xj(zg zgVar, com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar) {
        }
    }

    public static C0165xj hf() {
        return new C0165xj();
    }

    public void xj() {
    }

    public void xj(com.bytedance.sdk.openadsdk.g.hf hfVar, hf hfVar2, int i, int i2, String str) {
        xj(hfVar, hfVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str);
    }

    public void xj(com.bytedance.sdk.openadsdk.g.hf hfVar, hf hfVar2, int i, int i2, String str, int i3, jk jkVar, boolean z) {
        xj(hfVar, hfVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3, jkVar, z);
    }

    public void xj(com.bytedance.sdk.openadsdk.g.hf hfVar, final hf hfVar2, int i, int i2, ImageView.ScaleType scaleType, String str) {
        com.bytedance.sdk.openadsdk.f.hf.xj(hfVar.xj).key(hfVar.hf).width(i).height(i2).cacheDir(str).config(Bitmap.Config.RGB_565).scaleType(scaleType).requestTime(!TextUtils.isEmpty(str)).to(new dk() { // from class: com.bytedance.sdk.openadsdk.core.et.xj.xj.1
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i3, String str2, Throwable th) {
                xj.this.xj(i3, str2, th, hfVar2);
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg zgVar) {
                xj.this.xj(zgVar, hfVar2);
            }
        });
        xj();
    }

    public void xj(com.bytedance.sdk.openadsdk.g.hf hfVar, final hf hfVar2, int i, int i2, ImageView.ScaleType scaleType, String str, int i3, jk jkVar, boolean z) {
        com.bytedance.sdk.openadsdk.f.hf.xj(hfVar.xj).key(hfVar.hf).width(i).height(i2).cacheDir(str).config(Bitmap.Config.RGB_565).scaleType(scaleType).loadSetp(jkVar).headers(z).requestTime(!TextUtils.isEmpty(str)).to(new dk() { // from class: com.bytedance.sdk.openadsdk.core.et.xj.xj.2
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i4, String str2, Throwable th) {
                xj.this.xj(i4, str2, th, hfVar2);
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg zgVar) {
                xj.this.xj(zgVar, hfVar2);
            }
        }, i3);
        xj();
    }

    public void xj(zg zgVar, hf hfVar) {
        if (hfVar != null) {
            Object result = zgVar.getResult();
            int xj = xj(zgVar);
            if (result instanceof byte[]) {
                hfVar.xj(zgVar, new com.bytedance.sdk.openadsdk.core.et.xj.hf((byte[]) result, xj));
            } else if (result instanceof Bitmap) {
                hfVar.xj(zgVar, new com.bytedance.sdk.openadsdk.core.et.xj.hf((Bitmap) result, xj));
            } else {
                hfVar.xj(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int xj(zg zgVar) {
        Map<String, String> headers = zgVar.getHeaders();
        if (headers == null) {
            return 0;
        }
        try {
            String str = headers.get("image_size");
            if (str == null || !(str instanceof String)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void xj(int i, String str, Throwable th, hf hfVar) {
        if (hfVar != null) {
            hfVar.xj(i, str, th);
        }
    }
}
