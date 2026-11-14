package com.bytedance.adsdk.xj.xj;

import com.bytedance.adsdk.xj.xj.xj.d;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends w<com.bytedance.adsdk.xj.xj.xj.hf> {
    public xj(com.bytedance.adsdk.xj.xj.w.hf hfVar) {
        super(hfVar);
    }

    @Override // com.bytedance.adsdk.xj.xj.w
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.xj.xj.xj.hf hf(com.bytedance.adsdk.xj.xj.w.hf hfVar, d.xj xjVar) {
        return new com.bytedance.adsdk.xj.xj.xj.hf(hfVar, xjVar);
    }

    public static xj xj(final ByteBuffer byteBuffer) {
        return new xj(new com.bytedance.adsdk.xj.xj.w.xj() { // from class: com.bytedance.adsdk.xj.xj.xj.1
            @Override // com.bytedance.adsdk.xj.xj.w.xj
            public ByteBuffer xj() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
    }
}
