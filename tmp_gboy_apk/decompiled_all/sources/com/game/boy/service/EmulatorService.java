package com.game.boy.service;

import KpHwm4.AaHO0E;
import KpHwm4.B25kr6;
import McNXgv.A4TApA;
import Mib1rf.A2egSU;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import androidx.core.app.BV3sI0;
import com.bykv.vk.component.ttvideo.player.C;
import com.game.boy.activity.EmulatorActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class EmulatorService extends Service {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static EmulatorService f11108B4ZgIw;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public NotificationManager f11109AcNBzu;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Handler f11111AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public B25kr6 f11112AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public PowerManager.WakeLock f11113B25kr6;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final A2egSU f11110AlLFFp = new A2egSU();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f11114B2KMhB = false;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public volatile String f11115B3GDIM = null;

    public final synchronized B25kr6 A2egSU(AaHO0E aaHO0E) {
        Handler handler;
        try {
            if (this.f11112AzWtSf == null && aaHO0E != null) {
                EmulatorActivity BV3sI02 = EmulatorActivity.BV3sI0();
                if (BV3sI02 == null || (handler = BV3sI02.f11008BniPrB) == null) {
                    if (this.f11111AmA8tU == null) {
                        this.f11111AmA8tU = new Handler(Looper.getMainLooper());
                    }
                    handler = this.f11111AmA8tU;
                }
                this.f11112AzWtSf = new B25kr6(handler, aaHO0E);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f11112AzWtSf;
    }

    public final Notification A4TApA(String str) {
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) EmulatorActivity.class).setFlags(C.ENCODING_PCM_A_LAW), 201326592);
        BV3sI0 bV3sI0 = new BV3sI0(this, "EmulatorServiceChannel");
        bV3sI0.AMqCpz = BV3sI0.A4TApA("GBoy");
        bV3sI0.f8515ARc23Z = BV3sI0.A4TApA(str);
        bV3sI0.f8551CikNvS.icon = 2131231036;
        bV3sI0.f8516ASJ6gh = activity;
        bV3sI0.AMqCpz(2, true);
        bV3sI0.AMqCpz(8, true);
        bV3sI0.f8522AlLFFp = -1;
        bV3sI0.f8549CcAIMM = 1;
        return bV3sI0.A2egSU();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005f, code lost:
    
        if (r2.equals("wifi_server") == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String A5SV6n() {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            monitor-enter(r5)
            KpHwm4.B25kr6 r2 = r5.f11112AzWtSf     // Catch: java.lang.Throwable -> Ld
            if (r2 == 0) goto L10
            McNXgv.A4TApA r2 = r2.f4351A4TApA     // Catch: java.lang.Throwable -> Ld
            if (r2 == 0) goto L10
            r2 = 1
            goto L11
        Ld:
            r0 = move-exception
            goto L77
        L10:
            r2 = 0
        L11:
            monitor-exit(r5)
            if (r2 != 0) goto L17
            java.lang.String r0 = "游戏运行中"
            return r0
        L17:
            java.lang.String r2 = r5.f11115B3GDIM
            if (r2 != 0) goto L1e
            java.lang.String r2 = ""
            goto L20
        L1e:
            java.lang.String r2 = r5.f11115B3GDIM
        L20:
            r2.getClass()
            r3 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case -2105521235: goto L59;
                case 3506395: goto L4e;
                case 616416344: goto L43;
                case 1068302288: goto L38;
                case 1737560117: goto L2d;
                default: goto L2b;
            }
        L2b:
            r0 = -1
            goto L62
        L2d:
            java.lang.String r0 = "wifi_client"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L36
            goto L2b
        L36:
            r0 = 4
            goto L62
        L38:
            java.lang.String r0 = "bt_server"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L41
            goto L2b
        L41:
            r0 = 3
            goto L62
        L43:
            java.lang.String r0 = "bt_client"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L4c
            goto L2b
        L4c:
            r0 = 2
            goto L62
        L4e:
            java.lang.String r0 = "room"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L57
            goto L2b
        L57:
            r0 = 1
            goto L62
        L59:
            java.lang.String r1 = "wifi_server"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L62
            goto L2b
        L62:
            switch(r0) {
                case 0: goto L74;
                case 1: goto L71;
                case 2: goto L6e;
                case 3: goto L6b;
                case 4: goto L68;
                default: goto L65;
            }
        L65:
            java.lang.String r0 = "联机中"
            return r0
        L68:
            java.lang.String r0 = "联机中 · WiFi 客户端"
            return r0
        L6b:
            java.lang.String r0 = "联机中 · 蓝牙服务端"
            return r0
        L6e:
            java.lang.String r0 = "联机中 · 蓝牙客户端"
            return r0
        L71:
            java.lang.String r0 = "联机中 · 远程房间"
            return r0
        L74:
            java.lang.String r0 = "联机中 · WiFi 服务端"
            return r0
        L77:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> Ld
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.service.EmulatorService.A5SV6n():java.lang.String");
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f11110AlLFFp;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        f11108B4ZgIw = this;
        this.f11109AcNBzu = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel BIYEnU2 = JMFfuZ.A2egSU.BIYEnU();
            BIYEnU2.setShowBadge(false);
            BIYEnU2.setSound(null, null);
            BIYEnU2.enableVibration(false);
            BIYEnU2.setDescription("保持游戏在后台运行");
            this.f11109AcNBzu.createNotificationChannel(BIYEnU2);
        }
        try {
            PowerManager powerManager = (PowerManager) getSystemService("power");
            if (powerManager == null) {
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "GBoy::EmulatorWakeLock");
            this.f11113B25kr6 = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            this.f11113B25kr6.acquire();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        A4TApA a4TApA;
        B25kr6 b25kr6 = this.f11112AzWtSf;
        if (b25kr6 != null && (a4TApA = b25kr6.f4351A4TApA) != null) {
            try {
                a4TApA.interrupt();
                this.f11112AzWtSf.f4351A4TApA.A2egSU();
                this.f11112AzWtSf.f4351A4TApA.join(2000L);
            } catch (Exception unused) {
            }
        }
        this.f11112AzWtSf = null;
        this.f11115B3GDIM = null;
        try {
            PowerManager.WakeLock wakeLock = this.f11113B25kr6;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.f11113B25kr6.release();
            }
        } catch (Exception unused2) {
        }
        this.f11113B25kr6 = null;
        if (Build.VERSION.SDK_INT >= 24) {
            stopForeground(1);
        } else {
            stopForeground(true);
        }
        f11108B4ZgIw = null;
        this.f11114B2KMhB = false;
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        if (!this.f11114B2KMhB) {
            Notification A4TApA2 = A4TApA(A5SV6n());
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(1, A4TApA2, 1);
            } else {
                startForeground(1, A4TApA2);
            }
            this.f11114B2KMhB = true;
        }
        return 1;
    }

    public final void onTimeout(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 35) {
            if (i3 >= 24) {
                stopForeground(1);
            } else {
                stopForeground(true);
            }
            stopSelf();
        }
    }
}
