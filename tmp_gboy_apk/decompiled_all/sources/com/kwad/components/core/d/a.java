package com.kwad.components.core.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kuaishou.aegon.Aegon;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.d;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.l;
import com.kwad.sdk.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.m;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private static boolean OA;
    private static boolean OB;
    private static List<Throwable> OD;
    private static Map<String, String> OE;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean OC = new AtomicBoolean(false);
    private static final List<b> OF = new CopyOnWriteArrayList();
    private static final List<c> OG = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.d.a$a, reason: collision with other inner class name */
    public static class C0286a {
        public static String an(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = i >= 24 ? context.getDataDir() : null;
            if (dataDir != null) {
                return dataDir;
            }
            File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (file.exists()) {
                return file;
            }
            return new File("/data/data/" + context.getPackageName());
        }
    }

    public interface b {
        String getKey();

        JSONObject getValue();
    }

    public interface c {
        void onCrashOccur(int i, String str);
    }

    static {
        QckPCT();
    }

    private static /* synthetic */ void QckPCT() {
        char[] charArray = "çëéªãåéáªæëýª÷ìáèèªÎêíÆöíàãá".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 132);
        }
        String str = new String(charArray);
        char[] charArray2 = "çèíêíð".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 132);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void a(b bVar) {
        OF.add(bVar);
    }

    private static com.kwad.sdk.crash.model.b aj(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.kwad.sdk.crash.model.b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.model.b bVar = new com.kwad.sdk.crash.model.b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("KsAdExceptionCollectorHelper", e);
            return new com.kwad.sdk.crash.model.b();
        }
    }

    private static String ak(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static synchronized void am(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!OC.get() && !OB) {
                    OB = true;
                    h.execute(new bg() { // from class: com.kwad.components.core.d.a.2
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (e.b(com.kwad.sdk.core.config.c.aDi)) {
                                com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init Native");
                                com.kwad.sdk.crash.b.b(a.oN());
                                a.OC.set(true);
                            }
                        }
                    });
                }
            }
        }
    }

    private static void b(Throwable th) {
        if (OD == null) {
            OD = new CopyOnWriteArrayList();
        }
        OD.add(th);
    }

    public static synchronized void initAsync(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!mHasInit.get() && !OA) {
                    OA = true;
                    h.execute(new bg() { // from class: com.kwad.components.core.d.a.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (e.b(com.kwad.sdk.core.config.c.aDi)) {
                                com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init");
                                com.kwad.sdk.crash.b.a(a.oN());
                                a.mHasInit.set(true);
                                a.oL();
                                a.oM();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void j(String str, String str2) {
        if (mHasInit.get()) {
            com.kwad.sdk.crash.report.h.ai(str, str2);
        } else {
            k(str, str2);
        }
    }

    private static void k(String str, String str2) {
        if (OE == null) {
            OE = new ConcurrentHashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        OE.put(str, str2);
    }

    private static boolean oK() {
        return e.b(com.kwad.sdk.core.config.c.aDj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void oL() {
        if (OD == null || !oK()) {
            return;
        }
        Iterator<Throwable> it = OD.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.crash.b.n(it.next());
        }
        OD.clear();
        OD = null;
        ServiceProvider.f(new com.kwad.sdk.g.a<Throwable>() { // from class: com.kwad.components.core.d.a.3
            private static void c(Throwable th) {
                com.kwad.sdk.crash.b.n(th);
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(Throwable th) {
                c(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void oM() {
        Map<String, String> map = OE;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                com.kwad.sdk.crash.report.h.ai(entry.getKey(), entry.getValue());
            }
        }
        OE.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwad.sdk.crash.c oN() {
        String a2 = e.a(com.kwad.sdk.core.config.c.aEH);
        A2egSU.B7CMnp("configStr:", a2, "KsAdExceptionCollectorHelper");
        com.kwad.sdk.crash.model.b aj = aj(a2);
        String str = aj.aUo;
        String str2 = aj.aUp;
        boolean a3 = g.a(aj);
        boolean b2 = g.b(aj);
        final Context context = ServiceProvider.getContext();
        String an = C0286a.an(context);
        c.a fy = new c.a().ck(context).bI(a3).bJ(b2).bK(l.DP().CT()).fz(str).fy(str2);
        l.DP();
        c.a fG = fy.fG(ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 1));
        l.DP();
        return fG.el(BuildConfig.VERSION_CODE).fH(ExceptionMessage.getSdkCrashVersionName(l.DP().getApiVersion(), 1)).em(l.DP().getApiVersionCode()).en(1).fF("com.kwad.sdk").fI(context.getPackageName()).fJ(ServiceProvider.getSDKConfig().appId).fK(ServiceProvider.getSDKConfig().appName).fL(m.cN(context)).fM(aj.aUk).fN(aj.aUl).fC(bd.getDeviceId()).fD(ServiceProvider.getSDKConfig().appId).fB(aj.version).fO(aj.aUn).fP(aj.aUm).fA("Android").fE(an).a(new com.kwad.sdk.crash.h() { // from class: com.kwad.components.core.d.a.5
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a oW() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.fU(t.Ku());
                aVar.putString("mKsadAppId", ServiceProvider.getSDKConfig().appId);
                aVar.putString("mKsadAppName", ServiceProvider.getSDKConfig().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", m.cN(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                l.DP();
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(l.getSDKVersion(), 1));
                l.DP();
                aVar.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(l.DP().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", l.DP().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", 304);
                for (b bVar : a.OF) {
                    String key = bVar.getKey();
                    JSONObject value = bVar.getValue();
                    if (key != null && value != null) {
                        aVar.a(bVar.getKey(), bVar.getValue());
                    }
                }
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.d.a.4
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                n.aZ(context);
                if (i == 1 || i == 3 || i == 4) {
                    com.kwad.components.ad.reward.A2egSU.A4TApA(i, "onOccurred crashType=", "KsAdExceptionCollectorHelper");
                }
                Iterator it = a.OG.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onCrashOccur(i, exceptionMessage.mCrashDetail);
                }
            }
        }).d(oO()).e(oP()).H(e.GN()).m(e.a(com.kwad.sdk.core.config.c.aFP)).Ni();
    }

    private static String[] oO() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(ak(KsAdSDKImpl.class.getName()));
            arrayList.add(ak(DownloadTask.class.getName()));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        try {
            arrayList.add(ak(CpuMemoryProfiler.class.getName()));
            arrayList.add(ak(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] oP() {
        String[] strArr = new String[1];
        try {
            String name = d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
            return strArr;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return strArr;
        }
    }

    public static void reportSdkCaughtException(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTrace(th);
        if (!mHasInit.get()) {
            b(th);
        } else if (oK()) {
            com.kwad.sdk.crash.b.n(th);
        }
    }

    public static void a(c cVar) {
        OG.add(cVar);
    }
}
