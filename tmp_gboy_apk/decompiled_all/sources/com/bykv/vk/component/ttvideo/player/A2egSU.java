package com.bykv.vk.component.ttvideo.player;

import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.msdk.xj.kd.w;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.zg.u;
import com.czhj.sdk.logger.SigmobLog;
import com.kwad.sdk.core.d.c;
import java.io.File;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class A2egSU {
    public static int A2egSU(int i, int i2, String str) {
        return (str.hashCode() + i) * i2;
    }

    public static int A4TApA(String str, GradientDrawable gradientDrawable, Context context, float f) {
        gradientDrawable.setColor(Color.parseColor(str));
        return r.w(context, f);
    }

    public static int A5SV6n(List list, int i, int i2) {
        return (list.hashCode() + i) * i2;
    }

    public static int ADYaiT(JSONArray jSONArray, int i, List list, int i2, int i3) {
        list.add(jSONArray.optString(i));
        return i2 + i3;
    }

    public static ADYaiT AMqCpz(SparseArray sparseArray) {
        return new ARc23Z(sparseArray).A2egSU();
    }

    public static SparseArray ARc23Z(int i, Class cls) {
        return u.xj().xj(i).xj((Class<?>) cls).hf();
    }

    public static LinearLayout.LayoutParams ASJ6gh(TextView textView, int i, int i2, int i3) {
        textView.setId(i);
        return new LinearLayout.LayoutParams(i2, i3);
    }

    public static RelativeLayout.LayoutParams AYUAbz(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(i3, i4);
        return layoutParams;
    }

    public static u AZOQYO(int i, Class cls) {
        return u.xj().xj(i).xj((Class<?>) cls);
    }

    public static String AaHO0E(int i, int i2, String str, String str2) {
        return str + i + str2 + i2;
    }

    public static String AcNBzu(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.xj());
        return sb.toString();
    }

    public static String AlLFFp(String str, File file, String str2) {
        return str + file + str2;
    }

    public static String AmA8tU(StringBuilder sb, int i, int i2, String str, char c) {
        StringBuilder replace = sb.replace(i, i2, str);
        replace.append(c);
        return replace.toString();
    }

    public static String AzWtSf(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static void B25kr6(int i, SparseArray sparseArray, int i2, int i3, int i4) {
        sparseArray.put(i2, Integer.valueOf(i));
        sparseArray.put(i4, Integer.valueOf(i3));
    }

    public static void B2KMhB(int i, SparseArray sparseArray, int i2, int i3, Class cls) {
        sparseArray.put(i2, Integer.valueOf(i));
        sparseArray.put(i3, cls);
    }

    public static void B3GDIM(int i, SparseArray sparseArray, int i2, int i3, String str) {
        sparseArray.put(i2, Integer.valueOf(i));
        sparseArray.put(i3, str);
    }

    public static void B4ZgIw(String str, int i, StringBuilder sb) {
        sb.append(str.length() % i);
    }

    public static void B7CMnp(String str, String str2, String str3) {
        c.d(str3, str + str2);
    }

    public static void B9tovu(String str, String str2, boolean z) {
        c.d(str2, str + z);
    }

    public static void BChYOn(StringBuilder sb, int i, String str) {
        sb.append(i);
        c.d(str, sb.toString());
    }

    public static void BI9f7h(StringBuilder sb, String str, String str2) {
        sb.append(str);
        w.xj(str2, sb.toString());
    }

    public static void BIYEnU(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static void BJ7GGh(Throwable th, StringBuilder sb) {
        sb.append(th.getMessage());
        SigmobLog.e(sb.toString());
    }

    public static boolean BNL6CD(f fVar, String str) {
        return TextUtils.equals(fVar.tf().getType(), str);
    }

    public static boolean BPw6Q8(String str) {
        return new File(str).exists();
    }

    public static RelativeLayout.LayoutParams BTvldC(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(i3);
        layoutParams.addRule(i4);
        return layoutParams;
    }
}
