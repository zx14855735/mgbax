package com.ss.android.downloadlib.y;

import com.ss.android.socialbase.appdownloader.w.p;
import com.ss.android.socialbase.appdownloader.w.tf;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w implements p {
    private static volatile w xj;
    private List<p> hf;

    private w() {
        ArrayList arrayList = new ArrayList();
        this.hf = arrayList;
        arrayList.add(new hf());
        this.hf.add(new xj());
    }

    public static w xj() {
        if (xj == null) {
            synchronized (w.class) {
                try {
                    if (xj == null) {
                        xj = new w();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.ss.android.socialbase.appdownloader.w.p
    public void xj(DownloadInfo downloadInfo, tf tfVar) {
        if (downloadInfo != null && this.hf.size() != 0) {
            xj(downloadInfo, 0, tfVar);
        } else if (tfVar != null) {
            tfVar.xj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final DownloadInfo downloadInfo, final int i, final tf tfVar) {
        if (i != this.hf.size() && i >= 0) {
            this.hf.get(i).xj(downloadInfo, new tf() { // from class: com.ss.android.downloadlib.y.w.1
                @Override // com.ss.android.socialbase.appdownloader.w.tf
                public void xj() {
                    w.this.xj(downloadInfo, i + 1, tfVar);
                }
            });
        } else {
            tfVar.xj();
        }
    }
}
