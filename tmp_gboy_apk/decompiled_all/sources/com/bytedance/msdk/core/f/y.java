package com.bytedance.msdk.core.f;

import ADYaiT.CtFAbx;
import com.kuaishou.weapon.p0.bi;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    public static String hf(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    public static long xj(long j) {
        Date date = new Date();
        return xj((j < bi.s ? date.getMinutes() <= 30 ? new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 0, 0) : new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 30, 0) : new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 0, 0)).getTime(), j);
    }

    private static long xj(long j, long j2) {
        Date date = new Date(j2 + j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("old time ", j, " new time = ");
        B2KMhB2.append(simpleDateFormat.format(date));
        B2KMhB2.append(" 毫秒 = ");
        B2KMhB2.append(time);
        com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_IntervalEffectiveTime", B2KMhB2.toString());
        return time;
    }
}
