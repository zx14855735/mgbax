package com.bytedance.sdk.openadsdk.mediation.hf.xj.hf;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private final IMediationDrawAdTokenCallback xj;

    public xj(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.xj = iMediationDrawAdTokenCallback;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            int intValue = AMqCpz.intValue(-99999987, 0);
            AMqCpz.objectValue(-99999985, Class.class);
            switch (intValue) {
                case 270029:
                    this.xj.onAdTokenLoaded(AMqCpz.stringValue(0, null), new com.bytedance.sdk.openadsdk.mediation.hf.xj.xj.xj(qt.xj(AMqCpz.objectValue(1, Object.class))));
                    break;
                case 270030:
                    this.xj.onAdTokenLoadedFail(AMqCpz.intValue(0, 0), AMqCpz.stringValue(1, null));
                    break;
            }
        }
        return null;
    }
}
