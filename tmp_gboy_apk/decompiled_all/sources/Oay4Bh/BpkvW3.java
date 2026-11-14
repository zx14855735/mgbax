package Oay4Bh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BpkvW3 extends DaOi9o.B4ZgIw {
    @Override // DaOi9o.B4ZgIw
    public final void ADYaiT(DaOi9o.BmvVmW bmvVmW) {
        View view = bmvVmW.f2282A4TApA;
        if (view instanceof TextView) {
            bmvVmW.f2281A2egSU.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final void ASJ6gh(DaOi9o.BmvVmW bmvVmW) {
        View view = bmvVmW.f2282A4TApA;
        if (view instanceof TextView) {
            bmvVmW.f2281A2egSU.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // DaOi9o.B4ZgIw
    public final Animator AaHO0E(ViewGroup viewGroup, DaOi9o.BmvVmW bmvVmW, DaOi9o.BmvVmW bmvVmW2) {
        if (bmvVmW == null || bmvVmW2 == null || !(bmvVmW.f2282A4TApA instanceof TextView)) {
            return null;
        }
        View view = bmvVmW2.f2282A4TApA;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        HashMap hashMap = bmvVmW.f2281A2egSU;
        HashMap hashMap2 = bmvVmW2.f2281A2egSU;
        float floatValue = hashMap.get("android:textscale:scale") != null ? ((Float) hashMap.get("android:textscale:scale")).floatValue() : 1.0f;
        float floatValue2 = hashMap2.get("android:textscale:scale") != null ? ((Float) hashMap2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (floatValue == floatValue2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new O1Vn2F.A2egSU(1, textView));
        return ofFloat;
    }
}
