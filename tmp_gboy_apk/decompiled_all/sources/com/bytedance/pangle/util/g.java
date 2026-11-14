package com.bytedance.pangle.util;

import J3FDQU.A2egSU;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g {
    private static volatile g xj;
    private SharedPreferences hf = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    private g() {
    }

    public static g xj() {
        if (xj == null) {
            synchronized (g.class) {
                try {
                    if (xj == null) {
                        xj = new g();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void am(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String xj2 = y.xj(str);
        SharedPreferences.Editor edit = this.hf.edit();
        edit.remove("ALIAS_LAST_TIME_".concat(String.valueOf(xj2)));
        edit.apply();
    }

    public void c(String str) {
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
        edit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
    }

    public boolean d(String str) {
        return this.hf.getBoolean("UNINSTALL__".concat(String.valueOf(str)), false);
    }

    public void f(String str) {
        SharedPreferences.Editor edit = this.hf.edit();
        edit.remove("UNINSTALL__".concat(String.valueOf(str)));
        edit.apply();
    }

    public List<String> g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.hf.getString("ALIAS_LAST_TIME_".concat(String.valueOf(y.xj(str))), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Arrays.asList(string.split("_"));
    }

    public boolean hf(String str) {
        return !TextUtils.isEmpty(this.hf.getString("HOST_ABI_".concat(String.valueOf(str)), ""));
    }

    public int kd(String str) {
        int i = this.hf.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i);
        return i;
    }

    public String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hf.getString("ALIAS_".concat(String.valueOf(y.xj(str))), "");
    }

    public void pl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String xj2 = y.xj(str);
        SharedPreferences.Editor edit = this.hf.edit();
        edit.remove("ALIAS_".concat(String.valueOf(xj2)));
        edit.apply();
    }

    public String tf(String str) {
        return this.hf.getString("IDENTITY_".concat(String.valueOf(str)), "");
    }

    public void u(String str) {
        String string = this.hf.getString("HOST_ABI_".concat(String.valueOf(str)), "");
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putString("HOST_ABI_".concat(String.valueOf(str)), Zeus.getHostAbi());
        edit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
    }

    public boolean w(String str) {
        boolean z = !TextUtils.equals(this.hf.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + this.hf.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
        return z;
    }

    public String y(String str) {
        String string = this.hf.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public int d(String str, int i) {
        return this.hf.getInt("remove_entry_flag_" + str + "_" + i, 0);
    }

    public int hf(String str, int i) {
        return this.hf.getInt("API_MIN_" + str + "_" + i, 0);
    }

    public void hf(String str, String str2) {
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putString("IDENTITY_".concat(String.valueOf(str)), str2);
        edit.apply();
    }

    public void kd(String str, int i) {
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), i);
        edit.apply();
    }

    public int w(String str, int i) {
        int i2 = this.hf.getInt("API_MAX_" + str + "_" + i, Integer.MAX_VALUE);
        if (i2 == 0) {
            return Integer.MAX_VALUE;
        }
        return i2;
    }

    public boolean y(String str, int i) {
        SharedPreferences sharedPreferences = this.hf;
        Locale.getDefault();
        StringBuilder sb = new StringBuilder("OFFLINE_INTERNAL_");
        sb.append(str);
        return sharedPreferences.getInt(sb.toString(), -1) == i;
    }

    public boolean f(String str, int i) {
        return this.hf.getBoolean("dex_remove_state_" + str + "_" + i, false);
    }

    public void w(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putBoolean("dex_opt_state_" + str + "_" + i, z);
        edit.apply();
    }

    public boolean c(String str, int i) {
        return this.hf.getBoolean("dex_opt_state_" + str + "_" + i, false);
    }

    public void hf(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.hf.edit();
        String str2 = "INSTALLED_" + str + "-" + i;
        if (z) {
            edit.putBoolean(str2, true);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    public boolean u(String str, int i) {
        return this.hf.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i)), false);
    }

    public void u(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putBoolean("dex_remove_state_" + str + "_" + i, z);
        edit.apply();
    }

    public void xj(String str) {
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putString("ROM_LAST_".concat(String.valueOf(str)), Build.VERSION.INCREMENTAL);
        edit.apply();
    }

    public void w(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String xj2 = y.xj(str);
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putString("ALIAS_".concat(String.valueOf(xj2)), str2);
        edit.apply();
    }

    public void xj(String str, int i) {
        int kd = kd(str);
        if (kd != i) {
            SharedPreferences.Editor edit = this.hf.edit();
            edit.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), i);
            edit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + kd + " --> " + i);
    }

    public int hf(String str, int i, String str2) {
        return this.hf.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, 0);
    }

    public void u(String str, String str2) {
        SharedPreferences.Editor edit = this.hf.edit();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String xj2 = y.xj(str);
        String string = this.hf.getString("ALIAS_LAST_TIME_".concat(String.valueOf(xj2)), "");
        if (TextUtils.isEmpty(string)) {
            edit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(xj2)), str2);
        } else {
            edit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(xj2)), string + "_" + str2);
        }
        edit.apply();
    }

    public void xj(String str, String str2) {
        String y = y(str);
        if (!TextUtils.equals(y, str2)) {
            SharedPreferences.Editor edit = this.hf.edit();
            edit.putString("HOST_IDENTITY_".concat(String.valueOf(str)), str2);
            edit.apply();
        }
        StringBuilder BChYOn2 = A2egSU.BChYOn("ZeusSpUtils setHostIdentity(", str, ") ", y, " --> ");
        BChYOn2.append(str2);
        ZeusLogger.i(ZeusLogger.TAG_INIT, BChYOn2.toString());
    }

    public void xj(String str, int i, int i2, int i3) {
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putInt("API_MIN_" + str + "_" + i, i2);
        edit.putInt("API_MAX_" + str + "_" + i, i3);
        edit.apply();
    }

    public void xj(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.hf.edit();
        String str2 = "DISABLE_DOWNLOAD_" + str + "_" + i;
        if (z) {
            edit.putInt(str2, 0);
        } else {
            edit.remove(str2);
        }
        edit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i + " disable=" + z);
    }

    public void xj(String str, int i, int i2) {
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putInt("remove_entry_flag_" + str + "_" + i, i2);
        edit.apply();
    }

    public void xj(String str, int i, String str2) {
        int hf = hf(str, i, str2);
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, hf + 1);
        edit.apply();
    }
}
