package com.bytedance.pangle.y;

import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static boolean xj(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = exec.getErrorStream();
            InputStream inputStream = exec.getInputStream();
            xj(errorStream);
            xj(inputStream);
            if (exec.waitFor() == 0) {
                return true;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
            return false;
        } catch (IOException e) {
            com.bytedance.sdk.openadsdk.api.y.xj(e);
            return false;
        } catch (InterruptedException e2) {
            com.bytedance.sdk.openadsdk.api.y.xj(e2);
            return false;
        }
    }

    private static void xj(final InputStream inputStream) {
        com.bytedance.pangle.kd.kd.hf(new Runnable() { // from class: com.bytedance.pangle.y.xj.1
            @Override // java.lang.Runnable
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        } else {
                            ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(readLine));
                        }
                    } catch (IOException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e)));
                        return;
                    } finally {
                        com.bytedance.pangle.util.c.xj(bufferedReader);
                    }
                }
            }
        });
    }
}
