package com.bytedance.pangle.plugin;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.d;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.c;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.pl;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.fl.saas.base.custom.MedProConst;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_LOADING = 4;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    protected int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    protected volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsDexPlugin;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    protected int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    protected volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    final Object installLock = new Object();
    final Object initializeLock = new Object();

    public Plugin(JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mIsDexPlugin = false;
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        if (jSONObject.has("isDexPlugin")) {
            this.mIsDexPlugin = jSONObject.getInt("isDexPlugin") == 1;
        }
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString("signature", "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString(MedProConst.AD_APPKEY, "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.mSharedHostSos.add((String) optJSONArray.get(i));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkValid(File file, String str, int i) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        }
        if (i < this.mMinVersionCode || i > this.mMaxVersionCode) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + CtFAbx.AZkASS("].", this.mMaxVersionCode, J3FDQU.A2egSU.B7CMnp(i, this.mMinVersionCode, " pluginApk ver[", "] not match plugin VerRange[", ", ")));
            return false;
        }
        if (i < this.mVersionCode && isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + (" pluginApk ver[" + i + "] lower than installed plugin[" + this.mVersionCode + "]."));
            return false;
        }
        if (file == null || !file.exists()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        }
        if (i == this.mVersionCode && g.xj().tf(str).equals(com.bytedance.pangle.util.w.xj(file)[0])) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
            return false;
        }
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i + " true");
        return true;
    }

    private boolean checkVersionValid(int i, int i2, boolean z) {
        int kd = g.xj().kd(this.mPkgName);
        boolean z2 = false;
        if (kd > i2) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(" checkVersionValid " + this.mPkgName + " apiVersion downgrade , lastApiVersion=" + kd + " , currentApiVersion=" + i2));
            return false;
        }
        boolean z3 = i >= 0 && i >= this.mMinVersionCode && i <= this.mMaxVersionCode;
        if (z3 && i2 != -1) {
            int hf = g.xj().hf(this.mPkgName, i);
            int w = g.xj().w(this.mPkgName, i);
            if (i2 < hf || i2 > w) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(" checkVersionValid plugin[" + this.mPkgName + ", ver=" + this.mVersionCode + "] is not compatible with api[ver_code=" + i2 + "], apiCompatibleVer=[" + hf + "," + w + "]"));
                z3 = false;
            }
        }
        if (z3 && z && com.bytedance.pangle.kd.hf.hf(new File(com.bytedance.pangle.kd.w.hf(this.mPkgName, i)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(" checkVersionValid plugin[" + this.mPkgName + ", ver=" + i + "] not match hostAbi"));
        } else {
            z2 = z3;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z2);
        return z2;
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.kd.w.xj(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    g.xj().hf(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        c.xj(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i) {
        if (com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.kd.w.xj(this.mPkgName);
            }
            final String concat = "version-".concat(String.valueOf(i));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null && !concat.equals(file.getName()) && !PointParamKey.DATA.equals(file.getName())) {
                        c.xj(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            g.xj().hf(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication())) {
            if (this.mReInstallInternalPluginByMd5) {
                if (getVersion() > this.mInternalVersionCode) {
                    return;
                }
            } else if (getVersion() >= this.mInternalVersionCode) {
                return;
            }
            if (TextUtils.isEmpty(this.mInternalPath)) {
                return;
            }
            com.bytedance.pangle.kd.kd.xj(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                @Override // java.lang.Runnable
                public void run() {
                    File file;
                    try {
                        if (Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                            file = new File(com.bytedance.pangle.kd.w.w(), Plugin.this.mPkgName + ".7z.zip");
                        } else {
                            file = new File(com.bytedance.pangle.kd.w.w(), Plugin.this.mPkgName + ".apk");
                        }
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        c.xj(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            new hf(Plugin.this.mPkgName, file).run();
                            return;
                        }
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. ", th);
                    }
                }
            });
        }
    }

    private int modifyResIfNeed(int i) {
        String xj = com.bytedance.pangle.util.hf.xj(Zeus.getAppApplication());
        if (TextUtils.isEmpty(xj) || !TextUtils.equals(g.xj().y(this.mPkgName), xj)) {
            if (this.mUnInstallPluginWhenHostChange || GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
                ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i);
                return 0;
            }
            ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
            int xj2 = new com.bytedance.pangle.res.xj.w().xj(new File(com.bytedance.pangle.kd.w.hf(this.mPkgName, i)), true, new StringBuilder());
            if (xj2 != 100 && xj2 != 200) {
                return 0;
            }
        }
        return i;
    }

    private void setupInternalPlugin() {
        int xj;
        if (g.xj().y(this.mPkgName, this.mApiVersionCode)) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(d.u)) {
                    if (str.startsWith(this.mPkgName + "_") && (xj = pl.xj(str.split("_")[1], -1)) != -1) {
                        this.mInternalPath = d.u + "/" + str;
                        this.mInternalVersionCode = xj;
                        return;
                    }
                }
            } catch (IOException e) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
            }
        }
    }

    public void deleteIfNeeded() {
        if (com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication()) && g.xj().d(this.mPkgName)) {
            g.xj().f(this.mPkgName);
            deleteInstalledPlugin();
            ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
        }
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.kd.w.xj(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                if (parseInt > i && g.xj().u(this.mPkgName, parseInt) && com.bykv.vk.component.ttvideo.player.A2egSU.BPw6Q8(com.bytedance.pangle.kd.w.hf(this.mPkgName, parseInt))) {
                    i = parseInt;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i);
        return i;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public JSONObject getJsonConfig() {
        return null;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i = this.mVersionCode;
        return i > 0 ? com.bytedance.pangle.kd.w.u(this.mPkgName, i) : com.bytedance.pangle.kd.w.xj(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public void init() {
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            try {
                if (this.mInitialized) {
                    return;
                }
                if (com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication())) {
                    int i = 0;
                    boolean w = g.xj().hf(this.mPkgName) ? g.xj().w(this.mPkgName) : false;
                    deleteIfNeeded();
                    int installedMaxVer = getInstalledMaxVer();
                    if (checkVersionValid(installedMaxVer, this.mApiVersionCode, w)) {
                        i = modifyResIfNeed(installedMaxVer);
                        updateToInstalled(i);
                    }
                    deleteOtherExpiredVer(i);
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                    g.xj().xj(this.mPkgName);
                    g.xj().u(this.mPkgName);
                    g.xj().xj(this.mPkgName, com.bytedance.pangle.util.hf.xj(Zeus.getAppApplication()));
                    g.xj().xj(this.mPkgName, this.mApiVersionCode);
                } else {
                    updateInstallStateFromMainProcess();
                }
                this.mInitialized = true;
                installInternalPlugin();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    public boolean install(File file, com.bytedance.pangle.c.xj.kd kdVar) {
        boolean z = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = kdVar.xj;
            int i = kdVar.hf;
            synchronized (this.installLock) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                    boolean checkValid = checkValid(file, str, i);
                    if (checkValid) {
                        String str2 = com.bytedance.pangle.util.w.xj(file)[0];
                        z = w.xj(file, str, i);
                        if (z) {
                            g.xj().hf(this.mPkgName, str2);
                            g.xj().hf(this.mPkgName, i, true);
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i + " identity=" + str2);
                            c.xj(file);
                        }
                    }
                    synchronized (this) {
                        try {
                            if (!checkValid) {
                                c.xj(file);
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i);
                            } else if (this.mLifeCycle == 3) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i);
                            } else if (z) {
                                updateToInstalled(i);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i);
                            } else {
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i);
                                c.xj(file);
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i);
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        } catch (Throwable th2) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th2);
            return z;
        }
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isIsDexPlugin() {
        return this.mIsDexPlugin;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isLoading() {
        return this.mLifeCycle == 4;
    }

    public boolean isVersionInstalled(int i) {
        return g.xj().u(this.mPkgName, i);
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        g.xj().xj(this.mPkgName, i, i2, i3);
    }

    public void setLifeCycle(int i) {
        this.mLifeCycle = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Plugin{pkg=");
        sb.append(this.mPkgName);
        sb.append(", ver=");
        sb.append(this.mVersionCode);
        sb.append(", life=");
        return J3FDQU.A2egSU.B2KMhB(sb, this.mLifeCycle, '}');
    }

    public void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.w xj;
        try {
            if (com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (xj = com.bytedance.pangle.servermanager.hf.xj()) == null || !xj.xj(this.mPkgName)) {
                return;
            }
            updateToInstalled(xj.hf(this.mPkgName));
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PPM, "updateInstallStateFromMainProcess error. process = " + com.bytedance.pangle.kd.u.xj(Zeus.getAppApplication()), th);
        }
    }

    public void updateToInstalled(int i) {
        this.mVersionCode = i;
        this.mLifeCycle = 2;
    }
}
