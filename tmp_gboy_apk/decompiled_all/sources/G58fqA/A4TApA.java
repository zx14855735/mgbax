package G58fqA;

import ADYaiT.C4FrIb;
import GnQT2j.ARc23Z;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.BV3sI0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f2980A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public NotificationManager f2981A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public BV3sI0 f2982A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public NotificationChannel f2983ADYaiT;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Context f2984ARc23Z;

    public A4TApA(Context context, int i) {
        this.AMqCpz = false;
        this.f2980A2egSU = i;
        this.f2984ARc23Z = context;
        this.f2981A4TApA = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel A4TApA2 = C4FrIb.A4TApA();
            this.f2983ADYaiT = A4TApA2;
            A4TApA2.enableLights(false);
            this.f2983ADYaiT.enableVibration(false);
            this.f2983ADYaiT.setSound(null, null);
            NotificationManager notificationManager = this.f2981A4TApA;
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(this.f2983ADYaiT);
                this.AMqCpz = true;
            }
        }
    }

    public final synchronized void A2egSU(int i, int i2, String str, String str2) {
        BV3sI0 bV3sI0;
        try {
            if (this.AMqCpz && (bV3sI0 = this.f2982A5SV6n) != null && this.f2981A4TApA != null && !ARc23Z.f3104AZkASS) {
                if (i >= 0 && i2 >= 0) {
                    bV3sI0.f8528B4ZgIw = i2;
                    bV3sI0.f8529B7CMnp = i;
                    bV3sI0.f8530B9tovu = false;
                }
                if (str != null && !str.isEmpty()) {
                    BV3sI0 bV3sI02 = this.f2982A5SV6n;
                    bV3sI02.getClass();
                    bV3sI02.AMqCpz = BV3sI0.A4TApA(str);
                }
                if (str2 != null && !str2.isEmpty()) {
                    BV3sI0 bV3sI03 = this.f2982A5SV6n;
                    bV3sI03.getClass();
                    bV3sI03.f8515ARc23Z = BV3sI0.A4TApA(str2);
                }
                BV3sI0 bV3sI04 = this.f2982A5SV6n;
                bV3sI04.f8522AlLFFp = 2;
                this.f2981A4TApA.notify(this.f2980A2egSU, bV3sI04.A2egSU());
            }
        } finally {
        }
    }
}
