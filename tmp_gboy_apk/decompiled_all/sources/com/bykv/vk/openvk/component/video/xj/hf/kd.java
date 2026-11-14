package com.bykv.vk.openvk.component.video.xj.hf;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bykv.vk.openvk.component.video.xj.hf.xj.w;
import java.lang.reflect.Method;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    public static volatile Integer d;
    static volatile com.bykv.vk.openvk.component.video.xj.hf.xj.w hf;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context p;
    private static volatile com.bykv.vk.openvk.component.video.xj.hf.hf.w tf;
    public static volatile boolean u;
    static volatile com.bykv.vk.openvk.component.video.xj.hf.xj.hf xj;
    static volatile boolean y;
    public static final boolean w = com.bytedance.sdk.component.utils.pl.w();
    static volatile boolean kd = true;
    static volatile int c = 0;
    public static volatile int f = 3;

    static {
        Vamr();
    }

    private static /* synthetic */ void Vamr() {
        char[] charArray = "OCA\u0002KMAI\u0002NCU\u0002_DI@@\u0002fBEn^EHKI".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ',');
        }
        String str = new String(charArray);
        char[] charArray2 = "O@EBEX".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ',');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Context getContext() {
        return p;
    }

    public static void hf(boolean z) {
        y = z;
    }

    public static void xj(boolean z) {
        kd = z;
    }

    public static com.bykv.vk.openvk.component.video.xj.hf.xj.hf hf() {
        return xj;
    }

    public static void xj(int i) {
        c = i;
    }

    public static void xj(com.bykv.vk.openvk.component.video.xj.hf.xj.w wVar, Context context) {
        if (wVar != null && context != null) {
            p = context.getApplicationContext();
            if (hf != null) {
                return;
            }
            com.bykv.vk.openvk.component.video.xj.hf.xj.hf hfVar = xj;
            if (hfVar != null && hfVar.xj.getAbsolutePath().equals(wVar.xj.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
            }
            hf = wVar;
            tf = com.bykv.vk.openvk.component.video.xj.hf.hf.w.xj(context);
            hf.xj(new w.xj() { // from class: com.bykv.vk.openvk.component.video.xj.hf.kd.1
                @Override // com.bykv.vk.openvk.component.video.xj.hf.xj.w.xj
                public void xj(String str) {
                    if (kd.w) {
                        com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_DiskLruCache", "new cache created: ".concat(String.valueOf(str)));
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.xj.hf.xj.w.xj
                public void xj(Set<String> set) {
                    kd.tf.xj(set, 0);
                    if (kd.w) {
                        com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_DiskLruCache", "cache file removed, ".concat(String.valueOf(set)));
                    }
                }
            });
            y xj2 = y.xj();
            xj2.xj(wVar);
            xj2.xj(tf);
            u w2 = u.w();
            w2.xj(wVar);
            w2.xj(tf);
            return;
        }
        throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
    }

    public static com.bykv.vk.openvk.component.video.xj.hf.xj.w xj() {
        return hf;
    }
}
