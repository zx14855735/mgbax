package com.bytedance.adsdk.ugeno.xj.hf;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.xj.kd;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.sdk.component.utils.pl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends xj {
    private List<Keyframe> f;

    /* renamed from: com.bytedance.adsdk.ugeno.xj.hf.u$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[kd.values().length];
            xj = iArr;
            try {
                iArr[kd.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[kd.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public u(Context context, com.bytedance.adsdk.ugeno.hf.w wVar, String str, Map<Float, String> map) {
        super(context, wVar, str, map);
        this.f = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public void hf() {
        Keyframe ofFloat;
        Keyframe ofFloat2;
        int i = AnonymousClass1.xj[this.u.ordinal()];
        if (i == 1) {
            ofFloat = Keyframe.ofFloat(0.0f, this.c.g());
            ofFloat2 = Keyframe.ofFloat(0.0f, this.c.am());
        } else if (i != 2) {
            ofFloat = null;
            ofFloat2 = null;
        } else {
            ofFloat = Keyframe.ofFloat(0.0f, this.c.qt());
            ofFloat2 = Keyframe.ofFloat(0.0f, this.c.zg());
        }
        if (ofFloat != null) {
            this.kd.add(ofFloat);
        }
        if (ofFloat2 != null) {
            this.f.add(ofFloat2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public List<PropertyValuesHolder> kd() {
        String hf = this.u.hf();
        u();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(hf + "X", (Keyframe[]) this.kd.toArray(new Keyframe[0]));
        this.y.add(ofKeyframe);
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(hf + "Y", (Keyframe[]) this.f.toArray(new Keyframe[0]));
        this.y.add(ofKeyframe2);
        TypeEvaluator y = y();
        if (y != null) {
            ofKeyframe.setEvaluator(y);
            ofKeyframe2.setEvaluator(y);
        }
        return this.y;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public void xj(float f, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float optDouble = (float) jSONArray.optDouble(0);
            float optDouble2 = (float) jSONArray.optDouble(1);
            if (this.u == kd.TRANSLATE) {
                optDouble = f.xj(this.xj, optDouble);
                optDouble2 = f.xj(this.xj, optDouble2);
            }
            this.kd.add(Keyframe.ofFloat(f, optDouble));
            this.f.add(Keyframe.ofFloat(f, optDouble2));
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf.xj
    public TypeEvaluator y() {
        return new FloatEvaluator();
    }
}
