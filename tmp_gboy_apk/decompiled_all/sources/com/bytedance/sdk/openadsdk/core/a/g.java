package com.bytedance.sdk.openadsdk.core.a;

import com.sigmob.sdk.downloader.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class g {
    /* JADX WARN: Finally extract failed */
    public static String hf(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[f.a.c];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
            try {
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.pl.xj(th2);
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            try {
                com.bytedance.sdk.component.utils.pl.u("gzip compress error.", th.getMessage());
                try {
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    if (gZIPInputStream == null) {
                        return null;
                    }
                    gZIPInputStream.close();
                    return null;
                } catch (Throwable th4) {
                    com.bytedance.sdk.component.utils.pl.xj(th4);
                    return null;
                }
            } catch (Throwable th5) {
                try {
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                } catch (Throwable th6) {
                    com.bytedance.sdk.component.utils.pl.xj(th6);
                }
                throw th5;
            }
        }
    }

    public static byte[] xj(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr3 = new byte[f.a.c];
            while (true) {
                int read = byteArrayInputStream.read(bArr3, 0, f.a.c);
                if (read <= 0) {
                    gZIPOutputStream.close();
                    byteArrayInputStream.close();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return bArr2;
                }
                gZIPOutputStream.write(bArr3, 0, read);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return bArr2;
        }
    }
}
