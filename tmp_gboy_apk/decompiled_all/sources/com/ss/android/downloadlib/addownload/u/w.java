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
public class w implements c {
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
        String BI9f7h2;
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
        long curBytes = hf2.getCurBytes();
        long totalBytes = hf2.getTotalBytes();
        if (curBytes < 0 || totalBytes <= 0) {
            return false;
        }
        final int xj2 = com.ss.android.downloadlib.addownload.tf.xj(hf2.getId(), (int) ((100 * curBytes) / totalBytes));
        final int i2 = (int) (curBytes / BaseConstants.MB_VALUE);
        boolean z = xj2 > xj(hfVar.v());
        xj = new com.ss.android.downloadlib.addownload.xj.u() { // from class: com.ss.android.downloadlib.addownload.u.w.1
            @Override // com.ss.android.downloadlib.addownload.xj.u
            public void hf() {
                com.ss.android.downloadlib.addownload.xj.u unused = w.xj = null;
                w.this.xj(xj2, i2, i2, hfVar, "download_percent_cancel", "cancel");
                fVar.xj(hfVar);
            }

            @Override // com.ss.android.downloadlib.addownload.xj.u
            public void xj() {
                com.ss.android.downloadlib.addownload.xj.u unused = w.xj = null;
                w.this.xj(xj2, i2, i2, hfVar, "download_percent_cancel", "confirm");
            }
        };
        String xj3 = g.xj(com.ss.android.downloadlib.addownload.tf.xj(hfVar.v(), curBytes, totalBytes));
        if (z) {
            BI9f7h2 = "该任务已下载" + xj3 + "，仅需" + g.xj(totalBytes - curBytes) + "即可下载完成，是否继续？";
        } else {
            BI9f7h2 = CtFAbx.BI9f7h("该任务已下载", xj3, "，即将下载完成，是否继续下载？");
        }
        String str = BI9f7h2;
        if (wVar != null) {
            xj(new com.ss.android.downloadlib.addownload.xj.w() { // from class: com.ss.android.downloadlib.addownload.u.w.2
                @Override // com.ss.android.downloadlib.addownload.xj.w
                public void delete() {
                    com.ss.android.downloadlib.addownload.xj.u unused = w.xj = null;
                    w.this.xj(xj2, i2, i2, hfVar, "download_percent_cancel", "delete");
                    wVar.delete();
                }
            });
        }
        TTDelegateActivity.hf(hfVar, str, "继续", "暂停", "删除");
        return true;
    }

    private int xj(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean xj(com.ss.android.downloadad.api.xj.xj xjVar) {
        return com.ss.android.downloadlib.c.kd.xj(xjVar).xj("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && xjVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, int i2, int i3, com.ss.android.downloadad.api.xj.hf hfVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i3));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("pause_cancel_optimise", jSONObject, hfVar);
    }
}
