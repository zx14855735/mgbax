package com.bytedance.sdk.openadsdk.zg.xj.hf;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Function<SparseArray<Object>, Object> {
    private final TTAppDownloadListener xj;

    public w(TTAppDownloadListener tTAppDownloadListener) {
        this.xj = tTAppDownloadListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 221101:
                    this.xj.onIdle();
                    break;
                case 221102:
                    this.xj.onDownloadActive(AMqCpz.longValue(0, 0L), AMqCpz.longValue(1, 0L), AMqCpz.stringValue(2, null), AMqCpz.stringValue(3, null));
                    break;
                case 221103:
                    this.xj.onDownloadPaused(AMqCpz.longValue(0, 0L), AMqCpz.longValue(1, 0L), AMqCpz.stringValue(2, null), AMqCpz.stringValue(3, null));
                    break;
                case 221104:
                    this.xj.onDownloadFailed(AMqCpz.longValue(0, 0L), AMqCpz.longValue(1, 0L), AMqCpz.stringValue(2, null), AMqCpz.stringValue(3, null));
                    break;
                case 221105:
                    this.xj.onDownloadFinished(AMqCpz.longValue(0, 0L), AMqCpz.stringValue(1, null), AMqCpz.stringValue(2, null));
                    break;
                case 221106:
                    this.xj.onInstalled(AMqCpz.stringValue(0, null), AMqCpz.stringValue(1, null));
                    break;
            }
        }
        return null;
    }
}
