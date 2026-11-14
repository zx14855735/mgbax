package com.bytedance.pangle.y;

import B4ZgIw.AYUAbz;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.y.y;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements y.xj {
    @Override // com.bytedance.pangle.y.y.xj
    public boolean xj(String str, int i) {
        String xj = c.xj(str, i);
        String w = com.bytedance.pangle.kd.w.w(str, i);
        String[] split = xj.split(":");
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(xj));
        long currentTimeMillis = System.currentTimeMillis();
        int length = split.length;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 >= length) {
                z = z2;
                break;
            }
            String str2 = split[i2];
            StringBuilder A4TApA2 = AYUAbz.A4TApA(w);
            A4TApA2.append(File.separator);
            A4TApA2.append(hf.xj(str2));
            if (!xj(str2, A4TApA2.toString())) {
                break;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
            i2++;
            z2 = true;
        }
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - currentTimeMillis) + " result:" + z);
        return z;
    }

    private boolean xj(String str, String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
