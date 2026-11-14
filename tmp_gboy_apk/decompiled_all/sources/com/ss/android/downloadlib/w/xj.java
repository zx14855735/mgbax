package com.ss.android.downloadlib.w;

import ADYaiT.CtFAbx;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.fl.saas.base.cache.DatabaseHelper;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements g {
    private boolean w(DownloadInfo downloadInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(downloadInfo.getSavePath());
        String str = File.separator;
        sb.append(str);
        sb.append(downloadInfo.getName());
        String sb2 = sb.toString();
        File file = new File(sb2);
        String xj = com.ss.android.socialbase.appdownloader.y.xj.kd.xj(pl.getContext(), com.ss.android.socialbase.appdownloader.w.xj(downloadInfo, file), sb2);
        boolean z = false;
        if (!TextUtils.isEmpty(xj)) {
            String AcNBzu2 = CtFAbx.AcNBzu(xj, ".apk");
            if (AcNBzu2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                z = file.renameTo(new File(downloadInfo.getSavePath() + str + AcNBzu2));
                if (!z) {
                    return z;
                }
                downloadInfo.setName(AcNBzu2);
                return z;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.depend.g
    public boolean hf(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.c.kd.hf(com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()));
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.g
    public void xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !w(downloadInfo)) {
            return;
        }
        xj(pl.getContext(), downloadInfo);
    }

    private void xj(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{DatabaseHelper.COLUMN_ID}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), query.getInt(query.getColumnIndex(DatabaseHelper.COLUMN_ID))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{AdBaseConstants.MIME_APK}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.w.xj.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        com.ss.android.socialbase.downloader.downloader.w.et().xj(downloadInfo);
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.tf.y.xj(query);
    }
}
