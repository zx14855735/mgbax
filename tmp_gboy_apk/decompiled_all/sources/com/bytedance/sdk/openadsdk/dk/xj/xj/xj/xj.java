package com.bytedance.sdk.openadsdk.dk.xj.xj.xj;

import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.zg.xj.xj.pl;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final TTNativeAd.AdInteractionListener hf;
    private final ValueSet xj = ARc23Z.f4110A4TApA;

    public xj(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.hf = adInteractionListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.hf != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 141101:
                    this.hf.onAdClicked((View) AMqCpz.objectValue(0, View.class), new pl(qt.xj(AMqCpz.objectValue(1, Object.class))));
                    break;
                case 141102:
                    this.hf.onAdCreativeClick((View) AMqCpz.objectValue(0, View.class), new pl(qt.xj(AMqCpz.objectValue(1, Object.class))));
                    break;
                case 141103:
                    this.hf.onAdShow(new pl(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
            }
        }
        return null;
    }
}
