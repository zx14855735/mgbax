package com.game.boy.service;

import AZkASS.ARc23Z;
import I3HV03.A4TApA;
import LFHees.A2egSU;
import Qo94AZ.AMqCpz;
import Qo94AZ.B25kr6;
import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.core.app.BPw6Q8;
import androidx.core.app.BV3sI0;
import com.game.boy.activity.DeviceActivity;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FileService extends Service {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static boolean f11116AzWtSf = false;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static boolean f11117B25kr6 = false;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static String f11118B2KMhB = "";

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static String f11119B3GDIM = "";

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static String f11120B4ZgIw = "";

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static String f11121B7CMnp = "";

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A2egSU f11122AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public A4TApA f11123AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public File f11124AmA8tU;

    public static ArrayList A4TApA() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!nextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 instanceof Inet4Address) {
                            arrayList.add(nextElement2.getHostAddress());
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final Notification A2egSU() {
        String str;
        Intent intent = new Intent(this, (Class<?>) DeviceActivity.class);
        intent.setFlags(335544320);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 201326592);
        String str2 = f11116AzWtSf ? "文件服务运行中" : "文件服务已停止";
        StringBuilder sb = new StringBuilder();
        if (f11116AzWtSf) {
            sb.append("端口 6377");
            ArrayList A4TApA2 = A4TApA();
            if (!A4TApA2.isEmpty()) {
                sb.append("  ");
                sb.append((String) A4TApA2.get(0));
            }
        }
        if (f11117B25kr6 && (str = f11118B2KMhB) != null && !str.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("热点 ");
            sb.append(f11118B2KMhB);
            if (!f11119B3GDIM.isEmpty()) {
                sb.append("  密码 ");
                sb.append(f11119B3GDIM);
            }
        }
        if (!f11121B7CMnp.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(f11121B7CMnp);
        }
        if (sb.length() == 0) {
            sb.append("点击打开应用");
        }
        BV3sI0 bV3sI0 = new BV3sI0(this, "file_server_channel");
        bV3sI0.f8551CikNvS.icon = R.drawable.stat_sys_upload_done;
        bV3sI0.AMqCpz = BV3sI0.A4TApA(str2);
        bV3sI0.f8515ARc23Z = BV3sI0.A4TApA(sb.toString());
        BPw6Q8 bPw6Q8 = new BPw6Q8();
        bPw6Q8.f8510A5SV6n = BV3sI0.A4TApA(sb.toString());
        bV3sI0.ASJ6gh(bPw6Q8);
        bV3sI0.f8516ASJ6gh = activity;
        bV3sI0.AMqCpz(2, true);
        bV3sI0.f8522AlLFFp = -1;
        return bV3sI0.A2egSU();
    }

    public final void A5SV6n() {
        if (f11116AzWtSf) {
            return;
        }
        try {
            A2egSU a2egSU = new A2egSU(this.f11124AmA8tU, getAssets());
            this.f11122AcNBzu = a2egSU;
            a2egSU.ARc23Z();
            f11116AzWtSf = true;
            f11121B7CMnp = "";
        } catch (IOException e) {
            this.f11122AcNBzu = null;
            f11116AzWtSf = false;
            f11121B7CMnp = "启动失败：" + e.getMessage();
        }
    }

    public final void ADYaiT() {
        A4TApA a4TApA = this.f11123AlLFFp;
        WifiManager wifiManager = (WifiManager) a4TApA.f3808AlLFFp;
        WifiManager.LocalOnlyHotspotReservation localOnlyHotspotReservation = (WifiManager.LocalOnlyHotspotReservation) a4TApA.f3809AmA8tU;
        if (localOnlyHotspotReservation != null) {
            try {
                localOnlyHotspotReservation.close();
            } catch (Exception unused) {
            }
            a4TApA.f3809AmA8tU = null;
        }
        if (Build.VERSION.SDK_INT < 26) {
            try {
                wifiManager.getClass().getMethod("setWifiApEnabled", WifiConfiguration.class, Boolean.TYPE).invoke(wifiManager, null, Boolean.FALSE);
            } catch (Exception unused2) {
            }
        }
        f11117B25kr6 = false;
        f11118B2KMhB = "";
        f11119B3GDIM = "";
        f11120B4ZgIw = "";
    }

    public final void AMqCpz() {
        A2egSU a2egSU = this.f11122AcNBzu;
        if (a2egSU != null) {
            a2egSU.getClass();
            try {
                B25kr6.ADYaiT(a2egSU.f7820A4TApA);
                AMqCpz aMqCpz = a2egSU.AMqCpz;
                aMqCpz.getClass();
                Iterator it = new ArrayList(aMqCpz.f7776A4TApA).iterator();
                while (it.hasNext()) {
                    Qo94AZ.A2egSU a2egSU2 = (Qo94AZ.A2egSU) it.next();
                    B25kr6.ADYaiT(a2egSU2.f7762AcNBzu);
                    B25kr6.ADYaiT(a2egSU2.f7763AlLFFp);
                }
                Thread thread = a2egSU.f7822ADYaiT;
                if (thread != null) {
                    thread.join();
                }
            } catch (Exception e) {
                B25kr6.f7818AZkASS.log(Level.SEVERE, "Could not stop all connections", (Throwable) e);
            }
            this.f11122AcNBzu = null;
        }
        f11116AzWtSf = false;
        stopForeground(true);
        stopSelf();
    }

    public final void ARc23Z() {
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(1001, A2egSU());
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        Object systemService;
        super.onCreate();
        File file = new File(Environment.getExternalStorageDirectory(), "GBoy");
        this.f11124AmA8tU = file;
        if (!file.exists()) {
            this.f11124AmA8tU.mkdirs();
        }
        this.f11123AlLFFp = new A4TApA(this);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel BNL6CD2 = JMFfuZ.A2egSU.BNL6CD();
            BNL6CD2.setDescription("WiFi 文件服务运行状态");
            systemService = getSystemService(NotificationManager.class);
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(BNL6CD2);
            }
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        ADYaiT();
        AMqCpz();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        int i3;
        startForeground(1001, A2egSU());
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            action.getClass();
            switch (action) {
                case "com.game.boy.utils.STOP_HOTSPOT":
                    ADYaiT();
                    break;
                case "com.game.boy.utils.START_SERVER":
                    A5SV6n();
                    break;
                case "com.game.boy.utils.STOP_SERVER":
                    AMqCpz();
                    break;
                case "com.game.boy.utils.STOP_ALL":
                    ADYaiT();
                    AMqCpz();
                    stopForeground(true);
                    stopSelf();
                    return 2;
                case "com.game.boy.utils.START_HOTSPOT":
                    if (!f11117B25kr6 && (i3 = Build.VERSION.SDK_INT) >= 26) {
                        A4TApA a4TApA = this.f11123AlLFFp;
                        ARc23Z aRc23Z = new ARc23Z(27, this);
                        WifiManager wifiManager = (WifiManager) a4TApA.f3808AlLFFp;
                        if (i3 < 26) {
                            try {
                                WifiConfiguration wifiConfiguration = new WifiConfiguration();
                                wifiConfiguration.SSID = "\"GBoy-Hotspot\"";
                                wifiConfiguration.preSharedKey = "\"12345678\"";
                                wifiConfiguration.allowedKeyManagement.set(1);
                                Object invoke = wifiManager.getClass().getMethod("setWifiApEnabled", WifiConfiguration.class, Boolean.TYPE).invoke(wifiManager, wifiConfiguration, Boolean.TRUE);
                                if ((invoke instanceof Boolean) && ((Boolean) invoke).booleanValue()) {
                                    String AmA8tU2 = A4TApA.AmA8tU();
                                    if (AmA8tU2 == null) {
                                        AmA8tU2 = "192.168.43.1";
                                    }
                                    aRc23Z.BPw6Q8("GBoy-Hotspot", "12345678", AmA8tU2);
                                } else {
                                    aRc23Z.BNL6CD("开启热点失败（setWifiApEnabled 返回 false）");
                                }
                                break;
                            } catch (NoSuchMethodException unused) {
                                aRc23Z.BNL6CD("当前 Android 版本不支持自定义热点");
                                break;
                            } catch (Exception e) {
                                aRc23Z.BNL6CD("开启热点异常：" + e.getMessage());
                                break;
                            }
                        } else {
                            try {
                                wifiManager.startLocalOnlyHotspot(new LFHees.A4TApA(a4TApA, aRc23Z), new Handler(Looper.getMainLooper()));
                                break;
                            } catch (SecurityException e2) {
                                aRc23Z.BNL6CD("缺少权限：" + e2.getMessage());
                                break;
                            } catch (Exception e3) {
                                aRc23Z.BNL6CD("启动异常：" + e3.getMessage());
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        ARc23Z();
        return 1;
    }
}
