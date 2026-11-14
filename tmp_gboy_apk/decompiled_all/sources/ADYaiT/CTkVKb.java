package ADYaiT;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import com.game.boy.activity.DownLoadActivity;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.activity.FavoriteActivity;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CTkVKb extends BroadcastReceiver {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f133A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f134A4TApA;

    public /* synthetic */ CTkVKb(int i, Object obj) {
        this.f133A2egSU = i;
        this.f134A4TApA = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        L5dZB6.A4TApA a4TApA;
        L5dZB6.A4TApA a4TApA2;
        LLiCI0.CcAIMM ccAIMM;
        L5dZB6.A4TApA a4TApA3;
        switch (this.f133A2egSU) {
            case 0:
                ((CcAIMM) this.f134A4TApA).AZkASS();
                return;
            case 1:
                try {
                    ((G58fqA.A5SV6n) this.f134A4TApA).A4TApA(intent);
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 2:
                IQ76hF.A5SV6n a5SV6n = (IQ76hF.A5SV6n) this.f134A4TApA;
                boolean z = a5SV6n.f3937AmA8tU;
                a5SV6n.f3937AmA8tU = IQ76hF.A5SV6n.A2egSU(context);
                if (z != ((IQ76hF.A5SV6n) this.f134A4TApA).f3937AmA8tU) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        boolean z2 = ((IQ76hF.A5SV6n) this.f134A4TApA).f3937AmA8tU;
                    }
                    IQ76hF.A5SV6n a5SV6n2 = (IQ76hF.A5SV6n) this.f134A4TApA;
                    I3HV03.A4TApA a4TApA4 = a5SV6n2.f3936AlLFFp;
                    if (!a5SV6n2.f3937AmA8tU) {
                        a4TApA4.getClass();
                        return;
                    }
                    synchronized (((com.bumptech.glide.AzWtSf) a4TApA4.f3809AmA8tU)) {
                        IQ76hF.AlLFFp alLFFp = (IQ76hF.AlLFFp) a4TApA4.f3808AlLFFp;
                        Iterator it = ItGa5w.AlLFFp.ADYaiT(alLFFp.f3952A2egSU).iterator();
                        while (it.hasNext()) {
                            IhMMDv.A5SV6n a5SV6n3 = (IhMMDv.A5SV6n) it.next();
                            if (!a5SV6n3.AaHO0E() && !a5SV6n3.AYUAbz()) {
                                a5SV6n3.clear();
                                if (alLFFp.f3954A5SV6n) {
                                    alLFFp.f3953A4TApA.add(a5SV6n3);
                                } else {
                                    a5SV6n3.AZOQYO();
                                }
                            }
                        }
                    }
                    return;
                }
                return;
            case 3:
                try {
                    if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                        ((IySJvm.A2egSU) this.f134A4TApA).f4098A2egSU = (int) ((intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100));
                        return;
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            case 4:
                String action = intent.getAction();
                boolean equals = "android.bluetooth.device.action.FOUND".equals(action);
                MOpbMP.AZkASS aZkASS = (MOpbMP.AZkASS) this.f134A4TApA;
                if (!equals) {
                    if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action) && aZkASS.f5021AlLFFp.f4690AcNBzu.size() == 0) {
                        aZkASS.f5021AlLFFp.A2egSU(new L2suez.A4TApA(aZkASS.getString(2131886650), "", 1));
                        return;
                    }
                    return;
                }
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice != null) {
                    String address = bluetoothDevice.getAddress();
                    if (bluetoothDevice.getBondState() != 12) {
                        for (int i = 0; i < aZkASS.f5021AlLFFp.f4690AcNBzu.size(); i++) {
                            L2suez.A4TApA a4TApA5 = (L2suez.A4TApA) aZkASS.f5021AlLFFp.f4690AcNBzu.get(i);
                            if (a4TApA5 != null && a4TApA5.f4361A4TApA.equals(address)) {
                                return;
                            }
                        }
                        aZkASS.f5021AlLFFp.A2egSU(new L2suez.A4TApA(bluetoothDevice.getName(), bluetoothDevice.getAddress(), 1));
                        return;
                    }
                    return;
                }
                return;
            case 5:
                MOpbMP.B2KMhB b2KMhB = (MOpbMP.B2KMhB) this.f134A4TApA;
                if (!"com.game.boy.DOWNLOAD_UPDATE".equals(intent.getAction()) || (a4TApA = (L5dZB6.A4TApA) intent.getSerializableExtra("download_info")) == null) {
                    return;
                }
                try {
                    if (Integer.parseInt(a4TApA.f4392AcNBzu) == b2KMhB.f5034B3GDIM.A4TApA()) {
                        MOpbMP.B2KMhB.AlLFFp(b2KMhB, a4TApA);
                        return;
                    }
                    return;
                } catch (NumberFormatException unused3) {
                    return;
                }
            case 6:
                if (!"com.game.boy.DOWNLOAD_UPDATE".equals(intent.getAction()) || (a4TApA2 = (L5dZB6.A4TApA) intent.getSerializableExtra("download_info")) == null || (ccAIMM = ((MOpbMP.BpkvW3) this.f134A4TApA).f5071B7CMnp) == null) {
                    return;
                }
                ccAIMM.AMqCpz(a4TApA2);
                return;
            case 7:
                if (!"com.game.boy.DOWNLOAD_UPDATE".equals(intent.getAction()) || (a4TApA3 = (L5dZB6.A4TApA) intent.getSerializableExtra("download_info")) == null) {
                    return;
                }
                LLiCI0.B3GDIM b3gdim = ((DownLoadActivity) this.f134A4TApA).f10975B3GDIM;
                for (int i2 = 0; i2 < b3gdim.f4716AcNBzu.size(); i2++) {
                    if (((L5dZB6.A4TApA) b3gdim.f4716AcNBzu.get(i2)).f4392AcNBzu.equals(a4TApA3.f4392AcNBzu)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(PointCategory.PROGRESS);
                        arrayList.add("status");
                        b3gdim.f4716AcNBzu.set(i2, a4TApA3);
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        b3gdim.notifyItemChanged(i2, arrayList);
                        return;
                    }
                }
                return;
            case 8:
                if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", 0);
                    Button ARc23Z2 = ((EmulatorActivity) this.f134A4TApA).f11017CcAIMM.ARc23Z(-1);
                    if (intExtra == 23) {
                        ARc23Z2.setText(2131886279);
                        ARc23Z2.setEnabled(false);
                        return;
                    } else {
                        ARc23Z2.setText(2131886508);
                        ARc23Z2.setEnabled(true);
                        return;
                    }
                }
                return;
            default:
                if ("com.game.boy.DOWNLOAD_UPDATE".equals(intent.getAction())) {
                    L5dZB6.A4TApA a4TApA6 = (L5dZB6.A4TApA) intent.getSerializableExtra("download_info");
                    if (a4TApA6 != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(a4TApA6.f4392AcNBzu);
                        sb.append(" ");
                        sb.append(a4TApA6.f4400B7CMnp);
                    }
                    if (a4TApA6 != null) {
                        ((FavoriteActivity) this.f134A4TApA).f11039B9tovu.AMqCpz(a4TApA6);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
