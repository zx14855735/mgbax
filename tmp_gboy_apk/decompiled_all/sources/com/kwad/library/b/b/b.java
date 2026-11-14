package com.kwad.library.b.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.kwad.components.offline.api.adInnerEc.IAdInnerEcOfflineCompo;
import com.kwad.sdk.utils.z;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b {
    private static Map<String, Resources> aui = new HashMap();
    private static final Object auj = new Object();

    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) z.a(resources.getClass(), assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    /* renamed from: com.kwad.library.b.b.b$b, reason: collision with other inner class name */
    public static final class C0342b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return c(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) z.newInstance("android.content.res.HwResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return e(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) z.newInstance("android.content.res.MiuiResourcesImpl", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    public static final class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                try {
                    return g(resources, assetManager);
                } catch (Exception unused) {
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            } catch (Exception unused2) {
                return a.a(resources, assetManager);
            }
        }

        private static Resources g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) z.newInstance("android.content.res.MiuiResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    public static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return i(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) z.newInstance("android.content.res.NubiaResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    public static final class f {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Context context, Resources resources, AssetManager assetManager) {
            try {
                return b(context, resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) z.newInstance("android.content.res.VivoResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 == null) {
                throw new RuntimeException("Can not create Resources");
            }
            try {
                z.callMethodOrThrow(resources2, "init", context.getPackageName());
            } catch (Exception e) {
                com.kwad.library.solder.lib.a.e("ResourcesManager", "createVivoResources init failed", e);
            }
            try {
                z.b(resources2, "mThemeValues", z.f(resources, "mThemeValues"));
            } catch (Exception e2) {
                com.kwad.library.solder.lib.a.e("ResourcesManager", "createVivoResources set mThemeValues failed", e2);
            }
            return resources2;
        }
    }

    static {
        QISCekm();
    }

    private static /* synthetic */ void QISCekm() {
        char[] charArray = "\u0082\u008e\u008cÏ\u0086\u0080\u008c\u0084Ï\u0083\u008e\u0098Ï\u0092\u0089\u0084\u008d\u008dÏ«\u008f\u0088£\u0093\u0088\u0085\u0086\u0084".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 225);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0082\u008d\u0088\u008f\u0088\u0095".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 225);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Resources a(Context context, Resources resources, String str) {
        Resources resources2;
        synchronized (auj) {
            try {
                resources2 = aui.get(str);
                if (resources2 == null) {
                    if (str.contains(IAdInnerEcOfflineCompo.PACKAGE_NAME)) {
                        Resources b = b(context, resources, str);
                        Objects.toString(b);
                        resources2 = new com.kwad.library.b.b.a(context.getResources(), b);
                    } else {
                        resources2 = b(context, resources, str);
                    }
                    if (resources2 == null) {
                        throw new RuntimeException("Can not createResources for ".concat(str));
                    }
                    aui.put(str, resources);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return resources2;
    }

    private static int b(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                z.callMethodOrThrow(assetManager, "addAssetPathAsSharedLibrary", str);
            } else {
                z.callMethodOrThrow(assetManager, "addAssetPath", str);
            }
        } catch (Throwable unused) {
            z.callMethodOrThrow(assetManager, "addAssetPath", str);
        }
        return 0;
    }

    private static boolean c(Resources resources) {
        return "android.content.res.VivoResources".equals(resources.getClass().getName());
    }

    private static boolean d(Resources resources) {
        return "android.content.res.NubiaResources".equals(resources.getClass().getName());
    }

    private static boolean e(Resources resources) {
        return "android.content.res.HwResources".equals(resources.getClass().getName());
    }

    private static boolean f(Resources resources) {
        return !"android.content.res.Resources".equals(resources.getClass().getName());
    }

    private static Resources b(Context context, Resources resources, String str) {
        AssetManager assetManager = (AssetManager) z.i(AssetManager.class);
        z.callMethodOrThrow(assetManager, "addAssetPath", str);
        if (context != null) {
            z.callMethod(assetManager, "addAssetPath", context.getPackageResourcePath());
        } else {
            com.kwad.library.solder.lib.a.e("ResourcesManager", "context.getPackageResourcePath(): context is null");
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            Object field = z.getField(applicationInfo, "resourceDirs");
            if (field != null && field.getClass().isArray()) {
                Object[] objArr = (Object[]) field;
                if (objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (obj instanceof String) {
                            a(assetManager, (String) obj);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            String[] strArr = applicationInfo.sharedLibraryFiles;
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str2 != null && str2.endsWith(".apk")) {
                        b(assetManager, str2);
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return a(context, assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private static void a(AssetManager assetManager, String str) {
        try {
            z.callMethodOrThrow(assetManager, "addOverlayPath", str);
        } catch (Throwable unused) {
            z.callMethodOrThrow(assetManager, "addAssetPath", str);
        }
    }

    private static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        if (a(resources)) {
            return d.a(resources, assetManager);
        }
        if (b(resources)) {
            return c.a(resources, assetManager);
        }
        if (e(resources)) {
            return C0342b.a(resources, assetManager);
        }
        if (c(resources)) {
            return f.a(context, resources, assetManager);
        }
        if (d(resources)) {
            return e.a(resources, assetManager);
        }
        if (f(resources)) {
            return a.a(resources, assetManager);
        }
        return new Resources(assetManager, displayMetrics, configuration);
    }

    private static boolean b(Resources resources) {
        return "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName());
    }

    private static boolean a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
    }
}
