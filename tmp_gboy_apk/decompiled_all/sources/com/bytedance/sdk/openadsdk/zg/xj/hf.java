package com.bytedance.sdk.openadsdk.zg.xj;

import IzHBwY.ADYaiT;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.CSJSplashAdListener xj;

    public hf(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.xj = cSJSplashAdListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 114102:
                    this.xj.onSplashLoadSuccess(new com.bytedance.sdk.openadsdk.zg.xj.xj.hf(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
                case 114103:
                    this.xj.onSplashLoadFail(new com.bytedance.sdk.openadsdk.zg.xj.xj.xj(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
                case 114104:
                    this.xj.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.zg.xj.xj.hf(AaHO0E.AYUAbz(AMqCpz.objectValue(0, AaHO0E.ARc23Z()))));
                    break;
                case 114105:
                    this.xj.onSplashRenderFail(new com.bytedance.sdk.openadsdk.zg.xj.xj.hf(qt.xj(AMqCpz.objectValue(0, Object.class))), new com.bytedance.sdk.openadsdk.zg.xj.xj.xj(qt.xj(AMqCpz.objectValue(1, Object.class))));
                    break;
            }
        }
        return null;
    }
}
