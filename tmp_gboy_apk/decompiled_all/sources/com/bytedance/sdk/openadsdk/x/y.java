package com.bytedance.sdk.openadsdk.x;

import ADYaiT.CtFAbx;
import android.content.Context;
import com.baidu.mobads.sdk.internal.br;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.v;
import com.kwad.sdk.collector.AppStatusRules;
import com.sigmob.sdk.downloader.f;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private static Method hf;
    private static boolean w = xj().exists();
    private static Boolean xj;

    static {
        CUOodbl();
    }

    private static /* synthetic */ void CUOodbl() {
        char[] charArray = "\f\u0000\u0002A\b\u000e\u0002\nA\r\u0000\u0016A\u001c\u0007\n\u0003\u0003A%\u0001\u0006-\u001d\u0006\u000b\b\n".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'o');
        }
        String str = new String(charArray);
        char[] charArray2 = "\f\u0003\u0006\u0001\u0006\u001b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'o');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static boolean hf(String str) {
        try {
            if (hf == null) {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class);
                hf = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) y.class.getClassLoader();
            if (hf != null && baseDexClassLoader != null) {
                String findLibrary = baseDexClassLoader.findLibrary(str);
                synchronized (y.class) {
                    hf.invoke(null, findLibrary, baseDexClassLoader);
                }
                return true;
            }
        } catch (Throwable th) {
            w = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("lib", str);
                jSONObject.putOpt(br.c, "lock load failed!");
            } catch (JSONException unused) {
            }
            am.xj().xj("so_load_fail", jSONObject, th);
        }
        return false;
    }

    public static File xj() {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(pz.getContext()), ".csj_so");
    }

    public static void xj(String str) {
        try {
            if (w && hf(str)) {
                return;
            }
            System.loadLibrary(str);
        } catch (Throwable th) {
            xj(str, th);
        }
    }

    private static boolean xj(String str, Throwable th) {
        String y = ai.y();
        String BI9f7h2 = CtFAbx.BI9f7h("lib", str, ".so");
        File file = new File(y, "/lib/".concat(String.valueOf(BI9f7h2)));
        if (file.exists() && file.length() > 0) {
            return xj(str, file.getAbsolutePath());
        }
        File file2 = new File(y, "apk/base-1.apk");
        if (file2.exists() && file2.length() > 0) {
            xj(file2, file, BI9f7h2);
            File file3 = new File(y, "/lib/".concat(String.valueOf(BI9f7h2)));
            if (file3.exists() && file3.length() > 0) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable unused) {
                    return xj(str, file3.getAbsolutePath());
                }
            }
            xj(str, CtFAbx.AcNBzu(BI9f7h2, " unzip failed !"), th);
            return false;
        }
        xj(str, "load so filed! apk not exist! ", th);
        return false;
    }

    public static boolean hf() {
        Boolean bool = xj;
        if (bool != null) {
            return bool.booleanValue();
        }
        xj = Boolean.FALSE;
        try {
            Context context = pz.getContext();
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), f.a.d).applicationInfo.flags & 1) != 0) {
                xj = Boolean.TRUE;
            }
        } catch (Exception e) {
            pl.hf("SoLoaderUtil", e);
        }
        return xj.booleanValue();
    }

    private static boolean xj(String str, String str2) {
        try {
            System.load(str2);
            return true;
        } catch (Throwable th) {
            new File(str2).delete();
            xj(str, "load so " + str + " filed! ", th);
            throw th;
        }
    }

    private static void xj(File file, File file2, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("lib/" + com.bytedance.sdk.openadsdk.core.ai.hf.hf.xj() + "/" + str);
            if (entry == null) {
                entry = zipFile.getEntry("lib/armeabi/".concat(String.valueOf(str)));
            }
            if (entry == null) {
                return;
            }
            file2.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                    }
                    try {
                        byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                bufferedOutputStream.write(bArr, 0, read);
                            } else {
                                com.bytedance.sdk.component.y.w.w.hf.xj(bufferedInputStream);
                                com.bytedance.sdk.component.y.w.w.hf.xj(bufferedOutputStream);
                                com.bytedance.sdk.component.y.w.w.hf.xj(fileOutputStream);
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        com.bytedance.sdk.component.y.w.w.hf.xj(bufferedInputStream);
                        com.bytedance.sdk.component.y.w.w.hf.xj(bufferedOutputStream);
                        com.bytedance.sdk.component.y.w.w.hf.xj(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    bufferedInputStream = null;
                    th = th4;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th5) {
                bufferedInputStream = null;
                fileOutputStream = null;
                th = th5;
                bufferedOutputStream = null;
            }
        } catch (Throwable th6) {
            pl.hf("SoLoaderUtil", th6);
        }
    }

    private static void xj(String str, String str2, Throwable th) {
        if ("maparmor".equals(str)) {
            v.xj = false;
        }
        if (hf()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.putOpt(br.c, str2);
        } catch (JSONException unused) {
        }
        am.xj().xj("so_load_fail", jSONObject, th);
    }
}
