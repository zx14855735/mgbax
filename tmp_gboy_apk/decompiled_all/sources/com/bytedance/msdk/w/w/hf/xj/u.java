package com.bytedance.msdk.w.w.hf.xj;

import com.bytedance.msdk.w.w.hf.xj.hf.c;
import com.bytedance.msdk.w.w.hf.xj.hf.kd;
import com.bytedance.msdk.w.w.hf.xj.hf.p;
import com.bytedance.msdk.w.w.hf.xj.hf.pl;
import com.bytedance.msdk.w.w.hf.xj.hf.tf;
import com.bytedance.msdk.w.w.hf.xj.hf.y;
import com.bytedance.msdk.w.w.hf.xj.xj.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static com.bytedance.msdk.w.xj.xj xj(com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.w.xj.hf hfVar2) {
        if (hfVar == null) {
            return null;
        }
        int qt = hfVar.qt();
        switch (hfVar.io()) {
            case 1:
                return new com.bytedance.msdk.w.w.hf.xj.hf.xj(hfVar2);
            case 2:
                return new c(hfVar2);
            case 3:
                return new pl(hfVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                return qt == 4 ? new tf(hfVar2) : qt == 5 ? new kd(hfVar2) : qt == 3 ? new com.bytedance.msdk.w.w.hf.xj.hf.xj(hfVar2) : new tf(hfVar2);
            case 7:
                return qt == 6 ? new p(hfVar2) : qt == 7 ? new y(hfVar2) : new p(hfVar2);
            case 8:
                return new y(hfVar2);
            case 9:
                return new kd(hfVar2);
            case 10:
                if (qt == 1) {
                    return new c(hfVar2);
                }
                if (qt == 2) {
                    return new y(hfVar2);
                }
                return null;
        }
    }

    public static com.bytedance.msdk.w.xj.xj xj(String str, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.w.xj.hf hfVar2) {
        if (hfVar == null) {
            return null;
        }
        int qt = hfVar.qt();
        switch (hfVar.io()) {
            case 1:
                return new com.bytedance.msdk.w.w.hf.xj.xj.xj(str, hfVar2);
            case 2:
                return new com.bytedance.msdk.w.w.hf.xj.xj.y(str, hfVar2);
            case 3:
                return new f(str, hfVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (qt == 4) {
                    return new com.bytedance.msdk.w.w.hf.xj.xj.u(str, hfVar2);
                }
                if (qt == 5) {
                    return new com.bytedance.msdk.w.w.hf.xj.xj.w(str, hfVar2);
                }
                if (qt == 3) {
                    return new com.bytedance.msdk.w.w.hf.xj.xj.xj(str, hfVar2);
                }
                return new com.bytedance.msdk.w.w.hf.xj.xj.u(str, hfVar2);
            case 7:
                if (qt == 6) {
                    return new com.bytedance.msdk.w.w.hf.xj.xj.c(str, hfVar2);
                }
                if (qt == 7) {
                    return new com.bytedance.msdk.w.w.hf.xj.xj.kd(str, hfVar2);
                }
                return new com.bytedance.msdk.w.w.hf.xj.xj.c(str, hfVar2);
            case 8:
                return new com.bytedance.msdk.w.w.hf.xj.xj.kd(str, hfVar2);
            case 9:
                return new com.bytedance.msdk.w.w.hf.xj.xj.w(str, hfVar2);
            case 10:
                if (qt == 1) {
                    return new com.bytedance.msdk.w.w.hf.xj.xj.y(str, hfVar2);
                }
                if (qt == 2) {
                    return new com.bytedance.msdk.w.w.hf.xj.xj.kd(str, hfVar2);
                }
                return null;
        }
    }
}
