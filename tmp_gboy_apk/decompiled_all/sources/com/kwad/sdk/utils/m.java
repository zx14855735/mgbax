package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Insets;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class m {
    public static String bdR = null;
    private static int bdS = -1;
    public static String bdT;

    public static String Q(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageInfo packageInfo = y.getPackageInfo(context.getApplicationContext(), str, 64);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String cN(Context context) {
        if (!TextUtils.isEmpty(bdR)) {
            return bdR;
        }
        try {
            PackageInfo packageInfo = y.getPackageInfo(context.getApplicationContext(), context.getPackageName(), 64);
            if (packageInfo == null) {
                return "";
            }
            String str = packageInfo.versionName;
            bdR = str;
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String cO(Context context) {
        if (!TextUtils.isEmpty(bdT)) {
            return bdT;
        }
        try {
            PackageInfo packageInfo = y.getPackageInfo(context, context.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            String string = context.getResources().getString(packageInfo.applicationInfo.labelRes);
            bdT = string;
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int cP(Context context) {
        int i = bdS;
        if (i > 0) {
            return i;
        }
        try {
            PackageInfo packageInfo = y.getPackageInfo(context.getApplicationContext(), context.getPackageName(), 64);
            if (packageInfo == null) {
                return 0;
            }
            int i2 = packageInfo.versionCode;
            bdS = i2;
            return i2;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int cQ(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public static int cR(Context context) {
        float f;
        float f2;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i;
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (Build.VERSION.SDK_INT >= 35) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                bounds = currentWindowMetrics.getBounds();
                windowInsets = currentWindowMetrics.getWindowInsets();
                systemBars = WindowInsets.Type.systemBars();
                insets = windowInsets.getInsets(systemBars);
                int width = bounds.width();
                i = insets.left;
                i2 = insets.right;
                f = (width - i) - i2;
                f2 = displayMetrics.density;
            } else {
                f = displayMetrics.widthPixels;
                f2 = displayMetrics.density;
            }
            return (int) (f / f2);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int cS(Context context) {
        float f;
        float f2;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i;
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (Build.VERSION.SDK_INT >= 35) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                bounds = currentWindowMetrics.getBounds();
                windowInsets = currentWindowMetrics.getWindowInsets();
                systemBars = WindowInsets.Type.systemBars();
                insets = windowInsets.getInsets(systemBars);
                int height = bounds.height();
                i = insets.top;
                i2 = insets.bottom;
                f = (height - i) - i2;
                f2 = displayMetrics.density;
            } else {
                f = displayMetrics.heightPixels;
                f2 = displayMetrics.density;
            }
            return (int) (f / f2);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static float cT(Context context) {
        if (context == null) {
            return 0.0f;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.density;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getScreenHeight(Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i;
        int i2;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insets = windowInsets.getInsets(systemBars);
            int height = bounds.height();
            i = insets.top;
            i2 = insets.bottom;
            return (height - i) - i2;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i;
        int i2;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            }
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insets = windowInsets.getInsets(systemBars);
            int width = bounds.width();
            i = insets.left;
            i2 = insets.right;
            return (width - i) - i2;
        } catch (Exception unused) {
            return 0;
        }
    }
}
