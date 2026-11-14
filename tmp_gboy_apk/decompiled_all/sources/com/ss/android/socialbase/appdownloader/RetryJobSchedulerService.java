package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.ss.android.socialbase.downloader.impls.yo;

@TargetApi(21)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class RetryJobSchedulerService extends JobService {
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:12:0x002b, B:20:0x004a, B:21:0x0052, B:24:0x0072, B:26:0x0083, B:27:0x0086, B:29:0x0090, B:31:0x0096, B:33:0x00a4, B:35:0x00a9, B:44:0x0040, B:15:0x0037), top: B:11:0x002b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9 A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #0 {all -> 0x00b9, blocks: (B:12:0x002b, B:20:0x004a, B:21:0x0052, B:24:0x0072, B:26:0x0083, B:27:0x0086, B:29:0x0090, B:31:0x0096, B:33:0x00a4, B:35:0x00a9, B:44:0x0040, B:15:0x0037), top: B:11:0x002b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void xj(com.ss.android.socialbase.downloader.model.DownloadInfo r11, long r12, boolean r14, int r15) {
        /*
            if (r11 == 0) goto Lbd
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 > 0) goto La
            goto Lbd
        La:
            android.content.Context r2 = com.ss.android.socialbase.downloader.downloader.w.tj()
            if (r2 != 0) goto L12
            goto Lbd
        L12:
            boolean r3 = r11.isPauseReserveOnWifi()
            r4 = 3
            r5 = 2
            if (r3 == 0) goto L2b
            android.content.Context r3 = com.ss.android.socialbase.downloader.downloader.w.tj()
            com.ss.android.socialbase.downloader.downloader.Downloader r3 = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(r3)
            com.ss.android.socialbase.downloader.downloader.yo r3 = r3.getReserveWifiStatusListener()
            if (r3 == 0) goto L2b
            r3.xj(r11, r5, r4)
        L2b:
            java.lang.String r3 = "jobscheduler"
            java.lang.Object r3 = r2.getSystemService(r3)     // Catch: java.lang.Throwable -> Lb9
            android.app.job.JobScheduler r3 = (android.app.job.JobScheduler) r3     // Catch: java.lang.Throwable -> Lb9
            if (r3 != 0) goto L37
            goto Lbd
        L37:
            int r6 = r11.getId()     // Catch: java.lang.Throwable -> L3f
            r3.cancel(r6)     // Catch: java.lang.Throwable -> L3f
            goto L43
        L3f:
            r6 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r6)     // Catch: java.lang.Throwable -> Lb9
        L43:
            if (r15 == 0) goto L4f
            if (r14 == 0) goto L4a
            if (r15 == r5) goto L4a
            goto L4f
        L4a:
            r6 = 60000(0xea60, double:2.9644E-319)
            long r6 = r6 + r12
            goto L52
        L4f:
            r12 = 1000(0x3e8, double:4.94E-321)
            r6 = r0
        L52:
            android.app.job.JobInfo$Builder r15 = new android.app.job.JobInfo$Builder     // Catch: java.lang.Throwable -> Lb9
            int r8 = r11.getId()     // Catch: java.lang.Throwable -> Lb9
            android.content.ComponentName r9 = new android.content.ComponentName     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Throwable -> Lb9
            java.lang.Class<com.ss.android.socialbase.appdownloader.RetryJobSchedulerService> r10 = com.ss.android.socialbase.appdownloader.RetryJobSchedulerService.class
            java.lang.String r10 = r10.getName()     // Catch: java.lang.Throwable -> Lb9
            r9.<init>(r2, r10)     // Catch: java.lang.Throwable -> Lb9
            r15.<init>(r8, r9)     // Catch: java.lang.Throwable -> Lb9
            android.app.job.JobInfo$Builder r12 = r15.setMinimumLatency(r12)     // Catch: java.lang.Throwable -> Lb9
            if (r14 == 0) goto L71
            goto L72
        L71:
            r5 = 1
        L72:
            android.app.job.JobInfo$Builder r12 = r12.setRequiredNetworkType(r5)     // Catch: java.lang.Throwable -> Lb9
            r13 = 0
            android.app.job.JobInfo$Builder r12 = r12.setRequiresCharging(r13)     // Catch: java.lang.Throwable -> Lb9
            android.app.job.JobInfo$Builder r12 = r12.setRequiresDeviceIdle(r13)     // Catch: java.lang.Throwable -> Lb9
            int r13 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r13 <= 0) goto L86
            r12.setOverrideDeadline(r6)     // Catch: java.lang.Throwable -> Lb9
        L86:
            android.app.job.JobInfo r12 = r12.build()     // Catch: java.lang.Throwable -> Lb9
            int r12 = r3.schedule(r12)     // Catch: java.lang.Throwable -> Lb9
            if (r12 <= 0) goto La7
            boolean r13 = r11.isPauseReserveOnWifi()     // Catch: java.lang.Throwable -> Lb9
            if (r13 == 0) goto La7
            android.content.Context r13 = com.ss.android.socialbase.downloader.downloader.w.tj()     // Catch: java.lang.Throwable -> Lb9
            com.ss.android.socialbase.downloader.downloader.Downloader r13 = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(r13)     // Catch: java.lang.Throwable -> Lb9
            com.ss.android.socialbase.downloader.downloader.yo r13 = r13.getReserveWifiStatusListener()     // Catch: java.lang.Throwable -> Lb9
            if (r13 == 0) goto La7
            r13.xj(r11, r4, r4)     // Catch: java.lang.Throwable -> Lb9
        La7:
            if (r12 > 0) goto Lbd
            java.lang.String r11 = "RetrySchedulerService"
            java.lang.String r13 = "schedule err errCode = "
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r12 = r13.concat(r12)     // Catch: java.lang.Throwable -> Lb9
            com.ss.android.socialbase.downloader.w.xj.u(r11, r12)     // Catch: java.lang.Throwable -> Lb9
            goto Lbd
        Lb9:
            r11 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r11)
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.RetryJobSchedulerService.xj(com.ss.android.socialbase.downloader.model.DownloadInfo, long, boolean, int):void");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.w.xj(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.downloader.w.tf()) {
            return 2;
        }
        return onStartCommand;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        com.ss.android.socialbase.downloader.w.xj.w("RetrySchedulerService", "onStartJob, id = ".concat(String.valueOf(jobId)));
        yo.xj().xj(jobId);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
