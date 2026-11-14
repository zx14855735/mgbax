package com.bytedance.sdk.openadsdk.core.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class r {
    private static int c = 13;
    private static float f = 0.0f;
    private static volatile float hf = -1.0f;
    private static volatile int kd = -1;
    private static volatile float u = -1.0f;
    private static volatile int w = -1;
    public static volatile int xj = -1;
    private static volatile int y = -1;

    public interface xj {
        void xj(View view);
    }

    public static boolean am(Context context) {
        String tf = wo.tf("com.kllk.feature.screen.heteromorphism");
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature(tf);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static float c(Context context) {
        xj(context);
        return u;
    }

    public static int d(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static TextView e(Context context) {
        if (context == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.xj.xj.hf().xj(context, 4.0f));
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) (kd(context) * (-0.3d));
        int w2 = w(context, 20.0f);
        int w3 = w(context, 11.0f);
        textView.setPadding(w2, w3, w2, w3);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(c);
        textView.setGravity(17);
        return textView;
    }

    public static int f(Context context) {
        xj(context);
        return w;
    }

    public static boolean g(Context context) {
        try {
            if ("V1938CT".equals(tf.hf())) {
                return false;
            }
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int hf(float f2, float f3) {
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f3 / f2) + 0.5f);
    }

    public static int kd(Context context) {
        xj(context);
        return y;
    }

    public static float p(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        }
        try {
            if (context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android") > 0) {
                return context.getApplicationContext().getResources().getDimensionPixelSize(r0);
            }
            return 0.0f;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.hf("TTUtils", "Get StatusBarHeight failed:" + th.getMessage());
            return 0.0f;
        }
    }

    public static boolean pl(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean qt(Context context) {
        String hf2 = tf.hf();
        return hf2.equals("IN2010") || hf2.equals("IN2020") || hf2.equals("KB2000");
    }

    public static int tf(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private static boolean u() {
        return hf < 0.0f || w < 0 || u < 0.0f || kd < 0 || y < 0;
    }

    private static float v(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int w(Context context, float f2) {
        xj(context);
        return (int) ((f2 * v(context)) + 0.5f);
    }

    public static int xj(float f2, float f3) {
        return (int) ((f3 * f2) + 0.5f);
    }

    public static float y(Context context) {
        xj(context);
        return hf;
    }

    public static int yo(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean zg(Context context) {
        return Build.MANUFACTURER.equals("samsung");
    }

    public static int hf(Context context, float f2) {
        xj(context);
        float c2 = c(context);
        if (c2 <= 0.0f) {
            c2 = 1.0f;
        }
        return (int) ((f2 / c2) + 0.5f);
    }

    public static int u(Context context, float f2) {
        xj(context);
        float v = v(context);
        if (v <= 0.0f) {
            v = 1.0f;
        }
        return (int) ((f2 / v) + 0.5f);
    }

    private static boolean xj(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static Bitmap c(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.draw(canvas);
        canvas.save();
        return createBitmap;
    }

    public static void f(Activity activity) {
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }

    public static void kd(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.a.r.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                r.xj(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        ofFloat.setDuration(800L);
        ofFloat.start();
    }

    public static int[] w(Context context) {
        xj(context);
        return new int[]{kd, y};
    }

    public static void xj(Context context) {
        Resources resources;
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        }
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (u()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            hf = displayMetrics.density;
            w = displayMetrics.densityDpi;
            u = displayMetrics.scaledDensity;
            kd = displayMetrics.widthPixels;
            y = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (kd > y) {
                    int i = kd;
                    kd = y;
                    y = i;
                    return;
                }
                return;
            }
            if (kd < y) {
                int i2 = kd;
                kd = y;
                y = i2;
            }
        }
    }

    public static void y(View view) {
        if (view == null) {
            return;
        }
        xj(view, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.a.r.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                onAnimationEnd(animator);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public static int[] hf(Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowManager windowManager = null;
        if (context == null) {
            return null;
        }
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused) {
        }
        int[] iArr = new int[2];
        if (windowManager != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                    bounds = currentWindowMetrics.getBounds();
                    iArr[0] = bounds.width();
                    iArr[1] = bounds.height();
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    iArr[0] = displayMetrics.widthPixels;
                    iArr[1] = displayMetrics.heightPixels;
                }
            } catch (Throwable unused2) {
            }
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int u(Context context) {
        xj(context);
        return kd;
    }

    private static void p(Activity activity) {
        Object obj;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            obj = declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            obj = null;
        }
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().startsWith("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, obj);
        } catch (Throwable unused2) {
        }
    }

    public static int[] w(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static boolean u(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean d(Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static void kd(@ForbidWrapParam Activity activity) {
        if (w()) {
            return;
        }
        try {
            final WeakReference weakReference = new WeakReference(activity);
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("check_notch") { // from class: com.bytedance.sdk.openadsdk.core.a.r.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Activity activity2 = (Activity) weakReference.get();
                                if (activity2 != null && !r.w()) {
                                    r.xj = r.u(activity2) ? 1 : 0;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static boolean tf(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && activity.getWindow().getDecorView().getHeight() > 0 && activity.getWindow().getDecorView().getWidth() > 0) {
                if (d((Context) activity) - activity.getWindow().getDecorView().getHeight() <= 0) {
                    return tf((Context) activity) - activity.getWindow().getDecorView().getWidth() > 0;
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean u(Activity activity) {
        return y(activity) || xj("ro.miui.notch", activity) == 1 || pl(activity) || g(activity) || qt(activity) || zg(activity) || tf(activity) || am(activity);
    }

    public static void w(Activity activity) {
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(2050);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static boolean y(Activity activity) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return false;
        }
    }

    public static void f(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static boolean w() {
        return xj != -1;
    }

    public static void c(Activity activity) {
        try {
            p(activity);
        } catch (Throwable unused) {
        }
    }

    public static int[] hf(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void hf(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        xj(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    public static float xj(Context context, float f2) {
        xj(context);
        return TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics());
    }

    public static void xj(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new com.bytedance.sdk.component.utils.c(rect, view));
    }

    public static void hf(Activity activity) {
        try {
            w(activity);
            activity.getWindow().addFlags(134217728);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static boolean hf() {
        return xj == 1 || xj == -1;
    }

    public static void hf(View view, final float f2) {
        if (view != null && f2 > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.a.r.7
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f2);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public static int[] xj(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void xj(View view, int i) {
        if (view == null || view.getVisibility() == i || !xj(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static void xj(View view, float f2) {
        if (view == null) {
            return;
        }
        view.setAlpha(f2);
    }

    public static boolean xj(SSWebView sSWebView) {
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return false;
        }
        sSWebView.goBack();
        return true;
    }

    public static void xj(final com.bytedance.sdk.component.g.w wVar) {
        if (wVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.1
            @Override // java.lang.Runnable
            public void run() {
                WebSettings settings;
                WebView webView = com.bytedance.sdk.component.g.w.this.getWebView();
                if (webView == null || (settings = webView.getSettings()) == null) {
                    return;
                }
                settings.setTextZoom(100);
            }
        });
    }

    public static void xj(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    private static void xj(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static boolean xj() {
        try {
            return !((KeyguardManager) com.bytedance.sdk.openadsdk.core.pz.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject xj(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.bytedance.sdk.openadsdk.core.f.zg().xj() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                jSONObject.put("lock_scene", !xj() ? 1 : 0);
            }
            if (str != null && !str.isEmpty() && !jSONObject.has("auto_show_check")) {
                jSONObject.put("auto_show_check", str);
                return jSONObject;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.w("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    public static void xj(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            hf(activity);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static void xj(View view, View view2) {
        WindowInsets rootWindowInsets;
        int safeInsetTop;
        if (view == null || view2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && f == 0.0f) {
                rootWindowInsets = view.getRootWindowInsets();
                DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
                if (displayCutout != null) {
                    safeInsetTop = displayCutout.getSafeInsetTop();
                    f = safeInsetTop;
                }
            }
            if (f == 0.0f) {
                return;
            }
            float max = Math.max(p(view2.getContext()), f);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + max);
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + max);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + max);
            }
            view2.setLayoutParams(layoutParams);
        } catch (Throwable unused) {
        }
    }

    public static int xj(String str, Activity activity) {
        com.bytedance.sdk.component.u.p pVar;
        if (!io.zg() || (pVar = (com.bytedance.sdk.component.u.p) com.bytedance.sdk.openadsdk.ats.w.xj("system_info")) == null) {
            return 0;
        }
        return pVar.getInt(str);
    }

    public static void xj(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.pl.u("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void xj(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.pl.u("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void xj(final View view, final xj xjVar) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.a.r.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.xj(view);
                }
            }
        });
    }

    public static void xj(View view, final com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (view == null || wsVar == null) {
            return;
        }
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.a.r.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                y.xj(com.bytedance.sdk.openadsdk.core.pz.getContext(), com.bytedance.sdk.openadsdk.core.ra.ws.this);
            }
        });
    }

    public static void xj(TextView textView, String str, Context context) {
        if (textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(A2egSU.A4TApA("#1F161823", gradientDrawable, context, 3.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(com.bytedance.sdk.component.utils.jk.tf(context, "tt_adx_logo_desc"));
        textView.setGravity(17);
        textView.setPadding(w(context, 2.0f), w(context, 3.0f), w(context, 2.0f), w(context, 3.0f));
    }

    public static void xj(TextView textView, com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (textView != null && wsVar != null) {
            String nn = wsVar.nn();
            if (TextUtils.isEmpty(nn)) {
                xj(textView);
                xj((View) textView, wsVar);
                return;
            } else {
                xj(textView, nn, com.bytedance.sdk.openadsdk.core.pz.getContext());
                return;
            }
        }
        xj(textView);
    }

    public static void xj(TextView textView, com.bytedance.sdk.openadsdk.core.ra.ws wsVar, int i, int i2) {
        if (textView != null && wsVar != null) {
            String nn = wsVar.nn();
            if (TextUtils.isEmpty(nn)) {
                xj(textView, i, i2);
                xj((View) textView, wsVar);
                return;
            } else {
                xj(textView, nn, com.bytedance.sdk.openadsdk.core.pz.getContext());
                return;
            }
        }
        xj(textView, i, i2);
    }

    private static void xj(TextView textView) {
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = w(com.bytedance.sdk.openadsdk.core.pz.getContext(), 32.0f);
        layoutParams.height = w(com.bytedance.sdk.openadsdk.core.pz.getContext(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    private static void xj(TextView textView, int i, int i2) {
        if (i <= 0) {
            i = 32;
        }
        if (i2 <= 0) {
            i2 = 14;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = w(com.bytedance.sdk.openadsdk.core.pz.getContext(), i);
        layoutParams.height = w(com.bytedance.sdk.openadsdk.core.pz.getContext(), i2);
        textView.setLayoutParams(layoutParams);
    }

    @Deprecated
    public static void xj(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.xj.xj.hf().xj(context, 4.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int w2 = w(context, 20.0f);
        int w3 = w(context, 11.0f);
        textView.setPadding(w2, w3, w2, w3);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(c);
        textView.setGravity(17);
        textView.setText(str);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        toast.show();
    }
}
