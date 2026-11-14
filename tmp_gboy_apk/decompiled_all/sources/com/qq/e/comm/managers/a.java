package com.qq.e.comm.managers;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements IGDTAdManager {
    public static final ExecutorService g = Executors.newSingleThreadExecutor();

    /* renamed from: A2egSU, reason: collision with root package name */
    public volatile boolean f12921A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public volatile boolean f12922A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile Context f12923A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public volatile PM f12924ADYaiT;
    public volatile DevTools AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public volatile String f12925ARc23Z;

    /* renamed from: com.qq.e.comm.managers.a$a, reason: collision with other inner class name */
    class RunnableC0446a implements Runnable {

        /* renamed from: AcNBzu, reason: collision with root package name */
        public final /* synthetic */ GDTAdSdk.OnStartListener f12926AcNBzu;

        public RunnableC0446a(GDTAdSdk.OnStartListener onStartListener) {
            this.f12926AcNBzu = onStartListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                POFactory pOFactory = a.this.f12924ADYaiT.getPOFactory(false, false);
                if (pOFactory == null) {
                    GDTAdSdk.OnStartListener onStartListener = this.f12926AcNBzu;
                    if (onStartListener != null) {
                        onStartListener.onStartFailed(new Exception("GDTAdSdk start异常"));
                        return;
                    }
                    return;
                }
                pOFactory.start(a.this.f12924ADYaiT.getStartCaller(1));
                GDTAdSdk.OnStartListener onStartListener2 = this.f12926AcNBzu;
                if (onStartListener2 != null) {
                    onStartListener2.onStartSuccess();
                }
            } catch (e e) {
                GDTLogger.e(e.getMessage(), e);
                GDTAdSdk.OnStartListener onStartListener3 = this.f12926AcNBzu;
                if (onStartListener3 != null) {
                    onStartListener3.onStartFailed(e);
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: AcNBzu, reason: collision with root package name */
        public final /* synthetic */ boolean f12928AcNBzu;

        public b(boolean z) {
            this.f12928AcNBzu = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f12924ADYaiT.getPOFactory(this.f12928AcNBzu, true);
                a.this.f12922A4TApA = true;
            } catch (e e) {
                GDTLogger.e(e.getMessage(), e);
            }
        }
    }

    public static final class c {

        /* renamed from: A2egSU, reason: collision with root package name */
        public static final a f12930A2egSU;

        static {
            a aVar = new a();
            aVar.f12921A2egSU = false;
            aVar.f12922A4TApA = false;
            f12930A2egSU = aVar;
            isSnKFr();
        }

        private static /* synthetic */ void isSnKFr() {
            char[] charArray = "óÿý¾÷ñýõ¾òÿé¾ãøõüü¾ÚþùÒâùô÷õ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 144);
            }
            String str = new String(charArray);
            char[] charArray2 = "óüùþùä".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 144);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        xRWA();
    }

    public static a b() {
        return c.f12930A2egSU;
    }

    private static /* synthetic */ void xRWA() {
        char[] charArray = "¡\u00ad¯ì¥£¯§ì \u00ad»ì±ª§®®ì\u0088¬«\u0080°«¦¥§".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 194);
        }
        String str = new String(charArray);
        char[] charArray2 = "¡®«¬«¶".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 194);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final synchronized void A2egSU(Context context, String str, boolean z) {
        if (this.f12921A2egSU) {
            return;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return;
        }
        try {
            this.f12925ARc23Z = str;
            this.f12923A5SV6n = context.getApplicationContext();
            this.f12924ADYaiT = new PM(this.f12923A5SV6n, null);
            g.submit(new b(z));
            this.f12921A2egSU = true;
        } catch (Throwable th) {
            GDTLogger.e("GDTADManager初始化错误", th);
        }
    }

    public String a() {
        return this.f12925ARc23Z;
    }

    public PM c() {
        return this.f12924ADYaiT;
    }

    public boolean d() {
        if (this.f12921A2egSU) {
            return true;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.initWithoutStart() 初始化");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (!d()) {
            return "";
        }
        try {
            return this.f12924ADYaiT.getPOFactory().getBuyerId(map);
        } catch (Exception e) {
            GDTLogger.e("SDK 初始化异常", e);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.AMqCpz == null) {
            this.AMqCpz = new DevTools();
        }
        return this.AMqCpz;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.f12924ADYaiT.getPOFactory().getSDKInfo(str);
        } catch (Exception e) {
            GDTLogger.e("SDK 初始化异常", e);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.f12922A4TApA) {
            return 0;
        }
        try {
            return this.f12924ADYaiT.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e) {
            GDTLogger.e("SDK 初始化异常", e);
            return 0;
        }
    }
}
