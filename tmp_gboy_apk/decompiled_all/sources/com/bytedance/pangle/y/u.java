package com.bytedance.pangle.y;

import B4ZgIw.AYUAbz;
import android.os.Build;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.y.y;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements y.xj {
    private static boolean hf(String str, String str2) {
        try {
            return xj.xj(hf.xj(str, str2, hf.hf));
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.y.y.xj
    public boolean xj(String str, int i) {
        String hf = com.bytedance.pangle.kd.w.hf(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(hf)));
        String w = com.bytedance.pangle.kd.w.w(str, i);
        StringBuilder A4TApA2 = AYUAbz.A4TApA(w);
        String str2 = File.separator;
        A4TApA2.append(str2);
        A4TApA2.append("compFully");
        A4TApA2.append(hf.hf(hf));
        String sb = A4TApA2.toString();
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(w, str2);
        A5SV6n2.append(hf.xj(hf));
        String sb2 = A5SV6n2.toString();
        if (!hf(hf, sb)) {
            return false;
        }
        xj(sb, sb2);
        boolean xj = hf.xj(sb2);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(xj)));
        return xj;
    }

    private void xj(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
        }
        String str3 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        File file2 = new File(str.replace(str3, ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str2.replace(str3, ".vdex")));
        }
    }
}
