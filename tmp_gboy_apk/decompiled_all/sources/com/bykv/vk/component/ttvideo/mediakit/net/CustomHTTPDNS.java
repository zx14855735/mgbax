package com.bykv.vk.component.ttvideo.mediakit.net;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CustomHTTPDNS extends BaseDNS {
    private static final String TAG = "CustomHTTPDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    public static class MyRunnable implements Runnable {
        private final WeakReference<CustomHTTPDNS> mCustomHTTPDNSRef;

        public MyRunnable(CustomHTTPDNS customHTTPDNS) {
            this.mCustomHTTPDNSRef = new WeakReference<>(customHTTPDNS);
        }

        @Override // java.lang.Runnable
        public void run() {
            CustomHTTPDNS customHTTPDNS = this.mCustomHTTPDNSRef.get();
            if (customHTTPDNS == null || customHTTPDNS.mRet) {
                return;
            }
            customHTTPDNS.cancel();
            customHTTPDNS.notifyError(new AVMDLDNSInfo(4, customHTTPDNS.mHostname, (String) null, 0L, customHTTPDNS.mId));
        }
    }

    public CustomHTTPDNS(String str, Handler handler) {
        super(str, handler);
        this.mRet = false;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void close() {
        super.close();
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public boolean isRunning() {
        return this.mRet;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.CustomHTTPDNS.1
                @Override // java.lang.Runnable
                @SuppressLint({"CI_DefaultLocale"})
                public void run() {
                    String.format("----call custom httpdns, host:%s custom parser:%d", CustomHTTPDNS.this.mHostname, Integer.valueOf(AVMDLDNSParser.mCustomHttpDNSParser == null ? 0 : 1));
                    AVMDLCustomHTTPDNSParser aVMDLCustomHTTPDNSParser = AVMDLDNSParser.mCustomHttpDNSParser;
                    AVMDLCustomHTTPDNSParserResult parseHost = aVMDLCustomHTTPDNSParser != null ? aVMDLCustomHTTPDNSParser.parseHost(CustomHTTPDNS.this.mHostname) : null;
                    CustomHTTPDNS.this.mRet = true;
                    if (parseHost == null || TextUtils.isEmpty(parseHost.mIPList)) {
                        CustomHTTPDNS customHTTPDNS = CustomHTTPDNS.this;
                        customHTTPDNS.notifyError(new AVMDLDNSInfo(4, customHTTPDNS.mHostname, (String) null, 0L, customHTTPDNS.mId));
                        return;
                    }
                    String.format("****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                    int i = AVMDLDNSParser.mGlobalForceExpiredTime;
                    AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(4, CustomHTTPDNS.this.mHostname, parseHost.mIPList, System.currentTimeMillis() + ((i > 0 ? i : parseHost.mTTL) * 1000), CustomHTTPDNS.this.mId);
                    IPCache.getInstance().put(CustomHTTPDNS.this.mHostname, aVMDLDNSInfo);
                    CustomHTTPDNS.this.notifySuccess(aVMDLDNSInfo);
                    String str = CustomHTTPDNS.this.mHostname;
                }
            });
        } catch (Exception e) {
            String.format("****end call custom httpdns, exception:%s host:%s", e, this.mHostname);
            notifyError(new AVMDLDNSInfo(4, this.mHostname, (String) null, 0L, this.mId));
        }
        this.mHandler.postDelayed(new MyRunnable(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }
}
