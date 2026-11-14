package com.bytedance.sdk.openadsdk.core.pl.w.hf;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.a.io;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ht;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pl.d;
import com.bytedance.sdk.openadsdk.core.pl.w.w.w;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.kd;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.zg.u;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(final Map<String, Object> map, ws wsVar) {
        d.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.3
            @Override // java.lang.Runnable
            public void run() {
                if (f.zg().r() != null) {
                    f.zg().r().apply(A2egSU.AZOQYO(12, Boolean.class).xj(0, map).hf());
                }
            }
        }, wsVar);
    }

    public static void xj(String str, String str2, ws wsVar, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null) {
            return;
        }
        if (wsVar == null) {
            xj(true, r, str2, wsVar, jSONObject, str, "", null, i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xj(true, r, str2, wsVar, jSONObject, str, "", null, i);
            return;
        }
        String fh = wsVar.fh();
        if (TextUtils.isEmpty(fh) && wsVar.ut() != null) {
            fh = wsVar.ut().g();
        }
        xj(false, r, str2, wsVar, jSONObject, str, "", fh, i);
    }

    public static void hf(int i, int i2) {
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null) {
            return;
        }
        r.apply(u.xj().xj(30).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(i2)).xj("downloadScene", Integer.valueOf(i))).hf());
    }

    public static void xj(String str, ws wsVar, JSONObject jSONObject, int i) {
        String str2;
        String str3;
        String str4;
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null) {
            return;
        }
        if (wsVar == null) {
            xj(true, r, str, wsVar, jSONObject, null, null, null, i);
            return;
        }
        kd vh = wsVar.vh();
        if (vh != null) {
            String hf = vh.hf();
            String w = vh.w();
            str4 = vh.u();
            str2 = hf;
            str3 = w;
        } else {
            str2 = "";
            str3 = str2;
            str4 = str3;
        }
        xj(false, r, str, wsVar, jSONObject, str2, str3, str4, i);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:9|(3:10|11|12)|(2:13|14)|15|(1:17)(1:58)|18|19|20|(1:22)(1:56)|23|(2:52|53)|25|26|(3:27|(1:29)(2:46|(1:48))|30)|31|(3:33|(2:40|(1:42)(1:43))|37)(1:44)|38|39) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0116, code lost:
    
        r21 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e2 A[Catch: JSONException -> 0x00ef, TRY_ENTER, TryCatch #4 {JSONException -> 0x00ef, blocks: (B:29:0x00e2, B:30:0x0109, B:46:0x00f1, B:48:0x00fb), top: B:27:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f1 A[Catch: JSONException -> 0x00ef, TryCatch #4 {JSONException -> 0x00ef, blocks: (B:29:0x00e2, B:30:0x0109, B:46:0x00f1, B:48:0x00fb), top: B:27:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void xj(boolean r19, java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r20, java.lang.String r21, com.bytedance.sdk.openadsdk.core.ra.ws r22, org.json.JSONObject r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, int r27) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(boolean, java.util.function.Function, java.lang.String, com.bytedance.sdk.openadsdk.core.ra.ws, org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    public static void xj(ws wsVar, int i, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null) {
            return;
        }
        int u = jk.u(wsVar);
        int kd = jk.kd(wsVar);
        if (wsVar != null && (!TextUtils.isEmpty(wsVar.lp()) || z)) {
            kd = 2;
        }
        if (wsVar == null || wsVar.wx() == null) {
            z2 = false;
            z3 = false;
            z4 = false;
        } else {
            z3 = wsVar.wx().xj();
            z2 = wsVar.wx().hf();
            z4 = true;
        }
        r.apply(u.xj().xj(25).xj(Void.class).xj(0, new en().xj("autoOpen", Integer.valueOf(u)).xj("downloadMode", Integer.valueOf(kd)).xj("isHaveDownloadSdkConfig", Boolean.valueOf(z4)).xj("hashCode", Integer.valueOf(i)).xj("isEnableAH", Boolean.valueOf(z3)).xj("isEnableAM", Boolean.valueOf(z2))).hf());
    }

    public static void xj(int i, int i2) {
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null) {
            return;
        }
        r.apply(u.xj().xj(26).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(i2)).xj("downloadMode", Integer.valueOf(i))).hf());
    }

    public static void xj(boolean z, int i) {
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null) {
            return;
        }
        r.apply(u.xj().xj(31).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(i)).xj("isShowToast", Boolean.valueOf(z))).hf());
    }

    public static int xj(Function<SparseArray<Object>, Object> function, int i) {
        Object apply;
        if (function != null) {
            apply = function.apply(u.xj().xj(27).xj(Integer.class).xj(0, new en().xj("hashCode", Integer.valueOf(i))).hf());
            if (apply != null) {
                return ((Integer) apply).intValue();
            }
        }
        return 0;
    }

    public static void xj(boolean z, com.bytedance.sdk.openadsdk.core.pl.xj.u uVar, int i) {
        try {
            Function<SparseArray<Object>, Object> r = f.zg().r();
            if (r == null) {
                return;
            }
            r.apply(u.xj().xj(28).xj(Void.class).xj(0, new en().xj("isEnableOppoAutoDownload", Boolean.valueOf(z)).xj("hashCode", Integer.valueOf(i)).xj("downloadMarketInterceptor", com.bytedance.sdk.openadsdk.zg.w.u.xj(uVar))).hf());
        } catch (Throwable th) {
            pl.w("xgc_dof", "throwable", th);
        }
    }

    public static void xj(com.bytedance.sdk.openadsdk.core.pl.xj.u uVar, int i) {
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null) {
            return;
        }
        r.apply(u.xj().xj(MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(i)).xj("downloadMarketInterceptor", com.bytedance.sdk.openadsdk.zg.w.u.xj(uVar))).hf());
    }

    public static void xj(String str, String str2, String str3, String str4, int i, int i2, Bitmap bitmap, String str5, String str6, String str7) {
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null) {
            return;
        }
        r.apply(u.xj().xj(160).xj(Void.class).xj(0, new en().xj("install_app_name", str).xj("install_icon_bitmap", bitmap).xj("install_action_type", str4).xj("install_click_type", Integer.valueOf(i2)).xj("install_enable_target_34", Boolean.valueOf(Build.VERSION.SDK_INT >= 31 && pz.hf().mq() > 0)).xj("install_package_name", str5).xj("install_tag", str6).xj("install_value", str7).xj("install_log_extra", str3).xj("install_download_id", Integer.valueOf(i))).hf());
    }

    public static com.bytedance.sdk.openadsdk.core.pl.xj.u xj(ws wsVar, final boolean z) {
        if (wsVar == null) {
            return null;
        }
        String ke = wsVar.ke();
        if (!TextUtils.isEmpty(ke) && ai.w >= 6400) {
            final String zf = wsVar.zf();
            final String jq = wsVar.jq();
            final com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar = (com.bytedance.sdk.openadsdk.zg.w.xj.hf) ht.xj(ke, com.bytedance.sdk.openadsdk.zg.w.xj.hf.class);
            if (hfVar != null && !TextUtils.isEmpty(wsVar.lp()) && wsVar.kc().u() == 1) {
                return new com.bytedance.sdk.openadsdk.core.pl.xj.u() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.1
                    @Override // com.ss.android.download.api.config.DownloadMarketInterceptor
                    public Map<String, Object> interceptObmMarket(Map<String, Object> map) {
                        if (map == null) {
                            am xj = am.xj();
                            Boolean bool = Boolean.FALSE;
                            xj.xj(bool, bool, "param is null", zf, jq);
                            return map;
                        }
                        if (!z) {
                            map.put("is_button", Boolean.FALSE);
                        }
                        Object obj = map.get("is_button");
                        hfVar.xj(100, map);
                        hf.xj(map, obj, zf, jq);
                        return map;
                    }
                };
            }
            pl.xj("dof", "bridge something invalid");
        }
        return null;
    }

    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(BaseConstants.SCHEME_MARKET) || str.startsWith("mimarket")) {
            return io.zg();
        }
        return false;
    }

    public static boolean xj(Uri uri, ws wsVar, Context context, String str, int i) {
        if (f.zg().r() == null || wsVar == null) {
            return false;
        }
        xj(str, wsVar, (JSONObject) null, i);
        xj(wsVar, i, false);
        xj(str, i);
        en<String, Object> xj = new en().xj("hashCode", Integer.valueOf(i)).xj(ContentProviderManager.PROVIDER_URI, uri);
        w wVar = new w(context, wsVar);
        wVar.xj(new com.bytedance.sdk.openadsdk.core.pl.w.w.kd());
        if (xj(wsVar, str, xj, wVar)) {
            return true;
        }
        hf(xj, wsVar);
        return true;
    }

    private static boolean xj(final ws wsVar, String str, final Map<String, Object> map, w wVar) {
        if (!wVar.u(false)) {
            return false;
        }
        wVar.xj(str, new com.bytedance.sdk.openadsdk.core.pl.w.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.2
            @Override // com.bytedance.sdk.openadsdk.core.pl.w.xj.hf
            public void xj() {
                hf.hf((Map<String, Object>) map, wsVar);
            }
        });
        return true;
    }

    public static void xj(Map<String, Object> map, Object obj, String str, String str2) {
        Object obj2 = map.get("convert_result");
        if (obj2 != null) {
            am.xj().xj(obj, obj2, cb.o, str, str2);
            return;
        }
        am xj = am.xj();
        Boolean bool = Boolean.FALSE;
        xj.xj(bool, bool, "no intercept result", str, str2);
    }

    public static void xj(String str, int i) {
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null) {
            return;
        }
        r.apply(u.xj().xj(29).xj(Void.class).xj(0, new en().xj("clickButtonTag", str).xj("clickItemTag", str).xj("hashCode", Integer.valueOf(i)).xj("clickStartLabel", "click_start").xj("clickContinueLabel", "click_continue").xj("clickPauseLabel", "click_pause").xj("storageDenyLabel", PointCategory.DOWNLOAD_FAILED).xj("clickInstallLabel", "click_install").xj("isEnableClickEvent", Boolean.TRUE).xj("isEnableV3Event", Boolean.FALSE)).hf());
    }

    public static void xj(String str, String str2, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> r = f.zg().r();
        if (r == null || jSONObject == null) {
            return;
        }
        r.apply(u.xj().xj(29).xj(Void.class).xj(0, new en().xj("clickButtonTag", str).xj("clickItemTag", str2).xj("clickStartLabel", "click_start").xj("clickContinueLabel", "click_continue").xj("clickPauseLabel", "click_pause").xj("storageDenyLabel", PointCategory.DOWNLOAD_FAILED).xj("clickInstallLabel", "click_install").xj("isEnableClickEvent", Boolean.TRUE).xj("hashCode", Integer.valueOf(i)).xj("isEnableV3Event", Boolean.FALSE).xj("extraEventObject", jSONObject)).hf());
    }

    public static void xj(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar) {
        if (ai.w < 4400 || map == null || hfVar == null || map.get("downloadButtonClickListener") != null) {
            return;
        }
        map.put("downloadButtonClickListener", com.bytedance.sdk.openadsdk.zg.w.u.xj(hfVar));
    }
}
