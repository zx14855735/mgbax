package com.bytedance.msdk.api.u.xj.xj;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.u.xj.c.tf;
import com.bytedance.sdk.openadsdk.zg.w.hf.c;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface w {
    String c();

    int d();

    int f();

    c hf(Activity activity);

    c hf(Dialog dialog, Integer[] numArr);

    String hf();

    double kd();

    boolean p();

    com.bytedance.sdk.openadsdk.zg.w.hf.u pl();

    com.bytedance.msdk.api.u.xj.c.xj tf();

    String u();

    String w();

    com.bytedance.msdk.api.u.hf xj(Activity activity);

    com.bytedance.msdk.api.u.hf xj(Activity activity, Map<String, Object> map);

    String xj();

    void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tf tfVar);

    void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar);

    void xj(Dialog dialog, Integer[] numArr);

    List<String> y();
}
