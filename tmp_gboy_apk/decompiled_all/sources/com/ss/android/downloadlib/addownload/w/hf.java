package com.ss.android.downloadlib.addownload.w;

import com.ss.android.downloadlib.addownload.hf.d;
import com.ss.android.downloadlib.addownload.hf.y;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements Runnable {
    private DownloadInfo xj;

    public hf(DownloadInfo downloadInfo) {
        this.xj = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.downloadad.api.xj.hf xj;
        if (this.xj == null || (xj = y.xj().xj(this.xj)) == null) {
            return;
        }
        com.ss.android.downloadlib.u.xj.xj().xj("cleanspace_task", xj);
        long longValue = Double.valueOf((com.ss.android.downloadlib.c.kd.xj(this.xj.getId()) + 1.0d) * this.xj.getTotalBytes()).longValue() - this.xj.getCurBytes();
        long hf = g.hf(0L);
        if (pl.g() != null) {
            pl.g();
        }
        w.xj();
        w.hf();
        if (com.ss.android.downloadlib.c.kd.c(xj.v())) {
            w.xj(pl.getContext());
        }
        long hf2 = g.hf(0L);
        if (hf2 >= longValue) {
            xj.pl("1");
            d.xj().xj(xj);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(hf2 - hf));
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            com.ss.android.downloadlib.u.xj.xj().xj("cleanspace_download_after_quite_clean", jSONObject, xj);
            Downloader.getInstance(pl.getContext()).restart(this.xj.getId());
            return;
        }
        if (pl.g() != null) {
            xj.u(false);
            u.xj().xj(xj.xj(), new kd() { // from class: com.ss.android.downloadlib.addownload.w.hf.1
            });
            if (pl.g().xj(this.xj.getId(), this.xj.getUrl(), true, longValue)) {
                xj.kd(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("cleanspace_window_show", jSONObject2, xj);
    }
}
