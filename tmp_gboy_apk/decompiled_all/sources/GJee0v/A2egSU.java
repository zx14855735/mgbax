package GJee0v;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {
    static {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            cls.getMethod("currentActivityThread", new Class[0]);
            cls.getDeclaredField("mActivities").setAccessible(true);
        } catch (Exception unused) {
        }
        try {
            Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
            cls2.getDeclaredField("paused").setAccessible(true);
            cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY).setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Context A2egSU() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            Application application = (Application) declaredField.get(invoke);
            if (application != null) {
                return application.getApplicationContext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Context A4TApA(WeakReference weakReference) {
        if (weakReference != null) {
            try {
                if (weakReference.get() != null) {
                    return (Context) weakReference.get();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        Context A2egSU2 = A2egSU();
        if (A2egSU2 != null) {
            return A2egSU2;
        }
        return null;
    }

    public static Activity A5SV6n() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
