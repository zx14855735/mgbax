package com.ss.android.downloadlib.addownload.u;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p {
    private static p xj;
    private List<d> hf;

    private p() {
        ArrayList arrayList = new ArrayList();
        this.hf = arrayList;
        arrayList.add(new tf());
        this.hf.add(new pl());
        this.hf.add(new y());
        this.hf.add(new xj());
    }

    public static p xj() {
        if (xj == null) {
            synchronized (p.class) {
                try {
                    if (xj == null) {
                        xj = new p();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(com.ss.android.downloadad.api.xj.hf hfVar, int i, f fVar) {
        DownloadInfo hf;
        List<d> list = this.hf;
        if (list != null && list.size() != 0 && hfVar != null) {
            if (!TextUtils.isEmpty(hfVar.gy())) {
                hf = com.ss.android.downloadlib.tf.xj((Context) null).xj(hfVar.gy(), null, true);
            } else {
                hf = com.ss.android.downloadlib.tf.xj((Context) null).hf(hfVar.xj());
            }
            if (hf != null && AdBaseConstants.MIME_APK.equals(hf.getMimeType())) {
                boolean z = com.ss.android.socialbase.downloader.f.xj.xj(hfVar.v()).xj("pause_optimise_switch", 0) == 1;
                for (d dVar : this.hf) {
                    if (z || (dVar instanceof pl)) {
                        if (dVar.xj(hfVar, i, fVar)) {
                            return;
                        }
                    }
                }
                fVar.xj(hfVar);
                return;
            }
            fVar.xj(hfVar);
            return;
        }
        fVar.xj(hfVar);
    }
}
