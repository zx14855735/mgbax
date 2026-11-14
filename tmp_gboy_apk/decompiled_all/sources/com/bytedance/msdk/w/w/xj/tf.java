package com.bytedance.msdk.w.w.xj;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.f.q;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf extends hf {
    private final List<com.bytedance.msdk.core.tf.tf> c;
    private final HashSet<String> f = new HashSet<>();
    private final com.bytedance.msdk.w.y.xj.hf kd;
    private final com.bytedance.msdk.core.tf.hf y;

    public tf(com.bytedance.msdk.w.y.xj.hf hfVar, com.bytedance.msdk.core.tf.hf hfVar2, List<com.bytedance.msdk.core.tf.tf> list) {
        this.kd = hfVar;
        this.y = hfVar2;
        this.c = list;
    }

    private com.bytedance.msdk.core.tf.tf y() {
        List<com.bytedance.msdk.core.tf.tf> list = this.c;
        if (list == null) {
            return null;
        }
        for (com.bytedance.msdk.core.tf.tf tfVar : list) {
            if (tfVar != null) {
                if (!this.f.contains(tfVar.yo())) {
                    return tfVar;
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.w.w.xj.hf
    public boolean hf(com.bytedance.msdk.core.tf.tf tfVar, int i) {
        com.bytedance.msdk.core.tf.tf y;
        if (i == 1) {
            com.bytedance.msdk.core.tf.tf y2 = y();
            if (y2 != null && tfVar != null && TextUtils.equals(y2.yo(), tfVar.yo())) {
                w();
                return true;
            }
        } else if (i == 2) {
            if (tfVar != null) {
                this.f.add(tfVar.yo());
                CopyOnWriteArrayList<com.bytedance.msdk.hf.w> f = this.kd.f();
                com.bytedance.msdk.hf.w wVar = (f == null || f.size() <= 0) ? null : f.get(0);
                if (wVar != null && (y = y()) != null && TextUtils.equals(y.yo(), wVar.cy())) {
                    w();
                    return true;
                }
            }
            if (this.hf.f()) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "全部广告完成响应...");
                if (q.xj(this.kd.f())) {
                    xj(new com.bytedance.msdk.api.xj(20005, com.bytedance.msdk.api.xj.xj(20005)));
                }
                return true;
            }
        } else if (this.hf.kd()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.hf.kd() + "  allWtfFinish:" + this.hf.f());
            if (q.xj(this.kd.f())) {
                xj(new com.bytedance.msdk.api.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB, com.bytedance.msdk.api.xj.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB)));
            } else {
                w();
            }
            return true;
        }
        return false;
    }
}
