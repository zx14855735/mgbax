package com.fl.saas.s2s.sdk.helper;

import android.text.TextUtils;
import android.util.Pair;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CommReportHelper {
    private static CommReportHelper sInstance;

    /* renamed from: com.fl.saas.s2s.sdk.helper.CommReportHelper$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType;

        static {
            int[] iArr = new int[AdInfoPoJo.ClickType.values().length];
            $SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType = iArr;
            try {
                iArr[AdInfoPoJo.ClickType.SHAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType[AdInfoPoJo.ClickType.SLIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType[AdInfoPoJo.ClickType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void doReport(List<String> list, AdInfoPoJo adInfoPoJo) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            AdHttpUtils.getInstance().doGet(gdtReplac(list.get(i), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.1
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                }
            });
        }
    }

    public static CommReportHelper getInstance() {
        if (sInstance == null) {
            synchronized (CommReportHelper.class) {
                sInstance = new CommReportHelper();
            }
        }
        return sInstance;
    }

    private static String replaceMacro(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? str : str.replaceAll(str2, str3);
    }

    private static List<String> replaceMacroForList(List<String> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(replaceMacro(it.next(), str, str2));
        }
        return arrayList;
    }

    @SafeVarargs
    private static String replaceMacros(String str, Pair<String, String>... pairArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        for (Pair<String, String> pair : pairArr) {
            str = replaceMacro(str, (String) pair.first, (String) pair.second);
        }
        return str;
    }

    @SafeVarargs
    private static List<String> replaceMacrosForList(List<String> list, Pair<String, String>... pairArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(replaceMacros(it.next(), pairArr));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x02a8 A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0333 A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x03a2 A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03b1 A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03c0 A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x03cf A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03de A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03ed A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03fc A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x040b A[Catch: Exception -> 0x0476, TryCatch #0 {Exception -> 0x0476, blocks: (B:32:0x0113, B:33:0x0117, B:34:0x012b, B:36:0x02a8, B:37:0x02bf, B:39:0x0333, B:45:0x034d, B:46:0x0345, B:47:0x0348, B:48:0x034b, B:49:0x0353, B:51:0x03a2, B:52:0x03ab, B:54:0x03b1, B:55:0x03ba, B:57:0x03c0, B:58:0x03c9, B:60:0x03cf, B:61:0x03d8, B:63:0x03de, B:64:0x03e7, B:66:0x03ed, B:67:0x03f6, B:69:0x03fc, B:70:0x0405, B:72:0x040b, B:73:0x0414, B:79:0x0126), top: B:14:0x00e4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String gdtReplac(java.lang.String r20, com.fl.saas.s2s.sdk.helper.AdInfoPoJo r21) {
        /*
            Method dump skipped, instructions count: 1143
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.s2s.sdk.helper.CommReportHelper.gdtReplac(java.lang.String, com.fl.saas.s2s.sdk.helper.AdInfoPoJo):java.lang.String");
    }

    public void reportApiBidFail(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        doReport(adInfoPoJo.notice_failed_urls, adInfoPoJo);
    }

    public void reportApiBidSuccess(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        doReport(adInfoPoJo.notice_success_urls, adInfoPoJo);
    }

    public void reportClick(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null || "5".equals(adInfoPoJo.ac_type) || "6".equals(adInfoPoJo.ac_type)) {
            return;
        }
        doReport(replaceMacrosForList(adInfoPoJo.click_notice_urls, Pair.create("__X_MAX_ACC__", String.valueOf(adInfoPoJo.shake_x)), Pair.create("__Y_MAX_ACC__", String.valueOf(adInfoPoJo.shake_y)), Pair.create("__Z_MAX_ACC__", String.valueOf(adInfoPoJo.shake_z))), adInfoPoJo);
    }

    public void reportDeepLink(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        Iterator<String> it = adInfoPoJo.deeplink_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.2
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink requset onError:" + exc.getMessage());
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink requset 302");
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink requset onSuccess");
                }
            });
        }
    }

    public void reportDeepLinkAttempt(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        Iterator<String> it = adInfoPoJo.dp_attempt_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.4
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink attempt requset onError:" + exc.getMessage());
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink attempt requset 302");
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink attempt requset onSuccess");
                }
            });
        }
    }

    public void reportDeepLinkFail(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        Iterator<String> it = adInfoPoJo.dpfail_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.5
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink fail requset onError:" + exc.getMessage());
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink fail requset 302");
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink fail requset onSuccess");
                }
            });
        }
    }

    public void reportDeepLinkInstalled(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        Iterator<String> it = adInfoPoJo.app_installed_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.3
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink installed requset onError:" + exc.getMessage());
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink installed requset 302");
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink installed requset onSuccess");
                }
            });
        }
    }

    public void reportDisplay(AdInfoPoJo adInfoPoJo, boolean z) {
        if (adInfoPoJo == null) {
            return;
        }
        doReport(replaceMacroForList(adInfoPoJo.impress_notice_urls, "__IS_CACHED__", String.valueOf(z ? 1 : 0)), adInfoPoJo);
    }

    public void reportVideoClose(AdInfoPoJo adInfoPoJo, int i) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.closes) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.closes, adInfoPoJo);
    }

    public void reportVideoContinue(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_continue_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_continue_notice_urls, adInfoPoJo);
    }

    public void reportVideoEnd(AdInfoPoJo adInfoPoJo, int i) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.playing_end_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.playing_end_notice_urls, adInfoPoJo);
    }

    public void reportVideoFirst(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_first_quartile_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_first_quartile_notice_urls, adInfoPoJo);
    }

    public void reportVideoInfo(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_view_urls) == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = adInfoPoJo.video_view_urls.iterator();
        while (it.hasNext()) {
            arrayList.add(videoInfoReplac(it.next(), adInfoPoJo));
        }
        doReport(arrayList, adInfoPoJo);
    }

    public void reportVideoMute(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_mute_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_mute_notice_urls, adInfoPoJo);
    }

    public void reportVideoPause(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_pause_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_pause_notice_urls, adInfoPoJo);
    }

    public void reportVideoSkip(AdInfoPoJo adInfoPoJo, int i) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_skip_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_skip_notice_urls, adInfoPoJo);
    }

    public void reportVideoStart(AdInfoPoJo adInfoPoJo, int i) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_start_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_start_notice_urls, adInfoPoJo);
    }

    public void reportVideoThird(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_third_quartile_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_third_quartile_notice_urls, adInfoPoJo);
    }

    public void reportVideomMidpoint(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_midpoint_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_midpoint_notice_urls, adInfoPoJo);
    }

    public String videoInfoReplac(String str, AdInfoPoJo adInfoPoJo) {
        try {
            return str.replaceAll("__BEGIN_TIME__", adInfoPoJo.BEGIN_TIME + "").replaceAll("__END_TIME__", adInfoPoJo.END_TIME + "").replaceAll("__PLAY_FIRST_FRAME__", adInfoPoJo.PLAY_FIRST_FRAME + "").replaceAll("__PLAY_LAST_FRAME__", adInfoPoJo.PLAY_LAST_FRAME + "").replaceAll("__SCENE__", adInfoPoJo.SCENE + "").replaceAll("__TYPE__", adInfoPoJo.TYPE + "").replaceAll("__BEHAVIOR__", adInfoPoJo.BEHAVIOR + "").replaceAll("__STATUS__", adInfoPoJo.STATUS + "");
        } catch (Exception unused) {
            return str;
        }
    }
}
