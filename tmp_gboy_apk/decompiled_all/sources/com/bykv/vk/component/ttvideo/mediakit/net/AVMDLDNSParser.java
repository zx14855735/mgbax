package com.bykv.vk.component.ttvideo.mediakit.net;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVMDLDNSParser {
    public static final int AVMDL_DNS_BACKUP_TYPE = 1;
    public static final int AVMDL_DNS_DEFAULT_EXPIRED_TIME = 2;
    public static final int AVMDL_DNS_ENABLE_BACKUP_IP = 5;
    public static final int AVMDL_DNS_ENABLE_DNS_LOG = 7;
    public static final int AVMDL_DNS_ENABLE_PARALLEL = 4;
    public static final int AVMDL_DNS_ENABLE_REFRESH = 6;
    public static final int AVMDL_DNS_FORCE_EXPIRED_TIME = 10;
    public static final int AVMDL_DNS_GOOGLE_PARSE_HOST = 9;
    public static final int AVMDL_DNS_MAIN_DELAYED_USE_BACKUP_TIME = 3;
    public static final int AVMDL_DNS_MAIN_TYPE = 0;
    public static final int AVMDL_DNS_OWN_PARSE_HOST = 8;
    public static final int DNS_TYPE_BACKUP_IP = 11;
    public static final int DNS_TYPE_HTTP_ALI = 1;
    public static final int DNS_TYPE_HTTP_CUSTOM = 4;
    public static final int DNS_TYPE_HTTP_GOOGLE = 3;
    public static final int DNS_TYPE_HTTP_OWN = 2;
    public static final int DNS_TYPE_HTTP_SERVER = 10;
    public static final int DNS_TYPE_LOCAL = 0;
    public static final int PARSER_IS_BACKUP = 1;
    public static final int PARSER_IS_MAIN = 0;
    private static final String TAG = "AVMDLDNSParser";
    public static AVMDLCustomHTTPDNSParser mCustomHttpDNSParser = null;
    public static int mGlobalBackType = 2;
    public static int mGlobalBackUpDelayedTime = 0;
    public static int mGlobalDefaultExpiredTime = 60;
    public static int mGlobalEnableBackUpIp = 0;
    public static int mGlobalEnableDNSLog = 0;
    public static int mGlobalEnableParallel = 0;
    public static int mGlobalEnableRefresh = 0;
    public static int mGlobalForceExpiredTime = 0;
    public static String mGlobalGoogleDNSParseHost = "";
    public static int mGlobalMainType = 0;
    public static String mGlobalOwnDNSParseHost = "";
    private static AVMDLDNSParser mInstance;
    public static AVMDLNetClientMaker mNetClientMaker;
    private Handler mHandler;
    private int mRefCount;
    private int mState;
    private HandlerThread mThread;
    private int mType;
    private int mTimeOut = 5;
    private Lock mLock = new ReentrantLock();
    private Map<String, AVMDLHostProcessor> mProcessors = new HashMap();

    public AVMDLDNSParser() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper()) { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser.1
            @Override // android.os.Handler
            @SuppressLint({"CI_DefaultLocale"})
            public void handleMessage(Message message) {
                Object obj = message.obj;
                AVMDLDNSInfo aVMDLDNSInfo = obj != null ? (AVMDLDNSInfo) obj : null;
                String.format("----receive msg what:%d info:%s", Integer.valueOf(message.what), aVMDLDNSInfo);
                int i = message.what;
                if (i == 2) {
                    AVMDLDNSParser.this.proccessFailMsg(i, aVMDLDNSInfo);
                } else if (i == 3) {
                    AVMDLDNSParser.this.proccessSucMsg(i, aVMDLDNSInfo);
                } else if (i == 4) {
                    AVMDLDNSParser.this.proccessPreParseMsg(i, aVMDLDNSInfo);
                } else if (i == 6) {
                    AVMDLDNSParser.this.processParseMsg(i, aVMDLDNSInfo);
                } else if (i == 7) {
                    AVMDLDNSParser.this.processBatchParseMsg(i, aVMDLDNSInfo);
                }
                String.format("****end proc msg what:%d info:%s", Integer.valueOf(message.what), aVMDLDNSInfo);
            }
        };
    }

    private void addListenerInternal(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        String str2;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String.format("---add listener:%s for host:%s", aVMDLDNSParserListener, str);
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(str);
            String.format("get processor:%s", aVMDLHostProcessor);
            if (aVMDLHostProcessor == null) {
                str2 = str;
                AVMDLHostProcessor aVMDLHostProcessor2 = new AVMDLHostProcessor(str2, this.mHandler, mGlobalMainType, mGlobalBackType, mGlobalBackUpDelayedTime, mGlobalEnableParallel);
                String.format("create processor:%s", aVMDLHostProcessor2);
                aVMDLHostProcessor = aVMDLHostProcessor2;
                z = true;
            } else {
                str2 = str;
            }
            if (aVMDLDNSParserListener != null && !aVMDLHostProcessor.mListeners.containsKey(aVMDLDNSParserListener)) {
                aVMDLHostProcessor.mListeners.put(aVMDLDNSParserListener, 1);
            }
            this.mProcessors.put(str2, aVMDLHostProcessor);
            if (z) {
                aVMDLHostProcessor.processMsg(5, new AVMDLDNSInfo(mGlobalMainType, str2, (String) null, 0L, (String) null));
            }
            this.mLock.unlock();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public static AVMDLDNSParser getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDNSParser.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new AVMDLDNSParser();
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    public static int getIntValue(int i) {
        int i2;
        String.format("----get value for key:%d", Integer.valueOf(i));
        synchronized (AVMDLDNSParser.class) {
            try {
                if (i != 10) {
                    switch (i) {
                        case 0:
                            i2 = mGlobalMainType;
                            break;
                        case 1:
                            i2 = mGlobalBackType;
                            break;
                        case 2:
                            i2 = mGlobalDefaultExpiredTime;
                            break;
                        case 3:
                            i2 = mGlobalBackUpDelayedTime;
                            break;
                        case 4:
                            i2 = mGlobalEnableParallel;
                            break;
                        case 5:
                            i2 = mGlobalEnableBackUpIp;
                            break;
                        case 6:
                            i2 = mGlobalEnableRefresh;
                            break;
                        case 7:
                            i2 = mGlobalEnableDNSLog;
                            break;
                        default:
                            i2 = Integer.MIN_VALUE;
                            break;
                    }
                } else {
                    i2 = mGlobalForceExpiredTime;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        String.format("****get value:%d for key:%d", Integer.valueOf(i2), Integer.valueOf(i));
        return i2;
    }

    public static AVMDLNetClient getNetClient() {
        AVMDLNetClient netClient;
        synchronized (AVMDLDNSParser.class) {
            try {
                AVMDLNetClientMaker aVMDLNetClientMaker = mNetClientMaker;
                netClient = aVMDLNetClientMaker != null ? aVMDLNetClientMaker.getNetClient() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return netClient == null ? new AVMDLHTTPNetwork() : netClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessFailMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            return;
        }
        String.format("----proc fail msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost);
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
            String.format("get processor:%s host:%s", aVMDLHostProcessor, aVMDLDNSInfo.mHost);
            if (aVMDLHostProcessor != null && aVMDLHostProcessor.isValidSourceId(aVMDLDNSInfo.mId)) {
                aVMDLHostProcessor.processResult(i, aVMDLDNSInfo);
                if (aVMDLHostProcessor.isEnd()) {
                    for (AVMDLDNSParserListener aVMDLDNSParserListener : aVMDLHostProcessor.mListeners.keySet()) {
                        if (aVMDLDNSParserListener != null) {
                            String.format("listener:%s oncompletion fail", aVMDLDNSParserListener);
                            aVMDLDNSParserListener.onCompletion(0, aVMDLDNSInfo.mHost, null, 0L, null, aVMDLDNSInfo.mType);
                        }
                    }
                    aVMDLHostProcessor.mListeners.clear();
                    this.mProcessors.remove(aVMDLDNSInfo.mHost);
                }
            }
            this.mLock.unlock();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessPreParseMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        if (mGlobalEnableRefresh <= 0 || aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            return;
        }
        String.format("----proc pre parse msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost);
        AVMDLDNSInfo aVMDLDNSInfo2 = IPCache.getInstance().get(aVMDLDNSInfo.mHost);
        long currentTimeMillis = System.currentTimeMillis();
        String.format("cache:%s expiredT:%d", aVMDLDNSInfo2, Long.valueOf(aVMDLDNSInfo2 == null ? -1L : aVMDLDNSInfo2.mExpiredTime));
        if (aVMDLDNSInfo2 == null || aVMDLDNSInfo2.mExpiredTime < currentTimeMillis) {
            addListenerInternal(aVMDLDNSInfo.mHost, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public void proccessSucMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        HashMap<AVMDLDNSParserListener, Integer> hashMap;
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            return;
        }
        String.format("----proc suc msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost);
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
            String.format("get processor:%s host:%s", aVMDLHostProcessor, aVMDLDNSInfo.mHost);
            if (aVMDLHostProcessor != null && (hashMap = aVMDLHostProcessor.mListeners) != null) {
                for (AVMDLDNSParserListener aVMDLDNSParserListener : hashMap.keySet()) {
                    if (aVMDLDNSParserListener != null) {
                        String.format("listener:%s oncompletion suc", aVMDLDNSParserListener);
                        aVMDLDNSParserListener.onCompletion(0, aVMDLDNSInfo.mHost, aVMDLDNSInfo.mIpList, aVMDLDNSInfo.mExpiredTime, null, aVMDLDNSInfo.mType);
                    }
                }
                aVMDLHostProcessor.mListeners.clear();
                this.mProcessors.remove(aVMDLDNSInfo.mHost);
            }
            sendPreParseMsg(aVMDLDNSInfo.mHost, aVMDLDNSInfo.mExpiredTime - System.currentTimeMillis());
            reportLog(aVMDLDNSInfo);
            this.mLock.unlock();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public void processBatchParseMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        String[] strArr;
        if (aVMDLDNSInfo == null || (strArr = aVMDLDNSInfo.mHosts) == null || strArr.length == 0) {
            return;
        }
        String.format("----proc batch parse msg what:%d", Integer.valueOf(i));
        if (mGlobalEnableParallel <= 0 && mGlobalMainType != 2) {
            new LocalDNSHosts(aVMDLDNSInfo.mHosts, this.mHandler).start();
            return;
        }
        try {
            new HTTPDNSHosts(aVMDLDNSInfo.mHosts, null, 2, this.mHandler).start();
        } catch (Exception e) {
            String.format("parse end create httpdnshosts fail".concat(String.valueOf(e)), new Object[0]);
        }
    }

    public static void processHijack() {
        String.format("----process hijack old dnsmain:%d back:%d", Integer.valueOf(mGlobalMainType), Integer.valueOf(mGlobalBackType));
        int i = mGlobalMainType;
        if (i == 0) {
            mGlobalMainType = mGlobalBackType;
            mGlobalBackType = i;
        }
        String.format("****process hijack new dnsmain:%d back:%d", Integer.valueOf(mGlobalMainType), Integer.valueOf(mGlobalBackType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public void processParseMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            return;
        }
        String.format("----proc parser msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost);
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
            if (aVMDLHostProcessor != null) {
                String.format("----get processor:%s host:%s", aVMDLHostProcessor, aVMDLDNSInfo.mHost);
                aVMDLHostProcessor.processMsg(i, aVMDLDNSInfo);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    private void removeListenerInternal(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        if (TextUtils.isEmpty(str) || aVMDLDNSParserListener == null) {
            return;
        }
        String.format("---remove listener:%s for host:%s", aVMDLDNSParserListener, str);
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(str);
            String.format("get processor:%s", aVMDLHostProcessor);
            if (aVMDLHostProcessor != null) {
                aVMDLHostProcessor.mListeners.remove(aVMDLDNSParserListener);
            }
            if (aVMDLHostProcessor != null) {
                aVMDLHostProcessor.mListeners.size();
            }
            this.mLock.unlock();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    private void reportLog(AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || TextUtils.isEmpty(aVMDLDNSInfo.mIpList) || mGlobalEnableDNSLog <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", "mdl_dns_log");
            jSONObject.put("dns_type", aVMDLDNSInfo.mType);
            jSONObject.put("ip_list", aVMDLDNSInfo.mIpList);
            AVMDLDataLoader.getInstance().onLogInfo(15, 0, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    private void sendBatchParseMsg(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(mGlobalMainType, strArr, (String) null, 0L, (String) null);
        Message message = new Message();
        message.what = 7;
        message.obj = aVMDLDNSInfo;
        this.mHandler.sendMessage(message);
    }

    private void sendPreParseMsg(String str, long j) {
        if (TextUtils.isEmpty(str) || j <= 0 || mGlobalEnableRefresh <= 0) {
            return;
        }
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(mGlobalMainType, str, (String) null, 0L, (String) null);
        Message message = new Message();
        message.what = 4;
        message.obj = aVMDLDNSInfo;
        long j2 = j + 3000;
        String.format("send preparse for host:%s delayTime:%d", aVMDLDNSInfo.mHost, Long.valueOf(j2));
        this.mHandler.sendMessageDelayed(message, j2);
    }

    public static void setClientMaker(AVMDLNetClientMaker aVMDLNetClientMaker) {
        synchronized (AVMDLDNSParser.class) {
            if (aVMDLNetClientMaker != null) {
                try {
                    mNetClientMaker = aVMDLNetClientMaker;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @SuppressLint({"CI_DefaultLocale"})
    public static void setCustomHttpDNSParser(AVMDLCustomHTTPDNSParser aVMDLCustomHTTPDNSParser) {
        synchronized (AVMDLDNSParser.class) {
            try {
                String.format("set custom http dns parser:%d", Integer.valueOf(aVMDLCustomHTTPDNSParser == null ? 0 : 1));
                if (aVMDLCustomHTTPDNSParser != null) {
                    mCustomHttpDNSParser = aVMDLCustomHTTPDNSParser;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @SuppressLint({"CI_DefaultLocale"})
    public static void setIntValue(int i, int i2) {
        String.format("****set value:%d for key:%d", Integer.valueOf(i2), Integer.valueOf(i));
        synchronized (AVMDLDNSParser.class) {
            try {
                if (i != 10) {
                    switch (i) {
                        case 0:
                            mGlobalMainType = i2;
                            break;
                        case 1:
                            mGlobalBackType = i2;
                            break;
                        case 2:
                            mGlobalDefaultExpiredTime = i2;
                            break;
                        case 3:
                            mGlobalBackUpDelayedTime = i2;
                            break;
                        case 4:
                            mGlobalEnableParallel = i2;
                            break;
                        case 5:
                            mGlobalEnableBackUpIp = i2;
                            break;
                        case 6:
                            mGlobalEnableRefresh = i2;
                            break;
                        case 7:
                            mGlobalEnableDNSLog = i2;
                            break;
                    }
                } else {
                    mGlobalForceExpiredTime = i2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setStringValue(int i, String str) {
        String.format("****set value:%s for key:%d", str, Integer.valueOf(i));
        synchronized (AVMDLDNSParser.class) {
            try {
                if (i != 8) {
                    if (i == 9 && !TextUtils.isEmpty(str)) {
                        mGlobalGoogleDNSParseHost = str;
                    }
                } else if (!TextUtils.isEmpty(str)) {
                    mGlobalOwnDNSParseHost = str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void updateDNSInfo(String str, String str2, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IPCache.getInstance().put(str, new AVMDLDNSInfo(10, str, str2, (j + mGlobalDefaultExpiredTime) * 1000, (String) null));
    }

    public void addHost(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        addListenerInternal(str, aVMDLDNSParserListener);
    }

    public void doParseHosts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        int length = strArr.length;
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty(strArr[i])) {
                if (IPCache.getInstance().get(strArr[i]) != null) {
                    String str = strArr[i];
                    strArr[i] = null;
                    length--;
                } else {
                    this.mLock.lock();
                    try {
                        if (this.mProcessors.get(strArr[i]) != null) {
                            String str2 = strArr[i];
                            StringBuilder sb = new StringBuilder();
                            sb.append("for host:");
                            sb.append(str2);
                            strArr[i] = null;
                            length--;
                        }
                    } finally {
                        this.mLock.unlock();
                    }
                }
            }
        }
        if (length == 0) {
            return;
        }
        sendBatchParseMsg(strArr);
    }

    public void postParseHostMsg(String str, int i) {
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(i, str, (String) null, 0L, (String) null);
        Message message = new Message();
        message.what = 5;
        message.obj = aVMDLDNSInfo;
        this.mHandler.sendMessage(message);
    }

    public void release() {
    }

    public void removeHost(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        removeListenerInternal(str, aVMDLDNSParserListener);
    }

    public void setBackUpIP(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IPCache.getInstance().putBackUpIp(str, new AVMDLDNSInfo(11, str, str2, 0L, (String) null));
    }
}
