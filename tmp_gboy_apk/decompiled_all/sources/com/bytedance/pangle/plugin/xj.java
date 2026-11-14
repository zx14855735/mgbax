package com.bytedance.pangle.plugin;

import J3FDQU.A2egSU;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.c;
import com.bytedance.pangle.util.g;
import com.bytedance.sdk.openadsdk.api.y;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends Plugin {
    private com.bytedance.pangle.w.xj xj;

    public xj(JSONObject jSONObject) {
        super(jSONObject);
    }

    private void hf() {
        List<String> g = g.xj().g(this.mPkgName);
        if (g == null || g.size() <= 0) {
            return;
        }
        for (String str : g) {
            if (!TextUtils.isEmpty(str)) {
                int xj = com.bytedance.pangle.w.hf.xj(str);
                if (xj != -1) {
                    g.xj().hf(str, xj, false);
                }
                c.xj(com.bytedance.pangle.kd.w.xj(str));
            }
        }
        g.xj().am(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(g)));
    }

    private void w() {
        String p = g.xj().p(this.mPkgName);
        if (TextUtils.isEmpty(p)) {
            return;
        }
        String xj = com.bytedance.pangle.kd.w.xj(p);
        c.xj(xj);
        g.xj().pl(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(xj)));
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public void deleteIfNeeded() {
        if (com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication()) && g.xj().d(this.mPkgName)) {
            g.xj().f(this.mPkgName);
            String xj = com.bytedance.pangle.kd.w.xj(this.mPkgName);
            c.xj(xj);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + xj);
            hf();
            w();
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.bytedance.pangle.w.xj xjVar = this.xj;
        if (xjVar == null) {
            return null;
        }
        return xjVar.y();
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public void init() {
        com.bytedance.pangle.w.xj xjVar;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            try {
                if (this.mInitialized) {
                    return;
                }
                if (com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication())) {
                    deleteIfNeeded();
                    String p = g.xj().p(this.mPkgName);
                    if (TextUtils.isEmpty(p)) {
                        p = this.mPkgName;
                    }
                    int xj = com.bytedance.pangle.w.hf.xj(p);
                    if (xj != -1) {
                        File[] p2 = com.bytedance.pangle.kd.w.p(p, xj);
                        File file = new File(com.bytedance.pangle.kd.w.pl(p, xj));
                        if (p2 != null) {
                            try {
                            } catch (Exception e) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins fail throw exception ".concat(String.valueOf(e)));
                                y.xj(e);
                            }
                            if (p2.length > 0) {
                                this.xj = com.bytedance.pangle.w.hf.xj(file, (List<File>) Arrays.asList(p2));
                                if (p2 == null && p2.length > 0 && file.isFile() && (xjVar = this.xj) != null && xjVar.xj()) {
                                    updateToInstalled(xj);
                                } else {
                                    xj = 0;
                                }
                                xj(xj);
                                ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                                g.xj().xj(this.mPkgName);
                                g.xj().u(this.mPkgName);
                                g.xj().xj(this.mPkgName, com.bytedance.pangle.util.hf.xj(Zeus.getAppApplication()));
                                g.xj().xj(this.mPkgName, this.mApiVersionCode);
                            }
                        }
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                        if (p2 == null) {
                        }
                        xj = 0;
                        xj(xj);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        g.xj().xj(this.mPkgName);
                        g.xj().u(this.mPkgName);
                        g.xj().xj(this.mPkgName, com.bytedance.pangle.util.hf.xj(Zeus.getAppApplication()));
                        g.xj().xj(this.mPkgName, this.mApiVersionCode);
                    }
                    xj();
                } else {
                    updateInstallStateFromMainProcess();
                }
                this.mInitialized = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public boolean install(File file, com.bytedance.pangle.c.xj.kd kdVar) {
        boolean z = false;
        if (kdVar != null) {
            try {
                com.bytedance.pangle.w.xj xjVar = kdVar.w;
                if (xjVar != null) {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + xjVar);
                    String hf = xjVar.hf();
                    int w = xjVar.w();
                    synchronized (this.installLock) {
                        try {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + hf + " plugin=" + this);
                            boolean xj = xjVar.xj();
                            if (xj && (z = com.bytedance.pangle.w.hf.xj(xjVar, SystemClock.elapsedRealtime()))) {
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + hf + " version=" + w);
                            }
                            synchronized (this) {
                                try {
                                    if (!xj) {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + hf + ":" + w);
                                    } else if (this.mLifeCycle == 3) {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + hf + ":" + this.mVersionCode);
                                    } else if (z) {
                                        updateToInstalled(w);
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + hf + ":" + w);
                                    } else {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + hf + ":" + w);
                                    }
                                    c.xj(file);
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + hf + " version=" + w + " apkFile=" + file);
                                } finally {
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return z;
                }
            } catch (Throwable th2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "DexPlugin DEX ZIP IMPOSSIBLE!!!", th2);
            }
        }
        return z;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public String toString() {
        StringBuilder sb = new StringBuilder("DexPlugin{pkg=");
        sb.append(this.mPkgName);
        sb.append(", ver=");
        sb.append(this.mVersionCode);
        sb.append(", life=");
        return A2egSU.B2KMhB(sb, this.mLifeCycle, '}');
    }

    public void xj(com.bytedance.pangle.w.xj xjVar) {
        this.xj = xjVar;
    }

    private void xj(int i) {
        if (com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication())) {
            hf();
            String p = g.xj().p(this.mPkgName);
            if (TextUtils.isEmpty(p)) {
                com.bytedance.pangle.w.hf.xj(this.mPkgName, i);
            } else {
                com.bytedance.pangle.w.hf.xj(p, i);
            }
        }
    }

    public void xj() {
        String xj = com.bytedance.pangle.kd.w.xj(this.mPkgName);
        if (TextUtils.isEmpty(xj)) {
            return;
        }
        File[] listFiles = new File(xj).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + xj);
            c.xj(xj);
        }
    }
}
