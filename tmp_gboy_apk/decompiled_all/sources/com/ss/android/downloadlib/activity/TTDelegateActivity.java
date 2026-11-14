package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.config.pz;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.hf;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.xj.hf;
import com.ss.android.downloadlib.addownload.hf.y;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.addownload.qt;
import com.ss.android.downloadlib.addownload.xj.kd;
import com.ss.android.downloadlib.c.f;
import com.ss.android.downloadlib.c.g;
import com.ss.android.downloadlib.guide.install.xj;
import com.ss.android.downloadlib.tf;
import com.ss.android.socialbase.appdownloader.w;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class TTDelegateActivity extends Activity {
    private static xj u;
    private boolean hf;
    private hf w;
    protected Intent xj = null;

    public static void hf(String str, com.ss.android.downloadad.api.xj.xj xjVar) {
        Intent w = w(xjVar);
        w.addFlags(C.ENCODING_PCM_MU_LAW);
        w.putExtra(PointParamKey.TYPE, 11);
        w.putExtra(n.p, str);
        if (pl.getContext() != null) {
            pl.getContext().startActivity(w);
        }
    }

    private static Intent w(com.ss.android.downloadad.api.xj.xj xjVar) {
        return new Intent(pl.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void xj(String str, String[] strArr) {
        Intent intent = new Intent(pl.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (pl.getContext() != null) {
            pl.getContext().startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hf();
        this.xj = getIntent();
        pl.hf(this);
        xj();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.xj = intent;
        pl.hf(this);
        xj();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        pl.kd().xj(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        hf hfVar;
        super.onStop();
        if (!this.hf || (hfVar = this.w) == null) {
            return;
        }
        DownloadInfo xj = !TextUtils.isEmpty(hfVar.gy()) ? tf.xj(pl.getContext()).xj(this.w.gy(), null, true) : tf.xj(pl.getContext()).hf(this.w.xj());
        if (xj == null || xj.getCurBytes() < xj.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void w() {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.w():void");
    }

    public static void hf(String str, long j, String str2) {
        Intent intent = new Intent(pl.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 14);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (pl.getContext() != null) {
            pl.getContext().startActivity(intent);
        }
    }

    public static void xj(String str, com.ss.android.downloadad.api.xj.xj xjVar) {
        Intent w = w(xjVar);
        w.addFlags(C.ENCODING_PCM_MU_LAW);
        w.putExtra(PointParamKey.TYPE, 2);
        w.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        if (pl.getContext() != null) {
            pl.getContext().startActivity(w);
        }
    }

    public static void xj(com.ss.android.downloadad.api.xj.xj xjVar) {
        Intent w = w(xjVar);
        w.addFlags(C.ENCODING_PCM_MU_LAW);
        w.putExtra(PointParamKey.TYPE, 4);
        w.putExtra("model_id", xjVar.hf());
        if (pl.getContext() != null) {
            pl.getContext().startActivity(w);
        }
    }

    public static void hf(com.ss.android.downloadad.api.xj.xj xjVar) {
        xj(xjVar, 5, "", "", "", "");
    }

    public static void hf(com.ss.android.downloadad.api.xj.xj xjVar, String str, String str2, String str3) {
        xj(xjVar, 7, str, str2, str3, "");
    }

    public static void hf(com.ss.android.downloadad.api.xj.xj xjVar, String str, String str2, String str3, String str4) {
        xj(xjVar, 20, str, str2, str3, str4);
    }

    private void hf() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void xj(com.ss.android.downloadad.api.xj.xj xjVar, xj xjVar2) {
        Intent w = w(xjVar);
        w.addFlags(C.ENCODING_PCM_MU_LAW);
        w.putExtra(PointParamKey.TYPE, 9);
        u = xjVar2;
        if (pl.getContext() != null) {
            pl.getContext().startActivity(w);
        }
    }

    private void hf(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            pz pzVar = new pz() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
                private WeakReference<Activity> w;

                {
                    this.w = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.pz
                public void xj() {
                    com.ss.android.downloadlib.c.tf.xj(str);
                    w.xj(this.w.get());
                }

                @Override // com.ss.android.download.api.config.pz
                public void xj(String str2) {
                    com.ss.android.downloadlib.c.tf.xj(str, str2);
                    w.xj(this.w.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    pl.kd().xj(this, strArr, pzVar);
                    return;
                } catch (Exception e) {
                    pl.jk().xj(e, "requestPermission");
                }
            }
            pzVar.xj();
            return;
        }
        w.xj((Activity) this);
    }

    public static void xj(long j) {
        Intent intent = new Intent(pl.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 10);
        intent.putExtra("app_info_id", j);
        if (pl.getContext() != null) {
            pl.getContext().startActivity(intent);
        }
    }

    private void hf(String str) {
        Intent c = g.c(this, str);
        if (c == null) {
            return;
        }
        try {
            c.addFlags(C.ENCODING_PCM_MU_LAW);
            c.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(c);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        } finally {
            w.xj((Activity) this);
        }
    }

    public static void xj(String str, long j, String str2, JSONObject jSONObject) {
        Intent intent = new Intent(pl.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 12);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (pl.getContext() != null) {
            pl.getContext().startActivity(intent);
        }
    }

    private void hf(long j) {
        final hf u2 = y.xj().u(j);
        if (u2 == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("showOpenAppDialogInner nativeModel null");
            w.xj((Activity) this);
        } else {
            pl.w().hf(new hf.xj(this).xj("已安装完成").hf(String.format("%1$s已安装完成，是否立即打开？", TextUtils.isEmpty(u2.eu()) ? "刚刚下载的应用" : u2.eu())).w("打开").u("取消").xj(false).xj(g.u(this, u2.kd())).xj(new hf.InterfaceC0464hf() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
                @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
                public void hf(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.u.xj.xj().hf("market_openapp_cancel", u2);
                    TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                    if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                        dialogInterface.dismiss();
                    }
                    w.xj((Activity) TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
                public void w(DialogInterface dialogInterface) {
                    w.xj((Activity) TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
                public void xj(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.hf.xj.hf(u2);
                    TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                    if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                        dialogInterface.dismiss();
                    }
                    w.xj((Activity) TTDelegateActivity.this);
                }
            }).xj(2).xj());
            com.ss.android.downloadlib.u.xj.xj().hf("market_openapp_window_show", u2);
        }
    }

    public static void xj(String str, long j, String str2) {
        Intent intent = new Intent(pl.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 13);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        intent.putExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT, str2);
        if (pl.getContext() != null) {
            pl.getContext().startActivity(intent);
        }
    }

    public static void xj(String str, long j) {
        Intent intent = new Intent(pl.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 15);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        if (pl.getContext() != null) {
            pl.getContext().startActivity(intent);
        }
    }

    private void w(long j) {
        new com.ss.android.downloadlib.addownload.compliance.xj(this, j).show();
    }

    public static void xj(Context context, String str, long j) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 16);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public static void xj(com.ss.android.downloadad.api.xj.xj xjVar, String str) {
        xj(xjVar, 19, "", "", "", str);
    }

    public static void xj(com.ss.android.downloadad.api.xj.xj xjVar, String str, String str2, String str3) {
        xj(xjVar, 8, str, str2, str3, "");
    }

    public static void xj(com.ss.android.downloadad.api.xj.xj xjVar, String str, String str2, String str3, String str4) {
        xj(xjVar, 21, str, str2, str3, str4);
    }

    private static void xj(com.ss.android.downloadad.api.xj.xj xjVar, int i, String str, String str2, String str3, String str4) {
        Intent w = w(xjVar);
        w.addFlags(C.ENCODING_PCM_MU_LAW);
        w.putExtra(PointParamKey.TYPE, i);
        if (!TextUtils.isEmpty(str2)) {
            w.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            w.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            w.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            w.putExtra("message_text", str);
        }
        w.putExtra("model_id", xjVar.hf());
        if (pl.getContext() != null) {
            pl.getContext().startActivity(w);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void xj() {
        TTDelegateActivity tTDelegateActivity;
        Intent intent = this.xj;
        if (intent != null) {
            switch (intent.getIntExtra(PointParamKey.TYPE, 0)) {
                case 1:
                    tTDelegateActivity = this;
                    hf(tTDelegateActivity.xj.getStringExtra("permission_id_key"), tTDelegateActivity.xj.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    tTDelegateActivity = this;
                    xj(tTDelegateActivity.xj.getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    tTDelegateActivity = this;
                    w.xj((Activity) this);
                    break;
                case 4:
                    tTDelegateActivity = this;
                    hf(tTDelegateActivity.xj.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    tTDelegateActivity = this;
                    xj(tTDelegateActivity.xj.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    tTDelegateActivity = this;
                    w();
                    break;
                case 9:
                    tTDelegateActivity = this;
                    xj xjVar = u;
                    if (xjVar != null) {
                        xjVar.xj();
                    }
                    w.xj((Activity) this);
                    break;
                case 10:
                    tTDelegateActivity = this;
                    w(tTDelegateActivity.xj.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    tTDelegateActivity = this;
                    hf(tTDelegateActivity.xj.getStringExtra(n.p));
                    break;
                case 12:
                    tTDelegateActivity = this;
                    f.xj(tTDelegateActivity, this.xj.getStringExtra(n.p), this.xj.getLongExtra("model_id", 0L), this.xj.getStringExtra("param"), this.xj.getStringExtra("ext_json"));
                    w.xj((Activity) this);
                    break;
                case 13:
                    f.xj(this, this.xj.getStringExtra(n.p), this.xj.getLongExtra("model_id", 0L), this.xj.getStringExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT));
                    tTDelegateActivity = this;
                    w.xj((Activity) this);
                    break;
                case 14:
                    f.hf(this, this.xj.getStringExtra(n.p), this.xj.getLongExtra("model_id", 0L), this.xj.getStringExtra("market_app_id"));
                    tTDelegateActivity = this;
                    w.xj((Activity) this);
                    break;
                case 15:
                    f.xj(this, this.xj.getStringExtra(n.p), this.xj.getLongExtra("model_id", 0L));
                    tTDelegateActivity = this;
                    w.xj((Activity) this);
                    break;
                case 16:
                    f.hf(this, this.xj.getStringExtra(n.p), this.xj.getLongExtra("model_id", 0L));
                    tTDelegateActivity = this;
                    w.xj((Activity) this);
                    break;
                case 19:
                    xj(this.xj.getLongExtra("model_id", 0L), this.xj.getStringExtra("delete_button_text"));
                    tTDelegateActivity = this;
                    break;
            }
            tTDelegateActivity.xj = null;
        }
    }

    private void xj(long j, String str) {
        if (qt.xj() == null) {
            return;
        }
        com.ss.android.downloadad.api.xj.hf u2 = y.xj().u(j);
        if (u2 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(u2.v());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - u2.dc()));
                jSONObject.putOpt("click_download_size", Long.valueOf(u2.wn()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / BaseConstants.MB_VALUE)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / BaseConstants.MB_VALUE)));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.u.xj.xj().xj("cancel_pause_reserve_wifi_dialog_show", jSONObject, u2);
            } else {
                com.ss.android.downloadlib.u.xj.xj().hf("pause_reserve_wifi_dialog_show", jSONObject, u2);
            }
        }
        kd.xj xj = new kd.xj(this).xj(false).xj(qt.xj());
        if (!TextUtils.isEmpty(str)) {
            xj.u(str).xj(qt.hf());
        }
        xj.xj().show();
        this.hf = true;
        this.w = u2;
    }

    private void xj(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                w.xj((Activity) this);
                return;
            }
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                if (com.ss.android.socialbase.downloader.f.xj.w().xj("fix_app_link_flag")) {
                    intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(intent);
                w.xj((Activity) this);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
                w.xj((Activity) this);
            }
        } catch (Throwable th) {
            w.xj((Activity) this);
            throw th;
        }
    }
}
