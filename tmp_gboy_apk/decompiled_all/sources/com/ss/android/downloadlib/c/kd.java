package com.ss.android.downloadlib.c;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.sigmob.sdk.base.models.ClickCommon;
import com.ss.android.download.api.download.DownloadModel;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd {
    public static boolean c(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("clean_app_cache_dir", 0) == 1;
    }

    public static com.ss.android.socialbase.downloader.f.xj hf(DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.f.xj.xj(xj(downloadModel));
    }

    public static boolean kd(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean u(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("clean_fetch_apk_switch", 0L) == 1;
    }

    public static int w(DownloadModel downloadModel) {
        return xj(hf(downloadModel));
    }

    public static JSONObject xj() {
        return com.ss.android.downloadlib.addownload.pl.d().optJSONObject(ClickCommon.CLICK_SCENE_AD);
    }

    public static boolean y(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("clean_space_switch", 0) == 1;
    }

    public static long c(com.ss.android.downloadad.api.xj.hf hfVar) {
        return xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("ttdownloader_app_install_detect_sum_timestamp", 600000L);
    }

    public static boolean hf(com.ss.android.downloadad.api.xj.xj xjVar) {
        return xj(xjVar).xj("pause_reserve_on_wifi", 0) == 1 && xjVar.e();
    }

    public static long kd() {
        long optLong = com.ss.android.downloadlib.addownload.pl.d().optLong("next_install_min_interval");
        return optLong == 0 ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : optLong;
    }

    public static long u() {
        long optLong = com.ss.android.downloadlib.addownload.pl.d().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    public static JSONObject xj(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? g.xj(com.ss.android.downloadlib.addownload.pl.d(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static int y(com.ss.android.downloadad.api.xj.hf hfVar) {
        return xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("app_install_keep_receiver_time_s", 60);
    }

    public static boolean kd(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.addownload.pl.d().optInt("market_install_finish_opt_polling_thread", 0) == 1 || xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static boolean u(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.addownload.pl.d().optInt("market_install_finish_opt_broadcast", 0) == 1 || xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean w(com.ss.android.downloadad.api.xj.xj xjVar) {
        return xj(xjVar).xj("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && xjVar.e();
    }

    public static long hf(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("storage_min_size", 0L);
    }

    public static boolean hf(com.ss.android.socialbase.downloader.f.xj xjVar) {
        return xjVar != null && xjVar.xj("kllk_need_rename_apk", 0) == 1;
    }

    public static long w(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("clean_fetch_apk_head_time_out", 800L);
    }

    public static com.ss.android.socialbase.downloader.f.xj xj(com.ss.android.downloadad.api.xj.xj xjVar) {
        if (xjVar == null) {
            return com.ss.android.socialbase.downloader.f.xj.w();
        }
        if (xjVar.v() != 0) {
            return com.ss.android.socialbase.downloader.f.xj.xj(xjVar.v());
        }
        if (xjVar.w()) {
            return com.ss.android.socialbase.downloader.f.xj.xj(xj());
        }
        if (xjVar.yo() != null) {
            return com.ss.android.socialbase.downloader.f.xj.xj(xjVar.yo());
        }
        return com.ss.android.socialbase.downloader.f.xj.w();
    }

    public static boolean hf() {
        return com.ss.android.socialbase.downloader.f.xj.w().xj("fix_notification_anr");
    }

    public static boolean w() {
        return com.ss.android.downloadlib.addownload.pl.d().optInt("is_enable_start_install_again") == 1;
    }

    public static int hf(com.ss.android.downloadad.api.xj.hf hfVar) {
        return xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("ttdownloader_app_install_detect_interval_ms", 20000);
    }

    public static boolean w(com.ss.android.downloadad.api.xj.hf hfVar) {
        return com.ss.android.downloadlib.addownload.pl.d().optInt("market_install_finish_opt_switch", 0) == 1 || xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("market_install_finish_opt_switch", 0) == 1;
    }

    public static int xj(com.ss.android.socialbase.downloader.f.xj xjVar) {
        return xjVar.xj("external_storage_permission_path_type", 0);
    }

    public static double xj(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("clean_min_install_size", 0.0d);
    }

    public static int xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        return xj((com.ss.android.downloadad.api.xj.xj) hfVar).xj("ttdownloader_app_install_detect_count", 15);
    }
}
