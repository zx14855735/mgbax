package KpHwm4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.os.Process;
import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends McNXgv.A4TApA {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f4270AlLFFp = 1;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final B25kr6 f4271AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Closeable f4272AzWtSf;

    public A2egSU(B25kr6 b25kr6, String str) {
        super(b25kr6);
        this.f4271AmA8tU = b25kr6;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.f4272AzWtSf = defaultAdapter.getRemoteDevice(str).createRfcommSocketToServiceRecord(B25kr6.f4349AcNBzu);
        defaultAdapter.cancelDiscovery();
    }

    @Override // McNXgv.A4TApA
    public final void A2egSU() {
        switch (this.f4270AlLFFp) {
            case 0:
                try {
                    ((BluetoothSocket) this.f4272AzWtSf).close();
                    break;
                } catch (IOException unused) {
                    return;
                }
            default:
                ServerSocket serverSocket = (ServerSocket) this.f4272AzWtSf;
                if (serverSocket != null && !serverSocket.isClosed()) {
                    try {
                        serverSocket.close();
                        break;
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // McNXgv.A4TApA
    public final int A4TApA() {
        switch (this.f4270AlLFFp) {
            case 0:
                Process.setThreadPriority(-19);
                BluetoothSocket bluetoothSocket = (BluetoothSocket) this.f4272AzWtSf;
                bluetoothSocket.connect();
                return this.f4271AmA8tU.A4TApA(bluetoothSocket.getInputStream(), bluetoothSocket.getOutputStream());
            default:
                Socket accept = ((ServerSocket) this.f4272AzWtSf).accept();
                accept.setSoTimeout(500);
                accept.setTcpNoDelay(true);
                return this.f4271AmA8tU.A4TApA(accept.getInputStream(), accept.getOutputStream());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A2egSU(B25kr6 b25kr6, B25kr6 b25kr62, ServerSocket serverSocket) {
        super(b25kr62);
        this.f4271AmA8tU = b25kr6;
        this.f4272AzWtSf = serverSocket;
    }
}
