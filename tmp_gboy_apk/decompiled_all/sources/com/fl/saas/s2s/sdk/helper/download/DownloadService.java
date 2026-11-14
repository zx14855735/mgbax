package com.fl.saas.s2s.sdk.helper.download;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil;
import com.fl.saas.s2s.sdk.util.CommConstant;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.services.f;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DownloadService extends IntentService {
    public static boolean isIntentServiceRunning;
    private String downloadUrl;
    private boolean haveComplete;

    public DownloadService() {
        super(f.d);
        this.downloadUrl = "";
        this.haveComplete = false;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        isIntentServiceRunning = false;
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        isIntentServiceRunning = true;
        if (intent != null) {
            AdInfoPoJo adInfoPoJo = (AdInfoPoJo) intent.getSerializableExtra(CommConstant.DownloadConstants.REPORT_POJO);
            if (adInfoPoJo != null) {
                this.downloadUrl = !TextUtils.isEmpty(adInfoPoJo.download_url) ? adInfoPoJo.download_url : adInfoPoJo.click_url;
                new DownLoadSupportPauseUtil(this, adInfoPoJo, new DownLoadSupportPauseUtil.IProgress() { // from class: com.fl.saas.s2s.sdk.helper.download.DownloadService.1
                    @Override // com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.IProgress
                    public void onCancel() {
                        DownloadService.this.haveComplete = true;
                    }

                    @Override // com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.IProgress
                    public void onProgress(int i) {
                        Intent intent2 = new Intent();
                        intent2.setAction(DownLoadSupportPauseUtil.YD_UPDATE_DOWNLOAD_PROGRESS);
                        intent2.putExtra(PointCategory.PROGRESS, i);
                        DownloadService.this.sendBroadcast(intent2);
                    }

                    @Override // com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.IProgress
                    public void onSuccess(File file) {
                        DownloadService.this.haveComplete = true;
                        if (file != null) {
                            Intent intent2 = new Intent();
                            intent2.setAction(DownLoadSupportPauseUtil.YD_DOWNLOAD_SUCCESS);
                            intent2.putExtra("downloadFilePath", file.getAbsolutePath());
                            DownloadService.this.sendBroadcast(intent2);
                        }
                    }
                }).start();
            }
            while (!this.haveComplete) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
