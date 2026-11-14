package com.octopus.ad.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.octopus.ad.internal.nativead.NativeAdShownListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private View f12432a;
    private NativeAdShownListener b;
    private ScheduledExecutorService c;
    private Runnable d;

    public g(View view, NativeAdShownListener nativeAdShownListener) {
        this.f12432a = view;
        this.b = nativeAdShownListener;
        b();
    }

    public static g a(View view, NativeAdShownListener nativeAdShownListener) {
        if (view == null) {
            return null;
        }
        return new g(view, nativeAdShownListener);
    }

    private void b() {
        this.d = new Runnable() { // from class: com.octopus.ad.internal.g.1
            @Override // java.lang.Runnable
            public void run() {
                boolean c = g.this.c();
                if (g.this.b != null) {
                    g.this.b.onAdShown(c);
                }
            }
        };
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.c = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.octopus.ad.internal.g.2
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f12432a != null) {
                    g.this.f12432a.post(g.this.d);
                }
            }
        }, 0L, 250L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i;
        View view = this.f12432a;
        if (view == null || view.getVisibility() != 0 || this.f12432a.getParent() == null) {
            return false;
        }
        try {
            if (!a(this.f12432a)) {
                return false;
            }
            Rect rect = new Rect();
            this.f12432a.getLocalVisibleRect(rect);
            DecimalFormat decimalFormat = new DecimalFormat("##0.00");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            if (rect.left == 0) {
                if (rect.top >= 0) {
                    if (rect.bottom <= this.f12432a.getHeight()) {
                        if (Float.parseFloat(decimalFormat.format((((rect.bottom - rect.top) * rect.right) * 1.0d) / (this.f12432a.getWidth() * this.f12432a.getHeight()))) <= 0.5d) {
                        }
                        return true;
                    }
                }
            }
            if (rect.left > 0 && (i = rect.right) >= 0 && i <= this.f12432a.getWidth()) {
                if (Float.parseFloat(decimalFormat.format((((rect.bottom - rect.top) * (rect.right - rect.left)) * 1.0d) / (this.f12432a.getWidth() * this.f12432a.getHeight()))) > 0.5d) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
            return true;
        }
    }

    public void a() {
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        this.b = null;
        this.f12432a = null;
        this.c = null;
    }

    public static boolean a(View view) {
        Context context;
        if (view == null) {
            return false;
        }
        try {
            Object parent = view.getParent();
            if (parent != null) {
                context = ((View) parent).getContext();
            } else {
                context = view.getContext();
            }
            if (!(context instanceof Activity)) {
                return false;
            }
            String simpleName = ((Activity) context).getClass().getSimpleName();
            String a2 = com.octopus.ad.utils.g.a(context).f12705a.a();
            return a2 == null || simpleName.equals(a2);
        } catch (Exception unused) {
            return false;
        }
    }
}
