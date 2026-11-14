package com.bytedance.sdk.openadsdk.ht.xj.xj.hf;

import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.zg.xj.xj.d;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final TTFeedAd.VideoAdListener hf;
    private ValueSet xj = ARc23Z.f4110A4TApA;

    public xj(TTFeedAd.VideoAdListener videoAdListener) {
        this.hf = videoAdListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.hf != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 161101:
                    this.hf.onVideoLoad(new d(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
                case 161102:
                    this.hf.onVideoError(AMqCpz.intValue(0, 0), AMqCpz.intValue(1, 0));
                    break;
                case 161103:
                    this.hf.onVideoAdPaused(new d(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
                case 161104:
                    this.hf.onVideoAdStartPlay(new d(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
                case 161105:
                    this.hf.onVideoAdContinuePlay(new d(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
                case 161106:
                    this.hf.onProgressUpdate(AMqCpz.longValue(0, 0L), AMqCpz.longValue(1, 0L));
                    break;
                case 161107:
                    this.hf.onVideoAdComplete(new d(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    break;
            }
        }
        return null;
    }
}
