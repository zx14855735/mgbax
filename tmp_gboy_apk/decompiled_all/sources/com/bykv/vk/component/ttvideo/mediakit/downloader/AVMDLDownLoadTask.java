package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLThreadPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVMDLDownLoadTask {
    public static final int IsHttpOpen = 0;
    public static final int IsHttpRead = 1;
    public static final int IsInValidStep = -1;
    public static final int IsReponseHeader = 0;
    public static final int IsResponseComplete = 3;
    public static final int IsResponseData = 1;
    public static final int IsResponseError = 2;
    private static final String TAG = "AVMDLDownLoadTask";
    private File file;
    FileOutputStream fos;
    private Future mFuture;
    private AVMDLRequest mRequest;
    private AVMDLResponse mResponse;
    private long mHandle = 0;
    private boolean mIsRunning = false;
    private int mStep = -1;
    private Lock mHandleLock = new ReentrantLock();
    private Lock mResonseLock = new ReentrantLock();

    private static native void _notifyLoadInfo(long j, int i, long j2, long j3, String str);

    private static native int _onRecvData(long j, byte[] bArr, int i);

    @SuppressLint({"CI_DefaultLocale"})
    private void cancelResponse() {
        try {
            this.mResonseLock.lock();
            if (this.mResponse != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mResponse.cancel();
                String.format("end cancel cost time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        } finally {
            this.mResonseLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public AVMDLResponse httOpen(AVMDLRequest aVMDLRequest) {
        int i;
        AVMDLResponse aVMDLResponse;
        int i2;
        int i3 = aVMDLRequest.mCurlUrlIndex;
        setResponse(null);
        int i4 = i3;
        do {
            String.format("http open index:%d state:%d trycount:%d maxTry:%d", Integer.valueOf(i4), Integer.valueOf(aVMDLRequest.mUrlState[i4]), Integer.valueOf(aVMDLRequest.mUrlErrCount[i4]), Integer.valueOf(aVMDLRequest.mMaxTryCout));
            if (aVMDLRequest.mUrlState[i4] == 0 && ((i = aVMDLRequest.mMaxTryCout) <= 0 || aVMDLRequest.mUrlErrCount[i4] < i)) {
                try {
                    aVMDLResponse = AVMDLHttpExcutor.excute(aVMDLRequest, i4);
                } catch (IOException e) {
                    e.getLocalizedMessage();
                    aVMDLResponse = null;
                }
                if (aVMDLResponse != null && aVMDLResponse.isOpenSuccessful()) {
                    setResponse(aVMDLResponse);
                    notifyToNative(0, aVMDLResponse.statusCode, aVMDLResponse.contentlength, null);
                    aVMDLResponse.request = aVMDLRequest;
                    return aVMDLResponse;
                }
                int[] iArr = aVMDLRequest.mUrlErrCount;
                iArr[i4] = iArr[i4] + 1;
                if (aVMDLResponse != null && (i2 = aVMDLResponse.statusCode) >= 400 && i2 < 600) {
                    aVMDLRequest.mUrlState[i4] = 1;
                    String.format("set url state forbidden index:%d", Integer.valueOf(i4));
                }
            }
            i4 = (i4 + 1) % aVMDLRequest.urls.length;
        } while (i4 != i3);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public AVMDLResponse httpRead(AVMDLResponse aVMDLResponse, byte[] bArr) {
        int readData = aVMDLResponse.readData(bArr);
        if (readData <= 0) {
            return aVMDLResponse;
        }
        try {
            this.mHandleLock.lock();
            long j = this.mHandle;
            if (j != 0) {
                _onRecvData(j, bArr, readData);
            }
            return aVMDLResponse;
        } finally {
            this.mHandleLock.unlock();
        }
    }

    @SuppressLint({"CI_DefaultLocale"})
    private void setHandle(long j) {
        try {
            this.mHandleLock.lock();
            this.mHandle = j;
            String.format("set handle:%d", Long.valueOf(j));
        } finally {
            this.mHandleLock.unlock();
        }
    }

    private void setResponse(AVMDLResponse aVMDLResponse) {
        this.mResonseLock.lock();
        this.mResponse = aVMDLResponse;
        this.mResonseLock.unlock();
    }

    public void close() {
        setHandle(0L);
        this.mIsRunning = false;
        cancelResponse();
    }

    @SuppressLint({"CI_DefaultLocale"})
    public void notifyToNative(int i, long j, long j2, String str) {
        String.format("notify type:%d code:%d param:%d ", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2));
        try {
            this.mHandleLock.lock();
            long j3 = this.mHandle;
            if (j3 != 0) {
                _notifyLoadInfo(j3, i, j, j2, str);
            }
            this.mHandleLock.unlock();
        } catch (Throwable th) {
            this.mHandleLock.unlock();
            throw th;
        }
    }

    public int open(long j, Object obj, Object obj2, int i, int i2, int i3) {
        if (j == 0 || obj == null) {
            AVMDLLog.e(TAG, "handle zero err");
            return -1;
        }
        AVMDLRequest aVMDLRequest = (AVMDLRequest) obj;
        String[] strArr = aVMDLRequest.urls;
        if (strArr == null || strArr.length == 0) {
            AVMDLLog.e(TAG, "no url err");
            return -2;
        }
        this.mRequest = aVMDLRequest;
        setHandle(j);
        this.mStep = 0;
        this.mIsRunning = true;
        this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.downloader.AVMDLDownLoadTask.1
            @Override // java.lang.Runnable
            public void run() {
                AVMDLResponse aVMDLResponse = new AVMDLResponse(AVMDLDownLoadTask.this.mRequest, null, null);
                byte[] bArr = new byte[32768];
                while (AVMDLDownLoadTask.this.mIsRunning) {
                    int i4 = AVMDLDownLoadTask.this.mStep;
                    if (i4 == 0) {
                        aVMDLResponse = AVMDLDownLoadTask.this.httOpen(aVMDLResponse.request);
                        if (aVMDLResponse == null || !aVMDLResponse.isOpenSuccessful()) {
                            AVMDLDownLoadTask.this.notifyToNative(2, -777L, 0L, null);
                            return;
                        }
                        AVMDLDownLoadTask.this.mStep = 1;
                    } else if (i4 != 1) {
                        continue;
                    } else {
                        aVMDLResponse = AVMDLDownLoadTask.this.httpRead(aVMDLResponse, bArr);
                        if (!aVMDLResponse.isReadSuccessful()) {
                            AVMDLDownLoadTask.this.mStep = 0;
                        } else if (aVMDLResponse.isFinish()) {
                            AVMDLDownLoadTask.this.notifyToNative(3, 0L, aVMDLResponse.contentlength, null);
                            return;
                        }
                    }
                }
            }
        });
        return 0;
    }
}
