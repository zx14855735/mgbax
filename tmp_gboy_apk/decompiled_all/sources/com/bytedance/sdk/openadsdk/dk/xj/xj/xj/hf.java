package com.bytedance.sdk.openadsdk.dk.xj.xj.xj;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final TTNativeAd.EasyPlayWidgetListener xj;

    public hf(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        this.xj = easyPlayWidgetListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 144101:
                    this.xj.onInfo((JSONObject) AMqCpz.objectValue(0, JSONObject.class));
                    break;
                case 144103:
                    this.xj.onCanRenderSuccess((JSONObject) AMqCpz.objectValue(0, JSONObject.class));
                    break;
                case 144104:
                    this.xj.onCanRenderFail((JSONObject) AMqCpz.objectValue(0, JSONObject.class));
                    break;
                case 144105:
                    this.xj.onClose();
                    break;
            }
        }
        return null;
    }
}
