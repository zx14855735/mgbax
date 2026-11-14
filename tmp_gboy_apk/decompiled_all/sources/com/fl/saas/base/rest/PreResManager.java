package com.fl.saas.base.rest;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.http.HttpCallbackBytesListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.FileHelper;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.MD5Utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PreResManager {
    public static final String RAIN_CACHE = "RainRed";
    private static final String SDK_CACHE_DIR = "saas_cache";

    public static List<String> getDirInAllFilePath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        File file = new File(context.getCacheDir(), CtFAbx.B25kr6(new StringBuilder(SDK_CACHE_DIR), File.separator, str));
        return (file.exists() && file.isDirectory()) ? FileHelper.getFileNamesInDirectory(file) : new ArrayList();
    }

    private static void handleDown(final String str, final String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        AdHttpUtils.getInstance().doGet(str2, new HttpCallbackBytesListener() { // from class: com.fl.saas.base.rest.PreResManager.1
            @Override // com.fl.saas.config.http.HttpCallbackBytesListener
            public void onError(Exception exc) {
                LogcatUtil.d(String.format(Locale.CHINA, "PreResManager, onFailure, code:%d, msg:%s, url:%s", Integer.valueOf(ErrorCodeConstant.RENDER_ERROR), exc.getMessage(), str2));
            }

            @Override // com.fl.saas.config.http.HttpCallbackBytesListener
            public void onSuccess(byte[] bArr) {
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        File file = new File(str + File.separator + MD5Utils.getMD5(str2));
                        if (file.exists()) {
                            if (file.isDirectory()) {
                                FileHelper.deleteAllFilesInDirectory(file);
                            } else {
                                file.delete();
                            }
                        }
                        file.createNewFile();
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int read = byteArrayInputStream.read(bArr2);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr2, 0, read);
                                    }
                                }
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        byteArrayInputStream.close();
                    } finally {
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        });
    }

    public static void handleDownload(String str, List<String> list) {
        Context context = DeviceUtil.getContext();
        if (context == null) {
            return;
        }
        File cacheDir = context.getCacheDir();
        String path = cacheDir.getPath();
        String B25kr62 = CtFAbx.B25kr6(new StringBuilder(SDK_CACHE_DIR), File.separator, str);
        File file = new File(cacheDir, B25kr62);
        if (list == null || list.isEmpty()) {
            if (file.exists() && file.isDirectory()) {
                FileHelper.deleteAllFilesInDirectory(file);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : list) {
            hashMap.put(MD5Utils.getMD5(str2), str2);
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (hashMap.containsKey(name)) {
                            hashMap.remove(name);
                        } else {
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                try {
                    file.delete();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (hashMap.isEmpty()) {
            return;
        }
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (file.exists()) {
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                handleDown(CtFAbx.B25kr6(AYUAbz.A4TApA(path), File.separator, B25kr62), (String) it.next());
            }
        }
    }

    public static boolean isRainRedCacheEmpty() {
        List<String> dirInAllFilePath;
        Context context = DeviceUtil.getContext();
        return context == null || (dirInAllFilePath = getDirInAllFilePath(context, RAIN_CACHE)) == null || dirInAllFilePath.size() <= 4;
    }
}
