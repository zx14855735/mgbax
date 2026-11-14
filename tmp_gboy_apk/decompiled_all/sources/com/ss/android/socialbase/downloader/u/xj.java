package com.ss.android.socialbase.downloader.u;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.am;
import com.ss.android.socialbase.downloader.depend.dk;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.c;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.d;
import com.ss.android.socialbase.downloader.network.kd;
import com.ss.android.socialbase.downloader.tf.y;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    public static void xj(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            dk monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!isMonitorStatus && !(isMonitorStatus = xj(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.w)) {
                isMonitorStatus = xj(((com.ss.android.socialbase.downloader.depend.w) monitorDepend).xj(), i);
            }
            if (isMonitorStatus) {
                try {
                    am depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.xj(downloadInfo, baseException, i);
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                }
                xj(monitorDepend, downloadInfo, baseException, i);
                xj(com.ss.android.socialbase.downloader.downloader.w.c(), downloadInfo, baseException, i);
            }
        } catch (Throwable th2) {
            pl.xj(th2);
        }
    }

    private static boolean xj(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void xj(dk dkVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (dkVar == null) {
            return;
        }
        try {
            String hf = dkVar.hf();
            if (TextUtils.isEmpty(hf)) {
                hf = "default";
            }
            JSONObject xj = xj(hf, downloadInfo, baseException, i);
            if (xj == null) {
                xj = new JSONObject();
            }
            dkVar.xj(xj);
        } catch (Throwable unused) {
        }
    }

    public static void xj(hf hfVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (hfVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject xj = xj(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (xj == null) {
                xj = new JSONObject();
            }
            if (i == -1) {
                xj.put("status", baseException.getErrorCode());
            } else {
                xj(i, xj, downloadInfo);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private static void xj(int i, JSONObject jSONObject, DownloadInfo downloadInfo) {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i == -3) {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        } else if (i == -2) {
            str = "download_pause";
        } else if (i == 0) {
            str = "download_create";
        } else if (i == 2) {
            str = "download_start";
        } else if (i != 6) {
            str = "";
        } else {
            str = "download_first_start";
        }
        jSONObject.put("status", str);
    }

    public static String xj(String str) {
        try {
            if (TextUtils.isDigitsOnly(str)) {
                return String.valueOf(Long.valueOf(str).longValue() % 100);
            }
            return "";
        } catch (Exception e) {
            pl.xj(e);
            return "";
        }
    }

    private static JSONObject xj(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String str2;
        Object obj;
        Object obj2;
        int i2;
        Object obj3;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                e p = com.ss.android.socialbase.downloader.downloader.w.p();
                if (p == null) {
                    str2 = "";
                    obj = str2;
                    obj2 = obj;
                    i2 = 0;
                } else {
                    str2 = p.hf();
                    obj = xj(str2);
                    obj2 = p.xj();
                    i2 = p.w();
                }
                if (baseException == null || !(baseException instanceof c)) {
                    obj3 = "";
                } else {
                    obj3 = ((c) baseException).xj();
                }
                jSONObject2.put("event_page", str);
                jSONObject2.put(PluginConstants.KEY_APP_ID, obj2);
                jSONObject2.put("device_id", str2);
                jSONObject2.put("device_id_postfix", obj);
                jSONObject2.put("update_version", i2);
                jSONObject2.put("download_status", i);
                if (downloadInfo != null) {
                    jSONObject2.put("setting_tag", com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).w("setting_tag"));
                    jSONObject2.put("download_id", downloadInfo.getId());
                    jSONObject2.put("name", downloadInfo.getName());
                    jSONObject2.put("url", downloadInfo.getUrl());
                    jSONObject2.put("save_path", downloadInfo.getSavePath());
                    jSONObject2.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject2.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject2.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject2.put("network_quality", downloadInfo.getNetworkQuality());
                    jSONObject2.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject2.put(TKDownloadReason.KSAD_TK_MD5, downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject2.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject2.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject2.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject2.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject2.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject2.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    jSONObject2.put("add_listener_to_same_task", downloadInfo.isAddListenerToSameTask() ? 1 : 0);
                    jSONObject2.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject2.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject2.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject2.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    try {
                        String url = downloadInfo.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            str3 = "";
                            str4 = str3;
                            str5 = str4;
                        } else {
                            Uri parse = Uri.parse(url);
                            str4 = parse.getHost();
                            str5 = parse.getPath();
                            str3 = parse.getLastPathSegment();
                            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str3)) {
                                try {
                                    str5 = str5.substring(0, str5.length() - str3.length());
                                } catch (Throwable th) {
                                    pl.xj(th);
                                }
                            }
                        }
                        jSONObject2.put("url_host", str4);
                        jSONObject2.put("url_path", str5);
                        jSONObject2.put("url_last_path_segment", str3);
                    } catch (Throwable th2) {
                        pl.xj(th2);
                    }
                }
                jSONObject2.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject2.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
                jSONObject2.put("request_log", obj3);
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                pl.xj(e);
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:8|(4:63|64|65|(14:67|11|(3:44|(1:(2:53|(1:55)(2:56|57)))|50)|14|(2:18|19)|22|23|24|(1:26)|27|28|(1:39)|31|(2:36|37)(1:34)))|10|11|(0)|44|(1:46)|(0)|14|(3:16|18|19)|22|23|24|(0)|27|28|(0)|39|31|(0)|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0111, code lost:
    
        com.bytedance.sdk.component.utils.pl.xj(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4 A[Catch: JSONException -> 0x00f6, all -> 0x0130, TryCatch #1 {JSONException -> 0x00f6, blocks: (B:24:0x00aa, B:26:0x00e4, B:27:0x00f9), top: B:23:0x00aa, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0058 A[Catch: all -> 0x0130, TRY_LEAVE, TryCatch #0 {all -> 0x0130, blocks: (B:65:0x0030, B:67:0x0034, B:14:0x007c, B:16:0x0092, B:22:0x00a5, B:24:0x00aa, B:26:0x00e4, B:27:0x00f9, B:36:0x0122, B:39:0x011a, B:43:0x0111, B:44:0x0046, B:46:0x004c, B:53:0x0058, B:57:0x0065, B:60:0x006a, B:62:0x0076, B:70:0x002d, B:64:0x0027), top: B:8:0x0025, inners: #1, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void xj(com.ss.android.socialbase.downloader.network.c r11, java.lang.String r12, java.lang.String r13, long r14, java.lang.String r16, int r17, java.io.IOException r18, com.ss.android.socialbase.downloader.model.DownloadInfo r19) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.u.xj.xj(com.ss.android.socialbase.downloader.network.c, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void xj(com.ss.android.socialbase.downloader.f.xj xjVar, DownloadInfo downloadInfo, String str, d dVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        xj("download_io", xjVar.hf("monitor_download_io"), xjVar, downloadInfo, str, null, null, dVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void xj(com.ss.android.socialbase.downloader.f.xj xjVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, d dVar, BaseException baseException, long j, long j2) {
        xj("segment_io", xjVar.hf("monitor_segment_io"), xjVar, downloadInfo, str, str2, str3, dVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    private static void xj(String str, int i, com.ss.android.socialbase.downloader.f.xj xjVar, DownloadInfo downloadInfo, String str2, String str3, String str4, d dVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        String str5;
        int i2;
        int i3;
        if (i <= 0 || j2 <= 0) {
            return;
        }
        try {
            Uri parse = Uri.parse(str2);
            String host = parse.getHost();
            String path = parse.getPath();
            String lastPathSegment = parse.getLastPathSegment();
            int i4 = 0;
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            String str6 = null;
            if (z) {
                i4 = 1;
            } else if (z2) {
                i4 = 2;
            } else if (baseException != null) {
                i4 = !y.w(com.ss.android.socialbase.downloader.downloader.w.tj()) ? 1049 : baseException.getErrorCode();
                str6 = baseException.getErrorMessage();
            }
            JSONObject jSONObject2 = new JSONObject();
            String str7 = "";
            if (dVar != null) {
                i3 = !(dVar instanceof kd) ? 1 : 0;
                String xj = dVar.xj("X-Cache");
                int contains = !TextUtils.isEmpty(xj) ? xj.toLowerCase().contains("hit") : -1;
                xjVar.xj("monitor_sla", 1);
                if (dVar instanceof com.ss.android.socialbase.downloader.network.xj) {
                    str7 = ((com.ss.android.socialbase.downloader.network.xj) dVar).y();
                }
                i2 = contains;
                str5 = str6;
            } else {
                str5 = str6;
                i2 = -1;
                i3 = -1;
            }
            double d = j / 1048576.0d;
            double d2 = j2;
            double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", xjVar.w("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i3);
            jSONObject2.put("hit_cdn_cache", i2);
            jSONObject2.put("status_code", i4);
            jSONObject2.put("request_log", str7);
            if (str5 != null) {
                jSONObject2.put("error_msg", y.xj(str5, xjVar.xj("exception_msg_length", 500)));
            }
            jSONObject2.put("download_sec", nanos);
            jSONObject2.put("download_mb", d);
            if (nanos > 0.0d) {
                jSONObject2.put("download_speed", d / nanos);
            }
            if (z3) {
                jSONObject2.put("rw_read_time", j3 / d2);
                jSONObject2.put("rw_write_time", j4 / d2);
                jSONObject2.put("rw_sync_time", j5 / d2);
            }
            jSONObject2.put("pkg_name", downloadInfo.getPackageName());
            jSONObject2.put("name", downloadInfo.getTitle());
            if (i != 1) {
                if (i == 3) {
                }
                if (i != 2 || i == 3) {
                    com.ss.android.socialbase.downloader.downloader.w.yy().xj(downloadInfo.getId(), str, jSONObject2);
                }
                return;
            }
            com.ss.android.socialbase.downloader.downloader.w.c();
            if (i != 2) {
            }
            com.ss.android.socialbase.downloader.downloader.w.yy().xj(downloadInfo.getId(), str, jSONObject2);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public static void xj(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.y.d> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.y.d.xj(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            w yy = com.ss.android.socialbase.downloader.downloader.w.yy();
            if (yy != null) {
                yy.xj(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }
}
