package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.SoftReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class x {
    private static SoftReference<Toast> xj;

    public static void hf(Context context, String str, int i, int i2, int i3, int i4) {
        Toast xj2 = xj(context);
        if (xj2 == null) {
            pl.xj("TToast", "toast msg: ".concat(String.valueOf(str)));
            return;
        }
        xj2.setDuration(i);
        xj2.setGravity(i2, i3, i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(xj(context, 10.0f));
        gradientDrawable.setColor(Color.parseColor("#CC161823"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(xj(context, 20.0f), xj(context, 12.0f), xj(context, 20.0f), xj(context, 12.0f));
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        xj2.setView(linearLayout);
        xj2.show();
    }

    private static Toast xj(Context context) {
        if (context != null) {
            SoftReference<Toast> softReference = new SoftReference<>(Toast.makeText(context.getApplicationContext(), "", 0));
            xj = softReference;
            return softReference.get();
        }
        SoftReference<Toast> softReference2 = xj;
        if (softReference2 != null) {
            return softReference2.get();
        }
        return null;
    }

    public static Toast xj(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toast = new Toast(context);
        toast.setDuration(i);
        toast.setGravity(i2, i3, i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(xj(context, 10.0f));
        gradientDrawable.setColor(Color.parseColor("#CC161823"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(xj(context, 20.0f), xj(context, 12.0f), xj(context, 20.0f), xj(context, 12.0f));
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        return toast;
    }

    public static void xj(Context context, String str, int i) {
        hf(context, str, i, 80, 0, xj(context, 40.0f));
    }

    private static int xj(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
