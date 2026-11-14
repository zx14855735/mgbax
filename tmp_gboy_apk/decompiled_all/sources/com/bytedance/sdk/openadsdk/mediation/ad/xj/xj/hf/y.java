package com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.hf;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements Function<SparseArray<Object>, Object> {
    private final MediationExpressRenderListener xj;

    public y(MediationExpressRenderListener mediationExpressRenderListener) {
        this.xj = mediationExpressRenderListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 142101:
                    this.xj.onRenderSuccess((View) AMqCpz.objectValue(0, View.class), AMqCpz.floatValue(1, 0.0f), AMqCpz.floatValue(2, 0.0f), AMqCpz.booleanValue(3, false));
                    break;
                case 142102:
                    this.xj.onRenderFail((View) AMqCpz.objectValue(0, View.class), AMqCpz.stringValue(1, null), AMqCpz.intValue(2, 0));
                    break;
                case 142103:
                    this.xj.onAdClick();
                    break;
                case 142104:
                    this.xj.onAdShow();
                    break;
            }
        }
        return null;
    }
}
