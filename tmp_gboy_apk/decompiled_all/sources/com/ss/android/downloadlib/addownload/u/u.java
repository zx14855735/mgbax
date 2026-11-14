package com.ss.android.downloadlib.addownload.u;

import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private static u xj;
    private List<c> hf;

    private u() {
        ArrayList arrayList = new ArrayList();
        this.hf = arrayList;
        arrayList.add(new kd());
        this.hf.add(new hf());
        this.hf.add(new w());
    }

    public static u xj() {
        if (xj == null) {
            synchronized (p.class) {
                try {
                    if (xj == null) {
                        xj = new u();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(com.ss.android.downloadad.api.xj.hf hfVar, int i, f fVar, com.ss.android.downloadlib.addownload.xj.w wVar) {
        DownloadInfo hf;
        List<c> list = this.hf;
        if (list == null || list.size() == 0 || hfVar == null) {
            fVar.xj(hfVar);
        }
        if (!TextUtils.isEmpty(hfVar.gy())) {
            hf = com.ss.android.downloadlib.tf.xj(com.ss.android.downloadlib.addownload.pl.getContext()).xj(hfVar.gy(), null, true);
        } else {
            hf = com.ss.android.downloadlib.tf.xj(com.ss.android.downloadlib.addownload.pl.getContext()).hf(hfVar.xj());
        }
        if (hf == null) {
            hf = Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).getDownloadInfo(hfVar.v());
        }
        if (hf != null && AdBaseConstants.MIME_APK.equals(hf.getMimeType())) {
            if (new tf().xj(hfVar, i, fVar)) {
                return;
            }
            Iterator<c> it = this.hf.iterator();
            while (it.hasNext()) {
                if (it.next().xj(hfVar, i, fVar, wVar)) {
                    return;
                }
            }
            fVar.xj(hfVar);
            return;
        }
        fVar.xj(hfVar);
    }
}
