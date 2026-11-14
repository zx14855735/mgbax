package com.bytedance.sdk.openadsdk.x;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {
    public static volatile com.bykv.vk.openvk.component.video.api.xj.hf hf = null;
    private static String kd = null;
    private static String u = null;
    public static volatile com.bykv.vk.openvk.component.video.api.xj.hf w = null;
    public static String xj = null;
    private static int y = 1;

    private static com.bykv.vk.openvk.component.video.api.xj.hf c() {
        if (hf == null) {
            synchronized (d.class) {
                try {
                    if (hf == null) {
                        com.bykv.vk.openvk.component.video.xj.xj.xj.xj xjVar = new com.bykv.vk.openvk.component.video.xj.xj.xj.xj();
                        hf = xjVar;
                        xjVar.xj(d());
                        hf.kd();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    private static String d() {
        if (!TextUtils.isEmpty(xj)) {
            return xj;
        }
        int nt = pz.hf().nt();
        y = nt;
        String hf2 = hf(nt);
        xj = hf2;
        return hf2;
    }

    private static com.bykv.vk.openvk.component.video.api.xj.hf f() {
        if (w == null) {
            synchronized (d.class) {
                try {
                    if (w == null) {
                        com.bytedance.sdk.component.pl.hf.xj.xj xjVar = new com.bytedance.sdk.component.pl.hf.xj.xj();
                        w = xjVar;
                        xjVar.xj(d());
                        w.kd();
                    }
                } finally {
                }
            }
        }
        return w;
    }

    private static String hf(int i) {
        File xj2;
        Context context = pz.getContext();
        if (i == 1) {
            pl.xj("CacheDirConstants", "使用内部存储");
            xj2 = com.bytedance.sdk.component.utils.y.hf(context, com.bytedance.sdk.openadsdk.core.multipro.hf.w(), "tt_ad");
        } else {
            pl.xj("CacheDirConstants", "使用外部存储");
            xj2 = com.bytedance.sdk.component.utils.y.xj(context, com.bytedance.sdk.openadsdk.core.multipro.hf.w(), "tt_ad");
        }
        if (xj2.isFile()) {
            xj2.delete();
        }
        if (!xj2.exists()) {
            xj2.mkdirs();
        }
        return xj2.getAbsolutePath();
    }

    public static String kd() {
        if (u == null) {
            u = xj("splash_image");
        }
        return u;
    }

    public static int u() {
        return y;
    }

    public static long[] w() {
        return new long[]{10485760, 20971520, 31457280, 20971520, 10485760, 20971520, 31457280, 20971520};
    }

    public static com.bykv.vk.openvk.component.video.api.xj.hf xj(int i) {
        return i == 1 ? f() : c();
    }

    public static String y() {
        if (kd == null) {
            kd = xj("image");
        }
        return kd;
    }

    public static String xj() {
        StringBuilder sb = new StringBuilder();
        sb.append(d());
        return CtFAbx.B25kr6(sb, File.separator, "video_brand");
    }

    public static String xj(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(d());
        return CtFAbx.B25kr6(sb, File.separator, str);
    }

    public static String[] hf() {
        String hf2 = hf(1);
        com.bytedance.sdk.component.pl.hf.xj.xj xjVar = new com.bytedance.sdk.component.pl.hf.xj.xj();
        xjVar.xj(hf2);
        String hf3 = hf(0);
        com.bytedance.sdk.component.pl.hf.xj.xj xjVar2 = new com.bytedance.sdk.component.pl.hf.xj.xj();
        xjVar2.xj(hf3);
        return new String[]{xjVar.hf(), xjVar.w(), xjVar.xj(), xjVar.u(), xjVar2.hf(), xjVar2.w(), xjVar2.xj(), xjVar2.u()};
    }
}
