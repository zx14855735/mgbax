package com.bytedance.sdk.component.adexpress.xj.hf;

import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private static com.bytedance.sdk.component.adexpress.xj.w.xj xj;

    public static synchronized com.bytedance.sdk.component.adexpress.xj.w.xj hf() {
        com.bytedance.sdk.component.adexpress.xj.w.xj xjVar;
        synchronized (f.class) {
            xjVar = xj;
        }
        return xjVar;
    }

    public static void u() {
        w.hf(kd.c(), hf(), "temp_pkg_info.json");
        xj = null;
    }

    public static void w() {
        w.xj(kd.c(), hf(), "temp_pkg_info.json");
    }

    public static void xj() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(kd.c(), "temp_pkg_info.json");
                long length = file.length();
                Long valueOf = Long.valueOf(length);
                if (length > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[valueOf.intValue()];
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        com.bytedance.sdk.component.adexpress.xj.w.xj xj2 = com.bytedance.sdk.component.adexpress.xj.w.xj.xj(new JSONObject(new String(bArr, "utf-8")));
                        if (xj2 != null) {
                            xj = xj2;
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            pl.w("Version", "version init error", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th3;
                        }
                    }
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
    }

    public static boolean hf(com.bytedance.sdk.component.adexpress.xj.w.xj xjVar) {
        return w.w(hf(), xjVar);
    }

    public static synchronized void xj(com.bytedance.sdk.component.adexpress.xj.w.xj xjVar) {
        synchronized (f.class) {
            if (xjVar != null) {
                if (xjVar.y()) {
                    xj = xjVar;
                }
            }
        }
    }

    public static boolean xj(String str) {
        return w.xj(hf(), str);
    }
}
