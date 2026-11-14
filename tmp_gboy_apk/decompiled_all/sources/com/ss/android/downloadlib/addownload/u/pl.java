package com.ss.android.downloadlib.addownload.u;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.qt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class pl implements d {
    @Override // com.ss.android.downloadlib.addownload.u.d
    public boolean xj(com.ss.android.downloadad.api.xj.hf hfVar, int i, f fVar) {
        if (hfVar == null) {
            return false;
        }
        return qt.xj(hfVar, !TextUtils.isEmpty(hfVar.gy()) ? com.ss.android.downloadlib.tf.xj((Context) null).xj(hfVar.gy(), null, true) : com.ss.android.downloadlib.tf.xj((Context) null).hf(hfVar.xj()), i, fVar, false, null);
    }
}
