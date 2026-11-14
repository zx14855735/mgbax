package com.bytedance.adsdk.lottie.model;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.adsdk.lottie.model.hf.zg;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private final char hf;
    private final String kd;
    private final double u;
    private final double w;
    private final List<zg> xj;
    private final String y;

    public u(List<zg> list, char c, double d, double d2, String str, String str2) {
        this.xj = list;
        this.hf = c;
        this.w = d;
        this.u = d2;
        this.kd = str;
        this.y = str2;
    }

    public static int xj(char c, String str, String str2) {
        return str2.hashCode() + A2egSU.A2egSU(c * 31, 31, str);
    }

    public int hashCode() {
        return xj(this.hf, this.y, this.kd);
    }

    public double hf() {
        return this.u;
    }

    public List<zg> xj() {
        return this.xj;
    }
}
