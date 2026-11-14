package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.hf.xj.hf;
import com.bytedance.sdk.component.hf.xj.zg;
import com.sigmob.sdk.downloader.core.c;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public hf call;
    public long readOff;
    public AVMDLRequest request;
    public zg response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public AVMDLResponse(AVMDLRequest aVMDLRequest, zg zgVar, hf hfVar) {
        this.request = aVMDLRequest;
        this.response = zgVar;
        this.call = hfVar;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }

    private void parseResponse() {
        int lastIndexOf;
        zg zgVar = this.response;
        if (zgVar == null) {
            return;
        }
        int w = zgVar.w();
        this.statusCode = w;
        if (w == 200) {
            this.contentlength = toInt(this.response.xj(c.e));
            return;
        }
        if (w == 206) {
            String xj = this.response.xj(c.f);
            if (TextUtils.isEmpty(xj) || (lastIndexOf = xj.lastIndexOf("/")) < 0 || lastIndexOf >= xj.length() - 1) {
                return;
            }
            this.contentlength = toInt(xj.substring(lastIndexOf + 1), -1);
        }
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public void cancel() {
        hf hfVar = this.call;
        if (hfVar != null) {
            hfVar.w();
        }
    }

    @SuppressLint({"CI_DefaultLocale"})
    public boolean isFinish() {
        AVMDLRequest aVMDLRequest = this.request;
        long j = aVMDLRequest.size;
        long j2 = j >= 0 ? aVMDLRequest.reqOff + j : this.contentlength;
        long j3 = this.contentlength;
        if (j2 > j3) {
            j2 = j3;
        }
        String.format("check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(j2));
        return this.readOff >= j2;
    }

    public boolean isOpenSuccessful() {
        int i = this.statusCode;
        return i >= 200 && i < 300;
    }

    public boolean isReadSuccessful() {
        return !this.isReadErr;
    }

    @SuppressLint({"CI_DefaultLocale"})
    public int readData(byte[] bArr) {
        if (this.response.y() == null) {
            return 0;
        }
        try {
            int read = this.response.y().w().read(bArr);
            if (read <= 0) {
                return -1;
            }
            String.format("before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            long j = read;
            this.readOff += j;
            AVMDLRequest aVMDLRequest = this.request;
            aVMDLRequest.reqOff += j;
            long j2 = aVMDLRequest.size;
            if (j2 > 0) {
                aVMDLRequest.size = j2 - j;
            }
            String.format("after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(read), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            return read;
        } catch (IOException e) {
            this.isReadErr = true;
            AVMDLLog.e(TAG, "read data exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    public void reset() {
        this.response = null;
        this.call = null;
        this.contentlength = -1L;
        this.statusCode = -1;
        this.isReadErr = false;
    }

    public static int toInt(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }
}
