package androidx.emoji2.text;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B9tovu implements AcNBzu {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f8672AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final C4FrIb.AYUAbz f8673AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final B7CMnp f8674AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Object f8675AzWtSf = new Object();

    /* renamed from: B25kr6, reason: collision with root package name */
    public Handler f8676B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ThreadPoolExecutor f8677B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ThreadPoolExecutor f8678B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public AlLFFp f8679B4ZgIw;

    public B9tovu(Context context, C4FrIb.AYUAbz aYUAbz, B7CMnp b7CMnp) {
        JrXYwF.A4TApA.B4ZgIw(context, "Context cannot be null");
        this.f8672AcNBzu = context.getApplicationContext();
        this.f8673AlLFFp = aYUAbz;
        this.f8674AmA8tU = b7CMnp;
    }

    @Override // androidx.emoji2.text.AcNBzu
    public final void A2egSU(AlLFFp alLFFp) {
        synchronized (this.f8675AzWtSf) {
            this.f8679B4ZgIw = alLFFp;
        }
        A5SV6n();
    }

    public final void A4TApA() {
        synchronized (this.f8675AzWtSf) {
            try {
                this.f8679B4ZgIw = null;
                Handler handler = this.f8676B25kr6;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f8676B25kr6 = null;
                ThreadPoolExecutor threadPoolExecutor = this.f8678B3GDIM;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f8677B2KMhB = null;
                this.f8678B3GDIM = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void A5SV6n() {
        synchronized (this.f8675AzWtSf) {
            try {
                if (this.f8679B4ZgIw == null) {
                    return;
                }
                if (this.f8677B2KMhB == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new A2egSU("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f8678B3GDIM = threadPoolExecutor;
                    this.f8677B2KMhB = threadPoolExecutor;
                }
                this.f8677B2KMhB.execute(new CtFAbx.A2egSU(20, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C4FrIb.AzWtSf ADYaiT() {
        try {
            B7CMnp b7CMnp = this.f8674AmA8tU;
            Context context = this.f8672AcNBzu;
            C4FrIb.AYUAbz aYUAbz = this.f8673AlLFFp;
            b7CMnp.getClass();
            C4FrIb.AmA8tU A2egSU2 = C4FrIb.ASJ6gh.A2egSU(context, aYUAbz);
            int i = A2egSU2.f1574AcNBzu;
            if (i != 0) {
                throw new RuntimeException(CtFAbx.ASJ6gh(i, "fetchFonts failed (", ")"));
            }
            C4FrIb.AzWtSf[] azWtSfArr = (C4FrIb.AzWtSf[]) A2egSU2.f1575AlLFFp;
            if (azWtSfArr == null || azWtSfArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return azWtSfArr[0];
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("provider not found", e);
        }
    }
}
