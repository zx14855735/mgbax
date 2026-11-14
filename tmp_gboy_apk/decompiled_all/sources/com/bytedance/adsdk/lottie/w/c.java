package com.bytedance.adsdk.lottie.w;

import ADYaiT.CtFAbx;
import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private final kd xj;

    public c(kd kdVar) {
        this.xj = kdVar;
    }

    private File hf(String str) {
        File file = new File(xj(), xj(str, w.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(xj(), xj(str, w.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    @WorkerThread
    public Pair<w, InputStream> xj(String str) {
        try {
            File hf = hf(str);
            if (hf == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(hf);
            w wVar = hf.getAbsolutePath().endsWith(".zip") ? w.ZIP : w.JSON;
            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Cache hit for ", str, " at ");
            B3GDIM2.append(hf.getAbsolutePath());
            com.bytedance.adsdk.lottie.kd.kd.xj(B3GDIM2.toString());
            return new Pair<>(wVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public File xj(String str, InputStream inputStream, w wVar) {
        File file = new File(xj(), xj(str, wVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }

    public void xj(String str, w wVar) {
        File file = new File(xj(), xj(str, wVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        com.bytedance.adsdk.lottie.kd.kd.xj("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        com.bytedance.adsdk.lottie.kd.kd.hf("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private File xj() {
        File xj = this.xj.xj();
        if (xj.isFile()) {
            xj.delete();
        }
        if (!xj.exists()) {
            xj.mkdirs();
        }
        return xj;
    }

    private static String xj(String str, w wVar, boolean z) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? wVar.xj() : wVar.w);
        return sb.toString();
    }
}
