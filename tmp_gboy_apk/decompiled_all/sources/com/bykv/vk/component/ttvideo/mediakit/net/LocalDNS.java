package com.bykv.vk.component.ttvideo.mediakit.net;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.pl;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LocalDNS extends BaseDNS {
    private static final String TAG = "LocalDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    public static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNS> mLocalDNSRef;

        public MyRunnable(LocalDNS localDNS) {
            this.mLocalDNSRef = new WeakReference<>(localDNS);
        }

        @Override // java.lang.Runnable
        public void run() {
            LocalDNS localDNS = this.mLocalDNSRef.get();
            if (localDNS == null || localDNS.mRet) {
                return;
            }
            localDNS.cancel();
            localDNS.notifyError(new AVMDLDNSInfo(0, localDNS.mHostname, (String) null, 0L, localDNS.mId));
        }
    }

    public LocalDNS(String str, Handler handler) {
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
            this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.LocalDNS.1
                @Override // java.lang.Runnable
                public void run() {
                    LocalDNS localDNS = LocalDNS.this;
                    try {
                        localDNS.mAddress = InetAddress.getAllByName(localDNS.mHostname);
                        LocalDNS.this.mRet = true;
                        if (LocalDNS.this.mAddress == null) {
                            LocalDNS localDNS2 = LocalDNS.this;
                            localDNS2.notifyError(new AVMDLDNSInfo(0, localDNS2.mHostname, (String) null, 0L, localDNS2.mId));
                            return;
                        }
                        String str = "";
                        for (int i = 0; i < LocalDNS.this.mAddress.length; i++) {
                            String hostAddress = LocalDNS.this.mAddress[i].getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                str = TextUtils.isEmpty(str) ? CtFAbx.AcNBzu(str, hostAddress) : CtFAbx.AlLFFp(str, ",", hostAddress);
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            LocalDNS localDNS3 = LocalDNS.this;
                            localDNS3.notifyError(new AVMDLDNSInfo(0, localDNS3.mHostname, (String) null, 0L, localDNS3.mId));
                            return;
                        }
                        String.format("****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                        int i2 = AVMDLDNSParser.mGlobalForceExpiredTime;
                        if (i2 <= 0) {
                            i2 = AVMDLDNSParser.mGlobalDefaultExpiredTime;
                        }
                        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(0, LocalDNS.this.mHostname, str, (i2 * 1000) + System.currentTimeMillis(), LocalDNS.this.mId);
                        IPCache.getInstance().put(LocalDNS.this.mHostname, aVMDLDNSInfo);
                        LocalDNS.this.notifySuccess(aVMDLDNSInfo);
                        String str2 = LocalDNS.this.mHostname;
                    } catch (Throwable th) {
                        pl.xj(th);
                        LocalDNS.this.mRet = true;
                        String.format("****end call local dns, end exception:%s host:%s", th, LocalDNS.this.mHostname);
                        LocalDNS localDNS4 = LocalDNS.this;
                        localDNS4.notifyError(new AVMDLDNSInfo(0, localDNS4.mHostname, (String) null, 0L, localDNS4.mId));
                    }
                }
            });
        } catch (Exception e) {
            String.format("****end call local dns, exception:%s host:%s", e, this.mHostname);
            notifyError(new AVMDLDNSInfo(0, this.mHostname, (String) null, 0L, this.mId));
        }
        this.mHandler.postDelayed(new MyRunnable(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }
}
