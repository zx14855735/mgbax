package com.ss.android.socialbase.downloader.y;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class qt {
    public static long hf(List<d> list) {
        long j;
        long j2;
        long j3 = 0;
        loop0: while (true) {
            j = -1;
            j2 = -1;
            for (d dVar : list) {
                if (j == -1) {
                    if (dVar.xj() > 0) {
                        j = dVar.w();
                        j2 = dVar.u();
                    }
                } else if (dVar.w() > j2) {
                    j3 += j2 - j;
                    if (dVar.xj() > 0) {
                        j = dVar.w();
                        j2 = dVar.u();
                    }
                } else if (dVar.u() > j2) {
                    j2 = dVar.u();
                }
            }
        }
        return (j < 0 || j2 <= j) ? j3 : (j2 - j) + j3;
    }

    public static long xj(List<d> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            d dVar = list.get(i);
            if (dVar.w() > j) {
                break;
            }
            if (dVar.kd() > j) {
                j = dVar.kd();
            }
        }
        return j;
    }
}
