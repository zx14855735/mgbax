package com.octopus.ad.internal;

import android.graphics.Rect;
import android.view.View;
import com.octopus.ad.internal.nativead.NativeAdShownListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private View f12435a;
    private NativeAdShownListener b;
    private ScheduledExecutorService c;
    private Runnable d;

    public h(View view, NativeAdShownListener nativeAdShownListener) {
        this.f12435a = view;
        this.b = nativeAdShownListener;
        b();
    }

    private void b() {
        this.d = new Runnable() { // from class: com.octopus.ad.internal.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.c()) {
                    if (h.this.b != null) {
                        h.this.b.onAdShown(true);
                    }
                    if (h.this.c != null) {
                        h.this.c.shutdownNow();
                    }
                    h.this.b = null;
                    h.this.f12435a = null;
                    h.this.c = null;
                }
            }
        };
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.c = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.octopus.ad.internal.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f12435a != null) {
                    h.this.f12435a.post(h.this.d);
                }
            }
        }, 0L, 250L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i;
        View view = this.f12435a;
        if (view == null || view.getVisibility() != 0 || this.f12435a.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        this.f12435a.getLocalVisibleRect(rect);
        try {
            DecimalFormat decimalFormat = new DecimalFormat("##0.00");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            if (rect.left == 0) {
                if (rect.top >= 0) {
                    if (rect.bottom <= this.f12435a.getHeight()) {
                        if (Float.parseFloat(decimalFormat.format((((rect.bottom - rect.top) * rect.right) * 1.0d) / (this.f12435a.getWidth() * this.f12435a.getHeight()))) <= 0.5d) {
                        }
                        return true;
                    }
                }
            }
            if (rect.left > 0 && (i = rect.right) >= 0 && i <= this.f12435a.getWidth()) {
                if (Float.parseFloat(decimalFormat.format((((rect.bottom - rect.top) * (rect.right - rect.left)) * 1.0d) / (this.f12435a.getWidth() * this.f12435a.getHeight()))) > 0.5d) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
            return true;
        }
    }

    public static h a(View view, NativeAdShownListener nativeAdShownListener) {
        if (view == null) {
            return null;
        }
        return new h(view, nativeAdShownListener);
    }

    public void a() {
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.c = null;
        }
        View view = this.f12435a;
        if (view != null) {
            view.removeCallbacks(this.d);
            this.f12435a = null;
        }
        this.b = null;
    }
}
