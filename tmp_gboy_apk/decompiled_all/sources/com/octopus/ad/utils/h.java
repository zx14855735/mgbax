package com.octopus.ad.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h {
    private String f;
    private f i;

    /* renamed from: a, reason: collision with root package name */
    private String f12706a = "OnLineStateClass";
    private int b = 0;
    private boolean c = true;
    private boolean d = false;
    private boolean e = false;
    private final Map<String, String> g = new HashMap();
    private long h = 0;

    public static /* synthetic */ int d(h hVar) {
        int i = hVar.b;
        hVar.b = i + 1;
        return i;
    }

    public static /* synthetic */ int h(h hVar) {
        int i = hVar.b;
        hVar.b = i - 1;
        return i;
    }

    public void a(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.h = System.currentTimeMillis() / 1000;
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.octopus.ad.utils.h.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                h.this.f = activity.getClass().getSimpleName();
                h.this.g.put(h.this.f, h.this.f);
                h.this.c = true;
                h.this.d = false;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                h.this.g.remove(activity.getClass().getSimpleName());
                if (h.this.g.isEmpty() && h.this.c) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (h.this.i != null) {
                        long unused = h.this.h;
                        h.this.i.a(currentTimeMillis, h.this.h);
                        h.this.h = System.currentTimeMillis() / 1000;
                    }
                    h.this.c = false;
                }
                if (h.this.g.isEmpty()) {
                    h.this.e = true;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                h.this.d = !activity.getClass().getSimpleName().equals(h.this.f);
                h.this.f = activity.getClass().getSimpleName();
                if (!h.this.c || h.this.e) {
                    h.this.e = false;
                    if (h.this.i != null) {
                        h.this.i.a();
                    }
                    h.this.h = System.currentTimeMillis() / 1000;
                    h.this.c = true;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                com.octopus.ad.utils.b.f.a(h.this.f12706a, "onActivityStarted");
                h.d(h.this);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                com.octopus.ad.utils.b.f.a(h.this.f12706a, "onActivityStopped");
                h.h(h.this);
                if (activity.getClass().getSimpleName().equals(h.this.f)) {
                    if (!h.this.d || h.this.g.size() == 1) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        if (h.this.i != null) {
                            long unused = h.this.h;
                            h.this.i.a(h.this.h, currentTimeMillis);
                            h.this.h = System.currentTimeMillis() / 1000;
                        }
                        h.this.c = false;
                    }
                }
            }
        });
    }

    public String a() {
        return this.f;
    }

    public void a(f fVar) {
        this.i = fVar;
    }
}
