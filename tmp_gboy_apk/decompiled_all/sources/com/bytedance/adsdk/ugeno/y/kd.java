package com.bytedance.adsdk.ugeno.y;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static boolean hf;
    private static Field xj;

    public static Drawable xj(CompoundButton compoundButton) {
        Drawable buttonDrawable;
        if (Build.VERSION.SDK_INT >= 23) {
            buttonDrawable = compoundButton.getButtonDrawable();
            return buttonDrawable;
        }
        if (!hf) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                xj = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                pl.xj("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            hf = true;
        }
        Field field = xj;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                pl.xj("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                xj = null;
            }
        }
        return null;
    }
}
