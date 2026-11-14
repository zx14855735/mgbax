package com.sigmob.sdk.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.models.rtb.LinkAction;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f13768a = 0;
    public static final int b = 32;
    public static final int c = 8;
    private static int d;
    private static int e;
    private static final AtomicBoolean f = new AtomicBoolean(false);

    static {
        plrM();
    }

    public static int a(Activity activity) {
        Resources resources;
        int identifier;
        if (!d(activity) || (resources = activity.getResources()) == null || (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) == 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static Activity b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static Window c(Context context) {
        Activity b2 = b(context);
        if (b2 == null) {
            return null;
        }
        return b2.getWindow();
    }

    public static void d(Context context) {
        Window c2;
        if (!f.p || (c2 = c(context)) == null) {
            return;
        }
        c2.clearFlags(1024);
    }

    public static void e(Activity activity) {
        if (Build.VERSION.SDK_INT == 26 && g(activity)) {
            h(activity);
        }
    }

    public static void f(Context context) {
        AudioManager audioManager;
        if (context != null) {
            try {
                AtomicBoolean atomicBoolean = f;
                if (!atomicBoolean.get() && (audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO)) != null) {
                    atomicBoolean.set(true);
                    audioManager.requestAudioFocus(null, 3, 2);
                }
            } catch (Throwable unused) {
                f.set(false);
            }
        }
    }

    public static void g(Context context) {
        AudioManager audioManager;
        if (context != null) {
            try {
                AtomicBoolean atomicBoolean = f;
                if (atomicBoolean.get() && (audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO)) != null) {
                    atomicBoolean.set(false);
                    audioManager.abandonAudioFocus(null);
                }
            } catch (Throwable unused) {
                f.set(true);
            }
        }
    }

    private static void h(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void i(Context context) {
        c(context);
    }

    public static void j(Context context) {
        Window c2 = c(context);
        if (c2 == null) {
            return;
        }
        c2.getDecorView().setSystemUiVisibility(f13768a);
        int i = Build.VERSION.SDK_INT;
        c2.clearFlags(Integer.MIN_VALUE);
        if (i >= 28) {
            WindowManager.LayoutParams attributes = c2.getAttributes();
            attributes.layoutInDisplayCutoutMode = 0;
            c2.setAttributes(attributes);
        }
    }

    public static boolean k(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean l(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean m(Context context) {
        return context.getPackageManager().hasSystemFeature(a("com.kllk.feature.screen.heteromorphism"));
    }

    public static int n(Context context) {
        int dipsToIntPixels = Dips.dipsToIntPixels(30.0f, com.sigmob.sdk.b.e());
        if (context == null) {
            return dipsToIntPixels;
        }
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                dipsToIntPixels = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    dipsToIntPixels = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Throwable unused) {
        }
        return dipsToIntPixels;
    }

    private static /* synthetic */ void plrM() {
        char[] charArray = "jfd'nhdl'kfp'zalee'Cg`K{`mnl".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\t');
        }
        String str = new String(charArray);
        char[] charArray2 = "je`g`}".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\t');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean b(Activity activity) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        if (activity == null) {
            activity = com.sigmob.sdk.b.i();
        }
        if (activity == null) {
            return false;
        }
        try {
            rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean c(Activity activity) {
        return b(activity) || a("ro.miui.notch", com.sigmob.sdk.b.e()) == 1 || k(com.sigmob.sdk.b.e()) || m(com.sigmob.sdk.b.e()) || l(com.sigmob.sdk.b.e());
    }

    public static boolean d(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }

    public static void e(Context context) {
        Window c2;
        if (!f.p || (c2 = c(context)) == null) {
            return;
        }
        c2.setFlags(1024, 1024);
    }

    public static boolean f(Activity activity) {
        boolean z;
        int i;
        Window window = activity != null ? activity.getWindow() : null;
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                i = window.getAttributes().layoutInDisplayCutoutMode;
                if ((i & 1) != 1) {
                    z = false;
                    if ((window.getDecorView().getSystemUiVisibility() & 1028) == 1028 || !z) {
                        return false;
                    }
                }
            }
            z = true;
            if ((window.getDecorView().getSystemUiVisibility() & 1028) == 1028) {
            }
            return false;
        }
        return true;
    }

    public static boolean g(Activity activity) {
        try {
            Field declaredField = Class.forName("com.android.internal.R$styleable").getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isTranslucentOrFloating", TypedArray.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void h(Context context) {
        int i = Build.VERSION.SDK_INT;
        Window c2 = c(context);
        if (c2 == null) {
            return;
        }
        f13768a = c2.getDecorView().getSystemUiVisibility();
        c2.clearFlags(134217728);
        c2.getDecorView().setSystemUiVisibility(f13768a | 5894);
        c2.addFlags(Integer.MIN_VALUE);
        d = c2.getStatusBarColor();
        c2.setStatusBarColor(0);
        e = c2.getNavigationBarColor();
        c2.setNavigationBarColor(0);
        if (i >= 28) {
            WindowManager.LayoutParams attributes = c2.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            c2.setAttributes(attributes);
        }
    }

    public static int a(String str, Context context) {
        if (a()) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(0))).intValue();
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    private static boolean b(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) ? false : true;
    }

    public static LinkAction a(List<LinkAction> list, Uri uri) {
        if (uri != null && !com.sigmob.sdk.base.utils.e.a(list)) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            for (LinkAction linkAction : list) {
                if (linkAction != null && linkAction.redirect_count.intValue() >= 0) {
                    if (TextUtils.isEmpty(linkAction.scheme) || TextUtils.isEmpty(linkAction.host)) {
                        if (!a(scheme, linkAction.scheme) && !b(host, linkAction.host)) {
                        }
                        return linkAction;
                    }
                    if (a(scheme, linkAction.scheme) && b(host, linkAction.host)) {
                        return linkAction;
                    }
                }
            }
        }
        return null;
    }

    public static com.sigmob.sdk.base.utils.j a(WindowInsets windowInsets) {
        int stableInsetTop;
        int stableInsetLeft;
        int stableInsetRight;
        int stableInsetBottom;
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT >= 28) {
            displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                stableInsetTop = displayCutout.getSafeInsetTop();
                stableInsetLeft = displayCutout.getSafeInsetLeft();
                stableInsetRight = displayCutout.getSafeInsetRight();
                stableInsetBottom = displayCutout.getSafeInsetBottom();
            } else {
                stableInsetTop = 0;
                stableInsetBottom = 0;
                stableInsetLeft = 0;
                stableInsetRight = 0;
            }
        } else {
            stableInsetTop = windowInsets.getStableInsetTop();
            stableInsetLeft = windowInsets.getStableInsetLeft();
            stableInsetRight = windowInsets.getStableInsetRight();
            stableInsetBottom = windowInsets.getStableInsetBottom();
        }
        return new com.sigmob.sdk.base.utils.j(stableInsetTop, stableInsetLeft, stableInsetBottom, stableInsetRight);
    }

    public static String a(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        long j2 = j / 1000;
        int i = (int) (j2 % 60);
        int i2 = (int) ((j2 / 60) % 60);
        int i3 = (int) (j2 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return (i3 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)) : formatter.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i))).toString();
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str3 = "KLLK";
        if (str.contains("KLLK")) {
            str2 = "OPPO";
        } else {
            str3 = "kllk";
            if (!str.contains("kllk")) {
                return "";
            }
            str2 = "oppo";
        }
        return str.replace(str3, str2);
    }

    public static void a(Context context, int i) {
        Activity b2 = b(context);
        if (b2 == null) {
            return;
        }
        b2.setRequestedOrientation(i);
    }

    public static void a(Window window) {
        int i = Build.VERSION.SDK_INT;
        if (window != null) {
            f13768a = window.getDecorView().getSystemUiVisibility();
            window.clearFlags(134217728);
            window.getDecorView().setSystemUiVisibility(f13768a | 1796);
            window.addFlags(Integer.MIN_VALUE);
            d = window.getStatusBarColor();
            window.setStatusBarColor(0);
            e = window.getNavigationBarColor();
            window.setNavigationBarColor(0);
            if (i >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
        }
    }

    public static boolean a() {
        try {
            Class.forName("miui.os.Build");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    private static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.toLowerCase().equals(str2)) ? false : true;
    }
}
