package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {
    private static Handler aiA;
    private static WeakReference<Context> aiG;
    private static Messenger bdr;
    private static volatile ExecutorService bds;
    private static volatile AppStatusRules bdt;
    private static com.kwad.sdk.collector.h bdu;
    private static ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.utils.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (!g.Rh()) {
                    com.kwad.sdk.core.d.c.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                obtain.replyTo = g.bdr;
                try {
                    messenger.send(obtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.service.d.gatherException(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.kwad.sdk.utils.g$2, reason: invalid class name */
    public class AnonymousClass2 extends bg {
        final /* synthetic */ Context dq;

        public AnonymousClass2(Context context) {
            this.dq = context;
        }

        @Override // com.kwad.sdk.utils.bg
        public final void doTask() {
            com.kwad.sdk.collector.c.a(this.dq, new c.a() { // from class: com.kwad.sdk.utils.g.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.dq);
                    AppStatusRules unused = g.bdt = appStatusRules;
                    g.b(AnonymousClass2.this.dq, g.bdt);
                    g.cC(AnonymousClass2.this.dq);
                    boolean ep = br.ep(AnonymousClass2.this.dq);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(g.bdt);
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + ep);
                    if (ep && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = g.bdt.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            g.c(AnonymousClass2.this.dq, obtainDefaultScanInterval);
                        } else {
                            g.cE(AnonymousClass2.this.dq);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(g.bdt);
                    boolean z = g.bdt.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (isUploadTargetNotEmpty && z && ep) {
                        g.Ri();
                        g.bds.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.dq, g.bdt);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.d.gatherException(th);
                                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void v(int i, String str) {
                    com.kwad.sdk.core.d.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }
            });
        }
    }

    public interface b {
        void x(List<com.kwad.sdk.collector.model.b> list);
    }

    public static class d implements b {
        private b bdC = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.g.b
        public final void x(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray P = a.P(list);
            if (P != null) {
                g.bdu.c(P);
            }
            b bVar = this.bdC;
            if (bVar != null) {
                bVar.x(list);
            }
        }
    }

    static {
        QbMxEK();
    }

    private static List<com.kwad.sdk.collector.model.b> O(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    private static /* synthetic */ void QbMxEK() {
        char[] charArray = "íáã éïãë ìá÷ ýæëââ ÄàçÌüçêéë".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 142);
        }
        String str = new String(charArray);
        char[] charArray2 = "íâçàçú".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 142);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static AppStatusRules Rg() {
        return bdt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Rh() {
        if (bdr == null) {
            try {
                bdr = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return bdr != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ri() {
        if (bds == null) {
            synchronized (g.class) {
                try {
                    if (bds == null) {
                        ExecutorService Lp = GlobalThreadPools.Lp();
                        bds = Lp;
                        com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) Lp, "appStatusHelper");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static boolean Rj() {
        try {
            int i = ServiceProxyRemote.f12321AcNBzu;
            Context context = ServiceProvider.getContext();
            return context.getPackageManager().queryIntentServices(new Intent(context, (Class<?>) ServiceProxyRemote.class), 65536).size() > 0;
        } catch (ClassNotFoundException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static void a(Context context, long j, com.kwad.sdk.collector.h hVar) {
        if (bc.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ai(8192L) || context == null || com.kwad.sdk.utils.d.cA(context)) {
            return;
        }
        bdu = hVar;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        A2egSU.B9tovu("isMainProcess: ", "AppStatusHelper", isInMainProcess);
        if (isInMainProcess) {
            aiG = new WeakReference<>(context);
            if (aiA == null) {
                aiA = new Handler(Looper.getMainLooper());
            }
            aiA.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.k(file.getAbsolutePath(), com.kwad.sdk.core.a.c.encodeKsSdk(jSONObject), false);
    }

    public static void cC(Context context) {
        if (bdt == null) {
            bdt = cD(context);
        }
    }

    private static AppStatusRules cD(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String J = com.kwad.sdk.crash.utils.h.J(file);
            if (TextUtils.isEmpty(J)) {
                return null;
            }
            if (com.kwad.sdk.core.a.c.isEncodeKsSdk(J)) {
                J = com.kwad.sdk.core.a.c.decodeKsSdk(J);
            }
            JSONObject jSONObject = new JSONObject(J);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cE(Context context) {
        if (context == null) {
            return;
        }
        boolean Rj = Rj();
        A2egSU.B9tovu("isServiceAvailable: ", "AppStatusHelper", Rj);
        if (Rj) {
            com.kwad.sdk.collector.b.a.a(context, serviceConnection);
        } else {
            a(context, new d(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.kwad.sdk.collector.model.b> cF(Context context) {
        if (!br.ep(context)) {
            return new ArrayList();
        }
        if (bdt == null) {
            bdt = cD(context);
        }
        return cG(context);
    }

    private static List<com.kwad.sdk.collector.model.b> cG(Context context) {
        ArrayList arrayList = new ArrayList();
        if (bc.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ai(8192L) || com.kwad.sdk.utils.d.cA(context)) {
            return arrayList;
        }
        AppStatusRules Rg = Rg();
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(Rg)) {
            arrayList.addAll(a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy d2 = com.kwad.sdk.collector.i.d(Rg);
        arrayList.addAll(a(d2));
        d2.setNeedSaveLaunchTime(System.currentTimeMillis());
        return O(arrayList);
    }

    public static void c(final Context context, final long j) {
        if (aiA == null) {
            aiA = new Handler(Looper.getMainLooper());
        }
        aiA.post(new bg() { // from class: com.kwad.sdk.utils.g.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                g.cE(context);
                g.aiA.postDelayed(this, j);
            }
        });
    }

    public static class a implements com.kwad.sdk.core.b {
        private String appName;
        private List<Long> bdA = new ArrayList();
        private String packageName;

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        public static JSONArray P(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = Q(list);
            } catch (Exception e) {
                com.kwad.sdk.service.d.gatherException(e);
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = list2.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            return jSONArray;
        }

        private static List<a> Q(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap hashMap = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String b = com.kwad.sdk.collector.model.c.b(bVar);
                        if (hashMap.containsKey(b)) {
                            aVar = (a) hashMap.get(b);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            hashMap.put(b, aVar2);
                            aVar = aVar2;
                        }
                        long c = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.aY(c);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
            return null;
        }

        private void aY(long j) {
            this.bdA.add(Long.valueOf(j));
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.bdA.clear();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.bdA.add(Long.valueOf(optJSONArray.getLong(i)));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "appName", this.appName);
            aa.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.bdA.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            aa.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public a() {
        }
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || bc.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ai(8192L) || com.kwad.sdk.utils.d.cA(context)) {
            return;
        }
        Ri();
        bds.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.4
            @Override // java.lang.Runnable
            public final void run() {
                List cF;
                try {
                    HashSet hashSet = new HashSet();
                    if (!br.ep(context) || (cF = g.cF(context)) == null) {
                        return;
                    }
                    Iterator it = cF.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.c.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(cF);
                    if (bVar != null) {
                        bVar.x(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    com.kwad.sdk.service.d.gatherException(th);
                }
            }
        });
    }

    public static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        private static void R(List<a> list) {
            if (list == null) {
                return;
            }
            g.bdu.c(aa.S(list));
        }

        private void c(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> list2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = aa.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.g.c.1
                            private static a Rs() {
                                return new a();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a FU() {
                                return Rs();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable(PointParamKey.DATA);
                        list = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    list = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    c((ArrayList<com.kwad.sdk.collector.model.b>) arrayList);
                }
                if (list != null) {
                    R(list);
                }
            }
            if (g.aiG != null && g.aiG.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = aa.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.g.c.2
                            private static AppStatusRules.Strategy Rt() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy FU() {
                                return Rt();
                            }
                        });
                    }
                } else {
                    list2 = (ArrayList) data.getSerializable("allStrategy");
                }
                if (list2 != null) {
                    for (AppStatusRules.Strategy strategy : list2) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) g.aiG.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (g.aiG == null || g.serviceConnection == null) {
                return;
            }
            com.kwad.sdk.core.d.c.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.b.a.b((Context) g.aiG.get(), g.serviceConnection);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                c(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }

        private static void c(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray P;
            if (arrayList == null || (P = a.P(arrayList)) == null) {
                return;
            }
            g.bdu.c(P);
        }
    }

    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        if (!isNeedLaunch) {
            return new ArrayList();
        }
        return com.kwad.sdk.collector.b.Fr().a(strategy);
    }
}
