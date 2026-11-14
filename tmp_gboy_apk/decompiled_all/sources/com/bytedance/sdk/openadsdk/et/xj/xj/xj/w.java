package com.bytedance.sdk.openadsdk.et.xj.xj.xj;

import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Function<SparseArray<Object>, Object> {
    private final TTNativeExpressAd.ExpressVideoAdListener hf;
    private final ValueSet xj = ARc23Z.f4110A4TApA;

    public w(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.hf = expressVideoAdListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.hf != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 152101:
                    this.hf.onVideoLoad();
                    break;
                case 152102:
                    this.hf.onVideoError(AMqCpz.intValue(0, 0), AMqCpz.intValue(1, 0));
                    break;
                case 152103:
                    this.hf.onVideoAdStartPlay();
                    break;
                case 152104:
                    this.hf.onVideoAdPaused();
                    break;
                case 152105:
                    this.hf.onVideoAdContinuePlay();
                    break;
                case 152106:
                    this.hf.onProgressUpdate(AMqCpz.longValue(0, 0L), AMqCpz.longValue(1, 0L));
                    break;
                case 152107:
                    this.hf.onVideoAdComplete();
                    break;
                case 152108:
                    this.hf.onClickRetry();
                    break;
            }
        }
        return null;
    }
}
