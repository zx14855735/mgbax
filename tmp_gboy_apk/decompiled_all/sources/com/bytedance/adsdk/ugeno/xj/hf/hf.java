package com.bytedance.adsdk.ugeno.xj.hf;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.xj.kd;
import com.bytedance.adsdk.ugeno.y.f;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends xj {

    /* renamed from: com.bytedance.adsdk.ugeno.xj.hf.hf$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[kd.values().length];
            xj = iArr;
            try {
                iArr[kd.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[kd.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[kd.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                xj[kd.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                xj[kd.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                xj[kd.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                xj[kd.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                xj[kd.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                xj[kd.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public hf(Context context, com.bytedance.adsdk.ugeno.hf.w wVar, String str, TreeMap<Float, String> treeMap) {
        super(context, wVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public void hf() {
        float g;
        switch (AnonymousClass1.xj[this.u.ordinal()]) {
            case 1:
                g = this.c.g();
                break;
            case 2:
                g = this.c.am();
                break;
            case 3:
                g = this.c.qt();
                break;
            case 4:
                g = this.c.zg();
                break;
            case 5:
                g = this.c.e();
                break;
            case 6:
                g = this.c.yo();
                break;
            case 7:
                g = this.c.v();
                break;
            case 8:
                g = this.c.jk();
                break;
            case 9:
                g = this.c.pz();
                break;
            default:
                g = 0.0f;
                break;
        }
        this.kd.add(Keyframe.ofFloat(0.0f, g));
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public void xj(float f, String str) {
        this.kd.add(Keyframe.ofFloat(f, (this.hf.startsWith(kd.TRANSLATE.xj()) || this.u == kd.BORDER_RADIUS) ? f.xj(this.xj, com.bytedance.adsdk.ugeno.y.w.xj(str, 0.0f)) : com.bytedance.adsdk.ugeno.y.w.xj(str, 0.0f)));
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public TypeEvaluator y() {
        return new FloatEvaluator();
    }
}
