package com.bytedance.sdk.openadsdk.jk.xj.xj.xj;

import IzHBwY.ADYaiT;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.zg.xj.xj.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.FeedAdListener xj;

    public hf(TTAdNative.FeedAdListener feedAdListener) {
        this.xj = feedAdListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 164101:
                    this.xj.onError(AMqCpz.intValue(0, 0), AMqCpz.stringValue(1, null));
                    break;
                case 164102:
                    List list = (List) AMqCpz.objectValue(0, List.class);
                    if (list == null) {
                        list = new ArrayList(0);
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new d(AaHO0E.AYUAbz(it.next())));
                    }
                    this.xj.onFeedAdLoad(arrayList);
                    break;
            }
        }
        return null;
    }
}
