package com.kwad.sdk.utils;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class t {
    public static int a(long j, long j2, boolean z, int i) {
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("soFarBytes:", j, " totalBytes:");
        B2KMhB2.append(j2);
        B2KMhB2.append(" isShowOptimizedProgress: ");
        B2KMhB2.append(z);
        B2KMhB2.append(" optimizeMethod: ");
        B2KMhB2.append(i);
        com.kwad.sdk.core.d.c.d("DownloadProgressTransformUtil", B2KMhB2.toString());
        double d = j2 > 0 ? (j * 100.0d) / j2 : 0.0d;
        if (!z) {
            return (int) d;
        }
        if (i == 1) {
            d = p(d);
        } else if (i == 2) {
            d = q(d);
        }
        return (int) d;
    }

    private static double p(double d) {
        if (d <= 6.0d) {
            return d * 5.0d;
        }
        if (d <= 15.0d) {
            return ((d - 6.0d) * 2.0d) + 30.0d;
        }
        if (d <= 30.0d) {
            return d + 33.0d;
        }
        if (d < 100.0d) {
            return Math.min((((d - 30.0d) * 0.37d) / 0.7d) + 63.0d, 99.0d);
        }
        return 100.0d;
    }

    private static double q(double d) {
        return Math.sqrt(d) * 10.0d;
    }
}
