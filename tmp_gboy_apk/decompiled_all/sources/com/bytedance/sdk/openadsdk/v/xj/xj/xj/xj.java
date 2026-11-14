package com.bytedance.sdk.openadsdk.v.xj.xj.xj;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final TTAdDislike.DislikeInteractionCallback xj;

    public xj(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.xj = dislikeInteractionCallback;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 244101:
                    this.xj.onShow();
                    break;
                case 244102:
                    this.xj.onSelected(AMqCpz.intValue(0, 0), AMqCpz.stringValue(1, null), AMqCpz.booleanValue(2, false));
                    break;
                case 244103:
                    this.xj.onCancel();
                    break;
            }
        }
        return null;
    }
}
