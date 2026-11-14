package com.bytedance.msdk.core.hf;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.f.ai;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final ai xj = ai.xj("tt_user_live_day_time", com.bytedance.msdk.core.hf.getContext());
    private static final SimpleDateFormat hf = new SimpleDateFormat("yyyy-MM-dd");
    private static final Calendar w = Calendar.getInstance();

    static {
        MBlXCG();
    }

    private static /* synthetic */ void MBlXCG() {
        char[] charArray = "vzx;rtxp;wzl;f}pyy;_{|Wg|qrp".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 21);
        }
        String str = new String(charArray);
        char[] charArray2 = "vy|{|a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 21);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void c(String str) {
        if (!com.bytedance.msdk.core.hf.hf().wo() || str == null) {
            return;
        }
        String hf2 = hf(str, "_show_current_time_");
        String hf3 = hf(str, "_show_last_time_");
        ai aiVar = xj;
        String hf4 = aiVar.hf("_show_gap_time_day");
        String c = c();
        StringBuilder BChYOn2 = A2egSU.BChYOn("recordSameDayTwoAdIntervalTime curKey:", hf2, ",lastKey :", hf3, ",today:");
        BChYOn2.append(c);
        BChYOn2.append(",recordDate:");
        BChYOn2.append(hf4);
        com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", BChYOn2.toString());
        if (TextUtils.equals(hf4, c)) {
            aiVar.xj(hf3, aiVar.u(hf2));
            aiVar.xj(hf2, System.currentTimeMillis());
        } else {
            aiVar.xj(hf3, 0L);
            aiVar.xj(hf2, System.currentTimeMillis());
            aiVar.xj("_show_gap_time_day", c);
        }
    }

    private static int d(String str) {
        String str2;
        if (str == null) {
            return 0;
        }
        String[] split = str.split("_");
        if (split.length != 2 || (str2 = split[1]) == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    public static long f(String str) {
        if (!com.bytedance.msdk.core.hf.hf().wo() || str == null) {
            return -1L;
        }
        String hf2 = hf(str, "_show_current_time_");
        String hf3 = hf(str, "_show_last_time_");
        ai aiVar = xj;
        if (!TextUtils.equals(aiVar.hf("_show_gap_time_day"), c())) {
            return 0L;
        }
        if (aiVar.u(hf3) == 0) {
            return 0L;
        }
        return Math.round((aiVar.u(hf2) - r5) / 1000);
    }

    public static int hf() {
        if (com.bytedance.msdk.core.hf.hf().wo()) {
            return xj.hf("user_live_times", 0);
        }
        return -1;
    }

    public static void kd(String str) {
        if (!com.bytedance.msdk.core.hf.hf().wo() || str == null) {
            return;
        }
        xj(str, "_click_count_");
    }

    public static int u(String str) {
        if (!com.bytedance.msdk.core.hf.hf().wo() || str == null) {
            return -1;
        }
        return d(xj.hf(hf(str, "_show_count_")));
    }

    public static void w(String str) {
        if (!com.bytedance.msdk.core.hf.hf().wo() || str == null) {
            return;
        }
        xj(str, "_show_count_");
    }

    public static void xj() {
        com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "recordUserLiveDay start => enableDynamicPolicy:" + com.bytedance.msdk.core.hf.hf().wo());
        if (com.bytedance.msdk.core.hf.hf().wo()) {
            long currentTimeMillis = System.currentTimeMillis();
            String c = c();
            com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "当前日期(key)：".concat(String.valueOf(c)));
            ai aiVar = xj;
            if (aiVar.kd(c)) {
                com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "key=" + c + "，同一天，不再重新记录");
                return;
            }
            if (TextUtils.isEmpty(aiVar.hf("start_index"))) {
                aiVar.xj("start_index", c);
                com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "START_INDEX=".concat(String.valueOf(c)));
            }
            aiVar.xj(c, true);
            aiVar.xj("user_live_times", aiVar.hf("user_live_times", 0) + 1);
            String hf2 = aiVar.hf("start_index");
            if (TextUtils.equals(hf2, c)) {
                com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "startDay:" + hf2 + ",key=" + c + "，同一天，不处理");
            } else {
                try {
                    SimpleDateFormat simpleDateFormat = hf;
                    Date parse = simpleDateFormat.parse(hf2);
                    Date parse2 = simpleDateFormat.parse(c);
                    if (parse2 == null) {
                        parse2 = new Date();
                    }
                    if (parse != null) {
                        int xj2 = xj(parse.getTime(), parse2.getTime());
                        int wn = com.bytedance.msdk.core.hf.hf().wn();
                        if (wn - xj2 < 0) {
                            int i = xj2 - wn;
                            String xj3 = xj(parse, i);
                            if (!TextUtils.isEmpty(xj3)) {
                                aiVar.xj("start_index", xj3);
                                xj(hf2, parse, i);
                            }
                            com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "old-startIndex:" + hf2 + ",diff=" + i + ",new-startIndex:" + xj3);
                        }
                    }
                } catch (ParseException e) {
                    com.bytedance.msdk.xj.kd.w.u("AdLoadDynamicParamHandler", "计算生成日期出错：" + e.getMessage());
                }
            }
            com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "recordUserLiveDay方法，执行耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public static int y(String str) {
        if (!com.bytedance.msdk.core.hf.hf().wo() || str == null) {
            return -1;
        }
        return d(xj.hf(hf(str, "_click_count_")));
    }

    public static int hf(String str) {
        if (!com.bytedance.msdk.core.hf.hf().wo() || str == null) {
            return -1;
        }
        return d(xj.hf(hf(str, "_dislike_count_")));
    }

    public static int kd() {
        if (com.bytedance.msdk.core.hf.hf().wo()) {
            return xj(com.bytedance.msdk.core.xj.p().w(), System.currentTimeMillis());
        }
        return -1;
    }

    public static void w() {
        com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "recordSameDaySdkStartTimes start => enableDynamicPolicy:" + com.bytedance.msdk.core.hf.hf().wo());
        if (com.bytedance.msdk.core.hf.hf().wo()) {
            xj((String) null, "tt_sdk_start_count_");
        }
    }

    public static int u() {
        if (com.bytedance.msdk.core.hf.hf().wo()) {
            return d(xj.hf("tt_sdk_start_count_"));
        }
        return -1;
    }

    public static long y() {
        if (!com.bytedance.msdk.core.hf.hf().wo()) {
            return -1L;
        }
        float kd = com.bytedance.msdk.core.xj.p().kd() / 60000.0f;
        if (kd <= 0.0f || kd >= 1.0f) {
            return Math.round(kd);
        }
        return 1L;
    }

    private static String hf(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : CtFAbx.AcNBzu(str, str2);
    }

    private static String c() {
        return hf.format(new Date());
    }

    private static void xj(String str, Date date, int i) {
        if (i == 1) {
            ai aiVar = xj;
            if (aiVar.kd(str)) {
                aiVar.xj("user_live_times", Math.max(aiVar.w("user_live_times") - 1, 0));
            }
            aiVar.y(str);
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            i2++;
            String xj2 = xj(date, i2);
            ai aiVar2 = xj;
            if (aiVar2.kd(xj2)) {
                aiVar2.xj("user_live_times", Math.max(aiVar2.w("user_live_times") - 1, 0));
            }
            aiVar2.y(xj2);
        }
    }

    public static void xj(String str) {
        if (!com.bytedance.msdk.core.hf.hf().wo() || str == null) {
            return;
        }
        xj(str, "_dislike_count_");
    }

    private static void xj(String str, String str2) {
        String hf2 = hf(str, str2);
        String c = c();
        ai aiVar = xj;
        String hf3 = aiVar.hf(hf2);
        com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "saveToSpByAction key:" + hf2 + ",old value:" + hf3);
        int i = 1;
        if (!TextUtils.isEmpty(hf3)) {
            String[] split = hf3.split("_");
            if (split.length == 2) {
                String str3 = split[0];
                if (!TextUtils.isEmpty(str3) && TextUtils.equals(c, str3)) {
                    i = 1 + Integer.parseInt(split[1]);
                    c = str3;
                }
                hf3 = xj(c, i);
            }
            com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "saveToSpByAction key:" + hf2 + "，new value：" + hf3);
            aiVar.xj(hf2, hf3);
            return;
        }
        aiVar.xj(hf2, xj(c, 1));
        com.bytedance.msdk.xj.kd.w.hf("AdLoadDynamicParamHandler", "saveToSpByAction 首次记录 key:" + hf2 + "，new value：" + xj(c, 1));
    }

    private static String xj(String str, int i) {
        return str + "_" + i;
    }

    private static int xj(long j, long j2) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        ZonedDateTime atZone;
        LocalDate localDate;
        Instant ofEpochMilli2;
        ZoneId systemDefault2;
        ZonedDateTime atZone2;
        LocalDate localDate2;
        Period between;
        int days;
        if (Build.VERSION.SDK_INT >= 26) {
            ofEpochMilli = Instant.ofEpochMilli(j);
            systemDefault = ZoneOffset.systemDefault();
            atZone = ofEpochMilli.atZone(systemDefault);
            localDate = atZone.toLocalDate();
            ofEpochMilli2 = Instant.ofEpochMilli(j2);
            systemDefault2 = ZoneOffset.systemDefault();
            atZone2 = ofEpochMilli2.atZone(systemDefault2);
            localDate2 = atZone2.toLocalDate();
            between = Period.between(localDate, localDate2);
            days = between.getDays();
            return days;
        }
        return (int) ((j2 - j) / 86400000);
    }

    private static String xj(Date date, int i) {
        if (date == null) {
            return null;
        }
        Calendar calendar = w;
        calendar.setTime(date);
        calendar.add(5, i);
        return hf.format(calendar.getTime());
    }

    public static void xj(List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.core.tf.hf hfVar) {
        if (!com.bytedance.msdk.core.hf.hf().wo() || list == null || hfVar == null) {
            return;
        }
        for (com.bytedance.msdk.hf.w wVar : list) {
            if (wVar != null) {
                wVar.q().put(MediationConstant.KEY_GM_PRIME_RIT, hfVar.ff());
            }
        }
    }
}
