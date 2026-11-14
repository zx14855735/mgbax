package com.ss.android.socialbase.appdownloader;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.d.f;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.xj.xj;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    private static w hf = null;
    private static xj w = null;
    private static final String xj = "hf";

    /* renamed from: com.ss.android.socialbase.appdownloader.hf$hf, reason: collision with other inner class name */
    public interface InterfaceC0479hf {
        boolean xj(Context context);
    }

    public static class kd implements f.xj {
        private static int hf;
        public static int xj;
        private final long c;
        private boolean d = false;
        private Future<Boolean> f;
        private final InterfaceC0479hf kd;
        private final Intent u;
        private final Context w;
        private final Handler y;

        public kd(Context context, Intent intent, int i, InterfaceC0479hf interfaceC0479hf, long j) {
            this.w = context;
            this.u = intent;
            hf = i;
            this.kd = interfaceC0479hf;
            this.y = new com.ss.android.socialbase.downloader.d.f(Looper.getMainLooper(), this);
            this.c = j;
        }

        @Override // com.ss.android.socialbase.downloader.d.f.xj
        public void xj(Message message) {
            if (message != null) {
                int i = message.what;
                if (i == 1) {
                    long j = this.c;
                    if (j <= 0 || j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        return;
                    }
                    xj = 1;
                    this.f = com.ss.android.socialbase.downloader.downloader.w.pl().submit(new u(this.y, this.w, this.kd, this.c));
                    return;
                }
                if (i == 2) {
                    xj = 2;
                    this.y.removeMessages(2);
                    this.y.removeMessages(1);
                    Future<Boolean> future = this.f;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.d && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.xj.xj.xj().hf())) {
                        Intent intent = this.u;
                        if (intent != null) {
                            hf.hf(this.w, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.w).getDownloadInfo(hf);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.w.hf(this.w, hf, false);
                            }
                        }
                        this.d = true;
                    }
                    hf.hf(hf, this.u == null, hf.xj(this.w));
                }
            }
        }
    }

    public static class u implements Callable<Boolean> {
        private final InterfaceC0479hf hf;
        private final long u;
        private final Handler w;
        private final Context xj;

        public u(Handler handler, Context context, InterfaceC0479hf interfaceC0479hf, long j) {
            this.xj = context;
            this.hf = interfaceC0479hf;
            this.w = handler;
            this.u = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            InterfaceC0479hf interfaceC0479hf;
            try {
                interfaceC0479hf = this.hf;
            } catch (Throwable unused) {
            }
            if (interfaceC0479hf != null) {
                long j = this.u;
                if (j > 0 && j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    Context context = this.xj;
                    boolean xj = context != null ? interfaceC0479hf.xj(context) : false;
                    Message obtain = Message.obtain();
                    if (xj) {
                        obtain.what = 2;
                        this.w.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.w.sendMessageDelayed(obtain, this.u);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    public interface w {
        void xj(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.xj xjVar);
    }

    public static class xj implements xj.InterfaceC0510xj {
        private final int hf;
        private JSONObject w;
        private final kd xj;

        public xj(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0479hf interfaceC0479hf) {
            this.w = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.hf = optInt;
            this.xj = new kd(context, intent, i, interfaceC0479hf, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
        public void hf() {
            if (!this.xj.d) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.xj.y.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.xj.xj.xj().hf(this);
            xj unused = hf.w = null;
        }

        @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
        public void w() {
            int optInt = this.w.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.xj.y.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.xj.y.sendMessageDelayed(obtain2, optInt * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean kd(Context context) {
        boolean canRequestPackageInstalls;
        if (context == null) {
            return true;
        }
        try {
            canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
            return canRequestPackageInstalls;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean u(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean hf(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.xj xjVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            xjVar.u = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
            com.ss.android.socialbase.appdownloader.xj.xj xj2 = com.ss.android.socialbase.appdownloader.xj.u.xj(context, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, downloadInfo);
            if (xj2 != null && xj2.xj()) {
                Intent hf2 = xj2.hf();
                if (hf2 == null) {
                    return false;
                }
                if (!xj(new File(savePath), downloadInfo, jSONObject)) {
                    xjVar.hf = 6;
                } else {
                    if (hf(context, hf2)) {
                        xjVar.hf = 0;
                        return true;
                    }
                    xjVar.hf = 1;
                }
                return false;
            }
            xjVar.hf = 3;
        }
        return false;
    }

    private static void u(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            pl.xj(e);
        }
        com.ss.android.socialbase.downloader.downloader.w.yy().hf(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static void w(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            pl.xj(e);
        }
        com.ss.android.socialbase.downloader.downloader.w.yy().hf(i, "guide_auth_open_setting", jSONObject2);
    }

    public static boolean xj(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray kd2 = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).kd("ah_plans");
        if (kd2 != null) {
            int length = kd2.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = kd2.optJSONObject(i);
                if (com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONObject) && xj(context, downloadInfo, intent, optJSONObject, z)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean xj(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.hf.xj(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.xj hf(JSONObject jSONObject, com.ss.android.socialbase.downloader.f.xj xjVar) {
        com.ss.android.socialbase.appdownloader.xj xjVar2 = new com.ss.android.socialbase.appdownloader.xj();
        if (jSONObject == null) {
            return xjVar2;
        }
        xjVar2.xj = jSONObject.optString(PointParamKey.TYPE);
        xjVar2.kd = "vbi";
        if (com.ss.android.socialbase.appdownloader.xj.u.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), "vbi", jSONObject, xjVar)) {
            xjVar2.hf = 0;
            return xjVar2;
        }
        xj(xjVar2, 3);
        return xjVar2;
    }

    public static void hf(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            pl.xj(e);
        }
        com.ss.android.socialbase.downloader.downloader.w.yy().hf(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", z ? 1 : 2);
            jSONObject.put("result_code", z2 ? 1 : 2);
        } catch (Exception e) {
            pl.xj(e);
        }
        com.ss.android.socialbase.downloader.downloader.w.yy().hf(i, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hf(Context context, Intent intent) {
        return xj(context, intent, true);
    }

    private static boolean xj(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.xj xjVar, com.ss.android.socialbase.downloader.f.xj xjVar2) {
        boolean z;
        String optString = jSONObject.optString(PointParamKey.TYPE);
        xjVar.xj = optString;
        Intent hf2 = com.ss.android.socialbase.appdownloader.xj.u.xj(context, "vbi", jSONObject, downloadInfo).hf();
        StringBuilder sb = new StringBuilder();
        try {
            z = hf(context, hf2);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(xj(th));
            xj(xjVar, 1);
            z = false;
        }
        if (!z) {
            xjVar.w = sb.toString();
        } else {
            xjVar.hf = 0;
        }
        return true;
    }

    private static boolean xj(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.xj xjVar) {
        String str;
        boolean z;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            xjVar.kd = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        z = false;
                        break;
                    }
                    str = split[i];
                    com.ss.android.socialbase.appdownloader.xj.xj xj2 = com.ss.android.socialbase.appdownloader.xj.u.xj(context, str, jSONObject, downloadInfo);
                    if (xj2 != null) {
                        Intent hf2 = xj2.hf();
                        if (hf2 != null) {
                            if (xj(file, downloadInfo, jSONObject)) {
                                z = true;
                                try {
                                    xj(context, hf2, false);
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str);
                                    sb.append(" startActivity failed : ");
                                    sb.append(xj(th));
                                    xj(xjVar, 1);
                                }
                            } else {
                                xj(xjVar, 6);
                                sb.append(str);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            xj(xjVar, 3);
                            sb.append(str);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z) {
                    xjVar.w = sb.toString();
                } else {
                    xjVar.u = str;
                    xjVar.hf = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static int xj(com.ss.android.socialbase.downloader.f.xj xjVar) {
        if (!(xjVar.u("download_dir") != null ? !TextUtils.isEmpty(r0.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.f.xj.w().xj("get_download_info_by_list")) {
            return 4;
        }
        JSONArray kd2 = xjVar.kd("ah_plans");
        int i = -1;
        if (kd2 != null) {
            int length = kd2.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = kd2.optJSONObject(i2);
                if (com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONObject)) {
                    String optString = optJSONObject.optString(PointParamKey.TYPE);
                    if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                        if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i = hf(optJSONObject, xjVar).hf) == 0)) {
                            return 0;
                        }
                    } else {
                        i = xj(optJSONObject, xjVar).hf;
                        if (i == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i;
    }

    public static com.ss.android.socialbase.appdownloader.xj xj(JSONObject jSONObject, com.ss.android.socialbase.downloader.f.xj xjVar) {
        com.ss.android.socialbase.appdownloader.xj xjVar2 = new com.ss.android.socialbase.appdownloader.xj();
        if (jSONObject != null) {
            String optString = jSONObject.optString(PointParamKey.TYPE);
            xjVar2.xj = optString;
            if ("plan_b".equals(optString)) {
                xjVar2.kd = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
                if (com.ss.android.socialbase.appdownloader.xj.u.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, xjVar)) {
                    xjVar2.hf = 0;
                    return xjVar2;
                }
                xj(xjVar2, 3);
                return xjVar2;
            }
            String optString2 = jSONObject.optString("device_plans");
            xjVar2.kd = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.xj.u.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), str, jSONObject, xjVar)) {
                        xjVar2.hf = 0;
                        return xjVar2;
                    }
                    xj(xjVar2, 3);
                }
            }
        }
        return xjVar2;
    }

    public static com.ss.android.socialbase.appdownloader.xj xj(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.f.xj xjVar) {
        com.ss.android.socialbase.appdownloader.xj xjVar2 = new com.ss.android.socialbase.appdownloader.xj();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.y.kd.w()) {
            xjVar2.xj = jSONObject.optString(PointParamKey.TYPE);
            if (xjVar.xj("bi", 0) == 1) {
                xjVar2.hf = 0;
                return xjVar2;
            }
            if (xj(context)) {
                xjVar2.hf = 2;
                return xjVar2;
            }
            if (com.ss.android.socialbase.appdownloader.y.xj.xj(str) != null) {
                xjVar2.hf = 0;
                return xjVar2;
            }
            xjVar2.hf = 9;
        }
        return xjVar2;
    }

    private static void xj(com.ss.android.socialbase.appdownloader.xj xjVar, int i) {
        int i2 = xjVar.hf;
        if (i2 != -1) {
            xjVar.hf = (i2 * 10) + i;
        } else {
            xjVar.hf = i;
        }
    }

    private static boolean xj(File file, DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject u2 = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).u("download_dir");
        File file2 = null;
        String optString = u2 != null ? u2.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(CtFAbx.B25kr6(AYUAbz.A4TApA(path), File.separator, optString));
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean xj(Context context, Intent intent, JSONObject jSONObject, int i, com.ss.android.socialbase.appdownloader.xj xjVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong("jump_interval", 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences hf2 = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context, "sp_ah_config", 0);
            if ((System.currentTimeMillis() - hf2.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !xj(context)) {
                hf2.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(C.ENCODING_PCM_MU_LAW);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, i);
                    try {
                        if (xj(context, intent2, false)) {
                            u(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (xjVar != null) {
                            xjVar.hf = 1;
                            xjVar.w = "tryShowUnknownSourceDialog" + xj(th);
                        }
                        return false;
                    }
                }
                if (xj(context, intent, i, jSONObject)) {
                    w(i, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean xj(Context context, Intent intent, int i, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.y.kd.w() && Build.VERSION.SDK_INT < 26 && !u(context)) {
                com.ss.android.socialbase.appdownloader.xj.y yVar = new com.ss.android.socialbase.appdownloader.xj.y(context);
                if (yVar.xj()) {
                    xj(context, intent, i, jSONObject, new InterfaceC0479hf() { // from class: com.ss.android.socialbase.appdownloader.hf.1
                        @Override // com.ss.android.socialbase.appdownloader.hf.InterfaceC0479hf
                        public boolean xj(Context context2) {
                            return hf.u(context2);
                        }
                    });
                    return hf(context, yVar.hf());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !kd(context)) {
                com.ss.android.socialbase.appdownloader.xj.hf hfVar = new com.ss.android.socialbase.appdownloader.xj.hf(context);
                if (hfVar.xj()) {
                    xj(context, intent, i, jSONObject, new InterfaceC0479hf() { // from class: com.ss.android.socialbase.appdownloader.hf.2
                        @Override // com.ss.android.socialbase.appdownloader.hf.InterfaceC0479hf
                        public boolean xj(Context context2) {
                            return hf.kd(context2);
                        }
                    });
                    return hf(context, hfVar.hf());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean xj(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.y.kd.w() && Build.VERSION.SDK_INT < 26) {
            return u(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return kd(context);
        }
        return true;
    }

    public static boolean xj() {
        return kd.xj == 1;
    }

    public static void xj(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            pl.xj(e);
        }
        com.ss.android.socialbase.downloader.downloader.w.yy().hf(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void xj(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0479hf interfaceC0479hf) {
        if (w != null) {
            com.ss.android.socialbase.downloader.xj.xj.xj().hf(w);
            w = null;
        }
        w = new xj(context, intent, i, jSONObject, interfaceC0479hf);
        com.ss.android.socialbase.downloader.xj.xj.xj().xj(w);
    }

    public static boolean xj(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String xj(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    public static void xj(w wVar) {
        hf = wVar;
    }
}
