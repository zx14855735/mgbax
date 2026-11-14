package com.bytedance.sdk.component.c.w;

import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements com.bytedance.sdk.component.c.hf, com.bytedance.sdk.component.c.xj {
    private static Method hf;
    private static boolean w;
    private static Method xj;
    private final boolean kd;
    private final com.bytedance.sdk.component.u.hf.xj u;

    static {
        try {
            Class<?> cls = Class.forName("com.android.internal.util.XmlUtils");
            xj = cls.getDeclaredMethod("readMapXml", InputStream.class);
            hf = cls.getDeclaredMethod("writeMapXml", Map.class, OutputStream.class);
            xj.setAccessible(true);
            hf.setAccessible(true);
            w = true;
        } catch (Exception unused) {
            w = false;
        }
    }

    public kd(com.bytedance.sdk.component.u.hf.xj xjVar) {
        this.u = xjVar;
        this.kd = false;
    }

    public static boolean xj() {
        return w;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.component.c.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map<java.lang.String, java.lang.Object> xj(java.io.File r7) {
        /*
            r6 = this;
            boolean r0 = com.bytedance.sdk.component.c.w.kd.w
            if (r0 == 0) goto L73
            boolean r0 = r7.exists()
            if (r0 == 0) goto L73
            boolean r0 = r7.canRead()
            r1 = 0
            if (r0 != 0) goto L21
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r0 = "can't read file "
            java.lang.String r7 = r0.concat(r7)
            java.lang.String r0 = "PropReaderWriter"
            com.bytedance.sdk.component.utils.pl.hf(r0, r7)
            return r1
        L21:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r3 = 49152(0xc000, float:6.8877E-41)
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.reflect.Method r2 = com.bytedance.sdk.component.c.w.kd.xj     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r4 = 0
            r3[r4] = r0     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            com.bytedance.sdk.component.c.xj.hf r2 = new com.bytedance.sdk.component.c.xj.hf     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r2.<init>()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            com.bytedance.sdk.component.u.hf.xj r3 = r6.u     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            boolean r4 = r6.kd     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.util.Map r7 = r2.xj(r1, r3, r4)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r0.close()     // Catch: java.io.IOException -> L4c
        L4c:
            return r7
        L4d:
            r7 = move-exception
            r1 = r0
            goto L6d
        L50:
            r1 = move-exception
            goto L58
        L52:
            r7 = move-exception
            goto L6d
        L54:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L58:
            java.lang.String r2 = "XmlReader"
            java.lang.String r3 = "read file exception: "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r7 = r3.concat(r7)     // Catch: java.lang.Throwable -> L4d
            com.bytedance.sdk.component.utils.pl.hf(r2, r7, r1)     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.io.IOException -> L73
            goto L73
        L6d:
            if (r1 == 0) goto L72
            r1.close()     // Catch: java.io.IOException -> L72
        L72:
            throw r7
        L73:
            java.util.Map r7 = java.util.Collections.EMPTY_MAP
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.c.w.kd.xj(java.io.File):java.util.Map");
    }

    public kd(com.bytedance.sdk.component.u.hf.xj xjVar, boolean z) {
        this.u = xjVar;
        this.kd = z;
    }

    @Override // com.bytedance.sdk.component.c.hf
    public void xj(Map<String, Object> map, File file) {
        FileOutputStream fileOutputStream;
        if (!w || file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                hf.invoke(null, new com.bytedance.sdk.component.c.xj.hf().xj(map, this.u, this.kd), fileOutputStream);
                fileOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                pl.hf("XmlReader", "write: to file exception: ".concat(String.valueOf(file)), e);
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
        }
    }
}
