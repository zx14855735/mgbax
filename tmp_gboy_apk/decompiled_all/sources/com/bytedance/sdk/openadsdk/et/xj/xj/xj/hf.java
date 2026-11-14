package com.bytedance.sdk.openadsdk.et.xj.xj.xj;

import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final TTNativeExpressAd.ExpressAdInteractionListener hf;
    private final ValueSet xj = ARc23Z.f4110A4TApA;

    public hf(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.hf = expressAdInteractionListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.hf != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 151101:
                    this.hf.onAdClicked((View) AMqCpz.objectValue(0, View.class), AMqCpz.intValue(1, 0));
                    break;
                case 151102:
                    this.hf.onAdShow((View) AMqCpz.objectValue(0, View.class), AMqCpz.intValue(1, 0));
                    break;
                case 151103:
                    this.hf.onRenderFail((View) AMqCpz.objectValue(0, View.class), AMqCpz.stringValue(1, null), AMqCpz.intValue(2, 0));
                    break;
                case 151104:
                    this.hf.onRenderSuccess((View) AMqCpz.objectValue(0, View.class), AMqCpz.floatValue(1, 0.0f), AMqCpz.floatValue(2, 0.0f));
                    break;
            }
        }
        return null;
    }
}
