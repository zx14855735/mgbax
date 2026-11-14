package com.bytedance.sdk.openadsdk.jk.xj.xj.xj;

import IzHBwY.ADYaiT;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.zg.xj.xj.tf;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.FullScreenVideoAdListener xj;

    public w(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.xj = fullScreenVideoAdListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 132101:
                    this.xj.onError(AMqCpz.intValue(0, 0), AMqCpz.stringValue(1, null));
                    break;
                case 132102:
                    this.xj.onFullScreenVideoAdLoad(new tf(AaHO0E.AYUAbz(AMqCpz.objectValue(0, AaHO0E.ARc23Z()))));
                    break;
                case 132103:
                    this.xj.onFullScreenVideoCached(new tf(AaHO0E.AYUAbz(AMqCpz.objectValue(0, AaHO0E.ARc23Z()))));
                    break;
                case 132104:
                    this.xj.onFullScreenVideoCached();
                    break;
            }
        }
        return null;
    }
}
