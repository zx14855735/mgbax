package com.bytedance.adsdk.lottie.kd;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static final String hf;
    private static final String xj;

    public interface xj<T> {
        void xj(int i, String str);

        void xj(T t);
    }

    static {
        StringBuilder sb = new StringBuilder("tt_derive");
        String str = File.separator;
        xj = A2egSU.AzWtSf(sb, str, "lottie", str, "anim_img");
        hf = "tt_derive" + str + "lottie" + str + "anim_video";
        tqpEOO();
    }

    public static String hf(Context context) {
        return com.bytedance.sdk.component.utils.y.xj(context, com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().pl(), hf).getAbsolutePath();
    }

    private static /* synthetic */ void tqpEOO() {
        char[] charArray = "\u0086\u008a\u0088Ë\u0082\u0084\u0088\u0080Ë\u0087\u008a\u009cË\u0096\u008d\u0080\u0089\u0089Ë¯\u008b\u008c§\u0097\u008c\u0081\u0082\u0080".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 229);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0086\u0089\u008c\u008b\u008c\u0091".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 229);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String xj(Context context) {
        return com.bytedance.sdk.component.utils.y.xj(context, com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().pl(), xj).getAbsolutePath();
    }

    public static void xj(String str, Context context, final xj<File> xjVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            if (xjVar != null) {
                xjVar.xj(2, "url is empty");
                return;
            }
            return;
        }
        com.bytedance.sdk.component.d.hf.hf u = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().u();
        if (u == null) {
            if (xjVar != null) {
                xjVar.xj(3, "exec is null");
            }
        } else {
            final String xj2 = xj(context);
            final String hf2 = com.bytedance.sdk.component.utils.kd.hf(str);
            u.xj(str);
            u.xj(xj2, hf2);
            u.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.adsdk.lottie.kd.hf.1
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                    if (xj.this != null) {
                        File file = new File(xj2, hf2);
                        if (file.exists()) {
                            xj.this.xj(file);
                        } else {
                            xj.this.xj(4, "file not exist");
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                    xj xjVar2 = xj.this;
                    if (xjVar2 != null) {
                        xjVar2.xj(1, "net err: " + iOException.getMessage());
                    }
                }
            });
        }
    }
}
