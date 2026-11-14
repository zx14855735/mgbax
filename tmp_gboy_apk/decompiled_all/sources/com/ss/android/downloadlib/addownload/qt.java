package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.yo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class qt {
    private static com.ss.android.downloadlib.addownload.xj.w hf;
    private static com.ss.android.downloadlib.addownload.xj.u xj;

    public static com.ss.android.downloadlib.addownload.xj.w hf() {
        return hf;
    }

    public static boolean xj(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.ss.android.downloadlib.addownload.xj.u xj() {
        return xj;
    }

    public static void xj(com.ss.android.downloadlib.addownload.xj.u uVar) {
        xj = uVar;
    }

    public static void xj(com.ss.android.downloadlib.addownload.xj.w wVar) {
        hf = wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static boolean xj(final com.ss.android.downloadad.api.xj.hf hfVar, DownloadInfo downloadInfo, int i, final com.ss.android.downloadlib.addownload.u.f fVar, final boolean z, final com.ss.android.downloadlib.addownload.xj.w wVar) {
        ?? r2;
        if (hfVar == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            r2 = com.ss.android.downloadlib.c.kd.w((com.ss.android.downloadad.api.xj.xj) hfVar);
        } else {
            r2 = com.ss.android.downloadlib.c.kd.hf((com.ss.android.downloadad.api.xj.xj) hfVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf((int) r2));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        if (z) {
            com.ss.android.downloadlib.u.xj.xj().xj("cancel_pause_reserve_wifi_switch_status", jSONObject, hfVar);
        } else {
            com.ss.android.downloadlib.u.xj.xj().xj("pause_reserve_wifi_switch_status", jSONObject, hfVar);
        }
        if (r2 == 0 || !xj(i) || com.ss.android.socialbase.downloader.tf.y.hf(pl.getContext())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        xj(new com.ss.android.downloadlib.addownload.xj.u() { // from class: com.ss.android.downloadlib.addownload.qt.1
            @Override // com.ss.android.downloadlib.addownload.xj.u
            public void hf() {
                qt.xj((com.ss.android.downloadlib.addownload.xj.u) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(pl.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.ss.android.downloadlib.u.xj.xj().xj("cancel_pause_reserve_wifi_cancel", hfVar);
                } else {
                    com.ss.android.downloadlib.u.xj.xj().hf("pause_reserve_wifi_cancel", hfVar);
                }
                fVar.xj(hfVar);
            }

            @Override // com.ss.android.downloadlib.addownload.xj.u
            public void xj() {
                qt.xj((com.ss.android.downloadlib.addownload.xj.u) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(pl.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    yo.xj().xj(downloadInfo2);
                    if (z) {
                        com.ss.android.downloadlib.u.xj.xj().xj("cancel_pause_reserve_wifi_confirm", hfVar);
                    } else {
                        com.ss.android.downloadlib.u.xj.xj().hf("pause_reserve_wifi_confirm", hfVar);
                    }
                }
                fVar.xj(hfVar);
            }
        });
        if (z && wVar != null) {
            xj(new com.ss.android.downloadlib.addownload.xj.w() { // from class: com.ss.android.downloadlib.addownload.qt.2
                @Override // com.ss.android.downloadlib.addownload.xj.w
                public void delete() {
                    com.ss.android.downloadlib.u.xj.xj().xj("cancel_pause_reserve_wifi_delete", com.ss.android.downloadad.api.xj.hf.this);
                    wVar.delete();
                }
            });
        }
        if (z) {
            TTDelegateActivity.xj(hfVar, "删除");
        } else {
            TTDelegateActivity.hf(hfVar);
        }
        return true;
    }
}
