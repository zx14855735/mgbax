package com.bytedance.adsdk.ugeno.xj.hf;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.xj.kd;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends xj {
    public w(Context context, com.bytedance.adsdk.ugeno.hf.w wVar, String str, TreeMap<Float, String> treeMap) {
        super(context, wVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public void hf() {
        if (this.u == kd.BACKGROUND_COLOR) {
            this.kd.add(Keyframe.ofInt(0.0f, this.c.r()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public void xj(float f, String str) {
        this.kd.add(this.u == kd.BACKGROUND_COLOR ? Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.y.xj.xj(str)) : Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.y.w.xj(str, 0)));
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public TypeEvaluator y() {
        return this.u == kd.BACKGROUND_COLOR ? new ArgbEvaluator() : new IntEvaluator();
    }
}
