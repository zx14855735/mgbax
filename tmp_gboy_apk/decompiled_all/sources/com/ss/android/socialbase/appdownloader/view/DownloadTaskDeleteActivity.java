package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.w.g;
import com.ss.android.socialbase.appdownloader.w.kd;
import com.ss.android.socialbase.appdownloader.w.pl;
import com.ss.android.socialbase.appdownloader.w.u;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.tf.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private Intent hf;
    private pl xj;

    private void hf() {
        Intent intent;
        final boolean z = true;
        if (this.xj != null || (intent = this.hf) == null) {
            return;
        }
        try {
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                com.bytedance.sdk.component.utils.pl.hf("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String format = String.format(getString(d.xj(this, "tt_appdownloader_notification_download_delete")), title);
            u hf = com.ss.android.socialbase.appdownloader.u.p().hf();
            g xj = hf != null ? hf.xj(this) : null;
            if (xj == null) {
                xj = new com.ss.android.socialbase.appdownloader.u.xj(this);
            }
            int xj2 = d.xj(this, "tt_appdownloader_tip");
            int xj3 = d.xj(this, "tt_appdownloader_label_ok");
            int xj4 = d.xj(this, "tt_appdownloader_label_cancel");
            if (com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("cancel_with_net_opt", 0) != 1 || !y.f() || downloadInfo.getCurBytes() == downloadInfo.getTotalBytes()) {
                z = false;
            }
            if (z) {
                xj3 = d.xj(this, "tt_appdownloader_label_reserve_wifi");
                xj4 = d.xj(this, "tt_appdownloader_label_cancel_directly");
                format = getResources().getString(d.xj(this, "tt_appdownloader_resume_in_wifi"));
            }
            xj.xj(xj2).xj(format).xj(xj3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (z) {
                        downloadInfo.setOnlyWifi(true);
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                            }
                        }, 100L);
                    } else {
                        DownloadTaskDeleteActivity.this.xj(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).hf(xj4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (z) {
                        DownloadTaskDeleteActivity.this.xj(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).xj(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadTaskDeleteActivity.this.finish();
                }
            });
            this.xj = xj.xj();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xj();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.hf = getIntent();
        hf();
        pl plVar = this.xj;
        if (plVar != null && !plVar.hf()) {
            this.xj.xj();
        } else if (this.xj == null) {
            finish();
        }
    }

    private void xj() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(DownloadInfo downloadInfo, int i) {
        kd w = com.ss.android.socialbase.appdownloader.u.p().w();
        if (w != null) {
            w.xj(downloadInfo);
        }
        io downloadNotificationEventListener = Downloader.getInstance(w.tj()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.xj(10, downloadInfo, "", "");
        }
        if (w.tj() != null) {
            Downloader.getInstance(w.tj()).cancel(i);
        }
    }
}
