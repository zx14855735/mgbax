package com.bytedance.sdk.openadsdk.core.pl;

import com.bytedance.sdk.openadsdk.core.a.xj;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements xj.hf {

    public static class xj {
        private static hf xj = new hf();

        static {
            aWZl();
        }

        private static /* synthetic */ void aWZl() {
            char[] charArray = "ÊÆÄ\u0087ÎÈÄÌ\u0087ËÆÐ\u0087ÚÁÌÅÅ\u0087ãÇÀëÛÀÍÎÌ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 169);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÊÅÀÇÀÝ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 169);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static hf w() {
        return xj.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void hf() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void xj() {
        com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("dl_work") { // from class: com.bytedance.sdk.openadsdk.core.pl.hf.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.f.zg().xj(d.xj());
            }
        });
    }

    private hf() {
        com.bytedance.sdk.openadsdk.core.a.xj u = com.bytedance.sdk.openadsdk.core.f.zg().u();
        if (u != null) {
            u.xj(this);
        }
    }
}
