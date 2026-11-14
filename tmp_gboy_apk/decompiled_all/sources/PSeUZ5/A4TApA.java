package PSeUZ5;

import COJEAR.D6yqiO;
import COJEAR.DG07BK;
import CQhlFr.AYUAbz;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.google.android.material.slider.Slider;
import com.sigmob.sdk.downloader.f;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends CqNSpT.A4TApA {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Slider f7173B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Rect f7174B3GDIM;

    public A4TApA(Slider slider) {
        super(slider);
        this.f7174B3GDIM = new Rect();
        this.f7173B2KMhB = slider;
    }

    @Override // CqNSpT.A4TApA
    public final int AmA8tU(float f, float f2) {
        int i = 0;
        while (true) {
            Slider slider = this.f7173B2KMhB;
            if (i >= slider.getValues().size()) {
                return -1;
            }
            Rect rect = this.f7174B3GDIM;
            slider.BPw6Q8(i, rect);
            if (rect.contains((int) f, (int) f2)) {
                return i;
            }
            i++;
        }
    }

    @Override // CqNSpT.A4TApA
    public final void AzWtSf(ArrayList arrayList) {
        for (int i = 0; i < this.f7173B2KMhB.getValues().size(); i++) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    @Override // CqNSpT.A4TApA
    public final boolean B4ZgIw(int i, int i2, Bundle bundle) {
        Slider slider = this.f7173B2KMhB;
        if (!slider.isEnabled()) {
            return false;
        }
        if (i2 != 4096 && i2 != 8192) {
            if (i2 != 16908349 || bundle == null || !bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE") || !slider.BJ7GGh(bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"), i)) {
                return false;
            }
            slider.BTvldC();
            slider.postInvalidate();
            B25kr6(i);
            return true;
        }
        float f = slider.f7241EH1KK8;
        if (f == 0.0f) {
            f = 1.0f;
        }
        if ((slider.f7237DvK7DB - slider.f7236DuwtYk) / f > 20) {
            f *= Math.round(r1 / r4);
        }
        if (i2 == 8192) {
            f = -f;
        }
        if (slider.B2KMhB()) {
            f = -f;
        }
        if (!slider.BJ7GGh(com.bumptech.glide.AMqCpz.B2KMhB(slider.getValues().get(i).floatValue() + f, slider.getValueFrom(), slider.getValueTo()), i)) {
            return false;
        }
        slider.setActiveThumbIndex(i);
        CtFAbx.A2egSU a2egSU = slider.f7268G58fqA;
        slider.removeCallbacks(a2egSU);
        slider.postDelayed(a2egSU, slider.f7267Fyurov);
        slider.BTvldC();
        slider.postInvalidate();
        B25kr6(i);
        return true;
    }

    @Override // CqNSpT.A4TApA
    public final void B9tovu(int i, AYUAbz aYUAbz) {
        Object tag;
        aYUAbz.A4TApA(CQhlFr.A5SV6n.f1766AzWtSf);
        Slider slider = this.f7173B2KMhB;
        List<Float> values = slider.getValues();
        float floatValue = values.get(i).floatValue();
        float valueFrom = slider.getValueFrom();
        float valueTo = slider.getValueTo();
        if (slider.isEnabled()) {
            if (floatValue > valueFrom) {
                aYUAbz.A2egSU(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            }
            if (floatValue < valueTo) {
                aYUAbz.A2egSU(f.a.c);
            }
        }
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        try {
            valueFrom = numberInstance.parse(numberInstance.format(valueFrom)).floatValue();
            valueTo = numberInstance.parse(numberInstance.format(valueTo)).floatValue();
            floatValue = numberInstance.parse(numberInstance.format(floatValue)).floatValue();
        } catch (ParseException unused) {
            int i2 = ADYaiT.f7180GGG1xW;
        }
        AccessibilityNodeInfo.RangeInfo obtain = AccessibilityNodeInfo.RangeInfo.obtain(1, valueFrom, valueTo, floatValue);
        AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
        accessibilityNodeInfo.setRangeInfo(obtain);
        aYUAbz.AZkASS(SeekBar.class.getName());
        StringBuilder sb = new StringBuilder();
        if (slider.getContentDescription() != null) {
            sb.append(slider.getContentDescription());
            sb.append(",");
        }
        String format = String.format(((float) ((int) floatValue)) == floatValue ? "%.0f" : "%.2f", Float.valueOf(floatValue));
        String string = slider.getContext().getString(2131886525);
        if (values.size() > 1) {
            string = i == slider.getValues().size() - 1 ? slider.getContext().getString(2131886523) : i == 0 ? slider.getContext().getString(2131886524) : "";
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            tag = D6yqiO.A4TApA(slider);
        } else {
            tag = slider.getTag(2131298064);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        CharSequence charSequence = (CharSequence) tag;
        if (TextUtils.isEmpty(charSequence)) {
            Locale.getDefault();
            sb.append(string + ", " + format);
        } else if (i3 >= 30) {
            CQhlFr.ADYaiT.A5SV6n(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
        aYUAbz.AcNBzu(sb.toString());
        Rect rect = this.f7174B3GDIM;
        slider.BPw6Q8(i, rect);
        accessibilityNodeInfo.setBoundsInParent(rect);
    }
}
