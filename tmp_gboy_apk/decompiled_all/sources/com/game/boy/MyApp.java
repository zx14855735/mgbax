package com.game.boy;

import ADYaiT.BI9f7h;
import ADYaiT.BJ7GGh;
import ADYaiT.D8MqeW;
import AaHO0E.HIguqb;
import LlW7FF.ASJ6gh;
import MIEDxH.A2egSU;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import io.dcloud.ads.core.DCloudAdManager;
import io.dcloud.openapi.core.DCloudAOLManager;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MyApp extends Application {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static MyApp f10877AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static Toast f10878AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final Handler f10879AmA8tU = new Handler(Looper.getMainLooper());

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static ASJ6gh f10880AzWtSf;

    static {
        XROWY();
    }

    public static void A2egSU(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        f10879AmA8tU.post(new D8MqeW(22, str));
    }

    private static /* synthetic */ void XROWY() {
        char[] charArray = "`ln-dbnf-alz-pkfoo-ImjAqjgdf".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 3);
        }
        String str = new String(charArray);
        char[] charArray2 = "`ojmjw".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 3);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        DCloudAdManager.InitConfig initConfig = new DCloudAdManager.InitConfig();
        initConfig.setAppId("NAFA21789").setAdId("121817020912");
        DCloudAOLManager.init(this, initConfig);
        Logs.init(this);
        if (A2egSU.f4980AYUAbz == null) {
            A2egSU.f4980AYUAbz = this;
        }
        A2egSU.A5SV6n();
        A2egSU.A5SV6n().AMqCpz(false, null);
        new Thread(new D8MqeW(21, this)).start();
        f10877AcNBzu = this;
        BI9f7h bI9f7h = BJ7GGh.f97AcNBzu;
        int i = HIguqb.f932A2egSU;
    }
}
