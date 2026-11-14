package com.ss.android.downloadlib.addownload.hf;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    public String c;
    public String d;
    public final List<Pair<String, String>> f = new ArrayList();
    public long hf;
    public String kd;
    public String u;
    public String w;
    public long xj;
    public String y;

    public static long xj(long j, long j2) {
        return j > 0 ? j : j2;
    }

    public long xj() {
        return xj(this.xj, this.hf);
    }
}
