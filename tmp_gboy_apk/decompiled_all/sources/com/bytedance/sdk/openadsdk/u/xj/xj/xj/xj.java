package com.bytedance.sdk.openadsdk.u.xj.xj.xj;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final CSJSplashAd.SplashAdListener xj;

    public xj(CSJSplashAd.SplashAdListener splashAdListener) {
        this.xj = splashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null && sparseArray != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 111101:
                    this.xj.onSplashAdShow(new com.bytedance.sdk.openadsdk.zg.xj.xj.hf(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
                case 111102:
                    this.xj.onSplashAdClick(new com.bytedance.sdk.openadsdk.zg.xj.xj.hf(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    return null;
                case 111103:
                    this.xj.onSplashAdClose(new com.bytedance.sdk.openadsdk.zg.xj.xj.hf(qt.xj(AMqCpz.objectValue(0, Object.class))), AMqCpz.intValue(1, 0));
                    return null;
            }
        }
        return null;
    }
}
