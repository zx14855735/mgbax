package com.bytedance.sdk.openadsdk.u.xj.xj.xj;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final CSJSplashAd.SplashCardListener xj;

    public hf(CSJSplashAd.SplashCardListener splashCardListener) {
        this.xj = splashCardListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 112102:
                    this.xj.onSplashCardClick();
                    break;
                case 112103:
                    this.xj.onSplashCardClose();
                    break;
                case 121201:
                    this.xj.onSplashCardReadyToShow(new com.bytedance.sdk.openadsdk.zg.xj.xj.hf(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
            }
        }
        return null;
    }
}
