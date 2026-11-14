package com.ss.android.downloadlib.addownload.u;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.qt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd implements c {
    @Override // com.ss.android.downloadlib.addownload.u.c
    public boolean xj(com.ss.android.downloadad.api.xj.hf hfVar, int i, f fVar, com.ss.android.downloadlib.addownload.xj.w wVar) {
        if (hfVar == null) {
            return false;
        }
        return qt.xj(hfVar, !TextUtils.isEmpty(hfVar.gy()) ? com.ss.android.downloadlib.tf.xj(com.ss.android.downloadlib.addownload.pl.getContext()).xj(hfVar.gy(), null, true) : com.ss.android.downloadlib.tf.xj(com.ss.android.downloadlib.addownload.pl.getContext()).hf(hfVar.xj()), i, fVar, true, wVar);
    }
}
