package com.bykv.vk.component.ttvideo.mediakit.net;

import ADYaiT.CtFAbx;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LocalDNSHosts {
    private static final String TAG = "BatchParseLocalDNSHosts";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    protected Handler mHandler;
    public String[] mHosts;
    public String mId;
    private boolean mRet = false;
    protected boolean mCancelled = false;
    protected AVMDLNetClient mNetClient = null;

    public static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNSHosts> mLocalDNSRef;

        public MyRunnable(LocalDNSHosts localDNSHosts) {
            this.mLocalDNSRef = new WeakReference<>(localDNSHosts);
        }

        @Override // java.lang.Runnable
        public void run() {
            LocalDNSHosts localDNSHosts = this.mLocalDNSRef.get();
            if (localDNSHosts == null || localDNSHosts.mRet) {
                return;
            }
            localDNSHosts.cancel();
        }
    }

    public LocalDNSHosts(String[] strArr, Handler handler) {
        this.mHosts = strArr;
        this.mHandler = handler;
    }

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

    public void close() {
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    public boolean isRunning() {
        return this.mRet;
    }

    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.LocalDNSHosts.1
                @Override // java.lang.Runnable
                @SuppressLint({"CI_DefaultLocale"})
                public void run() {
                    int i = 0;
                    while (true) {
                        LocalDNSHosts localDNSHosts = LocalDNSHosts.this;
                        String[] strArr = localDNSHosts.mHosts;
                        if (i >= strArr.length) {
                            localDNSHosts.mRet = true;
                            return;
                        }
                        if (!TextUtils.isEmpty(strArr[i])) {
                            try {
                                LocalDNSHosts localDNSHosts2 = LocalDNSHosts.this;
                                localDNSHosts2.mAddress = InetAddress.getAllByName(localDNSHosts2.mHosts[i]);
                                String str = "";
                                for (int i2 = 0; i2 < LocalDNSHosts.this.mAddress.length; i2++) {
                                    String hostAddress = LocalDNSHosts.this.mAddress[i2].getHostAddress();
                                    if (!TextUtils.isEmpty(hostAddress)) {
                                        str = TextUtils.isEmpty(str) ? CtFAbx.AcNBzu(str, hostAddress) : CtFAbx.AlLFFp(str, ",", hostAddress);
                                    }
                                }
                                String str2 = LocalDNSHosts.this.mHosts[i];
                                if (!TextUtils.isEmpty(str)) {
                                    String.format("****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                                    int i3 = AVMDLDNSParser.mGlobalForceExpiredTime;
                                    if (i3 <= 0) {
                                        i3 = AVMDLDNSParser.mGlobalDefaultExpiredTime;
                                    }
                                    IPCache.getInstance().put(LocalDNSHosts.this.mHosts[i], new AVMDLDNSInfo(0, LocalDNSHosts.this.mHosts[i], str, System.currentTimeMillis() + (i3 * 1000), LocalDNSHosts.this.mId));
                                }
                            } catch (Throwable th) {
                                String str3 = LocalDNSHosts.this.mHosts[i];
                                th.getMessage();
                            }
                        }
                        i++;
                    }
                }
            });
        } catch (Exception e) {
            String.format("****end call local dns, exception:%s", e);
        }
        this.mHandler.postDelayed(new MyRunnable(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }
}
