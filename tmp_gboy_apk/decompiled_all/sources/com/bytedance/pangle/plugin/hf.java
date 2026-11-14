package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.u.hf;
import com.bytedance.pangle.util.c;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class hf implements Runnable {
    private final String hf;
    private File xj;

    public hf(String str, File file) {
        this.xj = file;
        this.hf = str;
    }

    private void hf() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.xj.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                c.hf(this.xj.getAbsolutePath(), file.getAbsolutePath());
                File[] listFiles = file.listFiles();
                File file2 = this.xj;
                if (listFiles != null && listFiles.length > 0) {
                    file2 = listFiles[0];
                }
                File xj = xj(file2);
                if (xj != null && xj.exists() && xj.isFile()) {
                    this.xj = xj;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                y.xj(e);
            }
        }
    }

    private com.bytedance.pangle.c.xj.kd w() {
        com.bytedance.pangle.w.xj xj;
        if (this.xj == null) {
            return null;
        }
        try {
            File file = new File(this.xj.getAbsolutePath() + "_unzip");
            if (file.exists()) {
                c.xj(file);
                file.mkdirs();
            }
            c.hf(this.xj.getAbsolutePath(), file.getAbsolutePath());
            File[] listFiles = file.listFiles();
            LinkedList linkedList = new LinkedList();
            File file2 = null;
            for (File file3 : listFiles) {
                if (file3.getName().equals("config.json")) {
                    file2 = file3;
                } else if (file3.getName().endsWith(".dex")) {
                    linkedList.add(file3);
                }
            }
            c.xj(this.xj);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable Dex deleting downloadFile apkFile=" + this.xj);
            this.xj = file;
            if (linkedList.size() > 0 && file2 != null && file2.isFile() && (xj = com.bytedance.pangle.w.hf.xj(file2, linkedList)) != null) {
                return new com.bytedance.pangle.c.xj.kd(xj);
            }
        } catch (Exception e) {
            y.xj(e);
        }
        return null;
    }

    private File xj(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] listFiles = new File(file.getParent()).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.exists() && file2.getName().endsWith(".apk")) {
                return file2;
            }
        }
        return file;
    }

    @Override // java.lang.Runnable
    public void run() {
        xj();
    }

    private static void xj(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.hf.xj(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.hf.xj(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.hf.xj(Integer.valueOf(i2)));
            jSONObject3.putOpt(MediationConstant.EXTRA_DURATION, Integer.valueOf(com.bytedance.pangle.log.hf.hf(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.hf.xj(str3));
        } catch (JSONException e) {
            y.xj(e);
        }
        com.bytedance.pangle.u.hf.xj().xj(str, jSONObject, jSONObject3, jSONObject2);
    }

    public boolean xj() {
        com.bytedance.pangle.c.xj.kd xj;
        File file = this.xj;
        if (file != null && file.getName().endsWith(".dex.zip")) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ZeusLogger.d("Plugin install : start unDexZip file ~~~~");
            xj = w();
            if (xj != null) {
                xj(com.bytedance.pangle.u.hf.c, hf.xj.v, this.hf, 0, SystemClock.elapsedRealtime() - elapsedRealtime, "");
                ZeusLogger.d("Plugin install : finish install from unDexZip success ~~~~");
            } else {
                ZeusLogger.d("Plugin install : finish install from unDexZip fail ~~~~");
            }
        } else {
            if (c.hf(this.xj)) {
                ZeusLogger.d("Plugin install : start unZip file ~~~~");
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                hf();
                xj(com.bytedance.pangle.u.hf.c, hf.xj.l, this.hf, 0, SystemClock.elapsedRealtime() - elapsedRealtime2, "");
                ZeusLogger.d("Plugin install : start install from unZip ~~~~");
            } else {
                ZeusLogger.d("Plugin install : start install without unZip ~~~~");
            }
            xj = com.bytedance.pangle.c.xj.u.xj(this.xj);
        }
        if (xj == null) {
            ZeusPluginStateListener.postStateChange(this.hf, 7, " read local file package info failed !!! pluginPkg = " + this.hf + " mApkFile.exists = " + this.xj.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.hf);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(xj.xj);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.hf, 7, " plugin == null !!! pluginPkg = " + this.hf);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + xj.xj);
            return false;
        }
        boolean install = plugin.install(this.xj, xj);
        if (install) {
            ZeusPluginStateListener.postStateChange(xj.xj, 6, new Object[0]);
            return install;
        }
        ZeusPluginStateListener.postStateChange(xj.xj, 7, "Internal error.");
        return install;
    }
}
