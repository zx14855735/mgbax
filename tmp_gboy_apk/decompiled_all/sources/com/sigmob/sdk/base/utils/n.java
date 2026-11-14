package com.sigmob.sdk.base.utils;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13223a = -1728053248;
    private static String b;
    private final a c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private View h;
    private View i;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f13224a = "status_bar_height";
        private static final String b = "navigation_bar_height";
        private static final String c = "navigation_bar_height_landscape";
        private static final String d = "navigation_bar_width";
        private static final String e = "config_showNavigationBar";
        private final boolean f;
        private final boolean g;
        private final int h;
        private final int i;
        private final boolean j;
        private final int k;
        private final int l;
        private final boolean m;
        private final float n;

        private a(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.m = resources.getConfiguration().orientation == 1;
            this.n = a(activity);
            this.h = a(resources, f13224a);
            this.i = a((Context) activity);
            int b2 = b(activity);
            this.k = b2;
            this.l = c(activity);
            this.j = b2 > 0;
            this.f = z;
            this.g = z2;
        }

        @SuppressLint({"NewApi"})
        private float a(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            float f = displayMetrics.widthPixels;
            float f2 = displayMetrics.density;
            return Math.min(f / f2, displayMetrics.heightPixels / f2);
        }

        public int b() {
            return this.h;
        }

        public int c() {
            return this.i;
        }

        public boolean d() {
            return this.j;
        }

        public int e() {
            return this.k;
        }

        public int f() {
            return this.l;
        }

        public int g() {
            if (this.g && a()) {
                return this.k;
            }
            return 0;
        }

        public int h() {
            if (!this.g || a()) {
                return 0;
            }
            return this.l;
        }

        @TargetApi(14)
        private int a(Context context) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        @TargetApi(14)
        private int b(Context context) {
            Resources resources = context.getResources();
            if (d(context)) {
                return a(resources, this.m ? b : c);
            }
            return 0;
        }

        @TargetApi(14)
        private int c(Context context) {
            Resources resources = context.getResources();
            if (d(context)) {
                return a(resources, d);
            }
            return 0;
        }

        @TargetApi(14)
        private boolean d(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(e, "bool", "android");
            if (identifier == 0) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            boolean z = resources.getBoolean(identifier);
            if ("1".equals(n.b)) {
                return false;
            }
            if (Constants.FAIL.equals(n.b)) {
                return true;
            }
            return z;
        }

        private int a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public int a(boolean z) {
            return (this.f ? this.h : 0) + (z ? this.i : 0);
        }

        public boolean a() {
            return this.n >= 600.0f || this.m;
        }
    }

    static {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            b = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            b = null;
        }
    }

    @TargetApi(19)
    public n(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{R.attr.windowTranslucentStatus, R.attr.windowTranslucentNavigation});
        try {
            this.d = obtainStyledAttributes.getBoolean(0, false);
            this.e = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
            int i = window.getAttributes().flags;
            if ((67108864 & i) != 0) {
                this.d = true;
            }
            if ((i & 134217728) != 0) {
                this.e = true;
            }
            a aVar = new a(activity, this.d, this.e);
            this.c = aVar;
            if (!aVar.d()) {
                this.e = false;
            }
            if (this.d) {
                a(activity, viewGroup);
            }
            if (this.e) {
                b(activity, viewGroup);
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public a a() {
        return this.c;
    }

    @TargetApi(11)
    public void b(float f) {
        if (this.d) {
            this.h.setAlpha(f);
        }
    }

    @TargetApi(11)
    public void c(float f) {
        if (this.e) {
            this.i.setAlpha(f);
        }
    }

    public void e(int i) {
        if (this.e) {
            this.i.setBackgroundColor(i);
        }
    }

    public void f(int i) {
        if (this.e) {
            this.i.setBackgroundResource(i);
        }
    }

    public void a(float f) {
        b(f);
        c(f);
    }

    public void b(int i) {
        d(i);
        f(i);
    }

    public void c(int i) {
        if (this.d) {
            this.h.setBackgroundColor(i);
        }
    }

    public void d(int i) {
        if (this.d) {
            this.h.setBackgroundResource(i);
        }
    }

    private void b(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        int i;
        this.i = new View(context);
        if (this.c.a()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.c.e());
            i = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.c.f(), -1);
            i = 8388613;
        }
        layoutParams.gravity = i;
        this.i.setLayoutParams(layoutParams);
        this.i.setBackgroundColor(f13223a);
        this.i.setVisibility(8);
        viewGroup.addView(this.i);
    }

    public void a(int i) {
        c(i);
        e(i);
    }

    public void c(Drawable drawable) {
        if (this.e) {
            this.i.setBackgroundDrawable(drawable);
        }
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.h = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.c.b());
        layoutParams.gravity = 48;
        if (this.e && !this.c.a()) {
            layoutParams.rightMargin = this.c.f();
        }
        this.h.setLayoutParams(layoutParams);
        this.h.setBackgroundColor(f13223a);
        this.h.setVisibility(8);
        viewGroup.addView(this.h);
    }

    public void b(Drawable drawable) {
        if (this.d) {
            this.h.setBackgroundDrawable(drawable);
        }
    }

    public boolean c() {
        return this.g;
    }

    public void a(Drawable drawable) {
        b(drawable);
        c(drawable);
    }

    public void b(boolean z) {
        this.g = z;
        if (this.e) {
            this.i.setVisibility(z ? 0 : 8);
        }
    }

    public void a(boolean z) {
        this.f = z;
        if (this.d) {
            this.h.setVisibility(z ? 0 : 8);
        }
    }

    public boolean b() {
        return this.f;
    }
}
