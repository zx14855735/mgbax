package com.bytedance.sdk.component.adexpress.dynamic.u;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.u.hf;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p {
    private static String hf;
    private static final Set<String> xj = Collections.unmodifiableSet(new HashSet(Arrays.asList(PointCategory.DISLIKE, "close", "close-fill", "webview-close")));

    static {
        nUsl();
    }

    public static double hf(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    private static /* synthetic */ void nUsl() {
        char[] charArray = "êæä§îèäì§ëæð§úáìåå§ÃçàËûàíîì".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 137);
        }
        String str = new String(charArray);
        char[] charArray2 = "êåàçàý".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 137);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(3:181|(1:184)|185)(2:209|(1:211)(4:212|187|(5:196|197|198|(3:200|(1:206)(1:203)|204)|207)|195))|186|187|(3:189|191|193)|196|197|198|(0)|207) */
    /* JADX WARN: Removed duplicated region for block: B:200:0x047c A[Catch: Exception -> 0x0490, TryCatch #0 {Exception -> 0x0490, blocks: (B:198:0x0471, B:200:0x047c, B:204:0x0488), top: B:197:0x0471 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.bytedance.sdk.component.adexpress.dynamic.u.hf.w xj(java.lang.String r25, java.lang.String r26, java.lang.String r27, boolean r28, boolean r29, int r30, com.bytedance.sdk.component.adexpress.dynamic.w.f r31, double r32, int r34, double r35, java.lang.String r37, com.bytedance.sdk.component.adexpress.hf.g r38) {
        /*
            Method dump skipped, instructions count: 1349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.u.p.xj(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.w.f, double, int, double, java.lang.String, com.bytedance.sdk.component.adexpress.hf.g):com.bytedance.sdk.component.adexpress.dynamic.u.hf$w");
    }

    public static int[] hf(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.u.getContext());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static boolean hf() {
        return !TextUtils.isEmpty(hf);
    }

    public static String xj(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split("adx:")) == null || split.length < 2) ? "" : split[1];
    }

    private static hf.w xj(hf.w wVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            wVar.xj = 0.0f;
            wVar.hf = 0.0f;
            return wVar;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = xj(str);
        }
        if (TextUtils.isEmpty(str3)) {
            wVar.xj = 0.0f;
            wVar.hf = 0.0f;
            return wVar;
        }
        return xj(str3, str2);
    }

    public static hf.w xj(String str, String str2) {
        return xj(str, str2, false);
    }

    public static hf.w xj(String str, String str2, boolean z) {
        hf.w wVar = new hf.w();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] xj2 = xj(str, (float) hf(str2), z);
            wVar.xj = xj2[0];
            wVar.hf = xj2[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                wVar.hf = 0.0f;
                return wVar;
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return wVar;
    }

    public static int[] xj(String str, float f, boolean z) {
        int[] hf2 = hf(str, f, z);
        return new int[]{com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), hf2[0]), com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), hf2[1])};
    }

    public static String xj() {
        return hf;
    }
}
