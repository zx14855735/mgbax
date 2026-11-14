package NUY5pn;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BniPrB extends BPw6Q8 implements Handler.Callback {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final HashMap f6027AmA8tU = new HashMap();

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Context f6028AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Handler f6029B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final NRGvz2.A2egSU f6030B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final long f6031B3GDIM;

    public BniPrB(Context context) {
        this.f6028AzWtSf = context.getApplicationContext();
        this.f6029B25kr6 = new Handler(context.getMainLooper(), this);
        synchronized (NRGvz2.A2egSU.f5914A2egSU) {
            try {
                if (NRGvz2.A2egSU.f5915A4TApA == null) {
                    NRGvz2.A2egSU.f5915A4TApA = new NRGvz2.A2egSU();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f6030B2KMhB = NRGvz2.A2egSU.f5915A4TApA;
        this.f6031B3GDIM = PushUIConfig.dismissTime;
    }

    public final void A2egSU(String str, ServiceConnection serviceConnection) {
        BTvldC bTvldC = new BTvldC(str);
        AYUAbz.A5SV6n(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f6027AmA8tU) {
            try {
                BmvVmW bmvVmW = (BmvVmW) this.f6027AmA8tU.get(bTvldC);
                if (bmvVmW == null) {
                    String valueOf = String.valueOf(bTvldC);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                    sb.append("Nonexistent connection status for service config: ");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                if (!bmvVmW.f6022A5SV6n.contains(serviceConnection)) {
                    String valueOf2 = String.valueOf(bTvldC);
                    StringBuilder sb2 = new StringBuilder(valueOf2.length() + 76);
                    sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb2.append(valueOf2);
                    throw new IllegalStateException(sb2.toString());
                }
                bmvVmW.f6020A2egSU.f6030B2KMhB.getClass();
                bmvVmW.f6022A5SV6n.remove(serviceConnection);
                if (bmvVmW.f6022A5SV6n.isEmpty()) {
                    this.f6029B25kr6.sendMessageDelayed(this.f6029B25kr6.obtainMessage(0, bTvldC), this.f6031B3GDIM);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        BTvldC bTvldC = (BTvldC) message.obj;
        synchronized (this.f6027AmA8tU) {
            try {
                BmvVmW bmvVmW = (BmvVmW) this.f6027AmA8tU.get(bTvldC);
                if (bmvVmW != null && bmvVmW.f6022A5SV6n.isEmpty()) {
                    if (bmvVmW.AMqCpz) {
                        BniPrB bniPrB = bmvVmW.f6020A2egSU;
                        NRGvz2.A2egSU a2egSU = bniPrB.f6030B2KMhB;
                        Context context = bniPrB.f6028AzWtSf;
                        a2egSU.getClass();
                        context.unbindService(bmvVmW.f6021A4TApA);
                        bmvVmW.AMqCpz = false;
                        bmvVmW.f6023ADYaiT = 2;
                    }
                    this.f6027AmA8tU.remove(bTvldC);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }
}
