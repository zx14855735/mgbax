package com.fl.saas.s2s.sdk.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.fl.saas.base.widget.YdCommonDialog;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.common.widget.h5.YdH5Activity;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CommJumpHelper {
    private static CommJumpHelper sInstance;
    private DownloadTipDialog downloadTipDialog;

    private CommJumpHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deepLinkJump, reason: merged with bridge method [inline-methods] */
    public void lambda$jump2App$1(Context context, AdInfoPoJo adInfoPoJo) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (adInfoPoJo.deep_url.contains("m.taobao.com")) {
                intent.setFlags(805339136);
            } else {
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
            }
            intent.setData(Uri.parse(adInfoPoJo.deep_url));
            if (DeviceUtil.deviceCanHandleIntent(intent)) {
                CommReportHelper.getInstance().reportDeepLinkInstalled(adInfoPoJo);
            } else {
                adInfoPoJo.dp_reason = 2;
            }
            CommReportHelper.getInstance().reportDeepLinkAttempt(adInfoPoJo);
            context.startActivity(intent);
            CommReportHelper.getInstance().reportDeepLink(adInfoPoJo);
            adInfoPoJo.clickIsDp = "1";
        } catch (Exception e) {
            adInfoPoJo.dp_result = 1;
            if (adInfoPoJo.dp_reason != 2) {
                adInfoPoJo.dp_reason = 3;
            }
            CommReportHelper.getInstance().reportDeepLinkFail(adInfoPoJo);
            YdH5Activity.launchWithEnableQuickApp(context, CommReportHelper.getInstance().gdtReplac(adInfoPoJo.click_url, adInfoPoJo), QuickAppHelper.getInstance().enableQuickApp(adInfoPoJo.place_id));
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gdtClick(Context context, AdInfoPoJo adInfoPoJo, String str) {
        if (context == null || adInfoPoJo == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (adInfoPoJo.ac_type.equals("5")) {
                if (str.contains("qz_gdt=")) {
                    adInfoPoJo.clickId = str.substring(str.indexOf("qz_gdt=") + 7);
                }
                jump2App(context, adInfoPoJo);
            } else if (adInfoPoJo.ac_type.equals("6")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("ret", -1) != 0) {
                        jump2H5(context, adInfoPoJo);
                    } else {
                        adInfoPoJo.clickId = jSONObject.optJSONObject(PointParamKey.DATA).optString("clickid");
                        jumpAndDownload(context, adInfoPoJo);
                    }
                } catch (Throwable unused) {
                    jump2H5(context, adInfoPoJo);
                }
            }
        } catch (Throwable unused2) {
            jump2H5(context, adInfoPoJo);
        }
    }

    public static CommJumpHelper getInstance() {
        if (sInstance == null) {
            synchronized (CommJumpHelper.class) {
                sInstance = new CommJumpHelper();
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startDownload, reason: merged with bridge method [inline-methods] */
    public void lambda$jump2Download$0(Context context, AdInfoPoJo adInfoPoJo) {
        String str = !TextUtils.isEmpty(adInfoPoJo.download_url) ? adInfoPoJo.download_url : adInfoPoJo.click_url;
        CommClickHelper.getInstance().report(context, adInfoPoJo, 4);
        CommClickHelper.getInstance().downloadAPK(context, adInfoPoJo, str);
    }

    private void startGdtClick(final Context context, final AdInfoPoJo adInfoPoJo) {
        List<String> list = adInfoPoJo.click_notice_urls;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = adInfoPoJo.click_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(true, CommReportHelper.getInstance().gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommJumpHelper.1
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    exc.printStackTrace();
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    CommJumpHelper.this.gdtClick(context, adInfoPoJo, str);
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    CommJumpHelper.this.gdtClick(context, adInfoPoJo, str);
                }
            });
        }
    }

    public void dismissDownLoadDialog() {
        try {
            DownloadTipDialog downloadTipDialog = this.downloadTipDialog;
            if (downloadTipDialog == null || !downloadTipDialog.isShowing()) {
                return;
            }
            this.downloadTipDialog.dismiss();
            this.downloadTipDialog = null;
        } catch (Exception e) {
            e.printStackTrace();
            this.downloadTipDialog = null;
        }
    }

    public void jump(Context context, AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        String str = adInfoPoJo.ac_type;
        if (str.equals("1")) {
            jumpAndDownload(context, adInfoPoJo);
            return;
        }
        if (str.equals("5") || str.equals("6")) {
            startGdtClick(context, adInfoPoJo);
            return;
        }
        if (str.equals("3")) {
            jump2App(context, adInfoPoJo);
        } else if (str.equals("7")) {
            jump2MiniProgram(context, adInfoPoJo);
        } else {
            jump2H5(context, adInfoPoJo);
        }
    }

    public void jump2App(Context context, AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(adInfoPoJo.deep_url)) {
                YdH5Activity.launchWithEnableQuickApp(context, CommReportHelper.getInstance().gdtReplac(adInfoPoJo.click_url, adInfoPoJo), QuickAppHelper.getInstance().enableQuickApp(adInfoPoJo.place_id));
                return;
            }
            if (QuickAppHelper.getInstance().enableQuickApp(adInfoPoJo.place_id) || !QuickAppHelper.getInstance().urlIntercept(adInfoPoJo.deep_url)) {
                lambda$jump2App$1(context, adInfoPoJo);
            } else if (QuickAppHelper.getInstance().getQuickAppInterceptionType() == 1) {
                new YdCommonDialog(context).setTitle("跳转提示").setContent("想要打开“快应用”\n是否允许").setCanDismiss(false).setCancelName("拒绝").setSubmitName("允许").setOnSubmitListener(new A2egSU(this, context, adInfoPoJo, 1)).show();
            }
        } catch (Exception e) {
            adInfoPoJo.dp_result = 1;
            if (adInfoPoJo.dp_reason != 2) {
                adInfoPoJo.dp_reason = 3;
            }
            CommReportHelper.getInstance().reportDeepLinkFail(adInfoPoJo);
            YdH5Activity.launchWithEnableQuickApp(context, CommReportHelper.getInstance().gdtReplac(adInfoPoJo.click_url, adInfoPoJo), QuickAppHelper.getInstance().enableQuickApp(adInfoPoJo.place_id));
            e.printStackTrace();
        }
    }

    public void jump2Download(Context context, AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        if (!adInfoPoJo.isShowDownloadDialog || !(context instanceof Activity)) {
            lambda$jump2Download$0(context, adInfoPoJo);
            return;
        }
        DownloadTipDialog downloadTipDialog = new DownloadTipDialog(context, adInfoPoJo, new A2egSU(this, context, adInfoPoJo, 0));
        this.downloadTipDialog = downloadTipDialog;
        downloadTipDialog.show();
    }

    public void jump2H5(Context context, AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        jump2App(context, adInfoPoJo);
    }

    public void jump2MiniProgram(Context context, AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        try {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, adInfoPoJo.wxAppId);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = adInfoPoJo.miniProgramOriginId;
            if (!TextUtils.isEmpty(adInfoPoJo.miniPath) && adInfoPoJo.miniPath.trim().length() > 0) {
                req.path = adInfoPoJo.miniPath;
            }
            req.miniprogramType = 0;
            createWXAPI.sendReq(req);
        } catch (Throwable th) {
            jump2H5(context, adInfoPoJo);
            th.printStackTrace();
        }
    }

    public void jumpAndDownload(Context context, AdInfoPoJo adInfoPoJo) {
        if (context == null || adInfoPoJo == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(adInfoPoJo.deep_url)) {
                jump2Download(context, adInfoPoJo);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (adInfoPoJo.deep_url.contains("m.taobao.com")) {
                intent.setFlags(805339136);
            } else {
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
            }
            intent.setData(Uri.parse(adInfoPoJo.deep_url));
            if (DeviceUtil.deviceCanHandleIntent(intent)) {
                CommReportHelper.getInstance().reportDeepLinkInstalled(adInfoPoJo);
            } else {
                adInfoPoJo.dp_reason = 2;
            }
            CommReportHelper.getInstance().reportDeepLinkAttempt(adInfoPoJo);
            context.startActivity(intent);
            CommReportHelper.getInstance().reportDeepLink(adInfoPoJo);
            adInfoPoJo.clickIsDp = "1";
        } catch (Exception e) {
            adInfoPoJo.dp_result = 1;
            if (adInfoPoJo.dp_reason != 2) {
                adInfoPoJo.dp_reason = 3;
            }
            CommReportHelper.getInstance().reportDeepLinkFail(adInfoPoJo);
            jump2Download(context, adInfoPoJo);
            e.printStackTrace();
        }
    }
}
