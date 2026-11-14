package com.octopus.ad.internal;

import android.graphics.Rect;
import android.view.View;
import com.octopus.ad.internal.utilities.HaoboLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class x {
    private View c;
    private Runnable e;
    private ScheduledExecutorService f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f12600a = false;
    private boolean b = false;
    private ArrayList<a> d = new ArrayList<>();

    public interface a {
        void a(boolean z);
    }

    private x(View view) {
        this.c = view;
        a();
    }

    public void b(a aVar) {
        this.d.remove(aVar);
    }

    public void c() {
        ScheduledExecutorService scheduledExecutorService = this.f;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.f = null;
        }
        View view = this.c;
        if (view != null) {
            view.removeCallbacks(this.e);
            this.c = null;
        }
        this.d = null;
    }

    public boolean b() {
        View view = this.c;
        if (view != null && view.getVisibility() == 0 && this.c.getParent() != null) {
            Rect rect = new Rect();
            if (!this.c.getGlobalVisibleRect(rect)) {
                return false;
            }
            int width = rect.width() * rect.height();
            int width2 = this.c.getWidth() * this.c.getHeight();
            if (width2 > 0 && width * 100 >= width2 * 50) {
                return true;
            }
        }
        return false;
    }

    public static x a(View view) {
        if (view == null) {
            HaoboLog.d(HaoboLog.nativeLogTag, "Unable to check visibility");
            return null;
        }
        return new x(view);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.d.add(aVar);
        }
    }

    public void a() {
        if (this.f12600a) {
            return;
        }
        this.f12600a = true;
        this.e = new Runnable() { // from class: com.octopus.ad.internal.x.1
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.d != null) {
                    ArrayList arrayList = new ArrayList(x.this.d);
                    if (!x.this.b()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((a) it.next()).a(false);
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((a) it2.next()).a(true);
                        }
                        x.this.b = true;
                    }
                }
            }
        };
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.octopus.ad.internal.x.2
            @Override // java.lang.Runnable
            public void run() {
                x.this.c.post(x.this.e);
                if (!x.this.b || x.this.f == null) {
                    return;
                }
                x.this.f.shutdownNow();
                x.this.f = null;
            }
        }, 0L, 250L, TimeUnit.MILLISECONDS);
    }
}
