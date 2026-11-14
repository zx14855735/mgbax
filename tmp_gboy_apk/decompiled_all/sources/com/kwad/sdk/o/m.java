package com.kwad.sdk.o;

import AZOQYO.ADYaiT;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class m {
    private static Application bjg;

    public static void C(Context context, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private static boolean UR() {
        if (f.UK().Tn()) {
            return true;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("please init KSPlugin"));
        return false;
    }

    public static Application US() {
        UR();
        Application UT = UT();
        if (j.UP()) {
            bjg = (Application) j.wrapContextIfNeed(UT);
        }
        return bjg;
    }

    private static Application UT() {
        Application application = bjg;
        if (application != null) {
            return application;
        }
        Context Re = ServiceProvider.Re();
        if (Re instanceof Application) {
            Application application2 = (Application) Re;
            bjg = application2;
            return application2;
        }
        Context applicationContext = Re.getApplicationContext();
        if (applicationContext instanceof Application) {
            Application application3 = (Application) applicationContext;
            bjg = application3;
            return application3;
        }
        Context et = aW(applicationContext) ? j.et(applicationContext) : k.aW(applicationContext) ? k.et(applicationContext) : Re.getApplicationContext();
        if (et instanceof Application) {
            bjg = (Application) et;
        } else {
            Application application4 = com.kwad.sdk.core.c.b.Ji().getApplication();
            if (application4 != null) {
                bjg = application4;
            } else if (et instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) et).getBaseContext();
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext instanceof Application) {
                    bjg = (Application) baseContext;
                }
            }
        }
        if (bjg == null) {
            bjg = UU();
        }
        Application ey = ey(bjg);
        bjg = ey;
        return ey;
    }

    private static Application UU() {
        Application application = (Application) z.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) z.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static boolean UV() {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT() || f.UK().UL();
    }

    public static View a(Context context, int i, ViewGroup viewGroup, boolean z) {
        return eB(context).inflate(i, viewGroup, z);
    }

    private static Context aU(Context context) {
        return context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : context;
    }

    private static boolean aW(Context context) {
        return context instanceof b;
    }

    public static void b(Application application) {
        if (bjg == null) {
            bjg = application;
        }
    }

    public static Context eA(Context context) {
        try {
            if (k.aW(context)) {
                context = k.aV(context);
            }
            if (context instanceof b) {
                context = ((b) context).getDelegatedContext();
            }
            if (ez(context)) {
                return context;
            }
            for (int i = 0; i < 5; i++) {
                if (k.aW(context)) {
                    context = k.aV(context);
                }
                if (context instanceof b) {
                    context = ((b) context).getDelegatedContext();
                }
                if (ez(context)) {
                    return context;
                }
            }
            return context;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return context;
        }
    }

    public static LayoutInflater eB(Context context) {
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        if (!k.aW(wrapContextIfNeed)) {
            return LayoutInflater.from(wrapContextIfNeed);
        }
        LayoutInflater from = LayoutInflater.from(wrapContextIfNeed);
        a(from);
        return from;
    }

    private static Context ev(Context context) {
        if (j.UP() && !aW(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW()));
            return context;
        }
        if (!j.UP() && !k.aW(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW()));
        }
        return context;
    }

    public static Context ew(Context context) {
        if (UR() && UV() && !ez(context)) {
            return ex(aW(context) ? j.es(context) : k.unwrapContextIfNeed(context));
        }
        return context;
    }

    private static Context ex(Context context) {
        if (!k.aW(context) && !(context instanceof b)) {
            return context;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW()));
        return context;
    }

    private static Application ey(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW() + "--isExternal:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT() + "--isInnerDex:" + f.UK().UL()));
        return null;
    }

    public static boolean ez(Context context) {
        return (aW(context) || k.aW(context)) ? false : true;
    }

    public static Activity getActivityFromContext(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context ew = ew(context);
        if (ew instanceof Activity) {
            return (Activity) ew;
        }
        com.kwad.sdk.core.c.b.Ji();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    public static int getThemeResId(Context context) {
        if (!(context instanceof ContextThemeWrapper)) {
            if (context instanceof ADYaiT) {
                return ((ADYaiT) context).getThemeResId();
            }
            return 0;
        }
        Object a2 = z.a((Object) context, "android.view.ContextThemeWrapper", "getThemeResId");
        if (a2 != null) {
            return ((Integer) a2).intValue();
        }
        return 0;
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        return eB(context).inflate(i, viewGroup);
    }

    public static void r(Activity activity) {
        k.onDestroy(activity);
    }

    public static Context wrapContextIfNeed(Context context) {
        if (UR() && UV()) {
            return ev(j.UP() ? j.wrapContextIfNeed(context) : k.wrapContextIfNeed(context));
        }
        return context;
    }

    public static LayoutInflater a(Context context, Context context2) {
        LayoutInflater cloneInContext = LayoutInflater.from(aU(context)).cloneInContext(context2);
        a(cloneInContext);
        return cloneInContext;
    }

    private static void a(LayoutInflater layoutInflater) {
        z.a(layoutInflater, "mFactory", (Object) null);
        z.a(layoutInflater, "mFactory2", (Object) null);
    }
}
