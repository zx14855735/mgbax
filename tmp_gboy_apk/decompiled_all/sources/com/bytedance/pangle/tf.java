package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf {
    private static volatile tf xj;
    private boolean hf;
    private final List<ZeusPluginStateListener> w = new CopyOnWriteArrayList();
    private final List<ZeusPluginEventCallback> u = new ArrayList();
    private final Handler kd = new Handler(Looper.getMainLooper());
    private ZeusPluginDecodeCallback y = null;
    private Map<String, JSONObject> c = new ConcurrentHashMap();

    private void c() {
        try {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke disableApiWarning");
            FieldUtils.writeField(com.bytedance.pangle.kd.xj.xj(), "mHiddenApiWarningShown", Boolean.TRUE);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
        }
    }

    private Object[] f() {
        Object[] array;
        synchronized (this.u) {
            try {
                array = !this.u.isEmpty() ? this.u.toArray() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return array == null ? new Object[0] : array;
    }

    public static tf xj() {
        if (xj == null) {
            synchronized (tf.class) {
                try {
                    if (xj == null) {
                        xj = new tf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private void y() {
        ProviderInfo[] providerInfoArr;
        String str;
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "start");
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                str = providerInfo.processName.split(":")[1];
                                if (Zeus.getServerManagerHashMap().get(str) != null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                    Zeus.getServerManagerHashMap().put(str, providerInfo);
                                }
                            }
                            str = "main";
                            if (Zeus.getServerManagerHashMap().get(str) != null) {
                            }
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "finish");
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "error:".concat(String.valueOf(e)));
            throw new RuntimeException(e);
        }
    }

    public boolean hf() {
        return this.hf;
    }

    public Map<String, JSONObject> kd() {
        return this.c;
    }

    public ZeusPluginDecodeCallback u() {
        return this.y;
    }

    public List<ZeusPluginStateListener> w() {
        return this.w;
    }

    public void hf(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = this.w;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public void hf(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.u) {
            this.u.remove(zeusPluginEventCallback);
        }
    }

    public synchronized void xj(Application application) {
        Throwable th;
        try {
            try {
                if (this.hf) {
                    try {
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                xj(3000, 0, null, -1, null);
                Zeus.setAppContext(application);
                GlobalParam globalParam = GlobalParam.getInstance();
                globalParam.init();
                if (application != null) {
                    ZeusLogger.setDebug(globalParam.isDebug());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
                    com.bytedance.pangle.kd.kd.hf(new Runnable() { // from class: com.bytedance.pangle.tf.1
                        @Override // java.lang.Runnable
                        public void run() {
                            p.hf();
                        }
                    });
                    if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                        com.bytedance.pangle.y.y.xj();
                    }
                    com.bytedance.pangle.u.hf.xj().xj(new com.bytedance.pangle.u.xj() { // from class: com.bytedance.pangle.tf.2
                        @Override // com.bytedance.pangle.u.xj
                        public void xj(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                            com.bytedance.pangle.log.hf.xj(str, jSONObject, jSONObject2, jSONObject3);
                        }
                    });
                    if (!globalParam.isCloseFlipped()) {
                        hf.xj();
                    }
                    if (com.bytedance.pangle.util.d.e()) {
                        com.bytedance.pangle.kd.kd.xj(new Runnable() { // from class: com.bytedance.pangle.tf.3
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke SystemConfig");
                                    MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                                } catch (Throwable th3) {
                                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "invoke SystemConfig error : ".concat(String.valueOf(th3)));
                                }
                            }
                        });
                    }
                    if (com.bytedance.pangle.util.d.qt()) {
                        c();
                    }
                    y();
                    ContentProviderManager.getInstance().initSystemContentProviderInfo();
                    if (!globalParam.closeHookHuaweiOnInit()) {
                        Zeus.hookHuaWeiVerifier(application);
                    }
                    this.hf = true;
                    try {
                        xj(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "context is null");
                throw new IllegalArgumentException("context must be not null !!!");
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public void xj(ZeusPluginStateListener zeusPluginStateListener) {
        this.w.add(zeusPluginStateListener);
    }

    public void xj(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.u) {
            this.u.add(zeusPluginEventCallback);
        }
    }

    public void xj(final int i, final int i2, final String str, final int i3, final Throwable th) {
        for (final Object obj : f()) {
            this.kd.post(new Runnable() { // from class: com.bytedance.pangle.tf.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i, i2, str, i3, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void xj(ZeusPluginDecodeCallback zeusPluginDecodeCallback) {
        this.y = zeusPluginDecodeCallback;
    }
}
