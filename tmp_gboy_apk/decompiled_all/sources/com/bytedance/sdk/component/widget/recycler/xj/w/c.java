package com.bytedance.sdk.component.widget.recycler.xj.w;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private static Method hf;
    private static boolean kd;
    private static Field u;
    private static boolean w;
    private static Field xj;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                hf = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                pl.xj("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static Display c(View view) {
        return view.getDisplay();
    }

    public static int d(View view) {
        int importantForAutofill;
        if (Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        importantForAutofill = view.getImportantForAutofill();
        return importantForAutofill;
    }

    public static boolean f(View view) {
        return view.isAttachedToWindow();
    }

    public static float hf(ViewConfiguration viewConfiguration, Context context) {
        float scaledVerticalScrollFactor;
        if (Build.VERSION.SDK_INT < 26) {
            return w(viewConfiguration, context);
        }
        scaledVerticalScrollFactor = viewConfiguration.getScaledVerticalScrollFactor();
        return scaledVerticalScrollFactor;
    }

    public static int kd(View view) {
        return view.getMinimumHeight();
    }

    public static void tf(View view) {
        view.stopNestedScroll();
    }

    public static int u(View view) {
        return view.getMinimumWidth();
    }

    private static float w(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = hf) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                pl.xj("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int xj(View view) {
        return view.getLayoutDirection();
    }

    public static boolean y(View view) {
        return view.hasTransientState();
    }

    public static int hf(View view) {
        return view.getImportantForAccessibility();
    }

    public static void xj(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void hf(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static void xj(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static float xj(ViewConfiguration viewConfiguration, Context context) {
        float scaledHorizontalScrollFactor;
        if (Build.VERSION.SDK_INT < 26) {
            return w(viewConfiguration, context);
        }
        scaledHorizontalScrollFactor = viewConfiguration.getScaledHorizontalScrollFactor();
        return scaledHorizontalScrollFactor;
    }

    public static void xj(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void w(View view) {
        view.postInvalidateOnAnimation();
    }

    public static boolean xj(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
