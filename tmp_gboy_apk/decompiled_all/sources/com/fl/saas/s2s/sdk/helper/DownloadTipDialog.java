package com.fl.saas.s2s.sdk.helper;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.fl.saas.common.widget.h5.YdH5Activity;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.sdk.helper.DownloadTipDialog;
import com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil;
import com.fl.saas.s2s.sdk.helper.download.DownloadService;
import com.fl.saas.s2s.sdk.util.ApkUtils;
import com.fl.saas.s2s.sdk.widget.DownloadProgressTextView;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DownloadTipDialog extends Dialog {
    public static final String HTML_END = "</body>\n</html>";
    public static final String HTML_HEAD = "<!DOCTYPE html>\n<html id=\"html\">\n<head>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" />\n<meta HTTP-EQUIV=\"pragma\" CONTENT=\"no-cache\">\n</head>\n<body>";
    private DialogUIUpdateReceiver dialogUIUpdateReceiver;
    private String downLoadUrl;
    private String downloadFilePath;
    private int downloadProgress;
    private boolean isDownload;
    private boolean isDownloadSuccess;
    private Context mContext;
    private OnAgreeClickListener mLinstener;
    private View mRootView;
    private DownloadProgressTextView tvConfirm;

    /* renamed from: com.fl.saas.s2s.sdk.helper.DownloadTipDialog$5, reason: invalid class name */
    public class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ AdInfoPoJo val$adInfoPoJo;

        public AnonymousClass5(AdInfoPoJo adInfoPoJo) {
            this.val$adInfoPoJo = adInfoPoJo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() {
            DownloadTipDialog.this.isDownload = true;
            if (DownloadTipDialog.this.mLinstener != null) {
                DownloadTipDialog.this.mLinstener.onClick();
            }
            DownloadTipDialog.this.setProgressText();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DownloadTipDialog.this.isDownloadSuccess) {
                if (TextUtils.isEmpty(DownloadTipDialog.this.downloadFilePath)) {
                    return;
                }
                File file = new File(DownloadTipDialog.this.downloadFilePath);
                if (file.exists()) {
                    ApkUtils.installAPk(DownloadTipDialog.this.mContext, file, this.val$adInfoPoJo);
                    return;
                }
                return;
            }
            if (!"立即下载".equals(DownloadTipDialog.this.tvConfirm.getCurrentText().toString())) {
                Intent intent = new Intent();
                intent.setAction(DownloadTipDialog.this.isDownload ? DownLoadSupportPauseUtil.YD_PAUSE_DOWNLOAD : DownLoadSupportPauseUtil.YD_START_DOWNLOAD);
                intent.putExtra("downLoadUrl", DownloadTipDialog.this.downLoadUrl);
                DownloadTipDialog.this.mContext.sendBroadcast(intent);
                return;
            }
            if (TextUtils.isEmpty(DownloadTipDialog.this.downLoadUrl)) {
                Toast.makeText(DownloadTipDialog.this.mContext, "下载链接为空", 0).show();
                return;
            }
            if (DownloadService.isIntentServiceRunning) {
                DownloadTipDialog.this.mContext.sendBroadcast(new Intent(DownLoadSupportPauseUtil.YD_CANCEL_LAST_DOWNLOAD));
            }
            DeviceUtil.postUIDelayed(100L, new Runnable() { // from class: com.fl.saas.s2s.sdk.helper.A5SV6n
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadTipDialog.AnonymousClass5.this.lambda$onClick$0();
                }
            });
        }
    }

    public class DialogUIUpdateReceiver extends BroadcastReceiver {
        public DialogUIUpdateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (DownLoadSupportPauseUtil.YD_START_DOWNLOAD.equals(action)) {
                    DownloadTipDialog.this.isDownload = true;
                    DownloadTipDialog.this.setProgressText();
                    return;
                }
                if (DownLoadSupportPauseUtil.YD_PAUSE_DOWNLOAD.equals(action)) {
                    DownloadTipDialog.this.isDownload = false;
                    DownloadTipDialog.this.tvConfirm.setState(2);
                    DownloadTipDialog.this.tvConfirm.setCurrentText("继续下载");
                    return;
                }
                if (DownLoadSupportPauseUtil.YD_CANCEL_DOWNLOAD.equals(action)) {
                    DownloadTipDialog.this.dismiss();
                    return;
                }
                if (DownLoadSupportPauseUtil.YD_UPDATE_DOWNLOAD_PROGRESS.equals(action)) {
                    DownloadTipDialog.this.downloadProgress = intent.getIntExtra(PointCategory.PROGRESS, 0);
                    DownloadTipDialog.this.setProgressText();
                } else if (DownLoadSupportPauseUtil.YD_DOWNLOAD_SUCCESS.equals(action)) {
                    DownloadTipDialog.this.isDownloadSuccess = true;
                    DownloadTipDialog.this.tvConfirm.setState(0);
                    DownloadTipDialog.this.tvConfirm.setCurrentText("立即安装");
                    DownloadTipDialog.this.downloadFilePath = intent.getStringExtra("downloadFilePath");
                }
            }
        }
    }

    public interface OnAgreeClickListener {
        void onClick();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DownloadTipDialog(android.content.Context r7, final com.fl.saas.s2s.sdk.helper.AdInfoPoJo r8, com.fl.saas.s2s.sdk.helper.DownloadTipDialog.OnAgreeClickListener r9) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.s2s.sdk.helper.DownloadTipDialog.<init>(android.content.Context, com.fl.saas.s2s.sdk.helper.AdInfoPoJo, com.fl.saas.s2s.sdk.helper.DownloadTipDialog$OnAgreeClickListener):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(AdInfoPoJo adInfoPoJo, View view) {
        YdH5Activity.launch(this.mContext, adInfoPoJo.app_intro_url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(DialogInterface dialogInterface) {
        DialogUIUpdateReceiver dialogUIUpdateReceiver = this.dialogUIUpdateReceiver;
        if (dialogUIUpdateReceiver != null) {
            try {
                this.mContext.unregisterReceiver(dialogUIUpdateReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.dialogUIUpdateReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgressText() {
        this.tvConfirm.setState(1);
        this.tvConfirm.setProgressText("正在下载", this.downloadProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String spliceHtml(AdInfoPoJo adInfoPoJo) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (adInfoPoJo != null) {
            try {
            } catch (Throwable unused) {
                sb = new StringBuilder("<div>暂未获取到权限列表，请稍后再试</div>");
            }
            if (!TextUtils.isEmpty(adInfoPoJo.permission_list)) {
                JSONArray jSONArray = new JSONArray(adInfoPoJo.permission_list);
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("permission_name");
                    String optString2 = optJSONObject.optString("permission_desc");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" <li style=\"padding: 3px 0\">\n <span>");
                    i++;
                    sb3.append(i);
                    sb3.append(".");
                    sb3.append(optString);
                    sb3.append(": ");
                    sb3.append(optString2);
                    sb3.append("</span>\n </li>");
                    sb2.append(sb3.toString());
                }
                sb = new StringBuilder(HTML_HEAD + ((Object) sb2) + HTML_END);
                return sb.toString();
            }
        }
        sb2 = new StringBuilder("<div>暂未获取到权限列表，请稍后再试</div>");
        sb = new StringBuilder(HTML_HEAD + ((Object) sb2) + HTML_END);
        return sb.toString();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DialogUIUpdateReceiver dialogUIUpdateReceiver = this.dialogUIUpdateReceiver;
        if (dialogUIUpdateReceiver != null) {
            try {
                this.mContext.unregisterReceiver(dialogUIUpdateReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.dialogUIUpdateReceiver = null;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            if (this.dialogUIUpdateReceiver == null) {
                this.dialogUIUpdateReceiver = new DialogUIUpdateReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_START_DOWNLOAD);
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_PAUSE_DOWNLOAD);
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_CANCEL_DOWNLOAD);
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_UPDATE_DOWNLOAD_PROGRESS);
                intentFilter.addAction(DownLoadSupportPauseUtil.YD_DOWNLOAD_SUCCESS);
                this.mContext.registerReceiver(this.dialogUIUpdateReceiver, intentFilter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.fl.saas.s2s.sdk.helper.A4TApA
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DownloadTipDialog.this.lambda$show$1(dialogInterface);
            }
        });
    }
}
