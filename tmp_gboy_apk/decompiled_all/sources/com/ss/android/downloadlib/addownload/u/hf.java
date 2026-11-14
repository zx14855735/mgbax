package com.ss.android.downloadlib.addownload.u;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements c {
    private static com.ss.android.downloadlib.addownload.xj.w hf;
    private static com.ss.android.downloadlib.addownload.xj.u xj;

    public static com.ss.android.downloadlib.addownload.xj.w hf() {
        return hf;
    }

    public static com.ss.android.downloadlib.addownload.xj.u xj() {
        return xj;
    }

    public static void xj(com.ss.android.downloadlib.addownload.xj.w wVar) {
        hf = wVar;
    }

    @Override // com.ss.android.downloadlib.addownload.u.c
    public boolean xj(final com.ss.android.downloadad.api.xj.hf hfVar, int i, final f fVar, final com.ss.android.downloadlib.addownload.xj.w wVar) {
        DownloadInfo hf2;
        if (hfVar == null || !xj(hfVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(hfVar.gy())) {
            hf2 = com.ss.android.downloadlib.tf.xj(com.ss.android.downloadlib.addownload.pl.getContext()).xj(hfVar.gy(), null, true);
        } else {
            hf2 = com.ss.android.downloadlib.tf.xj(com.ss.android.downloadlib.addownload.pl.getContext()).hf(hfVar.xj());
        }
        if (hf2 == null) {
            return false;
        }
        long xj2 = com.ss.android.downloadlib.addownload.tf.xj(hf2.getId(), hf2.getCurBytes(), hf2.getTotalBytes());
        long totalBytes = hf2.getTotalBytes();
        if (xj2 < 0 || totalBytes <= 0 || totalBytes > xj(hfVar.v())) {
            return false;
        }
        final int i2 = (int) (xj2 / BaseConstants.MB_VALUE);
        xj = new com.ss.android.downloadlib.addownload.xj.u() { // from class: com.ss.android.downloadlib.addownload.u.hf.1
            @Override // com.ss.android.downloadlib.addownload.xj.u
            public void hf() {
                com.ss.android.downloadlib.addownload.xj.u unused = hf.xj = null;
                hf.this.xj(i2, i2, hfVar, "apk_size_cancel", "cancel");
                fVar.xj(hfVar);
            }

            @Override // com.ss.android.downloadlib.addownload.xj.u
            public void xj() {
                com.ss.android.downloadlib.addownload.xj.u unused = hf.xj = null;
                hf.this.xj(i2, i2, hfVar, "apk_size_cancel", "confirm");
            }
        };
        String BI9f7h2 = CtFAbx.BI9f7h("该下载任务仅需", g.xj(totalBytes - xj2), "，即将下载完成，是否继续下载？");
        if (wVar != null) {
            xj(new com.ss.android.downloadlib.addownload.xj.w() { // from class: com.ss.android.downloadlib.addownload.u.hf.2
                @Override // com.ss.android.downloadlib.addownload.xj.w
                public void delete() {
                    com.ss.android.downloadlib.addownload.xj.u unused = hf.xj = null;
                    hf.this.xj(i2, i2, hfVar, "apk_size_cancel", "delete");
                    wVar.delete();
                }
            });
        }
        TTDelegateActivity.xj(hfVar, BI9f7h2, "继续", "暂停", "删除");
        return true;
    }

    private int xj(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("cancel_pause_optimise_apk_size", 100) * 1048576;
    }

    private boolean xj(com.ss.android.downloadad.api.xj.xj xjVar) {
        return com.ss.android.downloadlib.c.kd.xj(xjVar).xj("cancel_pause_optimise_apk_retain_switch", 0) == 1 && xjVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, int i2, com.ss.android.downloadad.api.xj.hf hfVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i2));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("pause_cancel_optimise", jSONObject, hfVar);
    }
}
