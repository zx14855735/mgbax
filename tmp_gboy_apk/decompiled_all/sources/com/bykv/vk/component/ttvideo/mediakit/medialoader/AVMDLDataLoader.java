package com.bykv.vk.component.ttvideo.mediakit.medialoader;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSInfo;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser;
import com.bykv.vk.component.ttvideo.mediakit.net.IPCache;
import com.bytedance.sdk.component.tf.u.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.x.y;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVMDLDataLoader implements Handler.Callback {
    public static final int AVMDLErrorIsCreateTask = -1000;
    public static final int AVMDLErrorIsInvalidContentLenth = -2000;
    public static final int AVMDLErrorIsInvalidFileWrite = -5000;
    public static final int AVMDLErrorIsInvalidRequestInfo = -4000;
    public static final int AVMDLErrorIsStatusCodeMoreThan400 = -3000;
    public static final int AVMDLErrorIsStatusCodeMoreThan500 = -3001;
    public static final int AVMDLErrorIsTheSameKeyTask = -1001;
    public static final int AVMDLErrorIsTooManyTask = -1002;
    public static final int AVMDLLoaderTypeNone = 10000;
    public static final int AVMDLTaskStateStart = 1;
    public static final int AVMDLTaskStateStop = 2;
    public static final int AVMDLTaskTypeDownloadTask = 3;
    public static final int AVMDLTaskTypePlayTask = 1;
    public static final int AVMDLTaskTypePreloadTask = 2;
    public static final int AVMDLoaderTypeAliP2P = 5;
    public static final int AVMDLoaderTypeHttp = 0;
    public static final int AVMDLoaderTypeKsyP2P = 3;
    public static final int AVMDLoaderTypeOwnLiveVDP = 7;
    public static final int AVMDLoaderTypeOwnVDP = 2;
    public static final int AVMDLoaderTypeWsuP2P = 6;
    public static final int AVMDLoaderTypeXYVod = 1;
    public static final int AVMDLoaderTypeYFP2P = 4;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeyIsAccessCheckLevel = 3511;
    public static final int KeyIsAllowTryTheLastUrl = 7357;
    public static final int KeyIsAlogEnable = 7225;
    public static final int KeyIsAlogInfo = 14;
    public static final int KeyIsCDNLog = 6;
    public static final int KeyIsCacheDirListsStr = 7399;
    public static final int KeyIsCloseFileCache = 800;
    public static final int KeyIsConnectPoolStragetyValue = 7363;
    public static final int KeyIsControlCDNRangeType = 703;
    public static final int KeyIsDNSLog = 15;
    public static final int KeyIsDownloadDir = 7300;
    public static final int KeyIsDownloadEnd = 21;
    public static final int KeyIsDownloadSuspend = 22;
    public static final int KeyIsDownloaderLog = 19;
    public static final int KeyIsDownloaderLogTTNet = 16;
    public static final int KeyIsEnableCacheReqRange = 7358;
    public static final int KeyIsEnableDynamicSocketTimeout = 7362;
    public static final int KeyIsEnableEarlyData = 8219;
    public static final int KeyIsEnableEventInfo = 9999;
    public static final int KeyIsEnableExternDNS = 700;
    public static final int KeyIsEnableFileCacheV2 = 7222;
    public static final int KeyIsEnableFileRingBuffer = 7228;
    public static final int KeyIsEnableIOManager = 7391;
    public static final int KeyIsEnableIpBucket = 901;
    public static final int KeyIsEnableLazyBufferpool = 7332;
    public static final int KeyIsEnableLoaderPreempt = 2510;
    public static final int KeyIsEnableLoaderSeek = 7369;
    public static final int KeyIsEnableNetScheduler = 7342;
    public static final int KeyIsEnableNewBufferpool = 7334;
    public static final int KeyIsEnableP2PPreDown = 7340;
    public static final int KeyIsEnablePlayInfoCache = 7339;
    public static final int KeyIsEnablePlayLog = 7341;
    public static final int KeyIsEnablePreconnect = 2508;
    public static final int KeyIsEnablePreloadReUse = 105;
    public static final int KeyIsEnableSessionReuse = 5511;
    public static final int KeyIsEnableSocketReuse = 701;
    public static final int KeyIsEnableStorageModule = 10000;
    public static final int KeyIsEnableSyncDnsForPcdn = 7226;
    public static final int KeyIsEnableUseFileExtendLoaderBuffer = 7229;
    public static final int KeyIsErrorStateTrustTime = 902;
    public static final int KeyIsFileCacheProgress = 3;
    public static final int KeyIsFirstRangeLeftThreshold = 7346;
    public static final int KeyIsForbidByPassCookie = 1510;
    public static final int KeyIsGetAllCacheSize = 100;
    public static final int KeyIsGetCacheInfo = 101;
    public static final int KeyIsGetCacheSize = 103;
    public static final int KeyIsGetCostLog = 1011;
    public static final int KeyIsGetCustomHttpHeader = 1509;
    public static final int KeyIsGetEnableHls = 9407;
    public static final int KeyIsGetIOManagerHandle = 7390;
    public static final int KeyIsGetLoaderVersion = 11;
    public static final int KeyIsGetLocalAddr = 4;
    public static final int KeyIsGetMdlProtocolHandle = 7218;
    public static final int KeyIsGetPlayLog = 1010;
    public static final int KeyIsGetResStatus = 7231;
    public static final int KeyIsGetSpeedStatus = 7230;
    public static final int KeyIsGetVersionInfo = 830;
    public static final int KeyIsGlobalSpeedSample = 703;
    public static final int KeyIsHeartBeatLog = 70;
    public static final int KeyIsHiJackError = 701;
    public static final int KeyIsIOSpeedInfo = 5;
    public static final int KeyIsIgnorePlayInfo = 9400;
    public static final int KeyIsInitialSocketTimeout = 7360;
    public static final int KeyIsIsCheckPreloadLevel = 6512;
    public static final int KeyIsIsChecksumLevel = 1504;
    public static final int KeyIsIsDownloadSource = 1506;
    public static final int KeyIsIsEnableDownloaderLog = 7347;
    public static final int KeyIsIsEnableTTNetLoader = 7348;
    public static final int KeyIsIsEncryptVersion = 1505;
    public static final int KeyIsIsGetChecksumInfo = 1503;
    public static final int KeyIsIsMaxTlsVersion = 5512;
    public static final int KeyIsIsPreloadCancel = 7;
    public static final int KeyIsIsTestSpeedVersion = 1502;
    public static final int KeyIsLiveCacheThresholdHttpToP2p = 8006;
    public static final int KeyIsLiveCacheThresholdP2pToHttp = 8007;
    public static final int KeyIsLiveContainerString = 8021;
    public static final int KeyIsLiveEnableMdlProto = 8102;
    public static final int KeyIsLiveGetCurrentBitRate = 8004;
    public static final int KeyIsLiveGetLoaderType = 8103;
    public static final int KeyIsLiveGetP2pState = 8002;
    public static final int KeyIsLiveGetPlayCacheSec = 8003;
    public static final int KeyIsLiveLoaderEnable = 8100;
    public static final int KeyIsLiveLoaderP2pEnable = 8101;
    public static final int KeyIsLiveMaxTrySwitchP2pTimes = 8008;
    public static final int KeyIsLiveMobileDownloadAllow = 8011;
    public static final int KeyIsLiveMobileUploadAllow = 8010;
    public static final int KeyIsLivePlayInfoAudioMixingEnd = 8014;
    public static final int KeyIsLivePlayInfoAudioMixingStart = 8013;
    public static final int KeyIsLivePlayInfoIsPreview = 8016;
    public static final int KeyIsLivePlayInfoIsStreamReceived = 8015;
    public static final int KeyIsLiveRecvDataTimeout = 8012;
    public static final int KeyIsLiveSetLoaderType = 8000;
    public static final int KeyIsLiveSetP2pAllow = 8001;
    public static final int KeyIsLiveSetPrepareTask = 8017;
    public static final int KeyIsLiveSetTaskFinish = 8018;
    public static final int KeyIsLiveWaitP2pReadyThreshold = 8009;
    public static final int KeyIsLiveWatchDurationThreshold = 8005;
    public static final int KeyIsLoadMonitorMinAllowLoadSize = 7397;
    public static final int KeyIsLoadMonitorTimeInternal = 7396;
    public static final int KeyIsLoaderCacheSize = 9216;
    public static final int KeyIsLoaderEventCancel = 72;
    public static final int KeyIsLoaderEventCompleted = 73;
    public static final int KeyIsLoaderEventStart = 71;
    public static final int KeyIsLoaderEventUnKnown = 74;
    public static final int KeyIsLoaderFactoryP2PLevel = 8216;
    public static final int KeyIsLoaderFactoryP2PStragetyLevel = 8218;
    public static final int KeyIsLoaderFactoryXYLibValue = 8217;
    public static final int KeyIsLoaderTypeSwitch = 12;
    public static final int KeyIsMAXIPV4Num = 7331;
    public static final int KeyIsMAXIPV6Num = 7330;
    public static final int KeyIsMarkedFileIOSpeed = 1508;
    public static final int KeyIsMaxFileMemCacheNum = 5515;
    public static final int KeyIsMaxFileMemCacheSize = 5513;
    public static final int KeyIsMaxIpCountEachDomain = 900;
    public static final int KeyIsMaxKeepAliveHostNum = 7364;
    public static final int KeyIsMaxSocketReuseNum = 7361;
    public static final int KeyIsNetCacheDir = 5510;
    public static final int KeyIsNetSchedulerBlockAllNetErr = 7343;
    public static final int KeyIsNetSchedulerBlockDurationMs = 7345;
    public static final int KeyIsNetSchedulerBlockErrCount = 7344;
    public static final int KeyIsNetworkAccessType = 7219;
    public static final int KeyIsNetworkChanged = 7217;
    public static final int KeyIsNewBufferPoolGrowBlockCount = 7337;
    public static final int KeyIsNewBufferpoolBlockSize = 7335;
    public static final int KeyIsNewBufferpoolResidentSize = 7336;
    public static final int KeyIsNewPreloadLog = 1002;
    public static final int KeyIsNewProtocolLog = 1001;
    public static final int KeyIsNewProxyLog = 1000;
    public static final int KeyIsNewTaskLog = 1003;
    public static final int KeyIsNextDownloadThreshold = 2511;
    public static final int KeyIsOnLiveLoaderError = 9;
    public static final int KeyIsOwnLiveLoaderLog = 10;
    public static final int KeyIsOwnLiveLoaderLogSample = 11;
    public static final int KeyIsOwnVdpLog = 1;
    public static final int KeyIsP2PFirstRangeLoaderType = 7372;
    public static final int KeyIsP2PPredownPeerCount = 7359;
    public static final int KeyIsPlayInfoBufferingEnd = 7214;
    public static final int KeyIsPlayInfoBufferingStart = 7213;
    public static final int KeyIsPlayInfoCurrentBuffer = 7215;
    public static final int KeyIsPlayInfoLoadPercent = 7212;
    public static final int KeyIsPlayInfoPlayingPos = 7211;
    public static final int KeyIsPlayInfoRenderStart = 7210;
    public static final int KeyIsPlayTaskState = 50;
    public static final int KeyIsPreconnectNum = 2509;
    public static final int KeyIsPreloadEnd = 4;
    public static final int KeyIsPreloadFail = 8;
    public static final int KeyIsPreloadStragetyWhenPlay = 1030;
    public static final int KeyIsPreloadWaitListType = 1040;
    public static final int KeyIsRingBufferSizeKB = 7221;
    public static final int KeyIsSessionTimeout = 7333;
    public static final int KeyIsSetAlogFuncPtr = 1100;
    public static final int KeyIsSetBackupLoaderType = 7227;
    public static final int KeyIsSetCacheDir = 0;
    public static final int KeyIsSetDMDomain = 9402;
    public static final int KeyIsSetDomains = 9404;
    public static final int KeyIsSetEnableOwnVdpPreloadNotify = 7395;
    public static final int KeyIsSetEnableReportTaskLog = 7371;
    public static final int KeyIsSetFileExtendSize = 7392;
    public static final int KeyIsSetForesightDomain = 9403;
    public static final int KeyIsSetGlobalSpeedSampleInterval = 7370;
    public static final int KeyIsSetKeyDomain = 9405;
    public static final int KeyIsSetKeyToken = 9406;
    public static final int KeyIsSetLiveListener = 107;
    public static final int KeyIsSetLoaderFactoryAppInfo = 10;
    public static final int KeyIsSetLoaderFactoryCacheDir = 9;
    public static final int KeyIsSetLoaderFactoryMaxCacheSize = 7;
    public static final int KeyIsSetLoaderFactoryMaxMemorySize = 8;
    public static final int KeyIsSetLoaderType = 6;
    public static final int KeyIsSetMaxCacheAge = 104;
    public static final int KeyIsSetMaxCacheSize = 1;
    public static final int KeyIsSetMinAllowSpeed = 7393;
    public static final int KeyIsSetNetSchedulerBlockHostErrIpCount = 7394;
    public static final int KeyIsSetOnlyUseCdn = 7216;
    public static final int KeyIsSetOpenTimeOut = 3;
    public static final int KeyIsSetPlayInfoSeekAction = 7338;
    public static final int KeyIsSetPreloadParallelNum = 102;
    public static final int KeyIsSetRWTimeOut = 2;
    public static final int KeyIsSetSettingsDomain = 9401;
    public static final int KeyIsSetSpeedSampleInterval = 7368;
    public static final int KeyIsSetTryCount = 5;
    public static final int KeyIsSocketIdleTimeout = 702;
    public static final int KeyIsSocketSendBufferKB = 7220;
    public static final int KeyIsSocketTrainingCenterConfigStr = 7398;
    public static final int KeyIsSpeedCoefficientValue = 1507;
    public static final int KeyIsSpeedInfo = 2;
    public static final int KeyIsSpeedTestSampledByTime = 700;
    public static final int KeyIsSpeedTestSampledByTimeV2 = 702;
    public static final int KeyIsStoIoWriteLimitKBTh1 = 10004;
    public static final int KeyIsStoIoWriteLimitKBTh2 = 10005;
    public static final int KeyIsStoMaxIdleTimeSec = 10006;
    public static final int KeyIsStoPlayDldWinSizeKBLS = 10002;
    public static final int KeyIsStoPlayDldWinSizeKBNM = 10001;
    public static final int KeyIsStoRingBufferSizeKB = 10003;
    public static final int KeyIsTTNetLoaderCronetBufSizeKB = 7349;
    public static final int KeyIsTaskFail = 20;
    public static final int KeyIsTaskLog = 0;
    public static final int KeyIsVdpABTestId = 7223;
    public static final int KeyIsVdpGroupId = 7224;
    public static final int KeyIsWriteFileNotifyIntervalMS = 110;
    public static final int LogInfoKeyIsPcdnTaskLog = 13;
    public static final long LongValueViaConfigNotReady = -998;
    public static final long LongValueViaUnknownKey = -1;
    public static final int S_FAIL = -1;
    public static final int S_OK = 0;
    private static final String TAG = "AVMDLDataLoader";
    private static boolean isSupportQueryEncode = true;
    private static AVMDLDataLoader mInstance;
    private static volatile boolean mIsLibraryLoaded;
    private static volatile boolean mIsMdlTtnetPluginLoaded;
    private boolean isSupportGetAuth;
    private AVMDLDataLoaderConfigure mConfigure;
    private long mEndTime;
    private LoaderListener mEventListener;
    private long mHandle;
    private AVMDLDataLoaderListener mLiveListener;
    private Thread mMsgThread;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mSartTime;
    private AVMDLStartCompleteListener mStartCompleteListener;
    private volatile int mState;
    private AVMDLDataLoaderListener mVodListener;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;
    private Handler mHandler = null;
    private Handler mLogHandler = null;

    private AVMDLDataLoader(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        this.mState = -1;
        this.mConfigure = null;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWritedLock = reentrantReadWriteLock;
        this.mMsgThread = null;
        this.isSupportGetAuth = true;
        this.mStartCompleteListener = null;
        initNativeHandle();
        this.mReadLock = reentrantReadWriteLock.readLock();
        this.mWriteLock = reentrantReadWriteLock.writeLock();
        if (this.mHandle == 0) {
            throw new Exception("create native mdl fail");
        }
        initLogThread(this);
        this.mConfigure = aVMDLDataLoaderConfigure;
        this.mState = 0;
        this.isSupportGetAuth = true;
    }

    private static native void _addDataSource(long j, int i, String str);

    private static native void _cancel(long j, String str);

    private static native void _cancelAll(long j);

    private static native void _cancelAllPreloadWaitReqs(long j);

    private static native void _clearAllCaches(long j);

    private static native void _clearCachesByUsedTime(long j, long j2);

    private static native void _clearNetinfoCache(long j);

    private static native void _close(long j);

    private final native long _create();

    private static native void _downloadResource(long j, String str);

    private static native String _encodeUrl(String str, int i);

    private static native void _forceRemoveCacheFile(long j, String str);

    private static native String _getAuth(long j, String str);

    private static native String _getCDNLog(long j, String str);

    private static native long _getLongValue(long j, int i);

    private static native long _getLongValueByStr(long j, String str, int i);

    private static native long _getLongValueByStrStr(long j, String str, String str2, int i);

    private static native String _getStringValue(long j, int i);

    private static native String _getStringValueByStr(long j, String str, int i);

    private static native String _getStringValueByStrStr(long j, String str, String str2, int i);

    private static native void _makeFileAutoDeleteFlag(long j, String str, int i);

    private static native String _makeTsFileKey(String str, String str2);

    private static native void _p2pPredown(long j, String str);

    private static native void _preConnectByHost(long j, String str, int i);

    private static native void _preloadGroupResource(long j, String str, String str2, int i, int i2);

    private static native void _preloadResource(long j, String str, int i);

    private static native void _preloadResourceWithOffset(long j, String str, int i, int i2);

    private static native void _removeCacheFile(long j, String str);

    private static native void _resumeFileWriteIO(long j);

    private static native void _setInt64Value(long j, int i, long j2);

    private static native void _setInt64ValueByStrKey(long j, int i, String str, long j2);

    private static native void _setIntValue(long j, int i, int i2);

    private static native void _setStringValue(long j, int i, String str);

    private static native int _start(long j);

    private static native void _stop(long j);

    private static native void _suspendedDownload(long j, String str);

    private static native void _updateDNSInfo(long j, String str, String str2, long j2, String str3, int i);

    private String createFilePathBaseDir(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String AcNBzu2 = str.charAt(str.length() + (-1)) == '/' ? CtFAbx.AcNBzu(str, str2) : CtFAbx.AlLFFp(str, "/", str2);
        if (!TextUtils.isEmpty(AcNBzu2)) {
            File file = new File(AcNBzu2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return AcNBzu2;
    }

    private String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static AVMDLDataLoader getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDataLoader.class) {
                if (mInstance == null) {
                    try {
                        mInstance = new AVMDLDataLoader(null);
                    } catch (Exception e) {
                        pl.xj(e);
                        pl.u("ttmdl", "create native exception".concat(String.valueOf(e)));
                        mInstance = null;
                    }
                }
            }
        }
        return mInstance;
    }

    private void hijack() {
        AVMDLDNSParser.processHijack();
        clearNetinfoCache();
    }

    public static synchronized int init(boolean z) {
        synchronized (AVMDLDataLoader.class) {
            try {
                if (mIsLibraryLoaded) {
                    return 0;
                }
                mIsLibraryLoaded = z;
                if (!z) {
                    try {
                        y.xj("avmdl_lite");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e) {
                        pl.u("ttmn", "Can't load avmdl library: ".concat(String.valueOf(e)));
                    } catch (Throwable th) {
                        pl.u("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th)));
                    }
                    tryLoadTTNetLoaderPlugin();
                }
                return !mIsLibraryLoaded ? -1 : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void initLogThread(final Handler.Callback callback) {
        if (this.mMsgThread == null) {
            w wVar = new w() { // from class: com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super("AVMDLDataLoader$1");
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                    AVMDLDataLoader.this.mLogHandler = new Handler(callback);
                    Looper.loop();
                }
            };
            this.mMsgThread = wVar;
            wVar.setName("mdl_log_handler");
            this.mMsgThread.start();
        }
    }

    private void initNativeHandle() {
        if (this.mHandle != 0) {
            return;
        }
        try {
            this.mHandle = _create();
        } catch (Throwable th) {
            this.mHandle = 0L;
            pl.xj(th);
        }
        if (this.mHandle == 0 || this.mHandler != null) {
            return;
        }
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(this);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
    }

    private boolean isNotifyInfo(int i) {
        return i == 4 || i == 20 || i == 50 || i == 8 || i == 3 || i == 21 || i == 7 || i == 22;
    }

    public static String makeTsFileKey(String str, String str2) {
        try {
            return _makeTsFileKey(str, str2);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "makeTsFileKey failed, other reason:  " + e.getMessage());
            return null;
        } catch (UnsatisfiedLinkError e2) {
            AVMDLLog.e(TAG, "makeTsFileKey failed, native not support: " + e2.getMessage());
            return null;
        }
    }

    private boolean postMessage(AVMDLDataLoaderListener aVMDLDataLoaderListener, Message message) {
        Object obj;
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo;
        if (message.what == 701) {
            hijack();
            return true;
        }
        if (aVMDLDataLoaderListener != null && (obj = message.obj) != null && (aVMDLDataLoaderNotifyInfo = (AVMDLDataLoaderNotifyInfo) obj) != null) {
            aVMDLDataLoaderListener.onNotify(aVMDLDataLoaderNotifyInfo);
        }
        return true;
    }

    public static String queryComponentEncode(String str) {
        if (isSupportQueryEncode && !TextUtils.isEmpty(str)) {
            try {
                return _encodeUrl(str, 4);
            } catch (Exception e) {
                e.getMessage();
                e.getStackTrace();
            } catch (UnsatisfiedLinkError e2) {
                isSupportQueryEncode = false;
                e2.getMessage();
                e2.getStackTrace();
            }
        }
        return null;
    }

    private void setConfigureInternal(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        if (this.mHandle == 0 || aVMDLDataLoaderConfigure == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mCacheDir)) {
            String createFilePathBaseDir = createFilePathBaseDir(aVMDLDataLoaderConfigure.mCacheDir, "loaderFactory");
            if (!TextUtils.isEmpty(createFilePathBaseDir)) {
                _setStringValue(this.mHandle, 9, createFilePathBaseDir);
            }
            if (TextUtils.isEmpty(this.mConfigure.mNetCacheDir)) {
                aVMDLDataLoaderConfigure.mNetCacheDir = createFilePathBaseDir(aVMDLDataLoaderConfigure.mCacheDir, "netCache");
            }
            _setStringValue(this.mHandle, 0, aVMDLDataLoaderConfigure.mCacheDir);
        }
        if (!TextUtils.isEmpty(this.mConfigure.mNetCacheDir)) {
            _setStringValue(this.mHandle, KeyIsNetCacheDir, aVMDLDataLoaderConfigure.mNetCacheDir);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mAppInfo)) {
            _setStringValue(this.mHandle, 10, aVMDLDataLoaderConfigure.mAppInfo);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDownloadDir)) {
            _setStringValue(this.mHandle, KeyIsDownloadDir, aVMDLDataLoaderConfigure.mDownloadDir);
        }
        _setIntValue(this.mHandle, KeyIsLiveSetP2pAllow, aVMDLDataLoaderConfigure.mLiveP2pAllow);
        _setIntValue(this.mHandle, KeyIsLiveSetLoaderType, aVMDLDataLoaderConfigure.mLiveLoaderType);
        _setIntValue(this.mHandle, KeyIsLiveWatchDurationThreshold, aVMDLDataLoaderConfigure.mLiveWatchDurationThreshold);
        _setIntValue(this.mHandle, KeyIsLiveCacheThresholdHttpToP2p, aVMDLDataLoaderConfigure.mLiveCacheThresholdHttpToP2p);
        _setIntValue(this.mHandle, KeyIsLiveCacheThresholdP2pToHttp, aVMDLDataLoaderConfigure.mLiveCacheThresholdP2pToHttp);
        _setIntValue(this.mHandle, KeyIsLiveMaxTrySwitchP2pTimes, aVMDLDataLoaderConfigure.mLiveMaxTrySwitchP2pTimes);
        _setIntValue(this.mHandle, KeyIsLiveWaitP2pReadyThreshold, aVMDLDataLoaderConfigure.mLiveWaitP2pReadyThreshold);
        _setIntValue(this.mHandle, KeyIsLiveMobileUploadAllow, aVMDLDataLoaderConfigure.mLiveMobileUploadAllow);
        _setIntValue(this.mHandle, KeyIsLiveMobileDownloadAllow, aVMDLDataLoaderConfigure.mLiveMobileDownloadAllow);
        _setIntValue(this.mHandle, KeyIsLiveRecvDataTimeout, aVMDLDataLoaderConfigure.mLiveRecvDataTimeout);
        _setStringValue(this.mHandle, KeyIsLiveContainerString, aVMDLDataLoaderConfigure.mLiveContainerString);
        _setIntValue(this.mHandle, 1, aVMDLDataLoaderConfigure.mMaxCacheSize);
        _setIntValue(this.mHandle, 2, aVMDLDataLoaderConfigure.mRWTimeOut);
        _setIntValue(this.mHandle, 3, aVMDLDataLoaderConfigure.mOpenTimeOut);
        _setIntValue(this.mHandle, 5, aVMDLDataLoaderConfigure.mTryCount);
        _setIntValue(this.mHandle, 7, aVMDLDataLoaderConfigure.mMaxCacheSize);
        _setIntValue(this.mHandle, 8, aVMDLDataLoaderConfigure.mLoaderFactoryMaxMemorySize);
        _setIntValue(this.mHandle, 6, aVMDLDataLoaderConfigure.mLoaderType);
        _setIntValue(this.mHandle, 102, aVMDLDataLoaderConfigure.mPreloadParallelNum);
        _setIntValue(this.mHandle, 800, aVMDLDataLoaderConfigure.mIsCloseFileCache);
        int i = aVMDLDataLoaderConfigure.mMaxCacheAge;
        if (i > 0) {
            _setIntValue(this.mHandle, 104, i);
        }
        _setIntValue(this.mHandle, KeyIsPreloadStragetyWhenPlay, aVMDLDataLoaderConfigure.mPreloadStrategy);
        _setIntValue(this.mHandle, KeyIsPreloadWaitListType, aVMDLDataLoaderConfigure.mPreloadWaitListType);
        _setIntValue(this.mHandle, 105, aVMDLDataLoaderConfigure.mEnablePreloadReUse);
        _setIntValue(this.mHandle, 700, aVMDLDataLoaderConfigure.mEnableExternDNS);
        _setIntValue(this.mHandle, 701, aVMDLDataLoaderConfigure.mEnableSocketReuse);
        _setIntValue(this.mHandle, 703, aVMDLDataLoaderConfigure.mControlCDNRangeType);
        _setIntValue(this.mHandle, 702, aVMDLDataLoaderConfigure.mSocketIdleTimeOut);
        _setIntValue(this.mHandle, 800, aVMDLDataLoaderConfigure.mIsCloseFileCache);
        _setIntValue(this.mHandle, KeyIsLoaderFactoryP2PLevel, aVMDLDataLoaderConfigure.mLoaderFactoryP2PLevel);
        _setIntValue(this.mHandle, KeyIsIsTestSpeedVersion, aVMDLDataLoaderConfigure.mTestSpeedTypeVersion);
        _setIntValue(this.mHandle, KeyIsIsChecksumLevel, aVMDLDataLoaderConfigure.mCheckSumLevel);
        _setIntValue(this.mHandle, KeyIsIsEncryptVersion, aVMDLDataLoaderConfigure.mEncryptVersion);
        _setIntValue(this.mHandle, KeyIsSpeedCoefficientValue, aVMDLDataLoaderConfigure.mSpeedCoefficientValue);
        _setIntValue(this.mHandle, KeyIsMaxIpCountEachDomain, aVMDLDataLoaderConfigure.mMaxIpCountEachDomain);
        _setIntValue(this.mHandle, 901, aVMDLDataLoaderConfigure.mEnableIpBucket);
        _setIntValue(this.mHandle, 902, aVMDLDataLoaderConfigure.mErrorStateTrustTime);
        _setIntValue(this.mHandle, KeyIsEnablePreconnect, aVMDLDataLoaderConfigure.mEnablePreconnect);
        _setIntValue(this.mHandle, KeyIsPreconnectNum, aVMDLDataLoaderConfigure.mPreconnectNum);
        _setIntValue(this.mHandle, KeyIsEnableLoaderPreempt, aVMDLDataLoaderConfigure.mEnableLoaderPreempt);
        _setIntValue(this.mHandle, KeyIsNextDownloadThreshold, aVMDLDataLoaderConfigure.mNextDownloadThreshold);
        _setIntValue(this.mHandle, KeyIsSetOnlyUseCdn, aVMDLDataLoaderConfigure.mOnlyUseCdn);
        _setIntValue(this.mHandle, KeyIsAccessCheckLevel, aVMDLDataLoaderConfigure.mAccessCheckLevel);
        _setIntValue(this.mHandle, KeyIsEnableSessionReuse, aVMDLDataLoaderConfigure.mEnableSessionReuse);
        _setIntValue(this.mHandle, KeyIsIsMaxTlsVersion, aVMDLDataLoaderConfigure.mMaxTlsVersion);
        _setIntValue(this.mHandle, KeyIsIsCheckPreloadLevel, aVMDLDataLoaderConfigure.mCheckPreloadLevel);
        _setIntValue(this.mHandle, KeyIsLoaderFactoryXYLibValue, aVMDLDataLoaderConfigure.mXYLibValue);
        _setIntValue(this.mHandle, KeyIsEnableP2PPreDown, aVMDLDataLoaderConfigure.mEnableP2PPreDown);
        _setIntValue(this.mHandle, KeyIsEnablePlayLog, aVMDLDataLoaderConfigure.mEnablePlayLog);
        _setIntValue(this.mHandle, KeyIsEnableNetScheduler, aVMDLDataLoaderConfigure.mEnableNetScheduler);
        _setIntValue(this.mHandle, KeyIsEnableCacheReqRange, aVMDLDataLoaderConfigure.mEnableCacheReqRange);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockAllNetErr, aVMDLDataLoaderConfigure.mNetSchedulerBlockAllNetErr);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockErrCount, aVMDLDataLoaderConfigure.mNetSchedulerBlockErrCount);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockDurationMs, aVMDLDataLoaderConfigure.mNetSChedulerBlockDurationMs);
        _setIntValue(this.mHandle, KeyIsFirstRangeLeftThreshold, aVMDLDataLoaderConfigure.mFirstRangeLeftThreshold);
        _setIntValue(this.mHandle, KeyIsSetNetSchedulerBlockHostErrIpCount, aVMDLDataLoaderConfigure.mNetSchedulerBlockHostIpErrCount);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheSize, aVMDLDataLoaderConfigure.mMaxFileMemCacheSize);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheNum, aVMDLDataLoaderConfigure.mMaxFileMemCacheNum);
        _setIntValue(this.mHandle, 110, aVMDLDataLoaderConfigure.mWriteFileNotifyIntervalMS);
        _setIntValue(this.mHandle, KeyIsP2PPredownPeerCount, aVMDLDataLoaderConfigure.mP2PPreDownPeerCount);
        _setIntValue(this.mHandle, KeyIsP2PFirstRangeLoaderType, aVMDLDataLoaderConfigure.mP2PFirstRangeLoaderType);
        int i2 = aVMDLDataLoaderConfigure.mSocketSendBufferKB;
        if (i2 > 0) {
            _setIntValue(this.mHandle, KeyIsSocketSendBufferKB, i2);
        }
        int i3 = aVMDLDataLoaderConfigure.mRingBufferSizeKB;
        if (i3 > 0) {
            _setIntValue(this.mHandle, KeyIsRingBufferSizeKB, i3);
        }
        _setIntValue(this.mHandle, KeyIsEnableFileCacheV2, aVMDLDataLoaderConfigure.mEnableFileCacheV2);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mVdpABTestId)) {
            _setStringValue(this.mHandle, KeyIsVdpABTestId, aVMDLDataLoaderConfigure.mVdpABTestId);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mVdpGroupId)) {
            _setStringValue(this.mHandle, KeyIsVdpGroupId, aVMDLDataLoaderConfigure.mVdpGroupId);
        }
        _setIntValue(this.mHandle, KeyIsAlogEnable, aVMDLDataLoaderConfigure.mAlogEnable);
        _setIntValue(this.mHandle, KeyIsEnableSyncDnsForPcdn, aVMDLDataLoaderConfigure.mEnableSyncDnsForPcdn);
        _setIntValue(this.mHandle, KeyIsEnableFileRingBuffer, aVMDLDataLoaderConfigure.mEnableFileRingBuffer);
        _setIntValue(this.mHandle, KeyIsEnableLazyBufferpool, aVMDLDataLoaderConfigure.mEnableLazyBufferpool);
        _setIntValue(this.mHandle, KeyIsEnableNewBufferpool, aVMDLDataLoaderConfigure.mEnableNewBufferpool);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolBlockSize, aVMDLDataLoaderConfigure.mNewBufferPoolBlockSize);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolResidentSize, aVMDLDataLoaderConfigure.mNewBufferPoolResidentSize);
        _setIntValue(this.mHandle, KeyIsNewBufferPoolGrowBlockCount, aVMDLDataLoaderConfigure.mNewBufferPoolGrowBlockCount);
        _setIntValue(this.mHandle, KeyIsEnableUseFileExtendLoaderBuffer, aVMDLDataLoaderConfigure.mEnableUseFileExtendLoaderBuffer);
        _setIntValue(this.mHandle, KeyIsMAXIPV6Num, aVMDLDataLoaderConfigure.mMaxIPV6Num);
        _setIntValue(this.mHandle, KeyIsMAXIPV4Num, aVMDLDataLoaderConfigure.mMaxIPV4Num);
        _setIntValue(this.mHandle, KeyIsForbidByPassCookie, aVMDLDataLoaderConfigure.mForbidByPassCookie);
        _setIntValue(this.mHandle, KeyIsSessionTimeout, aVMDLDataLoaderConfigure.mSessionTimeout);
        _setIntValue(this.mHandle, KeyIsEnablePlayInfoCache, aVMDLDataLoaderConfigure.mEnablePlayInfoCache);
        _setIntValue(this.mHandle, KeyIsIsEnableDownloaderLog, aVMDLDataLoaderConfigure.mEnableDownloaderLog);
        _setIntValue(this.mHandle, KeyIsIsEnableTTNetLoader, aVMDLDataLoaderConfigure.mEnableTTNetLoader);
        _setIntValue(this.mHandle, KeyIsTTNetLoaderCronetBufSizeKB, aVMDLDataLoaderConfigure.mTTNetLoaderCronetBufSizeKB);
        _setIntValue(this.mHandle, KeyIsAllowTryTheLastUrl, aVMDLDataLoaderConfigure.mIsAllowTryTheLastUrl);
        _setIntValue(this.mHandle, KeyIsSetSpeedSampleInterval, aVMDLDataLoaderConfigure.mSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsEnableIOManager, aVMDLDataLoaderConfigure.mEnableIOManager);
        _setIntValue(this.mHandle, KeyIsEnableLoaderSeek, aVMDLDataLoaderConfigure.mEnableLoaderSeek);
        _setIntValue(this.mHandle, KeyIsSetGlobalSpeedSampleInterval, aVMDLDataLoaderConfigure.mGlobalSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsEnableDynamicSocketTimeout, aVMDLDataLoaderConfigure.mEnableDynamicTimeout);
        _setIntValue(this.mHandle, KeyIsInitialSocketTimeout, aVMDLDataLoaderConfigure.mSocketInitialTimeout);
        _setIntValue(this.mHandle, KeyIsMaxSocketReuseNum, aVMDLDataLoaderConfigure.mMaxSocketReuseCount);
        _setIntValue(this.mHandle, KeyIsSetEnableReportTaskLog, aVMDLDataLoaderConfigure.mEnableReportTaskLog);
        _setInt64Value(this.mHandle, KeyIsLoaderFactoryP2PStragetyLevel, aVMDLDataLoaderConfigure.mP2PStragetyLevel);
        _setInt64Value(this.mHandle, KeyIsConnectPoolStragetyValue, aVMDLDataLoaderConfigure.mConnectPoolStragetyValue);
        _setIntValue(this.mHandle, KeyIsMaxKeepAliveHostNum, aVMDLDataLoaderConfigure.mMaxAliveHostNum);
        _setIntValue(this.mHandle, KeyIsSetFileExtendSize, aVMDLDataLoaderConfigure.mFileExtendSizeKB);
        _setIntValue(this.mHandle, KeyIsSetMinAllowSpeed, aVMDLDataLoaderConfigure.mMinAllowSpeed);
        _setIntValue(this.mHandle, KeyIsSetEnableOwnVdpPreloadNotify, aVMDLDataLoaderConfigure.mEnableOwnVDPPreloadNotify);
        _setIntValue(this.mHandle, KeyIsEnableEarlyData, aVMDLDataLoaderConfigure.mEnableEarlyData);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorMinAllowLoadSize, aVMDLDataLoaderConfigure.mMonitorMinAllowLoadSize);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorTimeInternal, aVMDLDataLoaderConfigure.mMonitorTimeInternal);
        _setStringValue(this.mHandle, KeyIsSocketTrainingCenterConfigStr, aVMDLDataLoaderConfigure.mSocketTraingCenterConfigStr);
        _setStringValue(this.mHandle, KeyIsCacheDirListsStr, aVMDLDataLoaderConfigure.mCacheDirListsStr);
        int i4 = aVMDLDataLoaderConfigure.mEnableEventInfo;
        if (i4 > 0) {
            _setIntValue(this.mHandle, KeyIsEnableEventInfo, i4);
        }
        int i5 = aVMDLDataLoaderConfigure.mEnableStorageModule;
        if (i5 > 0) {
            _setIntValue(this.mHandle, 10000, i5);
            int i6 = aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBNM;
            if (i6 > 0) {
                _setIntValue(this.mHandle, 10001, i6);
            }
            int i7 = aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBLS;
            if (i7 > 0) {
                _setIntValue(this.mHandle, KeyIsStoPlayDldWinSizeKBLS, i7);
            }
            int i8 = aVMDLDataLoaderConfigure.mStoRingBufferSizeKB;
            if (i8 > 0) {
                _setIntValue(this.mHandle, KeyIsStoRingBufferSizeKB, i8);
            }
            int i9 = aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh1;
            if (i9 > 0) {
                _setIntValue(this.mHandle, KeyIsStoIoWriteLimitKBTh1, i9);
            }
            int i10 = aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh2;
            if (i10 > 0) {
                _setIntValue(this.mHandle, KeyIsStoIoWriteLimitKBTh2, i10);
            }
            int i11 = aVMDLDataLoaderConfigure.mStoMaxIdleTimeSec;
            if (i11 > 0) {
                _setIntValue(this.mHandle, KeyIsStoMaxIdleTimeSec, i11);
            }
        }
        _setIntValue(this.mHandle, KeyIsIgnorePlayInfo, aVMDLDataLoaderConfigure.mIgnorePlayInfo);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mSettingsDomain)) {
            _setStringValue(this.mHandle, KeyIsSetSettingsDomain, aVMDLDataLoaderConfigure.mSettingsDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDmDomain)) {
            _setStringValue(this.mHandle, KeyIsSetDMDomain, aVMDLDataLoaderConfigure.mDmDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mForesightDomain)) {
            _setStringValue(this.mHandle, KeyIsSetForesightDomain, aVMDLDataLoaderConfigure.mForesightDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDomains)) {
            _setStringValue(this.mHandle, KeyIsSetDomains, aVMDLDataLoaderConfigure.mDomains);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mKeyDomain)) {
            _setStringValue(this.mHandle, KeyIsSetKeyDomain, aVMDLDataLoaderConfigure.mKeyDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mKeyToken)) {
            _setStringValue(this.mHandle, KeyIsSetKeyToken, aVMDLDataLoaderConfigure.mKeyToken);
        }
        AVMDLDNSParser.setIntValue(0, this.mConfigure.mDNSMainType);
        AVMDLDNSParser.setIntValue(1, this.mConfigure.mDNSBackType);
        AVMDLDNSParser.setIntValue(2, this.mConfigure.mDefaultExpiredTime);
        AVMDLDNSParser.setIntValue(3, this.mConfigure.mMainToBackUpDelayedTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal() {
        this.mWriteLock.lock();
        try {
            if (this.mState != 1) {
                initLogThread(this);
                if (this.mHandle != 0) {
                    setConfigureInternal(this.mConfigure);
                    if (_start(this.mHandle) >= 0) {
                        this.mState = 1;
                    }
                }
            }
            this.mWriteLock.unlock();
            if (this.mConfigure.mEnableBenchMarkIOSpeed > 0) {
                int testFileIOSpeed = testFileIOSpeed();
                String.format("test io average speed:%d", Integer.valueOf(testFileIOSpeed));
                if (testFileIOSpeed > 0) {
                    setIntValue(KeyIsMarkedFileIOSpeed, testFileIOSpeed);
                }
            }
            AVMDLStartCompleteListener aVMDLStartCompleteListener = this.mStartCompleteListener;
            if (aVMDLStartCompleteListener != null) {
                aVMDLStartCompleteListener.onStartComplete();
            }
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    private double testFileIO(String str, int i, RandomAccessFile randomAccessFile) {
        if (TextUtils.isEmpty(str)) {
            return -1.0d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        randomAccessFile.seek(i);
        byte[] bArr = new byte[f.a.c];
        for (int i2 = 0; i2 < 200; i2++) {
            Thread.sleep(5L);
            randomAccessFile.write(bArr, 0, 1024);
        }
        long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) - 1000;
        if (currentTimeMillis2 <= 0) {
            return -1.0d;
        }
        String.format("size:%d costtime:%d", 819200, Long.valueOf(currentTimeMillis2));
        return 819200 / currentTimeMillis2;
    }

    private int testFileIOSpeed() {
        int i;
        double d;
        if (TextUtils.isEmpty(this.mConfigure.mCacheDir)) {
            return -1;
        }
        String str = this.mConfigure.mCacheDir;
        String AcNBzu2 = str.charAt(str.length() - 1) == '/' ? CtFAbx.AcNBzu(this.mConfigure.mCacheDir, "iospeed") : CtFAbx.AcNBzu(this.mConfigure.mCacheDir, "/iospeed");
        File file = new File(AcNBzu2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(AcNBzu2, "iospeed.cach");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            double d2 = 0.0d;
            double d3 = 0.0d;
            for (int i2 = 0; i2 < 30; i2++) {
                try {
                    d = testFileIO(AcNBzu2, i2, randomAccessFile);
                    try {
                        i = 0;
                    } catch (Exception e) {
                        e = e;
                        i = 0;
                    }
                } catch (Exception e2) {
                    e = e2;
                    i = 0;
                    d = 0.0d;
                }
                try {
                    String.format("num:%d result:%f", Integer.valueOf(i2), Double.valueOf(d));
                } catch (Exception e3) {
                    e = e3;
                    pl.xj(e);
                    if (d > 0.0d) {
                        try {
                            d3 += d;
                            d2 += 1.0d;
                        } catch (Exception unused) {
                        }
                    }
                }
                if (d > 0.0d && i2 >= 20) {
                    d3 += d;
                    d2 += 1.0d;
                }
            }
            i = 0;
            randomAccessFile.close();
            file2.delete();
            return d2 > 0.0d ? (int) (d3 / d2) : i;
        } catch (Exception unused2) {
            return -1;
        }
    }

    public static synchronized boolean tryLoadTTNetLoaderPlugin() {
        boolean z;
        synchronized (AVMDLDataLoader.class) {
            z = mIsMdlTtnetPluginLoaded;
        }
        return z;
    }

    public static boolean tryLoadVcnverifylib() {
        return true;
    }

    public void addDataSource(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mWriteLock.lock();
        try {
            _addDataSource(this.mHandle, i, str);
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void cancel(String str) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _cancel(j, str);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void cancelAll() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _cancelAll(j);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void cancelAllPreloadWaitReqs() {
        if (this.mState != 1) {
            return;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _cancelAllPreloadWaitReqs(j);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void clearAllCaches() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _clearAllCaches(j);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void clearNetinfoCache() {
        if (this.mState != 1) {
            return;
        }
        IPCache.getInstance().clear();
        this.mWriteLock.lock();
        try {
            try {
                _clearNetinfoCache(this.mHandle);
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void close() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _close(j);
                    this.mHandle = 0L;
                    this.mState = 5;
                    Handler handler = this.mHandler;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        this.mHandler = null;
                    }
                    Handler handler2 = this.mLogHandler;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                        this.mLogHandler.getLooper().quit();
                        this.mLogHandler = null;
                        this.mMsgThread = null;
                    }
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
            this.mWriteLock.unlock();
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    public void doParseHosts(String[] strArr) {
        AVMDLDNSParser.getInstance().doParseHosts(strArr);
    }

    public void downloadResource(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _downloadResource(j, str);
                    }
                } catch (UnsatisfiedLinkError e) {
                    pl.xj(e);
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void forceRemoveFileCache(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _forceRemoveCacheFile(j, str);
                    }
                } catch (UnsatisfiedLinkError e) {
                    pl.xj(e);
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public long getAllCacheSize() {
        if (this.mState != 1) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            long j = this.mHandle;
            return j != 0 ? _getLongValue(j, 100) : -1L;
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            return -1L;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getAuth(String str) {
        if (this.mState != 1 || !this.isSupportGetAuth) {
            return null;
        }
        this.mReadLock.lock();
        try {
            return _getAuth(this.mHandle, str);
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            this.isSupportGetAuth = false;
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getCDNLog(String str) {
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            return _getCDNLog(this.mHandle, str);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public AVMDLFileInfo getCacheInfo(String str) {
        AVMDLFileInfo aVMDLFileInfo = null;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    String[] split = _getStringValueByStr(j, str, 101).split(",");
                    if (split.length >= 3) {
                        AVMDLFileInfo aVMDLFileInfo2 = new AVMDLFileInfo();
                        try {
                            aVMDLFileInfo2.mFilePath = split[2];
                            if (!TextUtils.isEmpty(split[0])) {
                                aVMDLFileInfo2.mCacheSize = Long.valueOf(split[0]).longValue();
                            }
                            if (!TextUtils.isEmpty(split[1])) {
                                aVMDLFileInfo2.mContentLenght = Long.valueOf(split[1]).longValue();
                            }
                            aVMDLFileInfo = aVMDLFileInfo2;
                        } catch (UnsatisfiedLinkError e) {
                            e = e;
                            aVMDLFileInfo = aVMDLFileInfo2;
                            pl.xj(e);
                            this.mReadLock.unlock();
                            return aVMDLFileInfo;
                        }
                    }
                }
                this.mReadLock.unlock();
                return aVMDLFileInfo;
            } catch (UnsatisfiedLinkError e2) {
                e = e2;
            }
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    public long getCacheSize(String str, String str2) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            long j = this.mHandle;
            return j != 0 ? _getLongValueByStrStr(j, str, str2, 103) : -1L;
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            return -1L;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public AVMDLDataLoaderConfigure getConfig() {
        if (this.mState != 1) {
            return null;
        }
        return this.mConfigure;
    }

    public long getInt64Value(int i, long j) {
        if (i != 8003 && i != 8004) {
            return j;
        }
        AVMDLDataLoaderListener aVMDLDataLoaderListener = this.mLiveListener;
        if (aVMDLDataLoaderListener != null) {
            return aVMDLDataLoaderListener.getInt64Value(i, j);
        }
        AVMDLLog.e("ttmn", "getInt64Value mLiveListener is nullptr, code: ".concat(String.valueOf(i)));
        return j;
    }

    public String getLocalAddr() {
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            long j = this.mHandle;
            return j != 0 ? _getStringValue(j, 4) : null;
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getLongValue(int i) {
        int i2;
        long j = -1;
        if (i == 7218 || i == 7390 || i == 9407) {
            long j2 = this.mHandle;
            if (j2 != 0) {
                return _getLongValue(j2, i);
            }
        } else {
            if (this.mState != 1) {
                return -1L;
            }
            if (this.mConfigure == null) {
                return -998L;
            }
            this.mReadLock.lock();
            try {
                try {
                    switch (i) {
                        case KeyIsLiveLoaderEnable /* 8100 */:
                            i2 = this.mConfigure.mLiveLoaderEnable;
                            j = i2;
                            break;
                        case KeyIsLiveLoaderP2pEnable /* 8101 */:
                            i2 = this.mConfigure.mLiveP2pAllow;
                            j = i2;
                            break;
                        case 8102:
                            i2 = this.mConfigure.mLiveEnableMdlProto;
                            j = i2;
                            break;
                        case KeyIsLiveGetLoaderType /* 8103 */:
                            i2 = this.mConfigure.mLiveLoaderType;
                            j = i2;
                            break;
                        default:
                            long j3 = this.mHandle;
                            if (j3 != 0) {
                                j = _getLongValue(j3, i);
                                break;
                            }
                            break;
                    }
                    this.mReadLock.unlock();
                    return j;
                } catch (UnsatisfiedLinkError e) {
                    pl.xj(e);
                    this.mReadLock.unlock();
                }
            } catch (Throwable th) {
                this.mReadLock.unlock();
                throw th;
            }
        }
        return -1L;
    }

    public long getLongValueByStr(String str, int i) {
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mWriteLock.lock();
        try {
            long j = this.mHandle;
            return j != 0 ? _getLongValueByStr(j, str, i) : -1L;
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            return -1L;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public String getStringCacheInfo(String str) {
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            long j = this.mHandle;
            return j != 0 ? _getStringValueByStr(j, str, 101) : null;
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringValue(int i) {
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            long j = this.mHandle;
            return j != 0 ? _getStringValue(j, i) : null;
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringValueByStr(String str, int i) {
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            long j = this.mHandle;
            return j != 0 ? _getStringValueByStr(j, str, i) : null;
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringValueByStrkey(int i, long j, String str) {
        if (this.mState != 1) {
            return null;
        }
        if (i != 1503) {
            if ((i == 1506 || i == 1509) && this.mVodListener != null && !TextUtils.isEmpty(str)) {
                return this.mVodListener.getStringValue(i, j, str);
            }
        } else if (this.mVodListener != null && !TextUtils.isEmpty(str)) {
            return this.mVodListener.getCheckSumInfo(str);
        }
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        return (i == 12 || i == 9) ? postMessage(this.mLiveListener, message) : (i == 71 || i == 72 || i == 73 || i == 74) ? postMessage(this.mEventListener, message) : postMessage(this.mVodListener, message);
    }

    public boolean isRunning() {
        return this.mState == 1;
    }

    public void makeFileAutoDeleteFlag(String str, int i) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _makeFileAutoDeleteFlag(j, str, i);
                    }
                } catch (UnsatisfiedLinkError e) {
                    pl.xj(e);
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void onEventInfo(Object obj) {
        if (this.mState != 1 || this.mLogHandler == null) {
            return;
        }
        LoaderEventInfo loaderEventInfo = new LoaderEventInfo();
        loaderEventInfo.what = 74;
        try {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("what")) {
                loaderEventInfo.what = ((Integer) hashMap.get("what")).intValue();
            }
            if (hashMap.containsKey("taskType")) {
                loaderEventInfo.taskType = ((Integer) hashMap.get("taskType")).intValue();
            }
            if (hashMap.containsKey("off")) {
                loaderEventInfo.off = ((Long) hashMap.get("off")).longValue();
            }
            if (hashMap.containsKey("endOff")) {
                loaderEventInfo.endOff = ((Long) hashMap.get("endOff")).longValue();
            }
            if (hashMap.containsKey("fileHash")) {
                loaderEventInfo.fileHash = String.valueOf(hashMap.get("fileHash"));
            }
            if (hashMap.containsKey("bytesLoaded")) {
                loaderEventInfo.bytesLoaded = ((Long) hashMap.get("bytesLoaded")).longValue();
            }
            String valueOf = hashMap.containsKey("headers") ? String.valueOf(hashMap.get("headers")) : "";
            if (valueOf != "") {
                for (String str : valueOf.split("\r\n")) {
                    String[] split = str.split(":");
                    loaderEventInfo.mHeaders.put(split[0], split[1]);
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        Message obtainMessage = this.mLogHandler.obtainMessage();
        obtainMessage.what = loaderEventInfo.what;
        obtainMessage.obj = loaderEventInfo;
        obtainMessage.sendToTarget();
    }

    public void onLogInfo(int i, int i2, int i3, String str) {
        if (this.mState == 1 && this.mLogHandler != null && isNotifyInfo(i)) {
            AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = new AVMDLDataLoaderNotifyInfo();
            aVMDLDataLoaderNotifyInfo.what = i;
            aVMDLDataLoaderNotifyInfo.code = i2;
            aVMDLDataLoaderNotifyInfo.parameter = i3;
            aVMDLDataLoaderNotifyInfo.logInfo = str;
            Message obtainMessage = this.mLogHandler.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.obj = aVMDLDataLoaderNotifyInfo;
            obtainMessage.sendToTarget();
        }
    }

    public void onNotify(int i, long j, int i2) {
        if (this.mState != 1 || this.mHandler == null) {
            return;
        }
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = new AVMDLDataLoaderNotifyInfo();
        aVMDLDataLoaderNotifyInfo.what = i;
        aVMDLDataLoaderNotifyInfo.parameter = j;
        aVMDLDataLoaderNotifyInfo.code = i2;
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.obj = aVMDLDataLoaderNotifyInfo;
        obtainMessage.what = i;
        obtainMessage.sendToTarget();
    }

    public void p2pPredown(String str) {
        if (this.mState == 1 && this.mConfigure.mLoaderType > 0) {
            String encodeUrl = encodeUrl(str);
            if (TextUtils.isEmpty(encodeUrl)) {
                return;
            }
            this.mReadLock.lock();
            try {
                _p2pPredown(this.mHandle, encodeUrl);
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                this.mReadLock.unlock();
                throw th;
            }
            this.mReadLock.unlock();
        }
    }

    public void preConnectByHost(String str, int i) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                _preConnectByHost(this.mHandle, str, i);
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void preloadGroupResource(String str, String str2, int i, int i2) {
        if (this.mState != 1 || TextUtils.isEmpty(str2) || i2 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _preloadGroupResource(j, str, str2, i, i2);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
            this.mWriteLock.unlock();
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    public void preloadResource(String str, int i) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || i == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _preloadResource(j, str, i);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void removeFileCache(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _removeCacheFile(j, str);
                    }
                } catch (UnsatisfiedLinkError e) {
                    pl.xj(e);
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void resumeFileWriteIO() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            if (this.mConfigure.mMaxFileMemCacheSize > 0) {
                _resumeFileWriteIO(this.mHandle);
                this.mConfigure.mMaxFileMemCacheSize = 0;
            }
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void setBackUpIp(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IPCache.getInstance().putBackUpIp(str, new AVMDLDNSInfo(11, str, str2, 0L, (String) null));
    }

    public void setConfigure(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        this.mWriteLock.lock();
        try {
            if (this.mState != 1) {
                this.mConfigure = aVMDLDataLoaderConfigure;
                aVMDLDataLoaderConfigure.ParseJsonConfig();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setEventListener(LoaderListener loaderListener) {
        this.mWriteLock.lock();
        try {
            this.mEventListener = loaderListener;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setInt64ValueByStrKey(int i, String str, long j) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    _setInt64ValueByStrKey(j2, i, str, j);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
            this.mWriteLock.unlock();
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    public void setIntValue(int i, int i2) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _setIntValue(j, i, i2);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setListener(AVMDLDataLoaderListener aVMDLDataLoaderListener) {
        this.mWriteLock.lock();
        try {
            this.mVodListener = aVMDLDataLoaderListener;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setLongValue(int i, long j) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    _setInt64Value(j2, i, j);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setStartCompleteListener(AVMDLStartCompleteListener aVMDLStartCompleteListener) {
        this.mStartCompleteListener = aVMDLStartCompleteListener;
    }

    public void setStringValue(int i, String str) {
        if (!TextUtils.isEmpty(str) && this.mState == 1) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _setStringValue(j, i, str);
                    }
                } catch (UnsatisfiedLinkError e) {
                    pl.xj(e);
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public int start() {
        if (this.mState == 1) {
            return 0;
        }
        initNativeHandle();
        new w(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.2
            @Override // java.lang.Runnable
            public void run() {
                AVMDLDataLoader.this.startInternal();
            }
        }, TAG).start();
        return 0;
    }

    public void stop() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _stop(j);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void suspendDownload(String str) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _suspendedDownload(j, str);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void tryToClearCachesByUsedTime(long j) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            long j2 = this.mHandle;
            if (j2 != 0) {
                _clearCachesByUsedTime(j2, j);
            }
        } catch (UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void updateDNSInfo(String str, String str2, long j, String str3, int i) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                _updateDNSInfo(this.mHandle, str, str2, j, str3, i);
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
            this.mWriteLock.unlock();
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    public void setListener(int i, AVMDLDataLoaderListener aVMDLDataLoaderListener) {
        this.mWriteLock.lock();
        if (i == 107) {
            try {
                this.mLiveListener = aVMDLDataLoaderListener;
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    private boolean postMessage(LoaderListener loaderListener, Message message) {
        Object obj;
        LoaderEventInfo loaderEventInfo;
        if (loaderListener != null && (obj = message.obj) != null && (loaderEventInfo = (LoaderEventInfo) obj) != null) {
            int i = message.what;
            if (i == 71) {
                loaderListener.onLoaderTaskStart(loaderEventInfo);
            } else if (i == 72) {
                loaderListener.onLoaderTaskCancel(loaderEventInfo);
            } else if (i == 73) {
                loaderListener.onLoaderTaskCompleted(loaderEventInfo);
            }
        }
        return true;
    }

    public String getStringCacheInfo(String str, String str2) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            long j = this.mHandle;
            return j != 0 ? _getStringValueByStrStr(j, str, str2, 101) : null;
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void preloadResource(String str, int i, int i2) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || i2 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _preloadResourceWithOffset(j, str, i, i2);
                }
            } catch (UnsatisfiedLinkError e) {
                pl.xj(e);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public long getCacheSize(String str) {
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            long j = this.mHandle;
            return j != 0 ? _getLongValueByStr(j, str, 103) : -1L;
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            return -1L;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public static synchronized int init(boolean z, boolean z2) {
        synchronized (AVMDLDataLoader.class) {
            try {
                if (mIsLibraryLoaded) {
                    return 0;
                }
                mIsLibraryLoaded = z;
                if (!z) {
                    try {
                        y.xj("avmdl_lite");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e) {
                        pl.u("ttmn", "Can't load avmdl library: ".concat(String.valueOf(e)));
                    } catch (Throwable th) {
                        pl.u("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th)));
                    }
                    if (z2) {
                        pl.u("ttmn", "try to load pcdn lib");
                        try {
                            y.xj("avmdlp2p");
                        } catch (UnsatisfiedLinkError e2) {
                            pl.u("ttmn", "Can't load avmdlp2p library: ".concat(String.valueOf(e2)));
                        } catch (Throwable th2) {
                            pl.u("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th2)));
                        }
                    }
                    tryLoadTTNetLoaderPlugin();
                }
                return !mIsLibraryLoaded ? -1 : 0;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLogInfo(int r6, int r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.onLogInfo(int, int, java.lang.String):void");
    }

    public static synchronized int init(boolean z, boolean z2, boolean z3) {
        synchronized (AVMDLDataLoader.class) {
            if (mIsLibraryLoaded) {
                return 0;
            }
            mIsLibraryLoaded = z;
            if (!z) {
                if (z3) {
                    try {
                        y.xj("avmdlv2");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e) {
                        pl.u("ttmn", "load avmdlv2 failed: ".concat(String.valueOf(e)));
                    }
                }
                if (!mIsLibraryLoaded) {
                    try {
                        y.xj("avmdl_lite");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e2) {
                        pl.u("ttmn", "Can't load avmdl library: ".concat(String.valueOf(e2)));
                    } catch (Throwable th) {
                        pl.u("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th)));
                    }
                    if (z2) {
                        pl.u("ttmn", "try to load pcdn lib");
                        try {
                            try {
                                y.xj("avmdlp2p");
                            } catch (Throwable th2) {
                                pl.u("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th2)));
                            }
                        } catch (UnsatisfiedLinkError e3) {
                            pl.u("ttmn", "Can't load avmdlp2p library: ".concat(String.valueOf(e3)));
                        }
                    }
                    tryLoadTTNetLoaderPlugin();
                }
            }
            return !mIsLibraryLoaded ? -1 : 0;
        }
    }
}
