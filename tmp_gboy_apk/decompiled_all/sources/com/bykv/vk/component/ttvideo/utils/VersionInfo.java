package com.bykv.vk.component.ttvideo.utils;

import android.os.Build;
import com.bytedance.sdk.component.utils.pl;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class VersionInfo {
    private static String[] mVersion;

    public static String[] getVersion() {
        FileReader fileReader;
        if (mVersion == null) {
            String[] strArr = {"null", "null", "null", "null"};
            BufferedReader bufferedReader = null;
            try {
                try {
                    fileReader = new FileReader("/proc/version");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                        try {
                            strArr[0] = bufferedReader2.readLine().split("\\s+")[2];
                            try {
                                bufferedReader2.close();
                                fileReader.close();
                            } catch (Throwable th) {
                                try {
                                    pl.xj(th);
                                    fileReader.close();
                                } finally {
                                    try {
                                        fileReader.close();
                                    } catch (Throwable th2) {
                                        pl.xj(th2);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th3) {
                                    try {
                                        pl.xj(th3);
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                    } catch (Throwable th4) {
                                        if (fileReader != null) {
                                        }
                                        throw th4;
                                    }
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            strArr[1] = Build.VERSION.RELEASE;
                            strArr[2] = Build.MODEL;
                            strArr[3] = Build.DISPLAY;
                            mVersion = strArr;
                            return mVersion;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    fileReader = null;
                }
            } catch (Throwable th5) {
                pl.xj(th5);
            }
            strArr[1] = Build.VERSION.RELEASE;
            strArr[2] = Build.MODEL;
            strArr[3] = Build.DISPLAY;
            mVersion = strArr;
        }
        return mVersion;
    }
}
