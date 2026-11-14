package LFHees;

import ADYaiT.CtFAbx;
import AZkASS.ARc23Z;
import android.net.wifi.SoftApConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends WifiManager.LocalOnlyHotspotCallback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f4449A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ I3HV03.A4TApA f4450A4TApA;

    public A4TApA(I3HV03.A4TApA a4TApA, ARc23Z aRc23Z) {
        this.f4450A4TApA = a4TApA;
        this.f4449A2egSU = aRc23Z;
    }

    @Override // android.net.wifi.WifiManager.LocalOnlyHotspotCallback
    public final void onFailed(int i) {
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "未知" : "系统禁止共享" : "不兼容模式（可能已开 WiFi/热点）" : "通用错误" : "无可用信道";
        this.f4449A2egSU.BNL6CD("热点启动失败：" + str + "（码 " + i + "）");
    }

    @Override // android.net.wifi.WifiManager.LocalOnlyHotspotCallback
    public final void onStarted(WifiManager.LocalOnlyHotspotReservation localOnlyHotspotReservation) {
        WifiConfiguration wifiConfiguration;
        SoftApConfiguration softApConfiguration;
        String passphrase;
        String ssid;
        this.f4450A4TApA.f3809AmA8tU = localOnlyHotspotReservation;
        String str = "未知";
        String str2 = "";
        if (Build.VERSION.SDK_INT >= 30) {
            softApConfiguration = localOnlyHotspotReservation.getSoftApConfiguration();
            if (softApConfiguration != null) {
                try {
                    ssid = softApConfiguration.getSsid();
                    if (ssid != null) {
                        if (!ssid.isEmpty()) {
                            str = ssid;
                        }
                    }
                } catch (Exception unused) {
                }
                try {
                    passphrase = softApConfiguration.getPassphrase();
                    if (passphrase != null) {
                        if (!passphrase.isEmpty()) {
                            str2 = passphrase;
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        } else {
            wifiConfiguration = localOnlyHotspotReservation.getWifiConfiguration();
            if (wifiConfiguration != null) {
                String str3 = wifiConfiguration.SSID;
                if (str3 != null && !str3.isEmpty()) {
                    str = wifiConfiguration.SSID;
                }
                String str4 = wifiConfiguration.preSharedKey;
                if (str4 != null && !str4.isEmpty()) {
                    str2 = wifiConfiguration.preSharedKey;
                }
            }
        }
        if (str.length() >= 2 && str.startsWith("\"") && str.endsWith("\"")) {
            str = CtFAbx.AMqCpz(1, 1, str);
        }
        this.f4450A4TApA.getClass();
        String AmA8tU2 = I3HV03.A4TApA.AmA8tU();
        if (AmA8tU2 == null) {
            AmA8tU2 = "192.168.43.1";
        }
        str2.getClass();
        this.f4449A2egSU.BPw6Q8(str, str2, AmA8tU2);
    }

    @Override // android.net.wifi.WifiManager.LocalOnlyHotspotCallback
    public final void onStopped() {
    }
}
