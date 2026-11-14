package com.kwad.sdk.f.a;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {
    private static volatile a aWb;
    private Activity mActivity;
    private int aWc = 3;
    private int aWd = 3;
    private int aWe = 3;
    private int aWf = 3;
    private AtomicBoolean aWg = new AtomicBoolean(false);
    private boolean aWh = false;
    private AtomicBoolean aWi = new AtomicBoolean(false);
    private AtomicBoolean mHasInit = new AtomicBoolean(false);

    private static int A(int i, int i2) {
        return (Build.VERSION.SDK_INT >= 34 && eq(i) && eq(i2)) ? 1 : 2;
    }

    public static a Og() {
        if (aWb == null) {
            synchronized (a.class) {
                try {
                    if (aWb == null) {
                        aWb = new a();
                    }
                } finally {
                }
            }
        }
        return aWb;
    }

    private void Oh() {
        this.aWc = Build.VERSION.SDK_INT;
        b.Ji();
        b.a(new d() { // from class: com.kwad.sdk.f.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.this.mActivity = activity;
                    if (a.this.aWi.get()) {
                        return;
                    }
                    a aVar = a.this;
                    aVar.aWe = a.b(aVar, activity);
                    a aVar2 = a.this;
                    aVar2.aWd = a.c(aVar2, activity);
                    a.this.Oi();
                } catch (Throwable th) {
                    c.e("HdrHelper", "collectHdrAbility error", th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                a.this.mActivity = null;
                b.Ji();
                b.b((com.kwad.sdk.core.c.c) this);
                super.b(activity);
            }
        });
    }

    private boolean Oj() {
        if (this.aWi.get()) {
            return true;
        }
        this.aWi.set(ag.m("ksadsdk_pref", "hdr_has_reported", false));
        return this.aWi.get();
    }

    public static /* synthetic */ int c(a aVar, Activity activity) {
        return n(activity);
    }

    private static boolean eo(int i) {
        return (i & 1) != 0;
    }

    private static boolean ep(int i) {
        return (i & 2) != 0;
    }

    private static boolean eq(int i) {
        return i == 1;
    }

    private static int n(Activity activity) {
        int colorMode;
        int colorMode2;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return 3;
            }
            colorMode = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(2);
            colorMode2 = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(colorMode);
            return colorMode2 == 2 ? 1 : 2;
        } catch (Throwable th) {
            c.e("HdrHelper", "getColorModeSupport error", th);
            return 3;
        }
    }

    private static int o(Activity activity) {
        Display display;
        try {
            if (Build.VERSION.SDK_INT < 34) {
                return 3;
            }
            display = activity.getDisplay();
            return display != null ? ((Boolean) z.f(display, "isHdrSdrRatioAvailable", new Object[0])).booleanValue() : false ? 1 : 2;
        } catch (Throwable th) {
            c.e("HdrHelper", "getScreenHdrAvailable error", th);
            return 3;
        }
    }

    private void report() {
        this.aWf = A(this.aWd, this.aWe);
        this.aWc = Build.VERSION.SDK_INT;
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.FH().cR(ILoggerReporter.Category.APM_LOG).i(1.0d).O("ad_sdk_hdr", "stats_ranger").z(new com.kwad.sdk.f.a.a.a(this.aWc, this.aWd, this.aWe, this.aWf)).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
    }

    public final void Oi() {
        if (!this.aWh || Oj()) {
            return;
        }
        report();
        ag.l("ksadsdk_pref", "hdr_has_reported", true);
        this.aWi.set(true);
    }

    public final void init(int i) {
        if (this.mHasInit.get() || i == 0) {
            return;
        }
        Oh();
        if (eo(i)) {
            this.aWh = true;
        }
        if (ep(i)) {
            this.aWg.set(true);
        }
        this.mHasInit.set(true);
    }

    public static /* synthetic */ int b(a aVar, Activity activity) {
        return o(activity);
    }
}
