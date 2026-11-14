package com.bytedance.pangle.kd;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.d;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.io.FileFilter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static File hf;
    private static File w;
    private static File xj;

    public static String c(String str, int i) {
        return new File(xj(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String d(String str, int i) {
        return xj(str, "version-".concat(String.valueOf(i)), "secondary-dexes");
    }

    public static String f(String str, int i) {
        return d.am() ? xj(str, "version-".concat(String.valueOf(i)), "apk", "temp", "oat", com.bytedance.pangle.y.hf.xj()) : xj(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String hf() {
        Application appApplication = Zeus.getAppApplication();
        if (hf == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + com.bytedance.pangle.d.hf);
            }
            hf = downloadDir;
        }
        return xj(hf);
    }

    private static void kd() {
        if (xj == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + com.bytedance.pangle.d.w);
            xj = file;
            xj(file);
        }
    }

    public static File[] p(String str, int i) {
        String xj2 = xj(str, "version-".concat(String.valueOf(i)), "dex");
        if (TextUtils.isEmpty(xj2)) {
            return null;
        }
        return new File(xj2).listFiles(new FileFilter() { // from class: com.bytedance.pangle.kd.w.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".dex");
            }
        });
    }

    public static String pl(String str, int i) {
        return new File(xj(str, "version-".concat(String.valueOf(i)), "config"), "config.json").getPath();
    }

    public static boolean tf(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(xj());
        String str2 = File.separator;
        A2egSU.BIYEnU(sb, str2, str, str2, "version-");
        sb.append(i);
        return A2egSU.BPw6Q8(sb.toString());
    }

    public static String u() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + com.bytedance.pangle.d.hf);
            if (externalFilesDir != null) {
                return xj(externalFilesDir);
            }
            return null;
        } catch (Exception e) {
            y.xj(e);
            return null;
        }
    }

    public static String w() {
        Application appApplication = Zeus.getAppApplication();
        if (w == null) {
            w = new File(appApplication.getFilesDir(), ".pangle" + com.bytedance.pangle.d.xj);
        }
        return xj(w);
    }

    public static String xj(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String y(String str, int i) {
        return new File(xj(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static String kd(String str, int i) {
        return new File(xj(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    private static String xj(String... strArr) {
        kd();
        File file = xj;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return xj(file);
    }

    public static String w(String str, int i) {
        if (d.am()) {
            return xj(str, "version-".concat(String.valueOf(i)), "apk", "oat", com.bytedance.pangle.y.hf.xj());
        }
        return xj(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String u(String str, int i) {
        return xj(str, "version-".concat(String.valueOf(i)), "lib");
    }

    public static String hf(String str, int i) {
        return new File(xj(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String xj() {
        kd();
        return xj.getPath();
    }

    public static String xj(String str, int i) {
        kd();
        File file = xj;
        String[] strArr = {str, "version-".concat(String.valueOf(i))};
        for (int i2 = 0; i2 < 2; i2++) {
            String str2 = strArr[i2];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String xj(String str) {
        return xj(str);
    }

    public static String xj(String str, int i, String str2) {
        return new File(xj(str, "version-".concat(String.valueOf(i)), "dex"), str2).getPath();
    }
}
