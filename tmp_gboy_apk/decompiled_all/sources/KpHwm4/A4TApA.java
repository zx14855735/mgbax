package KpHwm4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Process;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends McNXgv.A4TApA {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final B25kr6 f4273AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public BluetoothServerSocket f4274AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public BluetoothSocket f4275AzWtSf;

    public A4TApA(B25kr6 b25kr6) {
        super(b25kr6);
        this.f4273AlLFFp = b25kr6;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        defaultAdapter.cancelDiscovery();
        this.f4274AmA8tU = defaultAdapter.listenUsingRfcommWithServiceRecord("GBoy", B25kr6.f4349AcNBzu);
    }

    @Override // McNXgv.A4TApA
    public final void A2egSU() {
        try {
            BluetoothServerSocket bluetoothServerSocket = this.f4274AmA8tU;
            if (bluetoothServerSocket != null) {
                bluetoothServerSocket.close();
            }
        } catch (IOException unused) {
        }
        try {
            BluetoothSocket bluetoothSocket = this.f4275AzWtSf;
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
        } catch (IOException unused2) {
        }
    }

    @Override // McNXgv.A4TApA
    public final int A4TApA() {
        Process.setThreadPriority(-19);
        this.f4275AzWtSf = this.f4274AmA8tU.accept();
        this.f4274AmA8tU.close();
        this.f4274AmA8tU = null;
        return this.f4273AlLFFp.A4TApA(this.f4275AzWtSf.getInputStream(), this.f4275AzWtSf.getOutputStream());
    }
}
