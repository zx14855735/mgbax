package com.bytedance.adsdk.ugeno.xj.hf;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.xj.kd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj {
    protected com.bytedance.adsdk.ugeno.hf.w c;
    protected String hf;
    protected kd u;
    protected Map<Float, String> w;
    protected Context xj;
    protected List<PropertyValuesHolder> y = new ArrayList();
    protected List<Keyframe> kd = new ArrayList();

    public xj(Context context, com.bytedance.adsdk.ugeno.hf.w wVar, String str, Map<Float, String> map) {
        this.xj = context;
        this.hf = str;
        this.w = map;
        this.u = kd.xj(this.hf);
        this.c = wVar;
    }

    public String getType() {
        return this.u.w();
    }

    public abstract void hf();

    public List<PropertyValuesHolder> kd() {
        String hf = this.u.hf();
        u();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(hf, (Keyframe[]) this.kd.toArray(new Keyframe[0]));
        TypeEvaluator y = y();
        if (y != null) {
            ofKeyframe.setEvaluator(y);
        }
        this.y.add(ofKeyframe);
        return this.y;
    }

    public void u() {
        Map<Float, String> map = this.w;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!xj()) {
            hf();
        }
        for (Map.Entry<Float, String> entry : this.w.entrySet()) {
            if (entry != null) {
                xj(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        w();
    }

    public void w() {
        Map<Float, String> map = this.w;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.w;
        if (map2 instanceof TreeMap) {
            Float f = (Float) ((TreeMap) map2).lastKey();
            if (f.floatValue() != 100.0f) {
                xj(100.0f, this.w.get(f));
            }
        }
    }

    public abstract void xj(float f, String str);

    public boolean xj() {
        Map<Float, String> map = this.w;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.w.containsKey(Float.valueOf(0.0f));
    }

    public abstract TypeEvaluator y();
}
