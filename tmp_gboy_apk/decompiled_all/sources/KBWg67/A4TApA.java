package KBWg67;

import JrXYwF.A5SV6n;
import JrXYwF.ASJ6gh;
import NOd7IU.AmA8tU;
import android.os.SystemClock;
import com.bumptech.glide.AMqCpz;
import com.bytedance.sdk.component.utils.pl;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements Thread.UncaughtExceptionHandler {
    public static A4TApA AMqCpz;

    /* renamed from: A2egSU, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f4222A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public HashSet f4223A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public AmA8tU f4224A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public long f4225ADYaiT;

    public final void A2egSU(Thread thread, Throwable th) {
        try {
            Iterator it = this.f4223A4TApA.iterator();
            while (it.hasNext()) {
                try {
                    ((Thread.UncaughtExceptionHandler) it.next()).uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.f4222A2egSU.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        AmA8tU amA8tU;
        if (SystemClock.uptimeMillis() - this.f4225ADYaiT < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f4225ADYaiT = SystemClock.uptimeMillis();
            ASJ6gh aSJ6gh = A5SV6n.AMqCpz.AMqCpz;
            boolean z = true;
            if (aSJ6gh != null) {
                try {
                    if (!aSJ6gh.xj(th, thread)) {
                        z = false;
                    }
                } catch (Throwable unused) {
                }
            }
            if (z) {
                Iterator it = A5SV6n.AMqCpz.f4156A5SV6n.iterator();
                while (it.hasNext()) {
                    it.next();
                    try {
                        try {
                            JrXYwF.A4TApA.Dphsd2(th);
                        } catch (Throwable unused2) {
                            AMqCpz.C2rE4F();
                        }
                    } finally {
                        A2egSU(thread, th);
                    }
                }
                if (z && (amA8tU = this.f4224A5SV6n) != null) {
                    amA8tU.ARc23Z(currentTimeMillis, thread, th);
                    pl.xj("crash_dispatcher", "end dispose ".concat(String.valueOf(th)));
                }
            }
        } catch (Throwable unused3) {
            A5SV6n.f4152ADYaiT.getClass();
        }
    }
}
