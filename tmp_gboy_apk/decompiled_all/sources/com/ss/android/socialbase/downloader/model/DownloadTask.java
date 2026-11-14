package com.ss.android.socialbase.downloader.model;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.y;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.am;
import com.ss.android.socialbase.downloader.depend.dk;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.ra;
import com.ss.android.socialbase.downloader.depend.yo;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.v;
import com.ss.android.socialbase.downloader.downloader.zg;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloadTask {
    private boolean autoSetHashCodeForSameTask;
    private c chunkAdjustCalculator;
    private f chunkStrategy;
    private am depend;
    private yo diskSpaceHandler;
    private final List<g> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.xj downloadInfoBuilder;
    private IDownloadFileUriProvider fileUriProvider;
    private ra forbiddenHandler;
    private int hashCodeForSameTask;
    private IDownloadInterceptor interceptor;
    private final SparseArray<IDownloadListener> mainThreadListeners;
    private dk monitorDepend;
    private boolean needDelayForCacheSync;
    private j notificationClickCallback;
    private io notificationEventListener;
    private final SparseArray<IDownloadListener> notificationListeners;
    private v retryDelayTimeCalculator;
    private final SparseArray<y> singleListenerHashCodeMap;
    private final Map<y, IDownloadListener> singleListenerMap;
    private final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.xj();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int keyAt = sparseArray2.keyAt(i);
            IDownloadListener iDownloadListener = sparseArray2.get(keyAt);
            if (iDownloadListener != null) {
                sparseArray.put(keyAt, iDownloadListener);
            }
        }
    }

    private void removeAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.remove(sparseArray2.keyAt(i));
        }
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new f() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.2
                @Override // com.ss.android.socialbase.downloader.downloader.f
                public int xj(long j) {
                    return 1;
                }
            });
        }
    }

    public DownloadTask addDownloadCompleteHandler(g gVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (gVar != null) {
                try {
                    if (!this.downloadCompleteHandlers.contains(gVar)) {
                        this.downloadCompleteHandlers.add(gVar);
                        return this;
                    }
                } finally {
                }
            }
            return this;
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, y yVar, boolean z) {
        Map<y, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(yVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, yVar);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(yVar);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i, iDownloadListener);
        }
    }

    public void addListenerToDownloadingSameTask() {
        com.ss.android.socialbase.downloader.w.xj.hf("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(y.MAIN);
        addListenerToDownloadingSameTask(y.SUB);
        com.ss.android.socialbase.downloader.u.xj.xj(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.zg(z);
        return this;
    }

    public void asyncDownload(final zg zgVar) {
        com.ss.android.socialbase.downloader.d.u.xj(new Runnable() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask.this.download();
            }
        });
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        try {
            IDownloadListener singleDownloadListener = getSingleDownloadListener(y.MAIN);
            if (singleDownloadListener == null) {
                singleDownloadListener = getSingleDownloadListener(y.SUB);
            }
            if (singleDownloadListener != null) {
                this.hashCodeForSameTask = singleDownloadListener.hashCode();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.hashCodeForSameTask;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.y(z);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z) {
        this.autoSetHashCodeForSameTask = z;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.w(i);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.hf(list);
        return this;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public DownloadTask chunkAdjustCalculator(c cVar) {
        this.chunkAdjustCalculator = cVar;
        return this;
    }

    public DownloadTask chunkStategy(f fVar) {
        this.chunkStrategy = fVar;
        return this;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
        this.chunkStrategy = downloadTask.chunkStrategy;
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        for (Map.Entry<y, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.jk(z);
        return this;
    }

    public DownloadTask depend(am amVar) {
        this.depend = amVar;
        return this;
    }

    public DownloadTask diskSpaceHandler(yo yoVar) {
        this.diskSpaceHandler = yoVar;
        return this;
    }

    public DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.pz(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.xj();
        DownloadInfo hf = com.ss.android.socialbase.downloader.downloader.w.et().hf(this.downloadInfo.getId());
        if (hf == null) {
            this.downloadInfo.generateTaskId();
            com.ss.android.socialbase.downloader.u.xj.xj(this, (BaseException) null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(hf);
        }
        setChunkCalculator();
        com.ss.android.socialbase.downloader.downloader.u.xj().xj(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.xj(jSONObject);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.xj(enqueueType);
        return this;
    }

    public DownloadTask executorGroup(int i) {
        this.downloadInfoBuilder.y(i);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.xj(j);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.v(z);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.c(str);
        return this;
    }

    public DownloadTask extraHeaders(List<w> list) {
        this.downloadInfoBuilder.xj(list);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.hf(iArr);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask forbiddenHandler(ra raVar) {
        this.forbiddenHandler = raVar;
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.hf(z);
        return this;
    }

    public c getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public f getChunkStrategy() {
        return this.chunkStrategy;
    }

    public am getDepend() {
        return this.depend;
    }

    public yo getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public g getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            try {
                if (i >= this.downloadCompleteHandlers.size()) {
                    return null;
                }
                return this.downloadCompleteHandlers.get(i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List<g> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public IDownloadListener getDownloadListenerByIndex(y yVar, int i) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(yVar);
        if (downloadListeners == null || i < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            try {
                if (i >= downloadListeners.size()) {
                    return null;
                }
                return downloadListeners.get(downloadListeners.keyAt(i));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getDownloadListenerSize(y yVar) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(yVar);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public SparseArray<IDownloadListener> getDownloadListeners(y yVar) {
        if (yVar == y.MAIN) {
            return this.mainThreadListeners;
        }
        if (yVar == y.SUB) {
            return this.subThreadListeners;
        }
        if (yVar == y.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public ra getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public dk getMonitorDepend() {
        return this.monitorDepend;
    }

    public j getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public io getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public v getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public IDownloadListener getSingleDownloadListener(y yVar) {
        return this.singleListenerMap.get(yVar);
    }

    public DownloadTask hashCodeForSameTask(int i) {
        this.hashCodeForSameTask = i;
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.g(z);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.g(str);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.am(z);
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.yo(z);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return this;
        }
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.put(i, iDownloadListener);
        }
        Map<y, IDownloadListener> map = this.singleListenerMap;
        y yVar = y.MAIN;
        map.put(yVar, iDownloadListener);
        synchronized (this.singleListenerHashCodeMap) {
            this.singleListenerHashCodeMap.put(i, yVar);
        }
        return this;
    }

    public DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.xj(i);
        return this;
    }

    public DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.u(i);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.tf(str);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.f(str);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.kd(i);
        return this;
    }

    public DownloadTask monitorDepend(dk dkVar) {
        this.monitorDepend = dkVar;
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.pl(str);
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.xj(str);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.qt(z);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.f(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.u(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.pl(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.w(z);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.tf(z);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.d(z);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.p(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.e(z);
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z) {
        return this;
    }

    public DownloadTask notificationClickCallback(j jVar) {
        this.notificationClickCallback = jVar;
        return this;
    }

    public DownloadTask notificationEventListener(io ioVar) {
        this.notificationEventListener = ioVar;
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return this;
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.put(i, iDownloadListener);
        }
        Map<y, IDownloadListener> map = this.singleListenerMap;
        y yVar = y.NOTIFICATION;
        map.put(yVar, iDownloadListener);
        synchronized (this.singleListenerHashCodeMap) {
            this.singleListenerHashCodeMap.put(i, yVar);
        }
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.xj(z);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.xj(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.xj(iArr);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.d(str);
        return this;
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, y yVar, boolean z) {
        int indexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(yVar);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(yVar)) {
                this.singleListenerMap.remove(yVar);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            try {
                if (z) {
                    if (this.singleListenerMap.containsKey(yVar)) {
                        iDownloadListener = this.singleListenerMap.get(yVar);
                        this.singleListenerMap.remove(yVar);
                    }
                    if (iDownloadListener != null && (indexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && indexOfValue < downloadListeners.size()) {
                        downloadListeners.removeAt(indexOfValue);
                    }
                } else {
                    downloadListeners.remove(i);
                    synchronized (this.singleListenerHashCodeMap) {
                        try {
                            y yVar2 = this.singleListenerHashCodeMap.get(i);
                            if (yVar2 != null && this.singleListenerMap.containsKey(yVar2)) {
                                this.singleListenerMap.remove(yVar2);
                                this.singleListenerHashCodeMap.remove(i);
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.hf(i);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.p(str);
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(v vVar) {
        this.retryDelayTimeCalculator = vVar;
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.kd(str);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.ht(z);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<g> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<g> it = list.iterator();
            while (it.hasNext()) {
                addDownloadCompleteHandler(it.next());
            }
        }
        return this;
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, y yVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (yVar == y.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
                return;
            } else if (yVar == y.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
                return;
            } else {
                if (yVar == y.NOTIFICATION) {
                    synchronized (this.notificationListeners) {
                        copyListeners(this.notificationListeners, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        pl.xj(th);
    }

    public void setNeedDelayForCacheSync(boolean z) {
        this.needDelayForCacheSync = z;
    }

    public void setNotificationEventListener(io ioVar) {
        this.notificationEventListener = ioVar;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.kd(z);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.c(z);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return this;
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.put(i, iDownloadListener);
        }
        Map<y, IDownloadListener> map = this.singleListenerMap;
        y yVar = y.SUB;
        map.put(yVar, iDownloadListener);
        synchronized (this.singleListenerHashCodeMap) {
            this.singleListenerHashCodeMap.put(i, yVar);
        }
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.u(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.y(str);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.hf(j);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.hf(str);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.w(j);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.w(str);
        return this;
    }

    private void addListenerToDownloadingSameTask(y yVar) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(yVar);
        synchronized (downloadListeners) {
            for (int i = 0; i < downloadListeners.size(); i++) {
                try {
                    IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                    if (iDownloadListener != null) {
                        com.ss.android.socialbase.downloader.downloader.u.xj().hf(getDownloadId(), iDownloadListener, yVar, false);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }
}
