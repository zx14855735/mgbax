package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import com.sigmob.sdk.downloader.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class i0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        InputStream inputStream;
        int i = 0;
        Context context = pblv.f14062A4TApA.f14063A2egSU;
        String str2 = pblf.f14040A2egSU;
        int i2 = 255;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(hf.xj(context).getAbsolutePath());
            sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "661864", new byte[]{104}));
            String str3 = pblf.f14040A2egSU;
            sb.append(str3);
            String sb2 = sb.toString();
            File file = new File(sb2);
            if (file.exists()) {
                i2 = 2;
                file.delete();
            }
            inputStream = context.getResources().getAssets().open(str3);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[f.a.c];
                    while (true) {
                        int read = inputStream.read(bArr, 0, f.a.c);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(sb2);
                    fileOutputStream.write(byteArrayOutputStream2.toByteArray());
                    fileOutputStream.close();
                    if (byteArrayOutputStream2.size() <= 0) {
                        i = 3;
                    } else if (!new File(sb2).exists()) {
                        i = i2;
                    }
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                    }
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "db1183", new byte[]{116, 99, 125, 66});
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        i = i2;
                        return Integer.valueOf(i);
                    } finally {
                    }
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            inputStream = null;
        }
        return Integer.valueOf(i);
    }
}
