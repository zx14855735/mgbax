package NUY5pn;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BNL6CD implements Handler.Callback {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final IQ76hF.AmA8tU f6007AlLFFp;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Handler f6013B4ZgIw;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ArrayList f6008AmA8tU = new ArrayList();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f6006AcNBzu = new ArrayList();

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ArrayList f6009AzWtSf = new ArrayList();

    /* renamed from: B25kr6, reason: collision with root package name */
    public volatile boolean f6010B25kr6 = false;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final AtomicInteger f6011B2KMhB = new AtomicInteger(0);

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f6012B3GDIM = false;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Object f6014B7CMnp = new Object();

    public BNL6CD(Looper looper, IQ76hF.AmA8tU amA8tU) {
        this.f6007AlLFFp = amA8tU;
        this.f6013B4ZgIw = new Handler(looper, this);
    }

    public final void A2egSU(NSK3xo.AaHO0E aaHO0E) {
        AYUAbz.A4TApA(aaHO0E);
        synchronized (this.f6014B7CMnp) {
            try {
                if (this.f6009AzWtSf.contains(aaHO0E)) {
                    new StringBuilder(String.valueOf(aaHO0E).length() + 67);
                } else {
                    this.f6009AzWtSf.add(aaHO0E);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i);
            Log.wtf("GmsClientEvents", sb.toString(), new Exception());
            return false;
        }
        NSK3xo.AZkASS aZkASS = (NSK3xo.AZkASS) message.obj;
        synchronized (this.f6014B7CMnp) {
            try {
                if (this.f6010B25kr6 && this.f6007AlLFFp.B25kr6() && this.f6008AmA8tU.contains(aZkASS)) {
                    this.f6007AlLFFp.getClass();
                    aZkASS.A2egSU(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }
}
