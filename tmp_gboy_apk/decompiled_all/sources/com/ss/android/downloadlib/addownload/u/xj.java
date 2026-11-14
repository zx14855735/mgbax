package com.ss.android.downloadlib.addownload.u;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements d {
    private static com.ss.android.downloadlib.addownload.xj.u xj;

    public static com.ss.android.downloadlib.addownload.xj.u xj() {
        return xj;
    }

    @Override // com.ss.android.downloadlib.addownload.u.d
    public boolean xj(final com.ss.android.downloadad.api.xj.hf hfVar, int i, final f fVar) {
        DownloadInfo hf;
        if (hfVar == null || hfVar.wa() || !xj(hfVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(hfVar.gy())) {
            hf = com.ss.android.downloadlib.tf.xj(com.ss.android.downloadlib.addownload.pl.getContext()).xj(hfVar.gy(), null, true);
        } else {
            hf = com.ss.android.downloadlib.tf.xj(com.ss.android.downloadlib.addownload.pl.getContext()).hf(hfVar.xj());
        }
        if (hf == null) {
            return false;
        }
        long xj2 = com.ss.android.downloadlib.addownload.tf.xj(hf.getId(), hf.getCurBytes(), hf.getTotalBytes());
        long totalBytes = hf.getTotalBytes();
        if (xj2 <= 0 || totalBytes <= 0 || totalBytes > xj(hfVar.v())) {
            return false;
        }
        xj = new com.ss.android.downloadlib.addownload.xj.u() { // from class: com.ss.android.downloadlib.addownload.u.xj.1
            @Override // com.ss.android.downloadlib.addownload.xj.u
            public void hf() {
                com.ss.android.downloadlib.addownload.xj.u unused = xj.xj = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
                com.ss.android.downloadlib.u.xj.xj().xj("pause_optimise", jSONObject, hfVar);
                fVar.xj(hfVar);
            }

            @Override // com.ss.android.downloadlib.addownload.xj.u
            public void xj() {
                com.ss.android.downloadlib.addownload.xj.u unused = xj.xj = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
                com.ss.android.downloadlib.u.xj.xj().xj("pause_optimise", jSONObject, hfVar);
            }
        };
        TTDelegateActivity.xj(hfVar, CtFAbx.BI9f7h("该下载任务仅需", g.xj(totalBytes - xj2), "，即将下载完成，是否继续下载？"), "继续", "暂停");
        hfVar.am(true);
        return true;
    }

    private int xj(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("pause_optimise_apk_size", 100) * 1048576;
    }

    private boolean xj(com.ss.android.downloadad.api.xj.xj xjVar) {
        return com.ss.android.downloadlib.c.kd.xj(xjVar).xj("pause_optimise_apk_size_switch", 0) == 1 && xjVar.e();
    }
}
