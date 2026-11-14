package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import com.baidu.mobads.sdk.internal.an;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.g;
import com.bytedance.sdk.component.hf.xj.hf;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.qt;
import com.bytedance.sdk.component.hf.xj.y;
import com.bytedance.sdk.component.hf.xj.zg;
import com.sigmob.sdk.downloader.core.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static pl okHttpClient;

    public static String buildRangeHeader(long j, long j2) {
        String formRangeStrBySize = formRangeStrBySize(j, j2);
        if (formRangeStrBySize == null) {
            return null;
        }
        return "bytes=".concat(formRangeStrBySize);
    }

    @SuppressLint({"CI_DefaultLocale"})
    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) {
        am.xj xjVar = new am.xj();
        xjVar.xj(aVMDLRequest.urls[i]);
        xjVar.xj(an.c, (qt) null);
        xjVar.xj(toOkHttpHeaders(aVMDLRequest));
        hf xj = getOkHttpClient().xj(xjVar.hf());
        try {
            long currentTimeMillis = System.currentTimeMillis();
            zg hf = xj.hf();
            long currentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            String.format("http open cost time:%d url:%s", Long.valueOf(currentTimeMillis2 - currentTimeMillis), aVMDLRequest.urls[i]);
            return new AVMDLResponse(aVMDLRequest, hf, xj);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    public static String formRangeStrByPos(long j, long j2) {
        if (j >= 0 && j2 > 0) {
            return j + "-" + j2;
        }
        if (j >= 0) {
            return j + "-";
        }
        if (j >= 0 || j2 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(j2));
    }

    public static String formRangeStrBySize(long j, long j2) {
        return formRangeStrByPos(j, j2 > 0 ? (j2 + j) - 1 : -1L);
    }

    private static synchronized pl getOkHttpClient() {
        pl plVar;
        long j;
        synchronized (AVMDLHttpExcutor.class) {
            try {
                if (okHttpClient == null) {
                    AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
                    long j2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
                    if (config != null) {
                        long j3 = config.mOpenTimeOut > 0 ? r4 * 1000 : 10000L;
                        int i = config.mRWTimeOut;
                        if (i > 0) {
                            j2 = i * 1000;
                        }
                        long j4 = j3;
                        j = j2;
                        j2 = j4;
                    } else {
                        j = 10000;
                    }
                    pl.xj xjVar = new pl.xj();
                    xjVar.xj(Collections.singletonList(g.HTTP_1_1));
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    xjVar.xj(j2, timeUnit).hf(j, timeUnit).w(j, timeUnit);
                    okHttpClient = xjVar.xj();
                }
                plVar = okHttpClient;
            } catch (Throwable th) {
                throw th;
            }
        }
        return plVar;
    }

    private static y toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        y.xj xjVar = new y.xj();
        HashMap<String, String> hashMap = aVMDLRequest.headers;
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                entry.getKey();
                entry.getValue();
                xjVar.hf(entry.getKey(), entry.getValue());
            }
        }
        String buildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (buildRangeHeader != null) {
            xjVar.hf(c.b, buildRangeHeader);
        }
        xjVar.hf("Accept-Encoding", "identity");
        return xjVar.xj();
    }
}
