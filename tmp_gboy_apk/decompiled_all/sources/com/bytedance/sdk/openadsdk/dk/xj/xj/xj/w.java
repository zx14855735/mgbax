package com.bytedance.sdk.openadsdk.dk.xj.xj.xj;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Function<SparseArray<Object>, Object> {
    private final TTNativeAd.ExpressRenderListener xj;

    public w(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.xj = expressRenderListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            if (AMqCpz.intValue(-99999987, 0) == 142101) {
                this.xj.onRenderSuccess((View) AMqCpz.objectValue(0, View.class), AMqCpz.floatValue(1, 0.0f), AMqCpz.floatValue(2, 0.0f), AMqCpz.booleanValue(3, false));
                return null;
            }
        }
        return null;
    }
}
