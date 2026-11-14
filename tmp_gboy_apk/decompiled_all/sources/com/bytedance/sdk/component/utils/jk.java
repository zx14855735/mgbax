package com.bytedance.sdk.component.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class jk {
    private static String hf;
    private static boolean kd;
    private static String u;
    private static Resources w;

    @SuppressLint({"StaticFieldLeak"})
    private static Context xj;
    private static boolean y;

    public static int c(Context context, String str) {
        return xj(context, str, "layout");
    }

    public static int d(Context context, String str) {
        return xj(context, str, "dimen");
    }

    public static int f(Context context, String str) {
        return xj(context, str, "style");
    }

    public static int hf(Context context, String str) {
        return xj(context, str, "string");
    }

    public static int kd(Context context, String str) {
        try {
            return xj(context, str, "drawable");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int p(Context context, String str) {
        return xj(context, str, "color");
    }

    public static int pl(Context context, String str) {
        return xj(context, str, "anim");
    }

    public static int tf(Context context, String str) {
        return xj(context).getColor(p(context, str));
    }

    public static Bitmap u(Context context, String str) {
        return BitmapFactory.decodeResource(xj(context), kd(context, str));
    }

    private static String w(Context context) {
        if (u == null) {
            u = context.getPackageName();
        }
        return u;
    }

    private static int xj(Context context, String str, String str2) {
        int identifier = xj(context).getIdentifier(str, str2, w(context));
        if (identifier != 0) {
            return identifier;
        }
        if (kd) {
            return context.getResources().getIdentifier(str, str2, w(context));
        }
        hf(context);
        return xj(context).getIdentifier(str, str2, w(context));
    }

    public static int y(Context context, String str) {
        return xj(context, str, com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
    }

    public static synchronized void hf(Context context) {
        synchronized (jk.class) {
            try {
                if (TextUtils.isEmpty(hf)) {
                    return;
                }
                Resources resources = context.getResources();
                w = new Resources(hf(resources.getAssets(), hf + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
                u = context.getPackageName();
                kd = true;
            } catch (Throwable th) {
                pl.w("ResourceHelp", "makePluginResources failed", th);
            }
        }
    }

    public static Drawable w(Context context, String str) {
        try {
            return xj(context).getDrawable(kd(context, str));
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }

    public static String xj(Context context, String str) {
        return xj(context).getString(hf(context, str));
    }

    public static void xj(Context context, String str, ImageView imageView) {
        Drawable drawable = xj(context).getDrawable(kd(context, str));
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static void xj(Context context, String str, View view) {
        Drawable drawable = xj(context).getDrawable(kd(context, str));
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    private static AssetManager hf(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            xj(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            xj(assetManager, str);
        }
        try {
            q.xj(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static Resources xj(Context context) {
        Resources resources = w;
        if (resources == null) {
            resources = null;
        }
        Context context2 = xj;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static boolean xj(AssetManager assetManager, String str) {
        Method xj2 = q.xj((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (xj2 == null) {
            xj2 = q.xj((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (xj2 != null) {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i < 0) {
                    break;
                }
                if (((Integer) xj2.invoke(assetManager, str)).intValue() != 0) {
                    return true;
                }
                i = i2;
            }
        }
        return false;
    }
}
