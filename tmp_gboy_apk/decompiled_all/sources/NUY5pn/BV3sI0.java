package NUY5pn;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BV3sI0 implements ServiceConnection {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BmvVmW f6019A2egSU;

    public BV3sI0(BmvVmW bmvVmW) {
        this.f6019A2egSU = bmvVmW;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f6019A2egSU.f6020A2egSU.f6027AmA8tU) {
            try {
                BmvVmW bmvVmW = this.f6019A2egSU;
                bmvVmW.f6024ARc23Z = iBinder;
                bmvVmW.f6026AYUAbz = componentName;
                Iterator it = bmvVmW.f6022A5SV6n.iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f6019A2egSU.f6023ADYaiT = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f6019A2egSU.f6020A2egSU.f6027AmA8tU) {
            try {
                BmvVmW bmvVmW = this.f6019A2egSU;
                bmvVmW.f6024ARc23Z = null;
                bmvVmW.f6026AYUAbz = componentName;
                Iterator it = bmvVmW.f6022A5SV6n.iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f6019A2egSU.f6023ADYaiT = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
