package com.bytedance.sdk.openadsdk.core.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Application.ActivityLifecycleCallbacks {
    public static long hf;
    public static long w;
    public static boolean xj;
    private Handler am;
    private volatile WeakReference<Activity> g;
    private volatile Application.ActivityLifecycleCallbacks kd;
    private volatile WeakReference<Activity> qt;
    private volatile InterfaceC0134xj u;
    private volatile hf y;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final HashSet<Integer> f = new HashSet<>();
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.xj>> d = new CopyOnWriteArrayList<>();
    private volatile CopyOnWriteArrayList<hf> tf = new CopyOnWriteArrayList<>();
    private final ArrayList<String> p = new ArrayList<>();

    /* renamed from: pl, reason: collision with root package name */
    private SparseArray<Set<Runnable>> f10278pl = new SparseArray<>();

    public interface hf {
        void hf();

        void xj();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.a.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0134xj {
        void xj();
    }

    private void c() {
        if (!com.bytedance.sdk.openadsdk.core.f.zg().z() && hf()) {
            com.bytedance.sdk.component.tf.c.w(new com.bytedance.sdk.component.tf.d("reportSdkUseTime") { // from class: com.bytedance.sdk.openadsdk.core.a.xj.6
                @Override // java.lang.Runnable
                public void run() {
                    xj.xj = false;
                    xj.w = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(xj.hf / 1000, xj.w / 1000, !com.bytedance.sdk.openadsdk.core.v.hf.get() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.v.hf.set(false);
                }
            });
        }
    }

    private void f() {
        if (com.bytedance.sdk.openadsdk.core.f.zg().z()) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.c.hf(new com.bytedance.sdk.component.tf.d("upload_dpl") { // from class: com.bytedance.sdk.openadsdk.core.a.xj.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.u.hf.w xj2 = com.bytedance.sdk.openadsdk.core.hf.xj();
                long j = xj2.get("save_jump_success_time", 0L);
                if (j <= 0) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - j;
                if (currentTimeMillis >= 86400000 || currentTimeMillis <= 0) {
                    return;
                }
                String str = xj2.get("save_jump_success_ad_tag", "");
                String str2 = xj2.get("save_dpl_success_materialmeta", "");
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                xj2.remove("save_dpl_success_materialmeta");
                com.bytedance.sdk.openadsdk.core.am.u.xj(currentTimeMillis, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(@ForbidWrapParam Activity activity) {
        if (activity != null) {
            this.f.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.kd != null) {
            this.kd.onActivityDestroyed(activity);
        }
        if (this.d != null && this.d.size() > 0) {
            Iterator<WeakReference<com.bytedance.sdk.component.adexpress.xj>> it = this.d.iterator();
            while (it.hasNext()) {
                WeakReference<com.bytedance.sdk.component.adexpress.xj> next = it.next();
                if (next != null && next.get() != null) {
                    try {
                        next.get().xj(activity);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.pl.xj(th);
                    }
                }
            }
        }
        if (this.g != null && this.g.get() == activity) {
            this.g = null;
        }
        if (activity != null) {
            int hashCode = activity.hashCode();
            synchronized (this.f10278pl) {
                try {
                    Set<Runnable> set = this.f10278pl.get(hashCode);
                    if (set != null) {
                        for (Runnable runnable : set) {
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                        this.f10278pl.remove(hashCode);
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
        if (this.kd != null) {
            this.kd.onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@ForbidWrapParam final Activity activity) {
        kd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.xj.5
            @Override // java.lang.Runnable
            public void run() {
                xj.this.y(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@ForbidWrapParam final Activity activity) {
        kd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.xj.3
            @Override // java.lang.Runnable
            public void run() {
                xj.this.u(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@ForbidWrapParam final Activity activity) {
        kd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.xj.2
            @Override // java.lang.Runnable
            public void run() {
                xj.this.w(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@ForbidWrapParam final Activity activity) {
        kd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.xj.1
            @Override // java.lang.Runnable
            public void run() {
                xj.this.hf(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@ForbidWrapParam final Activity activity) {
        kd().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.xj.4
            @Override // java.lang.Runnable
            public void run() {
                xj.this.kd(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(@ForbidWrapParam Activity activity) {
        if (this.c.get()) {
            hf(true);
        }
        if (!this.p.contains(activity.toString())) {
            this.p.add(activity.toString());
            this.c.set(false);
            com.bytedance.sdk.openadsdk.xj.hf.hf.kd();
        }
        if (this.qt != null && this.qt.get() != null && this.qt.get() == activity) {
            f();
        }
        if (this.kd != null) {
            this.kd.onActivityStarted(activity);
        }
        r.kd(activity);
    }

    private Handler kd() {
        if (this.am == null) {
            if (com.bytedance.sdk.openadsdk.core.pz.hf().qa()) {
                this.am = com.bytedance.sdk.component.utils.f.w();
            } else {
                this.am = com.bytedance.sdk.component.utils.f.hf();
            }
        }
        return this.am;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(@ForbidWrapParam Activity activity) {
        if (this.kd != null) {
            this.kd.onActivityPaused(activity);
        }
        if (com.bytedance.sdk.openadsdk.core.f.zg().z() || activity == null || activity.getComponentName() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.hf.xj().w(activity.getComponentName().getClassName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(@ForbidWrapParam Activity activity) {
        if (activity != null) {
            this.f.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.u != null) {
            this.u.xj();
        }
        if (this.kd != null) {
            this.kd.onActivityResumed(activity);
        }
        com.bytedance.sdk.component.d.w.xj.xj(com.bytedance.sdk.openadsdk.core.pz.getContext(), Integer.parseInt("1371"));
        if (!xj) {
            hf = System.currentTimeMillis();
            xj = true;
        }
        com.bytedance.sdk.openadsdk.core.x.xj();
        this.g = new WeakReference<>(activity);
        if (com.bytedance.sdk.openadsdk.core.f.zg().z()) {
            return;
        }
        if (activity != null && activity.getComponentName() != null) {
            com.bytedance.sdk.openadsdk.core.a.hf.xj().xj(activity.getComponentName().getClassName());
        }
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        qt.xj().xj(activity.getIntent());
    }

    public WeakReference<Activity> xj() {
        return this.g;
    }

    public boolean xj(boolean z) {
        Activity activity;
        Window window;
        WeakReference<Activity> weakReference = this.g;
        return (weakReference == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) ? z : window.getDecorView().hasWindowFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(@ForbidWrapParam Activity activity) {
        if (this.p.contains(activity.toString())) {
            this.p.remove(activity.toString());
            if (this.p.size() == 0) {
                this.c.set(true);
                com.bytedance.sdk.openadsdk.xj.hf.hf.u();
                hf(false);
            }
        }
        this.qt = new WeakReference<>(activity);
        if (this.kd != null) {
            this.kd.onActivityStopped(activity);
        }
        c();
        ((com.bytedance.sdk.component.u.d) com.bytedance.sdk.openadsdk.ats.w.xj("kv_store_factory")).store();
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.a.hf.xj().hf();
    }

    public boolean xj(@ForbidWrapParam Activity activity) {
        return activity != null && this.f.contains(Integer.valueOf(activity.hashCode()));
    }

    public void xj(InterfaceC0134xj interfaceC0134xj) {
        this.u = interfaceC0134xj;
    }

    public void xj(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.kd = activityLifecycleCallbacks;
    }

    public void xj(com.bytedance.sdk.component.adexpress.xj xjVar) {
        this.d.add(new WeakReference<>(xjVar));
    }

    public void xj(hf hfVar) {
        if (this.tf.contains(hfVar)) {
            return;
        }
        this.tf.add(hfVar);
    }

    private void hf(boolean z) {
        try {
            if (z) {
                if (this.y != null) {
                    this.y.xj();
                }
                Iterator<hf> it = this.tf.iterator();
                while (it.hasNext()) {
                    hf next = it.next();
                    if (next != null) {
                        next.xj();
                    }
                }
                return;
            }
            if (this.y != null) {
                this.y.hf();
            }
            Iterator<hf> it2 = this.tf.iterator();
            while (it2.hasNext()) {
                hf next2 = it2.next();
                if (next2 != null) {
                    next2.hf();
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean xj(Activity activity, Runnable runnable) {
        boolean add;
        if (activity == null) {
            return false;
        }
        int hashCode = activity.hashCode();
        synchronized (this.f10278pl) {
            try {
                Set<Runnable> set = this.f10278pl.get(hashCode);
                if (set == null) {
                    set = new HashSet<>();
                    this.f10278pl.put(hashCode, set);
                }
                add = set.add(runnable);
            } catch (Throwable th) {
                throw th;
            }
        }
        return add;
    }

    private boolean y() {
        Object apply;
        Function<SparseArray<Object>, Object> aq = com.bytedance.sdk.openadsdk.core.f.zg().aq();
        if (aq != null) {
            try {
                apply = aq.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(2).xj(Boolean.class).hf());
                if (apply != null) {
                    return ((Boolean) apply).booleanValue();
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return this.c.get();
    }

    public void w() {
        if (this.u != null) {
            this.u = null;
        }
    }

    public boolean hf() {
        return y();
    }

    public boolean hf(com.bytedance.sdk.component.adexpress.xj xjVar) {
        return this.d.remove(new WeakReference(xjVar));
    }

    public void hf(hf hfVar) {
        this.y = hfVar;
    }
}
