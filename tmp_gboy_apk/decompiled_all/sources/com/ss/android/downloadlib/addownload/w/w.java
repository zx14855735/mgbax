package com.ss.android.downloadlib.addownload.w;

import ADYaiT.CtFAbx;
import android.content.Context;
import com.baidu.mobads.sdk.internal.bn;
import com.kuaishou.weapon.p0.bi;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {
    public static void hf() {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(pl.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i = 0; i < successedDownloadInfosWithMimeType.size(); i++) {
            DownloadInfo downloadInfo = (DownloadInfo) successedDownloadInfosWithMimeType.get(i);
            if (downloadInfo != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long xj = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("download_complete_file_expire_hours", 0) * bi.s;
                    if (xj <= 0) {
                        xj = bn.d;
                    }
                    if (currentTimeMillis >= xj || g.y(pl.getContext(), str)) {
                        xj(file);
                    }
                }
            }
        }
    }

    public static void xj() {
        List<DownloadInfo> xj = com.ss.android.socialbase.appdownloader.u.p().xj(pl.getContext());
        if (xj == null || xj.size() <= 0) {
            return;
        }
        for (int i = 0; i < xj.size(); i++) {
            DownloadInfo downloadInfo = xj.get(i);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long xj2 = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("download_file_expire_hours", 0) * bi.s;
            if (xj2 <= 0) {
                xj2 = bn.d;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= xj2) {
                xj(file);
                Downloader.getInstance(pl.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void xj(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            xj(externalCacheDir.getPath());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void xj(java.io.File r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            java.lang.String r0 = "1"
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16
            r1.write(r0)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16
            r1.close()     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16
            goto L2b
        L13:
            r3 = move-exception
            r0 = r1
            goto L2f
        L16:
            r0 = move-exception
            goto L1e
        L18:
            r3 = move-exception
            goto L2f
        L1a:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L1e:
            com.bytedance.sdk.component.utils.pl.xj(r0)     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L2b
            r1.close()     // Catch: java.lang.Exception -> L27
            goto L2b
        L27:
            r0 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r0)
        L2b:
            r3.delete()
            return
        L2f:
            if (r0 == 0) goto L39
            r0.close()     // Catch: java.lang.Exception -> L35
            goto L39
        L35:
            r0 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r0)
        L39:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.w.w.xj(java.io.File):void");
    }

    private static void xj(String str) {
        String AlLFFp2;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str2 : list) {
                if (str2 != null) {
                    String str3 = File.separator;
                    if (str.endsWith(str3)) {
                        AlLFFp2 = str.concat(str2);
                    } else {
                        AlLFFp2 = CtFAbx.AlLFFp(str, str3, str2);
                    }
                    File file2 = new File(AlLFFp2);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        xj(AlLFFp2);
                    }
                }
            }
            file.delete();
        }
    }
}
