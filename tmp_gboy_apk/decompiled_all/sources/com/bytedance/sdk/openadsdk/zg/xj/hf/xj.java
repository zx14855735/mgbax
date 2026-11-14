package com.bytedance.sdk.openadsdk.zg.xj.hf;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final ExitInstallListener xj;

    public xj(ExitInstallListener exitInstallListener) {
        this.xj = exitInstallListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj == null || new ARc23Z(sparseArray).A2egSU().intValue(-99999987, 0) != 223101) {
            return null;
        }
        this.xj.onExitInstall();
        return null;
    }
}
