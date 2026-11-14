package com.sigmob.sdk.base.utils;

import Dphsd2.AZkASS;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.czhj.sdk.common.Constants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f13213a;
    private final View b;
    private final ViewGroup.LayoutParams c;

    private a(View view) {
        this.b = view;
        view.getViewTreeObserver().addOnGlobalLayoutListener(new AZkASS(2, this));
        this.c = view.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int b = b();
        if (b == this.f13213a) {
            return;
        }
        this.c.height = b;
        this.b.requestLayout();
        this.f13213a = b;
    }

    private int b() {
        Rect rect = new Rect();
        this.b.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public static void a(View view) {
        new a(view);
    }

    @SuppressLint({"LongLogTag", "PrivateApi"})
    public static boolean a(Context context) {
        String str;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
        } catch (Exception unused) {
        }
        if ("1".equals(str)) {
            return false;
        }
        if (Constants.FAIL.equals(str)) {
            return true;
        }
        return z;
    }
}
