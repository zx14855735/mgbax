package com.ss.android.socialbase.downloader.constants;

import com.fl.saas.base.cache.DatabaseHelper;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface w {
    public static final String[] xj = {DatabaseHelper.COLUMN_ID, "url", "savePath", "tempPath", "name", "chunkCount", "status", "curBytes", "totalBytes", "eTag", "onlyWifi", "force", "retryCount", BaseConstants.EVENT_LABEL_EXTRA, "mimeType", "title", "notificationEnable", "notificationVisibility", "isFirstDownload", "isFirstSuccess", "needHttpsToHttpRetry", "downloadTime", "packageName", TKDownloadReason.KSAD_TK_MD5, "retryDelay", "curRetryTime", "retryDelayStatus", "defaultHttpServiceBackUp", "chunkRunnableReuse", "retryDelayTimeArray", "chunkDowngradeRetry", "backUpUrlsStr", "backUpUrlRetryCount", "realDownloadTime", "retryScheduleMinutes", "independentProcess", "auxiliaryJsonobjectString", "iconUrl", "appVersionCode", "taskId"};
    public static final String[] hf = {DatabaseHelper.COLUMN_ID};
    public static final String[] w = {DatabaseHelper.COLUMN_ID, "chunkIndex", "startOffset", "curOffset", "endOffset", "chunkContentLen", "hostChunkIndex"};
    public static final String[] u = {DatabaseHelper.COLUMN_ID};
    public static final String[] kd = {DatabaseHelper.COLUMN_ID, "info"};
    public static final String[] y = {DatabaseHelper.COLUMN_ID};

    static {
        jCbeGeo();
    }

    private static /* synthetic */ void jCbeGeo() {
        char[] charArray = "DHJ\t@FJB\tEH^\tTOBKK\tmINeUNC@B".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\'');
        }
        String str = new String(charArray);
        char[] charArray2 = "DKNINS".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\'');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
