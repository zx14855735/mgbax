package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloaderBuilder {
    private c chunkAdjustCalculator;
    private f chunkCntCalculator;
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private tf downloadCache;
    private com.ss.android.socialbase.downloader.network.y downloadDns;
    private boolean downloadInMultiProcess;
    private pl downloadLaunchHandler;
    private com.ss.android.socialbase.downloader.u.hf downloadMonitorListener;
    private x downloadSetting;
    private com.ss.android.socialbase.downloader.network.f headHttpService;
    private IDownloadHttpService httpService;
    private p idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private e monitorConfig;
    private j notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private pz ttNetHandler;
    private int writeBufferSize;
    private List<com.ss.android.socialbase.downloader.depend.g> downloadCompleteHandlers = new ArrayList();
    private boolean needAutoRefreshUnSuccessTask = true;
    private int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder addDownloadCompleteHandler(com.ss.android.socialbase.downloader.depend.g gVar) {
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

    public Downloader build() {
        return new Downloader(this);
    }

    public DownloaderBuilder chunkAdjustCalculator(c cVar) {
        this.chunkAdjustCalculator = cVar;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(f fVar) {
        this.chunkCntCalculator = fVar;
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService executorService) {
        this.chunkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService executorService) {
        this.cpuThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService executorService) {
        this.dbThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder downloadCache(tf tfVar) {
        this.downloadCache = tfVar;
        return this;
    }

    public DownloaderBuilder downloadDns(com.ss.android.socialbase.downloader.network.y yVar) {
        this.downloadDns = yVar;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i) {
        this.downloadExpSwitch = i;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z) {
        this.downloadInMultiProcess = z;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(pl plVar) {
        this.downloadLaunchHandler = plVar;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(com.ss.android.socialbase.downloader.u.hf hfVar) {
        this.downloadMonitorListener = hfVar;
        return this;
    }

    public DownloaderBuilder downloadSetting(x xVar) {
        this.downloadSetting = xVar;
        return this;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public c getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public f getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public Context getContext() {
        return this.context;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public tf getDownloadCache() {
        return this.downloadCache;
    }

    public List<com.ss.android.socialbase.downloader.depend.g> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public com.ss.android.socialbase.downloader.network.y getDownloadDns() {
        return this.downloadDns;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public pl getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public com.ss.android.socialbase.downloader.u.hf getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public x getDownloadSetting() {
        return this.downloadSetting;
    }

    public com.ss.android.socialbase.downloader.network.f getHeadHttpService() {
        return this.headHttpService;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public p getIdGenerator() {
        return this.idGenerator;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public e getMonitorConfig() {
        return this.monitorConfig;
    }

    public j getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public pz getTTNetHandler() {
        return this.ttNetHandler;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public DownloaderBuilder headHttpService(com.ss.android.socialbase.downloader.network.f fVar) {
        this.headHttpService = fVar;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder idGenerator(p pVar) {
        this.idGenerator = pVar;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i) {
        this.maxDownloadPoolSize = i;
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService executorService) {
        this.mixApkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService executorService) {
        this.mixDefaultDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService executorService) {
        this.mixFrequentDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder monitorConfig(e eVar) {
        this.monitorConfig = eVar;
        return this;
    }

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(j jVar) {
        this.notificationClickCallback = jVar;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public DownloaderBuilder ttNetHandler(pz pzVar) {
        this.ttNetHandler = pzVar;
        return this;
    }

    public DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }
}
