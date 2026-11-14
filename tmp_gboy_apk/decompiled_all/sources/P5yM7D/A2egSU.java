package P5yM7D;

import BPw6Q8.ASJ6gh;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.TypedValue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A2egSU {
    /* JADX INFO: Access modifiers changed from: private */
    public static Drawable A4TApA(Context context, int i) {
        ColorStateList colorStateList;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(1);
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) gradientDrawable, i, i, i, i);
        ColorStateList valueOf = ColorStateList.valueOf(0);
        TypedValue A2egSU2 = P3rngT.A4TApA.A2egSU(context, 2130968853);
        if (A2egSU2 != null) {
            int i2 = A2egSU2.resourceId;
            colorStateList = i2 != 0 ? ASJ6gh.A5SV6n(context, i2) : ColorStateList.valueOf(A2egSU2.data);
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            valueOf = colorStateList;
        }
        return new RippleDrawable(valueOf, null, insetDrawable);
    }
}
