package com.bytedance.sdk.openadsdk.ra.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener hf;
    private ValueSet xj = ARc23Z.f4110A4TApA;

    public xj(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.hf = fullScreenVideoAdInteractionListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.hf != null) {
            switch (new ARc23Z(sparseArray).A2egSU().intValue(-99999987, 0)) {
                case 131101:
                    this.hf.onAdShow();
                    break;
                case 131102:
                    this.hf.onAdVideoBarClick();
                    break;
                case 131103:
                    this.hf.onAdClose();
                    break;
                case 131104:
                    this.hf.onVideoComplete();
                    break;
                case 131105:
                    this.hf.onSkippedVideo();
                    break;
            }
        }
        return null;
    }
}
