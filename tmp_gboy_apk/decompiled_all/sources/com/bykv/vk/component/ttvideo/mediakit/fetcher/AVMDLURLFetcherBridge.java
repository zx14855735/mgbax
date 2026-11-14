package com.bykv.vk.component.ttvideo.mediakit.fetcher;

import android.text.TextUtils;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVMDLURLFetcherBridge implements AVMDLURLFetcherListener {
    private static final String TAG = "AVMDLURLFetcherBridge";
    private static AVMDLFetcherMakerInterface fetcherMaker;
    public String rawKey = null;
    public String fileKey = null;
    public String oldURL = null;
    String newURL = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyFetcherResult(long j, String str, String str2, String str3);

    public static void setFetcherMaker(AVMDLFetcherMakerInterface aVMDLFetcherMakerInterface) {
        if (aVMDLFetcherMakerInterface != null) {
            fetcherMaker = aVMDLFetcherMakerInterface;
        }
    }

    public String getResult() {
        this.lock.lock();
        try {
            return this.newURL;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.fetcher.AVMDLURLFetcherListener
    public void onCompletion(int i, String str, String str2, String[] strArr) {
        this.lock.lock();
        try {
            if (this.isFinish) {
                Locale locale = Locale.ENGLISH;
            } else {
                if (strArr != null && strArr.length > 0) {
                    this.newURL = strArr[0];
                }
                Locale locale2 = Locale.ENGLISH;
                String str3 = this.newURL;
                this.isFinish = true;
                long j = this.handle;
                if (j != 0) {
                    _notifyFetcherResult(j, str, str2, str3);
                }
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public void release() {
        String.format("----start release fetcher:%s", this);
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            String.format("****end call release:%s", this);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public int start(long j, String str, String str2, String str3) {
        if (fetcherMaker == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return -1;
        }
        this.lock.lock();
        this.handle = j;
        try {
            this.rawKey = str;
            this.fileKey = str2;
            this.oldURL = str3;
            AVMDLURLFetcherInterface fetcher = fetcherMaker.getFetcher(str, str2, str3);
            if (fetcher == null) {
                this.lock.unlock();
                return -1;
            }
            int start = fetcher.start(str, str2, str3, this);
            int i = 0;
            if (start > 0) {
                String[] uRLs = fetcher.getURLs();
                if (uRLs != null && uRLs.length != 0) {
                    long j2 = this.handle;
                    if (j2 != 0) {
                        String str4 = uRLs[0];
                        this.newURL = str4;
                        _notifyFetcherResult(j2, str, str2, str4);
                        i = 1;
                    }
                }
                Locale locale = Locale.ENGLISH;
                this.lock.unlock();
                return -2;
            }
            if (start < 0) {
                Locale locale2 = Locale.ENGLISH;
                this.lock.unlock();
                return -3;
            }
            this.lock.unlock();
            Locale locale3 = Locale.ENGLISH;
            return i;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }
}
