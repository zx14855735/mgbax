package com.ss.android.downloadlib.c;

import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {
    public static void hf(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.xj.hf xj;
        if (jSONObject == null || (xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo)) == null) {
            return;
        }
        try {
            w(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - xj.dc()));
            jSONObject.putOpt("click_download_size", Long.valueOf(xj.wn()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            xj.x();
            com.ss.android.downloadlib.addownload.hf.d.xj().xj(xj);
            jSONObject.put("click_pause_times", xj.io());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? 0.0d : curBytes / totalBytes);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long ff = xj.ff();
            if (ff > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - ff);
            }
            long ai = xj.ai();
            if (ai > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - ai);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(xj.j()));
            jSONObject.putOpt("fail_msg", xj.en());
            jSONObject.put("download_failed_times", xj.dk());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.kd.u.xj() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public static void w(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.xj.hf xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo.getId());
                if (xj != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(xj.dc()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(xj.wn()));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
                return;
            }
        }
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.kd.u.xj() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.ss.android.socialbase.downloader.tf.y.w(com.ss.android.downloadlib.addownload.pl.getContext()) ? 1 : 2));
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(com.ss.android.socialbase.downloader.tf.y.hf(com.ss.android.downloadlib.addownload.pl.getContext()) ? 1 : 2));
    }

    public static void xj(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            w(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.xj.hf xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
            if (xj == null) {
                return;
            }
            jSONObject.put("is_update_download", xj.aq() ? 1 : 2);
            xj(xj, jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public static void xj(com.ss.android.downloadad.api.xj.hf hfVar, JSONObject jSONObject) {
        if (jSONObject == null || hfVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", hfVar.s() ? 1 : 0);
            jSONObject.put("origin_mime_type", hfVar.tu());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public static void xj(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray kd = com.ss.android.socialbase.downloader.f.xj.xj(i).kd("ah_report_config");
        if (kd != null) {
            for (int i2 = 0; i2 < kd.length(); i2++) {
                try {
                    String string = kd.getString(i2);
                    c.xj xj = com.ss.android.socialbase.appdownloader.y.xj.xj(string);
                    if (xj != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), xj.y() + "_" + xj.c());
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.hf.xj(com.ss.android.socialbase.downloader.downloader.w.tj()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject xj(JSONObject jSONObject, com.ss.android.downloadad.api.xj.xj xjVar) {
        g.xj(jSONObject, AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, g.xj(xjVar.y(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void xj(JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.y.u.xj());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.y.u.w());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.y.u.u());
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.y.u.xj(com.ss.android.downloadlib.addownload.pl.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.y.u.kd() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.y.u.hf());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.y.u.hf(com.ss.android.downloadlib.addownload.pl.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.y.u.y() ? 1 : 2));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static JSONObject hf(JSONObject jSONObject, com.ss.android.downloadad.api.xj.xj xjVar) {
        g.xj(jSONObject, com.ss.android.socialbase.appdownloader.y.kd.tf().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(g.hf(com.ss.android.downloadlib.addownload.pl.getContext(), com.ss.android.socialbase.appdownloader.y.kd.tf())));
        g.xj(jSONObject, com.ss.android.socialbase.appdownloader.y.kd.tf().replaceAll("\\.", "_") + " versionName", g.w(com.ss.android.downloadlib.addownload.pl.getContext(), com.ss.android.socialbase.appdownloader.y.kd.tf()));
        return jSONObject;
    }
}
