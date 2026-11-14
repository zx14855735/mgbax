package com.sigmob.sdk.base.services;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.czhj.sdk.common.utils.FileUtil;
import com.sigmob.sdk.base.common.q;
import com.sigmob.sdk.base.utils.k;
import com.sigmob.sdk.base.utils.o;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class c extends BroadcastReceiver {
    public DownloadManager a(Context context) {
        return (DownloadManager) context.getSystemService("download");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        File file = new File(k.g(), longExtra + ".log");
        Object readFromCache = FileUtil.readFromCache(file.getAbsolutePath());
        q.b(longExtra, "");
        FileUtil.deleteFile(file.getAbsolutePath());
        if (o.a((CharSequence) intent.getAction(), (CharSequence) "android.intent.action.DOWNLOAD_COMPLETE")) {
            a(context, longExtra, readFromCache);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0019, code lost:
    
        if (r6 != null) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.content.Context r21, long r22, java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.c.a(android.content.Context, long, java.lang.Object):void");
    }
}
