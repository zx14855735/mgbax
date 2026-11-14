package com.kwad.sdk.crash.utils;

import ADYaiT.CtFAbx;
import com.czhj.sdk.common.Constants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class j {
    public static String aP(long j) {
        long j2 = j / 60000;
        long j3 = (j - (60000 * j2)) / 1000;
        return CtFAbx.AlLFFp(j2 < 10 ? CtFAbx.AaHO0E(Constants.FAIL, j2) : String.valueOf(j2), ":", j3 < 10 ? CtFAbx.AaHO0E(Constants.FAIL, j3) : String.valueOf(j3));
    }
}
