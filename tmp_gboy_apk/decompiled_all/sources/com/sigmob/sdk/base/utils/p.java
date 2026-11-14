package com.sigmob.sdk.base.utils;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.czhj.sdk.logger.SigmobLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p {
    public static Long[] a(String str, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return null;
        }
        long downTime = motionEvent.getDownTime();
        long eventTime = motionEvent.getEventTime();
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.uptimeMillis();
        long j = downTime + currentTimeMillis;
        long j2 = eventTime + currentTimeMillis;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        SigmobLogger.d(str, "convertAndLogMotionEventTimes: downTimeAbsolute = " + j + ", downTimeFormatted = " + simpleDateFormat.format(new Date(j)) + ", eventTimeAbsolute = " + j2 + ", eventTimeFormatted = " + simpleDateFormat.format(new Date(j2)), new Object[0]);
        return new Long[]{Long.valueOf(j), Long.valueOf(j2)};
    }
}
