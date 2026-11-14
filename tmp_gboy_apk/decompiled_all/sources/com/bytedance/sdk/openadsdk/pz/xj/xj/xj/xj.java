package com.bytedance.sdk.openadsdk.pz.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final TTDrawFeedAd.DrawVideoListener xj;

    public xj(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.xj = drawVideoListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            switch (new ARc23Z(sparseArray).A2egSU().intValue(-99999987, 0)) {
                case 171101:
                    this.xj.onClick();
                    break;
                case 171102:
                    this.xj.onClickRetry();
                    break;
            }
        }
        return null;
    }
}
