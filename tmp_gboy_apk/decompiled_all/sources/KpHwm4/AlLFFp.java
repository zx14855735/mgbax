package KpHwm4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp extends McNXgv.A4TApA {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final InetAddress f4320AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f4321AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Socket f4322AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ B25kr6 f4323B25kr6;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlLFFp(B25kr6 b25kr6, B25kr6 b25kr62, InetAddress inetAddress) {
        super(b25kr62);
        this.f4323B25kr6 = b25kr6;
        this.f4320AlLFFp = inetAddress;
        this.f4321AmA8tU = 6374;
    }

    @Override // McNXgv.A4TApA
    public final void A2egSU() {
        try {
            Socket socket = this.f4322AzWtSf;
            if (socket == null || socket.isClosed()) {
                return;
            }
            this.f4322AzWtSf.close();
        } catch (IOException unused) {
        }
    }

    @Override // McNXgv.A4TApA
    public final int A4TApA() {
        Socket socket = new Socket();
        this.f4322AzWtSf = socket;
        socket.connect(new InetSocketAddress(this.f4320AlLFFp, this.f4321AmA8tU));
        this.f4322AzWtSf.setSoTimeout(500);
        this.f4322AzWtSf.setTcpNoDelay(true);
        return this.f4323B25kr6.A4TApA(this.f4322AzWtSf.getInputStream(), this.f4322AzWtSf.getOutputStream());
    }
}
