package com.bytedance.sdk.openadsdk.core.a;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.openadsdk.core.et.xj.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class yo {

    public interface xj {
        void xj();

        void xj(com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar, com.bytedance.sdk.component.y.zg zgVar);
    }

    public static void xj(com.bytedance.sdk.openadsdk.g.hf hfVar, int i, int i2, final xj xjVar, String str, int i3, com.bytedance.sdk.component.y.jk jkVar, boolean z) {
        com.bytedance.sdk.component.utils.pl.u("splashLoadAd", " getImageBytes url ".concat(String.valueOf(hfVar)));
        com.bytedance.sdk.openadsdk.core.et.kd.xj().w().xj(hfVar, new xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.a.yo.1
            @Override // com.bytedance.sdk.openadsdk.core.et.xj.xj.hf
            public void xj(com.bytedance.sdk.component.y.zg zgVar, com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar2) {
                xj xjVar2;
                if (hfVar2.u() && (xjVar2 = xj.this) != null) {
                    xjVar2.xj(hfVar2, zgVar);
                    return;
                }
                xj xjVar3 = xj.this;
                if (xjVar3 != null) {
                    xjVar3.xj();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.et.xj.xj.hf
            public void xj(int i4, String str2, Throwable th) {
                xj xjVar2 = xj.this;
                if (xjVar2 != null) {
                    xjVar2.xj();
                }
            }
        }, i, i2, str, i3, jkVar, z);
    }

    public static Drawable xj(byte[] bArr, int i) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }
        return new ColorDrawable(0);
    }
}
