package IJPJ4E;

import android.os.Handler;
import android.os.Message;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements Handler.Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3903AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f3904AlLFFp;

    public /* synthetic */ ASJ6gh(int i, Object obj) {
        this.f3903AcNBzu = i;
        this.f3904AlLFFp = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f3903AcNBzu) {
            case 0:
                int i = message.what;
                AYUAbz aYUAbz = (AYUAbz) this.f3904AlLFFp;
                if (i == 1) {
                    aYUAbz.A4TApA((AMqCpz) message.obj);
                    return true;
                }
                if (i == 2) {
                    aYUAbz.f3908ADYaiT.A5SV6n((AMqCpz) message.obj);
                }
                return false;
            default:
                if (message.what != 0) {
                    return false;
                }
                A4TApA.A2egSU a2egSU = (A4TApA.A2egSU) this.f3904AlLFFp;
                if (message.obj != null) {
                    throw new ClassCastException();
                }
                synchronized (a2egSU.f7AcNBzu) {
                    throw null;
                }
        }
    }
}
