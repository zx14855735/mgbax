package com.ss.android.socialbase.downloader.xj;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.tf.y;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    private volatile boolean c;
    private final Application.ActivityLifecycleCallbacks f;
    private w hf;
    private WeakReference<Activity> kd;
    private int u;
    private final List<InterfaceC0510xj> w;
    private Application xj;
    private volatile int y;

    public static class hf {
        private static final xj xj = new xj();

        static {
            uggXkbl();
        }

        private static /* synthetic */ void uggXkbl() {
            char[] charArray = "_SQ\u0012[]QY\u0012^SE\u0012OTYPP\u0012vRU~NUX[Y".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '<');
            }
            String str = new String(charArray);
            char[] charArray2 = "_PURUH".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '<');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public interface w {
    }

    /* renamed from: com.ss.android.socialbase.downloader.xj.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0510xj {
        void hf();

        void w();
    }

    private boolean c() {
        try {
            Application application = this.xj;
            if (application == null) {
                return false;
            }
            application.getSystemService(TTDownloadField.TT_ACTIVITY);
            return TextUtils.equals(application.getPackageName(), y.u(application));
        } catch (Throwable th) {
            pl.xj(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        this.y = 1;
        Object[] u = u();
        if (u != null) {
            for (Object obj : u) {
                ((InterfaceC0510xj) obj).hf();
            }
        }
    }

    private Object[] u() {
        Object[] array;
        synchronized (this.w) {
            try {
                array = this.w.size() > 0 ? this.w.toArray() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.y = 0;
        Object[] u = u();
        if (u != null) {
            for (Object obj : u) {
                ((InterfaceC0510xj) obj).w();
            }
        }
    }

    private xj() {
        this.w = new ArrayList();
        this.y = -1;
        this.c = false;
        this.f = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.xj.xj.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                xj.this.c = true;
                if (xj.this.u != 0 || activity == null) {
                    return;
                }
                xj.this.u = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = xj.this.u;
                xj.this.c = false;
                xj.this.u = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    xj.this.kd();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                xj.this.kd = new WeakReference(activity);
                int i = xj.this.u;
                xj.this.u = activity != null ? activity.hashCode() : i;
                xj.this.c = false;
                if (i == 0) {
                    xj.this.kd();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == xj.this.u) {
                    xj.this.u = 0;
                    xj.this.y();
                }
                xj.this.c = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    public boolean hf() {
        int i = this.y;
        int i2 = i;
        if (i == -1) {
            ?? c = c();
            this.y = c;
            i2 = c;
        }
        return i2 == 1;
    }

    public boolean w() {
        return hf() && !this.c;
    }

    public static xj xj() {
        return hf.xj;
    }

    public void hf(InterfaceC0510xj interfaceC0510xj) {
        synchronized (this.w) {
            this.w.remove(interfaceC0510xj);
        }
    }

    public void xj(Context context) {
        if (this.xj == null && (context instanceof Application)) {
            synchronized (this) {
                try {
                    if (this.xj == null) {
                        Application application = (Application) context;
                        this.xj = application;
                        application.registerActivityLifecycleCallbacks(this.f);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void xj(w wVar) {
        this.hf = wVar;
    }

    public void xj(InterfaceC0510xj interfaceC0510xj) {
        if (interfaceC0510xj == null) {
            return;
        }
        synchronized (this.w) {
            try {
                if (!this.w.contains(interfaceC0510xj)) {
                    this.w.add(interfaceC0510xj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
