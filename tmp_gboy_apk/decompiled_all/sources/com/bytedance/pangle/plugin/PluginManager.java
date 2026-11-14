package com.bytedance.pangle.plugin;

import A5SV6n.A2egSU;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.d;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.tf;
import com.bytedance.pangle.util.g;
import com.sigmob.sdk.base.views.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class PluginManager {
    private static final String TAG = "PluginManager";
    private static volatile PluginManager sInstance;
    private volatile boolean hasInstallFromDownloadDir;
    private volatile boolean mIsParsePluginConfig;
    private volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    private final u pluginLoader = new u();

    private PluginManager() {
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || com.bykv.vk.component.ttvideo.player.A2egSU.BPw6Q8(com.bytedance.pangle.kd.w.hf(plugin.mPkgName, plugin.getVersion()))) {
            return;
        }
        unInstallPackage(plugin.mPkgName);
    }

    public static PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new PluginManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private synchronized void parsePluginConfig() {
        try {
            if (this.mIsParsePluginConfig) {
                return;
            }
            ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
            ArrayList arrayList = new ArrayList();
            try {
                Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), r.b.d).applicationInfo.metaData;
                try {
                    for (String str : bundle.keySet()) {
                        String str2 = d.kd;
                        if (str2.startsWith("PANGLE_")) {
                            if (!str.startsWith(str2) && !str.startsWith("ZEUS_PLUGIN_")) {
                            }
                            arrayList.add(bundle.getString(str));
                        } else if (str.startsWith(str2)) {
                            arrayList.add(bundle.getString(str));
                        }
                    }
                    try {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Plugin parsePlugins = parsePlugins((String) it.next());
                            if (parsePlugins != null) {
                                concurrentHashMap.put(parsePlugins.mPkgName, parsePlugins);
                                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + parsePlugins.mPkgName);
                            }
                        }
                        Map<String, JSONObject> kd = tf.xj().kd();
                        if (kd != null && kd.size() > 0) {
                            for (Map.Entry<String, JSONObject> entry : kd.entrySet()) {
                                String key = entry.getKey();
                                JSONObject value = entry.getValue();
                                if (!TextUtils.isEmpty(key) && value != null) {
                                    Plugin parsePlugins2 = parsePlugins(value);
                                    concurrentHashMap.put(parsePlugins2.mPkgName, parsePlugins2);
                                    ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager getPluginsJson. find " + parsePlugins2.mPkgName);
                                }
                            }
                        }
                        this.mPlugins.putAll(concurrentHashMap);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
                    } catch (Exception e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e);
                    }
                    this.mIsParsePluginConfig = true;
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager iterator metaData failed.", e2);
                }
            } catch (Exception e3) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e3);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private Plugin parsePlugins(String str) {
        if (str == null) {
            return null;
        }
        try {
            return parsePlugins(new JSONObject(str));
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str.trim(), e);
            return null;
        }
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            com.bytedance.pangle.kd.kd.hf(new hf(str, file));
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
        } else {
            ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        }
    }

    public boolean checkPluginInstalled(String str) {
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z = plugin != null && plugin.isInstalled();
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
        return z;
    }

    public Plugin getPlugin(String str, boolean z) {
        if (!Zeus.hasInit() && com.bytedance.pangle.util.hf.xj()) {
            throw new RuntimeException("Please init Zeus first!");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (z && plugin != null) {
            plugin.init();
        }
        return plugin;
    }

    public Plugin getPluginOnly(String str) {
        return this.mPlugins.get(str);
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication())) {
            com.bytedance.pangle.kd.kd.hf(new kd());
        }
        this.hasInstallFromDownloadDir = true;
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public boolean loadPlugin(String str) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "start load plugin:".concat(String.valueOf(str)));
        return this.pluginLoader.xj(str);
    }

    public void registerPlugin(String str) {
        Plugin parsePlugins;
        if (str == null || (parsePlugins = parsePlugins(str)) == null) {
            return;
        }
        this.mPlugins.put(parsePlugins.mPkgName, parsePlugins);
    }

    public void setAllowDownloadPlugin(String str, int i, boolean z) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + str + " " + i + " " + z);
        if (getPlugin(str) != null) {
            g.xj().xj(str, i, !z);
        }
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new hf(str, file).xj();
    }

    public void tryOfflineInternalPlugin(String str, int i) {
        Plugin plugin = getPlugin(str);
        if (plugin == null || plugin.getInternalVersionCode() != i) {
            return;
        }
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i + " apiVer:" + plugin.getApiVersionCode());
        g.xj().kd(str, plugin.getApiVersionCode());
    }

    public void unInstallPackage(String str) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            g.xj().c(str);
        }
    }

    private Plugin parsePlugins(JSONObject jSONObject) {
        Plugin plugin;
        if (jSONObject.has("isDexPlugin") && jSONObject.optInt("isDexPlugin") == 1) {
            plugin = new xj(jSONObject);
        } else {
            plugin = new Plugin(jSONObject);
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + plugin.mPkgName);
        return plugin;
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }
}
