package com.kwad.components.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private String NB;
    private long NC;
    private long ND;
    private Timer NE;
    private boolean NF = false;
    private String Nz;
    private final long period;

    /* renamed from: com.kwad.components.core.a.a$a, reason: collision with other inner class name */
    public static final class C0279a {
        private static final a NH = new a();

        static {
            OSymPyz();
        }

        private static /* synthetic */ void OSymPyz() {
            char[] charArray = "µ¹»ø±·»³ø´¹¯ø¥¾³ººø\u009c¸¿\u0094¤¿²±³".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 214);
            }
            String str = new String(charArray);
            char[] charArray2 = "µº¿¸¿¢".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 214);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public a() {
        this.NC = -1L;
        try {
            this.NC = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.NC = System.currentTimeMillis();
            c.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(e.GP());
        d dVar = new d() { // from class: com.kwad.components.core.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.au();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.at();
            }
        };
        b.Ji();
        b.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au() {
        this.NF = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.NE;
        if (timer != null) {
            timer.cancel();
        }
        ax(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.NC;
        this.NC = elapsedRealtime;
        if (i == 1) {
            this.ND = 0L;
            this.NB = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.Nz)) {
                this.Nz = this.NB;
            }
        }
        this.ND++;
        n nVar = new n(10220L);
        nVar.aHN = this.ND;
        if (j > 0) {
            nVar.aMw = j;
        }
        nVar.aMx = i;
        nVar.Nz = this.Nz;
        nVar.NB = this.NB;
        g.a2(nVar);
    }

    public static a oi() {
        return C0279a.NH;
    }

    public final void at() {
        if (this.NF) {
            return;
        }
        this.NF = true;
        if (this.period <= 0) {
            return;
        }
        this.NE = new Timer();
        ax(1);
        TimerTask timerTask = new TimerTask() { // from class: com.kwad.components.core.a.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                a.this.ax(2);
            }
        };
        try {
            Timer timer = this.NE;
            long j = this.period;
            timer.schedule(timerTask, j, j);
        } catch (Throwable unused) {
        }
    }
}
